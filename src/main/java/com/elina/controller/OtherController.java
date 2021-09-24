package com.elina.controller;

import com.elina.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OtherController {
    private OtherService otherService;

    @Autowired
    public void setOtherServiceImpl(OtherService otherServiceImpl) {
        this.otherService = otherServiceImpl;
    }


    @PutMapping("/other/add/{department_id}/{course_id}")
    public void addCourseToDepartment(@PathVariable("department_id") Long department_id, @PathVariable("course_id") Long course_id){
        otherService.addCourseToDepartment(department_id, course_id);
    }

    @PutMapping("/other/remove/{department_id}/{course_id}")
    public void removeCourseFromDepartment(@PathVariable("department_id") Long department_id, @PathVariable("course_id") Long course_id){
        otherService.removeCourseFromDepartment(department_id, course_id);
    }
}
