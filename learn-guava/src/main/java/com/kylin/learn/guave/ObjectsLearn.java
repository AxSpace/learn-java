package com.kylin.learn.guave;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.kylin.learn.guave.beans.Person;

/**
 * JDK 7 中新引入的 Objects 类提供了等效的 Objects.equals 方法。
 *
 * @author kylin
 * @classname ObjectsLearn
 * @date 2024/2/18 13:16
 */
public class ObjectsLearn {

    private static final ObjectsLearn INSTANCE = new ObjectsLearn();

    /**
     * 使用单例获取实例
     */
    public static ObjectsLearn getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {

        // 学习Objects.equals()
        getInstance().learnEquals();
        // 学习Objects.hashCode()
        getInstance().learnHashCode();
        // 学习MoreObjects.toStringHelper()
        getInstance().learnMoreObjectsToString();
        //学习ComparisonChain
        getInstance().learnComparisonChain();

    }

    /**
     * 学习ComparisonChain
     */
    public void learnComparisonChain() {
        //初始化两个person对象
        Person person = Person.Builder.builder().firstName("kylin").lastName("Hk").zipCode(1).build();
        Person person1 = Person.Builder.builder().firstName("kylin").lastName("ZH").zipCode(2).build();
        //比较两个Person对象
        int i = person.compareTo(person1);
        System.out.println(i);

        //初始化两个LearnPerson对象
        LearnPerson learnPerson = LearnPerson.Builder.builder().firstName("kylin").lastName("Hk").zipCode(1).build();
        LearnPerson learnPerson1 = LearnPerson.Builder.builder().firstName("kylin").lastName("ZH").zipCode(2).build();
        //比较两个LearnPerson对象
        int i1 = learnPerson.compareTo(learnPerson1);
        System.out.println(i1);

    }

    private static class LearnPerson extends Person {
        private LearnPerson(Builder builder) {
            setLastName(builder.lastName);
            setFirstName(builder.firstName);
            setZipCode(builder.zipCode);
        }

        @Override
        public int compareTo(Person other) {
            return ComparisonChain.start().compare(this.getFirstName(), other.getFirstName()).compare(this.getLastName(), other.getLastName()).compare(this.getZipCode(), other.getZipCode(), Ordering.natural().nullsLast()).result();
        }


        public static final class Builder {
            private String lastName;
            private String firstName;
            private int zipCode;

            private Builder() {
            }

            public static Builder builder() {
                return new Builder();
            }

            public Builder lastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder firstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public Builder zipCode(int zipCode) {
                this.zipCode = zipCode;
                return this;
            }

            public LearnPerson build() {
                return new LearnPerson(this);
            }
        }
    }


    /**
     * 学习MoreObjects.toStringHelper()
     */
    public void learnMoreObjectsToString() {
        //设置了当前实例的toString方法
        String string = MoreObjects.toStringHelper(this).add("name", "kylin").toString();
        System.out.println(string);

        //设置了LearnObject实例的toString方法
        String toString = MoreObjects.toStringHelper("LearnObject").add("name", "kylin").toString();
        System.out.println(toString);
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
