package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;
    private int head = -1;
    private int tail = -1;

    public MyRingArrayQueue() { this(10); }
    public MyRingArrayQueue(int capacity) {
        data = new Object[capacity];
    }

    @Override
    public void enqueue(T value) {
        /*if (isEmpty()) {
            data[0] = value;
            head = 0;
            tail = 0;
        }else if ( tail < data.length - 1) { //space available
            tail ++;
            data[tail] = value;
        }else {
            if (head > 0 && head != tail) { //search for empty space
                for (int i = 0; i < head; i++) {
                 if (data[i] == null) {
                     tail = i;
                    break;
                }
                }
            data[tail] = value;
            }
            if (head == 0 || tail == head) { //full array
                Object[] copy = new Object[data.length];
                for (int i = 0; i < data.length; i++) {
                    copy[i] = data[i];
                }
                data = new Object[(data.length * 2)];
                for (int k = 0; k < copy.length; k++) {
                    data[k] = copy[k];
                }
                tail++;
                data[tail] = value;
            }
        }*/

        /*if (isEmpty()) {
            data[0] = value;
            head = 0;
            tail = 0;
        }else if ( tail < data.length - 1 && size() < data.length) { //space available
            tail ++;
            data[tail] = value;
        }else {
            if (head > 0 && size() < data.length) { //empty spaces available
                for (int i = 0; i < head; i++) {
                    if (data[i] == null) {
                        tail = i;
                        data[tail] = value;
                        break;
                    }
                }
            } else if (size() >= data.length) { //full array
                Object[] copy = new Object[data.length];
                for (int i = 0; i < data.length; i++) {
                    copy[i] = data[i];
                }
                tail = data.length;
                data = new Object[(data.length * 2)];
                for (int k = 0; k < copy.length; k++) {
                    data[k] = copy[k];
                }
                data[tail] = value;
                }
        }*/

        if (isEmpty()) {
            data[0] = value;
            head = 0;
            tail = 0;
        }else if (size() < data.length) { //space available
            if (tail < data.length - 1) {
                tail ++;
                data[tail] = value;
            } else if ( tail >= data.length - 1) { // empty spaces available
                for (int i = 0; i < head; i++) {
                    if (data[i] == null) {
                        tail = i;
                        data[tail] = value;
                        break;
                    }
                }
            }
        }else if (size() == data.length) { //full array
            Object[] copy = new Object[data.length];
            for (int i = 0; i < data.length; i++) {
                if ((i + head) == data.length) {
                    break;
                }
                copy[i] = data[i + head];
            }
            if (copy[data.length - 1] == null) {
                int counter = 0;
                for (int i = (data.length - head); i < data.length; i++) {
                    copy[i] = data[counter];
                    counter++;
                }
            }
            tail = data.length;
            data = new Object[(data.length * 2)];
            for (int k = 0; k < copy.length; k++) {
                data[k] = copy[k];
            }
            data[tail] = value;
            head = 0;
        }

    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        }

        T el = (T) data[head];

        if (size() == 1) {
            head = -1;
            tail = -1;
        } else {
            data[head] = null;
            if (head < data.length - 1) {
                head ++;
            } else {
                head = 0;
            }
        }

        return el;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }

        return (T) data[head];
    }

    @Override
    public int size() {
        if (head < 0) {
            return 0;
        }

        /*if (head > tail) {
            return data.length - ((head - tail) - 1);
        }

        if (head == tail) {
            return head + 1;
        }/*

        /*int counter = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                counter ++;
            }
        }
        return counter;*/

        if (head == tail) {
            return (tail - head) + 1;
        }

        if (head > tail) {
            int size = data.length - head;
            size += (tail + 1);
            return size;
        }

        return (tail - head) + 1;

    }

    /*private int sizeCheck() {
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                counter ++;
            }
        }
        return counter;
    }*/
}
