package cn.coolbhu.sfexpress.service.serviceimpl;

import cn.coolbhu.sfexpress.dao.AddressMapper;
import cn.coolbhu.sfexpress.model.Address;
import cn.coolbhu.sfexpress.service.AddressService;
import cn.coolbhu.sfexpress.service.Constant;
import cn.coolbhu.sfexpress.util.RandomUtils;
import cn.coolbhu.sfexpress.util.ToolRandoms;
import cn.coolbhu.sfexpress.vo.AddInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lcyanxi on 17-5-28.
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public int saveAddress(AddInfo addInfo) {

        Address address = new Address();
        address.setUserid("2017962448");
        address.setAddid(ToolRandoms.randomCode10());
        address.setAddcreatetime(new Date());
        address.setAddname(addInfo.getName());
        address.setAddphone(addInfo.getPhone());
        address.setAddress(addInfo.getAddress());
        address.setDetailaddress(addInfo.getDetail());

        return addressMapper.insert(address);
    }

    @Override
    public List<Address> getAddressByUserId(String userid) {
        return addressMapper.selectByUserId(userid);
    }

    @Override
    public String addAddress(String userid, String addname, String address, String detailaddress, String addphone) {

        //准备  数据
        Address add = new Address();

        //
        add.setAddid(RandomUtils.randomId10());
        add.setAddcreatetime(new Date());
        add.setAddmark(Constant.MARK_CODE_OK);

        //田聪
        add.setUserid(userid);
        add.setAddname(addname);
        add.setAddress(address);
        add.setDetailaddress(detailaddress);
        add.setAddphone(addphone);

        //插入
        int result = addressMapper.insert(add);

        if (result > 0) {
            return add.getAddid();
        } else {

            return null;
        }
    }
}
