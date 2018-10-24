package algorithm.doit.examples.chap06;

public class ShellSort02 {
    static void shellSort(int[] a, int length) {
        int h;
        for(h=1;h<length/9;h=h*3+1);
        for(;h>0;h/=3)
            for(int i=h;i<length;i++){
                int j;
                int tmp=a[i];
                for(j=i-h;j>=0 && a[j]>tmp; j-=h)
                    a[j+h]=a[j];
                a[j+h]=tmp;
            for (int num : a) // 출력
                System.out.print(num + " ");
            System.out.println();

        }
    }


    public static void main(String args[]) {
        int[] a = new int[]{5, 3, 2, 7, 10, 1};
        for (int num : a) // 출력
            System.out.print(num + " ");
        System.out.println();
        shellSort(a,a.length);

    }
}
