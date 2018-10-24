package algorithm.doit.examples.chap06;

public class Partition{
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //배열을 나눕니다.
    static void partition(int[] a, int n){
        int pl=0;
        int pr=n-1;
        int x=a[n/2];

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


    }
    public static void main(String args[]) {
        int[] a = new int[]{5, 3, 2, 7, 10, 1};
        for (int num : a) // 출력
            System.out.print(num + " ");
        System.out.println();
        partition(a,a.length);
    }
}
