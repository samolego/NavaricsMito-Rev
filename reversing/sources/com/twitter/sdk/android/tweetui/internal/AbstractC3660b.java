package com.twitter.sdk.android.tweetui.internal;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

/* renamed from: com.twitter.sdk.android.tweetui.internal.b */
/* loaded from: classes2.dex */
public abstract class ClickableLinkSpan extends ClickableSpan implements HighlightedClickableSpan {

    /* renamed from: a */
    private final int f9071a;

    /* renamed from: b */
    private final boolean f9072b;

    /* renamed from: c */
    public final int f9073c;

    /* renamed from: d */
    private final boolean f9074d;

    /* renamed from: e */
    private boolean f9075e;

    public ClickableLinkSpan(int i, int i2, boolean z) {
        this(i, i2, true, z);
    }

    ClickableLinkSpan(int i, int i2, boolean z, boolean z2) {
        this.f9071a = i;
        this.f9073c = i2;
        this.f9072b = z;
        this.f9074d = z2;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.f9072b) {
            textPaint.setColor(this.f9073c);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        if (this.f9075e) {
            textPaint.bgColor = this.f9071a;
        } else {
            textPaint.bgColor = 0;
        }
        if (this.f9074d) {
            textPaint.setUnderlineText(true);
        }
    }

    @Override // com.twitter.sdk.android.tweetui.internal.HighlightedClickableSpan
    /* renamed from: a */
    public void mo3955a(boolean z) {
        this.f9075e = z;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.HighlightedClickableSpan
    /* renamed from: a */
    public boolean mo3956a() {
        return this.f9075e;
    }
}
