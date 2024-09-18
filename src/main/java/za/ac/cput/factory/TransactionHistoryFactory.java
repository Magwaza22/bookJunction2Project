package za.ac.cput.factory;

import za.ac.cput.domain.Book;
import za.ac.cput.domain.Buyer;
import za.ac.cput.domain.Seller;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class TransactionHistoryFactory {

    public static TransactionHistory createTransactionHistory(int transactionId, Book book, Buyer buyer, Seller seller, LocalDate date) {
        if (Helper.isNullOrEmpty(String.valueOf(transactionId))
                || Helper.isNullOrEmpty(String.valueOf(book))
                || Helper.isNullOrEmpty(String.valueOf(buyer))
                || Helper.isNullOrEmpty(String.valueOf(seller))
                || Helper.isNullOrEmpty(String.valueOf(date))) {
            return null;
        }

        return new TransactionHistory.Builder()
                .setTransactionID(transactionId)
                .setBook_id(book)
                .setBuyer(buyer)
                .setSeller(seller)
                .setDate(date)
                .build();
    }

}