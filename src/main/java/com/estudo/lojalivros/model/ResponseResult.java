package com.estudo.lojalivros.model;

public class ResponseResult {
    private boolean onSuccess;
    private Object data;

    public void error(Object object) {
        this.onSuccess = false;
        this.data = object;
    }

    public void success(Object object) {
        this.onSuccess = true;
        this.data = object;
    }

    public boolean isOnSuccess() {
        return onSuccess;
    }

    public Object getData() {
        return data;
    }
}