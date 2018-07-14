package com.example.wc.utils.result;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;

public class SuccResultMessageSource extends ResourceBundleMessageSource {

    public SuccResultMessageSource() {
        setAlwaysUseMessageFormat(true);
        setDefaultEncoding("UTF-8");
        setBasename("i18n.messages_success");
    }

    public static MessageSourceAccessor getAccessor() {
        return new MessageSourceAccessor(new SuccResultMessageSource());
    }
}
