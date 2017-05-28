package cn.coolbhu.sfexpress.dao;

import cn.coolbhu.sfexpress.model.Cart;
import cn.coolbhu.sfexpress.vo.CartInfo;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(String cartid);

    int insert(Cart record);

    Cart selectByPrimaryKey(String cartid);

    List<Cart> selectAll();

    int updateByPrimaryKey(Cart record);

    /**
     * @param userid
     * @return
     */
    List<Cart> selectCartByUserId(String userid);

    /**
     * @param userid
     * @return
     */
    List<CartInfo> selectCartInfoByUserId(String userid);

    /**
     * @return
     */
    int deleteAll();
}