package com.yanzhenjie.sofia;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
public class StatusView extends View {

    /* renamed from: a */
    private int f9294a;

    public StatusView(Context context) {
        this(context, null, 0);
    }

    public StatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = getResources();
        this.f9294a = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), this.f9294a);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public int getBarSize() {
        return this.f9294a;
    }
}
