package com.hci.doatap.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "level", nullable = false, updatable = false)
    private String levelOfStudies;

    @Column(name = "correspondence", nullable = false, updatable = false)
    private Boolean correspondence;

    @Column(name = "corr_with_university", nullable = false, updatable = false)
    private Boolean university;

    @Column(name = "corr_with_tei", nullable = false, updatable = false)
    private Boolean tei;

    @Column(name = "corr_with_all", nullable = false, updatable = false)
    private Boolean university_tei;

    @Column(name = "submitted", nullable = false)
    private Boolean submitted;

    @OneToOne(targetEntity = UserPersonalInfo.class)
    @JoinColumn(name = "personal_info_id", referencedColumnName = "id")
    //@JsonBackReference
    private UserPersonalInfo userPersonalInfo;

    @OneToOne(targetEntity = TitleOfStudies.class)
    @JoinColumn(name = "title_of_studies_id", referencedColumnName = "id")
    //@JsonBackReference
    private TitleOfStudies titleOfStudies;

    @OneToOne(targetEntity = UploadFiles.class)
    @JoinColumn(name = "upload_files_id", referencedColumnName = "id")
    //@JsonBackReference
    private UploadFiles uploadFiles;

    @JsonBackReference
    @ManyToOne
    //@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false)
    private AppUser user;

    public Application() {
    }

    public Application(Long id, String levelOfStudies, Boolean correspondence, Boolean university, Boolean tei, Boolean university_tei, Boolean submitted, UserPersonalInfo userPersonalInfo, TitleOfStudies titleOfStudies, UploadFiles uploadFiles, AppUser user) {
        this.id = id;
        this.levelOfStudies = levelOfStudies;
        this.correspondence = correspondence;
        this.university = university;
        this.tei = tei;
        this.university_tei = university_tei;
        this.submitted = submitted;
        this.userPersonalInfo = userPersonalInfo;
        this.titleOfStudies = titleOfStudies;
        this.uploadFiles = uploadFiles;
        this.user = user;
    }

    public Boolean getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
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

    public UploadFiles getUploadFiles() {
        return uploadFiles;
    }

    public void setUploadFiles(UploadFiles uploadFiles) {
        this.uploadFiles = uploadFiles;
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

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public UserPersonalInfo getUserPersonalInfo() {
        return userPersonalInfo;
    }

    public void setUserPersonalInfo(UserPersonalInfo userPersonalInfo) {
        this.userPersonalInfo = userPersonalInfo;
    }

    public TitleOfStudies getTitleOfStudies() {
        return titleOfStudies;
    }

    public void setTitleOfStudies(TitleOfStudies titleOfStudies) {
        this.titleOfStudies = titleOfStudies;
    }
}
