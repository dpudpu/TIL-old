package com.example.tobyreactive.exam;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Observer Pattern
 *
 * Duality (상대성)
 * - 상대성은 궁긍적인 기능은  똑같은데, 반대 방향으로 표현하는 것
 * - Iterable      ←→  observerable
 * - DATA method() ←→  void method(DATA)
 * - Iterable 은 pull 개념 (사용하는 쪽에서 땡겨 오는 방식) → next()
 * - observable은 push 개념 (사용하는 쪽에서 밀어 넣는 방식) → notifyObserver(..)
 *     - Observable (source) → event/data → Observer
 *     - subject (pub) - object (sub)
 */
@SuppressWarnings("deprecation")
public class Exam01 {

    public static void main(String[] args) {
        IntObservable ob = new IntObservable();

        Observer observer = (o, arg) -> System.out.println(Thread.currentThread().getName()+" :: "+arg);
        ob.addObserver(observer);

        ExecutorService es = Executors.newFixedThreadPool(5);
        es.execute(ob);
        es.shutdown();

        System.out.println(Thread.currentThread().getName() + " is finished");
    }

    private static class IntObservable extends Observable implements Runnable{
        @Override
        public void run() {
            List<Integer> list = List.of(1, 2, 3, 4, 5);
            for (Integer integer : list) {
                setChanged(); // 설정 해야 notify 실행 가능
                notifyObservers(integer); // observer에게 변경 내용 전파
            }
        }
    }
}
