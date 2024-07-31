package com.senseplay.sdk.model.keymap;

import android.content.Context;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.client.MClientHelper;
import com.senseplay.mframe.client.MReqListener;
import com.senseplay.mframe.json.MJsonData;
import com.senseplay.sdk.client.SPHttpUrls;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class KeyMapFileHttp {
    private MClientHelper helper;

    public KeyMapFileHttp(Context context) {
        this.helper = MClientHelper.getInstance(context);
    }

    public void getAllFile(String str, String str2, String str3, MCallBack<String> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", str);
        hashMap.put("access_token", str2);
        hashMap.put("rc", str3);
        this.helper.request(SPHttpUrls.KeyMap.GetKeyMap, 0, hashMap, new MReqListener<String>(mCallBack) { // from class: com.senseplay.sdk.model.keymap.KeyMapFileHttp.1
            @Override // com.senseplay.mframe.client.MReqListener
            public String onResponse(String str4) throws Exception {
                return MJsonData.getJsonString(str4);
            }
        });
    }

    public void getFileJson(String str, MCallBack<String> mCallBack) {
        this.helper.request(str, 0, null, new MReqListener<String>(mCallBack) { // from class: com.senseplay.sdk.model.keymap.KeyMapFileHttp.2
            @Override // com.senseplay.mframe.client.MReqListener
            public String onResponse(String str2) throws Exception {
                return str2;
            }
        });
    }
}
