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
        this.repository = repository; // Correctly assigning repository in constructor
    }

    @Override
    public Location create(Location location) {
        return repository.save(location);
    }

    @Override
    public Location read(String s) {
        return null;
    }

    @Override
    public Location read(Long id) { // Changed from String to Long
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
    public List<Location> getAll() { // Changed method name to match typical convention
        return repository.findAll();
    }

    @Override
    public List<Location> getall() {
        return getAll(); // Return the result from getAll()
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Location not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public Location saveLocation(Location location) {
        return location;
    }

    public Location getLocationById(Long locationId) {

        return null;
    }
        public void deleteLocation (Long locationId){
        }
    }

