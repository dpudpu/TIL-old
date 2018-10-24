package my.examples.threadexam;

public class ThreadEx {
    public static void main(String args[]){
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("*");
            }
        });

        Thread t2 = new Thread(()->{
            System.out.println("*");
        });

        t.start();
        t2.start();
    }
}


