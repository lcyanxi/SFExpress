package cn.coolbhu.sfexpress.dao;

import cn.coolbhu.sfexpress.model.proinfo;
import java.util.List;

public interface proinfoMapper {
    int deleteByPrimaryKey(String proinfoid);

    int insert(proinfo record);

    proinfo selectByPrimaryKey(String proinfoid);

    List<proinfo> selectAll();

    int updateByPrimaryKey(proinfo record);
}