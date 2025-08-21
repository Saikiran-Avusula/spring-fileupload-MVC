package com.example.fileupload.repository;

import com.example.fileupload.model.FileEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class FileRepositoryImpl implements FileRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public FileEntity save(FileEntity fileEntity) {
        entityManager.persist(fileEntity);
        return fileEntity;
    }

    @Override
    public FileEntity findById(Long id) {
        return entityManager.find(FileEntity.class, id);
    }

    @Override
    public List<FileEntity> findAll() {
        return entityManager.createQuery("SELECT f FROM FileEntity f", FileEntity.class)
                .getResultList();
    }
}
