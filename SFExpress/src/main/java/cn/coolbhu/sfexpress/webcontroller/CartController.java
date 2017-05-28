package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.model.User;
import cn.coolbhu.sfexpress.service.CartService;
import cn.coolbhu.sfexpress.vo.CartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brainy on 17-5-27.
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController extends BaseController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/all")
    public String toCart(Model model) {

        //当前登录用户
        User user = (User) session.getAttribute(Constant.USER_INFO);

        //添加到model
        model.addAttribute(Constant.USER_INFO, user);

        //当前登录用户的所有购物车产品
        List<CartInfo> cartInfoList = cartService.getCartInfoByUserId(user.getUserid());
        model.addAttribute(Constant.MODEL_KEY_CART_INFOS, cartInfoList);

        Double total = cartService.countTotalByCartInfos(cartInfoList);
        model.addAttribute(Constant.MODEL_KEY_CART_TOTAL, String.format("%.2f", total));

        return "cart";
    }

    @RequestMapping(value = "/plus/{cartid}", method = RequestMethod.GET)
    public String plusCartNum(@PathVariable(value = "cartid") String cartid) {

        //添加数量
        int result = cartService.plusCartNumByCartId(cartid);

        return "redirect:/cart/all";
    }

    @RequestMapping(value = "/minus/{cartid}", method = RequestMethod.GET)
    public String minusCartNum(@PathVariable(value = "cartid") String cartid) {

        //添加数量
        int result = cartService.minusCartNumByCartId(cartid);

        return "redirect:/cart/all";
    }

    @RequestMapping(value = "/delete/{cartid}", method = RequestMethod.GET)
    public String deleteCart(Model model,
                             @PathVariable(value = "cartid") String cartid) {

        //删除g购物车商品
        int result = cartService.deleteCartByCartId(cartid);

        return "redirect:/cart/all";
    }

    @RequestMapping(value = "/addcart", method = RequestMethod.GET)
    @ResponseBody
    public Map addCart(@RequestParam(value = "proid") String proid,
                       @RequestParam(value = "num", defaultValue = "1", required = false) Integer num) {

        Map map = new HashMap();

        //当前登录用户
        User user = (User) session.getAttribute(Constant.USER_INFO);

        //判断是否登录
        if (user == null) {

            map.put(Constant.STATUS, Constant.STATUS_CODE_NOT_LOGIN);
            return map;
        }

        //添加商品到购物车
        int result = cartService.addCart(user.getUserid(), proid, num);

        map.put(Constant.STATUS, result);

        return map;
    }

    @RequestMapping(value = "/deleteall", method = RequestMethod.GET)
    public String deleteAll() {

        //删除所有
        int result = cartService.deleteAll();

        return "redirect:/cart/all";
    }

    @RequestMapping(value = "/deletechoose", method = RequestMethod.POST)
    public String deleteChoose(@RequestParam(value = "cartid", required = false) String[] cartids) {

        //删除选中的
        int result = cartService.deleteChoose(cartids);

        return "redirect:/cart/all";
    }
}
