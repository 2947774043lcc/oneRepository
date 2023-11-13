package com.yuntu.service.impl;

import com.yuntu.entity.Student;
import com.yuntu.mapper.student.StudentMapper;
import com.yuntu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service.impl
 * @Author: Shuo
 * @CreateTime: 2023-10-19  14:06
 * @Description:
 * @Version: 1.0
 */
@Service("UserService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addStudents(List<Student> students) {
        return studentMapper.addStudents(students);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getTeacher(String t) {
        return studentMapper.getTeacher(t);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteStudent(String name) {
        Student student = studentMapper.getStudent(name);
        String sId = student.getS_id();
        int i = studentMapper.delStudent(sId);
        i+=studentMapper.delScore(sId);
        return i;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudentNoPass() {
        return studentMapper.getStudentNoPass();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudentThree() {
        return studentMapper.getStudentThree();
    }
}
