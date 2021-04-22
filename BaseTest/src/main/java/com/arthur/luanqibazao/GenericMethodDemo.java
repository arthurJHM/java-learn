package com.arthur.luanqibazao;

public class GenericMethodDemo {
    public static void main(String[] args) {
// 创建对象
        MyGenericMethod mm = new MyGenericMethod();
// 演示看方法提示
        mm.show("aaa");
        mm.show(123);
        mm.show(12.45);
        System.out.println(mm.show2("aaa"));
        System.out.println(mm.show2(123));
        System.out.println(mm.show2(12.45));
    }
}