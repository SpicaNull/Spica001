package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.util.MyBatisUtil;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao{
    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao.selectStudents";
        List<Student> listStu = sqlSession.selectList(sqlId);
        sqlSession.close();
        return listStu;
    }

    @Override
    public List<MyStudent> selectStudentMap() {
        return null;
    }

    @Override
    public List<Student> selectMulitStudents(String name, Integer age) {
        return null;
    }

    @Override
    public List<Student> selectMultiObject(QueryParam QP) {
        return null;
    }

    @Override
    public List<Student> selectMultiStudent(Student stu) {
        return null;
    }

    @Override
    public List<Student> selectIfStudent(Student stu) {
        return null;
    }

    @Override
    public List<Student> selectWhereStudent(Student stu) {
        return null;
    }

    @Override
    public List<Student> selectForeachStudent(List<Student> stulist) {
        return null;
    }

    @Override
    public List<Student> selectForeachStu(List<Integer> id) {
        return null;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao.insertStudent";
        int result = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}
