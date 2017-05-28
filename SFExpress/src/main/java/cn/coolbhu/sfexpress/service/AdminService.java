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

    /**
     * 判断电话号码是否存在
     * @param Phone
     * @return
     */
    boolean isExistPhone(String Phone);

    /**
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);


    /**
     * 更新个人信息
     * @param user
     * @return
     */
    int updateProfile(User user);



}
