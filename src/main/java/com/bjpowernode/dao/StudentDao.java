package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
    List<MyStudent> selectStudentMap();
    List<Student> selectMulitStudents(@Param("myname")String name, @Param("myage")Integer age);
    List<Student> selectMultiObject(QueryParam QP);
    List<Student> selectMultiStudent(Student stu);
    List<Student> selectIfStudent(Student stu);
    List<Student> selectWhereStudent(Student stu);
    List<Student> selectForeachStudent(List<Student> stulist);
    List<Student> selectForeachStu(List<Integer> id);
    int insertStudent(Student student);
}
