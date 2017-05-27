package cn.coolbhu.sfexpress.dao;

import cn.coolbhu.sfexpress.model.Cart;
import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(String cartid);

    int insert(Cart record);

    Cart selectByPrimaryKey(String cartid);

    List<Cart> selectAll();

    int updateByPrimaryKey(Cart record);
}