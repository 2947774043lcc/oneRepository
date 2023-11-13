import com.yuntu.entity.Score;
import com.yuntu.entity.Student;
import com.yuntu.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Shuo
 * @CreateTime: 2023-10-16  14:54
 * @Description:
 * @Version: 1.0
 */
public class StudentTest {
    @Test
    public void getStudentAllScoreTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("studentService", StudentService.class);
        List<Student> studentAllScore = studentServiceImpl.getStudentAllScore();
        studentAllScore.forEach(System.out::println);
    }
    @Test
    public void getStudentOneMaxTwoTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("studentService", StudentService.class);
        List<Student> studentAllScore = studentServiceImpl.getStudentOneMaxTwo("数学","英语");
        studentAllScore.forEach(System.out::println);
    }
    @Test
    public void getStudentNotOneTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("studentService", StudentService.class);
        List<Student> studentAllScore = studentServiceImpl.getStudentNotOne("数学","英语");
        studentAllScore.forEach(System.out::println);
    }

    @Test
    public void getStudentNotAllTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("studentService", StudentService.class);
        List<Student> studentAllScore = studentServiceImpl.getStudentNotAll();
        studentAllScore.forEach(System.out::println);
    }
    @Test
    public void getStudentScoreTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("studentService", StudentService.class);
        List<Score> studentAllScore = studentServiceImpl.getStudentScore();
        studentAllScore.forEach(System.out::println);
    }
    @Test
    public void getStudentTeacherTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentServiceImpl = applicationContext.getBean("studentService", StudentService.class);
        List<Student> studentAllScore = studentServiceImpl.getStudentTeacher("张三");
        studentAllScore.forEach(System.out::println);
    }
}
