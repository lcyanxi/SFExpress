package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.model.Address;
import cn.coolbhu.sfexpress.service.AddressService;
import cn.coolbhu.sfexpress.vo.AddInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lcyanxi on 17-5-27.
 */
@Controller
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 保存用户收货地址信息
     * @param addInfo
     * @return
     */
    @RequestMapping(value = "/saveaddress",method = RequestMethod.POST)
    @ResponseBody
    public Map saveAddress(AddInfo addInfo){
        System.out.print(addInfo);
        Map map=new HashMap();

        if (addressService.saveAddress(addInfo)>0){
            map.put(Constant.STATUS,Constant.SUCCESS);
            map.put(Constant.MESSAGE,"恭喜你，保存成功！");
        }else {
            map.put(Constant.MESSAGE,"对不起，保存失败！");
        }
        return map;
    }

    /**
     * 显示收货地址信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/showaddress")
    public String  showAddress(Model model){
        List<Address> list= addressService.showAddress();
        model.addAttribute("Addresslist",list);

        return "indent";
    }


}
