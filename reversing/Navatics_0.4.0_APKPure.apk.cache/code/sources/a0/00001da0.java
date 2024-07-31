package com.senseplay.sdk.client;

import com.senseplay.sdk.config.SPVersion;

/* loaded from: classes2.dex */
public class SPHttpUrls {
    private static final String URL = SPVersion.getUrl();
    public static final String URL_AUTH = URL + "auth.senseplay.cn/";
    public static final String URL_ACCOUNT = URL + "account.senseplay.cn/";
    private static final String URL_CLOUD = URL + "cloud.senseplay.cn/";
    private static final String URL_H5 = URL + "h5.racing.senseplay.cn/";
    private static final String URL_A = URL + "a.senseplay.cn/";
    public static final String URL_MSG = URL + "msg.senseplay.cn:3001/";

    /* loaded from: classes2.dex */
    public static class Account {
        public static final String Login = SPHttpUrls.URL_ACCOUNT + "third_callback/auth";
        public static final String RefreshToken = SPHttpUrls.URL_AUTH + "oauth/get_refresh_token";
        public static final String GetOpenId = SPHttpUrls.URL_AUTH + "oauth/get_openid";
        public static final String GetAccountInfo = SPHttpUrls.URL_AUTH + "oauth/get_userinfo";
        public static final String Logout = SPHttpUrls.URL_AUTH + "oauth/loginout";
    }

    /* loaded from: classes2.dex */
    public static class Auth {
        public static final String Login = SPHttpUrls.URL_ACCOUNT + "api/sdk/auth";
        public static final String RegEmail = SPHttpUrls.URL_ACCOUNT + "api/sdk/reg_email";
        public static final String SendCode = SPHttpUrls.URL_ACCOUNT + "api/sdk/sendcode";
    }

    /* loaded from: classes2.dex */
    public static class Cloud {
        public static final String GetDevIno = SPHttpUrls.URL_CLOUD + "api/sn/devices/{sn}";
        public static final String GetAccessCode = SPHttpUrls.URL_CLOUD + "api/sn/devices/{sn}";
        public static final String UptDevIno = SPHttpUrls.URL_CLOUD + "api/sn/devices/{sn}/info";
        public static final String GetBindList = SPHttpUrls.URL_CLOUD + "api/sn/devices";
    }

    /* loaded from: classes2.dex */
    public static class Device {
        public static final String BindDevice = SPHttpUrls.URL_CLOUD + "api/sn/devices";
        public static final String UnBindDevice = SPHttpUrls.URL_CLOUD + "api/sn/devices";
    }

    /* loaded from: classes2.dex */
    public static class Find {
        public static final String GetFindSetting = SPHttpUrls.URL_CLOUD + "mycloud/apifactility/setting_view";
        public static final String FindSetting = SPHttpUrls.URL_CLOUD + "mycloud/apifactility/find_setting";
        public static final String LoseSetting = SPHttpUrls.URL_CLOUD + "mycloud/apifactility/lose_setting";
        public static final String SetPhone = SPHttpUrls.URL_CLOUD + "mycloud/apifactility/inform_phone";
        public static final String SetContent = SPHttpUrls.URL_CLOUD + "mycloud/apifactility/content";
    }

    /* loaded from: classes2.dex */
    public static class KeyMap {
        public static final String GetKeyMap = SPHttpUrls.URL_CLOUD + "keymap/json";
    }

    /* loaded from: classes2.dex */
    public static class Location {
        public static final String GetNearbyUser = SPHttpUrls.URL_H5 + "api/look_around";
    }

    /* loaded from: classes2.dex */
    public static class Ota {
        public static final String checkVersion = SPHttpUrls.URL_CLOUD + "ota/check_ver";
    }

    /* loaded from: classes2.dex */
    public static class Super {
        public static final String GetBind = SPHttpUrls.URL_CLOUD + "api/super/binds";
        public static final String UnBind = SPHttpUrls.URL_CLOUD + "api/super/devices";
    }
}