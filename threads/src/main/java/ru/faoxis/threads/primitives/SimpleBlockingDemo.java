package ru.faoxis.threads.primitives;


public class SimpleBlockingDemo {

    private static long counter = 0;

    private static void inc100000TimesCounter() {
        for (int i = 0; i < 100_000; i++) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(SimpleBlockingDemo::inc100000TimesCounter);
        Thread thread2 = new Thread(SimpleBlockingDemo::inc100000TimesCounter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }

}
