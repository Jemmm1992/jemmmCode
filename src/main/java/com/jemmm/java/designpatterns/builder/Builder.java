package com.jemmm.java.designpatterns.builder;

/**
 * Created by BIG-JIAN on 2017/7/15.
 * 抽象建造者
 */
public interface Builder {
    public void builerEmailAdd();
    public void buildEmailContent();
    public Email getEmail();
}
