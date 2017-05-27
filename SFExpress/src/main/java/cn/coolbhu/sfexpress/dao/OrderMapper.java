package cn.coolbhu.sfexpress.dao;

import cn.coolbhu.sfexpress.model.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Order record);

    Order selectByPrimaryKey(String orderid);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}