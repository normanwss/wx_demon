package com.example.wc.utils.result;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.context.support.MessageSourceAccessor;

import java.io.IOException;

public class ResultSerializer extends JsonSerializer<IResult> {
    protected static MessageSourceAccessor successMessages = SuccResultMessageSource.getAccessor();
    protected static MessageSourceAccessor failMessages = FailureResultMessageSource.getAccessor();

    @Override
    public void serialize(IResult value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeFieldName("resultCode");
        jgen.writeNumber(value.getResultCode());
        String msg;
        if (value.getResultMsg() != null && "".equals(value.getResultMsg()) == false) {
            msg = value.getResultMsg();
        } else {
            if (value.getResultCode() == 0) {
                msg = successMessages.getMessage(value.toString(), value.getArgs(), value.toString());
            } else {
                msg = failMessages.getMessage(value.toString(), value.getArgs(), value.toString());
            }
        }
        if (msg != null && "".equals(msg) == false) {
            jgen.writeFieldName("resultMsg");
            jgen.writeString(msg);
        }

        jgen.writeEndObject();
    }

}
