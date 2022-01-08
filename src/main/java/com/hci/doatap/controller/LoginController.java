package com.hci.doatap.controller;

import com.hci.doatap.model.User;
import com.hci.doatap.model.vo.UserVo;
import com.hci.doatap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<Object> getUser(@RequestBody User user) {

        UserVo authenticatedUser = userService.login(user);
        if (authenticatedUser != null) {
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        }
        String errorLoginMessage = "User not found";
        return new ResponseEntity<>(errorLoginMessage, HttpStatus.UNAUTHORIZED);

    }
}
