package cn.coolbhu.sfexpress.service;

import cn.coolbhu.sfexpress.model.Order;

/**
 * Created by brainy on 17-5-28.
 */
public interface OrderService {

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
