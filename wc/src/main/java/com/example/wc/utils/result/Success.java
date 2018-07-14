package com.example.wc.utils.result;


public enum Success implements IResult {
    SUCCESS;

    int resultCode;
    String resultMsg;
    Object[] args;


    Success() {
        this.resultCode = 0;
    }

    Success(int resultCode) {
        this(resultCode, null);
    }

    Success(int resultCode, String resultMsg) {
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
    public Success setArgs(Object[] args) {
        this.args = args;
        return this;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
