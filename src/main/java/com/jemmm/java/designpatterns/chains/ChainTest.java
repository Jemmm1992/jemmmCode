package com.jemmm.java.designpatterns.chains;

import org.junit.Test;

/**
 * Created by BIG-JIAN on 2017/7/13.
 */
public class ChainTest {
    //需要被过滤的语句
    String msg = "被就业了：)，敏感信息，<script>";

    // 第一种设计：没有任何设计模式
    @Test
    public void test1() {
        //实例化处理类
        MsgProcessor1 mp = new MsgProcessor1(msg);
        String r = mp.process();
        System.out.println(r);
    }

    // 第二种设计：增加一个Filter接口
    @Test
    public void test2() {
        //实例化处理类
        MsgProcessor2 mp = new MsgProcessor2(msg);
        String r = mp.process();
        System.out.println(r);
    }


    // 第三种设计：责任链模式（FilterChain）
    @Test
    public void test3() {
        //需要被过滤的语句
        String msg = "被就业了：），敏感信息，<script>";
        //搞一个过过滤链
        FilterChain chain = new FilterChain();
        chain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
        //实例化处理类
        MsgProcessor3 mp = new MsgProcessor3(msg, chain);
        System.out.println(mp.process());
    }
}
