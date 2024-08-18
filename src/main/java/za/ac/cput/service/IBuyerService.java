package za.ac.cput.service;

import za.ac.cput.domain.Buyer;

import java.util.List;

public interface IBuyerService extends IService<Buyer, String> {
    List<Buyer> getAll();

    void delete(String buyerId);
}