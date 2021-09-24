package com.elina.service;

import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.repository.CourseRepository;
import com.elina.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("otherService")
public class OtherServiceImpl implements OtherService{

    private DepartmentRepository departmentRepository;
    private CourseRepository courseRepository;

    @Override
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    @Override
    public void addCourseToDepartment(Long course_id, Long department_id) {
        Course retrievedCourse = (Course) courseRepository.findById(course_id);
        Department retrievedDepartment = (Department) departmentRepository.findById(department_id);
        retrievedCourse.setDepartment(retrievedDepartment);
        retrievedDepartment.getCourses().add(retrievedCourse);
        courseRepository.update(retrievedCourse);
        departmentRepository.update(retrievedDepartment);
    }

    @Transactional
    @Override
    public void removeCourseFromDepartment(Long course_id, Long department_id) {
        Course retrievedCourse = (Course) courseRepository.findById(course_id);
        Department retrievedDepartment = (Department) departmentRepository.findById(department_id);
        retrievedCourse.setDepartment(null);
        retrievedDepartment.getCourses().remove(retrievedCourse);
        courseRepository.update(retrievedCourse);
        departmentRepository.update(retrievedDepartment);
    }


}
