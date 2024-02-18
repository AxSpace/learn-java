package com.kylin.learn.guave;

import com.google.common.base.Objects;

/**
 * JDK 7 中新引入的 Objects 类提供了等效的 Objects.equals 方法。
 *
 * @author kylin
 * @classname ObjectsLearn
 * @date 2024/2/18 13:16
 */
public class ObjectsLearn {

    private static final ObjectsLearn INSTANCE = new ObjectsLearn();

    public static void main(String[] args) {

        // 学习Objects.equals()
        getInstance().learnEquals();
        // 学习Objects.hashCode()
        getInstance().learnHashCode();

    }


    /**
     * 使用单例获取实例
     */
    public static ObjectsLearn getInstance() {
        return INSTANCE;
    }


    /**
     * 学习Objects.equals()
     * JDK 7 中新引入的 Objects 类提供了等效的 Objects.equals 方法。
     */
    public void learnEquals() {
        String s1 = "1";
        String s2 = "1";
        System.out.println(Objects.equal(s1, s2));
        System.out.println(s1.equals(s2));
    }

    /**
     * 学习Objects.hashCode()
     * JDK 7 中新引入的 Objects 类提供了等效的 Objects.hash(Object...)
     */
    public void learnHashCode() {
        int i = Objects.hashCode("1", "2");
        System.out.println(i);
    }

}
