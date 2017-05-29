package cn.coolbhu.sfexpress.service.serviceimpl;

import cn.coolbhu.sfexpress.dao.ProinfoMapper;
import cn.coolbhu.sfexpress.model.Proinfo;
import cn.coolbhu.sfexpress.service.Constant;
import cn.coolbhu.sfexpress.service.ProinfoService;
import cn.coolbhu.sfexpress.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by brainy on 17-5-29.
 */
@Service
public class ProinfoServiceImpl implements ProinfoService {

    @Autowired
    private ProinfoMapper proinfoMapper;

    @Override
    public int addProinfoByProId(String orderid, String proid) {

        //初始化 商品信息
        Proinfo proinfo = new Proinfo();

        proinfo.setOrderid(orderid);
        proinfo.setProid(proid);
        proinfo.setProinfocreatetime(new Date());
        proinfo.setProinfoid(RandomUtils.randomId10());
        proinfo.setProinfomark(Constant.MARK_CODE_OK);

        //添加到数据库
        return proinfoMapper.insert(proinfo);
    }
}
