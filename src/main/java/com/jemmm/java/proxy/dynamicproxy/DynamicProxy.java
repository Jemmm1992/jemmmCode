package com.jemmm.java.proxy.dynamicproxy;

/**
 * Created by BIG-JIAN on 2017/7/9.
 */

/**
 * 类比静态代理，可以发现，代理类不需要实现原接口了，而是实现InvocationHandler。
 *
 * 通过动态代理可以很明显的看到它的好处，在使用静态代理时，如果不同接口的某些类想使用代理模式来实现相同的功能，将要实现多个代理类，
 * 但在动态代理中，只需要一个代理类就好了。
 * 除了省去了编写代理类的工作量，动态代理实现了可以在原始类和接口还未知的时候，就确定代理类的代理行为，
 * 当代理类与原始类脱离直接联系后，就可以很灵活地重用于不同的应用场景中。
 */

/**
 * 弊端：
 * 代理类和委托类需要都实现同一个接口。也就是说只有实现了某个接口的类可以使用Java动态代理机制。
 * 但是，事实上使用中并不是遇到的所有类都会给你实现一个接口。因此，对于没有实现接口的类，就不能使用该机制。
 * 而CGLIB则可以实现对类的动态代理
 */
public class DynamicProxy {
    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        AnimalDynamicImpl dynamicImpl = new AnimalDynamicImpl();
        AnimalDynamic proxy = (AnimalDynamic)myProxy.bind(dynamicImpl);
        System.out.println(proxy.sayHi());
    }
}
