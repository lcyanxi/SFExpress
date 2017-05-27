package cn.coolbhu.sfexpress.service;

import cn.coolbhu.sfexpress.model.User;

/**
 * Created by lcyanxi on 17-5-27.
 */
public interface AdminService {

    /**
     * 注册
     *
     * @param username
     * @param password
     * @return
     */
    int addUser(String username, String password);

    boolean isExistPhone(String Phone);

    /**
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);
}
