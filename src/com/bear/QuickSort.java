package com.bear;

import java.util.Arrays;

/**
 * 快速排序 是对冒泡排序对一种改进,利用了分治对思想，
 *
 * 通过一趟排序，将要排序对数据分割成两部分，分割点左边都是比它(基准数字)小的数，分割点右边都是比它大的数
 * 然后在按照此方法对这两部分数据分别进行快速排序，递归。时间复杂度O(nlogn)
 *
 * 遍历一次数组，我们将数组中的元素分成三份， 分别是小于主元的元素，主元元素（pivot）以及大于主元的元素，
 * 其中主元是从当前数组中任意取的元素
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2,4,5,1,3};
        System.out.println(Arrays.toString(sort(arr, 0, arr.length-1)));
    }

    public static int[] sort(int[] arr, int left, int right) {

        if (left < right) {
            int p = partition(arr, left, right);
            sort(arr, left, p-1);
            sort(arr, p+1, right);
        }
        return arr;
    }

    /**
     * 对当前数组进行一次遍历
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {

            while (arr[right] > pivot && right > left) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] < pivot && left < right) {
                left ++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
