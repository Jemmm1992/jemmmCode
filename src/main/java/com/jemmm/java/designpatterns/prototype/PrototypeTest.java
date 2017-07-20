package com.jemmm.java.designpatterns.prototype;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by BIG-JIAN on 2017/7/13.
 */
public class PrototypeTest {
    /**
     * 总结：
     * 原型模式是一种快速创建大量相同或者相似对象的方法。
     * 优点：1.对象比较复杂的时候，简化对象的创建过程，并且提高对象的创建效率。
     * 2.简化了创建结构，比起工厂类创建对象，原型模式主要通过克隆的方法来实现。
     *
     * 缺点：
     * 1.为每一个类配备了克隆方法，克隆方法在类的内部，改造的时候需要改造源码。
     * 2.实现深克隆的时候，代码中如果存在多重的嵌套引用，每一层都必须支持深度克隆，实现起来比较复杂。
     *
     * 使用场景：
     * 1.创建对象成本比较大的时候（初始化时间，占用CPU资源）。
     * 2.如果要保存对象的状态，并且状态变化比较小的时候，可以使用原型模式+备忘录模式。
     * http://tengj.github.io/2016/04/07/sjms5prototype/
     */
    @Test
    public void test() throws IOException, ClassNotFoundException {
        Author author=new Author();
        author.setName("xzj");
        Book book=new Book();
        book.setBookName("Java设计模式");
        book.setPrice(99);
        book.setAuthor(author);
        Book book1=book.shallowClone();
        Book book2=book.deepClone();

        System.out.println(book==book1);                                 // false
        System.out.println(book.getBookName() == book1.getBookName());   // true
        System.out.println(book.getAuthor() == book1.getAuthor());       // true

        System.out.println(book==book2);                                 // false
        System.out.println(book.getBookName() == book2.getBookName());   // false
        System.out.println(book.getAuthor() == book2.getAuthor());       // false
    }
}
