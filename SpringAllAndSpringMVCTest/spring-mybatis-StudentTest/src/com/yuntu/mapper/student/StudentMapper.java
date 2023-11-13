package com.yuntu.mapper.student;

import com.yuntu.entity.Score;
import com.yuntu.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.mapper.student
 * @Author: Shuo
 * @CreateTime: 2023-10-16  14:32
 * @Description:
 * @Version: 1.0
 */
public interface StudentMapper {
    /*
    *1.查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩
    * */
    List<Student> getStudentAllScore();
    /*
    *2.查询"01"课程比"02"课程成绩高的学生的信息及课程分数
     01 和 02 是参数
    * */
    List<Student> getStudentOneMaxTwo(@Param("one") String one,@Param("two") String two);
    /*
    *3.查询学过编号为"01"但是没有学过编号为"02"的课程的同学的信息
     01 和 02 是参数
    * */
    List<Student> getStudentNotOne(@Param("one") String one,@Param("two") String two);

    /*
    * 4.查询没有学所有课程的同学的信息
    * */
    List<Student> getStudentNotAll();

    /*
    * 5.按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
    * */
    List<Score> getStudentScore();

    /*
    * 6.查询学过"张三"老师授课的同学的信息
      "张三" 是参数
    * */
    List<Student> getStudentTeacher(@Param("t")String teacher);

}
