package com.twitter.sdk.android.tweetui.internal;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* renamed from: com.twitter.sdk.android.tweetui.internal.e */
/* loaded from: classes2.dex */
public class SpanClickHandler {

    /* renamed from: a */
    private final View f9076a;

    /* renamed from: b */
    private Layout f9077b;

    /* renamed from: c */
    private float f9078c;

    /* renamed from: d */
    private float f9079d;

    /* renamed from: e */
    private HighlightedClickableSpan f9080e;

    /* renamed from: a */
    public static void m3951a(TextView textView) {
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.twitter.sdk.android.tweetui.internal.e.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                TextView textView2 = (TextView) view;
                Layout layout = textView2.getLayout();
                if (layout != null) {
                    SpanClickHandler.this.f9077b = layout;
                    SpanClickHandler.this.f9078c = textView2.getTotalPaddingLeft() + textView2.getScrollX();
                    SpanClickHandler.this.f9079d = textView2.getTotalPaddingTop() + textView2.getScrollY();
                    return SpanClickHandler.this.m3952a(motionEvent);
                }
                return false;
            }
        });
    }

    public SpanClickHandler(View view, Layout layout) {
        this.f9076a = view;
        this.f9077b = layout;
    }

    /* renamed from: a */
    public boolean m3952a(MotionEvent motionEvent) {
        HighlightedClickableSpan highlightedClickableSpan;
        CharSequence text = this.f9077b.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) (motionEvent.getX() - this.f9078c);
        int y = (int) (motionEvent.getY() - this.f9079d);
        if (x < 0 || x >= this.f9077b.getWidth() || y < 0 || y >= this.f9077b.getHeight()) {
            m3953a();
            return false;
        }
        int lineForVertical = this.f9077b.getLineForVertical(y);
        float f = x;
        if (f < this.f9077b.getLineLeft(lineForVertical) || f > this.f9077b.getLineRight(lineForVertical)) {
            m3953a();
            return false;
        }
        if (action == 0) {
            int offsetForHorizontal = this.f9077b.getOffsetForHorizontal(lineForVertical, f);
            HighlightedClickableSpan[] highlightedClickableSpanArr = (HighlightedClickableSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, HighlightedClickableSpan.class);
            if (highlightedClickableSpanArr.length > 0) {
                m3950a(highlightedClickableSpanArr[0]);
                return true;
            }
        } else if (action == 1 && (highlightedClickableSpan = this.f9080e) != null) {
            highlightedClickableSpan.onClick(this.f9076a);
            m3953a();
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m3950a(HighlightedClickableSpan highlightedClickableSpan) {
        highlightedClickableSpan.mo3955a(true);
        this.f9080e = highlightedClickableSpan;
        m3947b();
    }

    /* renamed from: a */
    private void m3953a() {
        HighlightedClickableSpan highlightedClickableSpan = this.f9080e;
        if (highlightedClickableSpan == null || !highlightedClickableSpan.mo3956a()) {
            return;
        }
        highlightedClickableSpan.mo3955a(false);
        this.f9080e = null;
        m3947b();
    }

    /* renamed from: b */
    private void m3947b() {
        View view = this.f9076a;
        float f = this.f9078c;
        view.invalidate((int) f, (int) this.f9079d, ((int) f) + this.f9077b.getWidth(), ((int) this.f9079d) + this.f9077b.getHeight());
    }
}
