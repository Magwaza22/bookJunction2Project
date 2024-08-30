package za.ac.cput.service;

import za.ac.cput.domain.Appointment;

import java.util.List;

public interface IAppointmentService extends IService<Appointment, String> {

    Appointment read(Long appointmentId);

    void delete(Long id);

    List<Appointment> getall();
}
