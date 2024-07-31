package com.navatics.app.widget;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.navatics.app.widget.a */
/* loaded from: classes.dex */
public class DrawElemInfo {

    /* renamed from: c */
    private static final AtomicInteger f5548c = new AtomicInteger();

    /* renamed from: a */
    protected boolean f5549a;

    /* renamed from: b */
    protected int f5550b = f5548c.getAndIncrement();

    /* renamed from: d */
    private RuntimeException f5551d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m7059a() {
        this.f5549a = false;
        this.f5551d = null;
        this.f5550b = f5548c.getAndIncrement();
    }

    /* renamed from: b */
    public void mo6919b() {
        if (this.f5549a) {
            throw new RuntimeException(toString() + " recycled twice, seq = " + this.f5550b);
        }
        this.f5549a = true;
    }
}
