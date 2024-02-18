package com.kylin.learn.guave;

import com.google.common.base.MoreObjects;

import java.util.Optional;

/**
 * @author kylin
 * @classname OptionalLearn
 * @date 2024/2/15 19:22
 */
public class OptionalLearn {


    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");


        optional.get();

        optional.isPresent();

        optional.orElse("world");

        optional.orElseGet(() -> {
            return "world";
        });

        optional.orElseThrow(() -> {
            return new RuntimeException("error");
        });

        optional.ifPresent(System.out::println);

        optional.map(String::toUpperCase).orElse("world");

        optional.flatMap(s -> Optional.of(s.toUpperCase())).orElse("world");


        String s = MoreObjects.firstNonNull("hello", "world");

        MoreObjects.toStringHelper(OptionalLearn.class).add("name", "kylin");

    }

}
