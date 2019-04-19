package com.yexu;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/26 18:00
 */
public class ArrayStack {
    private int maxSize;
    private int[] array;
    private int top = -1;

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满");
        }
        array[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈已空");
        }
        return array[top--];
    }

    public int size() {
        return top;
    }

    public void show(){
        for (int i = top ; i >= 0; i--) {
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }

    public int head() {
        if (isEmpty()) {
            System.out.println("栈已空");
        }
        return array[top];
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        for (int i = 1; i < 6; i++) {
            arrayStack.push(i);
        }
        arrayStack.show();
        System.out.println("size>>>>"+arrayStack.size());
        for (int i = 0; i < 5; i++) {
            System.out.println(arrayStack.pop());
//            System.out.println(arrayStack.head());
        }
    }
}
