package com.yexu;

import java.util.ArrayList;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/30 11:11
 */
public class ArrayDemo {

    public static void main(String[] args) {
        new Person().say();
        Object[] array = new String[10];
        array[0] = 10;

        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list.add("zhangsan");
    }

    public static class demo {

    }

    public static class demo1 {

    }
}

class Person {
    public void say() {
        System.out.println(1111);
    }
}
