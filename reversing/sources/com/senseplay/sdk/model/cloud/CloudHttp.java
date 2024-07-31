package com.senseplay.sdk.model.cloud;

import android.content.Context;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.client.MClientHelper;
import com.senseplay.mframe.client.MReqListener;
import com.senseplay.mframe.json.MJson;
import com.senseplay.mframe.json.MJsonData;
import com.senseplay.sdk.SPManager;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.client.SPHttpUrls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudHttp {
    private MClientHelper helper;

    public CloudHttp(Context context) {
        this.helper = MClientHelper.getInstance(context);
    }

    public void getDevIno(String str, String str2, MCallBack<BindDevice> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", SPManager.getClientId());
        hashMap.put("access_token", str2);
        this.helper.request(SPHttpUrls.Cloud.GetDevIno.replace("{sn}", str), 0, hashMap, new MReqListener<BindDevice>(mCallBack) { // from class: com.senseplay.sdk.model.cloud.CloudHttp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public BindDevice onResponse(String str3) throws Exception {
                return (BindDevice) MJson.jsonToObj(MJsonData.getJsonString(str3), BindDevice.class);
            }
        });
    }

    public void uptDevIno(String str, String str2, String str3, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", SPManager.getClientId());
        hashMap.put("access_token", str3);
        hashMap.put("alias", str2);
        this.helper.request(SPHttpUrls.Cloud.UptDevIno.replace("{sn}", str), 2, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.cloud.CloudHttp.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str4) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(MJsonData.getJson(str4), CallBackMsg.class);
            }
        });
    }

    public void refreshAccCode(String str, String str2, MCallBack<String> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", SPManager.getClientId());
        hashMap.put("access_token", str2);
        this.helper.request(SPHttpUrls.Cloud.GetAccessCode.replace("{sn}", str), 2, hashMap, new MReqListener<String>(mCallBack) { // from class: com.senseplay.sdk.model.cloud.CloudHttp.3
            @Override // com.senseplay.mframe.client.MReqListener
            public String onResponse(String str3) throws Exception {
                JsonObject jsonObject = MJsonData.getJsonObject(str3);
                return jsonObject != null ? jsonObject.get("access_code").getAsString() : "";
            }
        });
    }

    public void getBindList(String str, String str2, MCallBack<List<BindDevice>> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", str);
        hashMap.put("access_token", str2);
        this.helper.request(SPHttpUrls.Cloud.GetBindList, 0, hashMap, new MReqListener<List<BindDevice>>(mCallBack) { // from class: com.senseplay.sdk.model.cloud.CloudHttp.4
            @Override // com.senseplay.mframe.client.MReqListener
            public List<BindDevice> onResponse(String str3) throws Exception {
                return MJson.jsonToList(MJsonData.getJsonString(str3), new TypeToken<ArrayList<BindDevice>>() { // from class: com.senseplay.sdk.model.cloud.CloudHttp.4.1
                }.getType());
            }
        });
    }
}
