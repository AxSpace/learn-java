package com.kylin.learn.guave;

import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;

import java.util.List;

/**
 * @author kylin
 * @classname ThrowablesLearn
 * @date 2024/2/18 19:22
 */
public class ThrowableLearn {

    private static final ThrowableLearn INSTANCE = new ThrowableLearn();

    public static ThrowableLearn getInstance() {
        return INSTANCE;
    }

    private ThrowableLearn() {
    }


    public static void main(String[] args) {
        ThrowableLearn instance = getInstance();
        // 学习Throwables.throwIfInstanceOf()
        instance.learnThrowIfInstanceOf();
        // 学习Throwables.throwIfUnchecked()
        instance.learnThrowIfUnchecked();
        // 学习Throwables.getRootCause()
        instance.learnGetRootCause();
        // 学习Throwables.getCauseChain()
        instance.learnGetCauseChain();
        // 学习Throwables.getStackTraceAsString()
        instance.learnGetStackTraceAsString();
    }


    /**
     * 学习Throwables.throwIfInstanceOf()
     *<p>如果是指定的异常（NullPointerException）的实例，则抛出 throwable 。</p>
     */
    private void learnThrowIfInstanceOf() {
        Throwable throwable;
        try {
            throw new RuntimeException("test");
        } catch (Exception e) {
            System.out.println(e);
            throwable = e;
        }
        Throwables.throwIfInstanceOf(throwable, NullPointerException.class);
    }

    /**
     * 学习Throwables.throwIfUnchecked()
     *<p>如果是 RuntimeException 或 Error ，则抛出 throwable 。</p>
     */
    private void learnThrowIfUnchecked() {
        Throwable throwable;
        try {
            throw new NullPointerException("test");
        } catch (Exception e) {
            System.out.println(e);
            throwable = e;
        }
        Throwables.throwIfUnchecked(throwable);
    }


    /**
     * 学习获取Throwable的根原因
     * <p>返回 throwable 的最内层原因。链中的第一个可抛出项提供了最初检测到错误或异常时的上下文。</p>
     */
    private void learnGetRootCause() {
        try {
            throw new RuntimeException("test");
        } catch (Exception e) {
            Throwable rootCause = Throwables.getRootCause(e);
            System.out.println("test".equals(rootCause.getMessage()));
        }
    }

    /**
     * 学习Throwable的cause链
     * <p>
     * 获取 Throwable 原因链。列表中的第一个条目将是 throwable ，然后是其原因层次结构。请注意，这只是原因链的快照，不会反映原因链的任何后续更改。
     * </p>
     */
    private void learnGetCauseChain() {
        try {
            throw new RuntimeException("test");
        } catch (Exception e) {
            List<Throwable> causalChain = Throwables.getCausalChain(e);
            Iterables.filter(causalChain, RuntimeException.class).forEach(System.out::println);
        }


    }


    /**
     * 学习Throwable的StackTrace 以String的形式输出
     */
    private void learnGetStackTraceAsString() {
        try {
            throw new RuntimeException("test");
        } catch (Exception e) {
            System.out.println(Throwables.getStackTraceAsString(e));
        }
    }


}
