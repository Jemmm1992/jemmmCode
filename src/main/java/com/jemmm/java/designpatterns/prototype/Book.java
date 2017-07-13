package com.jemmm.java.designpatterns.prototype;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

/**
 * Created by BIG-JIAN on 2017/7/13.
 */
@Getter
@Setter
public class Book  implements Cloneable, Serializable{
    private String bookName;
    private int price;
    private Author author;

    public Book shallowClone() {
        Book  book=null;
        try {
            book=(Book)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return book;

    }
    public Book deepClone() throws IOException, ClassNotFoundException {
    // 写入当前对象的二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        // 读出二进制流产生的新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Book) ois.readObject();
    }

}
