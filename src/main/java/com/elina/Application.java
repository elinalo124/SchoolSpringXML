package com.elina;

import com.elina.config.AppConfig;
import com.elina.service.CourseServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String args[]){


        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CourseServiceImpl courseService = (CourseServiceImpl) appContext.getBean("courseService");
        //courseService.test();

    }
}
