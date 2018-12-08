package ru.faoxis.threads.threadTypes;


public class SleepExample {

    public static void sleepTest() {
        new Thread(() -> {
            for (int i = 0; i <= 100; i++)
                System.out.println("привет из потока 1 - " + i + " раз!");
        }).start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Это основной поток " + Thread.currentThread().getName());
//        Thread.currentThread().interrupt();
//        Thread.currentThread().stop();
        if (!Thread.currentThread().isInterrupted()) {
            new Thread(() -> System.out.println("привет из потока 2!!!")).start();
        }
    }

    public static void main(String[] args){
        sleepTest();
    }
}
