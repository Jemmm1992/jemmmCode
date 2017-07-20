package com.jemmm.java.designpatterns.chains;

/**
 * Created by BIG-JIAN on 2017/7/13.
 */
public class MsgProcessor2 {

    private String msg;
    private Filter[] filters = {new HtmlFilter(), new SensitiveFilter()};

    public MsgProcessor2(String msg) {
        this.msg = msg;
    }

    public String process() {
        String r = msg;
        for (Filter f : filters) {
            r = f.doFilter(r);
        }
        return r;
    }
}
