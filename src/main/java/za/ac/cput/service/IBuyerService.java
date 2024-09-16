package za.ac.cput.service;

import za.ac.cput.domain.Buyer;

import java.util.List;

public interface IBuyerService extends IService<Buyer, Integer> {
    Buyer create(Buyer buyer);
    Buyer read(Integer buyerID);
    Buyer update(Buyer buyer);
    List<Buyer> getAll();
    void delete(Integer buyerID);

}