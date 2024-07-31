package com.bumptech.glide.load.resource.p022a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.InterfaceC0667s;
import com.bumptech.glide.util.C0780h;

/* compiled from: BytesResource.java */
/* renamed from: com.bumptech.glide.load.resource.a.b, reason: use source file name */
/* loaded from: classes.dex */
public class BytesResource implements InterfaceC0667s<byte[]> {

    /* renamed from: a */
    private final byte[] f1011a;

    @Override // com.bumptech.glide.load.engine.InterfaceC0667s
    /* renamed from: f */
    public void mo940f() {
    }

    public BytesResource(byte[] bArr) {
        this.f1011a = (byte[]) C0780h.m1362a(bArr);
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0667s
    @NonNull
    /* renamed from: c */
    public Class<byte[]> mo937c() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0667s
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] mo938d() {
        return this.f1011a;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0667s
    /* renamed from: e */
    public int mo939e() {
        return this.f1011a.length;
    }
}