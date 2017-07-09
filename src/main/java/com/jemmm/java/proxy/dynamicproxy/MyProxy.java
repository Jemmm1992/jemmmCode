package com.jemmm.java.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by BIG-JIAN on 2017/7/9.
 */

/**
 * 通过Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
 * 来动态生成一个代理类，该类的类加载器与被代理类相同，实现的接口与被代理类相同。
 * 通过上述方法生成的代理类相当于静态代理中的代理类。
 * 这样就实现了在运行期才决定代理对象是怎么样的，解决了静态代理的弊端。
 * 当动态生成的代理类调用方法时，会触发invoke方法，在invoke方法中可以对被代理类的方法进行增强。
 */
public class MyProxy implements InvocationHandler {
    Object object;
    public Object bind (Object object){
        this.object = object;
        Object o = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
        return o;
    }

    // invoke是一个回调函数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I'm a proxy!");
        Object invoke = method.invoke(object, args);
        return invoke;
    }
}
