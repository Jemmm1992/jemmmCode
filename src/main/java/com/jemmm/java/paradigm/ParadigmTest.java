package com.jemmm.java.paradigm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/15.
 */
public class ParadigmTest {
    public static void main(String[] args) {
        List list =new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add(1);
        for (int i = 0; i <list.size() ; i++) {
            String o = (String)list.get(i);
            System.out.println(o);
        }
    }
}
