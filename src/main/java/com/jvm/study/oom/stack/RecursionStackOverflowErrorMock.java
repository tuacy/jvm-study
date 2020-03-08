package com.jvm.study.oom.stack;

/**
 * 线程请求的栈深度大于虚拟机栈运行的深度，抛出StackOverflowError
 * (jvm规定了Java虚拟机栈的最大深度，当执行时栈的深度大于规定的深度，就会抛出StackOverflowError错误)
 * <p>
 * 我们用一个递归来模拟StackOverflowError异常
 */
public class RecursionStackOverflowErrorMock {

    private int stackLength = 1;

    /**
     * 一直调用同一个方法,会一直入栈,最终超过Java虚拟机栈规定的最大深度抛出StackOverflowError异常
     */
    private void recursion() {
        stackLength++;
        recursion();
    }

    public static void main(String[] args) {
        RecursionStackOverflowErrorMock demo = new RecursionStackOverflowErrorMock();
        try {
            demo.recursion();
        } catch (Throwable throwable) {
            System.out.println("当前栈深度:stackLength=" + demo.stackLength);
            throwable.printStackTrace();
        }
    }

}
