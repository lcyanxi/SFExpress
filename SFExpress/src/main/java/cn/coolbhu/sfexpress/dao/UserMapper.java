package cn.coolbhu.sfexpress.dao;

import cn.coolbhu.sfexpress.model.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    User selectByPrimaryKey(String userid);

    User selectByPhone(String phone);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}