package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.RestrictTo;
import android.util.Log;
import android.util.Patterns;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.j */
/* loaded from: classes.dex */
public class UserDataStore {

    /* renamed from: a */
    private static final String f1767a = "j";

    /* renamed from: b */
    private static SharedPreferences f1768b;

    /* renamed from: c */
    private static AtomicBoolean f1769c = new AtomicBoolean(false);

    /* renamed from: d */
    private static final ConcurrentHashMap<String, String> f1770d = new ConcurrentHashMap<>();

    /* renamed from: e */
    private static final ConcurrentHashMap<String, String> f1771e = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m10960a() {
        if (f1769c.get()) {
            return;
        }
        m10950g();
    }

    /* renamed from: a */
    private static void m10959a(final String str, final String str2) {
        FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.appevents.j.1
            @Override // java.lang.Runnable
            public void run() {
                if (!UserDataStore.f1769c.get()) {
                    UserDataStore.m10950g();
                }
                UserDataStore.f1768b.edit().putString(str, str2).apply();
            }
        });
    }

    /* renamed from: a */
    public static void m10958a(List<String> list) {
        if (!f1769c.get()) {
            m10950g();
        }
        for (String str : list) {
            if (f1771e.containsKey(str)) {
                f1771e.remove(str);
            }
        }
        m10959a("com.facebook.appevents.UserDataStore.internalUserData", Utility.m10518a(f1771e));
    }

    /* renamed from: b */
    public static String m10956b() {
        if (!f1769c.get()) {
            m10950g();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(f1770d);
        hashMap.putAll(f1771e);
        return Utility.m10518a(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static synchronized void m10950g() {
        synchronized (UserDataStore.class) {
            if (f1769c.get()) {
                return;
            }
            f1768b = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.m10869h());
            String string = f1768b.getString("com.facebook.appevents.UserDataStore.userData", "");
            String string2 = f1768b.getString("com.facebook.appevents.UserDataStore.internalUserData", "");
            f1770d.putAll(Utility.m10486e(string));
            f1771e.putAll(Utility.m10486e(string2));
            f1769c.set(true);
        }
    }

    /* renamed from: c */
    public static Map<String, String> m10954c() {
        if (!f1769c.get()) {
            m10950g();
        }
        return new HashMap(f1771e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m10957a(Map<String, String> map) {
        String[] strArr;
        if (!f1769c.get()) {
            m10950g();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String m10497c = Utility.m10497c(m10955b(key, map.get(key).trim()));
            if (f1771e.containsKey(key)) {
                String str = f1771e.get(key);
                if (str != null) {
                    strArr = str.split(",");
                } else {
                    strArr = new String[0];
                }
                HashSet hashSet = new HashSet(Arrays.asList(strArr));
                if (hashSet.contains(m10497c)) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                if (strArr.length == 0) {
                    sb.append(m10497c);
                } else if (strArr.length < 5) {
                    sb.append(str);
                    sb.append(",");
                    sb.append(m10497c);
                } else {
                    for (int i = 1; i < 5; i++) {
                        sb.append(strArr[i]);
                        sb.append(",");
                    }
                    sb.append(m10497c);
                    hashSet.remove(strArr[0]);
                }
                f1771e.put(key, sb.toString());
            } else {
                f1771e.put(key, m10497c);
            }
        }
        m10959a("com.facebook.appevents.UserDataStore.internalUserData", Utility.m10518a(f1771e));
    }

    /* renamed from: b */
    private static String m10955b(String str, String str2) {
        String lowerCase = str2.trim().toLowerCase();
        if ("em".equals(str)) {
            if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                return lowerCase;
            }
            Log.e(f1767a, "Setting email failure: this is not a valid email address");
            return "";
        } else if ("ph".equals(str)) {
            return lowerCase.replaceAll("[^0-9]", "");
        } else {
            if ("ge".equals(str)) {
                String substring = lowerCase.length() > 0 ? lowerCase.substring(0, 1) : "";
                if ("f".equals(substring) || "m".equals(substring)) {
                    return substring;
                }
                Log.e(f1767a, "Setting gender failure: the supported value for gender is f or m");
                return "";
            }
            return lowerCase;
        }
    }
}
