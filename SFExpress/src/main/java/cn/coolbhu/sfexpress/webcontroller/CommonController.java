package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.model.Cart;
import cn.coolbhu.sfexpress.model.User;
import cn.coolbhu.sfexpress.service.CartService;
import cn.coolbhu.sfexpress.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by brainy on 17-5-27.
 */
@Controller
@RequestMapping(value = "/")
public class CommonController extends BaseController {

    @Autowired
    private ProductionService productionService;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = {"/", "index"})
    public String index(Model model) {

        //将登录用户的信息拿到
        User user = (User) session.getAttribute(Constant.USER_INFO);

        if (user != null) {

            //购物车数量
            List<Cart> cartList = cartService.getCartByUserId(user.getUserid());
            model.addAttribute(Constant.CART_NUM, cartList.size());

            session.setAttribute(Constant.CART_NUM, cartList.size());

            model.addAttribute(Constant.USER_INFO, user);
        } else {

            model.addAttribute(Constant.CART_NUM, 0);
        }

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
    public String toCart() {
        return "cart";
    }

    @RequestMapping(value = "toeditprofile")
    public String toEditProfile(Model model){
        model.addAttribute(Constant.CART_NUM,session.getAttribute(Constant.CART_NUM));
        return "editprofile";
    }
}
