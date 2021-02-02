package com.bytedance.java;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2021/2/2 - 23:05
 * @Description
 */
public interface MyInterface {
    //如下的三个方法的权限修饰符都是public
    void methodAbstract();

    static void methodStatic() {
        System.out.println("我是接口中的静态方法");
    }

    default void methodDefault() {
        System.out.println("我是接口中的默认方法");
        methodPrivate();
    }

    //jdk9中允许接口中定义私有的方法
    private void methodPrivate() {
        System.out.println("我是接口中的私有方法");
    }
}
