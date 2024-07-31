package com.navatics.app.utils;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p020b.GlideUrl;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.load.p020b.ModelLoaderFactory;
import com.bumptech.glide.load.p020b.MultiModelLoaderFactory;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* renamed from: com.navatics.app.utils.o */
/* loaded from: classes.dex */
public class OkHttpUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    /* renamed from: a */
    private final Call.InterfaceC2918a f5140a;

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull GlideUrl glideUrl) {
        return true;
    }

    public OkHttpUrlLoader(@NonNull Call.InterfaceC2918a interfaceC2918a) {
        this.f5140a = interfaceC2918a;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<InputStream> mo7358a(@NonNull GlideUrl glideUrl, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C0656a<>(glideUrl, new OkHttpStreamFetcher(this.f5140a, glideUrl));
    }

    /* compiled from: OkHttpUrlLoader.java */
    /* renamed from: com.navatics.app.utils.o$a */
    /* loaded from: classes.dex */
    public static class C1911a implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* renamed from: a */
        private static volatile Call.InterfaceC2918a f5141a;

        /* renamed from: b */
        private final Call.InterfaceC2918a f5142b;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public void mo7357a() {
        }

        /* renamed from: b */
        private static Call.InterfaceC2918a m7355b() {
            if (f5141a == null) {
                synchronized (C1911a.class) {
                    if (f5141a == null) {
                        f5141a = new OkHttpClient();
                    }
                }
            }
            return f5141a;
        }

        public C1911a() {
            this(m7355b());
        }

        public C1911a(@NonNull Call.InterfaceC2918a interfaceC2918a) {
            this.f5142b = interfaceC2918a;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public ModelLoader<GlideUrl, InputStream> mo7356a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new OkHttpUrlLoader(this.f5142b);
        }
    }
}
