package algorithm.doit.examples.chap06;


public class BubbleSort {
    // 개선된 버블정렬
    static void bubbleSort2(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;
            for (int j = n - 1; j > i; j--)
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                    for (int num : a)
                        System.out.print(num + " ");
                    System.out.println();
                }
            if (exchg == 0) break;
        }
    }

    static void bubbleSort3(int[] a, int n) {
        int i = 0;    // a[i]보다 앞쪽은 정렬을 마친 상태
        while (i < n - 1) {
            int last = n - 1;
            for (int j = n - 1; j > i; j--) {
                if (a[j-1] > a[j]) {  // 마지막으로 요소를 교환한 위치
                    swap(a, j-1, j);

                    for (int num : a) // 출력
                        System.out.print(num + " ");
                    System.out.println();

                    last = j;
                } //if
            }//for
            i = last;
            System.out.println(i);
        }// while
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String args[]) {
        int[] a = new int[]{5, 3, 2, 7, 10, 1};
        for (int num : a) // 출력
            System.out.print(num + " ");
        System.out.println();
        bubbleSort3(a, a.length);
    }
}
