package com.senseplay.sdk.model.account;

import android.content.Context;
import com.google.gson.JsonObject;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.client.MClientHelper;
import com.senseplay.mframe.client.MReqListener;
import com.senseplay.mframe.json.MJson;
import com.senseplay.mframe.json.MJsonData;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.client.SPHttpUrls;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class AccountHttp {
    private MClientHelper helper;

    public AccountHttp(Context context) {
        this.helper = MClientHelper.getInstance(context);
    }

    public void login(String str, String str2, String str3, String str4, String str5, MCallBack<AuthorizeBean> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", str);
        hashMap.put("client_secret", str2);
        hashMap.put("username", str4);
        hashMap.put("openid", str3);
        hashMap.put("type_name", str5);
        this.helper.request(SPHttpUrls.Account.Login, 1, hashMap, new MReqListener<AuthorizeBean>(mCallBack) { // from class: com.senseplay.sdk.model.account.AccountHttp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public AuthorizeBean onResponse(String str6) throws Exception {
                return (AuthorizeBean) MJson.jsonToObj(str6, AuthorizeBean.class);
            }
        });
    }

    public void refreshToken(String str, String str2, String str3, MCallBack<AuthorizeBean> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", str);
        hashMap.put("client_secret", str2);
        hashMap.put("refresh_token", str3);
        this.helper.request(SPHttpUrls.Account.RefreshToken, 1, hashMap, new MReqListener<AuthorizeBean>(mCallBack) { // from class: com.senseplay.sdk.model.account.AccountHttp.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public AuthorizeBean onResponse(String str4) throws Exception {
                return (AuthorizeBean) MJson.jsonToObj(str4, AuthorizeBean.class);
            }
        });
    }

    public void getAccountByUrl(String str, MCallBack<AuthorizeBean> mCallBack) {
        this.helper.request(str, 0, null, new MReqListener<AuthorizeBean>(mCallBack) { // from class: com.senseplay.sdk.model.account.AccountHttp.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public AuthorizeBean onResponse(String str2) throws Exception {
                return (AuthorizeBean) MJson.jsonToObj(str2, AuthorizeBean.class);
            }
        });
    }

    public void getAccountInfo(String str, String str2, String str3, MCallBack<SPAccountInfo> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", str);
        hashMap.put("openid", str2);
        hashMap.put("access_token", str3);
        this.helper.request(SPHttpUrls.Account.GetAccountInfo, 1, hashMap, new MReqListener<SPAccountInfo>(mCallBack) { // from class: com.senseplay.sdk.model.account.AccountHttp.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public SPAccountInfo onResponse(String str4) throws Exception {
                return (SPAccountInfo) MJson.jsonToObj(MJsonData.getJson(str4), SPAccountInfo.class);
            }
        });
    }

    public void logout(String str, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("access_token", str);
        this.helper.request(SPHttpUrls.Account.Logout, 0, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.account.AccountHttp.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str2) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(str2, CallBackMsg.class);
            }
        });
    }

    public void getOpenid(String str, MCallBack<String> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("access_token", str);
        this.helper.request(SPHttpUrls.Account.GetOpenId, 1, hashMap, new MReqListener<String>(mCallBack) { // from class: com.senseplay.sdk.model.account.AccountHttp.6
            @Override // com.senseplay.mframe.client.MReqListener
            public String onResponse(String str2) throws Exception {
                JsonObject jsonObj = MJsonData.getJsonObj(str2);
                return jsonObj != null ? jsonObj.get("openid").toString() : "";
            }
        });
    }
}
