package com.kylin.learn.guave;

import com.google.common.collect.ImmutableList;

/**
 * @author kylin
 * @classname ImmutableLearn
 * @date 2024/2/18 20:54
 */
public class ImmutableLearn {
    public static final ImmutableLearn INSTANCE = new ImmutableLearn();

    public ImmutableLearn getInstance() {
        return INSTANCE;
    }

    private ImmutableLearn() {

    }

    public static void main(String[] args) {

        ImmutableList<String> strings = ImmutableList.of("1", "2", "3");

        System.out.printf(strings.toString());

    }


}
