package com.priority;

import com.func.Machine;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> new Machine().say());
        Thread t2 = new Thread(() -> new Machine().say());

        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}
