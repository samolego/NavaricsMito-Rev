package com.senseplay.sdk.model.location;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.client.MClientHelper;
import com.senseplay.mframe.client.MReqListener;
import com.senseplay.mframe.json.MJson;
import com.senseplay.mframe.json.MJsonData;
import com.senseplay.sdk.client.SPHttpUrls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class LocationHttp {
    private MClientHelper helper;

    public LocationHttp(Context context) {
        this.helper = MClientHelper.getInstance(context);
    }

    public void getNearbyUser(String str, String str2, MCallBack<List<LocationUser>> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", str);
        hashMap.put("token", str2);
        this.helper.request(SPHttpUrls.Location.GetNearbyUser, 0, hashMap, new MReqListener<List<LocationUser>>(mCallBack) { // from class: com.senseplay.sdk.model.location.LocationHttp.1
            @Override // com.senseplay.mframe.client.MReqListener
            public List<LocationUser> onResponse(String str3) throws Exception {
                return MJson.jsonToList(MJsonData.getJson(str3), new TypeToken<ArrayList<LocationUser>>() { // from class: com.senseplay.sdk.model.location.LocationHttp.1.1
                }.getType());
            }
        });
    }

    public void getNearbyUserJson(String str, String str2, MCallBack<String> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", str);
        hashMap.put("token", str2);
        this.helper.request(SPHttpUrls.Location.GetNearbyUser, 0, hashMap, new MReqListener<String>(mCallBack) { // from class: com.senseplay.sdk.model.location.LocationHttp.2
            @Override // com.senseplay.mframe.client.MReqListener
            public String onResponse(String str3) throws Exception {
                return MJsonData.getJson(str3);
            }
        });
    }
}
