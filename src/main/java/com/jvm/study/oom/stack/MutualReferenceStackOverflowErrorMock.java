package com.jvm.study.oom.stack;

/**
 * 线程请求的栈深度大于虚拟机栈运行的深度，抛出StackOverflowError
 * (jvm规定了Java虚拟机栈的最大深度，当执行时栈的深度大于规定的深度，就会抛出StackOverflowError错误)
 * <p>
 * 模拟两个对象相互引用可能产生StackOverflowError的情况
 * toString()方法相互调用
 */
public class MutualReferenceStackOverflowErrorMock {

    static class Student {
        Teacher teacher;

        @Override
        public String toString() {
            return "Student{" +
                    "teacher=" + teacher +
                    '}';
        }
    }

    static class Teacher {
        Student student;

        @Override
        public String toString() {
            return "Teacher{" +
                    "student=" + student +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        student.teacher = teacher;
        teacher.student = student;
        System.out.println(teacher.toString());
    }

}
