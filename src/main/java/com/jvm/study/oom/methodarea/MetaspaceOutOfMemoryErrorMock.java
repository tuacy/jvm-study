package com.jvm.study.oom.methodarea;

import com.jvm.study.oom.utils.CglibBean;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 元空间内存溢出 java.lang.OutOfMemoryError: Metaspace
 * (
 * JDK1.7之前抛出的是java.lang.OutOfMemoryError: PermGen space.
 * JDK1.8之后抛出的是java.lang.OutOfMemoryError: Metaspace
 * 因为在JDK1.8中， HotSpot已经没有 “PermGen space”这个区间了，取而代之是一个叫做Metaspace(元空间)的东西
 * )
 * <p>
 * 解决该OOM的办法是增大MaxMetaspaceSize参数值，或者干脆不设置该参数，在默认情况元空间可使用的内存会受到本地内存的限制。
 */
public class MetaspaceOutOfMemoryErrorMock {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1000; i++) {
            //动态创建类
            Map<String, Class<?>> propertyMap = new HashMap<String, Class<?>>();
            propertyMap.put("id", Class.forName("java.lang.Integer"));
            CglibBean bean = new CglibBean(propertyMap);
            //给 Bean 设置值
            bean.setValue("id", new Random().nextInt(100));
            //打印 Bean的属性id
            System.out.println("id=" + bean.getValue("id"));
        }
    }
}
