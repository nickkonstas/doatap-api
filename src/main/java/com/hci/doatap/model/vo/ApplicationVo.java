package com.hci.doatap.model.vo;

public class ApplicationVo {
    private String levelOfStudies;
    private Boolean correspondence;
    private Boolean university;
    private Boolean tei;
    private Boolean universityTei;

    public ApplicationVo() {
    }

    public ApplicationVo(String levelOfStudies, Boolean correspondence, Boolean university, Boolean tei, Boolean university_tei) {
        this.levelOfStudies = levelOfStudies;
        this.correspondence = correspondence;
        this.university = university;
        this.tei = tei;
        this.universityTei = university_tei;
    }

    public String getLevelOfStudies() {
        return levelOfStudies;
    }

    public void setLevelOfStudies(String levelOfStudies) {
        this.levelOfStudies = levelOfStudies;
    }

    public Boolean getCorrespondence() {
        return correspondence;
    }

    public void setCorrespondence(Boolean correspondence) {
        this.correspondence = correspondence;
    }

    public Boolean getUniversity() {
        return university;
    }

    public void setUniversity(Boolean university) {
        this.university = university;
    }

    public Boolean getTei() {
        return tei;
    }

    public void setTei(Boolean tei) {
        this.tei = tei;
    }

    public Boolean getUniversity_tei() {
        return universityTei;
    }

    public void setUniversity_tei(Boolean university_tei) {
        this.universityTei = university_tei;
    }
}
