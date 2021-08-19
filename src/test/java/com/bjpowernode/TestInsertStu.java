package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.StudentDaoImpl;
import com.bjpowernode.domain.Student;
import org.junit.Test;

public class TestInsertStu {
    @Test
    public void testInsertStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        Student stu = new Student();
        stu.setId(1006);
        stu.setName("王琦");
        stu.setEmail("wangqi@163.com");
        stu.setAge(23);
        int result = studentDao.insertStudent(stu);
        if (result == 1){
            System.out.println("Insert操作执行成功！");
        }
    }
}
