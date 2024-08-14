package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class Seller {
    @Id
    private String sellerId;
    private String name;
    private String email;
    private String phoneNumber;

    protected Seller() {
    }

    private Seller(Builder builder) {
        this.sellerId = builder.sellerId;
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seller)) return false;
        Seller seller = (Seller) o;
        return Objects.equals(getSellerId(), seller.getSellerId()) &&
                Objects.equals(getName(), seller.getName()) &&
                Objects.equals(getEmail(), seller.getEmail()) &&
                Objects.equals(getPhoneNumber(), seller.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSellerId(), getName(), getEmail(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId='" + sellerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String sellerId;
        private String name;
        private String email;
        private String phoneNumber;

        public Builder setSellerId(String sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
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

        public Builder copy(Seller seller) {
            this.sellerId = seller.sellerId;
            this.name = seller.name;
            this.email = seller.email;
            this.phoneNumber = seller.phoneNumber;
            return this;
        }

        public Seller build() {
            return new Seller(this);
        }
    }
}