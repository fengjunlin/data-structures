package com.muehda.digui;

/**
 * @Description 递归实现1-100之间的加法 (从栈的角度分析问题)
 * @Author fengjl
 * @Date 2019/8/31 11:12
 * @Version 1.0
 * 递推就是自己调用自己，一定要深刻的理解图解的调用方式了解递归
 **/
public class RecursionTest {
    public static void main(String[] args) {
        /**
         * 1、每次递归的时候，都会有一个新的栈帧
         * 2、每个栈帧中的局部变量表示独立的
         * 3、递归必须有出口，不然会栈内存溢出
         * 4、在处理的引用类型的时候要注意
         * 5、谁调用，就把结果返回给谁，在得到返回结果之后，继续在调用的位置向下继续执行
         */

        int test = test(10000);
        System.out.println(test);
        test2(4);
    }

    public static int test(int n) {
        if (n >= 0) {
            return n + test(n - 1);
        }
        return 0;
    }

    public static void test2(int n) {
        if (n > 2) {
            test2(n-1);
        } else {
            System.out.println(n);
        }

    }
}
