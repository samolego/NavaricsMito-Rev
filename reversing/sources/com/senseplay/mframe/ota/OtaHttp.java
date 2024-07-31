package com.senseplay.mframe.ota;

import android.content.Context;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.client.MClientHelper;
import com.senseplay.mframe.client.MReqListener;
import com.senseplay.mframe.config.MHttpUrls;
import com.senseplay.mframe.json.MJson;
import com.senseplay.mframe.json.MJsonData;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public class OtaHttp {
    private MClientHelper helper;

    public OtaHttp(Context context) {
        this.helper = MClientHelper.getInstance(context);
    }

    public void checkVersion(String str, String str2, String str3, String str4, String str5, MCallBack<OtaInfo> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("product", str3);
        hashMap.put("version", str3);
        hashMap.put("sn", str3);
        hashMap.put("country", str3);
        hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, str3);
        this.helper.request(MHttpUrls.Ota.GetKeyMap, 1, hashMap, new MReqListener<OtaInfo>(mCallBack) { // from class: com.senseplay.mframe.ota.OtaHttp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public OtaInfo onResponse(String str6) throws Exception {
                return (OtaInfo) MJson.jsonToObj(MJsonData.getJson(str6), OtaInfo.class);
            }
        });
    }
}
