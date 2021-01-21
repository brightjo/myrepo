package io.github.brightjo.package01;

class EmptyQueueException extends Exception {
    EmptyQueueException() {
        System.out.println("空队列");
    }
}

public class CycleQueue<E> {
    private E[] data;
    private int head;
    private int tail;
    private int size;
    private int MaxSize = 3;

    CycleQueue() {
        data = (E[]) new Object[MaxSize];
        head = -1;
        tail = -1;
        size = 0;
    }

    void add(E x) {
        if (size >= MaxSize) {
            AddCapacity();
        } else if (size <= MaxSize / 2) {
            LessenCapacity();
        }
        head = head == -1 ? 0 : head;
        tail = (tail + 1) % MaxSize;
        data[tail] = x;
        size++;
    }

    private void LessenCapacity() {
        E[] tmp = (E[]) new Object[MaxSize/2+1];
        int k = 0;
        for (int i = head, N = size; N-- != 0; i = (i + 1) % MaxSize) {
            tmp[k++] = data[i];
        }
        head = 0;
        tail = size - 1;
        data = tmp;
        MaxSize = MaxSize/2+1;
    }

    private void AddCapacity() {
        E[] tmp = (E[]) new Object[2 * MaxSize];
        int k = 0;
        for (int i = head, N = size; N-- != 0; i = (i + 1) % MaxSize) {
            tmp[k++] = data[i];
        }
        head = 0;
        tail = size - 1;
        data = tmp;
        MaxSize *= 2;
    }

    E poll() throws EmptyQueueException {
        if (head != -1) {
            E res = data[head];
            head = (head + 1) % MaxSize;
            size--;
            if (size == 0) {
                head = -1;
                tail = -1;
            }
            return res;
        } else {
            throw new EmptyQueueException();
        }
    }

    E peek() throws EmptyQueueException {
        if (head != -1) {
            return data[head];
        } else {
            throw new EmptyQueueException();
        }
    }

    E getTail() throws EmptyQueueException {
        if (tail != -1) {
            return data[tail];
        } else {
            throw new EmptyQueueException();
        }
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("From head to tail ----->\n");
        for (int i = head, N = size; N-- != 0; i = (i + 1) % MaxSize) {
            sb.append(data[i] + " ");
        }
        return sb.toString();
    }

    E get(int index) {
        return data[index];
    }

    public static void main(String[] args) throws EmptyQueueException {
        CycleQueue<Integer> cycleQueue = new CycleQueue<Integer>();
        cycleQueue.add(2);
        cycleQueue.add(3);
        System.out.println(cycleQueue.get(1));
        
    }

}
