package algorithm.doit.examples.chap03;

import java.util.Scanner;

//이진 검색
public class Quiz04 {
    static int binSearch(int[] a, int n, int key){
        int pl=0;
        int pr=n-1;

        System.out.print("  | ");
        for(int i=0;i<n;i++)
            System.out.print(i+" ");
        System.out.println();
        for(int i=0;i<pr;i++)
            System.out.print("--");
        System.out.println();

        do{
            int pc=(pl+pr)/2;
            System.out.print("  | ");
            for(int i=0;i<n;i++){
                if(i==pl)
                    System.out.print("<-");
                else if(i==pc)
                    System.out.print("+");
                else if(i==pr)
                    System.out.print("->");
                else
                    System.out.print("  ");
            }
            System.out.println();
            System.out.print(pc+" |");
            for(int i=0;i<n; i++)
                System.out.print(" "+a[i]);
            System.out.println();
            if(a[pc]==key)
                return pc;
            else if(a[pc]<key)
                pl=pc+1;
            else
                pr=pc-1;
        }while(pl<=pr);

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

        System.out.print("검색할 값 : ");
        int ky=sc.nextInt();

        int idx = binSearch(x,num,ky);

        if(idx==-1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("\n"+ky+"은 x["+idx+"]에 있습니다.");

    }

}
