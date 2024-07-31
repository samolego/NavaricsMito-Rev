package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzr;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class Api<O extends ApiOptions> {
    private final String mName;

    /* renamed from: vi */
    private final zza<?, O> f2647vi;

    /* renamed from: vj */
    private final zzh<?, O> f2648vj;

    /* renamed from: vk */
    private final zzf<?> f2649vk;

    /* renamed from: vl */
    private final zzi<?> f2650vl;

    /* loaded from: classes.dex */
    public interface ApiOptions {

        /* loaded from: classes.dex */
        public interface HasOptions extends ApiOptions {
        }

        /* loaded from: classes.dex */
        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        /* loaded from: classes.dex */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* loaded from: classes.dex */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zza<T extends zze, O> extends zzd<T, O> {
        public abstract T zza(Context context, Looper looper, com.google.android.gms.common.internal.zzh zzhVar, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);
    }

    /* loaded from: classes.dex */
    public interface zzb {
    }

    /* loaded from: classes.dex */
    public static class zzc<C extends zzb> {
    }

    /* loaded from: classes.dex */
    public static abstract class zzd<T extends zzb, O> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public List<Scope> zzp(O o) {
            return Collections.emptyList();
        }
    }

    /* loaded from: classes.dex */
    public interface zze extends zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        boolean isConnecting();

        void zza(zze.zzf zzfVar);

        void zza(zzr zzrVar, Set<Scope> set);

        boolean zzahd();

        boolean zzahs();

        Intent zzaht();

        boolean zzapr();

        @Nullable
        IBinder zzaps();
    }

    /* loaded from: classes.dex */
    public static final class zzf<C extends zze> extends zzc<C> {
    }

    /* loaded from: classes.dex */
    public interface zzg<T extends IInterface> extends zzb {
        void zza(int i, T t);

        T zzh(IBinder iBinder);

        String zzix();

        String zziy();
    }

    /* loaded from: classes.dex */
    public static abstract class zzh<T extends zzg, O> extends zzd<T, O> {
        public abstract int zzapt();

        public abstract T zzr(O o);
    }

    /* loaded from: classes.dex */
    public static final class zzi<C extends zzg> extends zzc<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends zze> Api(String str, zza<C, O> zzaVar, zzf<C> zzfVar) {
        zzac.zzb(zzaVar, "Cannot construct an Api with a null ClientBuilder");
        zzac.zzb(zzfVar, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.f2647vi = zzaVar;
        this.f2648vj = null;
        this.f2649vk = zzfVar;
        this.f2650vl = null;
    }

    public String getName() {
        return this.mName;
    }

    public zzd<?, O> zzapm() {
        if (zzapq()) {
            return null;
        }
        return this.f2647vi;
    }

    public zza<?, O> zzapn() {
        zzac.zza(this.f2647vi != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f2647vi;
    }

    public zzh<?, O> zzapo() {
        zzac.zza(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public zzc<?> zzapp() {
        zzf<?> zzfVar = this.f2649vk;
        if (zzfVar != null) {
            return zzfVar;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean zzapq() {
        return false;
    }
}
