package com.wait;

import com.func.Machine;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> new Machine().say());
        Thread t2 = new Thread(() -> new Machine().say());

        t1.start();
        t2.start();
        synchronized (t2) {
            t2.wait();
        }
        System.out.println("end");
    }
}
