package com.navatics.app.widget;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DrawElemInfo.java */
/* renamed from: com.navatics.app.widget.a, reason: use source file name */
/* loaded from: classes.dex */
public class DrawElemInfo {

    /* renamed from: c */
    private static final AtomicInteger f5570c = new AtomicInteger();

    /* renamed from: a */
    protected boolean f5571a;

    /* renamed from: b */
    protected int f5572b = f5570c.getAndIncrement();

    /* renamed from: d */
    private RuntimeException f5573d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m5805a() {
        this.f5571a = false;
        this.f5573d = null;
        this.f5572b = f5570c.getAndIncrement();
    }

    /* renamed from: b */
    public void mo5806b() {
        if (this.f5571a) {
            throw new RuntimeException(toString() + " recycled twice, seq = " + this.f5572b);
        }
        this.f5571a = true;
    }
}