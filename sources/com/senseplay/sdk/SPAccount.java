package com.senseplay.sdk;

import android.content.Context;
import android.content.Intent;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.activity.SPWebActivity;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.constant.SPWebConstant;
import com.senseplay.sdk.model.account.AccountData;
import com.senseplay.sdk.model.account.AccountHttp;
import com.senseplay.sdk.model.account.AuthorizeBean;
import com.senseplay.sdk.model.account.SPAccountInfo;

/* loaded from: classes2.dex */
public class SPAccount {
    public static final int BIND_TYPE_ALL = 100;
    public static final int BIND_TYPE_DEVICE = 2;
    public static final int BIND_TYPE_RC = 1;
    public static MCallBack<Boolean> logoutCallBack;
    private static Context mContext;
    private static SPAccount spAccount;
    public static MCallBack<AuthorizeBean> webCallBack;
    private AccountHttp accountHttp;

    public static SPAccount getInstance() {
        if (spAccount == null) {
            synchronized (SPAccount.class) {
                if (spAccount == null) {
                    spAccount = new SPAccount();
                }
            }
        }
        return spAccount;
    }

    private SPAccount() {
        mContext = SPManager.getContent();
        this.accountHttp = new AccountHttp(SPManager.getContent());
    }

    public void login(String str, String str2, String str3, String str4, String str5, MCallBack<AuthorizeBean> mCallBack) {
        this.accountHttp.login(str, str2, str3, str4, str5, mCallBack);
    }

    public void refreshToken(String str, String str2, String str3, MCallBack<AuthorizeBean> mCallBack) {
        this.accountHttp.refreshToken(str, str2, str3, mCallBack);
    }

    public void loginWeb(String str, MCallBack<AuthorizeBean> mCallBack) {
        webCallBack = mCallBack;
        Intent intent = new Intent();
        intent.setClass(mContext, SPWebActivity.class);
        intent.putExtra("url", String.format(AccountData.AuthorizeUrl, SPManager.getClientId(), str));
        mContext.startActivity(intent);
    }

    public void registPhoneWeb(MCallBack<AuthorizeBean> mCallBack) {
        webCallBack = mCallBack;
        Intent intent = new Intent();
        intent.setClass(mContext, SPWebActivity.class);
        intent.putExtra("url", String.format(AccountData.RegPhoneUrl, SPManager.getClientId()));
        mContext.startActivity(intent);
    }

    public void registEmailWeb(MCallBack<AuthorizeBean> mCallBack) {
        webCallBack = mCallBack;
        Intent intent = new Intent();
        intent.setClass(mContext, SPWebActivity.class);
        intent.putExtra("url", String.format(AccountData.RegEmailUrl, SPManager.getClientId()));
        mContext.startActivity(intent);
    }

    public void modifyAccount(String str, MCallBack<Boolean> mCallBack) {
        logoutCallBack = mCallBack;
        Intent intent = new Intent();
        intent.setClass(mContext, SPWebActivity.class);
        intent.putExtra("url", String.format(AccountData.ModifyUrl, SPManager.getClientId(), str));
        intent.putExtra(SPWebConstant.Permission, true);
        mContext.startActivity(intent);
    }

    public void getAccountInfo(String str, String str2, MCallBack<SPAccountInfo> mCallBack) {
        this.accountHttp.getAccountInfo(SPManager.getClientId(), str, str2, mCallBack);
    }

    public void logout(String str, MCallBack<CallBackMsg> mCallBack) {
        this.accountHttp.logout(str, mCallBack);
    }
}
