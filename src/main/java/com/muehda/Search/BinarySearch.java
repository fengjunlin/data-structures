package com.muehda.Search;

/**
 * @Description
 * @Author fengjl
 * @Date 2019/9/18 15:04
 * @Version 1.0
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,7,7,8,9,10};
        int i = binarySearch(arr, 0, 9, 100);
        System.out.println(i);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (right + left) / 2;
        if (findVal > arr[mid]) {
          return   binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
           return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
