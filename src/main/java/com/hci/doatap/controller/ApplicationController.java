package com.hci.doatap.controller;


import com.hci.doatap.model.*;
import com.hci.doatap.model.vo.*;
import com.hci.doatap.service.ApplicationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("api/")
public class ApplicationController {

    ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping(value = "/user/createApplication", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createApplication(@RequestBody Application application) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        Application returnApplication = applicationService.saveApplication(application, userName);
        return new ResponseEntity<>(returnApplication, HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/getUserSavedApplications")
    public ResponseEntity<List<ApplicationVo>> getUserSavedApplications() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        List<ApplicationVo> applications = applicationService.getUserSavedApplications(userName);

        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping(value = "/user/getUserSubmittedApplications")
    public ResponseEntity<List<ApplicationVo>> getUserSubmittedApplications() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        List<ApplicationVo> applications = applicationService.getUserSubmittedApplications(userName);

        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/getAllApplications")
    public ResponseEntity<List<ApplicationVo>> getAdminApplications() {
        List<ApplicationVo> allApplications = applicationService.getAllApplications();

        return new ResponseEntity<>(allApplications, HttpStatus.OK);
    }

    // Get request for admin for all application content aka title, personal info , files
    @GetMapping(value = "/admin/getApplication/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") Long applicationId) {

        Application application = applicationService.getApplication(applicationId);

        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/getTitle/{id}")
    public ResponseEntity<TitleOfStudies> getTitle(@PathVariable("id") Long applicationId) {

        Application application = applicationService.getApplication(applicationId);
        TitleOfStudies titleOfStudies = application.getTitleOfStudies();
        return new ResponseEntity<>(titleOfStudies, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/getPersonalInfo/{id}")
    public ResponseEntity<UserPersonalInfo> getPersonalInfo(@PathVariable("id") Long applicationId) {

        Application application = applicationService.getApplication(applicationId);
        UserPersonalInfo personalInfo = application.getUserPersonalInfo();
        return new ResponseEntity<>(personalInfo, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/getUserProfile/{id}")
    public ResponseEntity<UserVo> getProfile(@PathVariable("id") Long applicationId) {

        Application application = applicationService.getApplication(applicationId);
        AppUser user = application.getUser();
        UserVo returnedUser = new UserVo(user);
        return new ResponseEntity<>(returnedUser, HttpStatus.OK);
    }

//    @GetMapping(value = "/admin/getFiles/{id}")
//    public ResponseEntity<UploadFiles> uploadUserFiles(@PathVariable("id") Long applicationId) {
//        UploadFiles files =  applicationService.getFiles(applicationId);
//        return new ResponseEntity<>(files, HttpStatus.OK);
//    }

    @DeleteMapping(value = "/user/deleteApplication/{id}")
    public ResponseEntity<Object> deleteApplication (@PathVariable("id") Long applicationId) {
        applicationService.deleteApplication(applicationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/admin/getFileTitles/{id}")
    public ResponseEntity<Object> getFileTitles(@PathVariable("id") Long applicationId) {
        FileTitles fileTitles = applicationService.getFileTitles(applicationId);
        return new ResponseEntity<>(fileTitles, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/getPdf/{id}/{fileTitle}")
    public HttpEntity<byte[]> getPdf(@PathVariable("id") Long applicationId, @PathVariable("fileTitle") String title) {

        byte[] document = applicationService.getDocument(applicationId, title);
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    // Admin's decision and message
    @PostMapping(value = "/admin/decide/{id}")
    public ResponseEntity<Object> postDecision(@RequestBody Decision decision, @PathVariable("id") Long applicationId) {
        ApplicationVo applicationVo = applicationService.adminDecision(applicationId, decision);
        return new ResponseEntity<>(applicationVo, HttpStatus.OK);
    }

//    // Get user's application final decision and message
//    @GetMapping(value = "/user/getDecision/{id}")
//    public ResponseEntity<Object> getDecision(@PathVariable("id"))

}

