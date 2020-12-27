## Introduction

Spring Boot uses Commons Logging for all internal logging but leaves the underlying log implementation open. 
If you use the “Starters”, Logback is used for logging with SLF4j as implementation. We can see in dependencies tree,
spring-boot-starter contain spring-boot-starter-logging. spring-boot-starter-logging contain following libraries:  
* logback-classic
* log4j-to-slf4j
* log4j-over-slf4j

Whenever you use any starters like spring-boot-starter-web or spring-boot-starter-web, you get logging those logging library free.

Default log output is like this  
```text
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.1)

2020-12-27 15:30:12.298  INFO 3443 --- [           main] i.g.b.s.l.f.FundamentalApplication       : Starting FundamentalApplication using Java 14.0.2 on chunincoder-lab with PID 3443 (/home/chunincoder/workspace/exercisesspring/logging/fundamental/build/classes/java/main started by chunincoder in /home/chunincoder/workspace/exercisesspring/logging)
2020-12-27 15:30:12.300  INFO 3443 --- [           main] i.g.b.s.l.f.FundamentalApplication       : No active profile set, falling back to default profiles: default
2020-12-27 15:30:12.649  INFO 3443 --- [           main] i.g.b.s.l.f.FundamentalApplication       : Started FundamentalApplication in 0.571 seconds (JVM running for 1.059)
```  
The output divided into several part:  
* Date and Time: Millisecond precision and easily sortable.  
* Log Level: ERROR, WARN, INFO, DEBUG, or TRACE.  
* Process ID.  
* A --- separator to distinguish the start of actual log messages.  
* Thread name: Enclosed in square brackets (maybe truncated for console output).  
* Logger name: This is usually the source class name (often abbreviated).  
* The log message.

By default, all logging goes to console and log level set to INFO.

### Configuration

Log configuration can be done via command-line parameters or add properties to application.properties (or application.yml).  
```text
java -jar myapp.jar --debug

or

add debug=true in our application.properties (or application.yml)
```

##### Configure Log Level

```text
logging.level.<package>=DEBUG
logging.level.<other-package>=ERROR
logging.level.root=WARN

or

java -jar myapp.jar -Dlogging.level.<package>=DEBUG -Dlogging.level.root=WARN
```

##### Logging to file  
We need to set a logging.file.name or logging.file.path property application.properties. By default, for file output, the log level is set to info. 
_If both properties are set, only logging.file.name takes effect_.

##### File rotation
If you are using the Logback (default), it’s possible to fine-tune log rotation settings using your application.properties or application.yaml file. For all other logging system, you’ll need to configure rotation settings directly yourself (for example, if you use Log4J2 then you could add a log4j.xml file). Rotation policy properties:

Name | Description
---- | -----------
logging.logback.rollingpolicy.file-name-pattern | Used to create log archives.
logging.logback.rollingpolicy.clean-history-on-start | If log archive cleanup should occur when the application starts.
logging.logback.rollingpolicy.max-file-size | The maximum size of log file before it’s archived.
logging.logback.rollingpolicy.total-size-cap | The maximum amount of size log archives can take before being deleted.
logging.logback.rollingpolicy.max-history | The number of days to keep log archives (defaults to 7)

#### Custom Log Configuration  
The various logging systems can be activated by including the appropriate libraries on the classpath and can be further customized by providing a suitable configuration file in the root of the classpath or in a location specified by the following Spring Environment property: logging.config. 
You can force Spring Boot to use a particular logging system by using the org.springframework.boot.logging.LoggingSystem system property.

Logging System | Customization
-------------- | -------------
Logback | logback-spring.xml, logback-spring.groovy, logback.xml, or logback.groovy
Log4j2 | log4j2-spring.xml or log4j2.xml
JDK (Java Util Logging) (_avoid this!_) | logging.properties

##### Logback configuration  
Because the standard logback.xml configuration file is loaded too early, you cannot use extensions in it. You need to either use logback-spring.xml or define a logging.config property.

#### Switching the Logger Implementation to Log4J2  
We can change the default Logback with other logging library by including their starters and excluding the default spring-boot-starter-logging in pom.xml or build.gradle  
```xml
dependencies {
    implementation('org.springframework.boot:spring-boot-starter') {
        exclude group:'org.springframework.boot', module:'spring-boot-starter-logging'
    }
    implementation 'org.springframework.boot:spring-boot-starter-log4j2'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

### References:
* [4.4. Logging](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-logging)