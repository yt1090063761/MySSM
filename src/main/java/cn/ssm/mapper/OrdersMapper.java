package cn.ssm.mapper;

import cn.ssm.po.Orders;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {

    List<Orders> allorder2();

    int deleteByPrimaryKey(Integer oid);

    int insert(Orders record);

    int insertSelective(Orders record);



    Orders selectByPrimaryKey(Integer oid);



    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}