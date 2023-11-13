package com.yuntu.service;

import com.yuntu.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service
 * @Author: Shuo
 * @CreateTime: 2023-10-19  14:06
 * @Description:
 * @Version: 1.0
 */
public interface StudentService {
    int addStudents(@Param("list") List<Student> students);
    List<Student> getTeacher(@Param("t")String t);
    int deleteStudent(String name);
    List<Student> getStudentNoPass();
    List<Student> getStudentThree();
}
