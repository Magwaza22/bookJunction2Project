package za.ac.cput.service;

import za.ac.cput.domain.Seller;
import za.ac.cput.domain.TransactionHistory;

import java.util.List;
import java.util.Set;

public interface ISellerService extends IService<Seller, Long>{

    void delete(Long sellerId);

    List<Seller> getAll();

    Seller createSeller(Set<TransactionHistory> inventory);

    Seller getSellerById(Long sellerId);

    Set<Seller> getAllSellers();

    void updateSeller(Seller seller);

    void deleteSeller(Long sellerId);
}