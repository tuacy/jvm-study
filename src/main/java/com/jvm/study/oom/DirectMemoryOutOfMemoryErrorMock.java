package com.jvm.study.oom;

import java.nio.ByteBuffer;

/**
 * 直接内存溢出 java.lang.OutOfMemoryError
 * ByteBuffer.allocateDirect() 申请的是本地的直接内存，并非java堆内存
 *
 */
public class DirectMemoryOutOfMemoryErrorMock {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {
            //申请堆外内存，这个内存是本地的直接内存，并非java堆内存
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
            System.out.println("created " + i + " byteBuffer");
        }
    }

//
//    public static void main(String[] args) throws Exception {
//        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
//        unsafeField.setAccessible(true);
//        Unsafe unsafe = (Unsafe) unsafeField.get(null);
//        while (true) {
//            unsafe.allocateMemory(_1MB);
//        }
//    }

}
