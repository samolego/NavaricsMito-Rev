package com.senseplay.sdk.model.ota;

import android.content.Context;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.client.MClientHelper;
import com.senseplay.mframe.client.MReqListener;
import com.senseplay.mframe.json.MJson;
import com.senseplay.sdk.client.SPHttpUrls;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public class OtaHttp {
    private MClientHelper helper;

    public OtaHttp(Context context) {
        this.helper = MClientHelper.getInstance(context);
    }

    public void checkVersion(String str, String str2, String str3, String str4, String str5, MCallBack<VersionInfo> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("product_code", str);
        hashMap.put("version", str2);
        hashMap.put("sn", str3);
        hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, str4);
        hashMap.put("country", str5);
        this.helper.request(SPHttpUrls.Ota.checkVersion, 0, hashMap, new MReqListener<VersionInfo>(mCallBack) { // from class: com.senseplay.sdk.model.ota.OtaHttp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.senseplay.mframe.client.MReqListener
            public VersionInfo onResponse(String str6) throws Exception {
                return (VersionInfo) MJson.jsonToObj(str6, VersionInfo.class);
            }
        });
    }
}
