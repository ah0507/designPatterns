package com.chensee.collection.common;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ah
 * @title: util
 * @date 2020/5/5 21:46
 */
public class Util {

    public static void main(String[] args) {
        //二分查找
        int[] arrs = {1, 3, 5, 6, 13, 16, 35, 55, 73, 93, 101};
        int i = secondSearch(arrs, 0, arrs.length, 93);
        if (i != -1) {
            System.out.println(i + "-----" + arrs[i]);
        }
        Arrays.sort(arrs);

        //冒泡排序
        int arrs2[] = {11,42,33,52,61,115,21,87};
        System.out.println(bubbleSort(arrs2));
        AtomicInteger atomicInteger = new AtomicInteger();
    }

    private static int[] bubbleSort(int[] arrs2) {
        if (arrs2.length <= 1) {
            return null;
        }
        int[] target = new int[arrs2.length];
        //外层循环控制比较轮数
        for (int i = 0; i < arrs2.length-1; i++) {
            //内层循环控制每轮比较次数
            for (int j = 0; j < arrs2.length - i - 1; j++) {
                //从小到大
                if (arrs2[j] > arrs2[j+1]) {
                    int temp = arrs2[j];
                    arrs2[j] = arrs2[j + 1];
                    arrs2[j+1] = temp;
                }
            }
        }
        return arrs2;
    }

    private static int binSearch(int[] sources, int start, int end, int target) {
        int mid = (end - start) / 2 + start;
        int source = sources[mid];
        if (source == target) {
            return mid;
        }
        if (start > end) {
            return -1;
        } else if (target > source) {
            return binSearch(sources, mid + 1, end, target);
        } else if (target < source) {
            return binSearch(sources, start, mid - 1, target);
        } else {
        }
        return -1;
    }

    public static int secondSearch(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = (end - start) / 2 + start;
        int midValue = arr[mid];
        if (midValue == key) {
            return mid;
        } else if (midValue > key) {
            return secondSearch(arr, start, mid - 1, key);
        } else if (key > mid) {
            return secondSearch(arr, mid + 1, end, key);
        }
        return -1;
    }

}
