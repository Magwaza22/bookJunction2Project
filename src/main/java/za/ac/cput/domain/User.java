package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

    @Id
    private String userId; // seller and buyer
    private String name;
    private String email;
    private String phoneNumber;

    public User() {
    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    public Long getUserId() {
        return Long.valueOf(userId);
    }

    public String getName(String janeDoe) {
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
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) &&
                Objects.equals(getName("Jane Doe"), user.getName("Jane Doe")) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPhoneNumber(), user.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName("Jane Doe"), getEmail(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String userId;
        private String name;
        private String email;
        private String phoneNumber;

        public Builder setUserId(String userId) {
            this.userId = userId;
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

        public Builder copy(User user) {
            this.userId = user.userId;
            this.name = user.name;
            this.email = user.email;
            this.phoneNumber = user.phoneNumber;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

