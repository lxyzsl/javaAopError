package com.lxy.springMVC.bean;

import java.util.List;

/**
 * 课程
 */
public class Course {

    private int id;
    private String name;
    private String teacher;
    private int hour;

    private List<Lesson> lessons;

    public Course() {
    }

    public Course(int id, String name, String teacher, int hour) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
