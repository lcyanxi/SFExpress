package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    @ResponseBody
    public Map addUser(@RequestParam(value = "username") String username,
                       @RequestParam(value = "password") String password) {
        Map map = new HashMap();
        if (username == "" || username == null || password == "" || password == null) {
            map.put(Constant.STATUS, Constant.FAIL);
            map.put(Constant.MESSAGE, "用户名或者密码不能为空！");
            return map;
        }


        //判断电话号码是否存在
        if (adminService.isExistPhone(username)) {
            map.put(Constant.STATUS, Constant.FAIL);
            map.put(Constant.MESSAGE, "对不起，该电话号码已经注册了！");
            return map;
        }

        if (adminService.addUser(username, password) > 0) {
            map.put(Constant.STATUS, Constant.SUCCESS);
            map.put(Constant.MESSAGE, "恭喜你，注册成功！");

        } else {
            map.put(Constant.STATUS, Constant.FAIL);
            map.put(Constant.MESSAGE, "对不起，注册失败，请重新注册！");
        }


        return map;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model,
                        @RequestParam(value = "name") String name,
                        @RequestParam(value = "password") String password) {

        //判断参数是否为空
        if (name == null || name.equals("") || password == null || password.equals("")) {
            model.addAttribute(Constant.STATUS, Constant.STATUS_CODE_ERROR);
            model.addAttribute(Constant.MESSAGE, Constant.MESSAGE_STR_ERROR);
            return "login";
        }

        //构建登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {

                //设置 登录信息
                String principal = (String) subject.getPrincipal();
                session.setAttribute(Constant.USER_INFO, adminService.getUserByPhone(principal));

                return "redirect:/";
            }
        } catch (IncorrectCredentialsException e) {
            model.addAttribute(Constant.MESSAGE, "登录密码错误");
        } catch (ExcessiveAttemptsException e) {
            model.addAttribute(Constant.MESSAGE, "登录失败次数过多");
        } catch (LockedAccountException e) {
            model.addAttribute(Constant.MESSAGE, "帐号已被锁定");
        } catch (DisabledAccountException e) {
            model.addAttribute(Constant.MESSAGE, "帐号已被禁用");
        } catch (ExpiredCredentialsException e) {
            model.addAttribute(Constant.MESSAGE, "帐号已过期");
        } catch (UnknownAccountException e) {
            model.addAttribute(Constant.MESSAGE, "帐号不存在");
        } catch (UnauthorizedException e) {
            model.addAttribute(Constant.MESSAGE, "您没有得到相应的授权！");
        }

        model.addAttribute(Constant.STATUS, Constant.STATUS_CODE_SUCCESSED);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(Model model) {

        return "login";
    }
}