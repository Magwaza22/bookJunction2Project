package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Buyer;
import za.ac.cput.repository.BuyerRepository;

import java.util.List;

@Service
public class BuyerService implements IBuyerService {
    private BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public Buyer create(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer read(String id) {
        return buyerRepository.findById(id).orElse(null);
    }

    @Override
    public Buyer update(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public void delete(String buyerId) {
        buyerRepository.deleteById(buyerId);
    }

    @Override
    public List<Buyer> getAll() {
        return buyerRepository.findAll();
    }

}
