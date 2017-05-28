package cn.coolbhu.sfexpress;

import cn.coolbhu.sfexpress.model.User;
import cn.coolbhu.sfexpress.service.AdminService;
import cn.coolbhu.sfexpress.util.ToolRandoms;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by lcyanxi on 17-5-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class AdminTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void Random10Test() {
        System.out.println(ToolRandoms.randomCode10());
    }

    @Test
    public void addUserTest() {

        String username = "13378185190";
        String password = "12345678";

        int result = adminService.addUser(username, password);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void loginTest() {

        User user = adminService.getUserByPhone("13378185190");

        Assert.assertNotNull(user);
    }
}
