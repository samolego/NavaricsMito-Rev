package com.navatics.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class InfoHoverView extends RelativeLayout {

    /* renamed from: a */
    private static final C3044k f5277a = C3044k.m1564a(InfoHoverView.class);

    public InfoHoverView(Context context) {
        super(context);
    }

    public InfoHoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InfoHoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i2) * 4.0f) / 3.0f), Integer.MIN_VALUE), i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        C3044k c3044k = f5277a;
        c3044k.mo1511a((Object) ("hoverViewWidth " + measuredWidth + ", hoverViewHeight " + measuredHeight));
    }
}
