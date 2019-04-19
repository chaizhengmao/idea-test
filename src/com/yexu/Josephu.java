package com.yexu;

import javax.print.attribute.standard.PrinterLocation;
import java.awt.font.TextMeasurer;
import java.lang.reflect.Field;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/26 16:38
 */
public class Josephu {

    private Boy first = null;
    private Boy currentBoy = null;
    private int size = 0;

    public Josephu(int playBoys, int startIndex, int countNum) {
        super();
        createList(playBoys);
        show();
        playGame(startIndex, countNum);
    }

    //创建环形链表
    public void createList(int num) {
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (first == null) {
                //第一个小孩
                first = boy;
                first.setNext(first);
                //指向当前小孩
            } else {
                currentBoy.setNext(boy);
                boy.setNext(first);
            }
            currentBoy = boy;
        }
    }

    public void playGame(int startIndex, int countNum) {
        if (first.getNext() == null) {
            System.out.println("没有小孩子，游戏无法开始....");
            return;
        }
        Boy temp = first;
        //让辅助指针指向first的前一个节点
        while (true) {
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }

        //调整指针到从哪个位置开始
        for (int i = 0; i < startIndex - 1; i++) {
            first = first.getNext();
            temp = temp.getNext();
        }
        while (true) {
            if (temp == first) {
                System.out.println("只剩下一个人:" + first);
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                temp = temp.getNext();
            }
            System.out.println("你要出圈了:" + first);
            first = first.getNext();
            temp.setNext(first);
        }
    }

    public void show() {
        if (first.getNext() == null) {
            System.out.println("没有小孩子....");
            return;
        }
        Boy temp = first;
        while (true) {
            System.out.println(temp);
            if (temp.getNext() == first) {
                return;
            }
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        new Josephu(70, 41, 30);
    }
}

class Boy {
    private int id;
    private Boy next;

    public Boy() {
        super();
    }

    public Boy(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
