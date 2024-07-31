package com.bumptech.glide.load.p018a;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.p018a.DataFetcher;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.a.b */
/* loaded from: classes.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* renamed from: a */
    private final String f565a;

    /* renamed from: b */
    private final AssetManager f566b;

    /* renamed from: c */
    private T f567c;

    /* renamed from: a */
    protected abstract T mo12393a(AssetManager assetManager, String str) throws IOException;

    /* renamed from: a */
    protected abstract void mo12391a(T t) throws IOException;

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: c */
    public void mo7363c() {
    }

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f566b = assetManager;
        this.f565a = str;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: a */
    public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super T> interfaceC0615a) {
        try {
            this.f567c = mo12393a(this.f566b, this.f565a);
            interfaceC0615a.mo12019a((DataFetcher.InterfaceC0615a<? super T>) ((T) this.f567c));
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            interfaceC0615a.mo12020a((Exception) e);
        }
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: b */
    public void mo7364b() {
        T t = this.f567c;
        if (t == null) {
            return;
        }
        try {
            mo12391a(t);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    @NonNull
    /* renamed from: d */
    public DataSource mo7362d() {
        return DataSource.LOCAL;
    }
}
