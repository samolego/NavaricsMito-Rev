package com.bumptech.glide.load.resource.p026a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.load.resource.a.b */
/* loaded from: classes.dex */
public class BytesResource implements Resource<byte[]> {

    /* renamed from: a */
    private final byte[] f1007a;

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: f */
    public void mo11851f() {
    }

    public BytesResource(byte[] bArr) {
        this.f1007a = (byte[]) Preconditions.m11580a(bArr);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public Class<byte[]> mo11853c() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: a */
    public byte[] mo11898d() {
        return this.f1007a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public int mo11852e() {
        return this.f1007a.length;
    }
}
