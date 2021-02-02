package com.bytedance.java;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2021/2/2 - 23:11
 * @Description
 */
public class MyInterfaceImpl implements MyInterface {
    @Override
    public void methodAbstract() {

    }

    @Override
    public void methodDefault() {
        System.out.println("重写了接口中的默认方法");
    }

    public static void main(String[] args) {
        //接口中的静态方法只能由接口自己调用
        MyInterface.methodStatic();
        //接口中的实现类不能调用接口的静态方法
//        MyInterfaceImpl.methodStatic();

        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.methodDefault();

        //接口的私有方法，不能在接口外部中应用
//        impl.methodPrivate();
    }
}
