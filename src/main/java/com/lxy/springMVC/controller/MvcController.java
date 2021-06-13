package com.lxy.springMVC.controller;

import com.lxy.springMVC.bean.User;
import com.lxy.springMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/mvc")
public class MvcController {

    /**
     * 以 模型（数据）+ 视图（页面）作为http响应
     */
    @RequestMapping("/modeAndView")
    public ModelAndView modelAndView(){
        User user = new User("13000000000","123456");

        ModelAndView modelAndView = new ModelAndView();

        // 添加模型数据
        modelAndView.addObject("user",user);

        // 设置模型数据
        modelAndView.setViewName("hello");

        // 返回模型 + 视图
        // 在Spring的配置文件中配置了SpringMVC视图解析器，它的作用是定位视图文件位置，
        // 视图文件所在位置：prefix + 视图文件名 + suffix
        return modelAndView;
    }

    /**
     * 以视图（页面）作为HTTP响应
     */
    @RequestMapping("/view")
    public String view(){
        return "hello";
    }

    /**
     * 以 模型（数据）作为http响应
     */
    @RequestMapping("/json")
    @ResponseBody
    public User json(){
        return new User("13000000000","123123");
    }

    /**
     * 指定RequestMapping的请求方法，可以简写为
     * - @GetMapping
     * - @PostMapping
     * - @PutMapping
     * - @DeleteMapping
     * - @PatchMapping
     */
    @RequestMapping(value="/method",method = RequestMethod.POST)
//    @PostMapping
    @ResponseBody
    public User method(){
        return new User("13000000000","123123");
    }

    /**
     * 获取请求参数
     * - @RequestParam("xxx") 等效于 request.getParameter("xxx")
     * - @SessionAttribute("xxx") 等效于 request.getSession().getAttribute("xxx") [从session中获取key为xxx的值]
     */
    @RequestMapping("/param")
    @ResponseBody
    public Map<String,Object> param(
           @RequestParam("param") String param,
           @RequestParam(value = "nullable", required=false) String nullable,
           @RequestParam(value = "defaultVal", defaultValue="18") String  defaultVal,
           @RequestHeader("User-Agent") String header,
           @SessionAttribute(value = "user", required=false) User user
    ){
        Map<String,Object> map = new HashMap<>();
        map.put("param",param);
        map.put("nullable",nullable);
        map.put("defaultVal",defaultVal);
        map.put("header",header);
        map.put("user",user);

        return map;
    }

    /**
     * 获取路径变量
     */
    @GetMapping("/param/{var1}/{var2}")
    @ResponseBody
    public Map<String,Object> path(
            @PathVariable String var1,
            @PathVariable String var2,
            @RequestParam(value="param",required=false) String param
    ){
        Map<String,Object> map = new HashMap<>();
        map.put("var1",var1);
        map.put("var2",var2);
        map.put("param",param);
        return map;
    }

    /**
     * 代替Servlet
     * @param request Http请求
     * @param response Http响应
     * @param param
     * @throws IOException
     */
    @GetMapping("/servlet")
    public void servlet(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "param",required = false) String param
    )throws IOException {
        response.setCharacterEncoding("gbk");
        response.getWriter().print("Controller可以代替Servlet");
    }



    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }


    /**
     * 使用Service
     * @return
     */
    @GetMapping("/service-example")
    @ResponseBody
    public Map<String,Object> serviceExample(){
        System.out.println("serviceExample");
        return userService.serviceExample();
    }
}
