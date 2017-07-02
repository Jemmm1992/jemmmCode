package com.jemmm.java.annotation;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by xu_zj on 2017/6/30.
 */
@Getter
@Setter
@Person(name="赵云",age = 20 ,hobby = {"王者荣耀"})
public class AnnotationTest {
    @PersonSex(sex= PersonSex.Sex.BOY)
    private String personsex;
}
