package com.yuntu.mapper.student;

import com.yuntu.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.mapper.student
 * @Author: Shuo
 * @CreateTime: 2023-10-19  14:05
 * @Description:
 * @Version: 1.0
 */
public interface StudentMapper {
    int addStudents(@Param("list") List<Student> students);

    List<Student> getTeacher(@Param("t")String t);

    Student getStudent(@Param("name") String name);
    int delStudent(String id);
    int delScore(String id);

    List<Student> getStudentNoPass();

    List<Student> getStudentThree();
}
