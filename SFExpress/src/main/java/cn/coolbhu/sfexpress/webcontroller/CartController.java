package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by brainy on 17-5-27.
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/all")
    public String toCart(Model model) {

        String userid = "userid";

        //当前登录用户的所有购物车产品
        model.addAttribute(Constant.MODEL_KEY_CARTS, cartService.getCartByUserId(userid));

        return "cart";
    }
}
