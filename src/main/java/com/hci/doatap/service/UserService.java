package com.hci.doatap.service;

import com.hci.doatap.model.User;
import com.hci.doatap.model.UserDetails;
import com.hci.doatap.model.vo.UpdateEmail;
import com.hci.doatap.model.vo.UserVo;
import com.hci.doatap.repository.UserDetailsRepository;
import com.hci.doatap.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserDetailsRepository userDetailsRepository;

    public UserService(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    public User getUser(Long id) {
        User user = userRepository.findById(id).orElse(new User());
        return user;
    }

    public UserVo login(User user) {
        User returnedUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (returnedUser == null) {
            return null;
        }
        return new UserVo(returnedUser);
    }

    public UserVo profile(String email) {
        User returnedUser = userRepository.findByEmail(email);
        if (returnedUser == null) {
            return null;
        }
        return new UserVo(returnedUser);
    }

    public boolean emailExist(UpdateEmail emailForm) {
        String newEmail = emailForm.getNewEmail();
        User existingUser = userRepository.findByEmail(newEmail);
        if (existingUser != null)
            return true;
        return false;
    }

    public UserVo updateEmail(UpdateEmail emailForm) {
        String oldEmail = emailForm.getOldEmail();
        String newEmail = emailForm.getNewEmail();


        User returnedUser = userRepository.findByEmail(oldEmail);
        if (returnedUser == null) {
            return null;
        }

        // Here maybe check if the new email is already used
        returnedUser.setEmail(newEmail);

        userRepository.save(returnedUser);
        return new UserVo(returnedUser);
    }

    public UserDetails getPersonalInfo(Long id) {
        User user = userRepository.getById(id);
        return user.getUserDetails();
    }

    public UserDetails savePersonalInfo(UserDetails userDetails) {
        userDetails = userDetailsRepository.save(userDetails);
        return userDetails;
    }

}
