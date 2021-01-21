package io.github.brightjo.package01;
public class LinkedQueue<E>{
    private class Node {
        E data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    void add(E x) {
        Node node = new Node();
        node.data = x;
        if(tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    E poll() throws EmptyQueueException {
        E res = null;
        if(head != null) {
            res = head.data;
            head = head.next;
            size--;
            return res;
        } else {
            throw new EmptyQueueException();
        }
    }

    E peek() throws EmptyQueueException {
        if(head != null) return head.data;
        throw new EmptyQueueException();
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return tail == null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("From head to tail: ---->\n");
        if(tail == null) return stringBuilder.toString();
        stringBuilder.append(head.data);
        Node cur = head.next;
        while(cur != null) {
            stringBuilder.append(" " + cur.data);
            cur = cur.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws EmptyQueueException{
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<Integer>();
        linkedQueue.add(2);
        linkedQueue.add(3);
        linkedQueue.add(4);
        System.out.println(linkedQueue.peek());
        System.out.println(linkedQueue.size());
        System.out.println(linkedQueue.poll());
        System.out.println(linkedQueue.poll());
        linkedQueue.poll();
        linkedQueue.poll();
        linkedQueue.poll();
    }
}
