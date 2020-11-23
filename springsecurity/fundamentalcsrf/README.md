### Cross Site Request Forgery (CSRF)

Cross-Site Request Forgery (CSRF) is an attack that forces an end user to execute unwanted actions on a web application in which they’re currently authenticated.  
For most sites, browser requests automatically include any credentials associated with the site, such as the user’s session cookie, IP address, Windows domain credentials, and so forth. Therefore, if the user is currently authenticated to the site, the site will have no way to distinguish between the forged request sent by the victim and a legitimate request sent by the victim.

How CSRF work:  
Attacker sent link to their victim, for example using an email. The link contain malicious code to do some action.  
When the victim is unconscious click the link, the code will run and sent the request to server.

How to prevent CSRF attack:
- Using a secret cookie
- Only accepting POST requests
- Multi-Step Transactions
- URL Rewriting

In Spring Security, we can use csrf token (_csrf).  
Spring Security will generate _csrf token every time we refresh the page.  
_csrf token needed by server to authenticated if the mutation request come from who ask the form.  
There are case when we don't need _csrf token, OAuth.  
_csrf token generate in CsrfFilter.

References:  
- [OWASP CSRF](https://owasp.org/www-community/attacks/csrf)
- [Spring Security CSRF](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-csrf-using)