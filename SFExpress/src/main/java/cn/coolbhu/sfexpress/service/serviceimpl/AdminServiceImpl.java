package cn.coolbhu.sfexpress.service.serviceimpl;

import cn.coolbhu.sfexpress.model.User;
import cn.coolbhu.sfexpress.service.AdminService;
import cn.coolbhu.sfexpress.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by lcyanxi on 17-5-27.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private SecurityService securityService;
    @Override
    public int addUser(String username, String password) {

        Map map=securityService.encodePassword(password,username);
        //拿到加密过后的密码
        String newPassword=(String) map.get(SecurityService.ENCODE_RESULT_KEY_PASSWORD);

        User user=new User();
        user.setPhone(username);
        user.setPassword(newPassword);
        return 0;
    }
}
