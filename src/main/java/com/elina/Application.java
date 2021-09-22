package com.elina;

import com.elina.service.CourseServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String args[]){


        ApplicationContext appContext = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");

        CourseServiceImpl courseService = (CourseServiceImpl) appContext.getBean("courseService");
        //courseService.test();

    }
}
