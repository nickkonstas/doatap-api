package com.hci.doatap.service;

import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.Application;
import com.hci.doatap.model.UserPersonalInfo;
import com.hci.doatap.repository.PersonalInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoService {

    private ApplicationService applicationService;
    private PersonalInfoRepository personalInfoRepository;

    public PersonalInfoService(ApplicationService applicationService, PersonalInfoRepository personalInfoRepository) {
        this.applicationService = applicationService;
        this.personalInfoRepository = personalInfoRepository;
    }

    public UserPersonalInfo savePersonalInfo(UserPersonalInfo userPersonalInfo, Long applicationId) {
        Application application = applicationService.getApplicationById(applicationId);
        application.setUserPersonalInfo(userPersonalInfo);
        applicationService.save(application);

        userPersonalInfo.setApplication(application);
        personalInfoRepository.save(userPersonalInfo);
        return userPersonalInfo;
    }
}
