package com.navatics.app.widget.badge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.utils.Utils;
import com.navatics.app.utils.MathUtils;
import com.navatics.app.widget.badge.Badge;
import com.navatics.robot.utils.DpiUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BadgeView extends View implements Badge {

    /* renamed from: A */
    protected PointF f5585A;

    /* renamed from: B */
    protected PointF f5586B;

    /* renamed from: C */
    protected PointF f5587C;

    /* renamed from: D */
    protected PointF f5588D;

    /* renamed from: E */
    protected List<PointF> f5589E;

    /* renamed from: F */
    protected View f5590F;

    /* renamed from: G */
    protected int f5591G;

    /* renamed from: H */
    protected int f5592H;

    /* renamed from: I */
    protected TextPaint f5593I;

    /* renamed from: J */
    protected Paint f5594J;

    /* renamed from: K */
    protected Paint f5595K;

    /* renamed from: L */
    protected BadgeAnimator f5596L;

    /* renamed from: M */
    protected Badge.InterfaceC1962a f5597M;

    /* renamed from: N */
    protected ViewGroup f5598N;

    /* renamed from: a */
    protected int f5599a;

    /* renamed from: b */
    protected int f5600b;

    /* renamed from: c */
    protected int f5601c;

    /* renamed from: d */
    protected Drawable f5602d;

    /* renamed from: e */
    protected Bitmap f5603e;

    /* renamed from: f */
    protected boolean f5604f;

    /* renamed from: g */
    protected float f5605g;

    /* renamed from: h */
    protected float f5606h;

    /* renamed from: i */
    protected float f5607i;

    /* renamed from: j */
    protected int f5608j;

    /* renamed from: k */
    protected String f5609k;

    /* renamed from: l */
    protected boolean f5610l;

    /* renamed from: m */
    protected boolean f5611m;

    /* renamed from: n */
    protected boolean f5612n;

    /* renamed from: o */
    protected boolean f5613o;

    /* renamed from: p */
    protected int f5614p;

    /* renamed from: q */
    protected float f5615q;

    /* renamed from: r */
    protected float f5616r;

    /* renamed from: s */
    protected float f5617s;

    /* renamed from: t */
    protected float f5618t;

    /* renamed from: u */
    protected int f5619u;

    /* renamed from: v */
    protected boolean f5620v;

    /* renamed from: w */
    protected RectF f5621w;

    /* renamed from: x */
    protected RectF f5622x;

    /* renamed from: y */
    protected Path f5623y;

    /* renamed from: z */
    protected Paint.FontMetrics f5624z;

    public BadgeView(Context context) {
        this(context, null);
    }

    private BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private BadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7009c();
    }

    /* renamed from: c */
    private void m7009c() {
        setLayerType(1, null);
        this.f5621w = new RectF();
        this.f5622x = new RectF();
        this.f5623y = new Path();
        this.f5585A = new PointF();
        this.f5586B = new PointF();
        this.f5587C = new PointF();
        this.f5588D = new PointF();
        this.f5589E = new ArrayList();
        this.f5593I = new TextPaint();
        this.f5593I.setAntiAlias(true);
        this.f5593I.setSubpixelText(true);
        this.f5593I.setFakeBoldText(true);
        this.f5593I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f5594J = new Paint();
        this.f5594J.setAntiAlias(true);
        this.f5594J.setStyle(Paint.Style.FILL);
        this.f5595K = new Paint();
        this.f5595K.setAntiAlias(true);
        this.f5595K.setStyle(Paint.Style.STROKE);
        this.f5599a = -1552832;
        this.f5601c = -1;
        this.f5606h = DpiUtils.m5886b(getContext(), 11.0f);
        this.f5607i = DpiUtils.m5887a(getContext(), 5.0f);
        this.f5608j = 0;
        this.f5614p = 8388661;
        this.f5615q = DpiUtils.m5887a(getContext(), 1.0f);
        this.f5616r = DpiUtils.m5887a(getContext(), 1.0f);
        this.f5618t = DpiUtils.m5887a(getContext(), 90.0f);
        this.f5613o = true;
        this.f5604f = false;
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(1000.0f);
        }
    }

    /* renamed from: a */
    public Badge m7016a(View view) {
        if (view == null) {
            throw new IllegalStateException("targetView can not be null");
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            this.f5590F = view;
            if (parent instanceof C1961a) {
                ((C1961a) parent).addView(this);
            } else {
                ViewGroup viewGroup = (ViewGroup) parent;
                int indexOfChild = viewGroup.indexOfChild(view);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                viewGroup.removeView(view);
                C1961a c1961a = new C1961a(getContext());
                if (viewGroup instanceof RelativeLayout) {
                    c1961a.setId(view.getId());
                }
                viewGroup.addView(c1961a, indexOfChild, layoutParams);
                c1961a.addView(view);
                c1961a.addView(this);
            }
            return this;
        }
        throw new IllegalStateException("targetView must have a parent");
    }

    public View getTargetView() {
        return this.f5590F;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5598N == null) {
            m7011b(this.f5590F);
        }
    }

    /* renamed from: b */
    private void m7011b(View view) {
        this.f5598N = (ViewGroup) view.getRootView();
        if (this.f5598N == null) {
            m7008c(view);
        }
    }

    /* renamed from: c */
    private void m7008c(View view) {
        if (view.getParent() != null && (view.getParent() instanceof View)) {
            m7008c((View) view.getParent());
        } else if (view instanceof ViewGroup) {
            this.f5598N = (ViewGroup) view;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (this.f5610l && motionEvent.getPointerId(motionEvent.getActionIndex()) == 0 && x > this.f5622x.left && x < this.f5622x.right && y > this.f5622x.top && y < this.f5622x.bottom && this.f5609k != null) {
                    m7001i();
                    this.f5611m = true;
                    m7012b(1);
                    this.f5617s = DpiUtils.m5887a(getContext(), 7.0f);
                    getParent().requestDisallowInterceptTouchEvent(true);
                    m7014a(true);
                    this.f5586B.x = motionEvent.getRawX();
                    this.f5586B.y = motionEvent.getRawY();
                    break;
                }
                break;
            case 1:
            case 3:
            case 6:
                if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 0 && this.f5611m) {
                    this.f5611m = false;
                    m7006d();
                    break;
                }
                break;
            case 2:
                if (this.f5611m) {
                    this.f5586B.x = motionEvent.getRawX();
                    this.f5586B.y = motionEvent.getRawY();
                    invalidate();
                    break;
                }
                break;
        }
        return this.f5611m || super.onTouchEvent(motionEvent);
    }

    /* renamed from: d */
    private void m7006d() {
        if (this.f5620v) {
            m7017a(this.f5586B);
            m7012b(5);
            return;
        }
        m7013b();
        m7012b(4);
    }

    /* renamed from: a */
    protected Bitmap m7023a() {
        Bitmap createBitmap = Bitmap.createBitmap(((int) this.f5622x.width()) + DpiUtils.m5887a(getContext(), 3.0f), ((int) this.f5622x.height()) + DpiUtils.m5887a(getContext(), 3.0f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        m7018a(canvas, new PointF(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f), getBadgeCircleRadius());
        return createBitmap;
    }

    /* renamed from: a */
    protected void m7014a(boolean z) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (z) {
            this.f5598N.addView(this, new FrameLayout.LayoutParams(-1, -1));
        } else {
            m7016a(this.f5590F);
        }
    }

    /* renamed from: c */
    private void m7007c(boolean z) {
        int m5887a = DpiUtils.m5887a(getContext(), 1.0f);
        int m5887a2 = DpiUtils.m5887a(getContext(), 1.5f);
        switch (this.f5619u) {
            case 1:
                m5887a = DpiUtils.m5887a(getContext(), 1.0f);
                m5887a2 = DpiUtils.m5887a(getContext(), -1.5f);
                break;
            case 2:
                m5887a = DpiUtils.m5887a(getContext(), -1.0f);
                m5887a2 = DpiUtils.m5887a(getContext(), -1.5f);
                break;
            case 3:
                m5887a = DpiUtils.m5887a(getContext(), -1.0f);
                m5887a2 = DpiUtils.m5887a(getContext(), 1.5f);
                break;
            case 4:
                m5887a = DpiUtils.m5887a(getContext(), 1.0f);
                m5887a2 = DpiUtils.m5887a(getContext(), 1.5f);
                break;
        }
        this.f5594J.setShadowLayer(z ? DpiUtils.m5887a(getContext(), 2.0f) : 0.0f, m5887a, m5887a2, 855638016);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5591G = i;
        this.f5592H = i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        BadgeAnimator badgeAnimator = this.f5596L;
        if (badgeAnimator != null && badgeAnimator.isRunning()) {
            this.f5596L.m6998a(canvas);
        } else if (this.f5609k != null) {
            m7005e();
            float badgeCircleRadius = getBadgeCircleRadius();
            float m7375b = this.f5617s * (1.0f - (MathUtils.m7375b(this.f5587C, this.f5586B) / this.f5618t));
            if (this.f5610l && this.f5611m) {
                this.f5619u = MathUtils.m7376a(this.f5586B, this.f5587C);
                m7007c(this.f5613o);
                boolean z = m7375b < ((float) DpiUtils.m5887a(getContext(), 1.5f));
                this.f5620v = z;
                if (z) {
                    m7012b(3);
                    m7018a(canvas, this.f5586B, badgeCircleRadius);
                    return;
                }
                m7012b(2);
                m7019a(canvas, m7375b, badgeCircleRadius);
                m7018a(canvas, this.f5586B, badgeCircleRadius);
                return;
            }
            m7003g();
            m7018a(canvas, this.f5585A, badgeCircleRadius);
        }
    }

    /* renamed from: e */
    private void m7005e() {
        m7007c(this.f5613o);
        this.f5594J.setColor(this.f5599a);
        this.f5595K.setColor(this.f5600b);
        this.f5595K.setStrokeWidth(this.f5605g);
        this.f5593I.setColor(this.f5601c);
        this.f5593I.setTextAlign(Paint.Align.CENTER);
    }

    /* renamed from: a */
    private void m7019a(Canvas canvas, float f, float f2) {
        float f3;
        float f4;
        float f5 = this.f5586B.y - this.f5587C.y;
        float f6 = this.f5586B.x - this.f5587C.x;
        this.f5589E.clear();
        if (f6 != 0.0f) {
            double d = (-1.0d) / (f5 / f6);
            MathUtils.m7377a(this.f5586B, f2, Double.valueOf(d), this.f5589E);
            MathUtils.m7377a(this.f5587C, f, Double.valueOf(d), this.f5589E);
        } else {
            MathUtils.m7377a(this.f5586B, f2, Double.valueOf((double) Utils.DOUBLE_EPSILON), this.f5589E);
            MathUtils.m7377a(this.f5587C, f, Double.valueOf((double) Utils.DOUBLE_EPSILON), this.f5589E);
        }
        this.f5623y.reset();
        Path path = this.f5623y;
        float f7 = this.f5587C.x;
        float f8 = this.f5587C.y;
        int i = this.f5619u;
        path.addCircle(f7, f8, f, (i == 1 || i == 2) ? Path.Direction.CCW : Path.Direction.CW);
        this.f5588D.x = (this.f5587C.x + this.f5586B.x) / 2.0f;
        this.f5588D.y = (this.f5587C.y + this.f5586B.y) / 2.0f;
        this.f5623y.moveTo(this.f5589E.get(2).x, this.f5589E.get(2).y);
        this.f5623y.quadTo(this.f5588D.x, this.f5588D.y, this.f5589E.get(0).x, this.f5589E.get(0).y);
        this.f5623y.lineTo(this.f5589E.get(1).x, this.f5589E.get(1).y);
        this.f5623y.quadTo(this.f5588D.x, this.f5588D.y, this.f5589E.get(3).x, this.f5589E.get(3).y);
        this.f5623y.lineTo(this.f5589E.get(2).x, this.f5589E.get(2).y);
        this.f5623y.close();
        canvas.drawPath(this.f5623y, this.f5594J);
        if (this.f5600b == 0 || this.f5605g <= 0.0f) {
            return;
        }
        this.f5623y.reset();
        this.f5623y.moveTo(this.f5589E.get(2).x, this.f5589E.get(2).y);
        this.f5623y.quadTo(this.f5588D.x, this.f5588D.y, this.f5589E.get(0).x, this.f5589E.get(0).y);
        this.f5623y.moveTo(this.f5589E.get(1).x, this.f5589E.get(1).y);
        this.f5623y.quadTo(this.f5588D.x, this.f5588D.y, this.f5589E.get(3).x, this.f5589E.get(3).y);
        int i2 = this.f5619u;
        if (i2 == 1 || i2 == 2) {
            f3 = this.f5589E.get(2).x - this.f5587C.x;
            f4 = this.f5587C.y - this.f5589E.get(2).y;
        } else {
            f3 = this.f5589E.get(3).x - this.f5587C.x;
            f4 = this.f5587C.y - this.f5589E.get(3).y;
        }
        double atan = Math.atan(f4 / f3);
        int i3 = this.f5619u;
        float m7379a = 360.0f - ((float) MathUtils.m7379a(MathUtils.m7378a(atan, i3 + (-1) == 0 ? 4 : i3 - 1)));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f5623y.addArc(this.f5587C.x - f, this.f5587C.y - f, this.f5587C.x + f, this.f5587C.y + f, m7379a, 180.0f);
        } else {
            this.f5623y.addArc(new RectF(this.f5587C.x - f, this.f5587C.y - f, this.f5587C.x + f, this.f5587C.y + f), m7379a, 180.0f);
        }
        canvas.drawPath(this.f5623y, this.f5595K);
    }

    /* renamed from: a */
    private void m7018a(Canvas canvas, PointF pointF, float f) {
        if (pointF.x == -1000.0f && pointF.y == -1000.0f) {
            return;
        }
        if (this.f5609k.isEmpty() || this.f5609k.length() == 1) {
            float f2 = (int) f;
            this.f5622x.left = pointF.x - f2;
            this.f5622x.top = pointF.y - f2;
            this.f5622x.right = pointF.x + f2;
            this.f5622x.bottom = pointF.y + f2;
            if (this.f5602d != null) {
                m7020a(canvas);
            } else {
                canvas.drawCircle(pointF.x, pointF.y, f, this.f5594J);
                if (this.f5600b != 0 && this.f5605g > 0.0f) {
                    canvas.drawCircle(pointF.x, pointF.y, f, this.f5595K);
                }
            }
        } else {
            this.f5622x.left = pointF.x - ((this.f5621w.width() / 2.0f) + this.f5607i);
            this.f5622x.top = pointF.y - ((this.f5621w.height() / 2.0f) + (this.f5607i * 0.5f));
            this.f5622x.right = pointF.x + (this.f5621w.width() / 2.0f) + this.f5607i;
            this.f5622x.bottom = pointF.y + (this.f5621w.height() / 2.0f) + (this.f5607i * 0.5f);
            float height = this.f5622x.height() / 2.0f;
            if (this.f5602d != null) {
                m7020a(canvas);
            } else {
                canvas.drawRoundRect(this.f5622x, height, height, this.f5594J);
                if (this.f5600b != 0 && this.f5605g > 0.0f) {
                    canvas.drawRoundRect(this.f5622x, height, height, this.f5595K);
                }
            }
        }
        if (this.f5609k.isEmpty()) {
            return;
        }
        canvas.drawText(this.f5609k, pointF.x, (((this.f5622x.bottom + this.f5622x.top) - this.f5624z.bottom) - this.f5624z.top) / 2.0f, this.f5593I);
    }

    /* renamed from: a */
    private void m7020a(Canvas canvas) {
        this.f5594J.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        int i = (int) this.f5622x.left;
        int i2 = (int) this.f5622x.top;
        int i3 = (int) this.f5622x.right;
        int i4 = (int) this.f5622x.bottom;
        if (this.f5604f) {
            i3 = this.f5603e.getWidth() + i;
            i4 = this.f5603e.getHeight() + i2;
            canvas.saveLayer(i, i2, i3, i4, null, 31);
        }
        this.f5602d.setBounds(i, i2, i3, i4);
        this.f5602d.draw(canvas);
        if (this.f5604f) {
            this.f5594J.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(this.f5603e, i, i2, this.f5594J);
            canvas.restore();
            this.f5594J.setXfermode(null);
            if (this.f5609k.isEmpty() || this.f5609k.length() == 1) {
                canvas.drawCircle(this.f5622x.centerX(), this.f5622x.centerY(), this.f5622x.width() / 2.0f, this.f5595K);
                return;
            }
            RectF rectF = this.f5622x;
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, this.f5622x.height() / 2.0f, this.f5595K);
            return;
        }
        canvas.drawRect(this.f5622x, this.f5595K);
    }

    /* renamed from: f */
    private void m7004f() {
        if (this.f5609k != null && this.f5604f) {
            Bitmap bitmap = this.f5603e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f5603e.recycle();
            }
            float badgeCircleRadius = getBadgeCircleRadius();
            if (this.f5609k.isEmpty() || this.f5609k.length() == 1) {
                int i = ((int) badgeCircleRadius) * 2;
                this.f5603e = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(this.f5603e);
                canvas.drawCircle(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f, canvas.getWidth() / 2.0f, this.f5594J);
                return;
            }
            this.f5603e = Bitmap.createBitmap((int) (this.f5621w.width() + (this.f5607i * 2.0f)), (int) (this.f5621w.height() + this.f5607i), Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(this.f5603e);
            if (Build.VERSION.SDK_INT >= 21) {
                canvas2.drawRoundRect(0.0f, 0.0f, canvas2.getWidth(), canvas2.getHeight(), canvas2.getHeight() / 2.0f, canvas2.getHeight() / 2.0f, this.f5594J);
            } else {
                canvas2.drawRoundRect(new RectF(0.0f, 0.0f, canvas2.getWidth(), canvas2.getHeight()), canvas2.getHeight() / 2.0f, canvas2.getHeight() / 2.0f, this.f5594J);
            }
        }
    }

    private float getBadgeCircleRadius() {
        if (this.f5609k.isEmpty()) {
            return this.f5607i;
        }
        if (this.f5609k.length() == 1) {
            if (this.f5621w.height() > this.f5621w.width()) {
                return (this.f5621w.height() / 2.0f) + (this.f5607i * 0.5f);
            }
            return (this.f5621w.width() / 2.0f) + (this.f5607i * 0.5f);
        }
        return this.f5622x.height() / 2.0f;
    }

    /* renamed from: g */
    private void m7003g() {
        float height = this.f5621w.height() > this.f5621w.width() ? this.f5621w.height() : this.f5621w.width();
        switch (this.f5614p) {
            case 17:
                PointF pointF = this.f5585A;
                pointF.x = this.f5591G / 2.0f;
                pointF.y = this.f5592H / 2.0f;
                break;
            case 49:
                PointF pointF2 = this.f5585A;
                pointF2.x = this.f5591G / 2.0f;
                pointF2.y = this.f5616r + this.f5607i + (this.f5621w.height() / 2.0f);
                break;
            case 81:
                PointF pointF3 = this.f5585A;
                pointF3.x = this.f5591G / 2.0f;
                pointF3.y = this.f5592H - ((this.f5616r + this.f5607i) + (this.f5621w.height() / 2.0f));
                break;
            case 8388627:
                PointF pointF4 = this.f5585A;
                pointF4.x = this.f5615q + this.f5607i + (height / 2.0f);
                pointF4.y = this.f5592H / 2.0f;
                break;
            case 8388629:
                PointF pointF5 = this.f5585A;
                pointF5.x = this.f5591G - ((this.f5615q + this.f5607i) + (height / 2.0f));
                pointF5.y = this.f5592H / 2.0f;
                break;
            case 8388659:
                PointF pointF6 = this.f5585A;
                float f = this.f5615q;
                float f2 = this.f5607i;
                pointF6.x = f + f2 + (height / 2.0f);
                pointF6.y = this.f5616r + f2 + (this.f5621w.height() / 2.0f);
                break;
            case 8388661:
                PointF pointF7 = this.f5585A;
                float f3 = this.f5615q;
                float f4 = this.f5607i;
                pointF7.x = this.f5591G - ((f3 + f4) + (height / 2.0f));
                pointF7.y = this.f5616r + f4 + (this.f5621w.height() / 2.0f);
                break;
            case 8388691:
                PointF pointF8 = this.f5585A;
                float f5 = this.f5615q;
                float f6 = this.f5607i;
                pointF8.x = f5 + f6 + (height / 2.0f);
                pointF8.y = this.f5592H - ((this.f5616r + f6) + (this.f5621w.height() / 2.0f));
                break;
            case 8388693:
                PointF pointF9 = this.f5585A;
                float f7 = this.f5615q;
                float f8 = this.f5607i;
                pointF9.x = this.f5591G - ((f7 + f8) + (height / 2.0f));
                pointF9.y = this.f5592H - ((this.f5616r + f8) + (this.f5621w.height() / 2.0f));
                break;
        }
        m7001i();
    }

    /* renamed from: h */
    private void m7002h() {
        RectF rectF = this.f5621w;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        if (TextUtils.isEmpty(this.f5609k)) {
            RectF rectF2 = this.f5621w;
            rectF2.right = 0.0f;
            rectF2.bottom = 0.0f;
        } else {
            this.f5593I.setTextSize(this.f5606h);
            this.f5621w.right = this.f5593I.measureText(this.f5609k);
            this.f5624z = this.f5593I.getFontMetrics();
            this.f5621w.bottom = this.f5624z.descent - this.f5624z.ascent;
        }
        m7004f();
    }

    /* renamed from: i */
    private void m7001i() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.f5587C.x = this.f5585A.x + iArr[0];
        this.f5587C.y = this.f5585A.y + iArr[1];
    }

    /* renamed from: a */
    protected void m7017a(PointF pointF) {
        if (this.f5609k == null) {
            return;
        }
        BadgeAnimator badgeAnimator = this.f5596L;
        if (badgeAnimator == null || !badgeAnimator.isRunning()) {
            m7014a(true);
            this.f5596L = new BadgeAnimator(m7023a(), pointF, this);
            this.f5596L.start();
            m7021a(0);
        }
    }

    /* renamed from: b */
    public void m7013b() {
        PointF pointF = this.f5586B;
        pointF.x = -1000.0f;
        pointF.y = -1000.0f;
        this.f5619u = 4;
        m7014a(false);
        getParent().requestDisallowInterceptTouchEvent(false);
        invalidate();
    }

    /* renamed from: a */
    public Badge m7021a(int i) {
        this.f5608j = i;
        int i2 = this.f5608j;
        if (i2 < 0) {
            this.f5609k = "";
        } else if (i2 > 99) {
            this.f5609k = this.f5612n ? String.valueOf(i2) : "99+";
        } else if (i2 > 0) {
            this.f5609k = String.valueOf(i2);
        } else {
            this.f5609k = null;
        }
        m7002h();
        invalidate();
        return this;
    }

    public int getBadgeNumber() {
        return this.f5608j;
    }

    /* renamed from: a */
    public Badge m7015a(String str) {
        this.f5609k = str;
        this.f5608j = 1;
        m7002h();
        invalidate();
        return this;
    }

    public String getBadgeText() {
        return this.f5609k;
    }

    /* renamed from: b */
    public Badge m7010b(boolean z) {
        this.f5613o = z;
        invalidate();
        return this;
    }

    public int getBadgeBackgroundColor() {
        return this.f5599a;
    }

    public Drawable getBadgeBackground() {
        return this.f5602d;
    }

    public int getBadgeTextColor() {
        return this.f5601c;
    }

    public int getBadgeGravity() {
        return this.f5614p;
    }

    /* renamed from: a */
    public Badge m7022a(float f, float f2, boolean z) {
        if (z) {
            f = DpiUtils.m5887a(getContext(), f);
        }
        this.f5615q = f;
        if (z) {
            f2 = DpiUtils.m5887a(getContext(), f2);
        }
        this.f5616r = f2;
        invalidate();
        return this;
    }

    /* renamed from: b */
    private void m7012b(int i) {
        Badge.InterfaceC1962a interfaceC1962a = this.f5597M;
        if (interfaceC1962a != null) {
            interfaceC1962a.m7000a(i, this, this.f5590F);
        }
    }

    public PointF getDragCenter() {
        if (this.f5610l && this.f5611m) {
            return this.f5586B;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.badge.BadgeView$a */
    /* loaded from: classes.dex */
    public class C1961a extends ViewGroup {
        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
            if (getParent() instanceof RelativeLayout) {
                return;
            }
            super.dispatchRestoreInstanceState(sparseArray);
        }

        public C1961a(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            View view = null;
            View view2 = null;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof BadgeView) {
                    view2 = childAt;
                } else {
                    view = childAt;
                }
            }
            if (view == null) {
                super.onMeasure(i, i2);
                return;
            }
            view.measure(i, i2);
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
            }
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }
}
