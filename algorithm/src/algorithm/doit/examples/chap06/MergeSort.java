package algorithm.doit.examples.chap06;

public class MergeSort {
    static int[] buff;

    static void __mergeSort(int[] a, int left,int right){
        if(left<right){
            int i;
            int center = (left+right)/2;
            int p=0;
            int j=0;
            int k=left;

            __mergeSort(a,left,center);
            __mergeSort(a,center+1,right);

            for(i=left; i<=center; i++)
                buff[p++] = a[i];

            while(i<=right && j <p)
                a[k++]=(buff[j]<= a[i])? buff[j++]:a[i++];

            while(j<p)
                a[k++]=buff[j++];
        }
    }

    static void mergeSort(int[] a, int n){
        buff = new int[n]; // 작업용 배열 생성

        __mergeSort(a,0,n-1); // 배열 전체를 병합 정렬

        buff=null; // 작업용 배열을 해체합니다.
    }

    public static void main(String args[]){
        int[] a = {5,6,7,1,10,23,12,3};

        mergeSort(a,a.length);

        for(int n : a)
            System.out.println(n);
    }
}
