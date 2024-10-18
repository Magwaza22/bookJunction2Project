package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Buyer extends User {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<TransactionHistory> buyingHistory;

    // Default constructor
    public Buyer() {
    }

    // Builder-based constructor
    public Buyer(Builder builder) {
        super(builder.userId, builder.firstName, builder.lastName, builder.email, builder.phoneNumber, builder.password);  // Call to User constructor
        this.buyingHistory = builder.buyingHistory;
    }

    // Getter for buyingHistory
    public Set<TransactionHistory> getBuyingHistory() {
        return buyingHistory;
    }

    // Setter for buyingHistory (if needed)
    public void setBuyingHistory(Set<TransactionHistory> buyingHistory) {
        this.buyingHistory = buyingHistory;
    }

    // equals method for comparing Buyer objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buyer buyer)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getBuyingHistory(), buyer.getBuyingHistory());
    }

    // hashCode method to ensure consistent hashing
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBuyingHistory());
    }

    // toString method for representing Buyer as a string
    @Override
    public String toString() {
        return "Buyer{" +
                "buyingHistory=" + buyingHistory +
                '}';
    }

    // Builder class for Buyer
    public static class Builder {
        // User fields inherited from User class
        private Integer userId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String password;

        // Buyer-specific field
        private Set<TransactionHistory> buyingHistory;

        // Builder methods for User fields
        public Builder setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        // Builder method for Buyer's buyingHistory
        public Builder setBuyingHistory(Set<TransactionHistory> buyingHistory) {
            this.buyingHistory = buyingHistory;
            return this;
        }

        // Copy method to copy fields from User (or Buyer) instance
        public Builder copy(User user) {
            this.userId = user.getUserId();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.email = user.getEmail();
            this.phoneNumber = user.getPhoneNumber();
            this.password = user.getPassword();

            if (user instanceof Buyer) {
                this.buyingHistory = ((Buyer) user).buyingHistory;
            }
            return this;
        }

        // Build method to create a new Buyer instance
        public Buyer build() {
            return new Buyer(this);
        }
    }
}