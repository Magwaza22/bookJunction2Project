package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.Objects;
import java.util.Set;


@Entity
public class Seller extends User{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<TransactionHistory> inventory;

    public Seller() {
    }

    public Seller(Builder builder) {
        super(builder.userId, builder.firstName, builder.lastName, builder.email, builder.phoneNumber, builder.password);  // Call User constructor
        this.inventory = builder.inventory;
    }

    public Set<TransactionHistory> getInventory() {
        return inventory;
    }

    public void setInventory(Set<TransactionHistory> inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Seller seller = (Seller) o;
        return Objects.equals(inventory, seller.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inventory);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "inventory=" + inventory +
                '}';
    }

    public static class Builder {
        // User fields inherited from User class
        private Integer userId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String password;

        // Seller-specific field
        private Set<TransactionHistory> inventory;

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

        // Builder method for Seller's inventory
        public Builder setInventory(Set<TransactionHistory> inventory) {
            this.inventory = inventory;
            return this;
        }

        // Copy method for building Seller object from User instance
        public Builder copy(User user) {
            this.userId = user.getUserId();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.email = user.getEmail();
            this.phoneNumber = user.getPhoneNumber();
            this.password = user.getPassword();

            if (user instanceof Seller) {
                this.inventory = ((Seller) user).inventory;
            }
            return this;
        }

        // Build method for creating a Seller instance
        public Seller build() {
            return new Seller(this);
        }
    }
}