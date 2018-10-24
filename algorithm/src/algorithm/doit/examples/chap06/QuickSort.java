package algorithm.doit.examples.chap06;

public class QuickSort {
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //배열을 나눕니다.
    static void quickSort(int[] a,int left,int right){
        int pl=left;
        int pr=right;
        int x=a[(pl+pr)/2];

        do{
            while(a[pl]<x)pl++;
            while(a[pr]>x)pr--;
            if(pl<=pr) {
                swap(a, pl++, pr--);
                for (int num : a) // 출력
                    System.out.print(num + " ");
                System.out.println();
            }
        }while (pl<=pr);
        System.out.println();

        if(left<pr) quickSort(a,left,pr);
        if(right>pl) quickSort(a,pl,right);

    }

    public static void main(String args[]) {
        int[] a = new int[]{5, 3, 2, 7, 10, 1};
        for (int num : a) // 출력
            System.out.print(num + " ");
        System.out.println();
        quickSort(a, 0 ,a.length-1);
    }
}
