package com.senseplay.sdk.model.account;

import android.content.Context;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.client.MClientHelper;
import com.senseplay.mframe.client.MReqListener;
import com.senseplay.mframe.json.MJson;
import com.senseplay.mframe.json.MJsonData;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.client.SPHttpUrls;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class AuthHttp {
    private MClientHelper helper;

    public AuthHttp(Context context) {
        this.helper = MClientHelper.getInstance(context);
    }

    public void login(String str, String str2, String str3, String str4, String str5, MCallBack<AuthorizeBean> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", str);
        hashMap.put("client_secret", str2);
        hashMap.put("username", str3);
        hashMap.put("password", str4);
        hashMap.put("reg_source", str5);
        this.helper.request(SPHttpUrls.Auth.Login, 1, hashMap, new MReqListener<AuthorizeBean>(mCallBack) { // from class: com.senseplay.sdk.model.account.AuthHttp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public AuthorizeBean onResponse(String str6) throws Exception {
                return (AuthorizeBean) MJson.jsonToObj(MJsonData.getJsonString(str6), AuthorizeBean.class);
            }
        });
    }

    public void registEmail(String str, String str2, String str3, String str4, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("useremail", str);
        hashMap.put("authcode", str2);
        hashMap.put("pwd", str3);
        hashMap.put("repeatpwd", str4);
        this.helper.request(SPHttpUrls.Auth.RegEmail, 1, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.account.AuthHttp.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str5) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(MJsonData.getJson(str5), CallBackMsg.class);
            }
        });
    }

    public void sendCode(String str, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("useremail", str);
        this.helper.request(SPHttpUrls.Auth.SendCode, 1, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.account.AuthHttp.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str2) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(MJsonData.getJson(str2), CallBackMsg.class);
            }
        });
    }
}
