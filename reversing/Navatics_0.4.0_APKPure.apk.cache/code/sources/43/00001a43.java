package com.navatics.app.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class PitchView extends View {

    /* renamed from: a */
    private Paint f5482a;

    /* renamed from: b */
    private Paint f5483b;

    /* renamed from: c */
    private Paint f5484c;

    /* renamed from: d */
    private Matrix f5485d;

    /* renamed from: e */
    private float[] f5486e;

    /* renamed from: f */
    private Bitmap f5487f;

    /* renamed from: g */
    private float f5488g;

    /* renamed from: h */
    private RectF f5489h;

    public PitchView(Context context) {
        super(context);
        this.f5485d = new Matrix();
        this.f5486e = new float[9];
        this.f5489h = new RectF();
        m5752a();
    }

    public PitchView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5485d = new Matrix();
        this.f5486e = new float[9];
        this.f5489h = new RectF();
        m5752a();
    }

    public PitchView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5485d = new Matrix();
        this.f5486e = new float[9];
        this.f5489h = new RectF();
        m5752a();
    }

    /* renamed from: a */
    private void m5752a() {
        this.f5482a = new Paint();
        this.f5482a.setAntiAlias(true);
        this.f5482a.setColor(-2130706433);
        this.f5482a.setStyle(Paint.Style.STROKE);
        this.f5483b = new Paint();
        this.f5482a.setAntiAlias(true);
        this.f5483b.setColor(-1);
        this.f5483b.setStrokeWidth(7.0f);
        this.f5483b.setStyle(Paint.Style.STROKE);
        this.f5484c = new Paint();
        this.f5484c.setColor(SupportMenu.CATEGORY_MASK);
        this.f5484c.setStrokeWidth(7.0f);
        this.f5484c.setStyle(Paint.Style.STROKE);
        this.f5487f = BitmapFactory.decodeResource(getResources(), R.drawable.mito2);
    }

    public void setPitchRadian(float f) {
        this.f5488g = f;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float height = getHeight() / 2;
        canvas.drawCircle(height, height, getHeight() / 2, this.f5482a);
        float f = 2.0f * height;
        this.f5489h.set(0.0f, 0.0f, f, f);
        canvas.drawArc(this.f5489h, -45.0f, 90.0f, false, this.f5483b);
        float[] fArr = this.f5486e;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        this.f5485d.setValues(fArr);
        this.f5485d.preTranslate(height - (this.f5487f.getWidth() / 2), height - (this.f5487f.getHeight() / 2));
        this.f5485d.preRotate((float) (-Math.toDegrees(-this.f5488g)), this.f5487f.getWidth() / 2, this.f5487f.getHeight() / 2);
        canvas.drawBitmap(this.f5487f, this.f5485d, null);
    }
}