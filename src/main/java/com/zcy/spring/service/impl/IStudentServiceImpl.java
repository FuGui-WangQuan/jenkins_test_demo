package com.zcy.spring.service.impl;

import com.zcy.spring.dao.IStudentDao;
import com.zcy.spring.entity.Student;
import com.zcy.spring.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao iStudentDao;

    @Override
    public List<Student> findAllStudent() {
        return iStudentDao.findAllStudent();
    }

    @Override
    public Student findStudentById(int id) {
        return iStudentDao.findStudentById(id);
    }

    @Override
    public int addStudent(Student student) {
        return iStudentDao.addStudent(student);
    }

    @Override
    public int deleteStudentById(int id) {
        return iStudentDao.deleteStudentById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return iStudentDao.updateStudent(student);
    }
}
