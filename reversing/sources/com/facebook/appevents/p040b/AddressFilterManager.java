package com.facebook.appevents.p040b;

import com.facebook.FacebookSdk;
import com.facebook.appevents.p042ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.appevents.b.a */
/* loaded from: classes.dex */
public final class AddressFilterManager {

    /* renamed from: a */
    private static boolean f1552a = false;

    /* renamed from: b */
    private static boolean f1553b = false;

    /* renamed from: a */
    public static void m11248a() {
        f1552a = true;
        f1553b = FetchedAppGateKeepersManager.m10702a("FBSDKFeatureAddressDetectionSample", FacebookSdk.m10865l(), false);
    }

    /* renamed from: a */
    public static void m11246a(Map<String, String> map) {
        if (!f1552a || map.size() == 0) {
            return;
        }
        try {
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            JSONObject jSONObject = new JSONObject();
            for (String str : arrayList) {
                String str2 = map.get(str);
                if (m11247a(str2)) {
                    map.remove(str);
                    if (!f1553b) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                }
            }
            if (jSONObject.length() != 0) {
                map.put("_onDeviceParams", jSONObject.toString());
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static boolean m11247a(String str) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        String m10933a = ModelManager.m10933a("DATA_DETECTION_ADDRESS", fArr, str);
        return m10933a != null && m10933a.equals("SHOULD_FILTER");
    }
}
