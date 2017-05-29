package cn.coolbhu.sfexpress.service;

import cn.coolbhu.sfexpress.model.Cart;
import cn.coolbhu.sfexpress.vo.CartInfo;

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
    Cart addCart(String userid, String proid, Integer num);

    /**
     * @param userId
     * @return
     */
    List<CartInfo> getCartInfoByUserId(String userId);

    /**
     * @param cartid
     * @return
     */
    int deleteCartByCartId(String cartid);

    /**
     * @param cartid
     * @return
     */
    int plusCartNumByCartId(String cartid);

    /**
     * @param cartid
     * @return
     */
    int minusCartNumByCartId(String cartid);

    /**
     * @param cartInfos
     * @return
     */
    Double countTotalByCartInfos(List<CartInfo> cartInfos);

    /**
     * @return
     */
    int deleteAll();

    /**
     * @param cartids
     * @return
     */
    int deleteChoose(String[] cartids);

    /**
     * @param cartids
     * @return
     */
    List<CartInfo> getCartInfoByCartIds(String[] cartids);
}
