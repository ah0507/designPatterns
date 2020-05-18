package com.chensee.collection.common;

/**
 * @author ah
 * @title: MergeSort 归并排序
 * @date 2020/5/7 15:27
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 27, 23, 2, 62, 98, 13, 15, 2};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "、");
        }
    }

    public static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int arr[], int left, int mid, int right) {
        int temArr[] = new int[arr.length];
        int rs = mid + 1;//右边数组开始的下标
        int point = left;//temArr数组下标
        int temp = left;//用于赋值数组的下标
        while (left <= mid && rs <= right) {
            if (arr[left] <= arr[rs]) {
                temArr[point++] = arr[left++];
            } else {
                temArr[point++] = arr[rs++];
            }
        }
        while (left <= mid) {
            temArr[point++] = arr[left++];
        }
        while (rs <= right) {
            temArr[point++] = arr[rs++];
        }
        while (temp <= right) {
            arr[temp] = temArr[temp++];
        }
    }
}
