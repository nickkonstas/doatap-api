package com.hci.doatap.repository;

import com.hci.doatap.model.UserPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends JpaRepository<UserPersonalInfo, Long> {

}
