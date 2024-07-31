package com.bumptech.glide.load.engine.p018a;

/* compiled from: ByteArrayAdapter.java */
/* renamed from: com.bumptech.glide.load.engine.a.g, reason: use source file name */
/* loaded from: classes.dex */
public final class ByteArrayAdapter implements InterfaceC0623a<byte[]> {
    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0623a
    /* renamed from: a */
    public String mo753a() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0623a
    /* renamed from: b */
    public int mo754b() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0623a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo751a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0623a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] mo752a(int i) {
        return new byte[i];
    }
}