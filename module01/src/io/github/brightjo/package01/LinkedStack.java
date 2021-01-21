package io.github.brightjo.package01;

import java.util.*;

public class LinkedStack<T>{
    private Node top; //栈顶引用
    private int size; //记录size

    private class Node {
        T data;
        Node next;
    }

    LinkedStack() {
        top = null; //null标志着空栈
        size = 0;
    }

    //进栈
    void push(T x) {
        Node node = new Node();
        node.data = x;
        node.next = top;
        top = node;
        size++;
    }
    //出栈
    T pop() throws EmptyStackException {
        if(top == null) {
            System.out.println("空栈，无法pop");
            throw new EmptyStackException();
        } //判断空栈异常
        T res = top.data;
        top = top.next;
        size--;
        return res;
    }
    //访问栈顶元素
    T peek() {
        if(top == null) {
            return null;
        }
        return top.data;
    }
    //获取size
    int size() {
        return size;
    }
    //判空
    boolean isEmpty() {
        return top == null;
    }
    //toString方法 方便打印栈
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("From bottom to top: ---->\n");
        if(top == null) return stringBuilder.toString();
        stringBuilder.append(top.data);
        Node cur = top.next;
        while(cur != null) {
            stringBuilder.append(" " + cur.data);
            cur = cur.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack<Integer>();
        //测试 判空
        System.out.println(linkedStack.isEmpty());
        //测试 进栈
        linkedStack.push(33);
        linkedStack.push(44);
        linkedStack.push(666);
        //测试 访问栈顶元素
        System.out.println(linkedStack.peek());
        System.out.println(linkedStack.peek());
        //测试 出栈
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        //测试 获取size
        System.out.println(linkedStack.size());
        //测试 判空
        System.out.println(linkedStack.isEmpty());
        //测试 打印栈
        System.out.println(linkedStack);
    }
}
