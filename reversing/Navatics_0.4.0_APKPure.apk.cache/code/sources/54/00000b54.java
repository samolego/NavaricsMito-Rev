package com.bumptech.glide.load.resource.p022a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.p014a.InterfaceC0572e;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder.java */
/* renamed from: com.bumptech.glide.load.resource.a.a, reason: use source file name */
/* loaded from: classes.dex */
public class ByteBufferRewinder implements InterfaceC0572e<ByteBuffer> {

    /* renamed from: a */
    private final ByteBuffer f1010a;

    @Override // com.bumptech.glide.load.p014a.InterfaceC0572e
    /* renamed from: b */
    public void mo596b() {
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.f1010a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.p014a.InterfaceC0572e
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer mo595a() {
        this.f1010a.position(0);
        return this.f1010a;
    }

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: com.bumptech.glide.load.resource.a.a$a */
    /* loaded from: classes.dex */
    public static class a implements InterfaceC0572e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.p014a.InterfaceC0572e.a
        @NonNull
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public InterfaceC0572e<ByteBuffer> mo597a(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }

        @Override // com.bumptech.glide.load.p014a.InterfaceC0572e.a
        @NonNull
        /* renamed from: a */
        public Class<ByteBuffer> mo598a() {
            return ByteBuffer.class;
        }
    }
}