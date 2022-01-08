package com.hci.doatap.service;

import com.hci.doatap.model.User;
import com.hci.doatap.model.vo.UserVo;
import com.hci.doatap.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserVo login(User user) {
        return new UserVo(userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()));
    }
}
