package algorithm.doit.examples.chap04;

import sun.invoke.empty.Empty;

public class IntQueue {
    private int max;
    private int front;
    private int num;
    private int rear;
    private int[] que;

    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){}
    }

    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){}
    }

    public IntQueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int enque(int x) throws OverflowIntStackException{
        if(num>=max)
            throw new OverflowIntStackException();
        que[rear++]=x;
        num++;
        if(rear==max)
            rear=0;
        return x;
    }

    public int deque() throws EmptyIntStackException{
        if(num<=0)
            throw new EmptyIntStackException();
        int x = que[front++];
        num--;
        if(front == max)
            front=0;
        return x;
    }
    public int peek() throws EmptyIntStackException{
        if(num<=0) throw new EmptyIntStackException();
        return que[front];
    }
    public int indexOf(int x){
        for(int i=0; i<num; i++){
            int idx=(i+front)%max;
            if(que[idx]==x)
                return idx;
        }
        return -1;
    }

    public void clear(){
        num=front=rear=0;
    }
    public int capacity(){
        return max;
    }

    public int size(){
        return num;
    }
    public boolean isEmpty(){
        return num<=0;
    }
    public boolean isFull(){
        return num>=max;
    }
    public void dump(){
        if(num<=0)
            System.out.println("큐가 비어 잇습니다.");
        else{
            for(int i=0;i<num;i++)
                System.out.print(que[(i+front)%max]+" ");
            System.out.println();
        }
    }

}
