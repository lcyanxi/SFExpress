package cn.coolbhu.sfexpress.service.serviceimpl;

import cn.coolbhu.sfexpress.dao.UserMapper;
import cn.coolbhu.sfexpress.model.User;
import cn.coolbhu.sfexpress.service.AdminService;
import cn.coolbhu.sfexpress.service.Constant;
import cn.coolbhu.sfexpress.service.SecurityService;
import cn.coolbhu.sfexpress.util.ToolRandoms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by lcyanxi on 17-5-27.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(String username, String password) {

        Map map = securityService.encodePassword(password, username);
        //拿到加密过后的密码
        String newPassword = (String) map.get(SecurityService.ENCODE_RESULT_KEY_PASSWORD);

        User user = new User();
        user.setUserid(ToolRandoms.randomCode10());
        user.setUsername("顺丰优选");
        user.setPhone(username);
        user.setPassword(newPassword);
        user.setSlead(1);
        user.setUsercreatetime(new Date());
        user.setSlead(Constant.SLEAD_ALIVE);

        return userMapper.insert(user);
    }

    @Override
    public boolean isExistPhone(String Phone) {
        return userMapper.selectByPhone(Phone) == null ? false : true;
    }

    @Override
    public User getUserByPhone(String phone) {

        return userMapper.selectByPhone(phone);
    }

    @Override
    public int updateProfile(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
