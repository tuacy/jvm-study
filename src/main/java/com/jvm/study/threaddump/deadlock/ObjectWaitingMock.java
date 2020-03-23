package com.jvm.study.threaddump.deadlock;

import java.util.concurrent.TimeUnit;

public class ObjectWaitingMock {

    public static void main(String[] args) {

        Thread thread = new Thread("线程1") {
            //重写run方法
            public void run() {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (thread) {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.notify();
        }


    }

}
