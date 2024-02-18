package com.kylin.learn.day1;

import java.util.EnumSet;

/**
 * @author kylin
 * @classname KylinLearn
 * @date 2024/2/5 21:41
 */
public interface KylinLearn {



    static KylinLearnOne kylinLearnOneInstance() {
        return KylinLearnOne.getInstance();
    }


}
