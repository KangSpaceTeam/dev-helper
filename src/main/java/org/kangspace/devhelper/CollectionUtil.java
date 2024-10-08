package org.kangspace.devhelper;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
public class CollectionUtil {

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?,?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isNotEmpty(Map<?,?> map) {
        return !isEmpty(map);
    }

    public static <T> T first(Collection<T> collection) {
        return isNotEmpty(collection) ? collection.stream().findFirst().orElse(null) : null;
    }
}
