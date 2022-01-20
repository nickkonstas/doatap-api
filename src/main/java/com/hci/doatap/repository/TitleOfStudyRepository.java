package com.hci.doatap.repository;


import com.hci.doatap.model.TitleOfStudies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleOfStudyRepository extends JpaRepository<TitleOfStudies, Long> {
}
