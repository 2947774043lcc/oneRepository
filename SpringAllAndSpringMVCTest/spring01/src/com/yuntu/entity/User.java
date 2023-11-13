package com.yuntu.entity;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.entity
 * @Author: Shuo
 * @CreateTime: 2023-09-20  10:33
 * @Description:
 * @Version: 1.0
 */
public class User {
    private String userName;
    private int id;
    private Integer age;

    public User() {
    }

    public User(String userName, int id, Integer age) {
        this.userName = userName;
        this.id = id;
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
