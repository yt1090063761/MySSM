package cn.ssm.service.impl;


import cn.ssm.mapper.UserMapper;
import cn.ssm.po.User;
import cn.ssm.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userImpl implements userService {
@Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findall() {
        //System.out.println("56556");
        //System.out.println(userMapper.findall().size());
        return userMapper.findall();
    }

    @Override
    public void deleteUserbyid(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> selectByName(String name) {
        return userMapper.selectByName(name);
    }

    public void addUser(User user){
        userMapper.addUser(user);
    }

    @Override
    public List<User> byidtouser(User user) {


        return userMapper.byid(user);
    }

    @Override
    public void update(User user) {

        userMapper.updateuser(user);
    }


}
