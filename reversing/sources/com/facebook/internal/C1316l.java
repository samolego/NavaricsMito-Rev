package com.facebook.internal;

import android.net.Uri;
import android.support.annotation.Nullable;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.l */
/* loaded from: classes.dex */
public final class FetchedAppSettings {

    /* renamed from: a */
    private boolean f1967a;

    /* renamed from: b */
    private String f1968b;

    /* renamed from: c */
    private boolean f1969c;

    /* renamed from: d */
    private int f1970d;

    /* renamed from: e */
    private EnumSet<SmartLoginOption> f1971e;

    /* renamed from: f */
    private Map<String, Map<String, C0957a>> f1972f;

    /* renamed from: g */
    private boolean f1973g;

    /* renamed from: h */
    private FacebookRequestErrorClassification f1974h;

    /* renamed from: i */
    private String f1975i;

    /* renamed from: j */
    private String f1976j;

    /* renamed from: k */
    private boolean f1977k;

    /* renamed from: l */
    private boolean f1978l;

    /* renamed from: m */
    private String f1979m;

    /* renamed from: n */
    private JSONArray f1980n;

    /* renamed from: o */
    private boolean f1981o;
    @Nullable

    /* renamed from: p */
    private String f1982p;
    @Nullable

    /* renamed from: q */
    private String f1983q;
    @Nullable

    /* renamed from: r */
    private String f1984r;

    public FetchedAppSettings(boolean z, String str, boolean z2, int i, EnumSet<SmartLoginOption> enumSet, Map<String, Map<String, C0957a>> map, boolean z3, FacebookRequestErrorClassification facebookRequestErrorClassification, String str2, String str3, boolean z4, boolean z5, JSONArray jSONArray, String str4, boolean z6, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.f1967a = z;
        this.f1968b = str;
        this.f1969c = z2;
        this.f1972f = map;
        this.f1974h = facebookRequestErrorClassification;
        this.f1970d = i;
        this.f1973g = z3;
        this.f1971e = enumSet;
        this.f1975i = str2;
        this.f1976j = str3;
        this.f1977k = z4;
        this.f1978l = z5;
        this.f1980n = jSONArray;
        this.f1979m = str4;
        this.f1981o = z6;
        this.f1982p = str5;
        this.f1983q = str6;
        this.f1984r = str7;
    }

    /* renamed from: a */
    public boolean m10692a() {
        return this.f1967a;
    }

    /* renamed from: b */
    public int m10690b() {
        return this.f1970d;
    }

    /* renamed from: c */
    public boolean m10689c() {
        return this.f1973g;
    }

    /* renamed from: d */
    public EnumSet<SmartLoginOption> m10688d() {
        return this.f1971e;
    }

    /* renamed from: e */
    public Map<String, Map<String, C0957a>> m10687e() {
        return this.f1972f;
    }

    /* renamed from: f */
    public FacebookRequestErrorClassification m10686f() {
        return this.f1974h;
    }

    /* renamed from: g */
    public boolean m10685g() {
        return this.f1977k;
    }

    /* renamed from: h */
    public boolean m10684h() {
        return this.f1978l;
    }

    /* renamed from: i */
    public JSONArray m10683i() {
        return this.f1980n;
    }

    /* renamed from: j */
    public String m10682j() {
        return this.f1979m;
    }

    @Nullable
    /* renamed from: k */
    public String m10681k() {
        return this.f1982p;
    }

    @Nullable
    /* renamed from: l */
    public String m10680l() {
        return this.f1983q;
    }

    @Nullable
    /* renamed from: m */
    public String m10679m() {
        return this.f1984r;
    }

    /* compiled from: FetchedAppSettings.java */
    /* renamed from: com.facebook.internal.l$a */
    /* loaded from: classes.dex */
    public static class C0957a {

        /* renamed from: a */
        private String f1985a;

        /* renamed from: b */
        private String f1986b;

        /* renamed from: c */
        private Uri f1987c;

        /* renamed from: d */
        private int[] f1988d;

        /* renamed from: a */
        public static C0957a m10676a(JSONObject jSONObject) {
            String optString = jSONObject.optString("name");
            if (Utility.m10530a(optString)) {
                return null;
            }
            String[] split = optString.split("\\|");
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            String str2 = split[1];
            if (Utility.m10530a(str) || Utility.m10530a(str2)) {
                return null;
            }
            String optString2 = jSONObject.optString("url");
            return new C0957a(str, str2, Utility.m10530a(optString2) ? null : Uri.parse(optString2), m10677a(jSONObject.optJSONArray("versions")));
        }

        /* renamed from: a */
        private static int[] m10677a(JSONArray jSONArray) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                int[] iArr = new int[length];
                for (int i = 0; i < length; i++) {
                    int i2 = -1;
                    int optInt = jSONArray.optInt(i, -1);
                    if (optInt == -1) {
                        String optString = jSONArray.optString(i);
                        if (!Utility.m10530a(optString)) {
                            try {
                                i2 = Integer.parseInt(optString);
                            } catch (NumberFormatException e) {
                                Utility.m10528a("FacebookSDK", (Exception) e);
                            }
                            iArr[i] = i2;
                        }
                    }
                    i2 = optInt;
                    iArr[i] = i2;
                }
                return iArr;
            }
            return null;
        }

        private C0957a(String str, String str2, Uri uri, int[] iArr) {
            this.f1985a = str;
            this.f1986b = str2;
            this.f1987c = uri;
            this.f1988d = iArr;
        }

        /* renamed from: a */
        public String m10678a() {
            return this.f1985a;
        }

        /* renamed from: b */
        public String m10675b() {
            return this.f1986b;
        }

        /* renamed from: c */
        public Uri m10674c() {
            return this.f1987c;
        }

        /* renamed from: d */
        public int[] m10673d() {
            return this.f1988d;
        }
    }

    /* renamed from: a */
    public static C0957a m10691a(String str, String str2, String str3) {
        FetchedAppSettings m10808a;
        Map<String, C0957a> map;
        if (Utility.m10530a(str2) || Utility.m10530a(str3) || (m10808a = FetchedAppSettingsManager.m10808a(str)) == null || (map = m10808a.m10687e().get(str2)) == null) {
            return null;
        }
        return map.get(str3);
    }
}
