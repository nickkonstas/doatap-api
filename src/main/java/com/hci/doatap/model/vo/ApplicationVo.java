package com.hci.doatap.model.vo;

import com.hci.doatap.model.Application;

public class ApplicationVo {
    private Long id;
    private String levelOfStudies;
    private Boolean correspondence;
    private Boolean university;
    private Boolean tei;
    private Boolean university_tei;

    public ApplicationVo() {
    }

    public ApplicationVo(Application application) {
        this.id = application.getId();
        this.levelOfStudies = application.getLevelOfStudies();
        this.correspondence = application.getCorrespondence();
        this.university = application.getUniversity();
        this.tei = application.getTei();
        this.university_tei = application.getUniversity_tei();
    }

    public ApplicationVo(Long id, String levelOfStudies, Boolean correspondence, Boolean university, Boolean tei, Boolean university_tei) {
        this.id = id;
        this.levelOfStudies = levelOfStudies;
        this.correspondence = correspondence;
        this.university = university;
        this.tei = tei;
        this.university_tei = university_tei;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getUniversityTei() {
        return university_tei;
    }

    public void setUniversityTei(Boolean universityTei) {
        this.university_tei = universityTei;
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
        return university_tei;
    }

    public void setUniversity_tei(Boolean university_tei) {
        this.university_tei = university_tei;
    }
}
