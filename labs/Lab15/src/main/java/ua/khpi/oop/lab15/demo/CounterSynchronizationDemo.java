package ua.khpi.oop.lab15.demo;

import java.util.concurrent.CountDownLatch;

public class CounterSynchronizationDemo {
    private static int unsafeCounter = 0;
    private static int safeCounter = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        demonstrateUnsafeUpdate();
        System.out.println();
        demonstrateSafeUpdate();
    }

    private static void demonstrateUnsafeUpdate() throws InterruptedException {
        System.out.println("=== 1. Unsafe update without synchronized ===");

        unsafeCounter = 0;

        CountDownLatch bothThreadsReadValue = new CountDownLatch(2);

        Runnable unsafeTask = () -> {
            String threadName = Thread.currentThread().getName();

            int currentValue = unsafeCounter;
            System.out.println(threadName + " read unsafeCounter = " + currentValue);

            bothThreadsReadValue.countDown();

            try {
                bothThreadsReadValue.await();
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }

            int updatedValue = currentValue + 1;
            System.out.println(threadName + " calculated updated value = " + updatedValue);

            unsafeCounter = updatedValue;
            System.out.println(threadName + " wrote unsafeCounter = " + unsafeCounter);
        };

        Thread firstThread = new Thread(unsafeTask, "UnsafeCounter-1");
        Thread secondThread = new Thread(unsafeTask, "UnsafeCounter-2");

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println("Expected unsafeCounter = 2");
        System.out.println("Actual unsafeCounter = " + unsafeCounter);
        System.out.println("Race condition detected = " + (unsafeCounter != 2));
    }

    private static void demonstrateSafeUpdate() throws InterruptedException {
        System.out.println("=== 2. Safe update with synchronized ===");

        safeCounter = 0;

        Runnable safeTask = () -> {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + " tries to enter synchronized block");

            synchronized (lock) {
                System.out.println(threadName + " entered synchronized block");

                int currentValue = safeCounter;
                System.out.println(threadName + " read safeCounter = " + currentValue);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }

                int updatedValue = currentValue + 1;
                safeCounter = updatedValue;

                System.out.println(threadName + " wrote safeCounter = " + safeCounter);
                System.out.println(threadName + " leaves synchronized block");
            }
        };

        Thread firstThread = new Thread(safeTask, "SafeCounter-1");
        Thread secondThread = new Thread(safeTask, "SafeCounter-2");

        firstThread.start();

        Thread.sleep(100);

        secondThread.start();

        Thread.sleep(150);

        System.out.println();
        System.out.println("--- Thread states while synchronized block is locked ---");
        System.out.println("SafeCounter-1 state = " + firstThread.getState());
        System.out.println("SafeCounter-2 state = " + secondThread.getState());

        if (secondThread.getState() == Thread.State.BLOCKED) {
            System.out.println("If SafeCounter-2 is BLOCKED, it is waiting for the synchronized lock.");
        }

        System.out.println();

        firstThread.join();
        secondThread.join();

        System.out.println("Expected safeCounter = 2");
        System.out.println("Actual safeCounter = " + safeCounter);
        System.out.println("Synchronization works = " + (safeCounter == 2));
    }
}