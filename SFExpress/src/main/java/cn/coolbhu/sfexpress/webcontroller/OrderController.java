package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.model.Address;
import cn.coolbhu.sfexpress.model.Cart;
import cn.coolbhu.sfexpress.model.Order;
import cn.coolbhu.sfexpress.model.User;
import cn.coolbhu.sfexpress.service.AddressService;
import cn.coolbhu.sfexpress.service.CartService;
import cn.coolbhu.sfexpress.service.OrderService;
import cn.coolbhu.sfexpress.vo.CartInfo;
import cn.coolbhu.sfexpress.vo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    private OrderService orderService;

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
        model.addAttribute(Constant.MODEL_KEY_CART_TOTAL, String.format("%.2f", total));

        return "indent";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrder(Model model,
                              @RequestParam(value = "addid") String addid,
                              @RequestParam(value = "cartid") String[] cartids) {

        //当前登录用户
        User user = (User) session.getAttribute(Constant.USER_INFO);
        model.addAttribute(Constant.USER_INFO, user);

        //判断是否登录
        if (user == null) {

            model.addAttribute(Constant.STATUS, Constant.STATUS_CODE_NOT_LOGIN);
            return "indent";
        }

        //添加订单
        Order result = orderService.addOrderByAddIdAndCartIds(addid, cartids, user.getUserid());

        if (result != null) {

            model.addAttribute(Constant.STATUS, Constant.STATUS_CODE_SUCCESSED);
            model.addAttribute(Constant.MESSAGE, "订单添加成功！");

            //删除购物车
            cartService.deleteChoose(cartids);

            //应付金额
            model.addAttribute(Constant.MODEL_KEY_CART_TOTAL, String.format("%.2f", result.getTotalprice()));

            model.addAttribute(Constant.MODEL_KEY_ORDER, result);

            return "order";
        } else {

            model.addAttribute(Constant.STATUS, Constant.STATUS_CODE_ERROR);
            model.addAttribute(Constant.MESSAGE, "订单添加失败!");

            return "indent";
        }
    }

    @RequestMapping(value = "/payment/{orderid}", method = RequestMethod.GET)
    public String payment(@PathVariable(value = "orderid") String orderid) {

        //更新
        orderService.payOrder(orderid);

        return "redirect:/order/showorderinfo";
    }

    @RequestMapping(value = "/fastbuy", method = RequestMethod.POST)
    public String fastBuy(Model model,
                          @RequestParam(value = "num") Integer num,
                          @RequestParam(value = "proid") String proid) {

        //当前登录用户
        User user = (User) session.getAttribute(Constant.USER_INFO);
        model.addAttribute(Constant.USER_INFO, user);

        //判断是否登录
        if (user == null) {

            model.addAttribute(Constant.STATUS, Constant.STATUS_CODE_NOT_LOGIN);
            return "redirect:/pro/" + proid;
        }

        //添加头购物车
        Cart cart = cartService.addCart(user.getUserid(), proid, num);

        //拿到地址信息
        List<Address> addressList = addressService.getAddressByUserId(user.getUserid());
        model.addAttribute(Constant.MODEL_KEY_USER_ADDRESSES, addressList);

        //添加商品信息
        List<CartInfo> cartInfos = cartService.getCartInfoByCartIds(new String[]{cart.getCartid()});
        model.addAttribute(Constant.MODEL_KEY_CART_INFOS, cartInfos);

        //应付金额
        Double total = cartService.countTotalByCartInfos(cartInfos);
        model.addAttribute(Constant.MODEL_KEY_CART_TOTAL, String.format("%.2f", total));

        return "indent";
    }

    @RequestMapping(value = "showorderinfo" ,method = RequestMethod.GET)
    public String showOrderInfo(Model model){

        //显示个人信息
        User user=(User) session.getAttribute(Constant.USER_INFO);

        if (user==null){
            //重定向到 login
            return "redirect:/user/login";
        }
        //显示订单信息
        List<OrderInfo> orderInfos=orderService.showOrderInfo(user.getUserid());

        int cartNum=(int)session.getAttribute(Constant.CART_NUM);
        model.addAttribute(Constant.ODERINFO_LIST,orderInfos);
        model.addAttribute(Constant.USER_INFO,user);
        model.addAttribute(Constant.CART_NUM,cartNum);

        return "orderinfo";
    }
}
