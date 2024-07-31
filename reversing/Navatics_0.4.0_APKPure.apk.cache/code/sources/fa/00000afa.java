package com.bumptech.glide.load.engine.p018a;

/* compiled from: IntegerArrayAdapter.java */
/* renamed from: com.bumptech.glide.load.engine.a.i, reason: use source file name */
/* loaded from: classes.dex */
public final class IntegerArrayAdapter implements InterfaceC0623a<int[]> {
    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0623a
    /* renamed from: a */
    public String mo753a() {
        return "IntegerArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0623a
    /* renamed from: b */
    public int mo754b() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0623a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo751a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0623a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int[] mo752a(int i) {
        return new int[i];
    }
}