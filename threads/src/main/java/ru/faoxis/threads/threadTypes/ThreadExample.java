package ru.faoxis.threads.threadTypes;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread");
    }
}

public class ThreadExample {
    public static void threadTest() {
        new Thread() {
            @Override
            public void run() {
                System.out.println("Thread");
            }
        }.start();
    }


    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();

//        threadTest();
    }
}
