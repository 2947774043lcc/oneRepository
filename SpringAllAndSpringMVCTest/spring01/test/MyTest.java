import com.yuntu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Shuo
 * @CreateTime: 2023-09-20  09:07
 * @Description:
 * @Version: 1.0
 */
public class MyTest {
    @Test
    public void getUserListTest(){
        /*通过配置文件获取Spring的上下文对象(Spring容器)*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        userService.getUserList();
    }
    @Test
    public void getUsertest(){
        /*通过配置文件获取Spring的上下文对象(Spring容器)*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user.toString());
    }
}
