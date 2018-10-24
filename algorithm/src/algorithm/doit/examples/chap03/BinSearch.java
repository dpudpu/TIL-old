package algorithm.doit.examples.chap03;

import java.util.Scanner;

//이진 검색
public class BinSearch {
    static int binSearch(int[] a, int n, int key){
        int pl=0;
        int pr=n-1;

//        do{
//            int pc=(pl+pr)/2;
//            if(a[pc]==key)
//                return pc;
//            else if(a[pc]<key)
//                pl=pc+1;
//            else
//                pr=pc-1;
//        }while(pl<=pr);

        for(int pc=(pl+pr)/2; pl<=pr;){
            if(a[pc]==key)
                return pc;
            else if(a[pc]<key)
                pl=pc+1;
            else
                pr=pc-1;
        }

        return -1;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 :" );
        int num= sc.nextInt();
        int[] x = new int[num];

        for(int i=0; i<num; i++){
            System.out.print("x["+i+"]:");
            x[i]=sc.nextInt();
        }

        System.out.println("검색할 값 : ");
        int ky=sc.nextInt();

        int idx = binSearch(x,num,ky);

        if(idx==-1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky+"은 x["+idx+"]에 있습니다.");

    }

}
