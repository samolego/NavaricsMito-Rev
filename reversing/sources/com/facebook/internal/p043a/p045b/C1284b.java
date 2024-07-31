package com.facebook.internal.p043a.p045b;

import android.support.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.p043a.InstrumentUtility;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.internal.a.b.b */
/* loaded from: classes.dex */
public final class ErrorReportHandler {
    /* renamed from: a */
    public static void m10759a(String str) {
        try {
            new ErrorReportData(str).m10763b();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m10760a() {
        if (FacebookSdk.m10861p()) {
            m10758b();
        }
    }

    /* renamed from: b */
    public static void m10758b() {
        File[] m10757c = m10757c();
        final ArrayList arrayList = new ArrayList();
        for (File file : m10757c) {
            ErrorReportData errorReportData = new ErrorReportData(file);
            if (errorReportData.m10765a()) {
                arrayList.add(errorReportData);
            }
        }
        Collections.sort(arrayList, new Comparator<ErrorReportData>() { // from class: com.facebook.internal.a.b.b.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(ErrorReportData errorReportData2, ErrorReportData errorReportData3) {
                return errorReportData2.m10764a(errorReportData3);
            }
        });
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size() && i < 1000; i++) {
            jSONArray.put(arrayList.get(i));
        }
        InstrumentUtility.m10771a("error_reports", jSONArray, new GraphRequest.InterfaceC0829b() { // from class: com.facebook.internal.a.b.b.2
            @Override // com.facebook.GraphRequest.InterfaceC0829b
            /* renamed from: a */
            public void mo10080a(GraphResponse graphResponse) {
                try {
                    if (graphResponse.m10831a() == null && graphResponse.m10824b().getBoolean("success")) {
                        for (int i2 = 0; arrayList.size() > i2; i2++) {
                            ((ErrorReportData) arrayList.get(i2)).m10762c();
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    /* renamed from: c */
    public static File[] m10757c() {
        File m10768b = InstrumentUtility.m10768b();
        if (m10768b == null) {
            return new File[0];
        }
        return m10768b.listFiles(new FilenameFilter() { // from class: com.facebook.internal.a.b.b.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.matches(String.format("^%s[0-9]+.json$", "error_log_"));
            }
        });
    }
}
