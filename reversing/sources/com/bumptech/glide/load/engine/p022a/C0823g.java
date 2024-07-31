package com.bumptech.glide.load.engine.p022a;

/* renamed from: com.bumptech.glide.load.engine.a.g */
/* loaded from: classes.dex */
public final class ByteArrayAdapter implements ArrayAdapterInterface<byte[]> {
    @Override // com.bumptech.glide.load.engine.p022a.ArrayAdapterInterface
    /* renamed from: a */
    public String mo12208a() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayAdapterInterface
    /* renamed from: b */
    public int mo12204b() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayAdapterInterface
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int mo12206a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayAdapterInterface
    /* renamed from: b */
    public byte[] mo12207a(int i) {
        return new byte[i];
    }
}
