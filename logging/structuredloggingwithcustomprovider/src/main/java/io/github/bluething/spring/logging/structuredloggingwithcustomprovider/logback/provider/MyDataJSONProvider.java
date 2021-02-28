package io.github.bluething.spring.logging.structuredloggingwithcustomprovider.logback.provider;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fasterxml.jackson.core.JsonGenerator;
import net.logstash.logback.composite.AbstractFieldJsonProvider;
import net.logstash.logback.composite.FieldNamesAware;
import net.logstash.logback.composite.JsonWritingUtils;

import java.io.IOException;

public class MyDataJSONProvider extends AbstractFieldJsonProvider<ILoggingEvent> implements FieldNamesAware<MyLogstashFieldNames> {
    public static final String FIELD_NAME = "what";
    public static final String FIELD_LEVEL = "level";
    public static final String FIELD_MESSAGE = "message";

    private String what = FIELD_NAME;
    private String level = FIELD_LEVEL;
    private String message = FIELD_MESSAGE;

    @Override
    public void writeTo(JsonGenerator generator, ILoggingEvent event) throws IOException {
        JsonWritingUtils.writeStringField(generator, level, event.getLevel().toString());
        JsonWritingUtils.writeStringField(generator, message, event.getFormattedMessage());
    }

    @Override
    public void setFieldNames(MyLogstashFieldNames fieldNames) {
        setFieldName(fieldNames.getWhat());
    }
}
