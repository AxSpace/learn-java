package com.kylin.learn.guave;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.kylin.learn.guave.beans.LearnWorker;

import java.util.*;

/**
 * @author kylin
 * @classname OrderingLearn
 * @date 2024/2/16 10:20
 */
public class OrderingLearn {
    public static void main(String[] args) {
        //初始化一个示例
        OrderingLearn orderingLearn = new OrderingLearn();

        //学习自然排序
        orderingLearn.learnNatural();

        //学习使用toString排序
        orderingLearn.learnUsingToString();

        //学习使用预Comparator进行排序
        orderingLearn.learnFromComparator();

        //学习Ordering.reverse()
        orderingLearn.learnOrderingReverse();

        //学习Ordering.nullsFirst()
        orderingLearn.learnOrderingNullsFirst();

        //学习Ordering.nullsLast()
        orderingLearn.learnOrderingNullsLast();

        //学习Ordering.compound()
        orderingLearn.learnOrderingCompound();

        //学习Ordering.onResultOf()
        orderingLearn.learnOrderingOnResultOf();

        //学习Ordering.min()和Ordering.max()
        orderingLearn.learnOrderingMinAndMax();

    }


    /**
     * 学习Ordering.min()和Ordering.max()
     */
    public void learnOrderingMinAndMax() {
        List<LearnWorker> learnWorkers = builderWorkerItem();

        //使用Ordering.from()进行排序 基于SequenceNo进行排序
        Ordering<LearnWorker> from = Ordering.from(new LearnWorkerSequenceNoComparator());

        //获取SequenceNo最大的LearnWorker
        LearnWorker max = from.max(learnWorkers);
        System.out.println(max.toString());

        //获取SequenceNo最小的LearnWorker
        LearnWorker min = from.min(learnWorkers);
        System.out.println(min.toString());

        //判断是否有序 false
        boolean ordered = from.isOrdered(learnWorkers);
        System.out.println(ordered);

        //使用Ordering.from()进行排序
        learnWorkers.sort(from);

        //判断是否有序 true
        boolean fromOrdered = from.isOrdered(learnWorkers);
        System.out.println(fromOrdered);

    }


    /**
     * 使用Ordering.onResultOf()进行排序
     */
    public void learnOrderingOnResultOf() {
        List<LearnWorker> learnWorkers = builderWorkerItem();

        Ordering<LearnWorker> learnWorkerOrdering = Ordering.natural().onResultOf(LearnWorker::getSequenceNo);

        learnWorkers.sort(learnWorkerOrdering);

        learnWorkers.forEach(System.out::println);
    }


    /**
     * 使用Ordering.compound()进行排序
     */
    public void learnOrderingCompound() {

        List<LearnWorker> learnWorkers = builderWorkerItem();

        Ordering<LearnWorker> compound = Ordering.from(new LearnWorkerSequenceNoComparator()).compound(new LearnWorkerNameComparator());

        learnWorkers.sort(compound);

        learnWorkers.forEach(System.out::println);
    }

    /**
     * 使用Ordering.nullsLast()进行排序
     */
    public void learnOrderingNullsLast() {
        List<Integer> list = Arrays.asList(1, 3, 14, 12, 16, 15, null, 5, null, 7, 8, 9, 11, 17, 10, 4, 18, 3, 19, 10);
        list.sort(Ordering.natural().nullsLast());
        System.out.println(list);
    }

    /**
     * 使用Ordering.nullsFirst()进行排序
     */
    public void learnOrderingNullsFirst() {
        List<Integer> list = Arrays.asList(1, 3, 14, 12, 16, 15, null, 5, null, 7, 8, 9, 11, 17, 10, 4, 18, 3, 19, 10);
        list.sort(Ordering.natural().nullsFirst());
        System.out.println(list);
    }

    /**
     * 使用Ordering.reverse()进行倒序
     */
    public void learnOrderingReverse() {
        List<Integer> list = Arrays.asList(1, 3, 14, 12, 16, 15, 2, 5, 6, 7, 8, 9, 11, 17, 10, 4, 18, 3, 19, 10);
        list.sort(Ordering.natural().reverse());
        System.out.println(list);

    }


    /**
     * 使用Comparator进行排序
     */
    public void learnFromComparator() {

        List<LearnWorker> learnWorkers = builderWorkerItem();

        Ordering<LearnWorker> from = Ordering.from(new LearnWorkerSequenceNoComparator());

        learnWorkers.sort(from);

        learnWorkers.forEach(System.out::println);
    }

    /**
     * 使用toString排序
     */
    public void learnUsingToString() {
        List<String> list = Arrays.asList("zhangsan", "wangwu", "lisi");
        list.sort(Ordering.usingToString());
        System.out.println(list);
    }

    /**
     * 自然排序
     */
    public void learnNatural() {
        List<Integer> list = Arrays.asList(1, 3, 14, 12, 16, 15, 2, 5, 6, 7, 8, 9, 11, 17, 10, 4, 18, 3, 19, 10);
        list.sort(Ordering.natural());
        System.out.println(list);
    }


    private List<LearnWorker> builderWorkerItem() {
        LearnWorker learnWorker = builderWorker("4", "zhangsan", "12345678901234567890", "99");
        LearnWorker learnWorker1 = builderWorker("3", "lisi", "12345678901234567890", "99");
        LearnWorker learnWorker2 = builderWorker("1", "kylin", "222424199505056517", "99");
        LearnWorker learnWorker3 = builderWorker("1", "hk", "222424199505056527", "99");
        return Lists.newArrayList(learnWorker, learnWorker1, learnWorker2, learnWorker3);
    }


    /**
     * 初始化一个LearnWorker
     *
     * @param sequenceNo 序列号
     * @param name       姓名
     * @param certNo     证件号
     * @param certType   证件类型
     * @return LearnWorker
     */
    public LearnWorker builderWorker(String sequenceNo, String name, String certNo, String certType) {
        return LearnWorker.builder().name(name).sequenceNo(sequenceNo).certNo(certNo).certType(certType).build();
    }


    /**
     * 自定义Comparator 使用Sequence进行对比
     */
    private static class LearnWorkerSequenceNoComparator implements Comparator<LearnWorker> {
        @Override
        public int compare(LearnWorker o1, LearnWorker o2) {
            return o1.getSequenceNo().compareTo(o2.getSequenceNo());
        }
    }

    /**
     * 自定义Comparator 使用Name进行对比
     */

    private static class LearnWorkerNameComparator implements Comparator<LearnWorker> {
        @Override
        public int compare(LearnWorker o1, LearnWorker o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }


}
