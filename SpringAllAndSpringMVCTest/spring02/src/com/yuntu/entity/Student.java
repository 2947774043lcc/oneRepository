package com.yuntu.entity;

import java.util.*;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.entity
 * @Author: Shuo
 * @CreateTime: 2023-09-25  11:28
 * @Description:
 * @Version: 1.0
 */
public class Student {
    private String name;
    private int age;
    private String[] subjectResult;
    private List<String> hobbys;
    private Map<String,String> IDCard;
    private Set<String> car;
    private Properties sqlCon;
    private String EQ;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subjectResult=" + Arrays.toString(subjectResult) +
                ", hobbys=" + hobbys +
                ", IDCard=" + IDCard +
                ", car=" + car +
                ", sqlCon=" + sqlCon +
                ", EQ='" + EQ + '\'' +
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

    public String[] getSubjectResult() {
        return subjectResult;
    }

    public void setSubjectResult(String[] subjectResult) {
        this.subjectResult = subjectResult;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public Map<String, String> getIDCard() {
        return IDCard;
    }

    public void setIDCard(Map<String, String> IDCard) {
        this.IDCard = IDCard;
    }

    public Set<String> getCar() {
        return car;
    }

    public void setCar(Set<String> car) {
        this.car = car;
    }

    public Properties getSqlCon() {
        return sqlCon;
    }

    public void setSqlCon(Properties sqlCon) {
        this.sqlCon = sqlCon;
    }

    public String getEQ() {
        return EQ;
    }

    public void setEQ(String EQ) {
        this.EQ = EQ;
    }
}
