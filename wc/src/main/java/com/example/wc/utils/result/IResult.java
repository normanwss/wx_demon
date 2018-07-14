package com.example.wc.utils.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.context.support.MessageSourceAccessor;

@JsonSerialize(using = ResultSerializer.class)
public interface IResult {

    MessageSourceAccessor failMessages = FailureResultMessageSource.getAccessor();

    MessageSourceAccessor successMessages = SuccResultMessageSource.getAccessor();


    int getResultCode();

    void setResultCode(int resultCode);

    String getResultMsg();

    void setResultMsg(String resultMsg);

    Object[] getArgs();

    IResult setArgs(Object[] args);


}
