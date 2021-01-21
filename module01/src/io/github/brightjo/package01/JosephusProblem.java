package io.github.brightjo.package01;

import java.util.Scanner;

public class JosephusProblem {
    private int num; //猴子总数
    private int startId; //开始的编号
    private int k; //数到几号猴就出局
    private Scanner scanner;
    private  CycleLinkedList list;
    private static int id; //每个猴子的编号

    public JosephusProblem() {
        scanner = new Scanner(System.in);
        id = 0;
        System.out.println("请输入猴子总数：");
        num = scanner.nextInt();
        System.out.println("请输入开始报数的猴子的编号：");
        startId = scanner.nextInt();
        if(startId > num || startId < 1) {
            System.out.println("输入数据不合理");
            return;
        }
        System.out.println("请输入数到几号猴就出局：");
        k = scanner.nextInt();
        if(k > num || k < 1) {
            System.out.println("输入数据不合理");
            return;
        }
        list = new CycleLinkedList();
        list.tailInsert(num);
    }

    private class CycleLinkedList {
        private Node head; //带空头的循环链表
        private class Node {
            int data; //1代表存活，0代表出局
            int id; //编号
            Node next;
        }

        public CycleLinkedList() {
            head = new Node();
            head.next = null; //空表情况
        }

        public void tailInsert(int n) {
            Node tail = head;
            while(n-- != 0) {
                Node node = new Node();
                node.data = 1;
                node.id = ++id;
                tail.next = node;
                tail = node;
            }
            tail.next = head.next;
        }

        int startGame() {
            int live = num; //还在场上的猴子数量
            int start = startId;
            Node cur = head;
            while(start-- != 0) {
                cur = cur.next;
            } //从startId号猴子开始
            while(true) {
                int i = k;
                while (--i != 0) {
                    do {
                        cur = cur.next;
                    } while (cur.data != 1);
                }
                cur.data = 0; //出局
                live--;
                System.out.println(cur.id + "号猴出局");
                do {
                    cur = cur.next;
                } while (cur.data != 1);
                if(live == 1) return cur.id;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new JosephusProblem().list.startGame() + "号猴被选为大王");
    }

}
