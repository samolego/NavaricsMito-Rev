package com.navatics.app.framework.user;

/* loaded from: classes.dex */
public class UserServiceException extends RuntimeException {
    int code;
    String msg;

    public UserServiceException(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public UserServiceException(String str, int i, String str2) {
        super(str);
        this.code = i;
        this.msg = str2;
    }

    public UserServiceException(String str, Throwable th, int i, String str2) {
        super(str, th);
        this.code = i;
        this.msg = str2;
    }

    public UserServiceException(Throwable th, int i, String str) {
        super(th);
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
