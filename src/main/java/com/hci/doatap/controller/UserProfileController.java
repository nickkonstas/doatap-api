package com.hci.doatap.controller;


import com.hci.doatap.model.User;
import com.hci.doatap.model.vo.UpdateEmail;
import com.hci.doatap.model.vo.UserVo;
import com.hci.doatap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("api/")
public class UserProfileController {

    private UserService userService;
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile/{email}")
    public ResponseEntity<Object> getUserProfile(@PathVariable("email") String userEmail) {

        UserVo user = userService.profile(userEmail);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        String errorMessage = "Profile Not Found";
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/profile/changeEmail")
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
}
