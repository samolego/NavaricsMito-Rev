package com.bumptech.glide.load.engine.p023b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.b.a */
/* loaded from: classes.dex */
public interface DiskCache {

    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.engine.b.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0700a {
        @Nullable
        /* renamed from: a */
        DiskCache mo12144a();
    }

    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.engine.b.a$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0701b {
        /* renamed from: a */
        boolean mo12108a(@NonNull File file);
    }

    @Nullable
    /* renamed from: a */
    File mo12142a(Key key);

    /* renamed from: a */
    void mo12141a(Key key, InterfaceC0701b interfaceC0701b);
}
