package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.facebook.FacebookSdk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.appevents.internal.g */
/* loaded from: classes.dex */
class InAppPurchaseEventManager {

    /* renamed from: a */
    private static final String f1751a = InAppPurchaseEventManager.class.getCanonicalName();

    /* renamed from: b */
    private static final HashMap<String, Method> f1752b = new HashMap<>();

    /* renamed from: c */
    private static final HashMap<String, Class<?>> f1753c = new HashMap<>();

    /* renamed from: d */
    private static final String f1754d = FacebookSdk.m10869h().getPackageName();

    /* renamed from: e */
    private static final SharedPreferences f1755e = FacebookSdk.m10869h().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);

    /* renamed from: f */
    private static final SharedPreferences f1756f = FacebookSdk.m10869h().getSharedPreferences("com.facebook.internal.PURCHASE", 0);

    InAppPurchaseEventManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public static Object m10995a(Context context, IBinder iBinder) {
        return m10991a(context, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{iBinder});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Map<String, String> m10990a(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> m10987a = m10987a(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!m10987a.containsKey(next)) {
                arrayList2.add(next);
            }
        }
        m10987a.putAll(m10983b(context, arrayList2, obj, z));
        return m10987a;
    }

    /* renamed from: b */
    private static Map<String, String> m10983b(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        HashMap hashMap = new HashMap();
        if (obj == null || arrayList.isEmpty()) {
            return hashMap;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        Object[] objArr = new Object[4];
        objArr[0] = 3;
        objArr[1] = f1754d;
        objArr[2] = z ? "subs" : "inapp";
        objArr[3] = bundle;
        Object m10991a = m10991a(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, objArr);
        if (m10991a != null) {
            Bundle bundle2 = (Bundle) m10991a;
            if (bundle2.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        hashMap.put(arrayList.get(i), stringArrayList.get(i));
                    }
                }
                m10986a(hashMap);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, String> m10987a(ArrayList<String> arrayList) {
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String string = f1755e.getString(next, null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(next, split[1]);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static void m10986a(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor edit = f1755e.edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            edit.putString(entry.getKey(), currentTimeMillis + ";" + entry.getValue());
        }
        edit.apply();
    }

    /* renamed from: a */
    private static Boolean m10993a(Context context, Object obj, String str) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        Object m10991a = m10991a(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{3, f1754d, str});
        if (m10991a != null && ((Integer) m10991a).intValue() == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static ArrayList<String> m10994a(Context context, Object obj) {
        return m10982b(m10984b(context, obj, "inapp"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static ArrayList<String> m10985b(Context context, Object obj) {
        return m10982b(m10984b(context, obj, "subs"));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c A[EDGE_INSN: B:21:0x005c->B:19:0x005c ?: BREAK  , SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<java.lang.String> m10984b(android.content.Context r9, java.lang.Object r10, java.lang.String r11) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r10 != 0) goto L8
            return r0
        L8:
            java.lang.Boolean r1 = m10993a(r9, r10, r11)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L5c
            r1 = 0
            r2 = 0
            r3 = r2
            r4 = 0
        L16:
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r5[r1] = r7
            r7 = 1
            java.lang.String r8 = com.facebook.appevents.internal.InAppPurchaseEventManager.f1754d
            r5[r7] = r8
            r7 = 2
            r5[r7] = r11
            r5[r6] = r3
            java.lang.String r3 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r6 = "getPurchases"
            java.lang.Object r3 = m10991a(r9, r3, r6, r10, r5)
            if (r3 == 0) goto L55
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r3.getInt(r5)
            if (r5 != 0) goto L55
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r3.getStringArrayList(r5)
            if (r5 == 0) goto L5c
            int r6 = r5.size()
            int r4 = r4 + r6
            r0.addAll(r5)
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r5)
            goto L56
        L55:
            r3 = r2
        L56:
            r5 = 30
            if (r4 >= r5) goto L5c
            if (r3 != 0) goto L16
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.InAppPurchaseEventManager.m10984b(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m10988a(String str) {
        try {
            String optString = new JSONObject(str).optString("freeTrialPeriod");
            if (optString != null) {
                return !optString.isEmpty();
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static ArrayList<String> m10981c(Context context, Object obj) {
        Class<?> m10992a;
        ArrayList<String> arrayList = new ArrayList<>();
        return (obj == null || (m10992a = m10992a(context, "com.android.vending.billing.IInAppBillingService")) == null || m10989a(m10992a, "getPurchaseHistory") == null) ? arrayList : m10982b(m10980c(context, obj, "inapp"));
    }

    /* renamed from: c */
    private static ArrayList<String> m10980c(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        ArrayList<String> arrayList = new ArrayList<>();
        if (m10993a(context, obj, str).booleanValue()) {
            String str2 = null;
            int i = 0;
            boolean z = false;
            do {
                Object m10991a = m10991a(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", obj, new Object[]{6, f1754d, str, str2, new Bundle()});
                if (m10991a != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) m10991a;
                    if (bundle.getInt("RESPONSE_CODE") == 0 && (stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST")) != null) {
                        Iterator<String> it = stringArrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                z = true;
                                break;
                            }
                            arrayList.add(next);
                            i++;
                        }
                        str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                        if (i < 30 || str2 == null) {
                            break;
                            break;
                        }
                    }
                }
                str2 = null;
                if (i < 30) {
                    break;
                }
            } while (!z);
        }
        return arrayList;
    }

    /* renamed from: b */
    private static ArrayList<String> m10982b(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor edit = f1756f.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                JSONObject jSONObject = new JSONObject(next);
                String string = jSONObject.getString("productId");
                long j = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j / 1000) <= 86400 && !f1756f.getString(string, "").equals(string2)) {
                    edit.putString(string, string2);
                    arrayList2.add(next);
                }
            } catch (JSONException unused) {
            }
        }
        edit.apply();
        return arrayList2;
    }

    @Nullable
    /* renamed from: a */
    private static Method m10989a(Class<?> cls, String str) {
        Method method = f1752b.get(str);
        if (method != null) {
            return method;
        }
        Class<?>[] clsArr = null;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1801122596:
                    if (str.equals("getPurchases")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1450694211:
                    if (str.equals("isBillingSupported")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1123215065:
                    if (str.equals("asInterface")) {
                        c = 0;
                        break;
                    }
                    break;
                case -594356707:
                    if (str.equals("getPurchaseHistory")) {
                        c = 4;
                        break;
                    }
                    break;
                case -573310373:
                    if (str.equals("getSkuDetails")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    clsArr = new Class[]{IBinder.class};
                    break;
                case 1:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
                    break;
                case 2:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class};
                    break;
                case 3:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
                    break;
                case 4:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
                    break;
            }
            method = cls.getDeclaredMethod(str, clsArr);
            f1752b.put(str, method);
            return method;
        } catch (NoSuchMethodException unused) {
            return method;
        }
    }

    @Nullable
    /* renamed from: a */
    private static Class<?> m10992a(Context context, String str) {
        Class<?> cls = f1753c.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            cls = context.getClassLoader().loadClass(str);
            f1753c.put(str, cls);
            return cls;
        } catch (ClassNotFoundException unused) {
            return cls;
        }
    }

    @Nullable
    /* renamed from: a */
    private static Object m10991a(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method m10989a;
        Class<?> m10992a = m10992a(context, str);
        if (m10992a == null || (m10989a = m10989a(m10992a, str2)) == null) {
            return null;
        }
        if (obj != null) {
            obj = m10992a.cast(obj);
        }
        try {
            return m10989a.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m10996a() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = f1755e.getLong("LAST_CLEARED_TIME", 0L);
        if (j == 0) {
            f1755e.edit().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
        } else if (currentTimeMillis - j > 604800) {
            f1755e.edit().clear().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
        }
    }
}
