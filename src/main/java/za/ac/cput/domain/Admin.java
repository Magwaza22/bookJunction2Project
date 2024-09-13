package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Admin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer adminID;
  private String name;
  private String email;
  private String password;
  private String phoneNumber;

  protected Admin() {}

  public Admin(Builder builder) {
    this.adminID = builder.adminID;
    this.name = builder.name;
    this.email = builder.email;
    this.password = builder.password;
    this.phoneNumber = builder.phoneNumber;
  }

  // Getters
  public Integer getAdminID() {
    return adminID;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Admin admin = (Admin) o;
    return Objects.equals(adminID, admin.adminID) &&
            Objects.equals(name, admin.name) &&
            Objects.equals(email, admin.email) &&
            Objects.equals(password, admin.password) &&
            Objects.equals(phoneNumber, admin.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adminID, name, email, password, phoneNumber);
  }

  // toString method
  @Override
  public String toString() {
    return "Admin{" +
            "adminID=" + adminID +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            '}';
  }

  // Builder pattern implementation
  public static class Builder {
    private Integer adminID;  // Change from Long to Integer
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    public Builder setAdminID(Integer adminID) {
      this.adminID = adminID;
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

    public Builder setPassword(String password) {
      this.password = password;
      return this;
    }

    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public Builder copy(Admin admin) {
      this.adminID = admin.adminID;
      this.name = admin.name;
      this.email = admin.email;
      this.password = admin.password;
      this.phoneNumber = admin.phoneNumber;
      return this;
    }

    public Admin build() {
      return new Admin(this);
    }
  }
}