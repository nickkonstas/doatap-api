package com.hci.doatap.controller;

import com.hci.doatap.model.TitleOfStudies;
import com.hci.doatap.model.UserPersonalInfo;
import com.hci.doatap.service.TitleOfStudiesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class TitleOfStudiesController {

    TitleOfStudiesService titleOfStudiesService;

    public TitleOfStudiesController(TitleOfStudiesService titleOfStudiesService) {
        this.titleOfStudiesService = titleOfStudiesService;
    }

    @PostMapping("user/postTitle/{id}")
    public ResponseEntity<Object> createTitle(@RequestBody TitleOfStudies titleOfStudies, @PathVariable("id") Long applicationId) {

       TitleOfStudies title = titleOfStudiesService.saveTitleOfStudies(titleOfStudies, applicationId);

        if (title == null) {
            String errorMessage = "Sorry, something went wrong";
            return new ResponseEntity<>(errorMessage, HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(title, HttpStatus.CREATED);

    }

}
