package cn.coolbhu.sfexpress.webcontroller;

/**
 * Created by brainy on 17-5-27.
 */
public interface Constant {

    /**
     * 多个商品
     */
    String MODEL_KEY_PRODUCTIONS = "productions";

    /**
     * 购物车产品
     */
    String MODEL_KEY_CARTS = "carts";

    /**
     * 购物车信息
     */
    String MODEL_KEY_CART_INFOS = "cartinfos";

    /**
     * 商品总计
     */
    String MODEL_KEY_CART_TOTAL = "total";

    /**
     * 状态
     */
    String STATUS = "status";

    /**
     * 消息
     */
    String MESSAGE = "message";

    /**
     * 成功
     */
    String SUCCESS = "1";

    /**
     * 失败
     */
    String FAIL = "0";

    /**
     * 错误
     */
    int STATUS_CODE_ERROR = -1;

    /**
     * 成功
     */
    int STATUS_CODE_SUCCESSED = 1;

    /**
     * 错误信息
     */
    String MESSAGE_STR_ERROR = "错误";

    /**
     * 登录用户信息
     */
    String USER_INFO = "userinfo";

    /**
     * 未登录
     */
    int STATUS_CODE_NOT_LOGIN = -2;

    /**
     * 购物车数量
     */
    String CART_NUM = "cartnum";
}
