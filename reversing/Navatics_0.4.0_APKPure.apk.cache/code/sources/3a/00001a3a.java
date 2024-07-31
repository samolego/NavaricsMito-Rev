package com.navatics.app.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class PinchImageView extends ImageView {

    /* renamed from: a */
    private View.OnClickListener f5457a;

    /* renamed from: b */
    private View.OnLongClickListener f5458b;

    /* renamed from: c */
    private Matrix f5459c;

    /* renamed from: d */
    private RectF f5460d;

    /* renamed from: e */
    private int f5461e;

    /* renamed from: f */
    private List<InterfaceC1871e> f5462f;

    /* renamed from: g */
    private List<InterfaceC1871e> f5463g;

    /* renamed from: h */
    private int f5464h;

    /* renamed from: i */
    private PointF f5465i;

    /* renamed from: j */
    private PointF f5466j;

    /* renamed from: k */
    private float f5467k;

    /* renamed from: l */
    private C1873g f5468l;

    /* renamed from: m */
    private C1867a f5469m;

    /* renamed from: n */
    private GestureDetector f5470n;

    /* renamed from: com.navatics.app.widget.PinchImageView$e */
    /* loaded from: classes.dex */
    public interface InterfaceC1871e {
        /* renamed from: a */
        void m5750a(PinchImageView pinchImageView);
    }

    /* renamed from: a */
    protected float m5731a(float f, float f2) {
        if (f2 * f < 4.0f) {
            return 4.0f;
        }
        return f;
    }

    protected float getMaxScale() {
        return 4.0f;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f5457a = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f5458b = onLongClickListener;
    }

    /* renamed from: a */
    public Matrix m5732a(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        } else {
            matrix.reset();
        }
        if (m5723c()) {
            RectF m5737a = C1868b.m5737a(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            RectF m5737a2 = C1868b.m5737a(0.0f, 0.0f, getWidth(), getHeight());
            matrix.setRectToRect(m5737a, m5737a2, Matrix.ScaleToFit.CENTER);
            C1868b.m5738a(m5737a2);
            C1868b.m5738a(m5737a);
        }
        return matrix;
    }

    /* renamed from: b */
    public Matrix m5734b(Matrix matrix) {
        Matrix m5732a = m5732a(matrix);
        m5732a.postConcat(this.f5459c);
        return m5732a;
    }

    /* renamed from: a */
    public RectF m5733a(RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        } else {
            rectF.setEmpty();
        }
        if (!m5723c()) {
            return rectF;
        }
        Matrix m5735a = C1868b.m5735a();
        m5734b(m5735a);
        rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        m5735a.mapRect(rectF);
        C1868b.m5742b(m5735a);
        return rectF;
    }

    public RectF getMask() {
        RectF rectF = this.f5460d;
        if (rectF != null) {
            return new RectF(rectF);
        }
        return null;
    }

    public int getPinchMode() {
        return this.f5461e;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f5461e == 2) {
            return true;
        }
        RectF m5733a = m5733a((RectF) null);
        if (m5733a == null || m5733a.isEmpty()) {
            return false;
        }
        return i > 0 ? m5733a.right > ((float) getWidth()) : m5733a.left < 0.0f;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (this.f5461e == 2) {
            return true;
        }
        RectF m5733a = m5733a((RectF) null);
        if (m5733a == null || m5733a.isEmpty()) {
            return false;
        }
        return i > 0 ? m5733a.bottom > ((float) getHeight()) : m5733a.top < 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5713a() {
        List<InterfaceC1871e> list;
        List<InterfaceC1871e> list2 = this.f5462f;
        if (list2 == null) {
            return;
        }
        this.f5464h++;
        Iterator<InterfaceC1871e> it = list2.iterator();
        while (it.hasNext()) {
            it.next().m5750a(this);
        }
        this.f5464h--;
        if (this.f5464h != 0 || (list = this.f5463g) == null) {
            return;
        }
        this.f5462f = list;
        this.f5463g = null;
    }

    public PinchImageView(Context context) {
        super(context);
        this.f5459c = new Matrix();
        this.f5461e = 0;
        this.f5465i = new PointF();
        this.f5466j = new PointF();
        this.f5467k = 0.0f;
        this.f5470n = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.navatics.app.widget.PinchImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (PinchImageView.this.f5461e != 0) {
                    return true;
                }
                if (PinchImageView.this.f5468l != null && PinchImageView.this.f5468l.isRunning()) {
                    return true;
                }
                PinchImageView.this.m5727d(f, f2);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PinchImageView.this.f5458b != null) {
                    PinchImageView.this.f5458b.onLongClick(PinchImageView.this);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (PinchImageView.this.f5461e == 1 && (PinchImageView.this.f5468l == null || !PinchImageView.this.f5468l.isRunning())) {
                    PinchImageView.this.m5722c(motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (PinchImageView.this.f5457a == null) {
                    return true;
                }
                PinchImageView.this.f5457a.onClick(PinchImageView.this);
                return true;
            }
        });
        m5718b();
    }

    public PinchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5459c = new Matrix();
        this.f5461e = 0;
        this.f5465i = new PointF();
        this.f5466j = new PointF();
        this.f5467k = 0.0f;
        this.f5470n = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.navatics.app.widget.PinchImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (PinchImageView.this.f5461e != 0) {
                    return true;
                }
                if (PinchImageView.this.f5468l != null && PinchImageView.this.f5468l.isRunning()) {
                    return true;
                }
                PinchImageView.this.m5727d(f, f2);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PinchImageView.this.f5458b != null) {
                    PinchImageView.this.f5458b.onLongClick(PinchImageView.this);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (PinchImageView.this.f5461e == 1 && (PinchImageView.this.f5468l == null || !PinchImageView.this.f5468l.isRunning())) {
                    PinchImageView.this.m5722c(motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (PinchImageView.this.f5457a == null) {
                    return true;
                }
                PinchImageView.this.f5457a.onClick(PinchImageView.this);
                return true;
            }
        });
        m5718b();
    }

    public PinchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5459c = new Matrix();
        this.f5461e = 0;
        this.f5465i = new PointF();
        this.f5466j = new PointF();
        this.f5467k = 0.0f;
        this.f5470n = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.navatics.app.widget.PinchImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (PinchImageView.this.f5461e != 0) {
                    return true;
                }
                if (PinchImageView.this.f5468l != null && PinchImageView.this.f5468l.isRunning()) {
                    return true;
                }
                PinchImageView.this.m5727d(f, f2);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PinchImageView.this.f5458b != null) {
                    PinchImageView.this.f5458b.onLongClick(PinchImageView.this);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (PinchImageView.this.f5461e == 1 && (PinchImageView.this.f5468l == null || !PinchImageView.this.f5468l.isRunning())) {
                    PinchImageView.this.m5722c(motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (PinchImageView.this.f5457a == null) {
                    return true;
                }
                PinchImageView.this.f5457a.onClick(PinchImageView.this);
                return true;
            }
        });
        m5718b();
    }

    /* renamed from: b */
    private void m5718b() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (m5723c()) {
            Matrix m5735a = C1868b.m5735a();
            setImageMatrix(m5734b(m5735a));
            C1868b.m5742b(m5735a);
        }
        if (this.f5460d != null) {
            canvas.save();
            canvas.clipRect(this.f5460d);
            super.onDraw(canvas);
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }

    /* renamed from: c */
    private boolean m5723c() {
        return getDrawable() != null && getDrawable().getIntrinsicWidth() > 0 && getDrawable().getIntrinsicHeight() > 0 && getWidth() > 0 && getHeight() > 0;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C1873g c1873g;
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            if (this.f5461e == 2) {
                m5726d();
            }
            this.f5461e = 0;
        } else if (action == 6) {
            if (this.f5461e == 2 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    m5714a(motionEvent.getX(1), motionEvent.getY(1), motionEvent.getX(2), motionEvent.getY(2));
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    m5714a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(2), motionEvent.getY(2));
                }
            }
        } else if (action == 0) {
            C1873g c1873g2 = this.f5468l;
            if (c1873g2 == null || !c1873g2.isRunning()) {
                m5729e();
                this.f5461e = 1;
                this.f5465i.set(motionEvent.getX(), motionEvent.getY());
            }
        } else if (action == 5) {
            m5729e();
            this.f5461e = 2;
            m5714a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        } else if (action == 2 && ((c1873g = this.f5468l) == null || !c1873g.isRunning())) {
            int i = this.f5461e;
            if (i == 1) {
                m5720b(motionEvent.getX() - this.f5465i.x, motionEvent.getY() - this.f5465i.y);
                this.f5465i.set(motionEvent.getX(), motionEvent.getY());
            } else if (i == 2 && motionEvent.getPointerCount() > 1) {
                float m5740b = C1868b.m5740b(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                float[] m5743c = C1868b.m5743c(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                this.f5465i.set(m5743c[0], m5743c[1]);
                m5715a(this.f5466j, this.f5467k, m5740b, this.f5465i);
            }
        }
        this.f5470n.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m5720b(float f, float f2) {
        if (!m5723c()) {
            return false;
        }
        RectF m5741b = C1868b.m5741b();
        m5733a(m5741b);
        float width = getWidth();
        float height = getHeight();
        if (m5741b.right - m5741b.left < width) {
            f = 0.0f;
        } else if (m5741b.left + f > 0.0f) {
            f = m5741b.left < 0.0f ? -m5741b.left : 0.0f;
        } else if (m5741b.right + f < width) {
            f = m5741b.right > width ? width - m5741b.right : 0.0f;
        }
        if (m5741b.bottom - m5741b.top < height) {
            f2 = 0.0f;
        } else if (m5741b.top + f2 > 0.0f) {
            f2 = m5741b.top < 0.0f ? -m5741b.top : 0.0f;
        } else if (m5741b.bottom + f2 < height) {
            f2 = m5741b.bottom > height ? height - m5741b.bottom : 0.0f;
        }
        C1868b.m5738a(m5741b);
        this.f5459c.postTranslate(f, f2);
        m5713a();
        invalidate();
        return (f == 0.0f && f2 == 0.0f) ? false : true;
    }

    /* renamed from: a */
    private void m5714a(float f, float f2, float f3, float f4) {
        this.f5467k = C1868b.m5744c(this.f5459c)[0] / C1868b.m5740b(f, f2, f3, f4);
        float[] m5739a = C1868b.m5739a(C1868b.m5743c(f, f2, f3, f4), this.f5459c);
        this.f5466j.set(m5739a[0], m5739a[1]);
    }

    /* renamed from: a */
    private void m5715a(PointF pointF, float f, float f2, PointF pointF2) {
        if (m5723c()) {
            float f3 = f * f2;
            Matrix m5735a = C1868b.m5735a();
            m5735a.postScale(f3, f3, pointF.x, pointF.y);
            m5735a.postTranslate(pointF2.x - pointF.x, pointF2.y - pointF.y);
            this.f5459c.set(m5735a);
            C1868b.m5742b(m5735a);
            m5713a();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5722c(float f, float f2) {
        float f3;
        if (m5723c()) {
            Matrix m5735a = C1868b.m5735a();
            m5732a(m5735a);
            float f4 = C1868b.m5744c(m5735a)[0];
            float f5 = C1868b.m5744c(this.f5459c)[0];
            float f6 = f4 * f5;
            float width = getWidth();
            float height = getHeight();
            float maxScale = getMaxScale();
            float m5731a = m5731a(f4, f5);
            if (m5731a > maxScale) {
                m5731a = maxScale;
            }
            if (m5731a >= f4) {
                f4 = m5731a;
            }
            Matrix m5736a = C1868b.m5736a(this.f5459c);
            float f7 = f4 / f6;
            m5736a.postScale(f7, f7, f, f2);
            float f8 = width / 2.0f;
            float f9 = height / 2.0f;
            m5736a.postTranslate(f8 - f, f9 - f2);
            Matrix m5736a2 = C1868b.m5736a(m5735a);
            m5736a2.postConcat(m5736a);
            float f10 = 0.0f;
            RectF m5737a = C1868b.m5737a(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            m5736a2.mapRect(m5737a);
            if (m5737a.right - m5737a.left < width) {
                f3 = f8 - ((m5737a.right + m5737a.left) / 2.0f);
            } else if (m5737a.left > 0.0f) {
                f3 = -m5737a.left;
            } else {
                f3 = m5737a.right < width ? width - m5737a.right : 0.0f;
            }
            if (m5737a.bottom - m5737a.top < height) {
                f10 = f9 - ((m5737a.bottom + m5737a.top) / 2.0f);
            } else if (m5737a.top > 0.0f) {
                f10 = -m5737a.top;
            } else if (m5737a.bottom < height) {
                f10 = height - m5737a.bottom;
            }
            m5736a.postTranslate(f3, f10);
            m5729e();
            this.f5468l = new C1873g(this, this.f5459c, m5736a);
            this.f5468l.start();
            C1868b.m5738a(m5737a);
            C1868b.m5742b(m5736a2);
            C1868b.m5742b(m5736a);
            C1868b.m5742b(m5735a);
        }
    }

    /* renamed from: d */
    private void m5726d() {
        float f;
        float f2;
        if (m5723c()) {
            Matrix m5735a = C1868b.m5735a();
            m5734b(m5735a);
            float f3 = C1868b.m5744c(m5735a)[0];
            float f4 = C1868b.m5744c(this.f5459c)[0];
            float width = getWidth();
            float height = getHeight();
            float maxScale = getMaxScale();
            float f5 = f3 > maxScale ? maxScale / f3 : 1.0f;
            if (f4 * f5 < 1.0f) {
                f5 = 1.0f / f4;
            }
            boolean z = f5 != 1.0f;
            Matrix m5736a = C1868b.m5736a(m5735a);
            m5736a.postScale(f5, f5, this.f5465i.x, this.f5465i.y);
            RectF m5737a = C1868b.m5737a(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            m5736a.mapRect(m5737a);
            if (m5737a.right - m5737a.left < width) {
                f = (width / 2.0f) - ((m5737a.right + m5737a.left) / 2.0f);
            } else if (m5737a.left > 0.0f) {
                f = -m5737a.left;
            } else {
                f = m5737a.right < width ? width - m5737a.right : 0.0f;
            }
            if (m5737a.bottom - m5737a.top < height) {
                f2 = (height / 2.0f) - ((m5737a.bottom + m5737a.top) / 2.0f);
            } else if (m5737a.top > 0.0f) {
                f2 = -m5737a.top;
            } else {
                f2 = m5737a.bottom < height ? height - m5737a.bottom : 0.0f;
            }
            if (f != 0.0f || f2 != 0.0f) {
                z = true;
            }
            if (z) {
                Matrix m5736a2 = C1868b.m5736a(this.f5459c);
                m5736a2.postScale(f5, f5, this.f5465i.x, this.f5465i.y);
                m5736a2.postTranslate(f, f2);
                m5729e();
                this.f5468l = new C1873g(this, this.f5459c, m5736a2);
                this.f5468l.start();
                C1868b.m5742b(m5736a2);
            }
            C1868b.m5738a(m5737a);
            C1868b.m5742b(m5736a);
            C1868b.m5742b(m5735a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5727d(float f, float f2) {
        if (m5723c()) {
            m5729e();
            this.f5469m = new C1867a(f / 60.0f, f2 / 60.0f);
            this.f5469m.start();
        }
    }

    /* renamed from: e */
    private void m5729e() {
        C1873g c1873g = this.f5468l;
        if (c1873g != null) {
            c1873g.cancel();
            this.f5468l = null;
        }
        C1867a c1867a = this.f5469m;
        if (c1867a != null) {
            c1867a.cancel();
            this.f5469m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.PinchImageView$a */
    /* loaded from: classes.dex */
    public class C1867a extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b */
        private float[] f5473b;

        public C1867a(float f, float f2) {
            setFloatValues(0.0f, 1.0f);
            setDuration(1000000L);
            addUpdateListener(this);
            this.f5473b = new float[]{f, f2};
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PinchImageView pinchImageView = PinchImageView.this;
            float[] fArr = this.f5473b;
            boolean m5720b = pinchImageView.m5720b(fArr[0], fArr[1]);
            float[] fArr2 = this.f5473b;
            fArr2[0] = fArr2[0] * 0.9f;
            fArr2[1] = fArr2[1] * 0.9f;
            if (!m5720b || C1868b.m5740b(0.0f, 0.0f, fArr2[0], fArr2[1]) < 1.0f) {
                valueAnimator.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.PinchImageView$g */
    /* loaded from: classes.dex */
    public class C1873g extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b */
        private float[] f5479b;

        /* renamed from: c */
        private float[] f5480c;

        /* renamed from: d */
        private float[] f5481d;

        public C1873g(PinchImageView pinchImageView, Matrix matrix, Matrix matrix2) {
            this(matrix, matrix2, 200L);
        }

        public C1873g(Matrix matrix, Matrix matrix2, long j) {
            this.f5479b = new float[9];
            this.f5480c = new float[9];
            this.f5481d = new float[9];
            setFloatValues(0.0f, 1.0f);
            setDuration(j);
            addUpdateListener(this);
            matrix.getValues(this.f5479b);
            matrix2.getValues(this.f5480c);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f5481d;
                float[] fArr2 = this.f5479b;
                fArr[i] = fArr2[i] + ((this.f5480c[i] - fArr2[i]) * floatValue);
            }
            PinchImageView.this.f5459c.setValues(this.f5481d);
            PinchImageView.this.m5713a();
            PinchImageView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.PinchImageView$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1870d<T> {

        /* renamed from: a */
        private int f5476a;

        /* renamed from: b */
        private Queue<T> f5477b = new LinkedList();

        /* renamed from: a */
        protected abstract T mo5746a(T t);

        /* renamed from: b */
        protected abstract T mo5747b();

        public AbstractC1870d(int i) {
            this.f5476a = i;
        }

        /* renamed from: c */
        public T m5749c() {
            if (this.f5477b.size() == 0) {
                return mo5747b();
            }
            return mo5746a(this.f5477b.poll());
        }

        /* renamed from: b */
        public void m5748b(T t) {
            if (t == null || this.f5477b.size() >= this.f5476a) {
                return;
            }
            this.f5477b.offer(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.PinchImageView$c */
    /* loaded from: classes.dex */
    public static class C1869c extends AbstractC1870d<Matrix> {
        public C1869c(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.navatics.app.widget.PinchImageView.AbstractC1870d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix mo5747b() {
            return new Matrix();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.navatics.app.widget.PinchImageView.AbstractC1870d
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Matrix mo5746a(Matrix matrix) {
            matrix.reset();
            return matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.PinchImageView$f */
    /* loaded from: classes.dex */
    public static class C1872f extends AbstractC1870d<RectF> {
        public C1872f(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.navatics.app.widget.PinchImageView.AbstractC1870d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RectF mo5747b() {
            return new RectF();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.navatics.app.widget.PinchImageView.AbstractC1870d
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public RectF mo5746a(RectF rectF) {
            rectF.setEmpty();
            return rectF;
        }
    }

    /* renamed from: com.navatics.app.widget.PinchImageView$b */
    /* loaded from: classes.dex */
    public static class C1868b {

        /* renamed from: a */
        private static C1869c f5474a = new C1869c(16);

        /* renamed from: b */
        private static C1872f f5475b = new C1872f(16);

        /* renamed from: a */
        public static Matrix m5735a() {
            return f5474a.m5749c();
        }

        /* renamed from: a */
        public static Matrix m5736a(Matrix matrix) {
            Matrix c = f5474a.m5749c();
            if (matrix != null) {
                c.set(matrix);
            }
            return c;
        }

        /* renamed from: b */
        public static void m5742b(Matrix matrix) {
            f5474a.m5748b(matrix);
        }

        /* renamed from: b */
        public static RectF m5741b() {
            return f5475b.m5749c();
        }

        /* renamed from: a */
        public static RectF m5737a(float f, float f2, float f3, float f4) {
            RectF c = f5475b.m5749c();
            c.set(f, f2, f3, f4);
            return c;
        }

        /* renamed from: a */
        public static void m5738a(RectF rectF) {
            f5475b.m5748b(rectF);
        }

        /* renamed from: b */
        public static float m5740b(float f, float f2, float f3, float f4) {
            float f5 = f - f3;
            float f6 = f2 - f4;
            return (float) Math.sqrt((f5 * f5) + (f6 * f6));
        }

        /* renamed from: c */
        public static float[] m5743c(float f, float f2, float f3, float f4) {
            return new float[]{(f + f3) / 2.0f, (f2 + f4) / 2.0f};
        }

        /* renamed from: c */
        public static float[] m5744c(Matrix matrix) {
            if (matrix != null) {
                float[] fArr = new float[9];
                matrix.getValues(fArr);
                return new float[]{fArr[0], fArr[4]};
            }
            return new float[2];
        }

        /* renamed from: a */
        public static float[] m5739a(float[] fArr, Matrix matrix) {
            if (fArr != null && matrix != null) {
                float[] fArr2 = new float[2];
                Matrix m5735a = m5735a();
                matrix.invert(m5735a);
                m5735a.mapPoints(fArr2, fArr);
                m5742b(m5735a);
                return fArr2;
            }
            return new float[2];
        }
    }
}