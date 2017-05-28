package cn.coolbhu.sfexpress;

import cn.coolbhu.sfexpress.service.CartService;
import cn.coolbhu.sfexpress.vo.CartInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by brainy on 17-5-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class CartTest {

    @Autowired
    private CartService cartService;

    @Test
    public void getAllCartInfoTest() {

        //用于Id
        String userid = "2017919382";

        List<CartInfo> cartInfos = cartService.getCartInfoByUserId(userid);

        Assert.assertNotNull(cartInfos);
    }
}
