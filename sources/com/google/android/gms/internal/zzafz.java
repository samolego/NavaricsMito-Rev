package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class zzafz {
    static HashMap<String, String> aRW;
    private static Object aRX;
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri aRT = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern aRU = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern aRV = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    static HashSet<String> aRY = new HashSet<>();

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        String string = getString(contentResolver, str);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
                return j;
            }
        }
        return j;
    }

    public static String getString(ContentResolver contentResolver, String str) {
        return zza(contentResolver, str, null);
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzafz.class) {
            zza(contentResolver);
            Object obj = aRX;
            if (aRW.containsKey(str)) {
                String str3 = aRW.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
                return str3;
            }
            Iterator<String> it = aRY.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    return str2;
                }
            }
            Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(1);
                        synchronized (zzafz.class) {
                            if (obj == aRX) {
                                aRW.put(str, string);
                            }
                        }
                        if (string != null) {
                            str2 = string;
                        }
                        return str2;
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            aRW.put(str, null);
            if (query != null) {
                query.close();
            }
            return str2;
        }
    }

    public static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(aRT, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.zzafz$1] */
    private static void zza(final ContentResolver contentResolver) {
        if (aRW == null) {
            aRW = new HashMap<>();
            aRX = new Object();
            new Thread("Gservices") { // from class: com.google.android.gms.internal.zzafz.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Looper.prepare();
                    contentResolver.registerContentObserver(zzafz.CONTENT_URI, true, new ContentObserver(new Handler(Looper.myLooper())) { // from class: com.google.android.gms.internal.zzafz.1.1
                        @Override // android.database.ContentObserver
                        public void onChange(boolean z) {
                            synchronized (zzafz.class) {
                                zzafz.aRW.clear();
                                Object unused = zzafz.aRX = new Object();
                                if (!zzafz.aRY.isEmpty()) {
                                    zzafz.zzb(contentResolver, (String[]) zzafz.aRY.toArray(new String[zzafz.aRY.size()]));
                                }
                            }
                        }
                    });
                    Looper.loop();
                }
            }.start();
        }
    }

    public static void zzb(ContentResolver contentResolver, String... strArr) {
        Map<String, String> zza = zza(contentResolver, strArr);
        synchronized (zzafz.class) {
            zza(contentResolver);
            aRY.addAll(Arrays.asList(strArr));
            for (Map.Entry<String, String> entry : zza.entrySet()) {
                aRW.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
