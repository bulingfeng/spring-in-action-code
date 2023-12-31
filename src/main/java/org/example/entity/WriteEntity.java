package org.example.entity;

import javax.annotation.PostConstruct;

/**
 * 测试懒加载的效果
 */
public class WriteEntity {
    public final String  name;

    public WriteEntity(String name) {
        System.out.println("init constructor WriteEntity");
        this.name = name;
    }

    @PostConstruct
    public void init(){
        System.out.println("init....");
    }

    public void print(String message){
        System.out.println(message);
    }
}
