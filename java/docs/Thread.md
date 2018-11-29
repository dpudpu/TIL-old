출처: 자바의 정석



## 1. 프로세스와 쓰레드

프로세스란 간단히 말해서 '실행 중인 프로그램'이다'. 프로그램을 실행하면 OS로부터 실행에 필요한 자원(메모리)을 할당받아 프로세스가 된다.

 프로세스는 프로그램을 수행하는 데 필요한 데이터와 메모리 등의 자원 그리고 쓰레드로 구성되어 있으며 프로세스의 자원을 이용해서 실제로 작업을 수행하는 것이 바로 **쓰레드**다. 그래서 모든 프로세스에는 최소한 하나 이상의 쓰레드가 존재하며, 둘 이상의 쓰레드를 가진 프로세스를 멀티쓰레드 프로세스라고 한다.



 멀티쓰레딩은 하나의 프로세스 내에서 여러 쓰레드가 동시에 작업을 수행하는 것이 가능하다. 실제로는 한 개의 CPU가 한 번에 단 한가지 작업만 수행할 수 있기 때문에 아주 짧은 시간 동안 여러 작업을 번갈아 가며 수행함으로써 동시에 여러 작업이 수행되는 것처럼 보이게 하는 것이다. 

ex) 메신저의 경우 채팅하면서 파일을 다운로드 받거나 음성대화를 나눌 수 있는 것이 가능한 이유가 바로 멀티쓰레드로 작성되어 있기 때문이다.

#### - 멀티쓰레딩의 장점

- cpu의 사용률을 향상시킨다.
- 자원을 보다 효율적으로 사용할 수 있다.
- 사용자에 대한 응답성이 향상된다.
- 작업이 분리되어 코드가 간결해진다.



 하지만 멀티쓰레드 프로세스는 여러 쓰레드가 같은 프로세스 내에서 자원을 공유하면서 작업을 하기 때문에 발생할 수 있는 동기화(synchronization), 교착상태(deadlock)와 같은 문제들을 고려해서 신중히 프로그래밍해야한다. (쓰레드 환경에서도 잘 작동 하는 것을 Thread safe라고 한다)



 항상 우리가 사용하는 main메소드의 작업을 수행하는 것도 쓰레드다. 프로그램을 실행하면 기본적으로 하나의 쓰레드(main thread)가 실행된다. 그리고 실행 중인 사용자 쓰레드가 하나도 없을 때 프로그램은 종료된다.



## 2. 쓰레드 구현과 실행

쓰레드를 구현하는 방법은 두가지가 있다.

- Thread클래스를 상속

- Runnable인터페이스를 구현

Runnable 사용을 추천한다. (Thread클래스를 상속받으면 다른 클래스를 상속받지 못하기 때문에)

Runnable을 구현하는 방법은 재사용성이 높고 코드의 일관성을 유지 할 수 있다는 장점이 있기 때문에 보다 객체지향적인 방법이라 할 수 있다.



#### 2.1. Thread 클래스

```java
public class ThreadExam01 {
    public static void main(String[] args){
        MyThread01 m1 = new MyThread01("*");
        MyThread01 m2 = new MyThread01("+");
        MyThread01 m3 = new MyThread01("#");
        m1.start();
        m2.start();
        m3.start();
        System.out.println("main메소드 종료.");
    }
}

class MyThread01 extends Thread{
    private String str;
    public MyThread01(String str){
        this.str = str;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
            System.out.print(str);
    }
}

```



#### 2.2. Runnable 인터페이스

```java
public class ThreadExam02 {
    public static void main(String[] args){
        Runnable r1 = new MyThread02("*");
        Runnable r2 = new MyThread02("%");
        Runnable r3 = new MyThread02("#");
        
        //Thread t1 = new Thread(new MyThread02("*"));
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
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
        for(int i = 0; i < 5; i++)
            System.out.print(str);
    }
}
```

```
[실행결과]
*****#####+++++main메소드 종료.
```

일단 둘 다 공통적으로 

- run() 메소드를 상속받아서 오버라이딩 해줘야한다. 

- 쓰레드 작업을 해줄 곳에 start()를 사용해준다.  

  start()를 호출하면 thread를 실행 준비 -> run()을 실행한다.(템플릿패턴 적용, 오버라이딩한 메소드 사용)

#### 2.3 run()에 Thread.sleep() 사용해서 지연

 ```java
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.print(str);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            }catch(InterruptedException ie){}
        }
    }
 ```

```
[실행결과]
*#main메소드 종료.
%**#%*%*%#%##
```

이번에는 run()메소드에 Thread.sleep()을 사용해서 지연을 시켜보았다. 



여러 개의 쓰레드로 작업하는 경우에는 짧은 시간동안 쓰레드들을 스케줄에 따라서 번갈아 가면서 작업을 수행해서 동시에 두 작업이 처리되는 것과 같이 느끼게 해주는데 아까는  *#####+++++main메소드 종료. 이렇게 한번에 출력이 되었다. 이유는 컴퓨터의 속도가 빠르다보니 이렇게 해줘

순서대로 출력이 되었는데 컴퓨터의 속도가 빨라서 한번에 처리 



#### Runnable 인터페이스를 구현한 경우의 인스턴스 생성방법이 다르다. 

```
 Runnable r1 = new MyThread02("*");
 Thread t1 = new Thread(r1);
 t1.start();
 
//또는

 Thread t1 = new Thread(new MyThread02("*"));
 t1.start();
```



## 3. Lambda를 사용한 Runnable 구현

람다 표현식(lambda expression)은 java 8부터 도입되었는데 Runnable 인터페이스처럼 메소드가 하나 있을 때 유용하게 사용 할 수 있다. ()->{ }



#### 3.1 

```java
public class ThreadExam04 {
    public static void main(String[] args) {
        // 이름없는 클래스. new A(){ ... }
        // A를 상속받거나, 구현하는 이름없는 객체를 생성한다.
        Runnable r = new Runnable(){
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    System.out.println("*");
                }
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
    }
}
```

#### 3.2

```java
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    System.out.println("*");
                }
            }
        });
        t1.start();
```

### 3.3

```java
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++)
                System.out.println("*");
        });
        t1.start();
```

