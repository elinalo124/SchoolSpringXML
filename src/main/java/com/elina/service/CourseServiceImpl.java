package com.elina.service;

import com.elina.model.Course;
import com.elina.repository.CourseRepository;
import com.elina.repository.CourseRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    private CourseRepository repository;

    public CourseServiceImpl() {
        System.out.println("Constructing CourseServiceImpl with no args");
    }

    //@Autowired
    @Override
    public void setCourseRepository(CourseRepository repository) {
        this.repository = repository;
        System.out.println("Setting repo for CourseServiceImpl");
    }

    @Override
    @Transactional
    public void save(Course course){
        System.out.println("Service is saving:\n"+course);
        repository.save(course);
    }

    @Override
    @Transactional
    public Course findById(Long id){
        return (Course) repository.findById(id);
    }

    @Override
    @Transactional
    public List<Course> findAll(){
        return (List<Course>) repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Course newCourse, Long id) {
        newCourse.setId(id);
        repository.update(newCourse);
    }

}
