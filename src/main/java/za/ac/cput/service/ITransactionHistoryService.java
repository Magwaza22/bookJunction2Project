package za.ac.cput.service;

import za.ac.cput.domain.TransactionHistory;

import java.util.List;

public interface ITransactionHistoryService extends IService<TransactionHistory, Integer> {
    List<TransactionHistory> getall();
}
