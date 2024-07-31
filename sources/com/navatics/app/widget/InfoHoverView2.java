package com.navatics.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class InfoHoverView2 extends RelativeLayout {

    /* renamed from: a */
    private static final C3044k f5278a = C3044k.m1564a(InfoHoverView2.class);

    public InfoHoverView2(Context context) {
        super(context);
    }

    public InfoHoverView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InfoHoverView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        ContentLayout contentLayout = (ContentLayout) getParent();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(contentLayout.getMeasuredInfoWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(contentLayout.getMeasuredInfoHeight(), 1073741824));
        getMeasuredWidth();
        getMeasuredHeight();
    }
}