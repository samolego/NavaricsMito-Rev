package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.p032b.NoTransition;
import com.bumptech.glide.request.p032b.TransitionFactory;

/* renamed from: com.bumptech.glide.j */
/* loaded from: classes.dex */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a */
    private TransitionFactory<? super TranscodeType> f547a = NoTransition.m11707a();

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final TransitionFactory<? super TranscodeType> m12429b() {
        return this.f547a;
    }
}
