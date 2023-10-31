package org.example.task4_dz;

public class Philosopher implements Runnable {
    private final Object leftFork;
    private final Object rightFork;
    private int eatingCounter = 0;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + action);
        Thread.sleep(500);
    }

    @Override
    public void run() {
        try {
            while (eatingCounter < 3) {
                doAction(" Thinking");
                synchronized (leftFork) {
                    doAction(" Picked up left fork");
                    synchronized (rightFork) {
                        doAction(" Picked up right fork - eating");
                        doAction(" Put down right fork");
                        eatingCounter++;
                    }
                    doAction(" Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
