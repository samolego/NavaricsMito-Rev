package com.twitter.sdk.android.tweetui.internal;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

/* compiled from: ClickableLinkSpan.java */
/* renamed from: com.twitter.sdk.android.tweetui.internal.b, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class ClickableLinkSpan extends ClickableSpan implements HighlightedClickableSpan {

    /* renamed from: a */
    private final int f9111a;

    /* renamed from: b */
    private final boolean f9112b;

    /* renamed from: c */
    public final int f9113c;

    /* renamed from: d */
    private final boolean f9114d;

    /* renamed from: e */
    private boolean f9115e;

    public ClickableLinkSpan(int i, int i2, boolean z) {
        this(i, i2, true, z);
    }

    ClickableLinkSpan(int i, int i2, boolean z, boolean z2) {
        this.f9111a = i;
        this.f9113c = i2;
        this.f9112b = z;
        this.f9114d = z2;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.f9112b) {
            textPaint.setColor(this.f9113c);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        if (this.f9115e) {
            textPaint.bgColor = this.f9111a;
        } else {
            textPaint.bgColor = 0;
        }
        if (this.f9114d) {
            textPaint.setUnderlineText(true);
        }
    }

    @Override // com.twitter.sdk.android.tweetui.internal.HighlightedClickableSpan
    /* renamed from: a */
    public void mo8900a(boolean z) {
        this.f9115e = z;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.HighlightedClickableSpan
    /* renamed from: a */
    public boolean mo8901a() {
        return this.f9115e;
    }
}