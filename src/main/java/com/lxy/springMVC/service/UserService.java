package com.lxy.springMVC.service;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    // 控制层不与持久层产生关系，所以将MyBatis的实例化从控制器转移到Service中
    private SqlSessionFactory sqlSessionFactory;

    // 构造函数，用来实初始化mybatis
    public UserService(){
        // 初始化mybatis
        try {
            // 构建sqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Map<String,Object> serviceExample(){
        Map<String,Object> map = new HashMap<>();
        map.put("123",123);
        return map;
    }
}
