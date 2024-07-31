package com.bumptech.glide.request.p031a;

import android.support.annotation.NonNull;
import com.bumptech.glide.util.C0791i;

/* renamed from: com.bumptech.glide.request.a.f */
/* loaded from: classes.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {

    /* renamed from: a */
    private final int f1220a;

    /* renamed from: b */
    private final int f1221b;

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: b */
    public void mo11696b(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public SimpleTarget(int i, int i2) {
        this.f1220a = i;
        this.f1221b = i2;
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: a */
    public final void mo11702a(@NonNull SizeReadyCallback sizeReadyCallback) {
        if (!C0791i.m11571a(this.f1220a, this.f1221b)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f1220a + " and height: " + this.f1221b + ", either provide dimensions in the constructor or call override()");
        }
        sizeReadyCallback.mo11723a(this.f1220a, this.f1221b);
    }
}
