package algorithm.kakao.y2019;


import java.util.*;

public class Quiz02 {
    public static int[] solution(int N, int[] stages) {
        int[] success=new int[N];

        for(int i=0;i<N;i++)
            success[i]=0;

        for(int j=0;j<N;j++) { // 성공 횟수 담기
            for (int i = 0; i < stages.length; i++)
                if(j+1<stages[i])
                    success[j]++;
        }

        Map<Integer,Double> map = new HashMap<>();

        for(int i=0;i<N;i++){  //  map(인덱스,실패확률) 담기
            double fail;
            if(i==0)
                fail= (double)(stages.length-success[0]) / stages.length;
            else {
                fail = (double)(success[i - 1] - success[i]) / success[i - 1];
            }
            if(Double.isNaN(fail)) // NaN(Not A Number)인지 판단
                fail=0;
            map.put(i,fail);
        }

        // 1. map으로는 정렬이 불가능하다
        // 2. 1차원 배열에 넣어서 정렬하면 정렬을 해도 순위를 알 수가 없다.
        // 3. 배열로 하려면 2차원 배열을해야함.
        // 그래서 map을 사용해서 나중에 map이랑 비교해서 answer에 입력하기 위해서 fail 배열 생성
        // map(0.5)의 key 3
        // fail[5]=3일때  map(fail[5]){순위}는 3(난이도)이므로  stage 3은 6등인거
        double[] fail=new double[N];
        for(int i=0;i<N;i++) // 실패율 fail 배열에 담기
            fail[i]=map.get(i);

        for(int i=0;i<N-1;i++){ // 실패율 내림차순 정렬하기
            for(int j=i+1; j<N; j++){
                if(fail[i]<fail[j]){
                    swap(fail, i, j);
                }
            }
        }
        int[] answer = new int[N];
        Set key = map.keySet();



        for(int i=0; i<N; i++){
            c:for (Iterator iterator = key.iterator(); iterator.hasNext();) {
                int keyName = (int)iterator.next();
                if(fail[i]==map.get(keyName)) {
                    answer[i] = keyName+1;

                    // 실패율 값이 중복 되는지 확인
                    for(int j=0;j<i;j++){
                        if(answer[i]==answer[j])
                            continue c;
                    }
                    break;
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.println((i+1)+"="+fail[i]);
        }

        return answer;
    }

    private static void swap(double[] a, int i, int j) {
        double tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args){

        int answer[] = solution(5,new int[]{2, 1, 2, 6, 2, 4, 3, 3});

        for(int a : answer)
            System.out.print(a+" ");

    }
}
