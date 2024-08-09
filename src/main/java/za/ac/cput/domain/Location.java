package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Location {
    @Id
    private String address;
    private String contactInformation;
    private String operatingHours;
    private String city;

    protected Location() {
    }

    private Location(Builder builder) {
        this.address = builder.address;
        this.contactInformation = builder.contactInformation;
        this.operatingHours = builder.operatingHours;
        this.city = builder.city;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location that = (Location) o;
        return Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getContactInformation(), that.getContactInformation()) &&
                Objects.equals(getOperatingHours(), that.getOperatingHours()) &&
                Objects.equals(getCity(), that.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getContactInformation(), getOperatingHours(), getCity());
    }

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                ", operatingHours='" + operatingHours + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static class Builder {
        private String address;
        private String contactInformation;
        private String operatingHours;
        private String city;

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setContactInformation(String contactInformation) {
            this.contactInformation = contactInformation;
            return this;
        }

        public Builder setOperatingHours(String operatingHours) {
            this.operatingHours = operatingHours;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder copy(Location location) {
            this.address = location.address;
            this.contactInformation = location.contactInformation;
            this.operatingHours = location.operatingHours;
            this.city = location.city;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}

