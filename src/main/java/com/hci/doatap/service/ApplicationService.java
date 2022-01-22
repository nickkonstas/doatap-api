package com.hci.doatap.service;


import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.Application;
import com.hci.doatap.model.vo.ApplicationVo;
import com.hci.doatap.repository.ApplicationRepository;
import com.hci.doatap.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    public List<ApplicationVo> getUserApplications(String userName) {
        AppUser user = userService.getUser(userName);
        List<Application> applications = user.getApplications();
        List<ApplicationVo> returnedApplications = new ArrayList<ApplicationVo>();

        Iterator<Application> it = applications.iterator();
        while (it.hasNext()) {
            returnedApplications.add(new ApplicationVo(it.next()));
        }
        return returnedApplications;
    }


    public List<ApplicationVo> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        List<ApplicationVo> returnedApplications = new ArrayList<ApplicationVo>();

        Iterator<Application> it = applications.iterator();
        while (it.hasNext()) {
            Application currentApplication = it.next();
            if (currentApplication.getSubmitted() == true) {

                returnedApplications.add(new ApplicationVo(currentApplication));
            }
        }
        return returnedApplications;
    }
}
