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
    private int f5188a;

    /* renamed from: b */
    private int f5189b;

    /* renamed from: c */
    private int f5190c;

    /* renamed from: d */
    private Paint f5191d;

    /* renamed from: e */
    private int f5192e;

    public CircleImage(Context context) {
        super(context);
        this.f5192e = -7829368;
        m5532a(context, null);
    }

    public CircleImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5192e = -7829368;
        m5532a(context, attributeSet);
    }

    public CircleImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5192e = -7829368;
        m5532a(context, attributeSet);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(this.f5189b, this.f5188a, this.f5190c, this.f5191d);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5189b = i / 2;
        this.f5188a = i2 / 2;
        this.f5190c = Math.min(i, i2) / 2;
    }

    public void setColor(int i) {
        this.f5192e = i;
        this.f5191d.setColor(this.f5192e);
        invalidate();
    }

    /* renamed from: a */
    private void m5532a(Context context, AttributeSet attributeSet) {
        this.f5191d = new Paint(1);
        this.f5191d.setStyle(Paint.Style.FILL);
        int i = this.f5192e;
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