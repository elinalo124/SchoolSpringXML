package com.elina.repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public interface CourseRepository<T extends Serializable> {
    void setClazz(Class<T> clazzToSet);

    T findById(Long id);

    List findAll();

    @Transactional
    void save(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(long entityId);
}
