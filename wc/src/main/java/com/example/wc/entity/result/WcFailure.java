package com.example.wc.entity.result;

import com.example.wc.utils.result.FailureResultMessageSource;
import com.example.wc.utils.result.IResult;
import org.springframework.context.support.MessageSourceAccessor;

public enum WcFailure implements IResult {
    ERROR,
    USER_SERVER_ERROR(4002);

    static MessageSourceAccessor failMessages = FailureResultMessageSource.getAccessor();

    int resultCode;
    String resultMsg;
    Object[] args;

    WcFailure() {
        this(-1, null);
    }

    WcFailure(int resultCode) {
        this(resultCode, null);
    }

    WcFailure(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public static MessageSourceAccessor getFailMessages() {
        return failMessages;
    }

    public static void setFailMessages(MessageSourceAccessor failMessages) {
        WcFailure.failMessages = failMessages;
    }

    @Override
    public int getResultCode() {
        return resultCode;
    }

    @Override
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String getResultMsg() {
        return failMessages.getMessage(this.name(), getArgs(), this.name());
    }

    @Override
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Override
    public Object[] getArgs() {
        return args;
    }

    @Override
    public WcFailure setArgs(Object[] args) {
        this.args = args;
        return this;
    }

    @Override
    public String toString() {
        return this.name();
    }



}
