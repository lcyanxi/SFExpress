package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.model.Address;
import cn.coolbhu.sfexpress.model.User;
import cn.coolbhu.sfexpress.service.AddressService;
import cn.coolbhu.sfexpress.service.CartService;
import cn.coolbhu.sfexpress.vo.CartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by brainy on 17-5-28.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/prepare", method = RequestMethod.POST)
    public String toPrepareOrder(Model model, @RequestParam(value = "cartid", required = false) String[] cartids) {

        //判断有没有选择商品
        if (cartids == null) {

            model.addAttribute(Constant.STATUS, Constant.STATUS_CODE_ERROR);
            model.addAttribute(Constant.MESSAGE, Constant.MESSAGE_STR_NULL_PARAM);

            return "redirect:/cart/all";
        }

        //拿到用户信息
        User user = (User) session.getAttribute(Constant.USER_INFO);
        model.addAttribute(Constant.USER_INFO, user);

        //拿到地址信息
        List<Address> addressList = addressService.getAddressByUserId(user.getUserid());
        model.addAttribute(Constant.MODEL_KEY_USER_ADDRESSES, addressList);

        //添加商品信息
        List<CartInfo> cartInfos = cartService.getCartInfoByCartIds(cartids);
        model.addAttribute(Constant.MODEL_KEY_CART_INFOS, cartInfos);

        //应付金额
        Double total = cartService.countTotalByCartInfos(cartInfos);
        model.addAttribute(Constant.MODEL_KEY_CART_TOTAL, total);

        return "indent";
    }


}
