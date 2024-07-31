package com.yanzhenjie.sofia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public class FitWindowLayout extends ViewGroup {
    public FitWindowLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), View.MeasureSpec.getMode(i));
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), View.MeasureSpec.getMode(i2));
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            childAt.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 += childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            int measuredHeight = childAt.getMeasuredHeight() + i6;
            childAt.layout(i, i6, i3, measuredHeight);
            i5++;
            i6 = measuredHeight;
        }
    }
}