package com.yuntu.entity;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.entity
 * @Author: Shuo
 * @CreateTime: 2023-10-19  14:35
 * @Description:
 * @Version: 1.0
 */
public class Teacher {
    private String t_id;
    private String t_name;

    @Override
    public String toString() {
        return "Teacher{" +
                "t_id='" + t_id + '\'' +
                ", t_name='" + t_name + '\'' +
                '}';
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public Teacher() {
    }

    public Teacher(String t_id, String t_name) {
        this.t_id = t_id;
        this.t_name = t_name;
    }


}
