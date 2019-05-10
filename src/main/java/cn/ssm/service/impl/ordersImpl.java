package cn.ssm.service.impl;

import cn.ssm.mapper.OrdersMapper;
import cn.ssm.po.Orders;
import cn.ssm.service.ordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ordersImpl implements ordersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<Orders> allorder() {

        return ordersMapper.allorder2();
    }
}
