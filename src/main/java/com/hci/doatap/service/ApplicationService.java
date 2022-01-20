package com.hci.doatap.service;


import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.Application;
import com.hci.doatap.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private UserService userService;

    public ApplicationService(ApplicationRepository applicationRepository, UserService userService) {
        this.applicationRepository = applicationRepository;
        this.userService = userService;
    }

    public Application saveApplication(Application application, String userName) {
        AppUser user = userService.getUser(userName);
        application.setUser(user);
        user.getApplications().add(application);
        applicationRepository.save(application);
        userService.saveUser(user);
        return application;

    }
}
