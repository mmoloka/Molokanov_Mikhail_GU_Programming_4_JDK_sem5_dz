package org.example.task2;

import org.example.task1.SyncThread;

/*
В рамках выполнения задачи необходимо:
    ● Создайте два потока A и B.
    ● Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд
      (true в состояние false и наоборот).
    ● Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет
      от 100 с задержкой 100 миллисекунд и приостанавливает свое действие, как только поток
      A переключит switcher в состояние false.
    ● Условием завершения работы потоков является достижение отсчета нулевой отметки.
    ● Можно воспользоваться синхронизацией для управления значения переменной или volatile
 */
public class Main {

    private static boolean switcher = true;
    private static int counter = 100;

    public static void main(String[] args) {

        Runnable run1 = () -> {
            try {
                while (counter > 0) {
                    switcher = !switcher;
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable run2 = () -> {
            try {
                while (counter > 0) {
                    if(switcher) {
                        counter--;
                        System.out.println(counter);
                    }
                    Thread.sleep(100);
                }
            }  catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);

        thread1.start();
        thread2.start();
    }
}
