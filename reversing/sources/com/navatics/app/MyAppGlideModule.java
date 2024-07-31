package com.navatics.app;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.p020b.GlideUrl;
import com.bumptech.glide.p015b.AppGlideModule;
import com.navatics.app.framework.user.UnsafeOkHttpClient;
import com.navatics.app.utils.OkHttpUrlLoader;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class MyAppGlideModule extends AppGlideModule {
    @Override // com.bumptech.glide.p015b.AppGlideModule, com.bumptech.glide.p015b.AppliesOptions
    /* renamed from: a */
    public void mo9571a(@NonNull Context context, GlideBuilder glideBuilder) {
        glideBuilder.m12504a(5);
    }

    @Override // com.bumptech.glide.p015b.LibraryGlideModule, com.bumptech.glide.p015b.RegistersComponents
    /* renamed from: a */
    public void mo9572a(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.m12614b(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.C1911a(UnsafeOkHttpClient.m7767a()));
    }
}
