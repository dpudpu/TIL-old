package my.examples.threadexam;
public class ThreadExam02 {
    public static void main(String[] args){
        Runnable r1 = new MyThread02("*");
        Runnable r2 = new MyThread02("%");
        Runnable r3 = new MyThread02("#");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("main메소드 종료.");
    }
}

class MyThread02 implements Runnable{
    private String str;
    public MyThread02(String str){
        this.str = str;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.print(str);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            }catch(InterruptedException ie){}
        }
    }



}

