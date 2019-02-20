package com.func;

public class Machine {
    public Machine() {

    }

    public void say() {
        System.out.println("I am " + Thread.currentThread().getName() ) ;
        try {
            Thread.sleep(1000);
            System.out.println("success");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
