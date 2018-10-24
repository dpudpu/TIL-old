package algorithm.doit.examples.chap07;

public class IntSet {
    private int max; // 집합의 최대 개수
    private int num; // 집합의 요소 개수
    private int[] set; // 집합 본체

    public IntSet(int capacity){
        num=0;
        max= capacity;
        try{
            set=new int[max];
        }catch(OutOfMemoryError outOfMemoryError){
            max=0;
        }
    }

    public int capacity(){
        return max;
    }
    public int size(){
        return num;
    }

    public int indexOf(int n){
        for(int i=0;i<num;i++)
            if(set[i]==n)
                return i;
            return -1;
    }

    public boolean contains(int n){
        return (indexOf(n)!=-1)?true:false;
    }

    public boolean add(int n){
        if(num>=max || contains(n) == true)
            return false;
        else{
            set[num++]=n;
            return true;
        }
    }

    // 집합에서 n을 삭제
    public boolean remove(int n){
        int idx; // n이 저장된 요소의 인덱스
        if(num<=0||(idx=indexOf(n))==-1)
            return false;
        else{
            set[idx]=set[--num];
            return true;
        }
    }

    // 집합 s에 복사합니다.
    public void copyTo(IntSet s){
        int n = (s.max<num) ? s.max:num;
        for(int i=0;i<n;i++)
            s.set[i]=set[i];
        s.num=n;
    }

    // 집합 s를 복사합니다
    public void copyFrom(IntSet s){
        int n=(max<s.num)? max:s.num; // 복사할 요소 개수
        for(int i=0;i<n;i++)
            set[i]=s.set[i];
        num=n;
    }

    //  집합 s와 같은지 확인
    public boolean equalTo(IntSet s){
        if(num!=s.num) // 요소 개수가 같지 않으면 집합도 같지 않습니다.
            return false;

        for(int i=0;i<num;i++){
            int j=0;
            for(;j<s.num;j++)
                if(set[i]==s.set[j])
                    break;
                if(j==s.num)    // set[i]는 s에 포함되지 않습니다.
                    return false;
        }
        return true;
    }

    //집합 s1과 s2의 합집합을 복사합니다.
    public void unionOf(IntSet s1, IntSet s2){
        copyFrom(s1);
        for(int i=0;i<s2.num;i++)
            add(s2.set[i]);
    }

    // "{a b c}" 형식의 문자열로 표현을 바꿉니다.
    public String toString(){
        StringBuffer temp = new StringBuffer("{");
        for(int i=0;i<num;i++)
            temp.append(set[i]+" ");
        temp.append("}");
        return temp.toString();
    }
}
