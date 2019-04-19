package com.yexu;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/26 15:47
 */
public class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "head", 0);

    public void addNode(HeroNode2 node) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                node.setPrev(temp);
                return;
            }
            temp = temp.getNext();
        }
    }

    public HeroNode2 getNode(int id) {
        HeroNode2 temp = head;
        while (true) {
            if (temp == null) {
                return null;
            }
            if (temp.getId() == id)
                return temp;

            temp = temp.getNext();
        }
    }

    public boolean deleteNode(int index) {
        HeroNode2 temp = head.getNext();
//        if (index > size()) {
//            System.out.println("要删除位置的节点不存在");
//            return false;
//        }
        while (true) {
            if (temp != null) {
                if (temp.getId() == index) {
                    if (temp.getNext() != null) {
                        temp.getNext().setPrev(temp.getPrev());
                    }
                    temp.getPrev().setNext(temp.getNext());
                    return true;
                }
            } else {
                System.out.println("要删除位置的节点不存在");
                return false;
            }
            temp = temp.getNext();
        }
    }

    public int size() {
        HeroNode2 temp = head;
        int count = 0;
        while (true) {
            if (temp.getNext() == null) {
                return count;
            }
            count++;
            temp = temp.getNext();
        }
    }

    public void showNode() {
        System.out.println(head);
    }

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addNode(new HeroNode2(1, "宋江1", 11));
        linkedList.addNode(new HeroNode2(3, "宋江3", 13));
        linkedList.showNode();
        System.out.println(linkedList.getNode(0).getPrev());
        System.out.println(linkedList.getNode(1).getPrev());
        System.out.println(linkedList.getNode(3).getPrev());
        linkedList.deleteNode(1);
        linkedList.deleteNode(3);
        linkedList.showNode();
//        System.out.println(linkedList.getNode(3).getPrev());

    }

}

class HeroNode2 {
    private int id;
    private String name;
    private int age;
    private HeroNode2 next;
    private HeroNode2 prev;

    public HeroNode2() {
        super();
    }

    public HeroNode2(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public HeroNode2 getPrev() {
        return prev;
    }

    public void setPrev(HeroNode2 prev) {
        this.prev = prev;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", next=" + next +
                '}';
    }
}
