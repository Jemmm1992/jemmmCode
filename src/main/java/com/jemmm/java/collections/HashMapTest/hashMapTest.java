package com.jemmm.java.collections.HashMapTest;

import com.jemmm.modal.User;

import java.util.HashMap;

/**
 * Created by BIG-JIAN on 2017/7/16.
 */
public class hashMapTest {
    public static void main(String[] args) {
        HashMap<User, String> map = new HashMap<>(2);
        HashMap<User,String> mapx = new HashMap<>(2);
        User user1 = new User("李白");
        User user2 = new User("老夫子");
        map.put(user1,"你好");
        System.out.println(map.get(user1));
        user1 = new User("礼拜2");
        System.out.println(map.get(user1));
        System.out.println(map);
    }
}
