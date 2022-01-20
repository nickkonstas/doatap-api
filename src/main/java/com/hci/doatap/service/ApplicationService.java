package com.hci.doatap.service;


import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.Application;
import com.hci.doatap.repository.ApplicationRepository;
import com.hci.doatap.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private UserService userService;
    private UserRepository userRepository;

    public ApplicationService(ApplicationRepository applicationRepository, UserService userService, UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public Application saveApplication(Application application, String userName) {
        AppUser user = userService.getUser(userName);
        application.setUser(user);
        user.getApplications().add(application);
        applicationRepository.save(application);
        userRepository.save(user);
        return application;
    }

    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public Application getApplicationById(Long id) {
        Application application = applicationRepository.findById(id).orElse(new Application());
        return application;
    }
}
