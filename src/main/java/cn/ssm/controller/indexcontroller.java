package cn.ssm.controller;

import cn.ssm.po.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class indexcontroller {
@Autowired
    private cn.ssm.service.userService userService;
    private User user;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(Model model){


     Map<String,List<User>> map=new HashMap<>();
     map.put("all1",userService.findall());
      model.addAttribute("all",userService.findall());

        return  new ModelAndView("index",map);
    }
    @RequestMapping(value = "delete")
    public String  deleteUserbyid(HttpServletRequest request){
       System.out.println(request.getParameter("id"));
       userService.deleteUserbyid(new Integer(request.getParameter("id")));
        return  "redirect:index.action";
    }

    @RequestMapping(value = "findbyname",method = RequestMethod.POST)
    public void find(String name, HttpServletResponse response){
        System.out.println(name);

        try {
         List<User> userList= userService.selectByName(name);
            System.out.println("长度"+userList.size());
            JSONArray jsonArray=new JSONArray();
            for (User user:userList){
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("name",user.getName());
                jsonArray.add(jsonObject);
            }
            response.getWriter().print(jsonArray.toString());

            //response.getWriter().print("a:"+"123456");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
