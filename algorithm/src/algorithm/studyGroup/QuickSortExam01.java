package algorithm.studyGroup;

public class QuickSortExam01 {
    static int cnt = 0;

    public static void main(String[] args) {
        int nums[] = {19, 16, 5, 3, 2, 7, 10, 1, 0};
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();

        quickSort(nums, 0, nums.length - 1);

        for (int num : nums)
            System.out.print(num + " ");

        System.out.println();
        System.out.println(cnt);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

//    public static int partition(int[] nums, int left, int right) {
//        int pivot = nums[left];
//        int pl = left + 1;
//        int pr = right;
//
//        while (pl <= pr) {
//            cnt++;
//            while (pl <= right && nums[pl] < pivot) pl++;
//            while (pr >= left && nums[pr] > pivot) pr--;
//
//            if (pl < pr)
//                swap(nums, pl, pr);
//        }
//        swap(nums, left, pr);
//        return pr;
//    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[(left+right)/2];
        int pl = left;
        int pr = right;

        while (pl < pr) {
            cnt++;
            while (nums[pl] < pivot) pl++;
            while (nums[pr] > pivot) pr--;

            if (pl < pr)
                swap(nums, pl, pr);
        }
        return pr;
    }

    public static void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
