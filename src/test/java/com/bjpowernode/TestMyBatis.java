package com.bjpowernode;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    @Test
    public void testInsert() throws IOException {
        //xml路径，从类路径的根目录开始
        String config = "mybatis.xml";
        InputStream in  = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        //【重点】指定要执行的sql语句标识，sql映射文件中的namespace+ "." +标签id值
        String sqlId = "com.bjpowernode.dao.StudentDao.insertStudent";
        Student student = new Student();
        student.setId(1005);
        student.setEmail("zhangsi@123.com");
        student.setName("张四");
        student.setAge(25);
        int result = sqlSession.insert(sqlId,student);

        if (result==1){
            System.out.println("insert数据success ： "+result);
        }
        //mybatis 默认是不自动提交事务的，需要手动提交
        sqlSession.commit();
        sqlSession.close();

    }
}
