package com.muehda.digui;

/**
 * @Description 递归实现阶乘
 * @Author fengjl
 * @Date 2019/8/31 11:54
 * @Version 1.0
 **/
public class jiecheng {
    public static void main(String[] args) {
        int jiecheng = jiecheng(3);
        System.out.println(jiecheng);
    }

    public static int jiecheng(int n) {
        if (n == 1) {
            return 1;
        } else {
            return jiecheng(n - 1) * n;
        }
    }
}
