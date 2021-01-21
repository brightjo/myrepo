package io.github.brightjo.package01;

import java.util.Scanner;

public class TwoWayLinkedList {
    private Node head;
    private int length;
    private static Scanner scanner;

    private class Node {
        int data;
        Node prev;
        Node next;
    }

    public TwoWayLinkedList() {
        head = new Node();
        length = 0;
        scanner = new Scanner(System.in);
    }

    public void tailInput(int n) {
        Node tail = head;
        while (n-- != 0) {
            Node tmp = new Node();
            tmp.data = scanner.nextInt();
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
        length = length();
    }

    public void display() {
        System.out.print("head");
        Node cur = head.next;
        while (cur != null) {
            System.out.print("->" + cur.data);
            cur = cur.next;
        }
        System.out.println();
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
        tmp.prev = cur;
        cur.next = tmp;
        if (tmp.next != null) {
            tmp.next.prev = tmp;
        }
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
        if (cur.next != null) {
            cur.next.prev = cur;
        }
        length = length();
    }

    public int length() {
        int len = 0;
        Node cur = head.next;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    public static void main(String[] args) {
        TwoWayLinkedList list = new TwoWayLinkedList();
        list.tailInput(3);
        list.delete();
        list.display();
        scanner.close();
        System.out.println(list.length());
    }

}

