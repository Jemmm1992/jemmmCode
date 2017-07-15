package com.jemmm.java.paradigm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/15.
    使用泛型，可以简化我们的开发，并且保证代码的质量和。
    http://www.cnblogs.com/lwbqqyumidi/p/3837629.html
 */
public class ParadigmTest {

   /**
    * 我们将一个对象放到集合中，集合不会记住对象的类型，当再次取出对对象的时候，都是Object，但是在运行的时候他仍然是其本身的类型，
    * 也就是说，可以通过类型强转恢复到具体的目标类型。
    * 所以，为了让集合能够记住元素的类型，并且只要编译的时候不出现问题，就能保证其运行的时候不会出错。
    * 方法也就是使用泛型。
    * */
    @Test
    public void test1() {
        List list =new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add(1);
        for (int i = 0; i <list.size() ; i++) {
            String o = (String)list.get(i); // 取出Integer 1 的时候会报错ClassCastException异常
            System.out.println(o);
        }
    }

    /**
     * 什么是泛型： 参数化类型
     * 其中下面中的String叫做类型实参
     */
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
//        list.add(1);     // 编译的时候就报错，所以避免了上面的情况
        for (int i = 0; i <list.size() ; i++) {
            String s = list.get(i); // 无需进行强制类型转换
            System.out.println(s);
        }
    }


    /**
     *  泛型擦除
     *  观察下方代码，我们可以发现虽然list1和list2的类型参数不同，但是他们的class都是class java.util.ArrayList。
     *  原因：泛型只作用于代码编译时期，在编译过程中，对于正确检验的泛型结果，会将泛型的相关信息擦除，也就是说，成功编译过后的class
     *  文件其实不包括泛型的任何信息，泛型信息不会进入到运行阶段。
     */
    @Test
    public void test3(){
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list1.getClass());// class java.util.ArrayList
        System.out.println(list2.getClass());// class java.util.ArrayList
    }

    /**
     * 类型通配符
     */
    @Test
    public void test4(){
        List<Integer> list1 = new ArrayList<>();
        List<Number> list2 = new ArrayList<>();
        list1.add(1); list2.add(2);
        getData1(list2);
//        getData1(list1);// 报错，虽然Integer和Number是父子关系，但是这样的写法不对，具体写法参见下方。

        getData2(list2);  // 正确
        getData2(list1);

        getData3(list2);  // 正确
        getData3(list1);


    }
    public void getData1(List<Number> list){
        System.out.println(list.get(0));
    }

    public void getData2(List<? extends Number> list){
        System.out.println(list.get(0));
    }

    public void getData3(List<?> list){
        System.out.println(list.get(0));
    }


}
