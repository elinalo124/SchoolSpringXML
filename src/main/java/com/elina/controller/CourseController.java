package com.elina.controller;

import com.elina.model.Course;
import com.elina.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private CourseService courseService;

    @Autowired
    public void setCourseServiceImpl(CourseService courseServiceImpl) {
        this.courseService = courseServiceImpl;
    }

    //CREATE
    @PostMapping("/courses")
    public void saveCourse(@RequestBody Course newCourse){
        System.out.println("Controller is saving:\n"+newCourse);
        courseService.save(newCourse);
    }

    //RETRIEVE
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long id){
        Course course = courseService.findById(id);
        System.out.println("get Course\n"+ course);
        return course;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        List<Course> courses = courseService.findAll();
        System.out.println("All courses\n"+courses);
        return courses;
    }
    //UPDATE
    @PutMapping("/courses/{id}")
    public void replaceCourse(@RequestBody Course newCourse) {
        courseService.update(newCourse);
    }

    //DELETE
    @DeleteMapping("/courses/{id}")
    void deleteEmployee(@PathVariable Long id) {
        courseService.deleteById(id);
    }

}
