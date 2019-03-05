package algorithm.studyGroup.heap;

public class HeapExam01 {
    public static void main(String[] args) {
        int nums[] = {5, 2, 1, 7, 112, 42, 52, 62};
        printNums(nums);
        buildMaxHeap(nums);
        printNums(nums);
        heapSort(nums);
        printNums(nums);
    }

    public static void heapSort(int nums[]) {
        int size = nums.length - 1;
        while (size >= 2) {
            swap(nums, 0, size);
            size--;
            maxHeapify(nums, 0, size);
        }
    }

    public static void buildMaxHeap(int nums[]) {
        int n = nums.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxHeapify(nums, i, n);
        }
    }

    public static void maxHeapify(int nums[], int i, int size) {
        int left = i == 0 ? 1 : i * 2;
        int right = i == 0 ? 2 : i * 2 + 1;
        int n = size;

        if (left >= n)
            return;
        if (right >= n) {
            if (nums[left] > nums[i])
                swap(nums, left, i);
            return;
        }


        if (nums[left] > nums[right] && nums[left] > nums[i]) {
            swap(nums, left, i);
            maxHeapify(nums, left, size);
        } else if (nums[left] < nums[right] && nums[right] > nums[i]) {
            swap(nums, right, i);
            maxHeapify(nums, right, size);
        }


    }


    public static void printNums(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
