package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.info.C2420b;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.crashreport.crash.C2435b;
import com.tencent.bugly.crashreport.crash.C2437c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2500y;
import com.tencent.bugly.proguard.C2503z;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.jni.a */
/* loaded from: classes2.dex */
public final class C2447a implements NativeExceptionHandler {

    /* renamed from: a */
    private final Context f7507a;

    /* renamed from: b */
    private final C2435b f7508b;

    /* renamed from: c */
    private final C2419a f7509c;

    /* renamed from: d */
    private final C2422a f7510d;

    public C2447a(Context context, C2419a c2419a, C2435b c2435b, C2422a c2422a) {
        this.f7507a = context;
        this.f7508b = c2435b;
        this.f7509c = c2419a;
        this.f7510d = c2422a;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str12;
        int indexOf;
        boolean m5325k = C2437c.m5343a().m5325k();
        if (m5325k) {
            C2499x.m5083e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f7351b = 1;
        crashDetailBean.f7354e = this.f7509c.m5454h();
        crashDetailBean.f7355f = this.f7509c.f7264j;
        crashDetailBean.f7356g = this.f7509c.m5439w();
        crashDetailBean.f7362m = this.f7509c.m5456g();
        crashDetailBean.f7363n = str3;
        crashDetailBean.f7364o = m5325k ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f7365p = str4;
        crashDetailBean.f7366q = str5 == null ? "" : str5;
        crashDetailBean.f7367r = j;
        crashDetailBean.f7370u = C2503z.m5023b(crashDetailBean.f7366q.getBytes());
        crashDetailBean.f7327A = str;
        crashDetailBean.f7328B = str2;
        crashDetailBean.f7335I = this.f7509c.m5437y();
        crashDetailBean.f7357h = this.f7509c.m5440v();
        crashDetailBean.f7358i = this.f7509c.m5487J();
        crashDetailBean.f7371v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String m5287a = C2448b.m5287a(dumpFilePath, str8);
        if (!C2503z.m5043a(m5287a)) {
            crashDetailBean.f7347U = m5287a;
        }
        crashDetailBean.f7348V = C2448b.m5285b(dumpFilePath);
        crashDetailBean.f7372w = C2448b.m5288a(str9, C2437c.f7423e, null, false);
        crashDetailBean.f7373x = C2448b.m5288a(str10, C2437c.f7423e, null, true);
        crashDetailBean.f7336J = str7;
        crashDetailBean.f7337K = str6;
        crashDetailBean.f7338L = str11;
        crashDetailBean.f7332F = this.f7509c.m5446p();
        crashDetailBean.f7333G = this.f7509c.m5447o();
        crashDetailBean.f7334H = this.f7509c.m5445q();
        if (z) {
            crashDetailBean.f7329C = C2420b.m5414k();
            crashDetailBean.f7330D = C2420b.m5418i();
            crashDetailBean.f7331E = C2420b.m5410m();
            if (crashDetailBean.f7372w == null) {
                crashDetailBean.f7372w = C2503z.m5056a(this.f7507a, C2437c.f7423e, (String) null);
            }
            crashDetailBean.f7374y = C2500y.m5082a();
            crashDetailBean.f7339M = this.f7509c.f7230a;
            crashDetailBean.f7340N = this.f7509c.m5476a();
            crashDetailBean.f7342P = this.f7509c.m5489H();
            crashDetailBean.f7343Q = this.f7509c.m5488I();
            crashDetailBean.f7344R = this.f7509c.m5495B();
            crashDetailBean.f7345S = this.f7509c.m5490G();
            crashDetailBean.f7375z = C2503z.m5060a(C2437c.f7424f, false);
            int indexOf2 = crashDetailBean.f7366q.indexOf("java:\n");
            if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.f7366q.length()) {
                String substring = crashDetailBean.f7366q.substring(i, crashDetailBean.f7366q.length() - 1);
                if (substring.length() > 0 && crashDetailBean.f7375z.containsKey(crashDetailBean.f7328B) && (indexOf = (str12 = crashDetailBean.f7375z.get(crashDetailBean.f7328B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.f7375z.put(crashDetailBean.f7328B, substring2);
                    crashDetailBean.f7366q = crashDetailBean.f7366q.substring(0, i);
                    crashDetailBean.f7366q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.f7327A = this.f7509c.f7258d;
            }
            this.f7508b.m5348c(crashDetailBean);
        } else {
            crashDetailBean.f7329C = -1L;
            crashDetailBean.f7330D = -1L;
            crashDetailBean.f7331E = -1L;
            if (crashDetailBean.f7372w == null) {
                crashDetailBean.f7372w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.f7339M = -1L;
            crashDetailBean.f7342P = -1;
            crashDetailBean.f7343Q = -1;
            crashDetailBean.f7344R = map;
            crashDetailBean.f7345S = this.f7509c.m5490G();
            crashDetailBean.f7375z = null;
            if (str == null) {
                crashDetailBean.f7327A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f7374y = bArr;
            }
        }
        return crashDetailBean;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        C2499x.m5090a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0128 A[Catch: Throwable -> 0x02b4, TryCatch #2 {Throwable -> 0x02b4, blocks: (B:3:0x0012, B:5:0x001a, B:13:0x0076, B:16:0x007f, B:18:0x0082, B:20:0x0086, B:22:0x009f, B:23:0x00a7, B:24:0x00b0, B:26:0x00ba, B:28:0x00c4, B:30:0x00cc, B:32:0x00d8, B:34:0x00e2, B:37:0x00e9, B:39:0x00fb, B:41:0x0105, B:44:0x010d, B:45:0x0122, B:47:0x0128, B:49:0x0138, B:52:0x015c, B:55:0x01a4, B:57:0x01c7, B:58:0x01ce, B:60:0x01d8, B:62:0x01e0, B:54:0x017d, B:38:0x00f5, B:25:0x00b3, B:8:0x0044, B:9:0x004a, B:11:0x0054), top: B:96:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015c A[Catch: Throwable -> 0x02b4, TryCatch #2 {Throwable -> 0x02b4, blocks: (B:3:0x0012, B:5:0x001a, B:13:0x0076, B:16:0x007f, B:18:0x0082, B:20:0x0086, B:22:0x009f, B:23:0x00a7, B:24:0x00b0, B:26:0x00ba, B:28:0x00c4, B:30:0x00cc, B:32:0x00d8, B:34:0x00e2, B:37:0x00e9, B:39:0x00fb, B:41:0x0105, B:44:0x010d, B:45:0x0122, B:47:0x0128, B:49:0x0138, B:52:0x015c, B:55:0x01a4, B:57:0x01c7, B:58:0x01ce, B:60:0x01d8, B:62:0x01e0, B:54:0x017d, B:38:0x00f5, B:25:0x00b3, B:8:0x0044, B:9:0x004a, B:11:0x0054), top: B:96:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01c7 A[Catch: Throwable -> 0x02b4, TryCatch #2 {Throwable -> 0x02b4, blocks: (B:3:0x0012, B:5:0x001a, B:13:0x0076, B:16:0x007f, B:18:0x0082, B:20:0x0086, B:22:0x009f, B:23:0x00a7, B:24:0x00b0, B:26:0x00ba, B:28:0x00c4, B:30:0x00cc, B:32:0x00d8, B:34:0x00e2, B:37:0x00e9, B:39:0x00fb, B:41:0x0105, B:44:0x010d, B:45:0x0122, B:47:0x0128, B:49:0x0138, B:52:0x015c, B:55:0x01a4, B:57:0x01c7, B:58:0x01ce, B:60:0x01d8, B:62:0x01e0, B:54:0x017d, B:38:0x00f5, B:25:0x00b3, B:8:0x0044, B:9:0x004a, B:11:0x0054), top: B:96:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d8 A[Catch: Throwable -> 0x02b4, TryCatch #2 {Throwable -> 0x02b4, blocks: (B:3:0x0012, B:5:0x001a, B:13:0x0076, B:16:0x007f, B:18:0x0082, B:20:0x0086, B:22:0x009f, B:23:0x00a7, B:24:0x00b0, B:26:0x00ba, B:28:0x00c4, B:30:0x00cc, B:32:0x00d8, B:34:0x00e2, B:37:0x00e9, B:39:0x00fb, B:41:0x0105, B:44:0x010d, B:45:0x0122, B:47:0x0128, B:49:0x0138, B:52:0x015c, B:55:0x01a4, B:57:0x01c7, B:58:0x01ce, B:60:0x01d8, B:62:0x01e0, B:54:0x017d, B:38:0x00f5, B:25:0x00b3, B:8:0x0044, B:9:0x004a, B:11:0x0054), top: B:96:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0242 A[Catch: Throwable -> 0x02b0, TryCatch #1 {Throwable -> 0x02b0, blocks: (B:65:0x023c, B:67:0x0242, B:69:0x024b), top: B:95:0x023c }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x024b A[Catch: Throwable -> 0x02b0, TRY_LEAVE, TryCatch #1 {Throwable -> 0x02b0, blocks: (B:65:0x023c, B:67:0x0242, B:69:0x024b), top: B:95:0x023c }] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleNativeException2(int r27, int r28, long r29, long r31, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, int r39, int r40, int r41, java.lang.String r42, java.lang.String r43, java.lang.String[] r44) {
        /*
            Method dump skipped, instructions count: 704
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C2447a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }
}
