package com.hci.doatap.controller;


import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.Application;
import com.hci.doatap.model.TitleOfStudies;
import com.hci.doatap.model.UserPersonalInfo;
import com.hci.doatap.model.vo.ApplicationVo;
import com.hci.doatap.model.vo.UserVo;
import com.hci.doatap.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
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

    @GetMapping(value = "/user/getUserApplications")
    public ResponseEntity<List<ApplicationVo>> getUserApplications() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        List<ApplicationVo> applications = applicationService.getUserApplications(userName);

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
}

