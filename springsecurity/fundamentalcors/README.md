Cross-origin resource sharing (CORS) is an HTTP header based mechanism that allow web browser to consume resources from multiple origins (_domain_, _scheme_, or _port_). For security reason, web browser restrict cross-origin HTTP requests.

<p align="center">
  <img src="https://media.prod.mdn.mozit.cloud/attachments/2016/10/28/14295/a21a85eaccd405d608395b4ca8d82538/CORS_principle.png">
</p>


The header is _Access-Control-Allow-Origin_ allow us specify which are the origins that are accepted.

For example, we have a web page at http://localhost:8080 request an api from http://localhost:8080/test. When we open from http://127.0.0.1:8080/ we will get error like this

Cross-Origin Request Blocked: The Same Origin Policy disallows reading the remote resource at http://localhost:8080/test. (Reason: CORS header ‘Access-Control-Allow-Origin’ missing).

The question, when we open from http://127.0.0.1:8080/ if the request received and proceed by server? YES

CORS doesn't disallow us to call the endpoint. We still call the endpoint, the request done by the server, but the client (web browser) won't receive the response.  
The server sent the response, but the client won't receive it.

So be careful with mutating operation (POST, PUT, DELETE).

We can use [preflight request](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS) to check if the server will permit the actual request.

Spring security can configure cors with HttpSecurity.cors method.

```java
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // by default uses a Bean by the name of corsConfigurationSource
            .cors(withDefaults())
            ...
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
```

References:  
[Cross-Origin Resource Sharing (CORS)](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS)  
[Spring Security CORS](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#cors)