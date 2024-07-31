package com.senseplay.mframe.client;

/* loaded from: classes2.dex */
public abstract class MReqListener<T> {
    private MCallBack<T> callBack;

    public abstract T onResponse(String str) throws Exception;

    public MReqListener(MCallBack<T> mCallBack) {
        this.callBack = mCallBack;
    }

    public MCallBack<T> getCallBack() {
        return this.callBack;
    }

    public T onResponse_(String str) throws Exception {
        return onResponse(str);
    }
}