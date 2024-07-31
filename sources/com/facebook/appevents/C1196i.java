package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.p040b.RestrictiveDataManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.appevents.i */
/* loaded from: classes.dex */
public class SessionEventsState {

    /* renamed from: c */
    private int f1713c;

    /* renamed from: d */
    private AttributionIdentifiers f1714d;

    /* renamed from: e */
    private String f1715e;

    /* renamed from: a */
    private List<AppEvent> f1711a = new ArrayList();

    /* renamed from: b */
    private List<AppEvent> f1712b = new ArrayList();

    /* renamed from: f */
    private final int f1716f = 1000;

    public SessionEventsState(AttributionIdentifiers attributionIdentifiers, String str) {
        this.f1714d = attributionIdentifiers;
        this.f1715e = str;
    }

    /* renamed from: a */
    public synchronized void m11047a(AppEvent appEvent) {
        if (this.f1711a.size() + this.f1712b.size() >= 1000) {
            this.f1713c++;
        } else {
            this.f1711a.add(appEvent);
        }
    }

    /* renamed from: a */
    public synchronized int m11050a() {
        return this.f1711a.size();
    }

    /* renamed from: a */
    public synchronized void m11046a(boolean z) {
        if (z) {
            this.f1711a.addAll(this.f1712b);
        }
        this.f1712b.clear();
        this.f1713c = 0;
    }

    /* renamed from: a */
    public int m11048a(GraphRequest graphRequest, Context context, boolean z, boolean z2) {
        synchronized (this) {
            int i = this.f1713c;
            RestrictiveDataManager.m11242a(this.f1712b);
            this.f1712b.addAll(this.f1711a);
            this.f1711a.clear();
            JSONArray jSONArray = new JSONArray();
            for (AppEvent appEvent : this.f1712b) {
                if (appEvent.isChecksumValid()) {
                    if (z || !appEvent.getIsImplicit()) {
                        jSONArray.put(appEvent.getJSONObject());
                    }
                } else {
                    Utility.m10505b("Event with invalid checksum: %s", appEvent.toString());
                }
            }
            if (jSONArray.length() == 0) {
                return 0;
            }
            m11049a(graphRequest, context, i, jSONArray, z2);
            return jSONArray.length();
        }
    }

    /* renamed from: b */
    public synchronized List<AppEvent> m11045b() {
        List<AppEvent> list;
        list = this.f1711a;
        this.f1711a = new ArrayList();
        return list;
    }

    /* renamed from: a */
    private void m11049a(GraphRequest graphRequest, Context context, int i, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject;
        try {
            jSONObject = AppEventsLoggerUtility.m11044a(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.f1714d, this.f1715e, z, context);
            if (this.f1713c > 0) {
                jSONObject.put("num_skipped_events", i);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        graphRequest.m11375a(jSONObject);
        Bundle m11358e = graphRequest.m11358e();
        if (m11358e == null) {
            m11358e = new Bundle();
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2 != null) {
            m11358e.putString("custom_events", jSONArray2);
            graphRequest.m11385a((Object) jSONArray2);
        }
        graphRequest.m11397a(m11358e);
    }
}
