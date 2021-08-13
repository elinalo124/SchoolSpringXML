package com.elina.service;

import com.elina.model.Course;
import com.elina.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService{

    private CourseRepository repository;

    public CourseServiceImpl() {
        System.out.println("Constructing CourseServiceImpl with no args");
    }

    @Autowired
    public void setRepository(CourseRepository repository) {
        this.repository = repository;
        System.out.println("Setting repo for CourseServiceImpl");
    }

    public void save(Course course){
        System.out.println("Service is saving:\n"+course);
        repository.save(course);
    }

    public Course findById(Long id){
        return repository.findById(id).get();
    }

    public List<Course> findByName(String name){
        return repository.findByName(name);
    }

    public List<Course> findAll(){
        return (List<Course>) repository.findAll();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Course updateById(Course newCourse, Long id) {
        return repository.findById(id)
                .map(course -> {
                    course.setName(newCourse.getName());
                    course.setDescription(newCourse.getDescription());
                    course.setDepartment(newCourse.getDepartment());
                    return repository.save(course);
                })
                .orElseGet(() -> {
                    newCourse.setId(id);
                    return repository.save(newCourse);
                });
    }


    /*
    public void test() {
        // Save a new course
        Course newCourse = new Course();
        newCourse.setName("Course1");
        newCourse.setDescription("Maths");

        repository.save(newCourse);

        // Find a course by ID
        Optional<Course> result = repository.findById(1L);
        result.ifPresent(course -> System.out.println(course));

        // Find courses by last name
        List<Course> courses = repository.findByName("Course1");
        courses.forEach(course -> System.out.println(course));

        // List all courses
        Iterable<Course> iterator = repository.findAll();
        iterator.forEach(course -> System.out.println(course));

        // Count number of course
        long count = repository.count();
        System.out.println("Number of courses: " + count);
    }
     */


}
