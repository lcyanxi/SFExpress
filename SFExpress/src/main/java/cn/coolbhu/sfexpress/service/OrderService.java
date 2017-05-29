package cn.coolbhu.sfexpress.service;


import cn.coolbhu.sfexpress.model.Order;
import cn.coolbhu.sfexpress.vo.OrderInfo;

import java.util.List;

/**
 * Created by brainy on 17-5-28.
 */
public interface OrderService {

    /**
     * 显示所有订单信息
     *
     * @param userid
     * @return
     */
    List<OrderInfo> showOrderInfo(String userid);

    /**
     * @param addid
     * @param cartids
     * @param userid
     * @return
     */
    Order addOrderByAddIdAndCartIds(String addid, String[] cartids, String userid);

    /**
     * @param orderid
     * @return
     */
    int payOrder(String orderid);
}
