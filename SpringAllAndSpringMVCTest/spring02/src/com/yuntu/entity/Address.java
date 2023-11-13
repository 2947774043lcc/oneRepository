package com.yuntu.entity;

import org.springframework.stereotype.Component;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.entity
 * @Author: Shuo
 * @CreateTime: 2023-09-25  15:39
 * @Description:
 * @Version: 1.0
 */
@Component
public class Address {
    private String name;

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
