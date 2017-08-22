package com.jemmm.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Ints;

import static com.google.common.base.CharMatcher.inRange;
import static com.utils.PrintfUtils.printf;

/**
 * Created by xu_zj on 2017/8/11.
 */
public class guavaTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        String[] subdirs = {"usr", "local", "lib"};
        String directory = Joiner.on("/").join(subdirs);
        printf(1, directory);

        int[] numbers = {1, 2, 3, 4, 5};
        String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
        printf(1, numbersAsString);

        String numbersAsStringDirectly = Ints.join(";", numbers);
        printf(1,numbersAsStringDirectly);
    }

    public static void test2() {
        CharMatcher or = inRange('a', 'z').or(inRange('A', 'Z'));
        String x = or.retainFrom("x");
        printf(2, x);
        x = or.retainFrom("xxzxz132413");
        printf(3, x);
        String string = CharMatcher.digit().retainFrom("some text 89983 and more");
        printf(4, string);
        string = CharMatcher.digit().removeFrom("some text 89983 and more");
        printf(5, string);
    }

    public static void test3() {
        ImmutableList<String> list = ImmutableList.of("a", "b", "c", "d");
        ImmutableMap<String, String> map = ImmutableMap.of("key1", "value1", "key2", "value2");
    }
}
