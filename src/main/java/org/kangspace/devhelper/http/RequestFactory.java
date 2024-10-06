package org.kangspace.devhelper.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * HttpClient工厂类
 * @author kango2gler@gmail.com
 * @since 0.0.4
 */
public class RequestFactory {
    /**
     * 默认最大重试次数
     */
    private static final int DEFAULT_MAX_RETRIES = 3;

    /**
     * 获取HttpClient对象 <br>
     * <pre>
     * 基础配置:
     * 超时时间: 60s
     * 连接超时时间: 30s
     * 读取超时时间: 60s
     * 最大连接数: 200
     * 每个路由的最大连接数: 20
     * 重试机制: IOException时 重试3次(不含首次请求)
     * </pre>
     *
     * @return HttpClient
     */
    public static CloseableHttpClient getHttpClient() {
        // 创建自定义的RequestConfig
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(60000)
                .setConnectionRequestTimeout(30000)
                .setSocketTimeout(60000)
                .build();
        // 添加重试机制
        HttpClientBuilder builder = HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
                .setMaxConnTotal(200)
                .setMaxConnPerRoute(20);

        // 设置重试处理器
        builder.setRetryHandler((exception, executionCount, context) -> {
            if (executionCount >= DEFAULT_MAX_RETRIES) {
                return false;
            }
            // 如果是IOException，进行重试
            return exception != null;
        });
        return builder.build();
    }
}
