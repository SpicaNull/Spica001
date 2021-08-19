package com.bjpowernode.domain;

import com.bjpowernode.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        //xml路径，从类路径的根目录开始
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //【重点】指定要执行的sql语句标识，sql映射文件中的namespace+ "." +标签id值
        String sqlId = "com.bjpowernode.dao.StudentDao.selectStudents";
        List<Student> stuList = sqlSession.selectList(sqlId);
        stuList.forEach(stu -> System.out.println("查询的学生： "+stu));
        sqlSession.close();
    }
}
