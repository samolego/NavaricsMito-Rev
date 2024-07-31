package com.bumptech.glide.load.engine.p019b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.InterfaceC0612c;
import java.io.File;

/* compiled from: DiskCache.java */
/* renamed from: com.bumptech.glide.load.engine.b.a */
/* loaded from: classes.dex */
public interface InterfaceC0638a {

    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.engine.b.a$a */
    /* loaded from: classes.dex */
    public interface a {
        @Nullable
        /* renamed from: a */
        InterfaceC0638a mo835a();
    }

    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.engine.b.a$b */
    /* loaded from: classes.dex */
    public interface b {
        /* renamed from: a */
        boolean mo836a(@NonNull File file);
    }

    @Nullable
    /* renamed from: a */
    File mo833a(InterfaceC0612c interfaceC0612c);

    /* renamed from: a */
    void mo834a(InterfaceC0612c interfaceC0612c, b bVar);
}