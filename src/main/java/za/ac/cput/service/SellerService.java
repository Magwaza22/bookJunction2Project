package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Seller;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.repository.SellerRepository;

import java.util.List;
import java.util.Set;

@Service
public class SellerService implements ISellerService {
    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Seller create(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller read(Long sellerId) {
        return sellerRepository.findById(String.valueOf(sellerId)).orElse(null);
    }

    @Override
    public Seller update(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public void delete(Long sellerId) {
        sellerRepository.deleteById(String.valueOf(sellerId));
    }

    @Override
    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller createSeller(Set<TransactionHistory> inventory) {
        return null;
    }

    @Override
    public Seller getSellerById(Long sellerId) {
        return null;
    }

    @Override
    public Set<Seller> getAllSellers() {
        return null;
    }

    @Override
    public void updateSeller(Seller seller) {

    }

    @Override
    public void deleteSeller(Long sellerId) {

    }
}