package my.examples.threadexam;

public class ThreadExam03 {
    public static void main(String[] args){
        MyData myData = new MyData();
        Thread t1 = new Thread(new MyThread03(1, myData));
        Thread t2 = new Thread(new MyThread03(2, myData));
        Thread t3 = new Thread(new MyThread03(3, myData));
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread03 implements Runnable{
    private int flag;
    private MyData data;
    public MyThread03(int flag, MyData data){
        this.flag = flag;
        this.data = data;
    }

    @Override
    public void run() {
        if(flag == 1){
            data.print1();
        }else if(flag == 2){
            data.print2();
        } else if (flag == 3){
            data.print3();
        }
    }
}

class MyData{

    public synchronized void print1(){
        for(int i = 0; i < 5; i++){
            System.out.print("*");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            }catch(InterruptedException ie){}
        }
    }

    public synchronized void print2(){
        for(int i = 0; i < 5; i++){
            System.out.print("+");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            }catch(InterruptedException ie){}
        }
    }

    public synchronized void print3(){
        for(int i = 0; i < 5; i++){
            System.out.print("-");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            }catch(InterruptedException ie){}
        }
    }
}

