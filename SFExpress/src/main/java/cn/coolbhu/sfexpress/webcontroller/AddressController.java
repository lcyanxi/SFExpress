package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.model.User;
import cn.coolbhu.sfexpress.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcyanxi on 17-5-27.
 */
@Controller
@RequestMapping(value = "/address")
public class AddressController extends BaseController {
    @Autowired
    private AddressService addressService;


    @RequestMapping(value = "/addaddress", method = RequestMethod.POST)
    @ResponseBody
    public Map saveAddress(@RequestParam(value = "addname") String addname,
                           @RequestParam(value = "addphone") String addphone,
                           @RequestParam(value = "address") String address,
                           @RequestParam(value = "detailaddress") String detailaddress) {

        //准备数据
        Map map = new HashMap();

        //用户登录信息
        User user = (User) session.getAttribute(Constant.USER_INFO);

        //未登录
        if (user == null) {

            map.put(Constant.STATUS, Constant.STATUS_CODE_NOT_LOGIN);

            return map;
        }

        //添加地址
        String result = addressService.addAddress(user.getUserid(), addname, address, detailaddress, addphone);

        if (result != null) {

            map.put(Constant.STATUS, Constant.STATUS_CODE_SUCCESSED);

            map.put(Constant.MODEL_KEY_ADDRESS_ADDID, result);
            map.put(Constant.MODEL_KEY_ADDRESS_ADDNAME, addname);
            map.put(Constant.MODEL_KEY_ADDRESS_ADDPHONE, addphone);
            map.put(Constant.MODEL_KEY_ADDRESS_ADDRESS, address);
        } else {

            map.put(Constant.STATUS, Constant.STATUS_CODE_ERROR);
        }

        return map;
    }

}
