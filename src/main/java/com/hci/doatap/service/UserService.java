package com.hci.doatap.service;

import com.hci.doatap.model.User;
import com.hci.doatap.model.UserDetails;
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
