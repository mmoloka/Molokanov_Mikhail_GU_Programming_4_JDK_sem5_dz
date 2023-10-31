package org.example.task1;

/*
В рамках выполнения задачи необходимо:
 ● Создать два класса ObjectA, ObjectB
 ● Реализовать класс в котором два потока при запуске провоцируют DeadLock
   для объектов ObjectA, ObjectB
 */
public class Main {
    public static void main(String[] args) {
        Object objectA = new ObjectA();
        Object objectB = new ObjectB();

        Thread thread1 = new Thread(new SyncThread(objectA, objectB), "t1");
        Thread thread2 = new Thread(new SyncThread(objectB, objectA), "t2");

        thread1.start();
        thread2.start();
    }
}
