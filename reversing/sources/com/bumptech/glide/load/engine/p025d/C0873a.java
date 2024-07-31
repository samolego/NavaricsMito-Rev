package com.bumptech.glide.load.engine.p025d;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.engine.p023b.MemoryCache;

/* renamed from: com.bumptech.glide.load.engine.d.a */
/* loaded from: classes.dex */
public final class BitmapPreFiller {

    /* renamed from: a */
    private final MemoryCache f868a;

    /* renamed from: b */
    private final BitmapPool f869b;

    /* renamed from: c */
    private final DecodeFormat f870c;

    /* renamed from: d */
    private final Handler f871d = new Handler(Looper.getMainLooper());

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.f868a = memoryCache;
        this.f869b = bitmapPool;
        this.f870c = decodeFormat;
    }
}
