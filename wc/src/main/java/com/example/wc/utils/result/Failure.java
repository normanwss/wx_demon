package com.example.wc.utils.result;


public enum Failure implements IResult {
    ERROR(-1),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500),
    UNAUTHORIZED(401),
    BAD_REQUEST(400),
    METHOD_NOT_ALLOWED(405),
    PARAMS_NOT_VALID(400);

    int resultCode;
    String resultMsg;
    Object[] args;

    Failure() {
        this(-1, null);
    }

    Failure(int resultCode) {
        this(resultCode, null);
    }

    Failure(int resultCode, String resultMsg) {
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
    public Failure setArgs(Object[] args) {
        this.args = args;
        return this;
    }

    @Override
    public String toString() {
        return this.name();
    }


}
