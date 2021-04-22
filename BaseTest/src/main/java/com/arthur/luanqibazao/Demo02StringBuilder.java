package com.arthur.luanqibazao;

import java.util.ArrayList;
import java.util.Collection;

public class Demo02StringBuilder {
    public static void main(String[] args) {
//创建对象
        StringBuilder builder = new StringBuilder();

        Collection a = new ArrayList();
        Collection b = new ArrayList<Integer>();
        a.add("ad");
        for (Object i : a) {
            String str = (String)i;
            System.out.println(i);
        }

        Object c = new Object();



//public StringBuilder append(任意类型)
        StringBuilder builder2 = builder.append("hello");
//对比一下
        System.out.println("builder:"+builder);
        System.out.println("builder2:"+builder2);
        System.out.println(builder == builder2); //true
// 可以添加 任何类型
        builder.append("hello");
        builder.append("world");
        builder.append(true);
        builder.append(100);
        System.out.println("builder:"+builder);
        System.out.println("builder2:"+builder2);
// 在我们开发中，会遇到调用一个方法后，返回一个对象的情况。然后使用返回的对象继续调用方法。
// 这种时候，我们就可以把代码现在一起，如append方法一样，代码如下
//链式编程
        builder.append("hello").append("world").append(true).append(100);
        System.out.println("builder:"+builder);
        System.out.println("builder2:"+builder2);
    }
}