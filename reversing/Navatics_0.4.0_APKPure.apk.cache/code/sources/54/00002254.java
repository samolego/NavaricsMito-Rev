package com.twitter.sdk.android.tweetui.internal;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* compiled from: SpanClickHandler.java */
/* renamed from: com.twitter.sdk.android.tweetui.internal.e, reason: use source file name */
/* loaded from: classes2.dex */
public class SpanClickHandler {

    /* renamed from: a */
    private final View f9116a;

    /* renamed from: b */
    private Layout f9117b;

    /* renamed from: c */
    private float f9118c;

    /* renamed from: d */
    private float f9119d;

    /* renamed from: e */
    private HighlightedClickableSpan f9120e;

    /* renamed from: a */
    public static void m8906a(TextView textView) {
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.twitter.sdk.android.tweetui.internal.e.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Layout layout = ((TextView) view).getLayout();
                if (layout == null) {
                    return false;
                }
                SpanClickHandler.this.f9117b = layout;
                SpanClickHandler.this.f9118c = r4.getTotalPaddingLeft() + r4.getScrollX();
                SpanClickHandler.this.f9119d = r4.getTotalPaddingTop() + r4.getScrollY();
                return SpanClickHandler.this.m8910a(motionEvent);
            }
        });
    }

    public SpanClickHandler(View view, Layout layout) {
        this.f9116a = view;
        this.f9117b = layout;
    }

    /* renamed from: a */
    public boolean m8910a(MotionEvent motionEvent) {
        HighlightedClickableSpan highlightedClickableSpan;
        CharSequence text = this.f9117b.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) (motionEvent.getX() - this.f9118c);
        int y = (int) (motionEvent.getY() - this.f9119d);
        if (x < 0 || x >= this.f9117b.getWidth() || y < 0 || y >= this.f9117b.getHeight()) {
            m8905a();
            return false;
        }
        int lineForVertical = this.f9117b.getLineForVertical(y);
        float f = x;
        if (f < this.f9117b.getLineLeft(lineForVertical) || f > this.f9117b.getLineRight(lineForVertical)) {
            m8905a();
            return false;
        }
        if (action == 0) {
            int offsetForHorizontal = this.f9117b.getOffsetForHorizontal(lineForVertical, f);
            HighlightedClickableSpan[] highlightedClickableSpanArr = (HighlightedClickableSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, HighlightedClickableSpan.class);
            if (highlightedClickableSpanArr.length > 0) {
                m8907a(highlightedClickableSpanArr[0]);
                return true;
            }
        } else if (action == 1 && (highlightedClickableSpan = this.f9120e) != null) {
            highlightedClickableSpan.onClick(this.f9116a);
            m8905a();
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m8907a(HighlightedClickableSpan highlightedClickableSpan) {
        highlightedClickableSpan.mo8900a(true);
        this.f9120e = highlightedClickableSpan;
        m8909b();
    }

    /* renamed from: a */
    private void m8905a() {
        HighlightedClickableSpan highlightedClickableSpan = this.f9120e;
        if (highlightedClickableSpan == null || !highlightedClickableSpan.mo8901a()) {
            return;
        }
        highlightedClickableSpan.mo8900a(false);
        this.f9120e = null;
        m8909b();
    }

    /* renamed from: b */
    private void m8909b() {
        View view = this.f9116a;
        float f = this.f9118c;
        view.invalidate((int) f, (int) this.f9119d, ((int) f) + this.f9117b.getWidth(), ((int) this.f9119d) + this.f9117b.getHeight());
    }
}