
package za.ac.cput.factory;

import za.ac.cput.domain.Buyer;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.util.Helper;

import java.util.Set;

public class BuyerFactory {
    public static Buyer createBuyer(Set<TransactionHistory> buyingHistory) {
        if (buyingHistory == null || buyingHistory.isEmpty()) {
            return null;
        }

        return new Buyer.Builder()
                .setBuyingHistory(buyingHistory)
                .build();
    }

    public static Buyer buildBuyer(Set<TransactionHistory> buyingHistory) {
        throw new UnsupportedOperationException();
    }
}