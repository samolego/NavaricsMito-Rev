package com.bumptech.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.navatics.app.MyAppGlideModule;
import java.util.Collections;
import java.util.Set;

/* renamed from: com.bumptech.glide.b */
/* loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* renamed from: a */
    private final MyAppGlideModule f401a = new MyAppGlideModule();

    GeneratedAppGlideModuleImpl() {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.navatics.app.MyAppGlideModule");
        }
    }

    @Override // com.bumptech.glide.p015b.AppGlideModule, com.bumptech.glide.p015b.AppliesOptions
    /* renamed from: a */
    public void mo9571a(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        this.f401a.mo9571a(context, glideBuilder);
    }

    @Override // com.bumptech.glide.p015b.LibraryGlideModule, com.bumptech.glide.p015b.RegistersComponents
    /* renamed from: a */
    public void mo9572a(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        this.f401a.mo9572a(context, glide, registry);
    }

    @Override // com.bumptech.glide.p015b.AppGlideModule
    /* renamed from: c */
    public boolean mo12554c() {
        return this.f401a.mo12554c();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    /* renamed from: a */
    public Set<Class<?>> mo12557a() {
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    /* renamed from: d */
    public GeneratedRequestManagerFactory mo12556b() {
        return new GeneratedRequestManagerFactory();
    }
}
