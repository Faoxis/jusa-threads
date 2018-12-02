package ru.faoxis.first;

public class WaitNotifyDemo {

    private static void doAction1(Object anyObject) {
        System.out.println("before synchronized doAction1");
        synchronized (anyObject) {
            System.out.println("before try doAction1");
            try { anyObject.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Action 1 has been completed!");
        }
    }

    private static void doAction2(Object anyObject) {
        System.out.println("before synchronized doAction2");
        synchronized (anyObject) {
            System.out.println("before try doAction2");
            try { anyObject.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Action 2 has been completed!");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Object object = new Object();
        new Thread(() -> doAction1(object)).start();
        new Thread(() -> doAction2(object)).start();

        Thread.sleep(500);
        synchronized (object) {
            object.notify();
        }
    }
}
