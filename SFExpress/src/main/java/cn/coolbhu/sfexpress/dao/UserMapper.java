package cn.coolbhu.sfexpress.dao;

import cn.coolbhu.sfexpress.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    User selectByPrimaryKey(String userid);


    List<User> selectAll();

    int updateByPrimaryKey(User record);


    User selectByPhone(@Param("phone") String phone);
}