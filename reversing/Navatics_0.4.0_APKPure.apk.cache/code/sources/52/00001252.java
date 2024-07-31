package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class zzs {
    public static String TAG = "Volley";
    public static boolean DEBUG = Log.isLoggable(TAG, 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zza {
        public static final boolean zzbj = zzs.DEBUG;
        private final List<C3575zza> zzbk = new ArrayList();
        private boolean zzbl = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zzs$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C3575zza {
            public final String name;
            public final long time;
            public final long zzbm;

            public C3575zza(String str, long j, long j2) {
                this.name = str;
                this.zzbm = j;
                this.time = j2;
            }
        }

        private long getTotalDuration() {
            if (this.zzbk.size() == 0) {
                return 0L;
            }
            return this.zzbk.get(r2.size() - 1).time - this.zzbk.get(0).time;
        }

        protected void finalize() throws Throwable {
            if (this.zzbl) {
                return;
            }
            zzd("Request on the loose");
            zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void zza(String str, long j) {
            if (this.zzbl) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.zzbk.add(new C3575zza(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void zzd(String str) {
            this.zzbl = true;
            long totalDuration = getTotalDuration();
            if (totalDuration <= 0) {
                return;
            }
            long j = this.zzbk.get(0).time;
            zzs.zzb("(%-4d ms) %s", Long.valueOf(totalDuration), str);
            for (C3575zza c3575zza : this.zzbk) {
                long j2 = c3575zza.time;
                zzs.zzb("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c3575zza.zzbm), c3575zza.name);
                j = j2;
            }
        }
    }

    public static void zza(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zzd(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr), th);
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(TAG, zzd(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr));
    }

    private static String zzd(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            }
            if (!stackTrace[i].getClass().equals(zzs.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String valueOf = String.valueOf(stackTrace[i].getMethodName());
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(valueOf).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(valueOf);
                str2 = sb.toString();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}