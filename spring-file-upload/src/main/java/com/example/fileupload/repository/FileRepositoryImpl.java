package com.example.fileupload.repository;

import com.example.fileupload.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileRepositoryImpl implements FileRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(UploadedFile file) {
        String sql = "INSERT INTO files (original_file_name, stored_file_path, file_type, file_size) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, file.getOriginalFileName(), file.getStoredFilePath(), file.getFileType(), file.getFileSize());
    }

    @Override
    public List<UploadedFile> findAll() {
        String sql = "SELECT id, original_file_name, stored_file_path, file_type, file_size FROM files";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                    UploadedFile file = new UploadedFile();
                    file.setId(rs.getLong("id"));
                    file.setOriginalFileName(rs.getString("original_file_name"));
                    file.setStoredFilePath(rs.getString("stored_file_path"));
                    file.setFileType(rs.getString("file_type"));
                    file.setFileSize(rs.getLong("file_size"));
                    return file;
                });
    }
}
