import com.yuntu.entity.User;
import com.yuntu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Shuo
 * @CreateTime: 2023-10-18  09:06
 * @Description:
 * @Version: 1.0
 */
public class MyTest {
    @Test
    public void TranTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        UserService userService = applicationContext.getBean("UserService", UserService.class);
        User user = new User();
        user.setCode("9567");
        user.setUserName("张三");
        user.setUserPassword("123456");
        userService.tranTest(user,10);

    }

}
