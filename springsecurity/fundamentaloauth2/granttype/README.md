Password grant type  
![Password grant type](https://chunincoder.files.wordpress.com/2020/12/passwordgrantytpe.png?w=656)  
* Don't use this!  
* Client ask for user credential then sent to the authorization server (together with client credential). Sharing user credential is less secure!  

Configure password grant type in Spring Security  
```java
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServerConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client1")
                .secret("secret1")
                .scopes("read")
                .authorizedGrantTypes("password");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

}
```

Authorization code grant type  
![Authorization code grant type](https://chunincoder.files.wordpress.com/2020/12/authorizationcodegrantytpe-1.png?w=656)  
* Commonly used.  
* When talk to authorization server, client don't use user credential, only client credential.  
* User perform authentication directly into authorization server. Then authorization server call redirect url to give the authorization token.  
* Client use authorization code to request access token.  
* _Authorization code can only be used once._

Configure authorization code grant type in Spring Security
```java
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServerConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client2")
                .secret("secret2")
                .scopes("scope")
                .authorizedGrantTypes("authorization_code")
                .redirectUris("http://localhost:9090");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

}
```


Client credential grant type  
![Client credential grant type](https://chunincoder.files.wordpress.com/2020/12/clientcredentialgrantytpe.png)  
* No user is involved, use when we want authentication between two applications.

Configure authorization code grant type in Spring Security
```java
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServerConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client3")
                .secret("secret3")
                .scopes("read")
                .authorizedGrantTypes("client_credentials");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

}
```

Refresh token  
![Refersh token](https://chunincoder.files.wordpress.com/2020/12/refreshtoken.png)  
* Used together with other grant types.

Configure refresh token in Spring Security  
```java
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServerConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client1")
                .secret("secret1")
                .scopes("read")
                .authorizedGrantTypes("password", "refresh_token")
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

}
```  
The request is like this (password grant type)  
```text
localhost:8080/oauth/token?grant_type=password&username=fulan&password=12345&scope=read
```
The response contain refresh token is like this  
```json
{
    "access_token": "d32de9e2-d089-404c-9a8a-144c52350b50",
    "token_type": "bearer",
    "refresh_token": "9e6e2296-0d25-415c-bcc5-345c9ac91b52",
    "expires_in": 43199,
    "scope": "read"
}
```  
When request new access token using refresh token, the request is like this  
```text
localhost:8080/oauth/token?grant_type=refresh_token&scope=read&refresh_token=9e6e2296-0d25-415c-bcc5-345c9ac91b52
```

_You need to configure UserDetailService in AuthorizationServerEndpointsConfigurer_  
```java
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Autowired
    public AuthServerConfig(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }
        
    //other code

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.userDetailsService(userDetailsService);
    }
```
