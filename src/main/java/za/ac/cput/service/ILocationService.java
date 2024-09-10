package za.ac.cput.service;

import za.ac.cput.domain.Location;

import java.util.List;

public interface ILocationService extends IService<Location, String> {
    Location read(Long id);
    List<Location> getAll();
    List<Location> getall();
    void delete(Long id); // Add this line
}
