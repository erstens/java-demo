package com.pool;

import com.func.Machine;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        BlockingQueue quee = new ArrayBlockingQueue(10) ;
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,10,100, TimeUnit.MICROSECONDS ,quee) ;


        for (int i = 0; i < 5; i++) {
            pool.execute(() -> new Machine().say());
            System.out.println(pool.getActiveCount());
        }
        pool.shutdown();

    }
}
