package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.util.zzt;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class zzb {

    /* renamed from: Cz */
    private static final Object f2963Cz = new Object();

    /* renamed from: DX */
    private static zzb f2964DX;

    /* renamed from: Ed */
    private static Integer f2965Ed;

    /* renamed from: DY */
    private final List<String> f2966DY;

    /* renamed from: DZ */
    private final List<String> f2967DZ;

    /* renamed from: Ea */
    private final List<String> f2968Ea;

    /* renamed from: Eb */
    private final List<String> f2969Eb;

    /* renamed from: Ec */
    private zze f2970Ec;

    /* renamed from: Ee */
    private zze f2971Ee;

    private zzb() {
        if (getLogLevel() == zzd.LOG_LEVEL_OFF) {
            this.f2966DY = Collections.EMPTY_LIST;
            this.f2967DZ = Collections.EMPTY_LIST;
            this.f2968Ea = Collections.EMPTY_LIST;
            this.f2969Eb = Collections.EMPTY_LIST;
            return;
        }
        String str = zzc.zza.f2975Ei.get();
        this.f2966DY = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        String str2 = zzc.zza.f2976Ej.get();
        this.f2967DZ = str2 == null ? Collections.EMPTY_LIST : Arrays.asList(str2.split(","));
        String str3 = zzc.zza.f2977Ek.get();
        this.f2968Ea = str3 == null ? Collections.EMPTY_LIST : Arrays.asList(str3.split(","));
        String str4 = zzc.zza.f2978El.get();
        this.f2969Eb = str4 == null ? Collections.EMPTY_LIST : Arrays.asList(str4.split(","));
        this.f2970Ec = new zze(1024, zzc.zza.f2979Em.get().longValue());
        this.f2971Ee = new zze(1024, zzc.zza.f2979Em.get().longValue());
    }

    private static int getLogLevel() {
        if (f2965Ed == null) {
            try {
                f2965Ed = Integer.valueOf(com.google.android.gms.common.util.zzd.zzact() ? zzc.zza.f2974Eh.get().intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException unused) {
                f2965Ed = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return f2965Ed.intValue();
    }

    private static String zza(StackTraceElement[] stackTraceElementArr, int i) {
        int i2 = i + 4;
        if (i2 >= stackTraceElementArr.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr[i2];
        String valueOf = String.valueOf(stackTraceElement.getClassName());
        String valueOf2 = String.valueOf(stackTraceElement.getMethodName());
        int lineNumber = stackTraceElement.getLineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append(".");
        sb.append(valueOf2);
        sb.append(":");
        sb.append(lineNumber);
        return sb.toString();
    }

    private void zza(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        long currentTimeMillis = System.currentTimeMillis();
        String zzm = ((getLogLevel() & zzd.f2986Er) == 0 || i == 13) ? null : zzm(3, 5);
        long nativeHeapAllocatedSize = (getLogLevel() & zzd.f2988Et) != 0 ? Debug.getNativeHeapAllocatedSize() : 0L;
        context.startService(new Intent().setComponent(zzd.f2982En).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (i == 1 || i == 4 || i == 14) ? new ConnectionEvent(currentTimeMillis, i, null, null, null, null, zzm, str, SystemClock.elapsedRealtime(), nativeHeapAllocatedSize) : new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, zzm, str, SystemClock.elapsedRealtime(), nativeHeapAllocatedSize)));
    }

    private void zza(Context context, String str, String str2, Intent intent, int i) {
        String str3;
        String str4;
        String str5;
        if (!zzawv() || this.f2970Ec == null) {
            return;
        }
        if (i != 4 && i != 1) {
            ServiceInfo zzd = zzd(context, intent);
            if (zzd == null) {
                Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", str2, intent.toUri(0)));
                return;
            }
            String str6 = zzd.processName;
            String str7 = zzd.name;
            String zzaxx = zzt.zzaxx();
            if (!zzb(zzaxx, str2, str6, str7)) {
                return;
            }
            this.f2970Ec.zzif(str);
            str4 = str6;
            str3 = zzaxx;
            str5 = str7;
        } else if (!this.f2970Ec.zzig(str)) {
            return;
        } else {
            str3 = null;
            str4 = null;
            str5 = null;
        }
        zza(context, str, i, str3, str2, str4, str5);
    }

    public static zzb zzawu() {
        synchronized (f2963Cz) {
            if (f2964DX == null) {
                f2964DX = new zzb();
            }
        }
        return f2964DX;
    }

    private boolean zzawv() {
        return false;
    }

    private String zzb(ServiceConnection serviceConnection) {
        return String.valueOf((Process.myPid() << 32) | System.identityHashCode(serviceConnection));
    }

    private boolean zzb(String str, String str2, String str3, String str4) {
        int logLevel = getLogLevel();
        if (this.f2966DY.contains(str) || this.f2967DZ.contains(str2) || this.f2968Ea.contains(str3) || this.f2969Eb.contains(str4)) {
            return false;
        }
        return !str3.equals(str) || (zzd.f2987Es & logLevel) == 0;
    }

    private boolean zzc(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            return false;
        }
        return com.google.android.gms.common.util.zzd.zzx(context, component.getPackageName());
    }

    private static ServiceInfo zzd(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", intent.toUri(0), zzm(3, 20)));
            return null;
        } else if (queryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", intent.toUri(0), zzm(3, 20)));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                Log.w("ConnectionTracker", resolveInfo.serviceInfo.name);
            }
            return null;
        } else {
            return queryIntentServices.get(0).serviceInfo;
        }
    }

    private static String zzm(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(zza(stackTrace, i));
            stringBuffer.append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"UntrackedBindService"})
    public void zza(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        zza(context, zzb(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (zzc(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            zza(context, zzb(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 4);
    }
}
