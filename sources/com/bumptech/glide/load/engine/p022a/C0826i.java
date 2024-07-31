package com.bumptech.glide.load.engine.p022a;

/* renamed from: com.bumptech.glide.load.engine.a.i */
/* loaded from: classes.dex */
public final class IntegerArrayAdapter implements ArrayAdapterInterface<int[]> {
    @Override // com.bumptech.glide.load.engine.p022a.ArrayAdapterInterface
    /* renamed from: a */
    public String mo12208a() {
        return "IntegerArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayAdapterInterface
    /* renamed from: b */
    public int mo12204b() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayAdapterInterface
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int mo12206a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.p022a.ArrayAdapterInterface
    /* renamed from: b */
    public int[] mo12207a(int i) {
        return new int[i];
    }
}
