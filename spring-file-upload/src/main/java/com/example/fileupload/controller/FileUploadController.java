package com.example.fileupload.controller;

import com.example.fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/files")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @GetMapping("/upload")
    public String showUploadForm() {
        return "uploadFile";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile multipartFile, Model model) {
        try {
            fileService.uploadFile(multipartFile);
            model.addAttribute("message", "File uploaded Successfully...!");
        } catch (Exception e) {
            model.addAttribute("message", "Failed to upload file: " + e.getMessage());
        }
        return "uploadFile";
    }

    @GetMapping("/list")
    public String listFiles(Model model) {
        model.addAttribute("files", fileService.getAllFiles());
        return "listFiles";
    }
}
