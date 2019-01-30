package algorithm.leetcode.divideAndConquer;

import java.util.Arrays;

public class MergerSortExam {
    public static int temp[] = new int[12];

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        for (int i = left; i <= right; i++)
            temp[i] = arr[i];

        int part1 = left;
        int part2 = mid + 1;
        int index = left;

        while (part1 <= mid && part2 <= right) {
            if (temp[part1] <= temp[part2])
                arr[index] = temp[part1++];
            else
                arr[index] = temp[part2++];
            index++;
        }
        for (int i = 0; i <= mid - part1; i++)
            arr[index + i] = temp[part1 + i];
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 4, 3, 6, 12, 10, 2, 1, 9, 8, 11};
        mergeSort(arr);
    }
}
