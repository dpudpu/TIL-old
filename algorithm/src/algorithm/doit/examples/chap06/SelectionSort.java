package algorithm.doit.examples.chap06;

public class SelectionSort {


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
        selectionSort(a);
    }

    // 선택정렬 비교하는 횟수는 (n^2-n)/2 회.
    // 그러나 이 정렬 알고리즘은 서로 떨어져 있는 요소를 교환하는 것이기 때문에 안정적이지 않음.
    private static void selectionSort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    min=j;
                }
            }
            swap(a,i,min);
            for (int num : a) // 출력
                System.out.print(num + " ");
            System.out.println();
        }
    }
}
