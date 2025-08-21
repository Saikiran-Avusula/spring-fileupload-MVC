package com.example.fileupload.repository;


import com.example.fileupload.model.FileEntity;

import java.util.List;

public interface FileRepository {
        FileEntity save(FileEntity fileEntity);
        FileEntity findById(Long id);
        List<FileEntity> findAll();
    }
