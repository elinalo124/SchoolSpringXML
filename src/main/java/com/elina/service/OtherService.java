package com.elina.service;

import com.elina.repository.CourseRepository;
import com.elina.repository.DepartmentRepository;

public interface OtherService {

    void setDepartmentRepository(DepartmentRepository repository);
    void setCourseRepository(CourseRepository repository);

    void addCourseToDepartment(Long course_id, Long department_id) ;
    void removeCourseFromDepartment(Long course_id, Long department_id);
}
