package com.lxy.springMVC.mapper;

import  com.lxy.springMVC.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户类的MyBatis操作接口
 */
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> findAll();

    /**
     * 多查询条件
     * @param mobile 手机号
     * @param begin 注册开始日期
     * @param end 注册截止日期
     */
    List<User> find(@Param("mobile") String mobile,
                    @Param("begin") String begin,
                    @Param("end") String end);


    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(int id);

    @Select("SELECT * FROM user WHERE mobile = #{arg0} and password = #{arg1}")
    User findByMobileAndPassword(String mobile, String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 修改用户电话号码
     * @param mobile
     * @param id
     * @return
     */
    @Update("UPDATE user SET mobile = #{arg1} WHERE id = #{arg0}")
    int changeMobile(String id, String mobile);

    /**
     * 根据主键删除用户
     * @param id
     * @return
     */
    @Delete("DELETE FROM user WHERE id = #{arg0}")
    int delete(String id);
}
