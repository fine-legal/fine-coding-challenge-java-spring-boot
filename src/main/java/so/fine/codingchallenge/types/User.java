package so.fine.codingchallenge.types;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zipCode;
    private String phoneNumber;
    private String emailAddress;
    private String state;
    private String court;

    private static final Map<String, String> ZIP_TO_STATE = Map.of(
        "10001", "New York",
        "90001", "California", 
        "10437", "Berlin");

    public User(Lead lead){
        this.firstName = lead.getFirstName();
        this.lastName = lead.getLastName();
        this.address = lead.getAddress();
        this.city = lead.getCity();
        this.zipCode = lead.getZipCode();
        this.phoneNumber = lead.getPhoneNumber();
        this.emailAddress = lead.getEmailAddress();
        this.state = ZIP_TO_STATE.get(lead.getZipCode());
        this.court = "High Court";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }
}
