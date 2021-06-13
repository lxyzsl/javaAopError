package com.lxy.springMVC.mapper;

import com.lxy.springMVC.bean.Course;
import  com.lxy.springMVC.bean.UserCourse;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 课程类的MyBatis操作接口
 */
public interface CourseMapper {

    List<UserCourse> userCourse(@Param("userId") int userId);

    Course courseDetail(int id);
}
