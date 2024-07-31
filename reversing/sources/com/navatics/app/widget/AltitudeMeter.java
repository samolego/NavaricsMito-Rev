package com.navatics.app.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.navatics.app.R;
import com.navatics.robot.utils.DpiUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class AltitudeMeter extends View {

    /* renamed from: a */
    private static final C3044k f5145a = C3044k.m1564a(AltitudeMeter.class);

    /* renamed from: b */
    private static float f5146b = 2.0f;

    /* renamed from: c */
    private Bitmap f5147c;

    /* renamed from: d */
    private Bitmap f5148d;

    /* renamed from: e */
    private double f5149e;

    /* renamed from: f */
    private double f5150f;

    /* renamed from: g */
    private double f5151g;

    /* renamed from: h */
    private double f5152h;

    /* renamed from: i */
    private String f5153i;

    /* renamed from: j */
    private Paint f5154j;

    /* renamed from: k */
    private Paint f5155k;

    /* renamed from: l */
    private int f5156l;

    /* renamed from: m */
    private int f5157m;

    /* renamed from: n */
    private int f5158n;

    /* renamed from: o */
    private int f5159o;

    /* renamed from: p */
    private int f5160p;

    /* renamed from: q */
    private int f5161q;

    /* renamed from: r */
    private float f5162r;

    /* renamed from: s */
    private IndicatorInfo f5163s;

    /* renamed from: t */
    private IndicatorInfo f5164t;

    /* renamed from: u */
    private List<DrawElemInfo> f5165u;

    public AltitudeMeter(Context context) {
        super(context);
        this.f5151g = 0.5d;
        this.f5156l = 13;
        this.f5165u = new ArrayList();
        m7352a();
    }

    public AltitudeMeter(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5151g = 0.5d;
        this.f5156l = 13;
        this.f5165u = new ArrayList();
        m7352a();
    }

    public AltitudeMeter(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5151g = 0.5d;
        this.f5156l = 13;
        this.f5165u = new ArrayList();
        m7352a();
    }

    /* renamed from: a */
    private void m7352a() {
        this.f5154j = new Paint();
        this.f5154j.setColor(-1);
        this.f5154j.setStyle(Paint.Style.FILL);
        this.f5162r = DpiUtils.m5886b(getContext(), 12.0f);
        this.f5155k = new Paint();
        this.f5155k.setColor(-1);
        this.f5155k.setStyle(Paint.Style.FILL);
        this.f5155k.setTextSize(this.f5162r);
        this.f5157m = DpiUtils.m5887a(getContext(), this.f5156l);
        this.f5158n = DpiUtils.m5887a(getContext(), 2.0f);
        this.f5159o = DpiUtils.m5887a(getContext(), 3.0f);
        this.f5160p = DpiUtils.m5887a(getContext(), 1.0f);
        this.f5161q = DpiUtils.m5887a(getContext(), 7.0f);
        this.f5149e = 0.25d;
        double d = this.f5149e;
        this.f5152h = d - m7351a(d, this.f5151g);
        this.f5153i = String.format(Locale.getDefault(), "%.1fm", Double.valueOf(this.f5152h));
        this.f5150f = 1.75d;
        if (this.f5147c == null) {
            this.f5147c = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_red);
        }
        if (this.f5148d == null) {
            this.f5148d = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_yellow);
        }
        this.f5163s = IndicatorInfo.m7029a(this.f5147c);
        this.f5164t = IndicatorInfo.m7029a(this.f5148d);
    }

    public void setCurrentDepthIndicator(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        if (decodeResource != null) {
            this.f5163s.m7028b(decodeResource);
        }
    }

    public void setTargetDepthIndicator(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        if (decodeResource != null) {
            this.f5164t.m7028b(decodeResource);
        }
    }

    public void setCurrentDepth(double d) {
        this.f5149e = d;
        double d2 = this.f5149e;
        this.f5152h = (int) (d2 - m7351a(d2, this.f5151g));
        this.f5153i = String.format(Locale.getDefault(), "%fm", Double.valueOf(this.f5152h));
    }

    public void setTargetDepth(double d) {
        this.f5150f = d;
    }

    /* renamed from: a */
    private double m7351a(double d, double d2) {
        double pow;
        return ((((int) (d * pow)) % ((int) (d2 * pow))) * 1.0d) / ((int) Math.pow(10.0d, f5146b));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m7348b();
        m7349a(canvas);
        for (DrawElemInfo drawElemInfo : this.f5165u) {
            drawElemInfo.mo6919b();
        }
        this.f5165u.clear();
        postInvalidate();
    }

    /* renamed from: b */
    private void m7348b() {
        float f;
        double d;
        float height = getHeight() / 2;
        boolean z = m7351a(this.f5149e, this.f5151g * 2.0d) < this.f5151g;
        this.f5163s.m7030a(0.0f, height - (this.f5147c.getHeight() / 2));
        int m7351a = (int) ((m7351a(this.f5149e, this.f5151g) / this.f5151g) * this.f5157m);
        float width = this.f5147c.getWidth() + DpiUtils.m5887a(getContext(), 6.0f);
        if (z) {
            f = (height - m7351a) - this.f5160p;
        } else {
            f = (height - m7351a) - this.f5158n;
        }
        if (z) {
            this.f5165u.add(TickInfo.m6920a(width, f, width + this.f5161q, f + this.f5160p, true, this.f5152h));
            this.f5165u.add(TextInfo.m6925a(DpiUtils.m5887a(getContext(), 28.0f), 15.0f + f, this.f5152h));
        } else {
            this.f5165u.add(TickInfo.m6920a(width, f, width + this.f5159o, f + this.f5158n, false, this.f5152h));
        }
        m7350a(width, f, 1, z);
        m7350a(width, f, 0, z);
        for (DrawElemInfo drawElemInfo : this.f5165u) {
            if (drawElemInfo instanceof TickInfo) {
                TickInfo tickInfo = (TickInfo) drawElemInfo;
                double m6914g = tickInfo.m6914g();
                double d2 = this.f5150f;
                if (m6914g < d2) {
                    if (m6914g + this.f5151g > d2) {
                        this.f5164t.m7030a(0.0f, (tickInfo.m6915f() + ((int) ((m7351a(d2, d) / this.f5151g) * this.f5157m))) - (this.f5148d.getHeight() / 2));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m7349a(Canvas canvas) {
        canvas.drawBitmap(this.f5163s.m7025e(), this.f5163s.m7027c(), this.f5163s.m7026d(), (Paint) null);
        canvas.drawBitmap(this.f5164t.m7025e(), this.f5164t.m7027c(), this.f5164t.m7026d(), (Paint) null);
        for (DrawElemInfo drawElemInfo : this.f5165u) {
            if (drawElemInfo instanceof TickInfo) {
                TickInfo tickInfo = (TickInfo) drawElemInfo;
                canvas.drawRect(tickInfo.m6918c(), tickInfo.m6917d(), tickInfo.m6916e(), tickInfo.m6915f(), this.f5154j);
            } else if (drawElemInfo instanceof TextInfo) {
                TextInfo textInfo = (TextInfo) drawElemInfo;
                canvas.drawText(String.format(Locale.getDefault(), "%.1fm", Double.valueOf(textInfo.m6922e())), textInfo.m6924c(), textInfo.m6923d(), this.f5155k);
            }
        }
    }

    /* renamed from: a */
    private void m7350a(float f, float f2, int i, boolean z) {
        float f3;
        float f4;
        double d = this.f5152h;
        if (i == 1) {
            boolean z2 = z;
            double d2 = d;
            float f5 = f2;
            while (true) {
                if (z2) {
                    f4 = f5 + this.f5160p + this.f5157m;
                } else {
                    f4 = f5 + this.f5158n + this.f5157m;
                }
                if (f4 > getHeight()) {
                    return;
                }
                double d3 = d2 + this.f5151g;
                if (z2) {
                    this.f5165u.add(TickInfo.m6920a(f, f4, f + this.f5159o, f4 + this.f5158n, false, d3));
                } else {
                    this.f5165u.add(TickInfo.m6920a(f, f4, f + this.f5161q, f4 + this.f5160p, true, d3));
                    this.f5165u.add(TextInfo.m6925a(DpiUtils.m5887a(getContext(), 28.0f), f4 + 15.0f, d3));
                }
                z2 = !z2;
                f5 = f4;
                d2 = d3;
            }
        } else {
            boolean z3 = z;
            double d4 = d;
            float f6 = f2;
            while (true) {
                if (z3) {
                    f3 = (f6 - this.f5160p) - this.f5157m;
                } else {
                    f3 = (f6 - this.f5158n) - this.f5157m;
                }
                if (f3 < 0.0f) {
                    return;
                }
                double d5 = d4 - this.f5151g;
                if (z3) {
                    this.f5165u.add(TickInfo.m6920a(f, f3, f + this.f5159o, f3 + this.f5158n, false, d5));
                } else {
                    this.f5165u.add(TickInfo.m6920a(f, f3, f + this.f5161q, f3 + this.f5160p, true, d5));
                    this.f5165u.add(TextInfo.m6925a(DpiUtils.m5887a(getContext(), 28.0f), f3 + 15.0f, d5));
                }
                z3 = !z3;
                f6 = f3;
                d4 = d5;
            }
        }
    }
}
