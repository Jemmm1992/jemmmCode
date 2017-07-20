package com.jemmm.java.designpatterns.builder;

/**
 * Created by BIG-JIAN on 2017/7/15.
 * 指挥者类
 */
public class Director {
    // 持有当前需要使用的建造器对象
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    // 产品构造方法，负责调用各个零件的建造方法
    public void construct(){
        builder.builerEmailAdd();
        builder.buildEmailContent();
    }
}
