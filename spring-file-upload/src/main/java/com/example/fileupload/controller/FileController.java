package com.example.fileupload.controller;

import com.example.fileupload.model.FileEntity;
import com.example.fileupload.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        try {
            fileService.saveFile(file);
            model.addAttribute("message", "File uploaded successfully!");
        } catch (Exception e) {
            model.addAttribute("message", "File upload failed: " + e.getMessage());
        }
        return "uploadFile";
    }
}

