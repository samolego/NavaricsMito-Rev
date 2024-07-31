package com.bumptech.glide.load.p018a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.load.p018a.DataRewinder;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.k */
/* loaded from: classes.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {

    /* renamed from: a */
    private final RecyclableBufferedInputStream f587a;

    InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        this.f587a = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f587a.mark(5242880);
    }

    @Override // com.bumptech.glide.load.p018a.DataRewinder
    @NonNull
    /* renamed from: c */
    public InputStream mo12010a() throws IOException {
        this.f587a.reset();
        return this.f587a;
    }

    @Override // com.bumptech.glide.load.p018a.DataRewinder
    /* renamed from: b */
    public void mo12009b() {
        this.f587a.m11985b();
    }

    /* compiled from: InputStreamRewinder.java */
    /* renamed from: com.bumptech.glide.load.a.k$a */
    /* loaded from: classes.dex */
    public static final class C0621a implements DataRewinder.InterfaceC0616a<InputStream> {

        /* renamed from: a */
        private final ArrayPool f588a;

        public C0621a(ArrayPool arrayPool) {
            this.f588a = arrayPool;
        }

        @Override // com.bumptech.glide.load.p018a.DataRewinder.InterfaceC0616a
        @NonNull
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public DataRewinder<InputStream> mo12006a(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f588a);
        }

        @Override // com.bumptech.glide.load.p018a.DataRewinder.InterfaceC0616a
        @NonNull
        /* renamed from: a */
        public Class<InputStream> mo12007a() {
            return InputStream.class;
        }
    }
}
