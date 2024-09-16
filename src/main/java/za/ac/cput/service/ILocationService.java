package za.ac.cput.service;

import za.ac.cput.domain.Location;

import java.util.List;

public interface ILocationService extends IService<Location, Integer> {
    void delete(Integer id);
    List<Location> getAll();


}
