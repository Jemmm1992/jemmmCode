package com.jemmm.java.designpatterns.chains;

/**
 * Created by BIG-JIAN on 2017/7/13.
 * 第一种设计：没有任何设计模式
 */
public class MsgProcessor1 {

    private String msg;

    public MsgProcessor1(String msg) {
        this.msg = msg;
    }

    public String process() {
        String r = msg;
        //过滤msg中的HTML标记
        r = r.replace("<", "").replace(">", "");
        //过滤敏感词
        r = r.replace("敏感", "").replace("被就业", "就业");
        return r;
    }
}
