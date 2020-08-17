package com.zcy.spring.controller;

import com.zcy.spring.entity.Student;
import com.zcy.spring.entity.StudentList;
import com.zcy.spring.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @RequestMapping("/findStudentById")
    public String findStudentById(int id, ModelMap map) {
        int ids = id;
        Student student = iStudentService.findStudentById(id);

        //也可以自己新建一个ModelMap
        map.put("msg", student.toString());

        System.out.println("findStudentById");
        return "hello";
    }


    @RequestMapping("/findStudentById2")
    //RequestParam  将前端传递的参数student_id作为id使用(映射关系)
    //required=false  表示参数student_id非必须传递 当传递的参数不是限定的参数时将会使用默认的参数值
    public String findStudentById2(@RequestParam(name = "student_id", required = false, defaultValue = "888") int id,
                                   ModelMap map) {
        Student student = new Student();
        student.setId(id);

        //也可以自己新建一个ModelMap
        map.put("msg", student.toString());
        return "hello";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(int id, String name, ModelMap map) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);

        //也可以自己新建一个ModelMap
        map.put("msg", student.toString());
        return "hello";
    }

    @RequestMapping("/updateStudent2")
    public String updateStudent2(Student student, ModelMap map) {

        map.put("msg", student.toString());
        return "hello";
    }

    @RequestMapping("/deleteStudentByIds")//不常用 这种方式的变量名对应checkbox的name
    public String deleteStudentByIds(int[] ids, ModelMap map) {
        StringBuilder sb = new StringBuilder();
        for (int id : ids) {
            sb.append(id + "---");
        }
        //也可以自己新建一个ModelMap
        map.put("msg", sb.toString());
        return "hello";
    }

    @RequestMapping("/deleteStudentByIds2")
    public String deleteStudentByIds2(StudentList studentList, ModelMap map) {
        StringBuilder sb = new StringBuilder();
        for (Student student : studentList.getStudentList()) {
            sb.append(student.toString());
        }
        //也可以自己新建一个ModelMap
        map.put("msg", sb.toString());
        return "hello";
    }

    @RequestMapping("/updateStudent3")
    @ResponseBody//表明返回得student对象要通过MappingJackson2HttpMessageConverter接口转换为json对象
    public Student updateStudent3(Student student) {
        System.out.println("更新学生");
        return student;
    }


    @RequestMapping("/updateStudentByJson")
    @ResponseBody//表明返回得student对象要通过MappingJackson2HttpMessageConverter接口转换为json对象
    //@RequestBody 表明要接收的是json 格式数据,一般不常用
    public Student updateStudentByJson(@RequestBody Student student) {
        System.out.println("更新学生");
        return student;
    }

    @RequestMapping("/findStudentByIdRestFul/{id}")
    @ResponseBody
    //@PathVariable 表明当前的参数去路径里面取用
    public Student findStudentByIdRestFul(@PathVariable(name = "id") int id) {
        Student student = new Student();
        student.setId(id);

        return student;
    }


    @RequestMapping("findAllStudent")
    @ResponseBody
    public List<Student> findAllStudent(){
        return iStudentService.findAllStudent();
    }
}
