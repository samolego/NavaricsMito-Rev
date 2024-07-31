package com.navatics.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class CircleImage extends View {

    /* renamed from: a */
    private int f5166a;

    /* renamed from: b */
    private int f5167b;

    /* renamed from: c */
    private int f5168c;

    /* renamed from: d */
    private Paint f5169d;

    /* renamed from: e */
    private int f5170e;

    public CircleImage(Context context) {
        super(context);
        this.f5170e = -7829368;
        m7347a(context, null);
    }

    public CircleImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5170e = -7829368;
        m7347a(context, attributeSet);
    }

    public CircleImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5170e = -7829368;
        m7347a(context, attributeSet);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(this.f5167b, this.f5166a, this.f5168c, this.f5169d);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5167b = i / 2;
        this.f5166a = i2 / 2;
        this.f5168c = Math.min(i, i2) / 2;
    }

    public void setColor(int i) {
        this.f5170e = i;
        this.f5169d.setColor(this.f5170e);
        invalidate();
    }

    /* renamed from: a */
    private void m7347a(Context context, AttributeSet attributeSet) {
        this.f5169d = new Paint(1);
        this.f5169d.setStyle(Paint.Style.FILL);
        int i = this.f5170e;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImage);
            i = obtainStyledAttributes.getColor(0, i);
            obtainStyledAttributes.recycle();
        }
        setColor(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        setColor(i);
    }
}
