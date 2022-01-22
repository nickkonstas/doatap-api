package com.hci.doatap.controller;


import com.hci.doatap.model.UploadFiles;
import com.hci.doatap.model.vo.UploadFileVo;
import com.hci.doatap.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("api/")
public class FileStorageController {

    FileService fileService;

    public FileStorageController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/user/upload/{id}" )
//    public String uploadFiles(@RequestBody Map<MultipartFile[], String> json) {
    public ResponseEntity<Object> uploadFiles(@ModelAttribute UploadFileVo form, @PathVariable("id") Long applicationId) {
        UploadFiles files = fileService.saveFiles(form, applicationId);


        //System.out.println("Mpike");
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
