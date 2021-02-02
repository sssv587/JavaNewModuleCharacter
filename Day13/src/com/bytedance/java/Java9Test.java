package com.bytedance.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2021/2/2 - 23:01
 * @Description
 */
public class Java9Test {
    @Test
    public void test1() {
        try {
            URL url = new URL("https:www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //java9特性五：钻石操作符的升级
    @Test
    public void test2() {
        //钻石操作符与匿名内部类在java 8中不能共存。在java9中可以。
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        //jdk7中的新特性：类型推断
        ArrayList<String> list = new ArrayList<>();
    }

    //java9 特性六：try操作的升级
    public static void main(String[] args) {
        //java8 之前的资源关闭的操作
//        InputStreamReader reader = null;
//        try {
//            reader = new InputStreamReader(System.in);
//            char[] cbuf = new char[1024];
//            int len;
//            if ((len = reader.read(cbuf)) != -1) {
//                String str = new String(cbuf, 0, len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        //java8中资源关闭操作：Java8中，可以实现资源的关闭
        //要求自动关闭的资源的初始化必须放在try的一对小括号中。
//        try (InputStreamReader reader = new InputStreamReader(System.in)) {
//            char[] cbuf = new char[1024];
//            int len;
//            if ((len = reader.read(cbuf)) != -1) {
//                String str = new String(cbuf, 0, len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //java9中，资源的关闭操作：需要自动关闭的资源的实例化可以放在try的一对小括号外。
        //此时的资源变量是常量，声明为final的，不可修改
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader) {
            char[] cbuf = new char[1024];
            int len;
            if ((len = reader.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
