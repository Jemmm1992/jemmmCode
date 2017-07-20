package com.jemmm.java.designpatterns.builder;

import org.junit.Test;

/**
 * Created by BIG-JIAN on 2017/7/15.
 */
public class BuilderTest {
    /**
     * 建造者模式，将一个复杂对象的构建和它的表示分离，使的同样的构建过程可以创建不同的表示。
     * 比如：我们想要发送一封邮件，需要收件人的地址，主题，内容，附件等。其中收件人的地址是必须的，但是附件是可以没有的。
     * 建造者模式的主要包含的角色。
     * 抽象构建者(Builder):创建一个产品各个部件的指定接口。
     * 具体构建者（ConcreteBuilder）:它实现了Builder接口，实现各个部件的具体构建方法和装配方法，提供一个方法返回创建好的对象。
     * 产品（Product）：如本例中的Email，它是被构建的复杂对象。
     * 指挥者（Director）:复杂安排复杂对象的建造次序
     */
    @Test
    public void test1(){
        Builder builder = new AliEmail();
        Director director = new Director(builder);
        director.construct();
        Email email = builder.getEmail();
        System.out.println(email.getEmailAdd());
        System.out.println(email.getEmailContent());
    }
}
