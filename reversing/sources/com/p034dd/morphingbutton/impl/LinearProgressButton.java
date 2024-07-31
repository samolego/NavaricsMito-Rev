package com.p034dd.morphingbutton.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.p034dd.morphingbutton.MorphingButton;

/* renamed from: com.dd.morphingbutton.impl.LinearProgressButton */
/* loaded from: classes.dex */
public class LinearProgressButton extends MorphingButton {

    /* renamed from: b */
    private int f1392b;

    /* renamed from: c */
    private int f1393c;

    /* renamed from: d */
    private int f1394d;

    /* renamed from: e */
    private Paint f1395e;

    /* renamed from: f */
    private RectF f1396f;

    public LinearProgressButton(Context context) {
        super(context);
    }

    public LinearProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinearProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.f1317a || (i = this.f1392b) <= 0 || i > 100) {
            return;
        }
        if (this.f1395e == null) {
            this.f1395e = new Paint();
            this.f1395e.setAntiAlias(true);
            this.f1395e.setStyle(Paint.Style.FILL);
            this.f1395e.setColor(this.f1393c);
        }
        if (this.f1396f == null) {
            this.f1396f = new RectF();
        }
        this.f1396f.right = (getWidth() / 100) * this.f1392b;
        this.f1396f.bottom = getHeight();
        RectF rectF = this.f1396f;
        int i2 = this.f1394d;
        canvas.drawRoundRect(rectF, i2, i2, this.f1395e);
    }

    @Override // com.p034dd.morphingbutton.MorphingButton
    /* renamed from: a */
    public void mo11488a(@NonNull MorphingButton.C0799b c0799b) {
        super.mo11488a(c0799b);
        this.f1392b = 0;
        this.f1395e = null;
        this.f1396f = null;
    }

    public void setProgress(int i) {
        this.f1392b = i;
        invalidate();
    }
}
