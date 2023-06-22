package org.kangspace.devhelper.str;

import javax.annotation.Nonnull;

/**
 * 字符串工具类
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/22
 */
public class StringHelper {

    /**
     * 字符串是否全空格
     *
     * @param str str
     * @return boolean
     */
    public static boolean isBlank(@Nonnull String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 字符串是否非全空格
     *
     * @param str str
     * @return boolean
     */
    public static boolean isNotBlank(@Nonnull String str) {
        return !isBlank(str);
    }

    /**
     * 字符串是否为空
     *
     * @param str str
     * @return boolean
     */
    public static boolean isEmpty(@Nonnull String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 字符串是否不为为空
     *
     * @param str str
     * @return boolean
     */
    public static boolean isNotEmpty(@Nonnull String str) {
        return !isEmpty(str);
    }

    /**
     * 字符串非空
     * @param str str
     * @param message 字符串为空时,异常提示信息
     * @return str
     */
    public static String requireNonEmpty(String str, String message) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException(message);
        }
        return str;
    }

    /**
     * 字符串非全空格
     * @param str str
     * @param message 字符串为空时,异常提示信息
     * @return str
     */
    public static String requireNonBlank(String str, String message) {
        if (isBlank(str)) {
            throw new IllegalArgumentException(message);
        }
        return str;
    }
}
