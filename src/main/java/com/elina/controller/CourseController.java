package com.elina.controller;

import com.elina.model.Course;
import com.elina.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private CourseServiceImpl courseServiceImpl;

    @Autowired
    public void setCourseServiceImpl(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    //CREATE
    @PostMapping("/courses")
    public void saveCourse(@RequestBody Course newCourse){
        System.out.println("Controller is saving:\n"+newCourse);
        courseServiceImpl.save(newCourse);
    }

    //RETRIEVE
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long id){
        Course course = courseServiceImpl.findById(id);
        System.out.println("get Course\n"+ course);
        return course;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        List<Course> courses = courseServiceImpl.findAll();
        System.out.println("All courses\n"+courses);
        return courses;
    }
    //UPDATE
    @PutMapping("/courses/{id}")
    Course replaceCourse(@RequestBody Course newCourse, @PathVariable Long id) {
        return courseServiceImpl.updateById(newCourse, id);
    }

    //DELETE
    @DeleteMapping("/courses/{id}")
    void deleteEmployee(@PathVariable Long id) {
        courseServiceImpl.deleteById(id);
    }

    /*
    @RequestMapping("/")
    public ModelAndView home() {
        List<Course> listCourse = courseServiceImpl.findAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listCourse", listCourse);
        return mav;
    }

    //CREATE
    @RequestMapping("/new")
    public String newCourseForm(Map<String, Object> model) {
        Course course = new Course();
        model.put("course", course);
        return "new_course";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseServiceImpl.save(course);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editCourseForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_course");
        Course course = courseServiceImpl.findById(id);
        mav.addObject("course", course);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteCourseForm(@RequestParam long id) {
        courseServiceImpl.deleteById(id);
        return "redirect:/";
    }
     */

}
