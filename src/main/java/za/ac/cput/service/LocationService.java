package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Location;
import za.ac.cput.repository.LocationRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LocationService implements ILocationService {

    private final LocationRepository repository;

    @Autowired
    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location create(Location location) {
        return repository.save(location);
    }

    @Override
    public Location read(Integer id) { // Changed from Long to Integer to match ID type
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Location not found with id: " + id));
    }

    @Override
    public Location update(Location location) {
        if (!repository.existsById(location.getId())) {
            throw new NoSuchElementException("Location not found with id: " + location.getId());
        }
        return repository.save(location);
    }

    @Override
    public List<Location> getAll() { // Standard method name
        return repository.findAll();
    }

    @Override
    public void delete(Integer id) { // Changed from Long to Integer to match ID type
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Location not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
