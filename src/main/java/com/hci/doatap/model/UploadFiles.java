package com.hci.doatap.model;


import javax.persistence.*;

@Entity
public class UploadFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String paravolo;
    private String title;
    private String vathmologia;


    @Lob
    private byte[] paravoloContent;

    @Lob
    private byte[] titleContent;

    @Lob
    private byte[] vathmologiaContent;

    @OneToOne(targetEntity = Application.class, mappedBy = "uploadFiles", cascade = CascadeType.ALL)
    //@JsonManagedReference
    private Application application;


    private String comment;


    public UploadFiles() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UploadFiles(Long id, String paravolo, String title, String vathmologia, byte[] paravoloContent, byte[] titleContent, byte[] vathmologiaContent,
                       Application application) {
        this.id = id;
        this.paravolo = paravolo;
        this.title = title;
        this.vathmologia = vathmologia;
        this.paravoloContent = paravoloContent;
        this.titleContent = titleContent;
        this.vathmologiaContent = vathmologiaContent;
        this.application = application;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParavolo() {
        return paravolo;
    }

    public void setParavolo(String paravolo) {
        this.paravolo = paravolo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVathmologia() {
        return vathmologia;
    }

    public void setVathmologia(String vathmologia) {
        this.vathmologia = vathmologia;
    }

    public byte[] getParavoloContent() {
        return paravoloContent;
    }

    public void setParavoloContent(byte[] paravoloContent) {
        this.paravoloContent = paravoloContent;
    }

    public byte[] getTitleContent() {
        return titleContent;
    }

    public void setTitleContent(byte[] titleContent) {
        this.titleContent = titleContent;
    }

    public byte[] getVathmologiaContent() {
        return vathmologiaContent;
    }

    public void setVathmologiaContent(byte[] vathmologiaContent) {
        this.vathmologiaContent = vathmologiaContent;
    }
}
