package com.jemmm.java.designpatterns.chains;

/**
 * Created by BIG-JIAN on 2017/7/13.
 */
public class HtmlFilter implements Filter {
    public String doFilter(String msg) {
        String r = msg;
        //过滤msg中的HTML标记
        r = r.replace("<", "<").replace(">", ">");
        return r;
    }
}
