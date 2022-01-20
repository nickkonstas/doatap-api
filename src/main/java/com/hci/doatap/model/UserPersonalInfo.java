package com.hci.doatap.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserPersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "gender")
    private String gender;

    @Column(name = "country_of_birth")
    private String countryOfBirth;

    @Column(name = "city_of_birth")
    private String cityOfBirth;

    @Column(name = "date_of_birth")
    @Type(type="date")
    private Date dateOfBirth;

    @Column(name = "country_of_residence")
    private String countryOfResidence;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city_of_residence")
    private String cityOfResidence;

    @Column(name = "region_of_residence")
    private String regionOfResidence;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "cell_number")
    private String cellNumber;

    //Identity Fields
    @Column(name = "is_identity")
    private boolean isIdentity;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "identity_issue_date")
    @Type(type="date")
    private Date identityIssueDate;

    @Column(name = "issuing_authority")
    private String issuingAuthority;

    // Passport Fields
    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "passport_expiration_date")
    @Type(type="date")
    private Date passportExpirationDate;

    @Column(name = "country_of_issue")
    private String countryOfIssue;

//    // One-to-one relationship with user
//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false, updatable = false)
//    @JsonBackReference
//    private AppUser appUser;

    @OneToOne(targetEntity = Application.class, mappedBy = "userPersonalInfo", cascade = CascadeType.ALL)
    //@JsonManagedReference
    private Application application;

    public UserPersonalInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public String getRegionOfResidence() {
        return regionOfResidence;
    }

    public void setRegionOfResidence(String regionOfResidence) {
        this.regionOfResidence = regionOfResidence;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public boolean isIdentity() {
        return isIdentity;
    }

    public void setIdentity(boolean identity) {
        isIdentity = identity;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Date getIdentityIssueDate() {
        return identityIssueDate;
    }

    public void setIdentityIssueDate(Date identityIssueDate) {
        this.identityIssueDate = identityIssueDate;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getPassportExpirationDate() {
        return passportExpirationDate;
    }

    public void setPassportExpirationDate(Date passportExpirationDate) {
        this.passportExpirationDate = passportExpirationDate;
    }

    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    //    public AppUser getUser() {
    //        return appUser;
    //    }
    //
    //    public void setUser(AppUser appUser) {
    //        this.appUser = appUser;
    //    }
}
