package com.zcy.spring.dao;

import com.zcy.spring.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentDao {
    /**
     * 查询所有学生
     * @return
     */
    List<Student> findAllStudent();

    /**
     * 根据Id查询学生
     * @param id
     * @return
     */
    Student findStudentById(int id);

    /**
     * 增加学生
     * @param student
     * @return
     */
    int addStudent(Student student);

    /**
     * 删除学生
     * @param id
     * @return
     */
    int deleteStudentById(int id);

    /**
     * 更新学生
     * @param student
     * @return
     */
    int updateStudent(Student student);
}
