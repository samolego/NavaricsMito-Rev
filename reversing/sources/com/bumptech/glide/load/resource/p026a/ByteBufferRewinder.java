package com.bumptech.glide.load.resource.p026a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.p018a.DataRewinder;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.resource.a.a */
/* loaded from: classes.dex */
public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {

    /* renamed from: a */
    private final ByteBuffer f1006a;

    @Override // com.bumptech.glide.load.p018a.DataRewinder
    /* renamed from: b */
    public void mo12009b() {
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.f1006a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.p018a.DataRewinder
    @NonNull
    /* renamed from: c */
    public ByteBuffer mo12010a() {
        this.f1006a.position(0);
        return this.f1006a;
    }

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: com.bumptech.glide.load.resource.a.a$a */
    /* loaded from: classes.dex */
    public static class C0737a implements DataRewinder.InterfaceC0616a<ByteBuffer> {
        @Override // com.bumptech.glide.load.p018a.DataRewinder.InterfaceC0616a
        @NonNull
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public DataRewinder<ByteBuffer> mo12006a(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }

        @Override // com.bumptech.glide.load.p018a.DataRewinder.InterfaceC0616a
        @NonNull
        /* renamed from: a */
        public Class<ByteBuffer> mo12007a() {
            return ByteBuffer.class;
        }
    }
}
