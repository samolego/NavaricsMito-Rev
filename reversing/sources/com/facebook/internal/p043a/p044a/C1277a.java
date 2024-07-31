package com.facebook.internal.p043a.p044a;

import android.os.Process;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.p043a.InstrumentUtility;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.internal.a.a.a */
/* loaded from: classes.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static final String f1914a = CrashHandler.class.getCanonicalName();
    @Nullable

    /* renamed from: b */
    private static CrashHandler f1915b;
    @Nullable

    /* renamed from: c */
    private final Thread.UncaughtExceptionHandler f1916c;

    /* renamed from: d */
    private boolean f1917d = false;

    private CrashHandler(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f1916c = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (InstrumentUtility.m10766c(th)) {
            new CrashReportData(th).m10777b();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f1916c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
        if (this.f1917d) {
            m10782b();
        }
    }

    /* renamed from: a */
    public static synchronized void m10783a() {
        synchronized (CrashHandler.class) {
            if (FacebookSdk.m10861p()) {
                m10781c();
            }
            if (f1915b != null) {
                Log.w(f1914a, "Already enabled!");
                return;
            }
            f1915b = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler());
            Thread.setDefaultUncaughtExceptionHandler(f1915b);
        }
    }

    /* renamed from: b */
    private static void m10782b() {
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private static void m10781c() {
        File[] m10774a = InstrumentUtility.m10774a();
        final ArrayList arrayList = new ArrayList();
        for (File file : m10774a) {
            CrashReportData crashReportData = new CrashReportData(file);
            if (crashReportData.m10779a()) {
                arrayList.add(crashReportData);
            }
        }
        Collections.sort(arrayList, new Comparator<CrashReportData>() { // from class: com.facebook.internal.a.a.a.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(CrashReportData crashReportData2, CrashReportData crashReportData3) {
                return crashReportData2.m10778a(crashReportData3);
            }
        });
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size() && i < 5; i++) {
            jSONArray.put(arrayList.get(i));
        }
        InstrumentUtility.m10771a("crash_reports", jSONArray, new GraphRequest.InterfaceC0829b() { // from class: com.facebook.internal.a.a.a.2
            @Override // com.facebook.GraphRequest.InterfaceC0829b
            /* renamed from: a */
            public void mo10080a(GraphResponse graphResponse) {
                try {
                    if (graphResponse.m10831a() == null && graphResponse.m10824b().getBoolean("success")) {
                        for (int i2 = 0; arrayList.size() > i2; i2++) {
                            ((CrashReportData) arrayList.get(i2)).m10776c();
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }
}
