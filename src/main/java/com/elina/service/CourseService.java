package com.elina.service;

import com.elina.model.Course;
import com.elina.repository.CourseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseService {
    //@Autowired
    void setCourseRepository(CourseRepository repository);

    @Transactional
    void save(Course course);

    @Transactional
    Course findById(Long id);

    @Transactional
    List<Course> findAll();

    @Transactional
    void deleteById(Long id);

    @Transactional
    void update(Course newCourse);
}
