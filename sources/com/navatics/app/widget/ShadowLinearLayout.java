package com.navatics.app.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.p008v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ShadowLinearLayout extends LinearLayout {
    public ShadowLinearLayout(Context context) {
        super(context);
        m7099a(context, null);
    }

    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m7099a(context, attributeSet);
    }

    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7099a(context, attributeSet);
    }

    /* renamed from: a */
    private void m7099a(Context context, AttributeSet attributeSet) {
        ShadowDrawable m6955a = ShadowDrawable.m6955a(context, attributeSet);
        setLayerType(1, null);
        ViewCompat.setBackground(this, m6955a);
    }
}
