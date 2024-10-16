package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.repository.TransactionHistoryRepository;

import java.util.List;

@Service
public class TransactionHistoryService implements ITransactionHistoryService{
    private final TransactionHistoryRepository transactionHistoryRepository;
    @Autowired
    TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository) {this.transactionHistoryRepository = transactionHistoryRepository;}

    @Override
    public TransactionHistory create(TransactionHistory transactionHistory) {
        return transactionHistoryRepository.save(transactionHistory);
    }

    @Override
    public TransactionHistory read(Integer integer) {return transactionHistoryRepository.findById(integer).orElse(null);}

    @Override
    public TransactionHistory update(TransactionHistory transactionHistory){return transactionHistoryRepository.save(transactionHistory);
    }
    @Override
    public List<TransactionHistory> getall() {
        return transactionHistoryRepository.findAll();
    }
    }




