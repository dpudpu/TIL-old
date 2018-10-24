package algorithm.programmers;

public class Stack01{
        public static int[] solution(int[] heights) {
            int max=heights.length;
            int[] answer = new int[max];

            A:for(int i=max-1; i>=0;i--){
                for(int j=i-1; j>=0; j--){
                    if(heights[i]<heights[j]){
                        answer[i]=j+1;
                        continue A;
                    }
                        answer[i] = 0;
                }
            }
            return answer;
        }

    public static void main(String args[]){
        for(int answer : solution(new int[]{6,9,5,7,4}))
            System.out.print(answer+" ");
        System.out.println();
        for(int answer : solution(new int[]{3,9,9,3,5,7,2}))
        System.out.print(answer+" ");
    }
}
