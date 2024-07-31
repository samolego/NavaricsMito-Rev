package com.facebook.appevents.p039a;

import android.support.annotation.RestrictTo;
import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.a.c */
/* loaded from: classes.dex */
final class MetadataRule {

    /* renamed from: a */
    private static final String f1538a = MetadataRule.class.getCanonicalName();

    /* renamed from: b */
    private static List<MetadataRule> f1539b = new ArrayList();

    /* renamed from: c */
    private String f1540c;

    /* renamed from: d */
    private List<String> f1541d;

    /* renamed from: e */
    private String f1542e;

    private MetadataRule(String str, List<String> list, String str2) {
        this.f1540c = str;
        this.f1541d = list;
        this.f1542e = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static List<MetadataRule> m11268a() {
        return new ArrayList(f1539b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public String m11265b() {
        return this.f1540c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public List<String> m11264c() {
        return new ArrayList(this.f1541d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public String m11263d() {
        return this.f1542e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11267a(String str) {
        try {
            f1539b.clear();
            m11266a(new JSONObject(str));
            m11262e();
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    private static void m11266a(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.get(next) instanceof JSONObject) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2.has("k") && jSONObject2.has("v") && !jSONObject2.getString("k").isEmpty() && !jSONObject2.getString("v").isEmpty()) {
                        f1539b.add(new MetadataRule(next, Arrays.asList(jSONObject2.getString("k").split(",")), jSONObject2.getString("v")));
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    /* renamed from: e */
    private static void m11262e() {
        Map<String, String> m10954c = UserDataStore.m10954c();
        if (m10954c.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (MetadataRule metadataRule : f1539b) {
            hashSet.add(metadataRule.m11265b());
        }
        ArrayList arrayList = new ArrayList();
        for (String str : m10954c.keySet()) {
            if (!hashSet.contains(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        UserDataStore.m10958a(arrayList);
    }
}
