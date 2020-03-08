package com.jvm.study.oom.stack;

/**
 * 统一时刻存在的线程太多的时候,如果扩展时无法申请到足够的内存，则抛出OutOfMemoryError异常。
 * <p>
 * 我们一直创建线程来模这种情况
 * <p>
 * ps:解决此OOM的办法是减小线程数。
 */
public class ThreadManyOutOfMemoryErrorMock {

    public static void main(String[] args) throws Exception {
        //循环创建线程
        for (int i = 0; i < 1000000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        //线程sleep时间足够长，保证线程不销毁
                        Thread.sleep(200000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println("created " + i + "threads");
        }
    }

}
