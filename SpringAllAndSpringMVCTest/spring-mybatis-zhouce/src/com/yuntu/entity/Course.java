package com.yuntu.entity;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.entity
 * @Author: Shuo
 * @CreateTime: 2023-10-16  15:58
 * @Description:
 * @Version: 1.0
 */
public class Course {
    private String c_id;
    private String c_name;
    private String t_id;

    @Override
    public String toString() {
        return "course{" +
                "c_id='" + c_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", t_id='" + t_id + '\'' +
                '}';
    }

    public Course() {
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public Course(String c_id, String c_name, String t_id) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.t_id = t_id;
    }
}
