package com.example.wc.entity.result;

import com.example.wc.utils.result.IResult;
import com.example.wc.utils.result.SuccResultMessageSource;
import org.springframework.context.support.MessageSourceAccessor;

public enum WcSuccess implements IResult {
    SUCCESS;

    int resultCode;
    String resultMsg;
    Object[] args;

    private static MessageSourceAccessor successMessages = SuccResultMessageSource.getAccessor();

    WcSuccess() {
        this.resultCode = 0;
    }

    WcSuccess(int resultCode) {
        this(resultCode, null);
    }

    WcSuccess(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
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
        return successMessages.getMessage(this.name(), getArgs(), this.name());
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
    public WcSuccess setArgs(Object[] args) {
        this.args = args;
        return this;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
