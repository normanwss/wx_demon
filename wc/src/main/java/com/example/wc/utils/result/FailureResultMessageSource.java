package com.example.wc.utils.result;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;

public class FailureResultMessageSource extends ResourceBundleMessageSource {
    //~ Constructors ===================================================================================================
    public FailureResultMessageSource() {
        setAlwaysUseMessageFormat(true);
        setDefaultEncoding("UTF-8");
        setBasename("i18n.messages_failure");
    }

    //~ Methods ========================================================================================================
    public static MessageSourceAccessor getAccessor() {
        return new MessageSourceAccessor(new FailureResultMessageSource());
    }
}
