package com.yexu;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/27 10:43
 */
public class Sort {
    private static int size = 8000000;
    private static int[] array = new int[size];

    static {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }
    }

    public static void bubbleSort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("*****冒泡排序**********");
        System.out.println("耗时" + (System.currentTimeMillis() - start));
//        System.out.println(Arrays.toString(array));
    }

    public static void selectSort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
                if (index != i) {
                    int temp = array[i];
                    array[i] = array[index];
                    array[index] = temp;
                }
            }
        }
        System.out.println("*****选择排序**********");
        System.out.println("耗时" + (System.currentTimeMillis() - start));
//        System.out.println(Arrays.toString(array));
    }

    public static void insertSort() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int insertIndex = i - 1;
            while (insertIndex > 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            array[insertIndex + 1] = insertValue;
        }
        System.out.println("*****插入排序**********");
        System.out.println("耗时" + (System.currentTimeMillis() - start));
//        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int start, int end) {
        int left = start;
        int right = end;
        int middledleVal = array[(left + end) / 2];
        while (left < right) {
            while (array[left] < middledleVal) {
                left++;
            }
            while (array[right] > middledleVal) {
                right--;
            }
            if (left >= right) {
                break;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            if (array[left] == middledleVal) {
                right--;
            }
            if (array[right] == middledleVal) {
                left++;
            }
        }
        if (left == right) {
            left++;
            right--;
        }
        if (start < right) {
            quickSort(start, right);
        }
        if (end > left) {
            quickSort(left, end);
        }
    }

    public static void mergeSort(int left, int right, int[] tempArray) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle, tempArray);
            mergeSort(middle + 1, right, tempArray);
            merge(left, middle, right, tempArray);
        }

    }

    public static void merge(int left, int middle, int right, int[] temp) {
        int i = left;// i 就是左边指针[索引]
        int j = middle + 1; //j 就是右边的指针
        int t = 0; // t 是 temp 数组的索引
        while (i <= middle && j <= right) {
            // 如果是当前的左边的有序列表的值小于当前的右边有序列表的值
            // 就把这个值拷贝到 temp 数组
            if (array[i] <= array[j]) {
                temp[t] = array[i];
                t += 1;
                i += 1;
            } else { // 如果是当前的右边的有序列表的值小于当前的左边有序列表的值，就把这个值拷贝到 temp
                temp[t] = array[j];
                t += 1;
                j += 1;
            }
        }
        while (i <= middle) { //如果左边有序列表还有剩余数据，就依次拷贝到 temp 数组
            temp[t] = array[i];
            t += 1;
            i += 1;
        }
        while (j <= right) { //如果右边有序列表还有剩余数据，就依次拷贝到 temp 数组
            temp[t] = array[j];
            t += 1;
            j += 1;
        }
        // 下面代码是完成将本次的 temp 的数据拷贝到 arr 中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(array));
        new Thread(new Runnable() {
            @Override
            public void run() {
                bubbleSort();
            }
        }).start();
//        new Thread(()-> bubbleSort()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                selectSort();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                insertSort();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                quickSort(0, array.length - 1);
                System.out.println("*****快速排序**********");
                System.out.println("耗时" + (System.currentTimeMillis() - startTime));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                mergeSort(0, array.length - 1,new int[size]);
                System.out.println("*****归并排序**********");
                System.out.println("耗时" + (System.currentTimeMillis() - startTime));
            }
        }).start();

    }
}
