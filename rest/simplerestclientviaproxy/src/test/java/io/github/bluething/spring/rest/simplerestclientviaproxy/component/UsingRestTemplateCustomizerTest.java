package io.github.bluething.spring.rest.simplerestclientviaproxy.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class UsingRestTemplateCustomizerTest {

    @Autowired
    private ProxyCustomizer proxyCustomizer;

    @Test
    public void callWebWithHttpsUsingProxyReturnOk() {
        RestTemplate restTemplate = new RestTemplateBuilder(proxyCustomizer).build();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://www.pegipegi.com/", String.class);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
