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
        super(builder);
        this.inventory = builder.inventory;
    }

    public Set<TransactionHistory> getInventory() {
        return inventory;
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

    public static class Builder extends UserBuilder{
        private Set<TransactionHistory> inventory;

        public Builder setInventory(Set<TransactionHistory> inventory) {
            this.inventory = inventory;
            return this;
        }

        public Builder copy(User user){
            if(user instanceof Seller){
                super.copy(user);
                this.inventory = ((Seller) user).inventory;
            }
            return this;
        }

        public Seller build(){return new Seller(this);}
    }
}