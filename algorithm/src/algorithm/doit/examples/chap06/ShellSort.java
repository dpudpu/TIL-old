package algorithm.doit.examples.chap06;

public class ShellSort {
    static void shellSort(int[] a, int length) {
        for (int h = length / 2; h > 0; h /= 2) {
            for (int i = h; i < length; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
                    a[j + h] = a[j];
                a[j + h] = tmp;

                for (int num : a) // 출력
                    System.out.print(num + " ");
                System.out.println();
            }
        }

    }


    public static void main(String args[]) {
        int[] a = new int[]{8,1,4,2,7,6,3,5};
        for (int num : a) // 출력
            System.out.print(num + " ");
        System.out.println();
        shellSort(a,a.length);

    }
}
