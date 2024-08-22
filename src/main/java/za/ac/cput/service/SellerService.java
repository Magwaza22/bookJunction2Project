package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Seller;
import za.ac.cput.repository.SellerRepository;

import java.util.List;

@Service
public class SellerService implements ISellerService {
    private SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Seller create(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller read(String id) {
        return sellerRepository.findById(id).orElse(null);
    }

    @Override
    public Seller update(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public boolean delete(String sellerId) {
        sellerRepository.deleteById(sellerId);
        return false;
    }

    @Override
    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }
}