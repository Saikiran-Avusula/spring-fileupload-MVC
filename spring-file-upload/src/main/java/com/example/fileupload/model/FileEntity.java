package com.example.fileupload.model;

import jakarta.persistence.*;

import javax.persistence.Lob;
import java.util.Arrays;

@Entity
@Table(name = "files")
public class FileEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String fileName;
        private String fileType;

        @Lob
        private byte[] data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return null;
    }

    public FileEntity orElseThrow(Object fileNotFound) {
    }
}
