package com.bumptech.glide.p016c;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.c.b */
/* loaded from: classes.dex */
public final class ImageHeaderParserRegistry {

    /* renamed from: a */
    private final List<ImageHeaderParser> f406a = new ArrayList();

    @NonNull
    /* renamed from: a */
    public synchronized List<ImageHeaderParser> m12547a() {
        return this.f406a;
    }

    /* renamed from: a */
    public synchronized void m12546a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f406a.add(imageHeaderParser);
    }
}
