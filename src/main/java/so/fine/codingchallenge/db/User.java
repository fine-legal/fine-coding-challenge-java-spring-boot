package so.fine.codingchallenge.db;

import jakarta.persistence.*;

import java.util.List;


@Entity
// The word "USER" is reserved in H2
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;

    private String lastname;

    private String address;

    private String city;

    private int zipcode;

    private String phoneNumber;

    private String emailAddress;

    private String state;

    private String court;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<AbstractDeal> deals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
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

    public List<AbstractDeal> getDeals() {
        return deals;
    }
}
