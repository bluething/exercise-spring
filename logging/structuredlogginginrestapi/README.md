##### @RestController

@RestController = @Controller + @ResponseBody  
Introduced in Spring 4.0. Types that carry this annotation are treated as controllers where @RequestMapping methods assume @ResponseBody semantics by default. We don't need to use @ResponseBody on each and every handler method.  
@RestController return object and directly written into http response as JSON orXML.


#### @RestControllerAdvice

@RestControllerAdvice = @ControllerAdvice + @ResponseBody  
@RestControllerAdvice tells a controller that the object returned is automatically serialized into JSON and pass it to the HttResponse object.  
We only need to return Java object instead of ResponseEntity. Status code will always 200 (OK), use ResponseStatus to set the HTTP status code for the response. The exception instance and the request will be injected via method arguments.

##### Reference:  
* [Annotation Type RestController](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)
* [@RestControllerAdvice example in Spring Boot](https://bezkoder.com/spring-boot-restcontrolleradvice/)