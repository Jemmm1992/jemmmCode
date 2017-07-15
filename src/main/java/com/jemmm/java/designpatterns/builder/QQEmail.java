package com.jemmm.java.designpatterns.builder;

/**
 * Created by BIG-JIAN on 2017/7/15.
 * 具体建造者类
 */
public class QQEmail implements Builder{
    Email email = new Email();
    @Override
    public void builerEmailAdd() {
        email.setEmailAdd("123@qq.com");
    }

    @Override
    public void buildEmailContent() {
        email.setEmailContent("你好QQ");
    }

    @Override
    public Email getEmail() {
        return email;
    }
}
