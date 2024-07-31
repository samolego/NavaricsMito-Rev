package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.p023b.DiskCache;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.d */
/* loaded from: classes.dex */
class DataCacheWriter<DataType> implements DiskCache.InterfaceC0701b {

    /* renamed from: a */
    private final Encoder<DataType> f865a;

    /* renamed from: b */
    private final DataType f866b;

    /* renamed from: c */
    private final Options f867c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheWriter(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.f865a = encoder;
        this.f866b = datatype;
        this.f867c = options;
    }

    @Override // com.bumptech.glide.load.engine.p023b.DiskCache.InterfaceC0701b
    /* renamed from: a */
    public boolean mo12108a(@NonNull File file) {
        return this.f865a.mo11855a(this.f866b, file, this.f867c);
    }
}
