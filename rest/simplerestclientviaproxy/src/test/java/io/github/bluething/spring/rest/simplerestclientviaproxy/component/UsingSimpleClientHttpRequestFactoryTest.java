package io.github.bluething.spring.rest.simplerestclientviaproxy.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class UsingSimpleClientHttpRequestFactoryTest {

    @Value("${proxy.host}")
    public String proxyHost;
    @Value("${proxy.port}")
    public Integer proxyPort;

    @Test
    public void callWebWithHttpsUsingProxyReturnOk() {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setProxy(proxy);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://www.pegipegi.com/", String.class);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
