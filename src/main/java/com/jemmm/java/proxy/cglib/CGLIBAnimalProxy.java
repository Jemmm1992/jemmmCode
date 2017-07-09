package com.jemmm.java.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by BIG-JIAN on 2017/7/9.
 */

/**
 * cglib需要指定父类和回调方法。当然cglib也可以与Java动态代理一样面向接口，因为本质是继承。
 */
public class CGLIBAnimalProxy {

    Object object;
    public Object bind(final Object object){
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new MethodInterceptor(){
            @Override
            public Object intercept(Object obj, Method method, Object[] args,
                                    MethodProxy proxy) throws Throwable {
                System.out.println("I'm proxy!");
                Object res = method.invoke(object, args);
                return res;
            }
        });
        return enhancer.create();
    }
}
