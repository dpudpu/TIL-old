package algorithm.doit.examples.chap06;


//칵테일 정렬
public class Quiz05 {
    public static void main(String args[]) {
        int[] a = new int[]{38, 24, 14, 12, 85, 7};
        for(int num:a)
            System.out.print(num+" ");
        System.out.println();
        bubbleSort(a);
    }

    public static void bubbleSort(int a[]) {
        int left = 0;
        int right = a.length - 1;
        do{
            for(int i=left;i<right;i++){
                if(a[i]>a[i+1]){
                    swap(a,i,i+1);
                }
            } // >>>>
            right--;

            for(int num:a)
                System.out.print(num+" ");
            System.out.println();

            for(int i=right; i>left;i--){
                if(a[i]<a[i-1]){
                    swap(a,i,i-1);
                }
            }
            left++;
            for(int num:a)
                System.out.print(num+" ");
            System.out.println();

        }while(!(left==right || left+1==right));

    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
