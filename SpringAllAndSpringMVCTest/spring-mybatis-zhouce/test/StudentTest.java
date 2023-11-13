import com.yuntu.entity.Student;
import com.yuntu.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Shuo
 * @CreateTime: 2023-10-19  14:16
 * @Description:
 * @Version: 1.0
 */
public class StudentTest {
    @Test
    public void addStudentsTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("UserService", StudentService.class);
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("test01","licc","1991-09-02","男");
        Student student2 = new Student("test02","zcff","1999-09-02","女");
        Student student3 = new Student("test03","sxxx","2003-09-02","女");
        Student student4 = new Student("test04","zsss","2004-09-02","男");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        int i = studentServiceImpl.addStudents(students);
        System.out.println("成功添加"+i+"条数据");
    }


    @Test
    public void getTeacherTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("UserService", StudentService.class);
        List<Student> teacher = studentServiceImpl.getTeacher("张三");
        teacher.forEach(System.out::println);
        for (Student student : teacher) {
            System.out.println("学生ID:"+student.getS_id()+"学生姓名:"+student.getS_name()+",学生生日:"+student.getS_birth()
            +"老师姓名:"+student.getTeacher().getT_name()+",老师ID"+student.getTeacher().getT_id());
        }
    }

    @Test
    public void deleteStudentTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("UserService", StudentService.class);
        int i = studentServiceImpl.deleteStudent("zsss");
        System.out.println("成功删除"+i+"条数据");
    }

    @Test
    public void getStudentNoPassTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("UserService", StudentService.class);
        List<Student> studentNoPass = studentServiceImpl.getStudentNoPass();
        System.out.println("询两门及其以上不及格课程的同学的学号，姓名及其平均成绩是:");
        for (Student noPass : studentNoPass) {
            System.out.println(noPass.getS_name()+"\t"+noPass.getS_id()+"\t"+noPass.getAvg());
        }
    }

    @Test
    public void getStudentThreeTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("UserService", StudentService.class);
        List<Student> studentNoPass = studentServiceImpl.getStudentThree();
        for (Student noPass : studentNoPass) {
            System.out.println("课程"+noPass.getC_name()+"的第"+noPass.getThree()+"名是"+noPass.getS_name());
        }
    }
}
