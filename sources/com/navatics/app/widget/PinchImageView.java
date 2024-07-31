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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class PinchImageView extends ImageView {

    /* renamed from: a */
    private View.OnClickListener f5435a;

    /* renamed from: b */
    private View.OnLongClickListener f5436b;

    /* renamed from: c */
    private Matrix f5437c;

    /* renamed from: d */
    private RectF f5438d;

    /* renamed from: e */
    private int f5439e;

    /* renamed from: f */
    private List<InterfaceC1950e> f5440f;

    /* renamed from: g */
    private List<InterfaceC1950e> f5441g;

    /* renamed from: h */
    private int f5442h;

    /* renamed from: i */
    private PointF f5443i;

    /* renamed from: j */
    private PointF f5444j;

    /* renamed from: k */
    private float f5445k;

    /* renamed from: l */
    private C1952g f5446l;

    /* renamed from: m */
    private C1946a f5447m;

    /* renamed from: n */
    private GestureDetector f5448n;

    /* renamed from: com.navatics.app.widget.PinchImageView$e */
    /* loaded from: classes.dex */
    public interface InterfaceC1950e {
        /* renamed from: a */
        void m7121a(PinchImageView pinchImageView);
    }

    /* renamed from: a */
    protected float m7157a(float f, float f2) {
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
        this.f5435a = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f5436b = onLongClickListener;
    }

    /* renamed from: a */
    public Matrix m7155a(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        } else {
            matrix.reset();
        }
        if (m7145c()) {
            RectF m7134a = C1947b.m7134a(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            RectF m7134a2 = C1947b.m7134a(0.0f, 0.0f, getWidth(), getHeight());
            matrix.setRectToRect(m7134a, m7134a2, Matrix.ScaleToFit.CENTER);
            C1947b.m7132a(m7134a2);
            C1947b.m7132a(m7134a);
        }
        return matrix;
    }

    /* renamed from: b */
    public Matrix m7148b(Matrix matrix) {
        Matrix m7155a = m7155a(matrix);
        m7155a.postConcat(this.f5437c);
        return m7155a;
    }

    /* renamed from: a */
    public RectF m7153a(RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        } else {
            rectF.setEmpty();
        }
        if (m7145c()) {
            Matrix m7135a = C1947b.m7135a();
            m7148b(m7135a);
            rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            m7135a.mapRect(rectF);
            C1947b.m7128b(m7135a);
            return rectF;
        }
        return rectF;
    }

    public RectF getMask() {
        RectF rectF = this.f5438d;
        if (rectF != null) {
            return new RectF(rectF);
        }
        return null;
    }

    public int getPinchMode() {
        return this.f5439e;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f5439e == 2) {
            return true;
        }
        RectF m7153a = m7153a((RectF) null);
        if (m7153a == null || m7153a.isEmpty()) {
            return false;
        }
        return i > 0 ? m7153a.right > ((float) getWidth()) : m7153a.left < 0.0f;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (this.f5439e == 2) {
            return true;
        }
        RectF m7153a = m7153a((RectF) null);
        if (m7153a == null || m7153a.isEmpty()) {
            return false;
        }
        return i > 0 ? m7153a.bottom > ((float) getHeight()) : m7153a.top < 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7158a() {
        List<InterfaceC1950e> list;
        List<InterfaceC1950e> list2 = this.f5440f;
        if (list2 == null) {
            return;
        }
        this.f5442h++;
        for (InterfaceC1950e interfaceC1950e : list2) {
            interfaceC1950e.m7121a(this);
        }
        this.f5442h--;
        if (this.f5442h != 0 || (list = this.f5441g) == null) {
            return;
        }
        this.f5440f = list;
        this.f5441g = null;
    }

    public PinchImageView(Context context) {
        super(context);
        this.f5437c = new Matrix();
        this.f5439e = 0;
        this.f5443i = new PointF();
        this.f5444j = new PointF();
        this.f5445k = 0.0f;
        this.f5448n = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.navatics.app.widget.PinchImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (PinchImageView.this.f5439e == 0) {
                    if (PinchImageView.this.f5446l == null || !PinchImageView.this.f5446l.isRunning()) {
                        PinchImageView.this.m7140d(f, f2);
                        return true;
                    }
                    return true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PinchImageView.this.f5436b != null) {
                    PinchImageView.this.f5436b.onLongClick(PinchImageView.this);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (PinchImageView.this.f5439e == 1 && (PinchImageView.this.f5446l == null || !PinchImageView.this.f5446l.isRunning())) {
                    PinchImageView.this.m7144c(motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (PinchImageView.this.f5435a != null) {
                    PinchImageView.this.f5435a.onClick(PinchImageView.this);
                    return true;
                }
                return true;
            }
        });
        m7150b();
    }

    public PinchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5437c = new Matrix();
        this.f5439e = 0;
        this.f5443i = new PointF();
        this.f5444j = new PointF();
        this.f5445k = 0.0f;
        this.f5448n = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.navatics.app.widget.PinchImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (PinchImageView.this.f5439e == 0) {
                    if (PinchImageView.this.f5446l == null || !PinchImageView.this.f5446l.isRunning()) {
                        PinchImageView.this.m7140d(f, f2);
                        return true;
                    }
                    return true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PinchImageView.this.f5436b != null) {
                    PinchImageView.this.f5436b.onLongClick(PinchImageView.this);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (PinchImageView.this.f5439e == 1 && (PinchImageView.this.f5446l == null || !PinchImageView.this.f5446l.isRunning())) {
                    PinchImageView.this.m7144c(motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (PinchImageView.this.f5435a != null) {
                    PinchImageView.this.f5435a.onClick(PinchImageView.this);
                    return true;
                }
                return true;
            }
        });
        m7150b();
    }

    public PinchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5437c = new Matrix();
        this.f5439e = 0;
        this.f5443i = new PointF();
        this.f5444j = new PointF();
        this.f5445k = 0.0f;
        this.f5448n = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.navatics.app.widget.PinchImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (PinchImageView.this.f5439e == 0) {
                    if (PinchImageView.this.f5446l == null || !PinchImageView.this.f5446l.isRunning()) {
                        PinchImageView.this.m7140d(f, f2);
                        return true;
                    }
                    return true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PinchImageView.this.f5436b != null) {
                    PinchImageView.this.f5436b.onLongClick(PinchImageView.this);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (PinchImageView.this.f5439e == 1 && (PinchImageView.this.f5446l == null || !PinchImageView.this.f5446l.isRunning())) {
                    PinchImageView.this.m7144c(motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (PinchImageView.this.f5435a != null) {
                    PinchImageView.this.f5435a.onClick(PinchImageView.this);
                    return true;
                }
                return true;
            }
        });
        m7150b();
    }

    /* renamed from: b */
    private void m7150b() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (m7145c()) {
            Matrix m7135a = C1947b.m7135a();
            setImageMatrix(m7148b(m7135a));
            C1947b.m7128b(m7135a);
        }
        if (this.f5438d != null) {
            canvas.save();
            canvas.clipRect(this.f5438d);
            super.onDraw(canvas);
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }

    /* renamed from: c */
    private boolean m7145c() {
        return getDrawable() != null && getDrawable().getIntrinsicWidth() > 0 && getDrawable().getIntrinsicHeight() > 0 && getWidth() > 0 && getHeight() > 0;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C1952g c1952g;
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            if (this.f5439e == 2) {
                m7141d();
            }
            this.f5439e = 0;
        } else if (action == 6) {
            if (this.f5439e == 2 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    m7156a(motionEvent.getX(1), motionEvent.getY(1), motionEvent.getX(2), motionEvent.getY(2));
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    m7156a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(2), motionEvent.getY(2));
                }
            }
        } else if (action == 0) {
            C1952g c1952g2 = this.f5446l;
            if (c1952g2 == null || !c1952g2.isRunning()) {
                m7138e();
                this.f5439e = 1;
                this.f5443i.set(motionEvent.getX(), motionEvent.getY());
            }
        } else if (action == 5) {
            m7138e();
            this.f5439e = 2;
            m7156a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        } else if (action == 2 && ((c1952g = this.f5446l) == null || !c1952g.isRunning())) {
            int i = this.f5439e;
            if (i == 1) {
                m7149b(motionEvent.getX() - this.f5443i.x, motionEvent.getY() - this.f5443i.y);
                this.f5443i.set(motionEvent.getX(), motionEvent.getY());
            } else if (i == 2 && motionEvent.getPointerCount() > 1) {
                float m7129b = C1947b.m7129b(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                float[] m7127c = C1947b.m7127c(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                this.f5443i.set(m7127c[0], m7127c[1]);
                m7154a(this.f5444j, this.f5445k, m7129b, this.f5443i);
            }
        }
        this.f5448n.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m7149b(float f, float f2) {
        if (m7145c()) {
            RectF m7130b = C1947b.m7130b();
            m7153a(m7130b);
            float width = getWidth();
            float height = getHeight();
            if (m7130b.right - m7130b.left < width) {
                f = 0.0f;
            } else if (m7130b.left + f > 0.0f) {
                f = m7130b.left < 0.0f ? -m7130b.left : 0.0f;
            } else if (m7130b.right + f < width) {
                f = m7130b.right > width ? width - m7130b.right : 0.0f;
            }
            if (m7130b.bottom - m7130b.top < height) {
                f2 = 0.0f;
            } else if (m7130b.top + f2 > 0.0f) {
                f2 = m7130b.top < 0.0f ? -m7130b.top : 0.0f;
            } else if (m7130b.bottom + f2 < height) {
                f2 = m7130b.bottom > height ? height - m7130b.bottom : 0.0f;
            }
            C1947b.m7132a(m7130b);
            this.f5437c.postTranslate(f, f2);
            m7158a();
            invalidate();
            return (f == 0.0f && f2 == 0.0f) ? false : true;
        }
        return false;
    }

    /* renamed from: a */
    private void m7156a(float f, float f2, float f3, float f4) {
        this.f5445k = C1947b.m7126c(this.f5437c)[0] / C1947b.m7129b(f, f2, f3, f4);
        float[] m7131a = C1947b.m7131a(C1947b.m7127c(f, f2, f3, f4), this.f5437c);
        this.f5444j.set(m7131a[0], m7131a[1]);
    }

    /* renamed from: a */
    private void m7154a(PointF pointF, float f, float f2, PointF pointF2) {
        if (m7145c()) {
            float f3 = f * f2;
            Matrix m7135a = C1947b.m7135a();
            m7135a.postScale(f3, f3, pointF.x, pointF.y);
            m7135a.postTranslate(pointF2.x - pointF.x, pointF2.y - pointF.y);
            this.f5437c.set(m7135a);
            C1947b.m7128b(m7135a);
            m7158a();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7144c(float f, float f2) {
        float f3;
        if (m7145c()) {
            Matrix m7135a = C1947b.m7135a();
            m7155a(m7135a);
            float f4 = C1947b.m7126c(m7135a)[0];
            float f5 = C1947b.m7126c(this.f5437c)[0];
            float f6 = f4 * f5;
            float width = getWidth();
            float height = getHeight();
            float maxScale = getMaxScale();
            float m7157a = m7157a(f4, f5);
            if (m7157a > maxScale) {
                m7157a = maxScale;
            }
            if (m7157a >= f4) {
                f4 = m7157a;
            }
            Matrix m7133a = C1947b.m7133a(this.f5437c);
            float f7 = f4 / f6;
            m7133a.postScale(f7, f7, f, f2);
            float f8 = width / 2.0f;
            float f9 = height / 2.0f;
            m7133a.postTranslate(f8 - f, f9 - f2);
            Matrix m7133a2 = C1947b.m7133a(m7135a);
            m7133a2.postConcat(m7133a);
            float f10 = 0.0f;
            RectF m7134a = C1947b.m7134a(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            m7133a2.mapRect(m7134a);
            if (m7134a.right - m7134a.left < width) {
                f3 = f8 - ((m7134a.right + m7134a.left) / 2.0f);
            } else if (m7134a.left > 0.0f) {
                f3 = -m7134a.left;
            } else {
                f3 = m7134a.right < width ? width - m7134a.right : 0.0f;
            }
            if (m7134a.bottom - m7134a.top < height) {
                f10 = f9 - ((m7134a.bottom + m7134a.top) / 2.0f);
            } else if (m7134a.top > 0.0f) {
                f10 = -m7134a.top;
            } else if (m7134a.bottom < height) {
                f10 = height - m7134a.bottom;
            }
            m7133a.postTranslate(f3, f10);
            m7138e();
            this.f5446l = new C1952g(this, this.f5437c, m7133a);
            this.f5446l.start();
            C1947b.m7132a(m7134a);
            C1947b.m7128b(m7133a2);
            C1947b.m7128b(m7133a);
            C1947b.m7128b(m7135a);
        }
    }

    /* renamed from: d */
    private void m7141d() {
        float f;
        float f2;
        if (m7145c()) {
            Matrix m7135a = C1947b.m7135a();
            m7148b(m7135a);
            float f3 = C1947b.m7126c(m7135a)[0];
            float f4 = C1947b.m7126c(this.f5437c)[0];
            float width = getWidth();
            float height = getHeight();
            float maxScale = getMaxScale();
            float f5 = f3 > maxScale ? maxScale / f3 : 1.0f;
            if (f4 * f5 < 1.0f) {
                f5 = 1.0f / f4;
            }
            boolean z = f5 != 1.0f;
            Matrix m7133a = C1947b.m7133a(m7135a);
            m7133a.postScale(f5, f5, this.f5443i.x, this.f5443i.y);
            RectF m7134a = C1947b.m7134a(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            m7133a.mapRect(m7134a);
            if (m7134a.right - m7134a.left < width) {
                f = (width / 2.0f) - ((m7134a.right + m7134a.left) / 2.0f);
            } else if (m7134a.left > 0.0f) {
                f = -m7134a.left;
            } else {
                f = m7134a.right < width ? width - m7134a.right : 0.0f;
            }
            if (m7134a.bottom - m7134a.top < height) {
                f2 = (height / 2.0f) - ((m7134a.bottom + m7134a.top) / 2.0f);
            } else if (m7134a.top > 0.0f) {
                f2 = -m7134a.top;
            } else {
                f2 = m7134a.bottom < height ? height - m7134a.bottom : 0.0f;
            }
            if ((f == 0.0f && f2 == 0.0f) ? true : true) {
                Matrix m7133a2 = C1947b.m7133a(this.f5437c);
                m7133a2.postScale(f5, f5, this.f5443i.x, this.f5443i.y);
                m7133a2.postTranslate(f, f2);
                m7138e();
                this.f5446l = new C1952g(this, this.f5437c, m7133a2);
                this.f5446l.start();
                C1947b.m7128b(m7133a2);
            }
            C1947b.m7132a(m7134a);
            C1947b.m7128b(m7133a);
            C1947b.m7128b(m7135a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7140d(float f, float f2) {
        if (m7145c()) {
            m7138e();
            this.f5447m = new C1946a(f / 60.0f, f2 / 60.0f);
            this.f5447m.start();
        }
    }

    /* renamed from: e */
    private void m7138e() {
        C1952g c1952g = this.f5446l;
        if (c1952g != null) {
            c1952g.cancel();
            this.f5446l = null;
        }
        C1946a c1946a = this.f5447m;
        if (c1946a != null) {
            c1946a.cancel();
            this.f5447m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.PinchImageView$a */
    /* loaded from: classes.dex */
    public class C1946a extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b */
        private float[] f5451b;

        public C1946a(float f, float f2) {
            setFloatValues(0.0f, 1.0f);
            setDuration(1000000L);
            addUpdateListener(this);
            this.f5451b = new float[]{f, f2};
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PinchImageView pinchImageView = PinchImageView.this;
            float[] fArr = this.f5451b;
            boolean m7149b = pinchImageView.m7149b(fArr[0], fArr[1]);
            float[] fArr2 = this.f5451b;
            fArr2[0] = fArr2[0] * 0.9f;
            fArr2[1] = fArr2[1] * 0.9f;
            if (!m7149b || C1947b.m7129b(0.0f, 0.0f, fArr2[0], fArr2[1]) < 1.0f) {
                valueAnimator.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.PinchImageView$g */
    /* loaded from: classes.dex */
    public class C1952g extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b */
        private float[] f5457b;

        /* renamed from: c */
        private float[] f5458c;

        /* renamed from: d */
        private float[] f5459d;

        public C1952g(PinchImageView pinchImageView, Matrix matrix, Matrix matrix2) {
            this(matrix, matrix2, 200L);
        }

        public C1952g(Matrix matrix, Matrix matrix2, long j) {
            this.f5457b = new float[9];
            this.f5458c = new float[9];
            this.f5459d = new float[9];
            setFloatValues(0.0f, 1.0f);
            setDuration(j);
            addUpdateListener(this);
            matrix.getValues(this.f5457b);
            matrix2.getValues(this.f5458c);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f5459d;
                float[] fArr2 = this.f5457b;
                fArr[i] = fArr2[i] + ((this.f5458c[i] - fArr2[i]) * floatValue);
            }
            PinchImageView.this.f5437c.setValues(this.f5459d);
            PinchImageView.this.m7158a();
            PinchImageView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.PinchImageView$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1949d<T> {

        /* renamed from: a */
        private int f5454a;

        /* renamed from: b */
        private Queue<T> f5455b = new LinkedList();

        /* renamed from: a */
        protected abstract T mo7118a(T t);

        /* renamed from: b */
        protected abstract T mo7117b();

        public AbstractC1949d(int i) {
            this.f5454a = i;
        }

        /* renamed from: c */
        public T m7122c() {
            if (this.f5455b.size() == 0) {
                return mo7117b();
            }
            return mo7118a(this.f5455b.poll());
        }

        /* renamed from: b */
        public void m7123b(T t) {
            if (t == null || this.f5455b.size() >= this.f5454a) {
                return;
            }
            this.f5455b.offer(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.PinchImageView$c */
    /* loaded from: classes.dex */
    public static class C1948c extends AbstractC1949d<Matrix> {
        public C1948c(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.navatics.app.widget.PinchImageView.AbstractC1949d
        /* renamed from: a */
        public Matrix mo7117b() {
            return new Matrix();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.navatics.app.widget.PinchImageView.AbstractC1949d
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Matrix mo7118a(Matrix matrix) {
            matrix.reset();
            return matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.PinchImageView$f */
    /* loaded from: classes.dex */
    public static class C1951f extends AbstractC1949d<RectF> {
        public C1951f(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.navatics.app.widget.PinchImageView.AbstractC1949d
        /* renamed from: a */
        public RectF mo7117b() {
            return new RectF();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.navatics.app.widget.PinchImageView.AbstractC1949d
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public RectF mo7118a(RectF rectF) {
            rectF.setEmpty();
            return rectF;
        }
    }

    /* renamed from: com.navatics.app.widget.PinchImageView$b */
    /* loaded from: classes.dex */
    public static class C1947b {

        /* renamed from: a */
        private static C1948c f5452a = new C1948c(16);

        /* renamed from: b */
        private static C1951f f5453b = new C1951f(16);

        /* renamed from: a */
        public static Matrix m7135a() {
            return f5452a.m7122c();
        }

        /* renamed from: a */
        public static Matrix m7133a(Matrix matrix) {
            Matrix c = f5452a.m7122c();
            if (matrix != null) {
                c.set(matrix);
            }
            return c;
        }

        /* renamed from: b */
        public static void m7128b(Matrix matrix) {
            f5452a.m7123b(matrix);
        }

        /* renamed from: b */
        public static RectF m7130b() {
            return f5453b.m7122c();
        }

        /* renamed from: a */
        public static RectF m7134a(float f, float f2, float f3, float f4) {
            RectF c = f5453b.m7122c();
            c.set(f, f2, f3, f4);
            return c;
        }

        /* renamed from: a */
        public static void m7132a(RectF rectF) {
            f5453b.m7123b(rectF);
        }

        /* renamed from: b */
        public static float m7129b(float f, float f2, float f3, float f4) {
            float f5 = f - f3;
            float f6 = f2 - f4;
            return (float) Math.sqrt((f5 * f5) + (f6 * f6));
        }

        /* renamed from: c */
        public static float[] m7127c(float f, float f2, float f3, float f4) {
            return new float[]{(f + f3) / 2.0f, (f2 + f4) / 2.0f};
        }

        /* renamed from: c */
        public static float[] m7126c(Matrix matrix) {
            if (matrix != null) {
                float[] fArr = new float[9];
                matrix.getValues(fArr);
                return new float[]{fArr[0], fArr[4]};
            }
            return new float[2];
        }

        /* renamed from: a */
        public static float[] m7131a(float[] fArr, Matrix matrix) {
            if (fArr != null && matrix != null) {
                float[] fArr2 = new float[2];
                Matrix m7135a = m7135a();
                matrix.invert(m7135a);
                m7135a.mapPoints(fArr2, fArr);
                m7128b(m7135a);
                return fArr2;
            }
            return new float[2];
        }
    }
}
