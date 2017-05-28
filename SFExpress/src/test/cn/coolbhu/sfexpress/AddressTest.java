package cn.coolbhu.sfexpress;

import cn.coolbhu.sfexpress.service.AddressService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by brainy on 17-5-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class AddressTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void addAddressTest() {

        String userid = "2017919382";

        int result = 0;

        for (int i = 0; i < 2; i++) {

            String addname = "孙晓聪" + i;
            String addphone = "13378185190";
            String address = "吉林省 吉林市 龙潭区";
            String detailaddress = "北华大学北校区";

            result += addressService.addAddress(userid, addname, address, detailaddress, addphone);
        }

        Assert.assertEquals(result, 2);
    }
}
