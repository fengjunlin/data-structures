package com.muehda.queue;

/**
 * @Description
 * @Author fengjl
 * @Date 2019/8/14 22:34
 * @Version 1.0
 **/
public class ArrayQueueDemo {
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int real;
    private int[] arr;

    public ArrayQueue(int num) {
        arr = new int[num];
        front = -1; // 指队列头部的前一个位置
        real = -1; // 指向队列的尾部数据的位置，即队列最后的位置
        maxSize = num;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == real;
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return real + 1 == maxSize;
    }


    /**
     * 向队列中添加数据
     */
    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("队列中满了。。。。");
            return;
        } else {
            arr[real + 1] = num;
            real++;
        }
    }

    /**
     * 获取队列中数，出队列
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列中的数据为空");
        }
            int value = arr[front + 1];
            front++;
            return value;
    }

    /**
     * 显示队列中的所有数据
     */
    public void getAllData(){
        if (isEmpty()) {
            System.out.println("队列中数据为空");
        }
        for (int i = front+1; i <= real; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 显示队列的头部数据
     */
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列中的数据为空。。。");
        }
        return arr[front+1];
    }


}
