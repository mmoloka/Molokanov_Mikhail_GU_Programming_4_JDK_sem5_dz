package org.example.task4_dz;
/* В качестве задачи предлагается решить классическую задачу про обедающих философов
        Условие:
            ● Есть пять философов (потоки), которые могут либо обедать (выполнение кода),
              либо размышлять(ожидание).
            ● Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд.
            ● После каждого приема пищи философ должен размышлять.
            ● Не должно возникнуть общей блокировки.
            ● Философы не должны есть больше одного раза подряд
 */

public class Main {
    public static void main(String[] args) {
        final Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int j = 0; j < philosophers.length; j++) {
            Object leftFork = forks[j];
            Object rightFork = forks[(j + 1) % forks.length];

            if (j == philosophers.length - 1) {
                philosophers[j] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[j] = new Philosopher(leftFork, rightFork);
            }

            Thread t = new Thread(philosophers[j], "Philosopher " + (j + 1));
            t.start();
        }
    }
}

