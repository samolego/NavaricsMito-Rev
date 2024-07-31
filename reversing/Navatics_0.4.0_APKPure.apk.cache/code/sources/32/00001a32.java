package com.navatics.app.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/* loaded from: classes.dex */
public class NvTestView extends View {

    /* renamed from: a */
    private int f5433a;

    /* renamed from: b */
    private int f5434b;

    /* renamed from: c */
    private int f5435c;

    /* renamed from: d */
    private int f5436d;

    /* renamed from: e */
    private int f5437e;

    public NvTestView(Context context) {
        super(context);
        this.f5437e = 0;
    }

    public NvTestView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5437e = 0;
    }

    public NvTestView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5437e = 0;
    }

    public void setAspectRatio(int i) {
        this.f5437e = i;
        Log.d("NvTestView", "setAspectRatio requestLayout");
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        float f;
        int i4;
        int defaultSize = View.getDefaultSize(this.f5433a, i);
        int defaultSize2 = View.getDefaultSize(this.f5434b, i2);
        if (defaultSize < defaultSize2) {
            Log.e("NvTestView", "wtf ??? width < height detected.");
        }
        Log.d("NvTestView", "width " + defaultSize + ", height " + defaultSize2);
        int i5 = this.f5437e;
        if (i5 == 3) {
            defaultSize2 = i2;
        } else {
            int i6 = this.f5433a;
            if (i6 <= 0 || (i3 = this.f5434b) <= 0) {
                i = defaultSize;
            } else {
                switch (i5) {
                    case 4:
                        f = 1.7777778f;
                        break;
                    case 5:
                        f = 1.3333334f;
                        break;
                    default:
                        f = i6 / i3;
                        int i7 = this.f5435c;
                        if (i7 > 0 && (i4 = this.f5436d) > 0) {
                            f = (f * i7) / i4;
                            break;
                        }
                        break;
                }
                Log.d("NvTestView", "displayAspectRatio " + f);
                float f2 = ((float) defaultSize2) * f;
                if (f2 < defaultSize) {
                    Log.e("NvTestView", "widthNeeded " + f2 + ", but we only have " + defaultSize);
                }
                i = (int) f2;
            }
        }
        Log.d("NvTestView", "setMeasuredDimension, width " + i + ", height " + defaultSize2);
        setMeasuredDimension(i, defaultSize2);
    }
}