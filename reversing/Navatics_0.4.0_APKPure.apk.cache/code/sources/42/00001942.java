package com.navatics.app.framework.user;

/* loaded from: classes.dex */
public class Result<T> {
    public static final int ERROR_CODE_KEY_1001 = 1001;
    public static final int ERROR_CODE_KEY_1002 = 1002;
    public static final int ERROR_CODE_KEY_1003 = 1003;
    public static final int ERROR_CODE_KEY_1004 = 1004;
    public static final int ERROR_CODE_KEY_1005 = 1005;
    public static final int ERROR_CODE_KEY_1006 = 1006;
    public static final int ERROR_CODE_KEY_1007 = 1007;
    public static final int ERROR_CODE_KEY_1008 = 1008;
    public static final int ERROR_CODE_KEY_1009 = 1009;
    public static final int ERROR_CODE_KEY_1010 = 1010;
    public static final int ERROR_CODE_KEY_1011 = 1011;
    public static final int ERROR_CODE_KEY_1012 = 1012;
    public static final int ERROR_CODE_KEY_1013 = 1013;
    public static final int ERROR_CODE_KEY_2001 = 2001;
    public static final int NO_USR_FOUND = -1;
    public static final int SUCCESS = 0;
    int code;
    T data;
    String msg;

    public Result() {
    }

    public Result(int i, String str, T t) {
        this.code = i;
        this.msg = str;
        this.data = t;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setData(T t) {
        this.data = t;
    }

    public String toString() {
        return "Result{code=" + this.code + ", msg='" + this.msg + ", data= " + this.data + "'}";
    }
}