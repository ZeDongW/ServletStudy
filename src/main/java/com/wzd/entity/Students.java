package com.wzd.entity;

/**
 * @Author ZeDongW
 * @ClassName Students
 * @Description 学生实体类
 * @Version 1.0
 * @date ：Created in 2019/4/30 0030 23:17
 * @modified By：
 */

public class Students {
    private String name;
    private int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Students() {
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
