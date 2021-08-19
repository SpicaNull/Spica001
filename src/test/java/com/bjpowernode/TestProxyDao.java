package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.StudentDaoImpl;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.util.MyBatisUtil;
import com.bjpowernode.vo.QueryParam;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestProxyDao {
    @Test
    public void testProxySelect(){
        /**
         * 使用mybatis中的动态代理机制，使用SqlSession.getMapper(dao接口);
         * getMapper能够获取dao接口对应的实现类对象。
         */

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class); //参数：dao接口
        PageHelper.startPage(2,3);
        List<Student> list = dao.selectStudents();
        for (Student stu: list) {
            System.out.println("查询学生结果："+stu);
        }
        sqlSession.close();

    }
    @Test
    public void testProxySelectMap(){
        /**
         * 使用mybatis中的动态代理机制，使用SqlSession.getMapper(dao接口);
         * getMapper能够获取dao接口对应的实现类对象。
         */

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class); //参数：dao接口
        List<MyStudent> list = dao.selectStudentMap();
        for (MyStudent stu: list) {
            System.out.println("查询学生结果："+stu);
        }
        sqlSession.close();

    }
    @Test
    public void testProxyInsert(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class); //参数：dao接口
        Student stu = new Student();
        stu.setId(1007);
        stu.setName("刘蓓");
        stu.setEmail("liubei@163.com");
        stu.setAge(22);
        int result = dao.insertStudent(stu);
        if (result == 1){
            System.out.println("Insert操作执行成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testProxySelectMulit(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "张三";
        Integer age = 26;
        List<Student> listStu = dao.selectMulitStudents(name,age);
        listStu.forEach(stu-> System.out.println("2次查询学生结果："+stu));
        sqlSession.close();
    }

    @Test
    public void testProxySelectMultiObj(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam = new QueryParam();
        queryParam.setParamName("张三");
        queryParam.setParamAge(23);
        List<Student> listStu = dao.selectMultiObject(queryParam);
        listStu.forEach(stu-> System.out.println("3次查询学生结果："+stu));
        sqlSession.close();
    }
    @Test
    public void testProxySelectMultiStu(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("张三");
        student.setAge(23);
        List<Student> listStu = dao.selectMultiStudent(student);
        listStu.forEach(stu-> System.out.println("3次查询学生结果："+stu));
        sqlSession.close();
    }

    @Test
    public void testProxySelectIf(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("王五");
        student.setAge(18);
        List<Student> listStu = dao.selectIfStudent(student);
        listStu.forEach(stu-> System.out.println("if查询学生结果："+stu));
        sqlSession.close();
    }

    @Test
    public void testProxySelectWhere(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("王五");
        student.setAge(18);
        List<Student> listStu = dao.selectWhereStudent(student);
        listStu.forEach(stu-> System.out.println("where查询学生结果："+stu));
        sqlSession.close();
    }

    @Test
    public void testProxySelectForeach(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> stuList = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1001);
        stuList.add(s1);

        s1 = new Student();
        s1.setId(1002);
        stuList.add(s1);

        s1 = new Student();
        s1.setId(1003);
        stuList.add(s1);
        List<Student> listStu = dao.selectForeachStudent(stuList);
        listStu.forEach(stu-> System.out.println("foreach查询学生结果："+stu));
        sqlSession.close();
    }

    @Test
    public void testProxySelectForeach2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> listStu = dao.selectForeachStu(list);
        listStu.forEach(stu-> System.out.println("foreach查询学生结果："+stu));
        sqlSession.close();
    }
}
