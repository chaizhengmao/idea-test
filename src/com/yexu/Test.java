package com.yexu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/4/2 11:48
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(new Integer(11000).hashCode());
        System.out.println(new Double(11.0).hashCode());
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("us","USA");
        hashMap.put("us","American");
        System.out.println(hashMap.get("us"));
        Random random = new Random();
        for (int i = 0; i <10 ; i++) {
            int i1 = random.nextInt(1000);
            System.out.print(i1+"\t");
            treeSet.add(i1);
        }
        System.out.println();
        System.out.println(treeSet);
    }
}
