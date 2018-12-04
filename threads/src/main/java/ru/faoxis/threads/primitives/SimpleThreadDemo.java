package ru.faoxis.threads.primitives;

public class SimpleThreadDemo {

    static void showThreadStates() {
        for (Thread.State s: Thread.State.values()) {
            System.out.println(s);
        }
    }

    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void runThreadExample() {
        Runnable runnable = () -> {
            sleep(5_000);
            System.out.println("Hello!");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    static void showThreadStatesInAction() throws InterruptedException {
        Thread thread = new Thread(() -> sleep(2_000));

        System.out.println("State of created thred object: " + thread.getState());
        thread.start();
        System.out.println("State after start: " + thread.getState());
        Thread.sleep(1_000);
        System.out.println("State in sleep time: " + thread.getState());
        Thread.sleep(1_500);
        System.out.println("State after work finished: " + thread.getState());
    }

    static void runDaemonThreadExample() {
        Thread thread = new Thread(() -> {
            sleep(5_000);
            System.out.println("Hello!");
        });

        thread.setDaemon(true);
        thread.start();
    }

    static void runThreadInFor() {
        for (int i = 0; i < 100; i++) {
            int j = i;
            new Thread(() -> System.out.println("Hello number " + j)).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        showThreadStates();
    }
}
