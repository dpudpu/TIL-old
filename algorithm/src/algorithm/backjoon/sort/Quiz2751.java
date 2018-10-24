package algorithm.backjoon.sort;

import java.util.Scanner;

// 퀵소트를 이용한 수 정렬하기2
public class Quiz2751 {

    static void quickSort(int[] nums, int left, int right) {
        int pl = left;
        int pr = right;
        int x = nums[(pl + pr) / 2];

        do {
            while (nums[pl] < x) pl++;
            while (nums[pr] > x) pr--;
            if (pl <= pr)
                swap(nums, pl++, pr--);

        } while (pl <= pr);
        if (left < pr) quickSort(nums, left, pr);
        if (right > pl) quickSort(nums, pl, right);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        int[] nums = new int[index];
        for(int i=0;i<index;i++)
            nums[i]=sc.nextInt();

        quickSort(nums, 0, nums.length - 1);
        for (int n : nums)
            System.out.println(n);
    }
}
