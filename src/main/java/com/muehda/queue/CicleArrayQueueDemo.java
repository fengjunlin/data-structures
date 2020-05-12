package com.muehda.queue;

/**
 * @Description
 * @Author fengjl
 * @Date 2019/8/15 21:01
 * @Version 1.0
 **/
public class CicleArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class CicleArrayQuee {
    private int maxSize;
    private int front; // 指定正好是数据的位置
    private int real; // 指定为数据的后一个位置，所以会空一个位置出来
    private int[] arr;

    private CicleArrayQuee(int num) {
        arr = new int[num];
        front = 0;
        real = 1;
        maxSize = num;
    }

    // 判断队列中是否满
    public boolean isFull() {
        return (real + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return real == front;
    }

    // 向队列中添加一个元素
    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("队列中的数据满了。。。。");
            return;
        }
        arr[real + 1] = num;
        real = (real + 1) % maxSize; // 考虑到环形这种情况
    }

    // 取出队列中的一个元素
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列中的数据为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 判断队列中有多个个元素
    // 好好想想
    public int size() {
        return (real + maxSize - front) % maxSize;
    }

    // 显示队列中的所有元素
    public void showData(){
        for (int i = front; i < front + size(); i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

    // 显示队列头部的信息
    public int headData() {
        if (isEmpty()) {
            throw  new RuntimeException("队列为空");
        }
        return arr[front];
    }


}





























