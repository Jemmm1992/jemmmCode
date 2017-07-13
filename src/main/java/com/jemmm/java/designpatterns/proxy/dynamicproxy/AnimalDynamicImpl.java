package com.jemmm.java.designpatterns.proxy.dynamicproxy;

/**
 * Created by BIG-JIAN on 2017/7/9.
 */
public class AnimalDynamicImpl implements AnimalDynamic {
    @Override
    public String sayHi() {
        return "I'm AnimalDynamicImpl";
    }
}
