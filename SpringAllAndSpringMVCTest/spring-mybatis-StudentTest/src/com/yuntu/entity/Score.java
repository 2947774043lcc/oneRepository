package com.yuntu.entity;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.entity
 * @Author: Shuo
 * @CreateTime: 2023-10-16  14:35
 * @Description:
 * @Version: 1.0
 */
public class Score {
    private String s_id;
    private String c_id;
    private String s_score;
    private String avg;

    public Score() {
    }

    @Override
    public String toString() {
        return "Score{" +
                "s_id='" + s_id + '\'' +
                ", c_id='" + c_id + '\'' +
                ", s_score='" + s_score + '\'' +
                ", avg='" + avg + '\'' +
                '}';
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public Score(String s_id, String c_id, String s_score, String avg) {
        this.s_id = s_id;
        this.c_id = c_id;
        this.s_score = s_score;
        this.avg = avg;
    }



    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getS_score() {
        return s_score;
    }

    public void setS_score(String s_score) {
        this.s_score = s_score;
    }

    public Score(String s_id, String c_id, String s_score) {
        this.s_id = s_id;
        this.c_id = c_id;
        this.s_score = s_score;
    }
}
