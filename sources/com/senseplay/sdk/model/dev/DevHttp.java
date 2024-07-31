package com.senseplay.sdk.model.dev;

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
public class DevHttp {
    private MClientHelper helper;

    public DevHttp(Context context) {
        this.helper = MClientHelper.getInstance(context);
    }

    public void getBind(String str, MCallBack<SnBind> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sn", str);
        this.helper.request(SPHttpUrls.Super.GetBind, 0, hashMap, new MReqListener<SnBind>(mCallBack) { // from class: com.senseplay.sdk.model.dev.DevHttp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public SnBind onResponse(String str2) throws Exception {
                return (SnBind) MJson.jsonToObj(MJsonData.getJsonString(str2), SnBind.class);
            }
        });
    }

    public void unBind(String str, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sn", str);
        this.helper.request(SPHttpUrls.Super.UnBind, 1, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.dev.DevHttp.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str2) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(MJsonData.getJson(str2), CallBackMsg.class);
            }
        });
    }
}
