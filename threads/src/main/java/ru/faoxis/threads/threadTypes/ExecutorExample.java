package ru.faoxis.threads.threadTypes;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void ExecutorServiceTest() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ExecutorService");
                }
            });
        }

//        Future future = service.submit(new MyCallable());
//        System.out.println(future.get());
//        service.shutdown();
    }

//    static class MyCallable implements Callable<Integer> {
//        @Override
//        public Integer call(){
//            return 1;
//        }
//    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorServiceTest();
    }
}
