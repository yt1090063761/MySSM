package cn.ssm.service;

import cn.ssm.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userService {
    public List<User> findall();
    public void deleteUserbyid( int id);

    public List<User> selectByName(String name);
    public void addUser(User user);
    public List<User> byidtouser(User user);

    public void update(User user);
}
