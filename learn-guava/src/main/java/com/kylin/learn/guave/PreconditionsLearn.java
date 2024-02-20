package com.kylin.learn.guave;

import com.google.common.base.Preconditions;

/**
 * @author kylin
 * @classname PreconditionsLearn
 * @date 2024/2/15 19:58
 */
public class PreconditionsLearn {

    private static final PreconditionsLearn INSTANCE = new PreconditionsLearn();

    public static PreconditionsLearn getInstance() {
        return INSTANCE;
    }

    private PreconditionsLearn() {
    }

    public static void main(String[] args) {

        //checkElementIndex
        getInstance().learnCheckElementIndex();

        //checkArgument
        getInstance().learnCheckArgument();

    }


    /**
     * Learn the usage of checkArgument method.
     */
    private void learnCheckArgument() {
        //初始化一个int数字
        int i = 1;
        System.out.println(String.format("初始化一个数值:%d",i));

        System.out.println(String.format("正常检查:%d==1",i));
        //正常情况
        Preconditions.checkArgument(i == 1);

        i = 2;

        System.out.println(String.format("异常检查:%d==1",i));
        //异常情况
        Preconditions.checkArgument(i == 1, String.format("检查失败:%d!=1",i));
    }


    /**
     * Learn the usage of checkElementIndex method.
     */
    private void learnCheckElementIndex() {
        //正常情况
        int i = Preconditions.checkElementIndex(1, 2);
        System.out.println(i);

        //异常情况
        int i1 = Preconditions.checkElementIndex(1, 0, "index out of range");
        System.out.println(i1);

    }

}
