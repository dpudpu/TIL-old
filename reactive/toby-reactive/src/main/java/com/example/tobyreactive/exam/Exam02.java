package com.example.tobyreactive.exam;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Flow.*;

/**
 * Publisher (Observable) <-> Subscriber(Observer)
 */
@SuppressWarnings("deprecation")
public class Exam02 {

    public static void main(String[] args) throws InterruptedException {
        Iterable<Integer> itr =  List.of(1, 2, 3, 4, 5);
        ExecutorService es = Executors.newFixedThreadPool(3);

        Publisher<Integer> pub = new Publisher<>() {
            Iterator<Integer> it = itr.iterator();

            @Override
            public void subscribe(Subscriber subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        es.execute(() -> {
                        int i = 0;
                            try {
                                while (i++<n) {
                                    if (it.hasNext()){
                                        subscriber.onNext(it.next());
                                    } else{
                                        subscriber.onComplete();
                                        break;
                                    }
                                }
                            } catch (RuntimeException e) {
                                subscriber.onError(e);
                            }
                        });
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber<Integer> sub = new Subscriber<>() {
            Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println(Thread.currentThread().getName() + " onSubscribe");
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                System.out.println(Thread.currentThread().getName() + " on Next " + item);
                this.subscription.request(2);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println(throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        pub.subscribe(sub);
        es.awaitTermination(1, TimeUnit.SECONDS);
        es.shutdown();
    }
}
