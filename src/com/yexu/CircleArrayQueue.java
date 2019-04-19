package com.yexu;

import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/26 11:02
 */
public class CircleArrayQueue {
    private int maxSize;
    private Integer[] array;
    private int front = 0;
    private int rear = 0;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new Integer[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public int addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法加入......");
            return -1;
        }
        array[rear] = n;
        rear = (rear + 1) % maxSize;
        return n;
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列已空，无法获取......");
            return -1;
        }
        Integer value = array[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列已空，无法获取......");
            return -1;
        }
        return array[front];
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        while (true) {
            System.out.println("请输入以下其中一个命令");
            Scanner scanner = new Scanner(System.in);
            System.out.println("exit: 表示退出程序");
            System.out.println("add: 表示添加队列数据");
            System.out.println("show: 表示显示队列");
            System.out.println("get: 表示取出队列数据");
            System.out.println("size: 表示队列有多少个元素");
            System.out.println("head: 查看队列头的数据(不改变队列)");
            switch (scanner.next()) {
                case "add": {
                    System.out.println("请输入一个整数");
                    arrayQueue.addQueue(scanner.nextInt());
                }
                break;
                case "show":
                    arrayQueue.showQueue();
                    break;
                case "get":
                    System.out.println(arrayQueue.getQueue());
                    break;
                case "head":
                    System.out.println(arrayQueue.headQueue());
                    break;
                case "size":
                    System.out.println(arrayQueue.size());
                    break;
            }
        }
    }
}
