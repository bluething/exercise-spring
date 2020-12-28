#### Configuration

Spring Boot starter contain spring-boot-starter-logging that contain logback-classic (Logback with SLF4J implementation). 
We only need to add logstash-logback-encoder, this library provides logback encoders, layouts, and appenders to log in JSON and other formats supported by Jackson.

We need to configure logback via logback-spring.xml. We define what JSON fields will print to log. There are standard fields, MDC fields, Context fields and Caller Info fields.  
We can add custom fields either globally, or on an event-by-event basis.  
For event specific, we can create custom fields using:  
1. structured arguments provided by [StructuredArguments](https://github.com/logstash/logstash-logback-encoder/blob/master/src/main/java/net/logstash/logback/argument/StructuredArguments.java). 
   Included in the log event's formatted message (when the message has a parameter for the argument) AND in the JSON output.
2. markers provided by [Markers](https://github.com/logstash/logstash-logback-encoder/blob/master/src/main/java/net/logstash/logback/marker/Markers.java).
   Only written to the JSON output

There are two event types:  
1. LoggingEvent. An application logging calls like log.info().  
2. AccessEvent. Provide fields like HTTP method, URI, status code, and elapsed time and directly address our need for historical trending.



#### References

* [logstash-logback-encoder Github](https://github.com/logstash/logstash-logback-encoder)  
* [A whole product concern logging implementation](http://stevetarver.github.io/2016/04/20/whole-product-logging.html)