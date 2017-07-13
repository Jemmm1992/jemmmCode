package com.jemmm.java.designpatterns.proxy.staticproxy;

/**
 * Created by BIG-JIAN on 2017/7/9.
 */
public class AnimalProxy implements Animal{

    Animal animal;

    public AnimalProxy(Animal animal){
        this.animal = animal;
    }

    @Override
    public String sayHi() {
        System.out.println("I'm AnimalProxy");
        return animal.sayHi();
    }
}
