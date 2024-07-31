package com.senseplay.sdk.model.device;

import android.content.Context;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.client.MClientHelper;
import com.senseplay.mframe.client.MReqListener;
import com.senseplay.mframe.json.MJson;
import com.senseplay.mframe.json.MJsonData;
import com.senseplay.sdk.SPManager;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.client.SPHttpUrls;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class DeviceHttp {
    private MClientHelper helper;

    public DeviceHttp(Context context) {
        this.helper = MClientHelper.getInstance(context);
    }

    public void bindDevice(String str, String str2, String str3, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", SPManager.getClientId());
        hashMap.put("access_token", str2);
        hashMap.put("sn", str);
        hashMap.put("verify_code", str3);
        this.helper.request(SPHttpUrls.Device.BindDevice, 1, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.device.DeviceHttp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str4) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(MJsonData.getJson(str4), CallBackMsg.class);
            }
        });
    }

    public void unBindDevice(String str, String str2, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", SPManager.getClientId());
        hashMap.put("access_token", str2);
        hashMap.put("sn", str);
        this.helper.request(SPHttpUrls.Device.UnBindDevice, 3, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.device.DeviceHttp.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str3) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(MJsonData.getJson(str3), CallBackMsg.class);
            }
        });
    }
}
