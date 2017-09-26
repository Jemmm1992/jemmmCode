package com.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by BIG-JIAN on 2017/9/3.
 */
public class tet1 {
    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactory.xml"));
//        ApplicationContext bf =
//                new ClassPathXmlApplicationContext("beanFactory.xml");
        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");

        System.out.println(myTestBean.getTestStr());
    }
}
