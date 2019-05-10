package cn.ssm.controller;

import cn.ssm.po.Orders;
import cn.ssm.service.ordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class order {
    @Autowired
private cn.ssm.service.ordersService ordersService;
    @RequestMapping("allorder")
    public ModelAndView allorder(Model model){


        Map<String,List<Orders>> map=new HashMap<>();
        System.out.println(ordersService.allorder().size());
        map.put("order",ordersService.allorder());
        return new ModelAndView("orders",map);
    }
}
