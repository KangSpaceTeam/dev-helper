package org.kangspace.devhelper.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * RequestFactory Tester.
 */
@Slf4j
@RunWith(JUnit4.class)
public class RequestFactoryTest {

    /**
     * Method: getHttpClient()
     */
    @Test
    public void getHttpClient() throws IOException {
        CloseableHttpClient client = RequestFactory.getHttpClient();
        CloseableHttpResponse response = client.execute(new HttpGet("http://www.baidu.com"));
        Assert.assertNotNull(response);
        log.info(response.toString());
    }
}