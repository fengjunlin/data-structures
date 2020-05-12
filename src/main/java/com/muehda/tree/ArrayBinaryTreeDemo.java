package com.muehda.tree;

/**
 * @Description 数组和二叉树之间的转换
 * @Author fengjl
 * @Date 2019/9/23 13:35
 * @Version 1.0
 **/
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {

    }
}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int no) {
        System.out.println(no);
        if (2 * no + 1 < arr.length) {
            preOrder(2 * no + 1);
        }
        if (2 * no + 2 < arr.length) {
            preOrder(2 * no + 2);
        }
    }
}

