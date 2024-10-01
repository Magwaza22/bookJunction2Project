package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class TransactionHistoryFactory {

    public static TransactionHistory createTransactionHistory(int transactionID, Book book, User user, LocalDate date) {
        if (Helper.isNullOrEmpty(String.valueOf(transactionID))
                || Helper.isNullOrEmpty(String.valueOf(book))
                || Helper.isNullOrEmpty(String.valueOf(user))
                || Helper.isNullOrEmpty(String.valueOf(date))) {
            return null;
        }

        return new TransactionHistory.Builder()
                .setTransactionID(transactionID)
                .setBookID(book)
                .setUser(user)
                .setDate(date)
                .build();
    }
}