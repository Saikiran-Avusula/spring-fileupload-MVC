package com.example.fileupload.repository;

import com.example.fileupload.model.UploadedFile;
import java.util.List;

public interface FileRepository {
    void save(UploadedFile file);
    List<UploadedFile> findAll();
}
