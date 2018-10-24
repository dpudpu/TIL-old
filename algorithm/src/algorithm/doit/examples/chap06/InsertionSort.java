package algorithm.doit.examples.chap06;


// 단순 산입 정렬 (셔틀정렬)
// 떨어져 있는 요소들이 서로 뒤바뀌지 않아 안정적
// 교환 횟수는 n^2/2회
// 시간복잡도 O(n^2)
public class InsertionSort {


    public static void main(String args[]) {
        int[] a = new int[]{5, 3, 2, 7, 10, 1};
        for (int num : a) // 출력
            System.out.print(num + " ");
        System.out.println();

        for(int i=0;i<a.length;i++){
            int tmp=a[i];
            int j;
            for(j=i;j>0&&a[j-1]>tmp;j--)
                a[j]=a[j-1];
            a[j]=tmp;
            for (int num : a) // 출력
                System.out.print(num + " ");
            System.out.println();
        }
    }

}
