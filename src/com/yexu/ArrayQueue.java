package com.yexu;

import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/26 10:33
 */
public class ArrayQueue {
    private int maxSize;
    private Integer[] array;
    private int front = -1;
    private int rear = -1;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new Integer[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public int addQueue(int n) {
        if(isFull()){
            System.out.println("队列已满，无法加入......");
            return -1;
        }
        array[++rear] = n;
        return n;
    }
    public int getQueue() {
        if(isEmpty()){
            System.out.println("队列已空，无法获取......");
            return -1;
        }
        return array[++front];
    }

    public void showQueue(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        while (true){
            System.out.println("请输入以下其中一个命令");
            Scanner scanner = new Scanner(System.in);
            System.out.println("show: 表示显示队列");
            System.out.println("exit: 表示退出程序");
            System.out.println("add: 表示添加队列数据");
            System.out.println("get: 表示取出队列数据");
            System.out.println("head: 查看队列头的数据(不改变队列)");
            switch (scanner.next()) {
                case "show":
                    arrayQueue.showQueue();
                    break;
                case "add": {
                    System.out.println("请输入一个整数");
                    arrayQueue.addQueue(scanner.nextInt());
                }
                break;
                case "get":
                    System.out.println(arrayQueue.getQueue());
                    break;
            }
        }
    }
}
