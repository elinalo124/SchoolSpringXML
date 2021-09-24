package com.elina.service;

import com.elina.model.Department;
import com.elina.repository.DepartmentRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DepartmentService {
    void setDepartmentRepository(DepartmentRepository repository);

    @Transactional
    void save(Department department);

    @Transactional
    Department findById(Long id);

    @Transactional
    List<Department> findAll();

    @Transactional
    void deleteById(Long id);

    @Transactional
    void update(Department newDepartment, Long id);
}
