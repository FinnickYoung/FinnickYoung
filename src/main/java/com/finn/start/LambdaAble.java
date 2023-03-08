package com.finn.start;


/**
 * 函数式接口有且只有一个抽象方法。
 */

@FunctionalInterface
public interface LambdaAble {

//    public abstract void eat();

    public abstract int add(int x, int y);
//
//    public abstract String fly(String s);

    //抽象方法
//    public abstract void method();

    //Object类的public方法变成抽象方法
    public abstract boolean equals(Object obj);

    public abstract String toString();

    //默认方法
    public default void show(String s) {
        //打印小写
        System.out.println(s.toLowerCase());
    }

    //静态方法
    public static void print(String s) {
        //打印大写
        System.out.println(s.toUpperCase());
    }


}
