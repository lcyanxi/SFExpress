package cn.coolbhu.sfexpress;

import cn.coolbhu.sfexpress.dao.OrderMapper;
import cn.coolbhu.sfexpress.model.Order;
import cn.coolbhu.sfexpress.service.OrderService;
import cn.coolbhu.sfexpress.util.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

/**
 * Created by brainy on 17-5-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class OrderTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void addOrderTest() {

        String userid = "2017966196";
        String addid = "1292445190";
        String cartid = "4292416838";

        Order order = new Order();

        order.setAddid(addid);
        order.setTotalprice(13.0);
        order.setUserid(userid);
        order.setOrdermark(1);
        order.setPaymark(1);
        order.setOrderid(RandomUtils.randomId10());
        order.setOrdercreatetime(new Date());

        int result = orderMapper.insert(order);

        Assert.assertEquals(result, 1);
    }
}
