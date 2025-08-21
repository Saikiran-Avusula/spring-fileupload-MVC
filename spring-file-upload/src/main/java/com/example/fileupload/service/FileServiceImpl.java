package com.example.fileupload.service;

import com.example.fileupload.model.UploadedFile;
import com.example.fileupload.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

//    private final String uploadDir = "C:/uploaded_files";

    private final String uploadDir = System.getProperty("user.home") + "/uploaded_files";

    @Override
    public void uploadFile(MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            throw new IllegalArgumentException("File must not be empty");
        }

        try {
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }

            String originalFileName = multipartFile.getOriginalFilename();
            String fileExtension = "";

            if (originalFileName != null && originalFileName.contains(".")) {
                fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            }

            String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

            Path filePath = Paths.get(uploadDir, uniqueFileName);
            Files.write(filePath, multipartFile.getBytes());

            UploadedFile fileEntity = new UploadedFile();
            fileEntity.setOriginalFileName(originalFileName);
            fileEntity.setStoredFilePath(filePath.toString());
            fileEntity.setFileType(multipartFile.getContentType());
            fileEntity.setFileSize(multipartFile.getSize());

            fileRepository.save(fileEntity);

        } catch (Exception e) {
            e.printStackTrace(); // logs full details to server console
            throw new RuntimeException("Failed to save file", e);
        }
    }

    @Override
    public List<UploadedFile> getAllFiles() {
        return fileRepository.findAll();
    }
}
