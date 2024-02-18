package com.kylin.learn.day1;

import java.util.Objects;

/**
 * @author kylin
 * @classname KylinLearnOne
 * @date 2024/2/5 21:42
 */
public class KylinLearnOne implements KylinLearn{
    private static KylinLearnOne kylinLearn;

    private KylinLearnOne() {
        System.out.println("kylin learn one");
    }

    public static KylinLearnOne getInstance(){
        if(Objects.isNull(kylinLearn)){
            kylinLearn = new KylinLearnOne();
        }
        return kylinLearn;
    }

}
