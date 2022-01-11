package com.hci.doatap.controller;

import com.hci.doatap.model.User;
import com.hci.doatap.model.UserDetails;
import com.hci.doatap.repository.UserRepository;
import com.hci.doatap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/")
public class UserDetailsController {

    private UserService userService;

    public UserDetailsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userInfo/{id}")
    public ResponseEntity<Object> getUserDetails(@PathVariable("id") Long userId) {
        UserDetails userDetails = userService.getPersonalInfo(userId);
        if (userDetails != null) {
            return new ResponseEntity<>(userDetails, HttpStatus.OK);
        }
        String errorLoginMessage = "Sorry, something went wrong";
        return new ResponseEntity<>(errorLoginMessage, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/postUserInfo/{id}")
    public ResponseEntity<Object> saveUserDetails(@RequestBody UserDetails userDetails, @PathVariable("id") Long userId) {
        User user = userService.getUser(userId);
        userDetails.setUser(user);
        userDetails = userService.savePersonalInfo(userDetails);
        user.setUserDetails(userDetails);

        String successMessage = "Success saving";
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
}
