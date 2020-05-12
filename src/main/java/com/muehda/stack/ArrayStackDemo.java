package com.muehda.stack;

/**
 * @Description 栈的两种实现方式
 * @Author fengjl
 * @Date 2019/8/18 19:29
 * @Version 1.0
 **/
public class ArrayStackDemo {
}

class ArrayStack {
    private int maxSize;
    private int top = -1;
    private int[] arr;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void add(int num) {
        if (isFull()) {
            System.out.println("满了");
        } else {
            top++;
            arr[top] = num;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空");
        } else {
            int value = arr[top];
            top--;
            return value;
        }
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("kong");
            return;
        }

        for (int i = top; i >= 0; i++) {
            System.out.println(arr[i]);
        }
    }
}
