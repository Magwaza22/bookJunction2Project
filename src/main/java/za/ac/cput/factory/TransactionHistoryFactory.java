package za.ac.cput.factory;

import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class TransactionHistoryFactory {
    public static TransactionHistory createTransactionHistory(int transaction_id, int book_id, int user_id_seller, int user_id_buyer, Double price, LocalDate date) {
        if (Helper.isNullOrEmpty(String.valueOf(transaction_id)) || Helper.isNullOrEmpty(String.valueOf(book_id)) || Helper.isNullOrEmpty(String.valueOf(user_id_seller)) || Helper.isNullOrEmpty(String.valueOf(date))
                || Helper.isNullOrEmpty(String.valueOf(price)))
            return null;

        return new TransactionHistory.Builder().setTransaction_id(transaction_id)
                .setBook_id(book_id)
                .setUser_id_seller(user_id_seller)
                .setUser_id_buyer(user_id_buyer)
                .setPrice(price)
                .setDate(date)
                .build();
    }
}
