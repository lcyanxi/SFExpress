package cn.coolbhu.sfexpress.service;

/**
 * Created by brainy on 17-5-29.
 */
public interface ProinfoService {

    /**
     * @param orderid
     * @param proid
     * @return
     */
    int addProinfoByProId(String orderid, String proid);
}
