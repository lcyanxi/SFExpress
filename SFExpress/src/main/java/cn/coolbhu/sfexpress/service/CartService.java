package cn.coolbhu.sfexpress.service;

import cn.coolbhu.sfexpress.model.Cart;

import java.util.List;

/**
 * Created by brainy on 17-5-27.
 */
public interface CartService {

    /**
     * @param userId
     * @return
     */
    List<Cart> getCartByUserId(String userId);

    /**
     * @param userid
     * @param proid
     * @param num
     * @return
     */
    int addCart(String userid, String proid, Integer num);
}
