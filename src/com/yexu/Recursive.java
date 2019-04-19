package com.yexu;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/27 9:36
 */
public class Recursive {

    public static void test(int num) {
        if (num > 2) {
            test(num - 1);
        }
        System.out.println("num =" + num);
    }

    public static void main(String[] args) {
        test(5000);
    }
}
