package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by brainy on 17-5-27.
 */
@Controller
@RequestMapping(value = "/")
public class CommonController extends BaseController {

    @Autowired
    private ProductionService productionService;

    @RequestMapping(value = {"/", "index"})
    public String index(Model model) {

        //将登录用户的信息拿到
        model.addAttribute(Constant.USER_INFO, session.getAttribute(Constant.USER_INFO));

        //添加所有的商品
        model.addAttribute(Constant.MODEL_KEY_PRODUCTIONS, productionService.getAllProduction());

        return "index";
    }

    @RequestMapping(value = "register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping(value = "login")
    public String toLogin() {
        return "login";
    }
    @RequestMapping(value = "tocart")
    public String toCart(){
        return "cart";
    }
}
