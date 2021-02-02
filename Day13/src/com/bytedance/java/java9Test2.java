package com.bytedance.java;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2021/2/3 - 0:35
 * @Description
 */
public class java9Test2 {
    //java9新特性十：Stream API的加强
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(23, 43, 44, 24, 43, 35, 25);
        //takeWhile():返回从开头开始的尽量多的元素
        list.stream().takeWhile(x -> x < 30).forEach(System.out::println);

        //dropWhile():takeWhile相反,返回剩余的元素
        list.stream().dropWhile(x -> x < 30).forEach(System.out::println);
    }

    @Test
    public void test2() {
        //of()参数中的多个元素，可以包含null值
        Stream<Integer> stream1 = Stream.of(1, 2, 3, null);
        stream1.forEach(System.out::println);

        //of()参数不能存储单个null值。否则，报异常。
        //Stream<Object> stream2 = Stream.of(null);
        //stream2.forEach(System.out::println);

        Integer i = 10;
        i = null;
        //ifNullable():形参变量是可以为null值的单个元素
        Stream<Integer> stream3 = Stream.ofNullable(i);
        stream3.forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream.iterate(0, x -> x + 1).limit(20).forEach(System.out::println);

        //java9中新增的重载的方法
        Stream.iterate(0, x -> x < 30, x -> x + 2).forEach(System.out::println);
    }

    //java9新特性十一：Optional提供了新的方法stream()
    @Test
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");
        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<List<String>> stream = optional.stream();

//      long count = stream.count();
//      System.out.println(count);
        stream.flatMap(Collection::stream).forEach(System.out::println);
    }
}
