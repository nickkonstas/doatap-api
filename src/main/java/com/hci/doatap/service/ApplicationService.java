package com.hci.doatap.service;


import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.Application;
import com.hci.doatap.model.UploadFiles;
import com.hci.doatap.model.vo.AdminDecision;
import com.hci.doatap.model.vo.ApplicationVo;
import com.hci.doatap.model.vo.FileTitles;
import com.hci.doatap.model.vo.UploadFileVo;
import com.hci.doatap.repository.ApplicationRepository;
import com.hci.doatap.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private UserService userService;
    private UserRepository userRepository;

    public ApplicationService(ApplicationRepository applicationRepository, UserService userService, UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public Application saveApplication(Application application, String userName) {
        AppUser user = userService.getUser(userName);
        application.setUser(user);
        user.getApplications().add(application);
        applicationRepository.save(application);
        userRepository.save(user);
        return application;
    }

    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public Application getApplicationById(Long id) {
        Application application = applicationRepository.findById(id).orElse(new Application());
        return application;
    }

    public List<ApplicationVo> getUserSavedApplications(String userName) {
        AppUser user = userService.getUser(userName);
        List<Application> applications = user.getApplications();
        List<ApplicationVo> returnedApplications = new ArrayList<ApplicationVo>();

        Iterator<Application> it = applications.iterator();
        while (it.hasNext()) {
            Application current = it.next();
            if (current.getSubmitted() == false)
                returnedApplications.add(new ApplicationVo(current));
        }
        return returnedApplications;
    }

    public List<ApplicationVo> getUserSubmittedApplications(String userName) {
        AppUser user = userService.getUser(userName);
        List<Application> applications = user.getApplications();
        List<ApplicationVo> returnedApplications = new ArrayList<ApplicationVo>();

        Iterator<Application> it = applications.iterator();
        while (it.hasNext()) {
            Application current = it.next();
            if (current.getSubmitted() == true)
                returnedApplications.add(new ApplicationVo(current));
        }
        return returnedApplications;
    }


    public List<ApplicationVo> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        List<ApplicationVo> returnedApplications = new ArrayList<ApplicationVo>();

        Iterator<Application> it = applications.iterator();
        while (it.hasNext()) {
            Application currentApplication = it.next();
            if (currentApplication.getSubmitted() == true) {

                returnedApplications.add(new ApplicationVo(currentApplication));
            }
        }
        return returnedApplications;
    }

    public Application getApplication(Long applicationId) {
        return getApplicationById(applicationId);
    }

    public void deleteApplication(Long applicationId) {
        Application application = getApplication(applicationId);
        applicationRepository.delete(application);
    }

    // Return the titles of the files to download
    public FileTitles getFileTitles(Long applicationId) {
        Application application = getApplication(applicationId);
        UploadFiles files = application.getUploadFiles();
        String paravolo = files.getParavolo();
        String title = files.getTitle();
        String vathmologia = files.getVathmologia();
        String comment = files.getComment();

        FileTitles fileTitles= new FileTitles(paravolo, title, vathmologia, comment);
        return fileTitles;

    }

    public byte[] getDocument(Long applicationId, String title) {
        Application application = getApplication(applicationId);
        UploadFiles files = application.getUploadFiles();
        byte[] returnedDocument = new byte[]{};
        if (title == files.getParavolo()) {
            returnedDocument = files.getParavoloContent();
        }

        else if (title == files.getTitle()) {
            returnedDocument = files.getTitleContent();
        }

        else {
            returnedDocument = files.getVathmologiaContent();
        }
        return returnedDocument;
    }

    public ApplicationVo adminDecision(Long applicationId, AdminDecision decision) {
        Application application = getApplication(applicationId);
        application.setAccepted(decision.getDecision());
        application.setMessage(decision.getMessage());

        ApplicationVo returnedApplication = new ApplicationVo(application);
        return returnedApplication;

    }

//    public UploadFiles getFiles(Long applicationId) {
//        Application application = getApplication(applicationId);
//        UploadFiles files = application.getUploadFiles();
//        return files;
//    }
}
