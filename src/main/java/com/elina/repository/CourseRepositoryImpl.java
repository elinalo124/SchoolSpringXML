package com.elina.repository;


import com.elina.model.Course;
import org.springframework.stereotype.Repository;


@Repository("courseRepository")
public class CourseRepositoryImpl extends AbstractJPARepository<Course> implements CourseRepository<Course>{

    public CourseRepositoryImpl(){
        setClazz(Course.class );
    }

}
