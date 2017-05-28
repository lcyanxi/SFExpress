package cn.coolbhu.sfexpress.service.serviceimpl;

import cn.coolbhu.sfexpress.dao.AddressMapper;
import cn.coolbhu.sfexpress.model.Address;
import cn.coolbhu.sfexpress.service.AddressService;
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

        Address address=new Address();
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
    public List<Address> showAddress() {
        List<Address> list=  addressMapper.selectAll();
        return list;
    }
}
