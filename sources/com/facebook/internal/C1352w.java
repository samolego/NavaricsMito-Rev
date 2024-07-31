package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.github.mikephil.charting.utils.Utils;
import com.senseplay.sdk.constant.SPWebConstant;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.facebook.internal.w */
/* loaded from: classes.dex */
public final class Utility {

    /* renamed from: a */
    private static int f2057a = 0;

    /* renamed from: b */
    private static long f2058b = -1;

    /* renamed from: c */
    private static long f2059c = -1;

    /* renamed from: d */
    private static long f2060d = -1;

    /* renamed from: e */
    private static String f2061e = "";

    /* renamed from: f */
    private static String f2062f = "";

    /* renamed from: g */
    private static String f2063g = "NoCarrier";

    /* compiled from: Utility.java */
    /* renamed from: com.facebook.internal.w$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0984a {
        /* renamed from: a */
        void mo10342a(FacebookException facebookException);

        /* renamed from: a */
        void mo10341a(JSONObject jSONObject);
    }

    /* compiled from: Utility.java */
    /* renamed from: com.facebook.internal.w$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0985b<T, K> {
        /* renamed from: a */
        K mo9923a(T t);
    }

    /* renamed from: a */
    public static <T> boolean m10520a(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    /* renamed from: a */
    public static boolean m10530a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: a */
    public static String m10527a(String str, String str2) {
        return m10530a(str) ? str2 : str;
    }

    /* renamed from: a */
    public static <T> Collection<T> m10510a(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
    }

    /* renamed from: b */
    public static String m10506b(String str) {
        return m10496c("MD5", str);
    }

    /* renamed from: a */
    public static String m10511a(byte[] bArr) {
        return m10523a("SHA-1", bArr);
    }

    @Nullable
    /* renamed from: c */
    public static String m10497c(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return m10496c("SHA-256", str);
    }

    /* renamed from: c */
    private static String m10496c(String str, String str2) {
        return m10523a(str, str2.getBytes());
    }

    /* renamed from: a */
    private static String m10523a(String str, byte[] bArr) {
        try {
            return m10521a(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m10521a(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString((b >> 0) & 15));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static Uri m10526a(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        return builder.build();
    }

    /* renamed from: d */
    public static Bundle m10490d(String str) {
        Bundle bundle = new Bundle();
        if (!m10530a(str)) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    } else if (split.length == 1) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e) {
                    m10528a("FacebookSDK", (Exception) e);
                }
            }
        }
        return bundle;
    }

    /* renamed from: a */
    public static void m10543a(Bundle bundle, String str, String str2) {
        if (m10530a(str2)) {
            return;
        }
        bundle.putString(str, str2);
    }

    /* renamed from: a */
    public static void m10545a(Bundle bundle, String str, Uri uri) {
        if (uri != null) {
            m10543a(bundle, str, uri.toString());
        }
    }

    /* renamed from: a */
    public static boolean m10544a(Bundle bundle, String str, Object obj) {
        if (obj == null) {
            bundle.remove(str);
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return true;
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return true;
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
            return true;
        } else if (obj instanceof JSONObject) {
            bundle.putString(str, obj.toString());
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    public static void m10538a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m10522a(URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    /* renamed from: a */
    public static String m10548a(Context context) {
        Validate.m10469a(context, "context");
        FacebookSdk.m10883a(context);
        return FacebookSdk.m10865l();
    }

    /* renamed from: a */
    public static Map<String, String> m10516a(@NonNull JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static List<String> m10517a(JSONArray jSONArray) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    /* renamed from: a */
    public static Object m10512a(JSONObject jSONObject, String str, String str2) throws JSONException {
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    /* renamed from: a */
    public static String m10536a(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        sb.append(cArr, 0, read);
                    } else {
                        String sb2 = sb.toString();
                        m10538a((Closeable) bufferedInputStream);
                        m10538a(inputStreamReader);
                        return sb2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                m10538a((Closeable) bufferedInputStream);
                m10538a(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
        }
    }

    /* renamed from: a */
    public static int m10535a(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            int i = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i += read;
            }
            bufferedInputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static void m10547a(Context context, String str) {
        String[] split;
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        for (String str2 : cookie.split(";")) {
            if (str2.split("=").length > 0) {
                cookieManager.setCookie(str, split[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
        }
        cookieManager.removeExpiredCookie();
    }

    /* renamed from: b */
    public static void m10508b(Context context) {
        m10547a(context, "facebook.com");
        m10547a(context, ".facebook.com");
        m10547a(context, "https://facebook.com");
        m10547a(context, "https://.facebook.com");
    }

    /* renamed from: a */
    public static void m10528a(String str, Exception exc) {
        if (!FacebookSdk.m10874d() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
    }

    /* renamed from: b */
    public static void m10505b(String str, String str2) {
        if (!FacebookSdk.m10874d() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    /* renamed from: a */
    public static void m10525a(String str, String str2, Throwable th) {
        if (!FacebookSdk.m10874d() || m10530a(str)) {
            return;
        }
        Log.d(str, str2, th);
    }

    /* renamed from: a */
    public static <T> boolean m10533a(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return t.equals(t2);
    }

    /* renamed from: a */
    public static String m10513a(JSONObject jSONObject, String str) {
        return jSONObject != null ? jSONObject.optString(str, "") : "";
    }

    /* renamed from: b */
    public static JSONObject m10502b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    /* renamed from: c */
    public static JSONArray m10494c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    /* renamed from: a */
    public static void m10537a(File file) {
        File[] listFiles;
        if (file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    m10537a(file2);
                }
            }
            file.delete();
        }
    }

    /* renamed from: b */
    public static <T> List<T> m10501b(T... tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static List<String> m10504b(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    /* renamed from: c */
    public static Set<String> m10495c(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        return hashSet;
    }

    /* renamed from: a */
    public static String m10518a(Map<String, String> map) {
        if (map.isEmpty()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: e */
    public static Map<String, String> m10486e(String str) {
        if (str.isEmpty()) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    /* renamed from: a */
    public static void m10514a(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z) throws JSONException {
        jSONObject.put("anon_id", str);
        jSONObject.put("application_tracking_enabled", !z);
        if (attributionIdentifiers != null) {
            if (attributionIdentifiers.m10755a() != null) {
                jSONObject.put("attribution", attributionIdentifiers.m10755a());
            }
            if (attributionIdentifiers.m10752b() != null) {
                jSONObject.put("advertiser_id", attributionIdentifiers.m10752b());
                jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.m10748d());
            }
            if (!attributionIdentifiers.m10748d()) {
                String m10956b = UserDataStore.m10956b();
                if (!m10956b.isEmpty()) {
                    jSONObject.put("ud", m10956b);
                }
            }
            if (attributionIdentifiers.m10750c() != null) {
                jSONObject.put("installer_package", attributionIdentifiers.m10750c());
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public static String m10551a() {
        Context m10869h = FacebookSdk.m10869h();
        if (m10869h == null) {
            return null;
        }
        try {
            return m10869h.getPackageManager().getPackageInfo(m10869h.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m10515a(JSONObject jSONObject, Context context) throws JSONException {
        Locale locale;
        int i;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        m10478h(context);
        String packageName = context.getPackageName();
        String str = "";
        int i2 = 0;
        int i3 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i3 = packageInfo.versionCode;
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONArray.put(packageName);
        jSONArray.put(i3);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception unused2) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + "_" + locale.getCountry());
        jSONArray.put(f2061e);
        jSONArray.put(f2063g);
        double d = Utils.DOUBLE_EPSILON;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                i = displayMetrics.widthPixels;
                try {
                    i2 = displayMetrics.heightPixels;
                    d = displayMetrics.density;
                } catch (Exception unused3) {
                }
            } else {
                i = 0;
            }
        } catch (Exception unused4) {
            i = 0;
        }
        jSONArray.put(i);
        jSONArray.put(i2);
        jSONArray.put(new DecimalFormat("#.##").format(d));
        jSONArray.put(m10489e());
        jSONArray.put(f2059c);
        jSONArray.put(f2060d);
        jSONArray.put(f2062f);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    /* renamed from: a */
    public static Method m10534a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Method m10524a(String str, String str2, Class<?>... clsArr) {
        try {
            return m10534a(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Object m10532a(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        } catch (InvocationTargetException unused2) {
            return null;
        }
    }

    /* renamed from: c */
    public static String m10499c(Context context) {
        return context == null ? "null" : context == context.getApplicationContext() ? "unknown" : context.getClass().getSimpleName();
    }

    /* renamed from: a */
    public static <T, K> List<K> m10519a(List<T> list, InterfaceC0985b<T, K> interfaceC0985b) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            K mo9923a = interfaceC0985b.mo9923a(t);
            if (mo9923a != null) {
                arrayList.add(mo9923a);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m10546a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    /* renamed from: b */
    public static boolean m10507b(Uri uri) {
        return uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()) || "fbstaging".equalsIgnoreCase(uri.getScheme()));
    }

    /* renamed from: c */
    public static boolean m10498c(Uri uri) {
        return uri != null && "content".equalsIgnoreCase(uri.getScheme());
    }

    /* renamed from: d */
    public static boolean m10491d(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    /* renamed from: e */
    public static long m10487e(Uri uri) {
        Cursor cursor = null;
        try {
            cursor = FacebookSdk.m10869h().getContentResolver().query(uri, null, null, null, null);
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            return cursor.getLong(columnIndex);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* renamed from: a */
    public static Date m10542a(Bundle bundle, String str, Date date) {
        long parseLong;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            parseLong = ((Long) obj).longValue();
        } else if (!(obj instanceof String)) {
            return null;
        } else {
            try {
                parseLong = Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        if (parseLong == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + (parseLong * 1000));
    }

    /* renamed from: a */
    public static void m10540a(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    /* renamed from: a */
    public static Map<String, String> m10541a(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    /* renamed from: a */
    public static boolean m10539a(AccessToken accessToken) {
        return accessToken != null && accessToken.equals(AccessToken.m11457a());
    }

    /* renamed from: a */
    public static void m10529a(final String str, final InterfaceC0984a interfaceC0984a) {
        JSONObject m10558a = ProfileInformationCache.m10558a(str);
        if (m10558a != null) {
            interfaceC0984a.mo10341a(m10558a);
            return;
        }
        GraphRequest.InterfaceC0829b interfaceC0829b = new GraphRequest.InterfaceC0829b() { // from class: com.facebook.internal.w.1
            @Override // com.facebook.GraphRequest.InterfaceC0829b
            /* renamed from: a */
            public void mo10080a(GraphResponse graphResponse) {
                if (graphResponse.m10831a() != null) {
                    InterfaceC0984a.this.mo10342a(graphResponse.m10831a().m11403g());
                    return;
                }
                ProfileInformationCache.m10557a(str, graphResponse.m10824b());
                InterfaceC0984a.this.mo10341a(graphResponse.m10824b());
            }
        };
        GraphRequest m10480g = m10480g(str);
        m10480g.m11393a(interfaceC0829b);
        m10480g.m11348j();
    }

    /* renamed from: f */
    public static JSONObject m10483f(String str) {
        JSONObject m10558a = ProfileInformationCache.m10558a(str);
        if (m10558a != null) {
            return m10558a;
        }
        GraphResponse m11349i = m10480g(str).m11349i();
        if (m11349i.m10831a() != null) {
            return null;
        }
        return m11349i.m10824b();
    }

    /* renamed from: g */
    private static GraphRequest m10480g(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        return new GraphRequest(null, "me", bundle, HttpMethod.GET, null);
    }

    /* renamed from: e */
    private static int m10489e() {
        int i = f2057a;
        if (i > 0) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.facebook.internal.w.2
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return Pattern.matches("cpu[0-9]+", str);
                }
            });
            if (listFiles != null) {
                f2057a = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (f2057a <= 0) {
            f2057a = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return f2057a;
    }

    /* renamed from: h */
    private static void m10478h(Context context) {
        if (f2058b == -1 || System.currentTimeMillis() - f2058b >= 1800000) {
            f2058b = System.currentTimeMillis();
            m10485f();
            m10476i(context);
            m10477i();
            m10479h();
        }
    }

    /* renamed from: f */
    private static void m10485f() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            f2061e = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            f2062f = timeZone.getID();
        } catch (AssertionError | Exception unused) {
        }
    }

    /* renamed from: i */
    private static void m10476i(Context context) {
        if (f2063g.equals("NoCarrier")) {
            try {
                f2063g = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: g */
    private static boolean m10482g() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: h */
    private static void m10479h() {
        try {
            if (m10482g()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f2060d = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            f2060d = m10550a(f2060d);
        } catch (Exception unused) {
        }
    }

    /* renamed from: i */
    private static void m10477i() {
        try {
            if (m10482g()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f2059c = statFs.getBlockCount() * statFs.getBlockSize();
            }
            f2059c = m10550a(f2059c);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static long m10550a(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    /* compiled from: Utility.java */
    /* renamed from: com.facebook.internal.w$c */
    /* loaded from: classes.dex */
    public static class C0986c {

        /* renamed from: a */
        List<String> f2066a;

        /* renamed from: b */
        List<String> f2067b;

        /* renamed from: c */
        List<String> f2068c;

        public C0986c(List<String> list, List<String> list2, List<String> list3) {
            this.f2066a = list;
            this.f2067b = list2;
            this.f2068c = list3;
        }

        /* renamed from: a */
        public List<String> m10475a() {
            return this.f2066a;
        }

        /* renamed from: b */
        public List<String> m10474b() {
            return this.f2067b;
        }

        /* renamed from: c */
        public List<String> m10473c() {
            return this.f2068c;
        }
    }

    /* renamed from: b */
    public static C0986c m10503b(JSONObject jSONObject) throws JSONException {
        String optString;
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        ArrayList arrayList3 = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString2 = optJSONObject.optString(SPWebConstant.Permission);
            if (optString2 != null && !optString2.equals("installed") && (optString = optJSONObject.optString(NotificationCompat.CATEGORY_STATUS)) != null) {
                if (optString.equals("granted")) {
                    arrayList.add(optString2);
                } else if (optString.equals("declined")) {
                    arrayList2.add(optString2);
                } else if (optString.equals("expired")) {
                    arrayList3.add(optString2);
                }
            }
        }
        return new C0986c(arrayList, arrayList2, arrayList3);
    }

    /* renamed from: a */
    public static String m10549a(int i) {
        return new BigInteger(i * 5, new Random()).toString(32);
    }

    /* renamed from: d */
    public static boolean m10492d(Context context) {
        return m10488e(context);
    }

    /* renamed from: e */
    public static boolean m10488e(Context context) {
        AutofillManager autofillManager;
        return Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    /* renamed from: f */
    public static boolean m10484f(Context context) {
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        return Build.DEVICE != null && Build.DEVICE.matches(".+_cheets|cheets_.+");
    }

    @Nullable
    /* renamed from: b */
    public static Locale m10509b() {
        try {
            return FacebookSdk.m10869h().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static Locale m10500c() {
        Locale m10509b = m10509b();
        return m10509b != null ? m10509b : Locale.getDefault();
    }

    /* renamed from: a */
    public static void m10531a(Runnable runnable) {
        try {
            FacebookSdk.m10871f().execute(runnable);
        } catch (Exception unused) {
        }
    }

    /* renamed from: g */
    public static String m10481g(Context context) {
        try {
            String m10864m = FacebookSdk.m10864m();
            if (m10864m != null) {
                return m10864m;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            return context.getString(i);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: d */
    public static boolean m10493d() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format("fb%s://applinks", FacebookSdk.m10865l())));
            Context m10869h = FacebookSdk.m10869h();
            PackageManager packageManager = m10869h.getPackageManager();
            String packageName = m10869h.getPackageName();
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
                if (packageName.equals(resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
