package com.muehda.sort;

/**
 * @Description 选择排序算法
 * @Author fengjl
 * @Date 2019/9/4 23:31
 * @Version 1.0
 **/
public class Sort {
    public static void main(String[] args) {
        // 给一个数组然后开始排序
        int[] aa = {1, 52, 5, 9, 4, 7, 3, -1};
        shellSort(aa);
        for (int i = 0; i < aa.length; i++) {
            System.out.print(aa[i] + " ");
        }
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubleSort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    /**
     * //     * 选择排序
     *
     * @param array
     */
    public static void selectSort(int[] array) {

        /*for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }*/

        for (int i = 0; i < array.length - 1; i++) {
            int minValue = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > minValue) {
                    minValue = array[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                array[i] = minValue;
            }
        }
    }

    /**
     * charu
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int indexStart = i - 1;
            int value = array[i];
            while (indexStart >= 0 && value < array[indexStart]) {
                array[indexStart + 1] = array[indexStart];
                indexStart--;
            }
            if (indexStart + 1 != i) {
                array[indexStart + 1] = value;
            }
        }
    }

    /**
     * 希尔排序
     * 是对插入排序的改进版，明白其中的思想精髓
     */
    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < array.length; i++) {
                // 对灭个间隔开始进行插入排序
                int j = i;
                int value = array[j];
                while (j-gap >= 0 && value < array[j-gap]) {
                    array[j] = array[j-gap];
                    j-=gap;
                }
                array[j] = value;
            }
        }
    }

}
