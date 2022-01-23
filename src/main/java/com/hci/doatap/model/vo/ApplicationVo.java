package com.hci.doatap.model.vo;

import com.hci.doatap.model.Application;

public class ApplicationVo {
    private Long id;
    private String levelOfStudies;
    private Boolean correspondence;
    private Boolean university;
    private Boolean tei;
    private Boolean universityAndTei;
    private Boolean submitted;
    private Boolean accepted;
    private String message;

    public ApplicationVo() {
    }

    public ApplicationVo(Application application) {
        this.id = application.getId();
        this.levelOfStudies = application.getLevelOfStudies();
        this.correspondence = application.getCorrespondence();
        this.university = application.getUniversity();
        this.tei = application.getTei();
        this.universityAndTei = application.getUniversity_tei();
        this.submitted = application.getSubmitted();
        this.accepted = application.getAccepted();
        this.message = application.getMessage();
    }

    public ApplicationVo(Long id, String levelOfStudies, Boolean correspondence, Boolean university, Boolean tei, Boolean university_tei, Boolean submit, Boolean accepted, String message) {
        this.id = id;
        this.levelOfStudies = levelOfStudies;
        this.correspondence = correspondence;
        this.university = university;
        this.tei = tei;
        this.universityAndTei = university_tei;
        this.submitted = submit;
        this.accepted = accepted;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getUniversityAndTei() {
        return universityAndTei;
    }

    public void setUniversityAndTei(Boolean universityAndTei) {
        this.universityAndTei = universityAndTei;
    }

    public Boolean getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
    }
}
