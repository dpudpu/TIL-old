package algorithm.doit.examples.chap05;

import java.util.ArrayList;
import java.util.List;

public class Q3 {
    public static void main(String args[]){
        int[] nums= new int[]{52,36,32,40,46};

        System.out.println("최대공약수 ; " + gcdArray(nums));

    }
    static int gcdArray(int[] a){
        for(int i=0; i<a.length; i++) {
            for(int j=i+1;j<a.length;j++){
                int tmp=a[i];
                if(a[i]>a[j]){
                    a[i]=a[j];
                    a[j]=tmp;
                }
            }
        }
        int i=1;
        List<Integer> cd = new ArrayList<Integer>();

        loop: while(i!=a[0]){
            i++;
            for(int num : a){
                if(num%i != 0)
                    continue loop;
            }

            System.out.println("공약수 : "+i);
            for(int j=0;j<a.length;j++) {
                a[j] /= i;
                System.out.println(a[j]);
            }

            cd.add(i);
            i=1;
        }
        int max=1;
        for(int j : cd){
            max*=j;
        }

        return max;
    }
}
