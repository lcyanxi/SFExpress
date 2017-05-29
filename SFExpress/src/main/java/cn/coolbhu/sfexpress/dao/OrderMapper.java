package cn.coolbhu.sfexpress.dao;

import cn.coolbhu.sfexpress.model.Order;
import cn.coolbhu.sfexpress.vo.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Order record);

    Order selectByPrimaryKey(String orderid);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    List<OrderInfo> selectOrderInfo(@Param("uerid") String userid);
}