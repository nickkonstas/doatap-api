package com.hci.doatap.repository;


import com.hci.doatap.model.UploadFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<UploadFiles, Long> {


}
