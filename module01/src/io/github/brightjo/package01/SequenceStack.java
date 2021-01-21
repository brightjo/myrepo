package io.github.brightjo.package01;

import java.util.*;

public class SequenceStack<T>{
    private T data[]; //数组实现
    private int top; //记录栈顶索引位置
    private int size; //记录size
    private int MAX_SIZE = 2; //记录最大容量

    SequenceStack() {
        data = (T[])new Object[MAX_SIZE];
        top = -1; //-1标志着空栈
        size = 0;
    }
    //进栈
    void push(T x) {
        data[++top] = x;
        size++;
        if(size == MAX_SIZE) {
            data = Arrays.copyOf(data,2*MAX_SIZE);
            MAX_SIZE *= 2;
        } //动态扩容 每次自动增长两倍
    }
    //出栈
    T pop() throws EmptyStackException {
        if(top == -1) {
            System.out.println("空栈，无法pop");
            throw new EmptyStackException();
        } //判断空栈异常
        T res = data[top--];
        size--;
        return res;
    }
    //访问栈顶元素
    T peek() {
        return data[top];
    }
    //获取size
    int size() {
        return size;
    }
    //判空
    boolean isEmpty() {
        return top == -1;
    }
    //toString方法 方便打印栈
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("From bottom to top: ---->\n");
        if(top == -1) return stringBuilder.toString();
        int cur = 0;
        stringBuilder.append(data[cur++]);
        while(cur <= top) {
            stringBuilder.append(" " + data[cur++]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SequenceStack sequenceStack = new SequenceStack<Integer>();
        //测试 判空
        System.out.println(sequenceStack.isEmpty());
        //测试 进栈
        sequenceStack.push(23);
        sequenceStack.push(5);
        sequenceStack.push(6);
        //测试 访问栈顶元素
        System.out.println(sequenceStack.peek());
        System.out.println(sequenceStack.peek());
        //测试 出栈
        System.out.println(sequenceStack.pop());
        System.out.println(sequenceStack.pop());
        //测试 获取size
        System.out.println(sequenceStack.size());
        //测试 判空
        System.out.println(sequenceStack.isEmpty());
        //测试 打印栈
        System.out.println(sequenceStack);
    }
}
