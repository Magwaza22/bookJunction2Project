package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.repository.TransactionHistoryRepository;

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
    public TransactionHistory read(Integer id) {
        return transactionHistoryRepository.findById(id).orElseThrow();
    }

    @Override
    public TransactionHistory update(TransactionHistory transactionHistory) {
        return transactionHistoryRepository.save(transactionHistory);
    }
}



