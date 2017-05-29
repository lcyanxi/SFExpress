package cn.coolbhu.sfexpress.dao;

import cn.coolbhu.sfexpress.model.Proinfo;
import cn.coolbhu.sfexpress.vo.ProImgInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProinfoMapper {
    int deleteByPrimaryKey(String proinfoid);

    int insert(Proinfo record);

    Proinfo selectByPrimaryKey(String proinfoid);

    List<Proinfo> selectAll();

    int updateByPrimaryKey(Proinfo record);

    List<ProImgInfo> selectByOrderId(@Param("orderid") String orderid);
}