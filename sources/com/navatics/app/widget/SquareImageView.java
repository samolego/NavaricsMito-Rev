package com.navatics.app.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.p011v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class SquareImageView extends AppCompatImageView {
    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
