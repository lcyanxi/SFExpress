package cn.coolbhu.sfexpress.dao;

import cn.coolbhu.sfexpress.model.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(String addid);

    int insert(Address record);

    Address selectByPrimaryKey(String addid);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);

    /**
     * @param userid
     * @return
     */
    List<Address> selectByUserId(String userid);
}