package com.elina.repository;

import java.io.Serializable;
import java.util.List;

public interface DepartmentRepository <T extends Serializable>{
    void setClazz(Class<T> clazzToSet);

    T findById(Long id);

    List findAll();

    void save(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(long entityId);
}
