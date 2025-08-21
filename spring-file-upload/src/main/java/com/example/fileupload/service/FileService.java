package com.example.fileupload.service;

import com.example.fileupload.model.FileEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileEntity saveFile(MultipartFile file) throws Exception;
    FileEntity getFile(Long id) throws Exception;

}
