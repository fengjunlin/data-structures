package com.muehda.sort;

/**
 * @Description 基数排序
 * @Author fengjl
 * @Date 2019/9/17 13:56
 * @Version 1.0
 **/
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {52, 15, 23, 78, 95, 100};
        radixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void radixSort(int[] arr) {
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        int maxLength = String.valueOf(maxValue).length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElement = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int elementiIndex = arr[j] / n % 10;
                bucket[elementiIndex][bucketElement[elementiIndex]] = arr[j];
                bucketElement[elementiIndex]++;
            }

            // 然后再装回去
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                if (bucketElement[k] != 0) {
                    for (int j = 0; j < bucketElement[k]; j++) {
                        arr[index++] = bucket[k][j];
                    }
                    bucketElement[k] = 0;
                }
            }


        }
    }


}
