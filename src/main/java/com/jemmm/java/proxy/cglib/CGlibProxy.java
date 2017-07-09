package com.jemmm.java.proxy.cglib;

/**
 * Created by BIG-JIAN on 2017/7/9.
 */
public class CGlibProxy {
    public static void main(String[] args) {
        AnimalCGLIB animalCglib = new AnimalCGLIB();
        CGLIBAnimalProxy cGlibHoseeProxy = new CGLIBAnimalProxy();
        AnimalCGLIB proxy = (AnimalCGLIB) cGlibHoseeProxy.bind(animalCglib);
        System.out.println(proxy.sayhi());
    }
}