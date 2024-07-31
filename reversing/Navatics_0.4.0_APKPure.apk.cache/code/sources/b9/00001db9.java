package com.senseplay.sdk.model.account;

import com.senseplay.sdk.client.SPHttpUrls;

/* loaded from: classes2.dex */
public class AccountData {
    public static final String AuthorizeInfo = "AuthorizeInfo";
    public static final int RequestCode = 1001;
    public static final int ResultCode = 1002;
    public static String RegPhoneUrl = SPHttpUrls.URL_ACCOUNT + "sdk/reg_phone?client_id=%s&from=SDK&bv=1";
    public static String RegEmailUrl = SPHttpUrls.URL_ACCOUNT + "sdk/reg_email?client_id=%s&from=SDK&bv=1";
    public static String ModifyUrl = SPHttpUrls.URL_ACCOUNT + "m/sensego_profile?client_id=%s&access_token=%s&bv=1";
    public static String AuthorizeUrl = SPHttpUrls.URL_AUTH + "oauth/authorize?client_id=%s&redirect_uri=%s&state=sense";
    public static String LoginSuccess = "login_success?code=";
    public static String Back_Account = "bv_account.com";
    public static String Back_Reg = "bv_reg.com";
    public static String Back_Logout = "tc.com";
    public static String Back = "back.com";
}