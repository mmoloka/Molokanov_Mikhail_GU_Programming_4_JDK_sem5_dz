package org.example.task1;

public class ObjectB {
    private int value = 20;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
