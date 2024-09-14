package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Buyer extends User {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer", fetch = FetchType.EAGER)
    private Set<TransactionHistory> buyingHistory;

    public Buyer() {
    }

    public Buyer(Builder builder) {
        super(builder);
        this.buyingHistory = builder.buyingHistory;
    }

    public Set<TransactionHistory> getBuyingHistory() {
        return buyingHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buyer buyer)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getUserId(), buyer.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUserId());
    }
    @Override
    public String toString() {
        return "Buyer{" +
                "buyingHistory=" + buyingHistory +
                '}';
    }

    public static class Builder extends UserBuilder {
        private Set<TransactionHistory> buyingHistory;

        public Builder setBuyingHistory(Set<TransactionHistory> buyingHistory) {
            this.buyingHistory = buyingHistory;
            return this;
        }

        public Builder copy(User user) {
            if (user instanceof Buyer) {
                super.copy(user);
                this.buyingHistory = ((Buyer) user).buyingHistory;
            }
            return this;
        }

        public Buyer build() {
            return new Buyer(this);
        }
    }
}