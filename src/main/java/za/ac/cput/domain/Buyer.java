package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Objects;
import java.util.Set;

@Entity
public class Buyer extends User {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    private Set<TransactionHistory> buyingHistory;

    protected Buyer() {
    }

    public Buyer(Builder builder) {
        this.buyingHistory = builder.buyingHistory;
    }

    public Set<TransactionHistory> getBuyingHistory() {
        return buyingHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(buyingHistory, buyer.buyingHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), buyingHistory);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyingHistory=" + buyingHistory +
                '}';
    }

    public static class Builder {
        private Set<TransactionHistory> buyingHistory;

        public Builder setBuyingHistory(Set<TransactionHistory> buyingHistory) {
            this.buyingHistory = buyingHistory;
            return this;
        }

        public Builder copy(Buyer buyer) {
            this.buyingHistory = buyer.buyingHistory;
            return this;
        }

        public Buyer build() {
            return new Buyer(this);
        }
    }

}