package com.yuntu.service;

import com.yuntu.entity.Score;
import com.yuntu.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service
 * @Author: Shuo
 * @CreateTime: 2023-10-16  14:51
 * @Description:
 * @Version: 1.0
 */
public interface StudentService {
    List<Student> getStudentAllScore();

    List<Student> getStudentOneMaxTwo(String one,String two);

    List<Student> getStudentNotOne(@Param("one") String one,@Param("two") String two);

    List<Student> getStudentNotAll();
    List<Score> getStudentScore();
    List<Student> getStudentTeacher(@Param("t")String teacher);
}
