package com.jemmm.java.proxy.staticproxy;

/**
 * Created by BIG-JIAN on 2017/7/9.
 */

/**
 * 代理模式的使用场景：因为一些类不想直接对外暴露，通过中间一个代理类来作为客户端和被代理类的桥梁。
 * 通过使用代理模式，可以增强或者隐藏被代理类的部分方法。
 */

/**
 * 使用静态类的缺点：
 * 如果想要为多个类进行代理，需要建立多个代理类，维护难度比较大。
 */
public class StaticProxy {
    public static void main(String[] args) {
        AnimalImpl a = new AnimalImpl();
        AnimalProxy ap = new AnimalProxy(a);
        System.out.println(ap.sayHi());
    }
}
