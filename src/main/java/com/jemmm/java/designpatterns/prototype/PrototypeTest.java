package com.jemmm.java.designpatterns.prototype;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by BIG-JIAN on 2017/7/13.
 */
public class PrototypeTest {
    @Test
    public void test() throws IOException, ClassNotFoundException {
        Author author=new Author();
        author.setName("tengj");
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
