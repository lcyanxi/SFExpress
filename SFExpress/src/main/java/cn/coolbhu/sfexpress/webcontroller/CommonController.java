package cn.coolbhu.sfexpress.webcontroller;

import cn.coolbhu.sfexpress.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by brainy on 17-5-27.
 */
@Controller
@RequestMapping(value = "/")
public class CommonController {

    @Autowired
    private ProductionService productionService;

    @RequestMapping(value = {"/", "index"})
    public String index(Model model) {

        //添加所有的商品
        model.addAttribute(Constant.MODEL_KEY_PRODUCTIONS, productionService.getAllProduction());

        return "index";
    }
}
