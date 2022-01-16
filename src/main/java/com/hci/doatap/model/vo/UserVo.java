package com.hci.doatap.model.vo;

import com.hci.doatap.model.AppUser;

public class UserVo {
    private Long id;

    private String firstName;

    private String lastName;

    private String fathersName;

    private String mothersName;

    private String email;

    private String SSN;

    private boolean isAdmin;

    public UserVo(Long id, String firstName, String lastName, String fathersName, String mothersName, String email, String SSN, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.email = email;
        this.SSN = SSN;
        this.isAdmin = isAdmin;
    }

    public UserVo(AppUser appUser) {
        this.id = appUser.getId();
        this.firstName = appUser.getFirstName();
        this.lastName = appUser.getLastName();
        this.fathersName = appUser.getFathersName();
        this.mothersName = appUser.getMothersName();
        this.email = appUser.getEmail();
        this.SSN = appUser.getSSN();
        this.isAdmin = appUser.isAdmin();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
