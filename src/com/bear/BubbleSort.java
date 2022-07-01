package com.bear;

import java.util.Arrays;

/**
 * 冒泡排序
 * 每个元素都可以像小气泡一样，根据自身大小一点一点像数组一侧移动
 *
 * 每一趟都只能确定将一个数归位，如果有n个数排序，只需要将n-1个数归位，也就是要进行n-1趟操作
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 5};
        int[] arr2 = {1, 1, 2, 3, 4, 5};
        int[] arr3 = {2,11,5,3, 1, 21, 31, 41, 51};
        System.out.println(Arrays.toString(sort(arr)));
        System.out.println(Arrays.toString(sort2(arr2)));
        System.out.println(Arrays.toString(sort3(arr3)));
    }

    /**
     * 原始排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {

        if (arr.length < 2) {
            return arr;
        }
        // 假如4个石子，需要排序三趟，第一趟需要比较三次，第二趟需要比较两次，第三趟比较一次
        // 那么n个石子，需要 （n-1）+（n-2）+ ... +2+1 等差数列 复杂度也就是O(n2)了
        // 第一层循环用来控制排序趟数
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            // 第二次循环用来控制i+1（因为i从0开始的）趟的比较次数
            for (int j = 0; j < arr.length -1 - i; j++) {
                count++;
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
        System.out.println("比较的次数：" + count);
        return arr;
    }

    /**
     * 优化1： 如果比较的过程中没有发生元素交换，证明数组已经有序，直接跳出
     *
     * @param arr
     * @return
     */
    public static int[] sort2(int[] arr) {

        if (arr.length < 2) {
            return arr;
        }
        int count = 0;
        boolean flag = true;// 用来标记是否已经有序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 - i; j++) {
                count++;
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println("比较的次数：" + count);
        return arr;
    }

    /**
     * 优化2：在优化1的基础上，如果元素的后半部分有序，那么记录元素最后交换的位置，减少排序趟数
     * @param arr
     * @return
     */
    public static int[] sort3(int[] arr) {

        if (arr.length < 2) {
            return arr;
        }
        int count = 0;
        boolean flag = true;// 用来标记是否已经有序
        int border = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 - i; j++) {
                count++;
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    // 记录最后一次交换的位置，后面的已经有序了
                    border = j;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            i = arr.length - 1 - border-1;
        }
        System.out.println("比较的次数：" + count);
        return arr;
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
