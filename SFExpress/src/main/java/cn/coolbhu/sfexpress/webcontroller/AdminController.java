package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.service.AdminService;
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
@RequestMapping(value = "/user")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/adduser" ,method = RequestMethod.POST)
    @ResponseBody
    public Map addUser(@RequestParam(value = "username")String username,
                       @RequestParam(value = "password")String password){
        Map map=new HashMap();
        if (username==""||username==null||password==""||password==null){
            map.put(Constant.STATUS,Constant.FAIL);
            map.put(Constant.MESSAGE,"用户名或者密码不能为空！");
            return map;
        }


        //判断电话号码是否存在
        if (adminService.isExistPhone(username)){
            map.put(Constant.STATUS,Constant.FAIL);
            map.put(Constant.MESSAGE,"对不起，该电话号码已经注册了！");
            return map;
        }

        if (adminService.addUser(username,password)>0){
            map.put(Constant.STATUS,Constant.SUCCESS);
            map.put(Constant.MESSAGE,"恭喜你，注册成功！");

        }else {
            map.put(Constant.STATUS,Constant.FAIL);
            map.put(Constant.MESSAGE,"对不起，注册失败，请重新注册！");
        }


        return map;
    }
}
