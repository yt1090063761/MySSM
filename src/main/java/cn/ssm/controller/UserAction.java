package cn.ssm.controller;

import cn.ssm.po.User;
import cn.ssm.service.userService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserAction {

    @Autowired
    private cn.ssm.service.userService userService;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public cn.ssm.service.userService getUserService() {
        return userService;
    }

    public void setUserService(cn.ssm.service.userService userService) {
        this.userService = userService;
    }

    @RequestMapping("addUser")
    public String adduser() {
        System.out.println("跳转到添加页面");
        return "addUser";
    }

    @RequestMapping(value = "postUser", method = RequestMethod.POST)
    public String putUser(User user) {

        userService.addUser(user);
        return "redirect:index.action";
    }


    @RequestMapping(value = "put/{id}/postUser", method = RequestMethod.GET)
    public String postUser(@PathVariable("id") int id, User user1) {
        System.out.println(user1.getUsername());
        System.out.println(id);
        //   userService.addUser(user);
        return "";
    }

    @RequestMapping(value = "put/postUser", method = RequestMethod.GET)
    public String postUser1(@RequestParam("id") int id) {
        System.out.println(id);
        //   userService.addUser(user);
        return "";
    }

    //跳转修改页面
    @RequestMapping(value = "updateUser", method = RequestMethod.GET)
    public ModelAndView updateuser(User user) {

        List<User> ulist = userService.byidtouser(user);
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("");
        //System.out.println("sasa");
        modelAndView.addObject("user1", ulist.get(0));

        return modelAndView;
    }

    @RequestMapping(value = "updateUser1", method = RequestMethod.POST)
    public void update(User user, HttpServletResponse response) {
        System.out.println("修改");
        System.out.println(user.getName());
        userService.update(user);
        try {
            response.getWriter().print("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return "info:success";
    }
}
