package com.senseplay.sdk;

import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.model.account.AuthHttp;
import com.senseplay.sdk.model.account.AuthorizeBean;

/* loaded from: classes2.dex */
public class SPAuth {
    private static SPAuth spAuth;
    private AuthHttp authHttp = new AuthHttp(SPManager.getContent());

    public static SPAuth getInstance() {
        if (spAuth == null) {
            synchronized (SPAuth.class) {
                if (spAuth == null) {
                    spAuth = new SPAuth();
                }
            }
        }
        return spAuth;
    }

    private SPAuth() {
    }

    public void login(String str, String str2, String str3, MCallBack<AuthorizeBean> mCallBack) {
        this.authHttp.login(SPManager.getClientId(), SPManager.getClientSecret(), str, str2, str3, mCallBack);
    }

    public void registEmail(String str, String str2, String str3, String str4, MCallBack<CallBackMsg> mCallBack) {
        this.authHttp.registEmail(str, str2, str3, str4, mCallBack);
    }

    public void sendCode(String str, MCallBack<CallBackMsg> mCallBack) {
        this.authHttp.sendCode(str, mCallBack);
    }
}
