package com.hci.doatap.controller;

import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.UserPersonalInfo;
import com.hci.doatap.service.PersonalInfoService;
import com.hci.doatap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class UserPersonalInfoController {

    private UserService userService;
    private PersonalInfoService personalInfoService;

    public UserPersonalInfoController(UserService userService, PersonalInfoService personalInfoService) {
        this.userService = userService;
        this.personalInfoService = personalInfoService;
    }

    @GetMapping("/user/info/{id}")
    public ResponseEntity<Object> getUserDetails(@PathVariable("id") Long userId) {
//        UserPersonalInfo userPersonalInfo = userService.getPersonalInfo(userId);
//        if (userPersonalInfo != null) {
//            return new ResponseEntity<>(userPersonalInfo, HttpStatus.OK);
//        }
//        String errorLoginMessage = "Sorry, something went wrong";
//        return new ResponseEntity<>(errorLoginMessage, HttpStatus.BAD_REQUEST);
        return null;
    }

    @PostMapping("/user/postInfo/{id}")
    public ResponseEntity<Object> saveUserDetails(@RequestBody UserPersonalInfo userPersonalInfo, @PathVariable("id") Long applicationId) {
        UserPersonalInfo info = personalInfoService.savePersonalInfo(userPersonalInfo, applicationId);

        if (info == null) {
            String errorMessage = "Sorry, something went wrong";
            return new ResponseEntity<>(errorMessage, HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(info, HttpStatus.CREATED);
    }
}
