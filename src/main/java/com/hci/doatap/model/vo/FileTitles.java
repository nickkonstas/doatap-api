package com.hci.doatap.model.vo;

public class FileTitles {

    private String paravolo;
    private String titleOfStudies;
    private String vathmologia;
    private String userComment;

    public FileTitles() {
    }

    public FileTitles(String paravolo, String titleOfStudies, String vathmologia, String comment) {
        this.paravolo = paravolo;
        this.titleOfStudies = titleOfStudies;
        this.vathmologia = vathmologia;
        this.userComment = comment;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getParavolo() {
        return paravolo;
    }

    public void setParavolo(String paravolo) {
        this.paravolo = paravolo;
    }

    public String getTitleOfStudies() {
        return titleOfStudies;
    }

    public void setTitleOfStudies(String titleOfStudies) {
        this.titleOfStudies = titleOfStudies;
    }

    public String getVathmologia() {
        return vathmologia;
    }

    public void setVathmologia(String vathmologia) {
        this.vathmologia = vathmologia;
    }
}
