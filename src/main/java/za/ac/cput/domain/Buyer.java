package za.ac.cput.domain;

import jakarta.persistence.Id;

import java.util.Objects;

public class Buyer {
    @Id
    private String buyerId;
    private String name;
    private String email;
    private String phoneNumber;

    protected Buyer() {
    }

    private Buyer(Builder builder) {
        this.buyerId = builder.buyerId;
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    public String getBuyerId() {
        return buyerId;
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
        if (!(o instanceof Buyer)) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(getBuyerId(), buyer.getBuyerId()) &&
                Objects.equals(getName(), buyer.getName()) &&
                Objects.equals(getEmail(), buyer.getEmail()) &&
                Objects.equals(getPhoneNumber(), buyer.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuyerId(), getName(), getEmail(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyerId='" + buyerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String buyerId;
        private String name;
        private String email;
        private String phoneNumber;

        public Builder setBuyerId(String buyerId) {
            this.buyerId = buyerId;
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

        public Builder copy(Buyer buyer) {
            this.buyerId = buyer.buyerId;
            this.name = buyer.name;
            this.email = buyer.email;
            this.phoneNumber = buyer.phoneNumber;
            return this;
        }

        public Buyer build() {
            return new Buyer(this);
        }
    }
}