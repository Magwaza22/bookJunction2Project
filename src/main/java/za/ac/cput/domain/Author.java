package za.ac.cput.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Author implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String nationality;

    protected Author(){

    }

    public Author(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.nationality = builder.nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(getFirstName(), author.getFirstName()) && Objects.equals(getLastName(), author.getLastName()) && Objects.equals(getEmail(), author.getEmail()) && Objects.equals(getPhoneNumber(), author.getPhoneNumber()) && Objects.equals(getNationality(), author.getNationality());
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPhoneNumber(), getNationality());
//    }

//    @Override
//    public String toString() {
//        return "Author{" +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", nationality='" + nationality + '\'' +
//                '}';
//    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String nationality;


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

        public Builder setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Builder copy(Author a) {
            this.firstName = a.firstName;
            this.lastName = a.lastName;
            this.email = a.email;
            this.phoneNumber = a.phoneNumber;
            this.nationality = a.nationality;
            return this;
        }
        public Author build(){
            return new Author(this);
        }
    }
}
