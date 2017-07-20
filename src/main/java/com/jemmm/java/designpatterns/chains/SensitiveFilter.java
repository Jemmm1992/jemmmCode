package com.jemmm.java.designpatterns.chains;

/**
 * Created by BIG-JIAN on 2017/7/13.
 */
public class SensitiveFilter implements Filter {
    public String doFilter(String msg) {
        String r = msg;
        //过滤敏感词
        r = r.replace("敏感", "").replace("被就业", "就业");
        return r;
    }
}
