package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Buyer;
import za.ac.cput.repository.BuyerRepository;

import java.util.List;

@Service
public class BuyerService implements IBuyerService {
    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public Buyer create(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer read(Integer buyerID) {
        return buyerRepository.findById(Integer.valueOf(String.valueOf(buyerID))).orElse(null);
    }

    @Override
    public Buyer update(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public List<Buyer> getAll() {
        return buyerRepository.findAll();
    }

    @Override
    public void delete(Integer buyerID) {
        buyerRepository.deleteById(Integer.valueOf(String.valueOf(buyerID)));
    }
}