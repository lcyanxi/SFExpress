package cn.coolbhu.sfexpress.service;

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
    int addOrderByAddIdAndCartIds(String addid, String[] cartids, String userid);
}
