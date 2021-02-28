package io.github.bluething.spring.logging.structuredloggingwithcustomprovider.logback.provider;

import net.logstash.logback.fieldnames.LogstashFieldNames;

public class MyLogstashFieldNames extends LogstashFieldNames {
    public static final String FIELD_NAME = "what";
    public static final String FIELD_LEVEL = "level";
    public static final String FIELD_MESSAGE = "message";

    private String what = FIELD_NAME;
    private String level = FIELD_LEVEL;
    private String message = FIELD_MESSAGE;

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    @Override
    public String getLevel() {
        return level;
    }

    @Override
    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
