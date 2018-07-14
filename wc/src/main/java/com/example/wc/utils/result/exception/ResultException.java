package com.example.wc.utils.result.exception;

import com.example.wc.utils.result.IResult;

public class ResultException extends RuntimeException {
    private int errorCode;
    private String errorMsg;
    private IResult result;

    public ResultException(IResult result) {
        super(result.toString());
        this.result = result;
        this.errorCode = result.getResultCode();
        this.errorMsg = result.getResultMsg();
    }

    public IResult getResult() {
        return result;
    }

    public int getErrorCode() {
        return errorCode;
    }


    public String getErrorMsg() {
        return errorMsg;
    }


    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
