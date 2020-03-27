package com.jvm.study.threaddump;

/**
 * 模拟线程死锁的状态
 */
public class DeadLockMock {

    private final static String fileA = "A文件";
    private final static String filedB = "B文件";

    public static void main(String[] args) {
        new Thread("线程1") { //线程1
            //重写run方法
            public void run() {
                while (true) {
                    synchronized (fileA) {//打开文件A,线程独占fileA
                        System.out.println(this.getName() + ":文件A写入");
                        synchronized (filedB) {
                            System.out.println(this.getName() + ":文件B写入");
                        }
                        System.out.println(this.getName() + ":所有文件保存");
                    }
                }
            }
        }.start();

        new Thread("线程2") { //线程2
            //重写run方法
            public void run() {
                while (true) {
                    synchronized (filedB) {//打开文件B,线程独占filedB
                        System.out.println(this.getName() + ":文件B写入");
                        synchronized (fileA) {
                            System.out.println(this.getName() + ":文件A写入");
                        }
                        System.out.println(this.getName() + ":所有文件保存");
                    }
                }
            }
        }.start();
    }

}
