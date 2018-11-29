package my.examples.threadexam;

public class ThreadExam06 {
    public static void main(String[] args) {
        // 이름없는 클래스. new A(){ ... }
        // A를 상속받거나, 구현하는 이름없는 객체를 생성한다.

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++)
                System.out.println("*");
        });
        t1.start();

    }
}