package com.hci.doatap.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "father_name", nullable = false)
    private String fathersName;

    @Column(name = "mother_name", nullable = false)
    private String mothersName;

    @Column(name = "email_adress", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "social_security_number", nullable = false)
    private String SSN;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    // One-to-many relationship with applications
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Application> applications;


//    // One-to-one relationship with UserDetails
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "appUser")
//    @JsonManagedReference
//    private UserPersonalInfo userPersonalInfo;

    public AppUser() {
    }

//    public AppUser(Long id, String firstName, String lastName, String fathersName, String mothersName, String email, String password, String SSN, boolean isAdmin) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.fathersName = fathersName;
//        this.mothersName = mothersName;
//        this.email = email;
//        this.password = password;
//        this.SSN = SSN;
//        this.isAdmin = isAdmin;
//        //this.userPersonalInfo = userPersonalInfo;
//    }
//
    public AppUser(Long id, String firstName, String lastName, String fathersName, String mothersName, String email, String password, String SSN, Collection<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.email = email;
        this.password = password;
        this.SSN = SSN;
        this.roles = roles;
    }


//    public AppUser(Long id, String firstName, String lastName, String fathersName, String mothersName, String email, String password, String SSN, boolean isAdmin, Collection<Role> roles, Set<Application> applications) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.fathersName = fathersName;
//        this.mothersName = mothersName;
//        this.email = email;
//        this.password = password;
//        this.SSN = SSN;
//        this.isAdmin = isAdmin;
//        this.roles = roles;
//        this.applications = applications;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public UserPersonalInfo getUserDetails() {
//        return userPersonalInfo;
//    }
//
//    public void setUserDetails(UserPersonalInfo userPersonalInfo) {
//        this.userPersonalInfo = userPersonalInfo;
//    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    //    public UserPersonalInfo getUserPersonalInfo() {
//        return userPersonalInfo;
//    }
//
//    public void setUserPersonalInfo(UserPersonalInfo userPersonalInfo) {
//        this.userPersonalInfo = userPersonalInfo;
//    }
}
