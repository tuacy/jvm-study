package com.jvm.study.oom.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出 java.lang.OutOfMemoryError Java heap space
 *
 * 解决办法是增加堆内存空间，在实际开发中必要的时候去掉引用关系，使垃圾回收器尽快对无用对象进行回收。
 *
 */
public class HeapMemoryOutOfMemoryErrorMock {
    /**
     * 内存申请的太大了,超过了启动限制,最后跑出  java.lang.OutOfMemoryError: Java heap space
     */

    public static void main(String[] args) {
        List<Byte[]> list = new ArrayList<Byte[]>();
        for (int i = 0; i < 10000; i++) {
            //构造1M大小的byte数值
            Byte[] bytes = new Byte[1024 * 1024];
            //将byte数组添加到list列表中，因为存在引用关系所以bytes数组不会被GC回收
            list.add(bytes);
        }
    }
}
