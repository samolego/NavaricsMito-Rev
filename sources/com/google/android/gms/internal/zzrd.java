package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;

/* loaded from: classes.dex */
public final class zzrd<L> {
    private volatile L mListener;

    /* renamed from: ze */
    private final zza f3287ze;

    /* renamed from: zf */
    private final zzb<L> f3288zf;

    /* loaded from: classes.dex */
    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.google.android.gms.common.internal.zzac.zzbs(message.what == 1);
            zzrd.this.zzb((zzc) message.obj);
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb<L> {
        private final L mListener;

        /* renamed from: zh */
        private final String f3290zh;

        private zzb(L l, String str) {
            this.mListener = l;
            this.f3290zh = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof zzb) {
                zzb zzbVar = (zzb) obj;
                return this.mListener == zzbVar.mListener && this.f3290zh.equals(zzbVar.f3290zh);
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.mListener) * 31) + this.f3290zh.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public interface zzc<L> {
        void zzarg();

        void zzt(L l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrd(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.f3287ze = new zza(looper);
        this.mListener = (L) com.google.android.gms.common.internal.zzac.zzb(l, "Listener must not be null");
        this.f3288zf = new zzb<>(l, com.google.android.gms.common.internal.zzac.zzhz(str));
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzc<? super L> zzcVar) {
        com.google.android.gms.common.internal.zzac.zzb(zzcVar, "Notifier must not be null");
        this.f3287ze.sendMessage(this.f3287ze.obtainMessage(1, zzcVar));
    }

    @NonNull
    public zzb<L> zzasr() {
        return this.f3288zf;
    }

    void zzb(zzc<? super L> zzcVar) {
        Object obj = (L) this.mListener;
        if (obj == null) {
            zzcVar.zzarg();
            return;
        }
        try {
            zzcVar.zzt(obj);
        } catch (RuntimeException e) {
            zzcVar.zzarg();
            throw e;
        }
    }
}
