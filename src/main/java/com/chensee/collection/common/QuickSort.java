package com.chensee.collection.common;

/**
 * @author ah
 * @title: QuickSort
 * @date 2020/5/7 14:20
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {14, 9, 10, 23, 77, 78, 1, 20, 79, 5, 31};
//        quickSort(arr);
        getQuick(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("args = [" + arr[i] + "]");
        }
    }

    public static void quickSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            quickSort(arr, 0, middle - 1);//操作中心点左边的数据
            quickSort(arr, middle + 1, high);
        }

    }

    /**
     * 获取中心点
     */
    public static int getMiddle(int[] arr, int low, int high) {
        int povit = arr[low];//默认为基准
        while (low < high) {
            while (low < high && arr[high] >= povit) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= povit) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = povit;//找到的中心节点的位置就是low所处的位置，将值改为基准的值
        return low;
    }

    public static void getOrder(int[] arrs) {
        if (arrs.length != 0) {
            quicklyOrder(arrs, 0, arrs.length - 1);
        }
    }

    private static void quicklyOrder(int[] arrs, int low, int height) {
        if (height > low) {
            int mid = getMid(arrs, low, height);
            quicklyOrder(arrs, low, mid - 1);
            quicklyOrder(arrs, mid + 1, height);
        }
    }

    private static int getMid(int[] arrs, int low, int height) {
        int basic = arrs[low];
        while (low < height) {
            while (low < height && arrs[height] >= basic) {
                height--;
            }
            arrs[low] = arrs[height];
            while (low < height && arrs[low] <= basic) {
                low++;
            }
            arrs[height] = arrs[low];
        }
        arrs[low] = basic;
        return low;
    }

    public static void getQuick(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        quickOrder1(arr, 0, arr.length-1);
    }

    private static void quickOrder1(int[] arr, int low, int high) {
        if (low < high) {
            int mid = getMid2(arr, low, high);
            quickOrder1(arr, low, mid - 1);
            quickOrder1(arr, mid + 1, high);
        }
    }

    private static int getMid2(int[] arr, int low, int high) {
        int basic = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= basic) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= basic) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = basic;
        return low;
    }
}
