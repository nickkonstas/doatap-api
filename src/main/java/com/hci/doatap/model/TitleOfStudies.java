package com.hci.doatap.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "title_studies")
public class TitleOfStudies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "country")
    private String countryOfStudies;

    @Column(name = "university")
    private String university;

    @Column(name = "title_of_studies")
    private String titleOfStudies;

    @Column(name = "ects")
    private int ects;

    @Column(name = "registration_date")
    @Type(type = "date")
    private Date registrationDate;

    @Column(name = "graduation_date")
    @Type(type = "date")
    private Date graduationDate;

    @Column(name = "duration")
    private int durationOfStudies;

//    @Column(name = "remote")
//    private Boolean remoteStudies;
//
//    // If remote button in front-end is enabled
//    @Column(name = "remote_city")
//    private String remoteCityOfStudies;
//
//    @Column(name = "remote_university")
//    private String remoteInstitutionOfStudies;

    @Column(name = "corr_with_university")
    private String corrWithUniversity;

    @Column(name = "corr_with_tei")
    private String corrWithTei;

    @OneToOne(targetEntity = Application.class, mappedBy = "titleOfStudies", cascade = CascadeType.ALL)
    //@JsonManagedReference
    private Application application;

    public TitleOfStudies() {
    }

    public TitleOfStudies(Long id, String countryOfStudies, String university, String titleOfStudies, int ects, Date registrationDate, Date graduationDate, int durationOfStudies, String corrWithUniversity, String corrWithTei, Application application) {
        this.id = id;
        this.countryOfStudies = countryOfStudies;
        this.university = university;
        this.titleOfStudies = titleOfStudies;
        this.ects = ects;
        this.registrationDate = registrationDate;
        this.graduationDate = graduationDate;
        this.durationOfStudies = durationOfStudies;
        this.corrWithUniversity = corrWithUniversity;
        this.corrWithTei = corrWithTei;
        this.application = application;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryOfStudies() {
        return countryOfStudies;
    }

    public void setCountryOfStudies(String countryOfStudies) {
        this.countryOfStudies = countryOfStudies;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getTitleOfStudies() {
        return titleOfStudies;
    }

    public void setTitleOfStudies(String titleOfStudies) {
        this.titleOfStudies = titleOfStudies;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public int getDurationOfStudies() {
        return durationOfStudies;
    }

    public void setDurationOfStudies(int durationOfStudies) {
        this.durationOfStudies = durationOfStudies;
    }

//    public Boolean getRemoteStudies() {
//        return remoteStudies;
//    }
//
//    public void setRemoteStudies(Boolean remoteStudies) {
//        this.remoteStudies = remoteStudies;
//    }
//
//    public String getRemoteCityOfStudies() {
//        return remoteCityOfStudies;
//    }
//
//    public void setRemoteCityOfStudies(String remoteCityOfStudies) {
//        this.remoteCityOfStudies = remoteCityOfStudies;
//    }
//
//    public String getRemoteInstitutionOfStudies() {
//        return remoteInstitutionOfStudies;
//    }
//    public void setRemoteInstitutionOfStudies(String remoteInstitutionOfStudies) {
//        this.remoteInstitutionOfStudies = remoteInstitutionOfStudies;
//    }

    public String getCorrWithUniversity() {
        return corrWithUniversity;
    }

    public void setCorrWithUniversity(String corrWithUniversity) {
        this.corrWithUniversity = corrWithUniversity;
    }

    public String getCorrWithTei() {
        return corrWithTei;
    }

    public void setCorrWithTei(String corrWithTei) {
        this.corrWithTei = corrWithTei;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }


}
