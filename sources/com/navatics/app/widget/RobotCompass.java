package com.navatics.app.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.Nullable;
import android.support.p008v4.internal.view.SupportMenu;
import android.support.p008v4.view.InputDeviceCompat;
import android.util.AttributeSet;
import android.view.View;
import com.navatics.app.R;
import com.navatics.robot.utils.DpiUtils;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class RobotCompass extends View implements SensorEventListener {

    /* renamed from: a */
    private static final C3044k f5477a = C3044k.m1564a(RobotCompass.class);

    /* renamed from: A */
    private float f5478A;

    /* renamed from: B */
    private SensorManager f5479B;

    /* renamed from: b */
    private Paint f5480b;

    /* renamed from: c */
    private Paint f5481c;

    /* renamed from: d */
    private Paint f5482d;

    /* renamed from: e */
    private Paint f5483e;

    /* renamed from: f */
    private Paint f5484f;

    /* renamed from: g */
    private Paint f5485g;

    /* renamed from: h */
    private Paint f5486h;

    /* renamed from: i */
    private Sensor f5487i;

    /* renamed from: j */
    private Sensor f5488j;

    /* renamed from: k */
    private float[] f5489k;

    /* renamed from: l */
    private float[] f5490l;

    /* renamed from: m */
    private float[] f5491m;

    /* renamed from: n */
    private float[] f5492n;

    /* renamed from: o */
    private float f5493o;

    /* renamed from: p */
    private Bitmap f5494p;

    /* renamed from: q */
    private Matrix f5495q;

    /* renamed from: r */
    private float[] f5496r;

    /* renamed from: s */
    private Bitmap f5497s;

    /* renamed from: t */
    private Bitmap f5498t;

    /* renamed from: u */
    private Matrix f5499u;

    /* renamed from: v */
    private Matrix f5500v;

    /* renamed from: w */
    private float[] f5501w;

    /* renamed from: x */
    private float[] f5502x;

    /* renamed from: y */
    private float f5503y;

    /* renamed from: z */
    private float f5504z;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public RobotCompass(Context context) {
        super(context);
        this.f5489k = new float[3];
        this.f5490l = new float[3];
        this.f5491m = new float[3];
        this.f5492n = new float[9];
        this.f5495q = new Matrix();
        this.f5496r = new float[9];
        this.f5499u = new Matrix();
        this.f5500v = new Matrix();
        this.f5501w = new float[9];
        this.f5502x = new float[9];
        m7107a();
    }

    public RobotCompass(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5489k = new float[3];
        this.f5490l = new float[3];
        this.f5491m = new float[3];
        this.f5492n = new float[9];
        this.f5495q = new Matrix();
        this.f5496r = new float[9];
        this.f5499u = new Matrix();
        this.f5500v = new Matrix();
        this.f5501w = new float[9];
        this.f5502x = new float[9];
        m7107a();
    }

    public RobotCompass(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5489k = new float[3];
        this.f5490l = new float[3];
        this.f5491m = new float[3];
        this.f5492n = new float[9];
        this.f5495q = new Matrix();
        this.f5496r = new float[9];
        this.f5499u = new Matrix();
        this.f5500v = new Matrix();
        this.f5501w = new float[9];
        this.f5502x = new float[9];
        m7107a();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m7104d();
    }

    /* renamed from: a */
    private void m7107a() {
        this.f5480b = new Paint();
        this.f5480b.setAntiAlias(true);
        this.f5480b.setColor(-2130706433);
        this.f5480b.setStyle(Paint.Style.STROKE);
        this.f5481c = new Paint();
        this.f5481c.setAntiAlias(true);
        this.f5481c.setColor(-2130706433);
        this.f5481c.setStyle(Paint.Style.STROKE);
        this.f5482d = new Paint();
        this.f5482d.setColor(Integer.MIN_VALUE);
        this.f5482d.setStyle(Paint.Style.FILL);
        this.f5485g = new Paint();
        this.f5485g.setColor(-2145062657);
        this.f5485g.setStyle(Paint.Style.STROKE);
        this.f5483e = new Paint();
        this.f5483e.setColor(-1);
        this.f5483e.setStyle(Paint.Style.STROKE);
        this.f5484f = new Paint();
        this.f5484f.setColor(InputDeviceCompat.SOURCE_ANY);
        this.f5484f.setStyle(Paint.Style.STROKE);
        this.f5486h = new Paint();
        this.f5486h.setColor(SupportMenu.CATEGORY_MASK);
        this.f5494p = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_mito);
        this.f5497s = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_red);
        this.f5498t = BitmapFactory.decodeResource(getResources(), R.drawable.n);
        m7106b();
        m7105c();
    }

    /* renamed from: b */
    private void m7106b() {
        this.f5479B = (SensorManager) getContext().getSystemService("sensor");
        this.f5487i = this.f5479B.getDefaultSensor(1);
        this.f5488j = this.f5479B.getDefaultSensor(2);
    }

    /* renamed from: c */
    private void m7105c() {
        this.f5479B.registerListener(this, this.f5487i, 3);
        this.f5479B.registerListener(this, this.f5488j, 3);
    }

    /* renamed from: d */
    private void m7104d() {
        SensorManager sensorManager = this.f5479B;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public void setRobotRadian(float f) {
        this.f5504z = f;
        postInvalidate();
    }

    public void setRobotRefRadian(float f) {
        this.f5478A = f;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float m5887a;
        super.onDraw(canvas);
        float m5887a2 = DpiUtils.m5887a(getContext(), 44.0f);
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        canvas.drawCircle(width, height, m5887a2, this.f5482d);
        canvas.drawLine(width, height, width, height - m5887a2, this.f5485g);
        canvas.drawLine(width, height, width, height + m5887a2, this.f5485g);
        canvas.drawLine(width, height, width - m5887a2, height, this.f5485g);
        canvas.drawLine(width, height, width + m5887a2, height, this.f5485g);
        canvas.drawCircle(width, height, m5887a2, this.f5480b);
        canvas.drawCircle(width, height, m5887a2 * 0.7f, this.f5481c);
        float[] fArr = this.f5496r;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        this.f5495q.setValues(fArr);
        this.f5495q.preTranslate(width - (this.f5494p.getWidth() / 2), height - (this.f5494p.getHeight() / 2));
        this.f5495q.preRotate(-90.0f, this.f5494p.getWidth() / 2, this.f5494p.getHeight() / 2);
        this.f5495q.preRotate(-((float) Math.toDegrees(this.f5503y)), this.f5494p.getWidth() / 2, this.f5494p.getHeight() / 2);
        this.f5495q.preRotate((float) Math.toDegrees(this.f5504z), this.f5494p.getWidth() / 2, this.f5494p.getHeight() / 2);
        canvas.drawBitmap(this.f5494p, this.f5495q, null);
        float[] fArr2 = this.f5501w;
        fArr2[0] = 1.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 0.0f;
        fArr2[3] = 0.0f;
        fArr2[4] = 1.0f;
        fArr2[5] = 0.0f;
        fArr2[6] = 0.0f;
        fArr2[7] = 0.0f;
        fArr2[8] = 1.0f;
        this.f5499u.setValues(fArr2);
        this.f5499u.preTranslate(width - (this.f5497s.getWidth() / 2), height - (this.f5497s.getHeight() / 2));
        this.f5499u.preRotate(180.0f, this.f5497s.getWidth() / 2, this.f5497s.getHeight() / 2);
        this.f5499u.preRotate(-((float) Math.toDegrees(this.f5503y)), this.f5497s.getWidth() / 2, this.f5497s.getHeight() / 2);
        this.f5499u.postTranslate((float) ((-f) * Math.cos(-this.f5503y)), (float) ((m5887a2 - 12.0f) * Math.sin(this.f5503y)));
        canvas.drawBitmap(this.f5497s, this.f5499u, null);
        float[] fArr3 = this.f5502x;
        fArr3[0] = 1.0f;
        fArr3[1] = 0.0f;
        fArr3[2] = 0.0f;
        fArr3[3] = 0.0f;
        fArr3[4] = 1.0f;
        fArr3[5] = 0.0f;
        fArr3[6] = 0.0f;
        fArr3[7] = 0.0f;
        fArr3[8] = 1.0f;
        this.f5500v.setValues(fArr3);
        this.f5500v.preTranslate(width - (this.f5498t.getWidth() / 2.0f), height - (this.f5498t.getHeight() / 2.0f));
        this.f5500v.postTranslate((float) ((-m5887a) * Math.cos(-this.f5503y)), (float) ((m5887a2 + DpiUtils.m5887a(getContext(), 10.0f)) * Math.sin(this.f5503y)));
        canvas.drawBitmap(this.f5498t, this.f5500v, null);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            this.f5489k = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.f5490l = sensorEvent.values;
        }
        SensorManager.getRotationMatrix(this.f5492n, null, this.f5489k, this.f5490l);
        SensorManager.getOrientation(this.f5492n, this.f5491m);
        synchronized (this) {
            this.f5503y = this.f5491m[0];
            this.f5493o = (float) Math.toDegrees(this.f5491m[0]);
        }
        postInvalidate();
    }
}
