package com.bumptech.glide.p012c;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry.java */
/* renamed from: com.bumptech.glide.c.b, reason: use source file name */
/* loaded from: classes.dex */
public final class ImageHeaderParserRegistry {

    /* renamed from: a */
    private final List<ImageHeaderParser> f410a = new ArrayList();

    @NonNull
    /* renamed from: a */
    public synchronized List<ImageHeaderParser> m417a() {
        return this.f410a;
    }

    /* renamed from: a */
    public synchronized void m418a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f410a.add(imageHeaderParser);
    }
}