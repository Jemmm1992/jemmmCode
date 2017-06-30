package com.jemmm.java.annotation;


import org.junit.Test;

/**
 * Created by xu_zj on 2017/6/30.
 */
public class ATest {
    @Test
    public void testAnnotation(){
        AnnotationProcessor.getInfo(AnnotationTest.class);
    }
}
