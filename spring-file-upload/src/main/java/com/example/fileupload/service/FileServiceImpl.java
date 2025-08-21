package com.example.fileupload.service;

import com.example.fileupload.model.FileEntity;
import com.example.fileupload.repository.FileRepository;
import org.springframework.web.multipart.MultipartFile;

public class FileServiceImpl implements FileService{

    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public FileEntity saveFile(MultipartFile file) throws Exception {
        FileEntity entity = new FileEntity();
        entity.setFileName(file.getOriginalFilename());
        entity.setFileType(file.getContentType());
        entity.setData(file.getBytes());
        return fileRepository.save(entity);
    }

    @Override
    public FileEntity getFile(Long id) throws Exception {
        return fileRepository.findById(id)
                .orElseThrow(() -> new Exception("File not found"));
    }
}
