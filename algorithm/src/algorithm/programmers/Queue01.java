package algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

class Queue01 {
    public static void main(String args[]){
        int[] pro={93,30,55};
        int[] spe={1,30,5};
        int answer[];
        answer = solution(pro,spe);
        for(int a : answer){
            System.out.print(a+" ");
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] needDay = new int[progresses.length];      // 필요한 일 수
        List<Integer> result = new ArrayList<Integer>(); // answer값

        for(int i=0; i<progresses.length; i++){
            int day=0;
            while(progresses[i]<100){
                progresses[i]+=speeds[i];
                day++;
            }
            needDay[i]=day;
        }

        for(int i=0; i<needDay.length;i++){
            int cnt=1;
            for(int j=i+1; j<needDay.length;j++,cnt++){
                if(needDay[i]<needDay[j]) { // needDay[i]<needDay[j] 면 작업의 개수 입력 후
                    i = j - 1;              // needDay[j]부터 비교
                    break;
                }
                if(j==needDay.length-1)
                    i=j;
            }
            result.add(cnt);
        }


        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
}