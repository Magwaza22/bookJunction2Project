package za.ac.cput.domain;


import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

import javax.sql.RowSet;
import java.util.Objects;
@Entity
public class Admin {
  @Id
  private Long adminID;
  private String name;
  private String email;
  private String password;
  private String phoneNumber;
  @jakarta.persistence.Id
  private Long id;

  // Default constructor
  public Admin() {}

  // Parameterized constructor
  public Admin(Long adminID, String name, String email, String password, String phoneNumber) {
    this.adminID = adminID;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
  }

  // Copy constructor
  public Admin(Admin other) {
    this.adminID = other.adminID;
    this.name = other.name;
    this.email = other.email;
    this.password = other.password;
    this.phoneNumber = other.phoneNumber;
  }

  // Getters
  public Long getAdminID() {
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

  // Setters
  public void setAdminID(Long adminID) {
    this.adminID = adminID;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  // equals method
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Admin)) return false;
    Admin admin = (Admin) o;
    return Objects.equals(getAdminID(), admin.getAdminID()) &&
            Objects.equals(getName(), admin.getName()) &&
            Objects.equals(getEmail(), admin.getEmail()) &&
            Objects.equals(getPassword(), admin.getPassword()) &&
            Objects.equals(getPhoneNumber(), admin.getPhoneNumber());
  }

  // hashCode method
  @Override
  public int hashCode() {
    return Objects.hash(getAdminID(), getName(), getEmail(), getPassword(), getPhoneNumber());
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

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  // Builder pattern implementation
  public static class Builder {
    private Long adminID;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    public Builder setAdminID(Long adminID) {
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

    public Admin build() {
      return new Admin(adminID, name, email, password, phoneNumber);
    }


  }
}
