package io.github.brightjo.package01;

import java.util.Scanner;

public class CycleLinkedList {
    private Node head;
    private int length;
    private static Scanner scanner;

    private class Node {
        int data;
        Node next;
    }

    public CycleLinkedList() {
        head = new Node();
        head.next = null;
        length = 0;
        scanner = new Scanner(System.in);
    }

    public void tailInsert(int n) {
        Node tail = head;
        while(n-- != 0) {
            Node node = new Node();
            node.data = scanner.nextInt();
            tail.next = node;
            tail = node;
        }
        tail.next = head.next;
        length = length();
    }

    public void display() {
        Node cur = head.next;
        System.out.print("head");
        while(cur != null) {
            System.out.print("->" + cur.data);
            cur = cur.next;
            if(cur.equals(head.next))    break;
        }
        System.out.println();
    }

    public int length() {
        int len = 0;
        Node cur = head.next;
        while(cur != null) {
            len++;
            cur = cur.next;
            if(cur.equals(head.next))    break;
        }
        return len;
    }

    public void insert() {
        System.out.println("请输入数据值x：");
        Node tmp = new Node();
        tmp.data = scanner.nextInt();
        System.out.println("请输入要插入的位置：");
        int pos = scanner.nextInt();
        if (pos < 1 || pos > length + 1) {
            System.out.println("输入位置错误：");
            return;
        }
        Node cur = head;
        while (--pos != 0) {
            cur = cur.next;
        }
        tmp.next = cur.next;
        cur.next = tmp;
        length = length();
    }

    public void delete() {
        System.out.println("请问要删除第几个节点：");
        int pos = scanner.nextInt();
        if (pos < 1 || pos > length) {
            System.out.println("输入位置错误");
            return;
        }
        Node cur = head;
        while (--pos != 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        length = length();
    }



    public static void main(String[] args) {
        CycleLinkedList list = new CycleLinkedList();
        list.tailInsert(3);
        //list.insert();
        //list.delete();
        list.display();
        System.out.println(list.length());
    }

}
