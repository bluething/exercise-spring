package io.github.bluething.spring.rest.simplerestclientviaproxy.component;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProxyCustomizer implements RestTemplateCustomizer {

    @Value("${proxy.host}")
    public String proxyHost;
    @Value("${proxy.port}")
    public Integer proxyPort;

    @Override
    public void customize(RestTemplate restTemplate) {
        HttpHost proxy = new HttpHost(proxyHost, proxyPort);
        HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy){

            @Override
            protected HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
                return super.determineProxy(target, request, context);
            }
        }).build();

        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
    }
}
