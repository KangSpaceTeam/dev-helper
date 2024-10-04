package org.kangspace.devhelper.http;

import org.kangspace.devhelper.str.StringHelper;
import org.kangspace.devhelper.str.StringLiteral;

import javax.annotation.Nonnull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

/**
 * URL工具类
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/16
 */
public class UrlHelper {
    /**
     * URL编码
     *
     * @param url url
     * @return 编码后的url
     */
    public static String encode(@Nonnull String url) {
        if (StringHelper.isBlank(url)) {
            return url;
        }
        String charset = StandardCharsets.UTF_8.name();
        try {
            return URLEncoder.encode(url.trim(), charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * URL QueryString编码
     *
     * @param url url
     * @return 编码后的url
     */
    public static String encodeQueryString(@Nonnull String url) {
        if (StringHelper.isBlank(url)) {
            return url;
        }
        String charset = StandardCharsets.UTF_8.name();
        try {
            return URLEncoder.encode(url.trim(), charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * url转换
     *
     * @param urlPattern url变量, 如 http://example.com/{0}/{1}
     * @param params     urlPattern对应的变量值
     * @return 最终url
     */
    public static String url(String urlPattern, String... params) {
        if (StringHelper.isBlank(urlPattern)) {
            return urlPattern;
        }
        Object[] vars = new Object[params.length];
        for (int i = 0; i < params.length; i++) {
            String var = params[i] != null ? params[i].trim() : "";
            try {
                vars[i] = URLEncoder.encode(var, StandardCharsets.UTF_8.name());
            } catch (UnsupportedEncodingException e) {
                vars[i] = var;
            }
        }
        return MessageFormat.format(urlPattern, vars);
    }

    /**
     * url参数替换
     * @param url url
     * @param name 参数名
     * @param value 参数值
     */
    public static String urlReplaceParam(String url, String name, String value) {
        // 如何url中包含name参数，则删除并替换为新的value,如果不存在name，则添加该参数到url中
        String regex = "([?&])" + name + "=.*?(&|$)";
        url = url.replaceAll(regex, "$1" + name + "=" + value + "$2");
        String prefix = name + StringLiteral.EQUALS;
        if(!url.contains(prefix)){
            url += (url.contains(StringLiteral.QUESTION_MARK) ? StringLiteral.AND : StringLiteral.QUESTION_MARK) + prefix + value;
        }
        return url;
    }

    public static void main(String[] args) {
        System.out.println(urlReplaceParam("http://example.com/?a=1&b=2", "b", "3"));
        System.out.println(urlReplaceParam("http://example.com/", "b", "3"));
        System.out.println(urlReplaceParam("http://example.com/?b=2", "b", "3"));
    }
}
