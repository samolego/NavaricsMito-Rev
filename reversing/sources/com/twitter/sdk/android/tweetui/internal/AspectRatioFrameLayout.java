package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.twitter.sdk.android.tweetui.R;

/* loaded from: classes2.dex */
public class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: a */
    protected double f8970a;

    /* renamed from: b */
    private int f8971b;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4060a(i);
    }

    /* renamed from: a */
    private void m4060a(int i) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(i, R.styleable.AspectRatioFrameLayout);
        try {
            this.f8970a = obtainStyledAttributes.getFloat(R.styleable.AspectRatioFrameLayout_tw__frame_layout_aspect_ratio, 1.0f);
            this.f8971b = obtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_tw__frame_layout_dimension_to_adjust, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setAspectRatio(double d) {
        this.f8970a = d;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f8971b == 0) {
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                i3 = View.MeasureSpec.getSize(i) - paddingLeft;
            } else {
                super.onMeasure(i, i2);
                i3 = getMeasuredWidth() - paddingLeft;
            }
            measuredHeight = (int) (i3 / this.f8970a);
        } else {
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                measuredHeight = View.MeasureSpec.getSize(i2) - paddingBottom;
            } else {
                super.onMeasure(i, i2);
                measuredHeight = getMeasuredHeight() - paddingBottom;
            }
            i3 = (int) (measuredHeight * this.f8970a);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3 + paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight + paddingBottom, 1073741824));
    }
}
