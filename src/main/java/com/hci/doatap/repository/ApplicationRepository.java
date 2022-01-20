package com.hci.doatap.repository;


import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    public Application findByUser(AppUser user);
}
