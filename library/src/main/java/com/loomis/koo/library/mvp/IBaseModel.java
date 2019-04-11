package com.loomis.koo.library.mvp;

import java.io.Serializable;

public class IBaseModel<T> implements Serializable {
    private int    errCode;
    private String errMsg;
    private T      result;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}