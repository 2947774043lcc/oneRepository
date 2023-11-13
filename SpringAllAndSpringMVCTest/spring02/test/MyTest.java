import com.yuntu.entity.User;
import com.yuntu.service.UserService;
import com.yuntu.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Shuo
 * @CreateTime: 2023-09-25  10:41
 * @Description:
 * @Version: 1.0
 */
public class MyTest {
    @Test
    public void userTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object userBean = applicationContext.getBean("userBean");
        Object userBean1 = applicationContext.getBean("userBean1");
        Object student = applicationContext.getBean("student");
        System.out.println(userBean.toString());
        System.out.println(userBean1.toString());
        System.out.println(student.toString());
    }
    @Test
    public void userTest1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        userService.getUserList();
        User userBean = (User) applicationContext.getBean("user");
        System.out.println(userBean.toString());

    }
}
