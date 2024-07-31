package com.senseplay.sdk.model.find;

import android.content.Context;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.client.MClientHelper;
import com.senseplay.mframe.client.MReqListener;
import com.senseplay.mframe.json.MJson;
import com.senseplay.mframe.json.MJsonData;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.client.SPHttpUrls;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public class FindHttp {
    private MClientHelper helper;

    public FindHttp(Context context) {
        this.helper = MClientHelper.getInstance(context);
    }

    public void getFindSetting(String str, int i, MCallBack<FindSetting> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sn", str);
        this.helper.request(SPHttpUrls.Find.GetFindSetting, 1, hashMap, new MReqListener<FindSetting>(mCallBack) { // from class: com.senseplay.sdk.model.find.FindHttp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public FindSetting onResponse(String str2) throws Exception {
                return (FindSetting) MJson.jsonToObj(MJsonData.getJson(str2), FindSetting.class);
            }
        });
    }

    public void findSetting(int i, String str, int i2, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("find_type", "" + i);
        hashMap.put("fid", str);
        hashMap.put(IjkMediaMeta.IJKM_KEY_TYPE, "" + i2);
        this.helper.request(SPHttpUrls.Find.FindSetting, 1, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.find.FindHttp.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str2) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(str2, CallBackMsg.class);
            }
        });
    }

    public void loseSetting(int i, String str, int i2, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("lose_type", "" + i);
        hashMap.put("fid", str);
        hashMap.put(IjkMediaMeta.IJKM_KEY_TYPE, "" + i2);
        this.helper.request(SPHttpUrls.Find.LoseSetting, 1, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.find.FindHttp.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str2) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(str2, CallBackMsg.class);
            }
        });
    }

    public void setPhone(String str, String str2, int i, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", str);
        hashMap.put("fid", str2);
        hashMap.put(IjkMediaMeta.IJKM_KEY_TYPE, "" + i);
        this.helper.request(SPHttpUrls.Find.SetPhone, 1, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.find.FindHttp.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str3) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(str3, CallBackMsg.class);
            }
        });
    }

    public void setContent(String str, String str2, int i, MCallBack<CallBackMsg> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("fid", str2);
        hashMap.put(IjkMediaMeta.IJKM_KEY_TYPE, "" + i);
        this.helper.request(SPHttpUrls.Find.SetContent, 1, hashMap, new MReqListener<CallBackMsg>(mCallBack) { // from class: com.senseplay.sdk.model.find.FindHttp.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public CallBackMsg onResponse(String str3) throws Exception {
                return (CallBackMsg) MJson.jsonToObj(str3, CallBackMsg.class);
            }
        });
    }
}
