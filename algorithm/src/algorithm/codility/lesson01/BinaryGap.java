package algorithm.codility.lesson01;

public class BinaryGap {
    public static int solution(int num) {
        int maxGap = 0;
        char[] binary = Integer.toBinaryString(num).toCharArray();

        int gap=0;
        for(char ch : binary){
            if(ch=='1') {
                maxGap=Math.max(maxGap,gap);
                gap = 0;
            }else
                gap++;
        }

        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(solution(32));
    }
}
