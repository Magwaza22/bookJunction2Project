package za.ac.cput.service;

import za.ac.cput.domain.Seller;

import java.util.List;

public interface ISellerService extends IService<Seller, String> {
    List<Seller> getAll();

    boolean delete(String sellerId);
}