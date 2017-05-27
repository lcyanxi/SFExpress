package cn.coolbhu.sfexpress.service.serviceimpl;

import cn.coolbhu.sfexpress.dao.ProdutionMapper;
import cn.coolbhu.sfexpress.model.Prodution;
import cn.coolbhu.sfexpress.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brainy on 17-5-27.
 */
@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProdutionMapper produtionMapper;

    @Override
    public List<Prodution> getAllProduction() {
        return produtionMapper.selectAll();
    }
}
