package cn.coolbhu.sfexpress.service;

/**
 * Created by lcyanxi on 17-5-27.
 */
public interface AdminService {

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    int addUser(String username,String password);

    boolean isExistPhone(String Phone);
}
