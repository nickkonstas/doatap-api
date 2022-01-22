package com.hci.doatap.controller;


import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.vo.UpdateEmail;
import com.hci.doatap.model.vo.UpdatePassword;
import com.hci.doatap.model.vo.UserVo;
import com.hci.doatap.service.UserService;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("api/")
public class UserProfileController {

    private UserService userService;
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/profile/{email}")
    public ResponseEntity<Object> getUserProfile(@PathVariable("email") String userEmail) {

        UserVo user = userService.getProfile(userEmail);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        String errorMessage = "Profile Not Found";
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    // We have the email from the toke inside the SecurityContextHolder
    // so it's not required as a path variable

    @GetMapping("/user/profile")
    public ResponseEntity<Object> profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserVo user = userService.getProfile(userName);
        if (user == null) {
            String errorMessage = "User with that email don't exist";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/admin/profile")
    public ResponseEntity<Object> profileAdmin() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserVo user = userService.getProfile(userName);
        if (user == null) {
            String errorMessage = "User with that email don't exist";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PutMapping(value = "/user/profile/changeEmail")
    public ResponseEntity<Object> updateUserEmail(@RequestBody UpdateEmail emailForm) {

        if (userService.emailExist(emailForm)) {
            String errorMessage = "Sorry, email already exists. Try another one";
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
        }

        UserVo user = userService.updateEmail(emailForm);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        String errorMessage = "Email Not Found";
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/user/profile/changePass")
    public ResponseEntity<Object> updateUserPassword(@RequestBody UpdatePassword pass) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        AppUser user = userService.getUser(userName);
        String newPassword = pass.getNewPass();
        user.setPassword(newPassword);

        // need saveUser method to encode the new password and
        // then save the user in the database
        userService.saveUser(user);
        return new ResponseEntity<>(new UserVo(user), HttpStatus.OK);
    }

}
