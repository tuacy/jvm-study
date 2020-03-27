package com.jvm.study.threaddump;

import java.util.concurrent.TimeUnit;

/**
 * 模拟线程block状态
 */
public class BlockMock {

    public static void main(String[] args) {

        Thread thread = new Thread("线程") {
            //重写run方法
            public void run() {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(60);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();

        synchronized (thread) {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
