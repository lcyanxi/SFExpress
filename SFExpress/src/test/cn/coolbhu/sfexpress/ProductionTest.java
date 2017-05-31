package cn.coolbhu.sfexpress;

import cn.coolbhu.sfexpress.dao.ProdutionMapper;
import cn.coolbhu.sfexpress.model.Prodution;
import cn.coolbhu.sfexpress.util.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by brainy on 17-5-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class ProductionTest {

    @Autowired
    private ProdutionMapper produtionMapper;

    @Test
    public void productionTest() {

        //生成100个商品
        for (int i = 1; i <= 8; i++) {

            //准备数据
            Prodution prodution = new Prodution();
            prodution.setProid(RandomUtils.randomId10());
            prodution.setProname("商品" + i);
            prodution.setPrice(Math.abs(RandomUtils.random.nextInt()%100000) / 100.0);
            prodution.setDetail("详情" + i);
            prodution.setImg("rou" + i);
            prodution.setPromark(1);

            //添加
            produtionMapper.insert(prodution);
        }
    }
}
