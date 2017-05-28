package cn.coolbhu.sfexpress.service.serviceimpl;

import cn.coolbhu.sfexpress.dao.CartMapper;
import cn.coolbhu.sfexpress.dao.ProdutionMapper;
import cn.coolbhu.sfexpress.model.Cart;
import cn.coolbhu.sfexpress.model.Prodution;
import cn.coolbhu.sfexpress.service.CartService;
import cn.coolbhu.sfexpress.service.Constant;
import cn.coolbhu.sfexpress.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by brainy on 17-5-27.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProdutionMapper produtionMapper;

    @Override
    public List<Cart> getCartByUserId(String userId) {
        return cartMapper.selectCartByUserId(userId);
    }

    @Override
    public int addCart(String userid, String proid, Integer num) {

        //准备数据
        Cart cart = new Cart();
        Prodution prodution = produtionMapper.selectByPrimaryKey(proid);

        if (prodution == null) {

            return Constant.STATUS_CODE_FAILED;
        }

        //填充数据
        cart.setCartid(RandomUtils.randomId10());
        cart.setProid(proid);
        cart.setUserid(userid);
        cart.setNum(num);
        cart.setCartcreatetime(new Date());
        cart.setCartupdatetime(new Date());
        cart.setCartmark(Constant.MARK_CODE_OK);

        //计算小计
        Double total = num * prodution.getPrice();
        cart.setTotal(total);

        //添加到购物车
        return cartMapper.insert(cart);
    }
}
