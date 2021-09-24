package com.elina.controller;

import com.elina.model.Department;
import com.elina.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public void setDepartmentServiceImpl(DepartmentService departmentServiceImpl) {
        this.departmentService = departmentServiceImpl;
    }

    //CREATE
    @PostMapping("/departments")
    public void saveDepartment(@RequestBody Department newDepartment){
        System.out.println("Controller is saving:\n"+newDepartment);
        departmentService.save(newDepartment);
    }

    //RETRIEVE
    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable("id") Long id){
        Department department = departmentService.findById(id);
        System.out.println("get Department\n"+ department);
        return department;
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        List<Department> departments = departmentService.findAll();
        System.out.println("All departments\n"+departments);
        return departments;
    }
    //UPDATE
    @PutMapping("/departments/{id}")
    public void replaceDepartment(@RequestBody Department newDepartment, @PathVariable("id") Long id) {
        departmentService.update(newDepartment, id);
    }

    //DELETE
    @DeleteMapping("/departments/{id}")
    void deleteEmployee(@PathVariable Long id) {
        departmentService.deleteById(id);
    }
}
