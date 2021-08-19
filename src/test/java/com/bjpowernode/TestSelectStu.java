package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.StudentDaoImpl;
import com.bjpowernode.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestSelectStu {
    @Test
    public void testSelectStudents(){
        StudentDao students = new StudentDaoImpl();
        List<Student> listStu = students.selectStudents();
        listStu.forEach(stu->System.out.println("学生查询结果："+stu));

    }
}
