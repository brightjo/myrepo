package io.github.brightjo.package01;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class LinkedList<E> {
    Node<E> head;
    private String genericClass;
    static Scanner scanner;

    private static class Node<E> {
        E data;
        Node<E> next;

        public String toString() {
            return "" + data;
        }
    }

    public Class<E> getT() {
        Type type = getClass().getGenericSuperclass();
        Type[] parameter = ((ParameterizedType) type).getActualTypeArguments();
        return (Class<E>) parameter[0];
    }

    LinkedList() {
        head = new Node<E>();
        String[] arr = getT().toString().split("\\.");
        int len = arr.length;
        genericClass = arr[len - 1];
        scanner = new Scanner(System.in);
    }

    private E input() {
        E res = null;
        if (scanner.hasNext()) {
            if (genericClass.equals("Integer")) {
                res = (E) (Integer) scanner.nextInt();
            } else if (genericClass.equals("Float")) {
                res = (E) (Float) scanner.nextFloat();
            } else if (genericClass.equals("Byte")) {
                res = (E) (Byte) scanner.nextByte();
            } else if (genericClass.equals("Short")) {
                res = (E) (Short) scanner.nextShort();
            } else if (genericClass.equals("Long")) {
                res = (E) (Long) scanner.nextLong();
            } else if (genericClass.equals("Double")) {
                res = (E) (Double) scanner.nextDouble();
            } else if (genericClass.equals("String")) {
                res = (E) scanner.next();
            } else if (genericClass.equals("Character")) {
                res = (E) (Character) scanner.next().charAt(0);
            } else if (genericClass.equals("BigInteger")) {
                res = (E) (BigInteger) scanner.nextBigInteger();
            } else if (genericClass.equals("BigDecimal")) {
                res = (E) (BigDecimal) scanner.nextBigDecimal();
            } else {
                System.out.println("暂时不支持此种数据类型 " + genericClass);
            }
        }
        return res;
    }

    public void tailInput() {
        Node<E> tail = head;
        while (scanner.hasNext()) {
            Node<E> node = new Node<E>();
            node.data = input();
            if (node.data == null) {
                return;
            }
            tail.next = node;
            tail = node;
        }
    }


    public void tailInput(int n) {
        if (n <= 0) {
            System.out.println("输入数目不正确");
            return;
        }
        Node<E> tail = head;
        while (n-- > 0) {
            Node<E> node = new Node<E>();
            node.data = input();
            if (node.data == null) {
                return;
            }
            tail.next = node;
            tail = node;
        }
    }

    public void headInput(int n) {
        if (n <= 0) {
            System.out.println("输入数目不正确");
            return;
        }
        Node<E> Head = head;
        while (n-- > 0) {
            Node<E> node = new Node<E>();
            node.data = input();
            if (node.data == null) {
                return;
            }
            node.next = Head.next;
            Head.next = node;
        }
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        String str = "head";
        Node<E> cur = head.next;
        while (cur != null) {
            str += ("->" + cur.data);
            cur = cur.next;
        }
        return str;
    }

    public int length() {
        Node<E> cur = head;
        int i = 0;
        while (cur.next != null) {
            cur = cur.next;
            i++;
        }
        return i;
    }

    public Node<E> getNode(int k) {
        if (k < 1 || k > length()) {
            return null;
        }
        Node<E> cur = head;
        while (k-- > 0) {
            cur = cur.next;
        }
        return cur;
    }

    public Node<E> getPreviousNode(Node<E> node) {
        Node<E> cur = head;
        while (cur.next != null && cur.next != node) {
            cur = cur.next;
        }
        return cur;
    }

    public void insert(E x, int k) {
        if (k < 1 || k > length() + 1) {
            System.out.println("插入位置不正确");
            return;
        }
        Node<E> eNode = new Node<>();
        eNode.data = x;
        Node<E> preNode = getPreviousNode(getNode(k));
        eNode.next = preNode.next;
        preNode.next = eNode;
    }

    public void delete(int k) {
        if (k < 1 || k > length()) {
            System.out.println("删除位置不正确");
            return;
        }
        Node<E> node = getPreviousNode(getNode(k));
        node.next = node.next.next;
    }

    public Node<E> find(E x) {
        Node<E> cur = head.next;
        while (cur != null) {
            if (cur.data.equals(x)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public Node<E> findPreviousNode(E x) {
        Node<E> res = find(x);
        if (res == null) {
            System.out.println("没找到元素" + x);
            return null;
        }
        return getPreviousNode(res);
    }

    public void deleteX(E x) {
        Node<E> res = find(x);
        if (res == null) {
            System.out.println("没找到元素" + x);
            return;
        }
        Node<E> preNode = getPreviousNode(res);
        preNode.next = preNode.next.next;
    }

    public boolean isEmpty() {
        return length() == 0 ? true : false;
    }

    public void clear() {
        head.next = null;
        System.out.println("清空完毕");
    }

    public void setNodeData(E x, int k) {
        if (k < 1 || k > length()) {
            System.out.println("输入位置不正确");
            return;
        }
        getNode(k).data = x;
        System.out.println("修改节点data完毕");
    }

    public int get_X_Num(E x) {
        int res = 0;
        Node<E> cur = head.next;
        while(cur != null) {
            if(cur.data.equals(x))   res++;
            cur = cur.next;
        }
        return res;
    }

    public static int menu() {
        System.out.println("\n\n\t\t-------------请选择一个操作------------\n" +
                "\t\t---------------------------------------\n" +
                "\t\t---------1 查找值为x的元素-------------\n" +
                "\t\t---------2 删除值为的x元素-------\n" +
                "\t\t---------3 插入新的节点在第i个位置上-------\n" +
                "\t\t---------4 获取第i个位置上的元素-------\n" +
                "\t\t---------5 修改第i个位置上的元素值-----\n" +
                "\t\t---------6 打印链表------------------------\n" +
                "\t\t---------7 清空------------------------\n" +
                "\t\t---------8 获取泛型链表的类型------------------------\n" +
                "\t\t---------9 尾插法插入n个节点------------------------\n" +
                "\t\t---------10头插法插入n个节点------------------------\n" +
                "\t\t---------11获取表长------------------------\n" +
                "\t\t---------12删除第i个元素------------------------\n" +
                "\t\t---------13查找值为x的节点的前一个节点------------------------\n" +
                "\t\t---------14判断链表是否为空------------------------\n" +
                "\t\t---------15获取值为x的节点的个数------------------------\n" +
                "\t\t---------0 退出------------------------\n" +
                "\t\t---------------------------------------\n" +
                "\t\t---------请选择：");
        int choose = Integer.valueOf(scanner.next());
        return choose;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>() {
        };
        //linkedList.tailInput();
        while (true) {
            int choose = menu();
            switch (choose) {
                case 1: {
                    System.out.println("请输入你要查找的数据元素值：");
                    if (linkedList.find(linkedList.input()) != null) {
                        System.out.println("找到了");
                    } else {
                        System.out.println("没有该元素");
                    }
                    break;
                }
                case 2: {
                    System.out.println("请输入你要删除的元素的值");
                    linkedList.deleteX(linkedList.input());
                    break;
                }
                case 3: {
                    System.out.println("请输入你要插入的数据元素值和位置");
                    linkedList.insert(linkedList.input(), scanner.nextInt());
                    break;
                }
                case 4: {
                    System.out.println("请输入你要获取的数据元素的位置");
                    Node<?> node;
                    if ((node = linkedList.getNode(scanner.nextInt())) != null)
                        System.out.println("获取到元素" + node.data);
                    else System.out.println("输入位置不正确");
                    break;
                }
                case 5: {
                    System.out.println("实现修改，请输入修改数据和节点位置");
                    linkedList.setNodeData(linkedList.input(), scanner.nextInt());
                    break;
                }
                case 6: {
                    linkedList.print();
                    break;
                }
                case 7: {
                    linkedList.clear();
                    break;
                }
                case 8: {
                    System.out.println(linkedList.getT());
                    break;
                }
                case 9: {
                    System.out.println("请输入尾插法要插入节点的数目和元素值：");
                    linkedList.tailInput(scanner.nextInt());
                    break;
                }
                case 10: {
                    System.out.println("请输入头插法要插入节点的数目和元素值：");
                    linkedList.headInput(scanner.nextInt());
                    break;
                }
                case 11: {
                    System.out.println("表长：" + linkedList.length());
                    break;
                }
                case 12: {
                    System.out.println("请输入要删除第几个节点：");
                    linkedList.delete(linkedList.input());
                    break;
                }
                case 13: {
                    System.out.println("请输入值x");
                    System.out.println(linkedList.findPreviousNode(linkedList.input()));
                    break;
                }
                case 14: {
                    System.out.println(linkedList.isEmpty());
                    break;
                }
                case 15: {
                    System.out.println("请输入值x的值：");
                    System.out.println("结果：" + linkedList.get_X_Num(linkedList.input()));
                    break;
                }
                case 0: {
                    scanner.close();
                    System.out.println("退出");
                    return;
                }
            }
        }
    }
};
