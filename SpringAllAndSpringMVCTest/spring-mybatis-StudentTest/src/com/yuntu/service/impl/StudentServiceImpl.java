package com.yuntu.service.impl;

import com.yuntu.entity.Score;
import com.yuntu.entity.Student;
import com.yuntu.mapper.student.StudentMapper;
import com.yuntu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service.impl
 * @Author: Shuo
 * @CreateTime: 2023-10-16  14:52
 * @Description:
 * @Version: 1.0
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    @Qualifier("studentMapper")
    private StudentMapper studentMapper;
    @Override
    public List<Student> getStudentAllScore() {
        return studentMapper.getStudentAllScore();
    }

    @Override
    public List<Student> getStudentOneMaxTwo(String one, String two) {
        return studentMapper.getStudentOneMaxTwo(one,two);
    }

    @Override
    public List<Student> getStudentNotOne(String one, String two) {
        return studentMapper.getStudentNotOne(one,two);
    }

    @Override
    public List<Student> getStudentNotAll() {
        return studentMapper.getStudentNotAll();
    }

    @Override
    public List<Score> getStudentScore() {
        return studentMapper.getStudentScore();
    }

    @Override
    public List<Student> getStudentTeacher(String teacher) {
        return studentMapper.getStudentTeacher(teacher);
    }
}
