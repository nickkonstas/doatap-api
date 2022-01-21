package com.hci.doatap.repository;


import com.hci.doatap.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    public Optional<Application> findById(Long id);

    @Override
    List<Application> findAllById(Iterable<Long> longs);
}
