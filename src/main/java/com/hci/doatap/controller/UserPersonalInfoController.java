package com.hci.doatap.controller;

import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.UserPersonalInfo;
import com.hci.doatap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class UserPersonalInfoController {

    private UserService userService;

    public UserPersonalInfoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userInfo/{id}")
    public ResponseEntity<Object> getUserDetails(@PathVariable("id") Long userId) {
        UserPersonalInfo userPersonalInfo = userService.getPersonalInfo(userId);
        if (userPersonalInfo != null) {
            return new ResponseEntity<>(userPersonalInfo, HttpStatus.OK);
        }
        String errorLoginMessage = "Sorry, something went wrong";
        return new ResponseEntity<>(errorLoginMessage, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/postUserInfo/{id}")
    public ResponseEntity<Object> saveUserDetails(@RequestBody UserPersonalInfo userPersonalInfo, @PathVariable("id") Long userId) {
        AppUser appUser = userService.getUser(userId);
        userPersonalInfo.setUser(appUser);
        userPersonalInfo = userService.savePersonalInfo(userPersonalInfo);
        appUser.setUserDetails(userPersonalInfo);

        String successMessage = "Success saving";
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
}
