package com.navatics.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.p011v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.navatics.app.R;
import com.navatics.robot.utils.DpiUtils;

/* loaded from: classes.dex */
public class MaxWidthRecyclerView extends RecyclerView {

    /* renamed from: a */
    private float f5285a;

    public MaxWidthRecyclerView(Context context) {
        super(context);
    }

    public MaxWidthRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m7248a(context, attributeSet);
    }

    public MaxWidthRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7248a(context, attributeSet);
    }

    /* renamed from: a */
    private void m7248a(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxWidthRecyclerView);
        this.f5285a = obtainStyledAttributes.getDimension(0, DpiUtils.m5887a(getContext(), 120.0f));
        Log.d("MaxWidthRecyclerView", "maxWidth= " + this.f5285a);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) this.f5285a, Integer.MIN_VALUE), i2);
    }
}
