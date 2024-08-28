package za.ac.cput.service;

import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    public List<TransactionHistory> getAllTransactions() {
        return transactionHistoryRepository.findAll();
    }

    public TransactionHistory getTransactionById(int id) {
        return transactionHistoryRepository.findById(id).orElse(null);
    }

    public TransactionHistory createTransaction(TransactionHistory transactionHistory) {
        return transactionHistoryRepository.save(transactionHistory);
    }

    public TransactionHistory updateTransaction(int id, TransactionHistory transactionHistory) {
        if (transactionHistoryRepository.existsById(id)) {
            transactionHistory.setTransaction_id(id);
            return transactionHistoryRepository.save(transactionHistory);
        }
        return null;
    }

    public boolean deleteTransaction(int id) {
        if (transactionHistoryRepository.existsById(id)) {
            transactionHistoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}