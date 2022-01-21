package com.hci.doatap.service;


import com.hci.doatap.model.Application;
import com.hci.doatap.model.TitleOfStudies;
import com.hci.doatap.repository.TitleOfStudyRepository;
import org.springframework.stereotype.Service;

@Service
public class TitleOfStudiesService {

    TitleOfStudyRepository titleOfStudyRepository;
    ApplicationService applicationService;

    public TitleOfStudiesService(TitleOfStudyRepository titleOfStudyRepository, ApplicationService applicationService) {
        this.titleOfStudyRepository = titleOfStudyRepository;
        this.applicationService = applicationService;
    }

    public TitleOfStudies saveTitleOfStudies(TitleOfStudies titleOfStudies, Long applicationId) {
        Application application = applicationService.getApplicationById(applicationId);
        titleOfStudies.setApplication(application);
        titleOfStudyRepository.save(titleOfStudies);

        application.setTitleOfStudies(titleOfStudies);
        applicationService.save(application);

        return titleOfStudies;
    }
}
