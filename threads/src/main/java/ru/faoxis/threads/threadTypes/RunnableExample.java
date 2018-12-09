package ru.faoxis.threads.threadTypes;

public class RunnableExample {

    public static void runnableTest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        }).start();
    }

    public static void main(String[] args){
        runnableTest();
    }
}
