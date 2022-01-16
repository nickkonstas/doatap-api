package com.hci.doatap.repository;

import com.hci.doatap.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    public AppUser findByEmailAndPassword(String email, String password);
    public AppUser findByEmail(String email);

    Optional<AppUser> findById(Long id);
}
