package com.muehda.digui;

/**
 * @Description 回溯算法经典问题(八方后问题)
 * @Author fengjl
 * @Date 2019/8/31 13:40
 * @Version 1.0
 **/
public class BaHangHou {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        BaHangHou baHangHou = new BaHangHou();
        baHangHou.check(0);
        System.out.println(count);

    }

    public void check(int n) {
        // 如果最大那么久结束，及已经找到了
        if (n == max) {
            print();
            count++;
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n+1);
            }
        }
    }



    /**
     * 检验第n哥皇后是否和前面的所有皇后冲突
     *
     * @param n
     * @return
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印所有的这个数组的所有的元素
     */
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
