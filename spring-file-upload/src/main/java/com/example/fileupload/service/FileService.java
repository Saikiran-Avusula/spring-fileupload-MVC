package com.example.fileupload.service;

import com.example.fileupload.model.UploadedFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    void uploadFile(MultipartFile multipartFile);
    List<UploadedFile> getAllFiles();
}
