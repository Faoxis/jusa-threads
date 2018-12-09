package ru.faoxis.threads.threadTypes;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {

    public static void callableTest() throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
//        FutureTask<Integer> futureTask = new FutureTask<>(() -> {return 1;});
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call(){
            return 1;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        callableTest();
    }
}
