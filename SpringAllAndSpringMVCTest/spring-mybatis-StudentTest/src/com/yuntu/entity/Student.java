package com.yuntu.entity;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.entity
 * @Author: Shuo
 * @CreateTime: 2023-10-16  14:34
 * @Description:
 * @Version: 1.0
 */
public class Student {
    private String s_id;
    private String s_name;
    private String s_birth;
    private String s_sex;

    private Integer count;
    private Integer sum;
    private String score1;
    private String score2;
    private String c_name1;
    private String c_name2;

    @Override
    public String toString() {
        return "Student{" +
                "s_id='" + s_id + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_birth='" + s_birth + '\'' +
                ", s_sex='" + s_sex + '\'' +
                ", count=" + count +
                ", sum=" + sum +
                ", score1='" + score1 + '\'' +
                ", score2='" + score2 + '\'' +
                ", c_name1='" + c_name1 + '\'' +
                ", c_name2='" + c_name2 + '\'' +
                ", course=" + course +
                '}';
    }

    public Student(String s_id, String s_name, String s_birth, String s_sex, Integer count, Integer sum, String score1, String score2, String c_name1, String c_name2, Course course) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_birth = s_birth;
        this.s_sex = s_sex;
        this.count = count;
        this.sum = sum;
        this.score1 = score1;
        this.score2 = score2;
        this.c_name1 = c_name1;
        this.c_name2 = c_name2;
        this.course = course;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getC_name1() {
        return c_name1;
    }

    public void setC_name1(String c_name1) {
        this.c_name1 = c_name1;
    }

    public String getC_name2() {
        return c_name2;
    }

    public void setC_name2(String c_name2) {
        this.c_name2 = c_name2;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    private Course course;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Student(String s_id, String s_name, String s_birth, String s_sex, Integer count, Integer sum, Course course) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_birth = s_birth;
        this.s_sex = s_sex;
        this.count = count;
        this.sum = sum;
        this.course = course;
    }

    public Student() {
    }

    public Student(String s_id, String s_name, String s_birth, String s_sex, Integer count, Integer sum) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_birth = s_birth;
        this.s_sex = s_sex;
        this.count = count;
        this.sum = sum;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_birth() {
        return s_birth;
    }

    public void setS_birth(String s_birth) {
        this.s_birth = s_birth;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

}
