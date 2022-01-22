package com.hci.doatap.service;


import com.hci.doatap.model.Application;
import com.hci.doatap.model.UploadFiles;
import com.hci.doatap.model.vo.UploadFileVo;
import com.hci.doatap.repository.FileRepository;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private FileRepository fileRepository;
    private ApplicationService applicationService;

    public FileService(FileRepository fileRepository, ApplicationService applicationService) {
        this.fileRepository = fileRepository;
        this.applicationService = applicationService;
    }

    public UploadFiles saveFiles(UploadFileVo files, Long applicationId) {

        try {
            Application application = applicationService.getApplicationById(applicationId);

            UploadFiles uploadFiles = new UploadFiles();

            uploadFiles.setApplication(application);
            uploadFiles.setComment(files.getComment());

            String applicationStatus = files.getIsSubmit();
            application.setSubmitted(Boolean.parseBoolean(applicationStatus));

            uploadFiles.setParavolo(files.getFiles()[0].getOriginalFilename());
            uploadFiles.setParavoloContent(files.getFiles()[0].getBytes());

            uploadFiles.setVathmologia(files.getFiles()[1].getOriginalFilename());
            uploadFiles.setVathmologiaContent(files.getFiles()[1].getBytes());

            uploadFiles.setTitle(files.getFiles()[2].getOriginalFilename());
            uploadFiles.setTitleContent(files.getFiles()[2].getBytes());

            uploadFiles = fileRepository.save(uploadFiles);

            application.setUploadFiles(uploadFiles);
            applicationService.save(application);

            return uploadFiles;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
