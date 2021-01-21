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
                System.out.println("��ʱ��֧�ִ����������� " + genericClass);
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
            System.out.println("������Ŀ����ȷ");
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
            System.out.println("������Ŀ����ȷ");
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
            System.out.println("����λ�ò���ȷ");
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
            System.out.println("ɾ��λ�ò���ȷ");
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
            System.out.println("û�ҵ�Ԫ��" + x);
            return null;
        }
        return getPreviousNode(res);
    }

    public void deleteX(E x) {
        Node<E> res = find(x);
        if (res == null) {
            System.out.println("û�ҵ�Ԫ��" + x);
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
        System.out.println("������");
    }

    public void setNodeData(E x, int k) {
        if (k < 1 || k > length()) {
            System.out.println("����λ�ò���ȷ");
            return;
        }
        getNode(k).data = x;
        System.out.println("�޸Ľڵ�data���");
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
        System.out.println("\n\n\t\t-------------��ѡ��һ������------------\n" +
                "\t\t---------------------------------------\n" +
                "\t\t---------1 ����ֵΪx��Ԫ��-------------\n" +
                "\t\t---------2 ɾ��ֵΪ��xԪ��-------\n" +
                "\t\t---------3 �����µĽڵ��ڵ�i��λ����-------\n" +
                "\t\t---------4 ��ȡ��i��λ���ϵ�Ԫ��-------\n" +
                "\t\t---------5 �޸ĵ�i��λ���ϵ�Ԫ��ֵ-----\n" +
                "\t\t---------6 ��ӡ����------------------------\n" +
                "\t\t---------7 ���------------------------\n" +
                "\t\t---------8 ��ȡ�������������------------------------\n" +
                "\t\t---------9 β�巨����n���ڵ�------------------------\n" +
                "\t\t---------10ͷ�巨����n���ڵ�------------------------\n" +
                "\t\t---------11��ȡ��------------------------\n" +
                "\t\t---------12ɾ����i��Ԫ��------------------------\n" +
                "\t\t---------13����ֵΪx�Ľڵ��ǰһ���ڵ�------------------------\n" +
                "\t\t---------14�ж������Ƿ�Ϊ��------------------------\n" +
                "\t\t---------15��ȡֵΪx�Ľڵ�ĸ���------------------------\n" +
                "\t\t---------0 �˳�------------------------\n" +
                "\t\t---------------------------------------\n" +
                "\t\t---------��ѡ��");
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
                    System.out.println("��������Ҫ���ҵ�����Ԫ��ֵ��");
                    if (linkedList.find(linkedList.input()) != null) {
                        System.out.println("�ҵ���");
                    } else {
                        System.out.println("û�и�Ԫ��");
                    }
                    break;
                }
                case 2: {
                    System.out.println("��������Ҫɾ����Ԫ�ص�ֵ");
                    linkedList.deleteX(linkedList.input());
                    break;
                }
                case 3: {
                    System.out.println("��������Ҫ���������Ԫ��ֵ��λ��");
                    linkedList.insert(linkedList.input(), scanner.nextInt());
                    break;
                }
                case 4: {
                    System.out.println("��������Ҫ��ȡ������Ԫ�ص�λ��");
                    Node<?> node;
                    if ((node = linkedList.getNode(scanner.nextInt())) != null)
                        System.out.println("��ȡ��Ԫ��" + node.data);
                    else System.out.println("����λ�ò���ȷ");
                    break;
                }
                case 5: {
                    System.out.println("ʵ���޸ģ��������޸����ݺͽڵ�λ��");
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
                    System.out.println("������β�巨Ҫ����ڵ����Ŀ��Ԫ��ֵ��");
                    linkedList.tailInput(scanner.nextInt());
                    break;
                }
                case 10: {
                    System.out.println("������ͷ�巨Ҫ����ڵ����Ŀ��Ԫ��ֵ��");
                    linkedList.headInput(scanner.nextInt());
                    break;
                }
                case 11: {
                    System.out.println("����" + linkedList.length());
                    break;
                }
                case 12: {
                    System.out.println("������Ҫɾ���ڼ����ڵ㣺");
                    linkedList.delete(linkedList.input());
                    break;
                }
                case 13: {
                    System.out.println("������ֵx");
                    System.out.println(linkedList.findPreviousNode(linkedList.input()));
                    break;
                }
                case 14: {
                    System.out.println(linkedList.isEmpty());
                    break;
                }
                case 15: {
                    System.out.println("������ֵx��ֵ��");
                    System.out.println("�����" + linkedList.get_X_Num(linkedList.input()));
                    break;
                }
                case 0: {
                    scanner.close();
                    System.out.println("�˳�");
                    return;
                }
            }
        }
    }
};
