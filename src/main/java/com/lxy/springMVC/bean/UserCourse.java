package com.lxy.springMVC.bean;

/**
 * 用户的课程
 */
public class UserCourse {

    private int id;
    private int userId;
    private int courseId;
    private Course course;
    private int studied;
    private Lesson studying;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getStudied() {
        return studied;
    }

    public void setStudied(int studied) {
        this.studied = studied;
    }

    public Lesson getStudying() {
        return studying;
    }

    public void setStudying(Lesson studying) {
        this.studying = studying;
    }
}
