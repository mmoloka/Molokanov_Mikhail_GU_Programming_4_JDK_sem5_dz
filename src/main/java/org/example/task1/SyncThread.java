package org.example.task1;

public class SyncThread implements Runnable {
    private Object objectA;
    private Object objectB;

    public SyncThread(Object objectA, Object objectB) {
        this.objectA = objectA;
        this.objectB = objectB;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        synchronized (objectA) {
            System.out.println(name);
            System.out.println(objectA);
            work();
            System.out.println(name);
            synchronized (objectB) {
                System.out.println(name);
                System.out.println(objectB);
                work();
            }
            System.out.println(name);
        }
        System.out.println(name);
    }

    private void work() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
