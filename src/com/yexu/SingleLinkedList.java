package com.yexu;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/26 11:49
 */
public class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "head", 0, null);

    public void addNode(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                return;
            }
            temp = temp.getNext();
        }
    }

    public void addNode(int index, HeroNode node) {
        HeroNode temp = head.getNext();
        if (index > size()) {
            System.out.println("插入的位置不存在");
        }
        while (true) {
            if (temp != null && temp.getId() + 1 == index) {
                node.setNext(temp.getNext());
                temp.setNext(node);
                return;
            }
            temp = temp.getNext();
        }
    }

    public void updateNode(int index, HeroNode node) {
        HeroNode temp = head.getNext();
        if (index > size()) {
            System.out.println("修改的位置不存在");
        }
        while (true) {
            if (temp != null && temp.getId() + 1 == index) {
                if (temp.getNext() == null) {
                    node.setNext(null);
                } else {
                    node.setNext(temp.getNext().getNext());
                }
                temp.setNext(node);
                return;
            }
            temp = temp.getNext();
        }
    }

    public boolean deleteNode(int index) {
        HeroNode temp = head.getNext();
        if (index > size()) {
            System.out.println("要删除位置的节点不存在");
            return false;
        }
        while (true) {
            if (temp != null) {
                if (temp.getId() + 1 == index) {
                    temp.setNext(temp.getNext().getNext());
                    return true;
                }
            } else {
                System.out.println("要删除位置的节点不存在");
                return false;
            }
            temp = temp.getNext();
        }
    }

    public void showNode() {
        System.out.println(head);
    }

    public int size() {
        HeroNode temp = head;
        int count = 0;
        while (true) {
            if (temp.getNext() == null) {
                return count;
            }
            temp = temp.getNext();
            count++;
        }
    }

    public HeroNode getNode(int id) {
        HeroNode temp = head;
        while (true) {
            if (temp == null) {
                return null;
            }
            if (temp.getId() == id) {
                return temp;
            }
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addNode(new HeroNode(1, "宋江1", 11, null));
        linkedList.addNode(new HeroNode(3, "宋江3", 13, null));
        linkedList.addNode(2, new HeroNode(2, "宋江2", 12, null));
        linkedList.updateNode(2, new HeroNode(2, "宋江22", 122, null));
        linkedList.updateNode(4, new HeroNode(4, "宋江4", 14, null));
        linkedList.updateNode(4, new HeroNode(4, "宋江44", 144, null));
        linkedList.showNode();
        System.out.println(linkedList.size());
        linkedList.deleteNode(4);
        linkedList.deleteNode(5);
        linkedList.showNode();
        System.out.println(linkedList.size());
    }
}

class HeroNode {
    private int id;
    private String name;
    private int age;
    private HeroNode next;

    public HeroNode() {
        super();
    }

    public HeroNode(int id, String name, int age, HeroNode next) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.next = next;
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", next=" + next +
                '}';
    }
}
