package com.hci.doatap.model.vo;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileVo {

    private MultipartFile[] files;
    private String comment;
    private String isSubmit;

    public UploadFileVo(MultipartFile[] files, String comment, String isSubmit) {
        this.files = files;
        this.comment = comment;
        this.isSubmit = isSubmit;
    }

    public UploadFileVo() {
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public String getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
