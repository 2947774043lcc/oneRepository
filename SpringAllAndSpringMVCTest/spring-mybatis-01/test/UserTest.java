import com.yuntu.entity.User;
import com.yuntu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Shuo
 * @CreateTime: 2023-10-10  15:44
 * @Description:
 * @Version: 1.0
 */
public class UserTest {

    @Test
    public void userTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");

        User user = (User) applicationContext.getBean("user");
        List<User> userList = userService.getUserList(user);
        userList.forEach(System.out::println);
    }
    @Test
    public void userTest2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");

        User user = (User) applicationContext.getBean("user");
        List<User> userList = userService.getUserList(user);
        userList.forEach(System.out::println);
    }
    @Test
    public void userTest3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring3.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");

        User user = (User) applicationContext.getBean("user");
        List<User> userList = userService.getUserList(user);
        userList.forEach(System.out::println);
    }
}
