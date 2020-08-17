package com.zcy.spring.test;

import com.zcy.spring.dao.IStudentDao;
import com.zcy.spring.entity.Student;
import com.zcy.spring.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMybatis {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

       /* IStudentDao iStudentDao = applicationContext.getBean(IStudentDao.class);
        Student student = iStudentDao.findStudentById(36);*/

        IStudentService iStudentService = applicationContext.getBean(IStudentService.class);
        Student student = iStudentService.findStudentById(36);
        System.out.println("student: " + student);

        List<Student> studentList = iStudentService.findAllStudent();
        for(Student student1 : studentList){
            System.out.println("student1: " + student1);
        }
    }
}
