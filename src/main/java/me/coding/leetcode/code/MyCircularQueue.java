package me.coding.leetcode.code;

class MyCircularQueue {
    int front, rear;
    int[] queue;
    int size, filled;

    public MyCircularQueue(int k) {
        front = -1;
        rear = -1;
        filled = 0;
        queue = new int[k];
        size = k;
    }

    public boolean enQueue(int value) {
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
            queue[rear] = value;
            filled++;
            return true;
        } else if (!isFull()) {
            rear = (rear + 1) % size;
            queue[rear] = value;
            filled++;
            return true;
        } else {
            return false;
        }

    }

    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % size;
            filled--;
            return true;
        }else{
            return false;
        }
    }

    public int Front() {
        if (!isEmpty()) {
            return queue[front];
        } else return -1;
    }

    public int Rear() {
        if (!isEmpty()) {
            return queue[rear];
        } else return -1;
    }

    public boolean isEmpty() {
        return filled == 0;
    }

    public boolean isFull() {
        return filled == size;
    }
}
