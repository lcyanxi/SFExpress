package cn.coolbhu.sfexpress.service.serviceimpl;

import cn.coolbhu.sfexpress.dao.OrderMapper;
import cn.coolbhu.sfexpress.dao.ProinfoMapper;
import cn.coolbhu.sfexpress.service.OrderService;
import cn.coolbhu.sfexpress.vo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brainy on 17-5-28.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProinfoMapper proinfoMapper;

    @Override
    public List<OrderInfo> showOrderInfo(String userid) {


        List<OrderInfo> infoList=orderMapper.selectOrderInfo(userid);
        for (OrderInfo info:infoList){
           String orderId= info.getOrderid();
           List<String> listImg= proinfoMapper.selectByOrderId(orderId);

           info.setNum(listImg.size());
           info.setImg(listImg);

        }
        return infoList;
    }
}
