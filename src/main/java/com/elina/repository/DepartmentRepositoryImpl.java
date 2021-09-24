package com.elina.repository;

import com.elina.model.Course;
import com.elina.model.Department;
import org.springframework.stereotype.Repository;

@Repository("departmentRepository")
public class DepartmentRepositoryImpl extends AbstractJPARepository<Department> implements DepartmentRepository<Department>{
    public DepartmentRepositoryImpl(){
        setClazz(Department.class );
    }
}
