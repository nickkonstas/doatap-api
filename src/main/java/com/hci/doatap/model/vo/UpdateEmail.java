package com.hci.doatap.model.vo;

public class UpdateEmail {

    private String oldEmail;
    private String newEmail;

    public UpdateEmail() {
    }

    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
