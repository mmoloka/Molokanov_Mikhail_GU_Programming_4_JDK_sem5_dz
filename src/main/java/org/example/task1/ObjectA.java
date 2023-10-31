package org.example.task1;

public class ObjectA {
    private int value = 10;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
