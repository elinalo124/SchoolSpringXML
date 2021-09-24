package com.elina.service;

import com.elina.model.Department;
import com.elina.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentRepository repository;

    public DepartmentServiceImpl() {
        System.out.println("Constructing DepartmentServiceImpl with no args");
    }

    @Override
    public void setDepartmentRepository(DepartmentRepository repository) {
        this.repository = repository;
        System.out.println("Setting repo for DepartmentServiceImpl");
    }

    @Override
    @Transactional
    public void save(Department department){
        System.out.println("Service is saving:\n"+department);
        repository.save(department);
    }

    @Override
    @Transactional
    public Department findById(Long id){
        return (Department) repository.findById(id);
    }

    @Override
    @Transactional
    public List<Department> findAll(){
        return (List<Department>) repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Department newDepartment, Long id) {
        newDepartment.setId(id);
        repository.update(newDepartment);
    }
}
