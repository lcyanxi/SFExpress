package cn.coolbhu.sfexpress.service.serviceimpl;

import cn.coolbhu.sfexpress.dao.CartMapper;
import cn.coolbhu.sfexpress.dao.ProdutionMapper;
import cn.coolbhu.sfexpress.model.Cart;
import cn.coolbhu.sfexpress.model.Prodution;
import cn.coolbhu.sfexpress.service.CartService;
import cn.coolbhu.sfexpress.service.Constant;
import cn.coolbhu.sfexpress.util.RandomUtils;
import cn.coolbhu.sfexpress.vo.CartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Cart addCart(String userid, String proid, Integer num) {

        //准备数据
        Cart cart = new Cart();
        Prodution prodution = produtionMapper.selectByPrimaryKey(proid);

        if (prodution == null) {

            return null;
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
        int reuslt = cartMapper.insert(cart);

        if (reuslt > 0) {

            return cart;
        } else {

            return null;
        }
    }

    @Override
    public List<CartInfo> getCartInfoByUserId(String userId) {

        return cartMapper.selectCartInfoByUserId(userId);
    }

    @Override
    public int deleteCartByCartId(String cartid) {
        return cartMapper.deleteByPrimaryKey(cartid);
    }

    @Override
    public int plusCartNumByCartId(String cartid) {

        Cart cart = cartMapper.selectByPrimaryKey(cartid);

        if (cart != null) {

            Double price = cart.getTotal() / cart.getNum();

            cart.setNum(cart.getNum() + 1);

            cart.setTotal(cart.getNum() * price);

            //更新
            cartMapper.updateByPrimaryKey(cart);
        }

        return -1;
    }

    @Override
    public int minusCartNumByCartId(String cartid) {

        Cart cart = cartMapper.selectByPrimaryKey(cartid);

        if (cart != null) {

            Double price = cart.getTotal() / cart.getNum();

            cart.setNum(cart.getNum() - 1);

            //删除
            if (cart.getNum() <= 0) {

                cartMapper.deleteByPrimaryKey(cart.getCartid());
            } else {

                cart.setTotal(cart.getNum() * price);

                //更新
                cartMapper.updateByPrimaryKey(cart);
            }

            return 1;
        }

        return -1;
    }

    @Override
    public Double countTotalByCartInfos(List<CartInfo> cartInfos) {

        Double total = 0.00;

        //算总计
        for (CartInfo cartInfo : cartInfos) {

            total += cartInfo.getTotal();
        }

        return total;
    }

    @Override
    public int deleteAll() {
        return cartMapper.deleteAll();
    }

    @Override
    public int deleteChoose(String[] cartids) {

        for (int i = 0; i < cartids.length; i++) {

            while (cartMapper.deleteByPrimaryKey(cartids[i]) > 0) ;
        }

        return cartids.length;
    }

    @Override
    public List<CartInfo> getCartInfoByCartIds(String[] cartids) {

        List<CartInfo> cartInfos = new ArrayList<>();

        for (String cartid : cartids) {

            CartInfo cartInfo = cartMapper.selectCartInfoByCartId(cartid);

            if (cartid != null) {

                cartInfos.add(cartInfo);
            }
        }

        return cartInfos;
    }
}
