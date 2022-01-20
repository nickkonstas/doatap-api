package com.hci.doatap.controller;

import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.vo.UserVo;
import com.hci.doatap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("api/")
public class LoginController {

//    private UserService userService;
//    @Autowired
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<Object> getUser(@RequestBody User user) {
//
//        UserVo authenticatedUser = userService.login(user);
//        if (authenticatedUser != null) {
//            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
//        }
//        String errorLoginMessage = "User not found";
//        return new ResponseEntity<>(errorLoginMessage, HttpStatus.UNAUTHORIZED);
////    }
//    @PostMapping("/login")
//    public String getUser(@RequestBody AppUser user) {
//        return "Hello";
//    }
//
}
