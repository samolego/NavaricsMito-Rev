package com.navatics.app.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.p008v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class PitchView extends View {

    /* renamed from: a */
    private Paint f5460a;

    /* renamed from: b */
    private Paint f5461b;

    /* renamed from: c */
    private Paint f5462c;

    /* renamed from: d */
    private Matrix f5463d;

    /* renamed from: e */
    private float[] f5464e;

    /* renamed from: f */
    private Bitmap f5465f;

    /* renamed from: g */
    private float f5466g;

    /* renamed from: h */
    private RectF f5467h;

    public PitchView(Context context) {
        super(context);
        this.f5463d = new Matrix();
        this.f5464e = new float[9];
        this.f5467h = new RectF();
        m7116a();
    }

    public PitchView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5463d = new Matrix();
        this.f5464e = new float[9];
        this.f5467h = new RectF();
        m7116a();
    }

    public PitchView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5463d = new Matrix();
        this.f5464e = new float[9];
        this.f5467h = new RectF();
        m7116a();
    }

    /* renamed from: a */
    private void m7116a() {
        this.f5460a = new Paint();
        this.f5460a.setAntiAlias(true);
        this.f5460a.setColor(-2130706433);
        this.f5460a.setStyle(Paint.Style.STROKE);
        this.f5461b = new Paint();
        this.f5460a.setAntiAlias(true);
        this.f5461b.setColor(-1);
        this.f5461b.setStrokeWidth(7.0f);
        this.f5461b.setStyle(Paint.Style.STROKE);
        this.f5462c = new Paint();
        this.f5462c.setColor(SupportMenu.CATEGORY_MASK);
        this.f5462c.setStrokeWidth(7.0f);
        this.f5462c.setStyle(Paint.Style.STROKE);
        this.f5465f = BitmapFactory.decodeResource(getResources(), R.drawable.mito2);
    }

    public void setPitchRadian(float f) {
        this.f5466g = f;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float height = getHeight() / 2;
        canvas.drawCircle(height, height, getHeight() / 2, this.f5460a);
        float f = 2.0f * height;
        this.f5467h.set(0.0f, 0.0f, f, f);
        canvas.drawArc(this.f5467h, -45.0f, 90.0f, false, this.f5461b);
        float[] fArr = this.f5464e;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        this.f5463d.setValues(fArr);
        this.f5463d.preTranslate(height - (this.f5465f.getWidth() / 2), height - (this.f5465f.getHeight() / 2));
        this.f5463d.preRotate((float) (-Math.toDegrees(-this.f5466g)), this.f5465f.getWidth() / 2, this.f5465f.getHeight() / 2);
        canvas.drawBitmap(this.f5465f, this.f5463d, null);
    }
}
