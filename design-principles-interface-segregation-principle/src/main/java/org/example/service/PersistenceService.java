package org.example.service;

import org.example.entity.Entity;

import java.util.List;

public interface PersistenceService<T extends Entity> {
    void save(T entity);
    void delete(T entity);
    T findById(Long id);
}
