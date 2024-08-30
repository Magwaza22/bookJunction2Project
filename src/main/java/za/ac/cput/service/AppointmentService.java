package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Appointment;
import za.ac.cput.repository.AppointmentRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentService implements IAppointmentService {

    private final AppointmentRepository repository;

    @Autowired
    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public Appointment read(String s) {
        return null;
    }

    @Override
    public Appointment read(Long appointmentId) {
        return repository.findById(appointmentId)
                .orElseThrow(() -> new NoSuchElementException("Appointment not found with id: " + appointmentId));
    }

    @Override
    public Appointment update(Appointment appointment) {
        if (!repository.existsById(appointment.getAppointmentId())) {
            throw new NoSuchElementException("Appointment not found with id: " + appointment.getAppointmentId());
        }
        return repository.save(appointment);
    }

    @Override
    public void delete(Long appointmentId) {
        SimpleJpaRepository appointmentRepository = null;
        if (appointmentRepository.existsById(appointmentId)) {
            appointmentRepository.deleteById(appointmentId);
        } else {
            throw new NoSuchElementException("Appointment not found.");
        }
    }


    @Override
    public List<Appointment> getall() {
        return repository.findAll();
    }

    public List<Appointment> getAll() {
        return null;
    }
}