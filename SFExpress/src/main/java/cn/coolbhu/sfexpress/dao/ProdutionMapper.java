package cn.coolbhu.sfexpress.dao;

import cn.coolbhu.sfexpress.model.Prodution;
import java.util.List;

public interface ProdutionMapper {
    int deleteByPrimaryKey(String proid);

    int insert(Prodution record);

    Prodution selectByPrimaryKey(String proid);

    List<Prodution> selectAll();

    int updateByPrimaryKey(Prodution record);
}