package ru.faoxis.threads.primitives;

public class SimpleLockDemo {

    static class MySimpleLock {
        private boolean isLocked = false;

        public synchronized void lock() {
            while (isLocked) {
                try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            isLocked = true;
        }

        public synchronized void unlock() {
            isLocked = false;
            notify();
        }
    }


    static long counter = 0;
    static MySimpleLock locker = new MySimpleLock();
    private static void inc100000TimesCounter() {
        for (int i = 0; i < 100_000; i++) {
            locker.lock();
            counter++;
            locker.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(SimpleLockDemo::inc100000TimesCounter);
        Thread thread2 = new Thread(SimpleLockDemo::inc100000TimesCounter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
