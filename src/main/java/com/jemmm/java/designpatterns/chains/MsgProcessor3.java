package com.jemmm.java.designpatterns.chains;

/**
 * Created by BIG-JIAN on 2017/7/13.
 */
public class MsgProcessor3 {
    private String msg;
    private FilterChain chain = new FilterChain();

    public MsgProcessor3(String msg, Filter Chain) {
        this.msg = msg;
        this.chain = chain;
    }

    public String process() {
        return chain.doFilter(msg);
    }
}
