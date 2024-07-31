package com.navatics.app.widget.xbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.p008v4.app.NotificationCompat;
import android.support.p008v4.graphics.drawable.DrawableCompat;
import android.support.p008v4.util.Pools;
import android.support.p008v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import com.navatics.app.R;
import java.util.ArrayList;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class XBar extends View {

    /* renamed from: f */
    private static final C3044k f5750f = C3044k.m1564a(XBar.class);

    /* renamed from: y */
    private static final DecelerateInterpolator f5751y = new DecelerateInterpolator();

    /* renamed from: A */
    private InterfaceC1980a f5752A;

    /* renamed from: a */
    int f5753a;

    /* renamed from: b */
    int f5754b;

    /* renamed from: c */
    int f5755c;

    /* renamed from: d */
    int f5756d;

    /* renamed from: e */
    float f5757e;

    /* renamed from: g */
    private int f5758g;

    /* renamed from: h */
    private Drawable f5759h;

    /* renamed from: i */
    private Drawable f5760i;

    /* renamed from: j */
    private Drawable f5761j;

    /* renamed from: k */
    private int f5762k;

    /* renamed from: l */
    private Drawable f5763l;

    /* renamed from: m */
    private int f5764m;

    /* renamed from: n */
    private float f5765n;

    /* renamed from: o */
    private boolean f5766o;

    /* renamed from: p */
    private float f5767p;

    /* renamed from: q */
    private int f5768q;

    /* renamed from: r */
    private int f5769r;

    /* renamed from: s */
    private RunnableC1982c f5770s;

    /* renamed from: t */
    private long f5771t;

    /* renamed from: u */
    private boolean f5772u;

    /* renamed from: v */
    private boolean f5773v;

    /* renamed from: w */
    private final ArrayList<C1981b> f5774w;

    /* renamed from: x */
    private float f5775x;

    /* renamed from: z */
    private final Property<XBar, Float> f5776z;

    /* renamed from: com.navatics.app.widget.xbar.XBar$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1980a {
        /* renamed from: a */
        void mo6878a(XBar xBar);

        /* renamed from: a */
        void mo6877a(XBar xBar, int i, boolean z);

        /* renamed from: b */
        void mo6876b(XBar xBar);
    }

    /* renamed from: a */
    private static int m6907a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public XBar(Context context) {
        super(context);
        this.f5758g = 1;
        this.f5774w = new ArrayList<>();
        this.f5776z = new Property<XBar, Float>(Float.class, "visual_progress") { // from class: com.navatics.app.widget.xbar.XBar.1
            @Override // android.util.Property
            /* renamed from: a */
            public void set(XBar xBar, Float f) {
                xBar.m6890b(XBar.this.m6892a(NotificationCompat.CATEGORY_PROGRESS), f.floatValue());
                xBar.f5775x = f.floatValue();
            }

            @Override // android.util.Property
            /* renamed from: a */
            public Float get(XBar xBar) {
                return Float.valueOf(xBar.f5775x);
            }
        };
        m6902a(context, (AttributeSet) null, 0, 0);
    }

    public XBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5758g = 1;
        this.f5774w = new ArrayList<>();
        this.f5776z = new Property<XBar, Float>(Float.class, "visual_progress") { // from class: com.navatics.app.widget.xbar.XBar.1
            @Override // android.util.Property
            /* renamed from: a */
            public void set(XBar xBar, Float f) {
                xBar.m6890b(XBar.this.m6892a(NotificationCompat.CATEGORY_PROGRESS), f.floatValue());
                xBar.f5775x = f.floatValue();
            }

            @Override // android.util.Property
            /* renamed from: a */
            public Float get(XBar xBar) {
                return Float.valueOf(xBar.f5775x);
            }
        };
        m6902a(context, attributeSet, 0, 0);
    }

    public XBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5758g = 1;
        this.f5774w = new ArrayList<>();
        this.f5776z = new Property<XBar, Float>(Float.class, "visual_progress") { // from class: com.navatics.app.widget.xbar.XBar.1
            @Override // android.util.Property
            /* renamed from: a */
            public void set(XBar xBar, Float f) {
                xBar.m6890b(XBar.this.m6892a(NotificationCompat.CATEGORY_PROGRESS), f.floatValue());
                xBar.f5775x = f.floatValue();
            }

            @Override // android.util.Property
            /* renamed from: a */
            public Float get(XBar xBar) {
                return Float.valueOf(xBar.f5775x);
            }
        };
        m6902a(context, attributeSet, i, 0);
    }

    /* renamed from: c */
    private void m6885c() {
        this.f5769r = 100;
        this.f5768q = 10;
        this.f5753a = 24;
        this.f5754b = 48;
        this.f5755c = 24;
        this.f5756d = 48;
    }

    /* renamed from: a */
    private void m6902a(Context context, AttributeSet attributeSet, int i, int i2) {
        m6885c();
        this.f5771t = Thread.currentThread().getId();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XBar, i, i2);
        String string = obtainStyledAttributes.getString(9);
        if (!TextUtils.isEmpty(string)) {
            if ("horizontal".equals(string)) {
                this.f5758g = 2;
            } else if ("vertical".equals(string)) {
                this.f5758g = 1;
            } else {
                throw new RuntimeException("unknown orientation : " + string);
            }
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(4);
        if (drawable != null) {
            setProgressDrawable(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(5);
        if (drawable2 != null) {
            setThumb(drawable2);
        }
        setThumbOffset(obtainStyledAttributes.getDimensionPixelOffset(6, getThumbOffset()));
        obtainStyledAttributes.getBoolean(8, true);
        this.f5767p = 1.0f;
        setTickMark(obtainStyledAttributes.getDrawable(7));
        this.f5753a = obtainStyledAttributes.getDimensionPixelSize(3, this.f5753a);
        this.f5754b = obtainStyledAttributes.getDimensionPixelSize(1, this.f5754b);
        this.f5755c = obtainStyledAttributes.getDimensionPixelSize(2, this.f5755c);
        this.f5756d = obtainStyledAttributes.getDimensionPixelSize(0, this.f5756d);
        obtainStyledAttributes.recycle();
    }

    public int getThumbOffset() {
        return this.f5762k;
    }

    public void setThumbOffset(int i) {
        this.f5762k = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5774w != null) {
            synchronized (this) {
                int size = this.f5774w.size();
                for (int i = 0; i < size; i++) {
                    C1981b c1981b = this.f5774w.get(i);
                    m6905a(c1981b.f5779a, c1981b.f5780b, c1981b.f5781c, true, c1981b.f5782d);
                    c1981b.m6875a();
                }
                this.f5774w.clear();
            }
        }
        this.f5772u = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        RunnableC1982c runnableC1982c = this.f5770s;
        if (runnableC1982c != null) {
            removeCallbacks(runnableC1982c);
            this.f5773v = false;
        }
        super.onDetachedFromWindow();
        this.f5772u = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m6908a(i, i2);
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Drawable drawable = this.f5761j;
        int intrinsicWidth = this.f5759h == null ? 0 : this.f5759h.getIntrinsicWidth();
        if (drawable != null) {
            i4 = Math.max(this.f5755c, Math.min(this.f5756d, drawable.getIntrinsicHeight()));
            i3 = Math.max(intrinsicWidth, Math.max(this.f5753a, Math.min(this.f5754b, drawable.getIntrinsicWidth())));
        } else {
            i3 = 0;
            i4 = 0;
        }
        setMeasuredDimension(resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.f5769r) {
            this.f5769r = i;
            postInvalidate();
            if (this.f5768q > i) {
                this.f5768q = i;
            }
            m6906a(m6892a(NotificationCompat.CATEGORY_PROGRESS), this.f5768q, false, false);
        }
    }

    public void setTickMark(Drawable drawable) {
        Drawable drawable2 = this.f5763l;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f5763l = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this));
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
        invalidate();
    }

    public void setThumb(Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.f5759h;
        if (drawable2 == null || drawable == drawable2) {
            z = false;
        } else {
            drawable2.setCallback(null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            if (canResolveLayoutDirection() && Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            this.f5762k = drawable.getIntrinsicHeight() / 2;
            if (z && (drawable.getIntrinsicWidth() != this.f5759h.getIntrinsicWidth() || drawable.getIntrinsicHeight() != this.f5759h.getIntrinsicHeight())) {
                requestLayout();
            }
            if (this.f5759h == null || drawable.getIntrinsicWidth() != this.f5759h.getIntrinsicWidth() || drawable.getIntrinsicHeight() != this.f5759h.getIntrinsicHeight()) {
                requestLayout();
            }
        }
        this.f5759h = drawable;
        invalidate();
        if (z) {
            m6908a(getWidth(), getHeight());
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    /* renamed from: a */
    private void m6908a(int i, int i2) {
        int i3;
        int i4;
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        Drawable drawable = this.f5761j;
        Drawable drawable2 = this.f5759h;
        int min = Math.min(this.f5754b, paddingLeft);
        int intrinsicWidth = drawable2 == null ? 0 : drawable2.getIntrinsicWidth();
        if (intrinsicWidth > min) {
            int i5 = (paddingLeft - intrinsicWidth) / 2;
            int i6 = ((intrinsicWidth - min) / 2) + i5;
            i4 = i5;
            i3 = i6;
        } else {
            i3 = (paddingLeft - min) / 2;
            i4 = ((min - intrinsicWidth) / 2) + i3;
        }
        if (drawable != null) {
            drawable.setBounds(i3, 0, min + i3, (i2 - getPaddingTop()) - getPaddingBottom());
        }
        if (drawable2 != null) {
            m6904a(i2, drawable2, getScale(), i4);
        }
    }

    /* renamed from: a */
    private void m6904a(int i, Drawable drawable, float f, int i2) {
        int i3;
        int paddingTop = (i - getPaddingTop()) - getPaddingBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i4 = (paddingTop - intrinsicHeight) + (this.f5762k * 2);
        int i5 = (int) ((f * i4) + 0.5f);
        if (i2 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            int i6 = bounds.left;
            i3 = bounds.right;
            i2 = i6;
        } else {
            i3 = intrinsicWidth + i2;
        }
        int i7 = i4 - i5;
        int i8 = intrinsicHeight + i7;
        Drawable background = getBackground();
        if (background != null) {
            int paddingLeft = getPaddingLeft() - this.f5762k;
            int paddingTop2 = getPaddingTop();
            background.setHotspotBounds(i2 + paddingLeft, i7 + paddingTop2, paddingLeft + i3, paddingTop2 + i8);
        }
        drawable.setBounds(i2, i7, i3, i8);
    }

    public synchronized void setProgress(int i) {
        m6903a(i, false, false);
    }

    /* renamed from: a */
    synchronized boolean m6903a(int i, boolean z, boolean z2) {
        int m6907a = m6907a(i, 0, this.f5769r);
        if (m6907a == this.f5768q) {
            return false;
        }
        this.f5768q = m6907a;
        m6906a(m6892a(NotificationCompat.CATEGORY_PROGRESS), this.f5768q, z, z2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m6892a(String str) {
        return Resources.getSystem().getIdentifier(str, "id", "android");
    }

    private float getScale() {
        int max = getMax();
        if (max > 0) {
            return getProgress() / max;
        }
        return 0.0f;
    }

    public synchronized int getMax() {
        return this.f5769r;
    }

    public synchronized int getProgress() {
        return this.f5768q;
    }

    /* renamed from: d */
    private boolean m6883d() {
        for (ViewParent parent = getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (m6883d()) {
                        this.f5765n = motionEvent.getX();
                        return true;
                    }
                    m6899a(motionEvent);
                    return true;
                case 1:
                    if (this.f5766o) {
                        m6887b(motionEvent);
                        m6891b();
                        setPressed(false);
                    } else {
                        m6911a();
                        m6887b(motionEvent);
                        m6891b();
                    }
                    invalidate();
                    return true;
                case 2:
                    if (this.f5766o) {
                        m6887b(motionEvent);
                        return true;
                    } else if (Math.abs(motionEvent.getX() - this.f5765n) > this.f5764m) {
                        m6899a(motionEvent);
                        return true;
                    } else {
                        return true;
                    }
                case 3:
                    if (this.f5766o) {
                        m6891b();
                        setPressed(false);
                    }
                    invalidate();
                    return true;
                default:
                    return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m6899a(MotionEvent motionEvent) {
        setPressed(true);
        Drawable drawable = this.f5759h;
        if (drawable != null) {
            invalidate(drawable.getBounds());
        }
        m6911a();
        m6887b(motionEvent);
        m6882e();
    }

    /* renamed from: b */
    private void m6887b(MotionEvent motionEvent) {
        Math.round(motionEvent.getX());
        int round = Math.round(motionEvent.getY());
        int height = getHeight();
        int paddingTop = (height - getPaddingTop()) - getPaddingBottom();
        int paddingTop2 = getPaddingTop() + height;
        float f = 1.0f;
        float f2 = 0.0f;
        if (round > paddingTop2) {
            f = 0.0f;
        } else if (round >= getPaddingTop()) {
            f = 1.0f - ((round - getPaddingTop()) / paddingTop);
            f2 = this.f5757e;
        }
        m6903a(Math.round(f2 + (f * getMax())), true, false);
    }

    /* renamed from: a */
    void m6911a() {
        this.f5766o = true;
        InterfaceC1980a interfaceC1980a = this.f5752A;
        if (interfaceC1980a != null) {
            interfaceC1980a.mo6878a(this);
        }
    }

    /* renamed from: b */
    void m6891b() {
        this.f5766o = false;
        InterfaceC1980a interfaceC1980a = this.f5752A;
        if (interfaceC1980a != null) {
            interfaceC1980a.mo6876b(this);
        }
    }

    /* renamed from: e */
    private void m6882e() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f5759h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f5763l;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null && this.f5767p < 1.0f) {
            progressDrawable.setAlpha(isEnabled() ? 255 : (int) (this.f5767p * 255.0f));
        }
        Drawable drawable = this.f5759h;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidateDrawable(drawable);
        }
        Drawable drawable2 = this.f5763l;
        if (drawable2 != null && drawable2.isStateful() && drawable2.setState(getDrawableState())) {
            invalidateDrawable(drawable2);
        }
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m6888b(canvas);
        mo6901a(canvas);
        m6884c(canvas);
    }

    /* renamed from: b */
    private void m6888b(Canvas canvas) {
        Drawable drawable = this.f5761j;
        if (drawable != null) {
            int save = canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* renamed from: c */
    private void m6884c(Canvas canvas) {
        if (this.f5759h != null) {
            int save = canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop() - this.f5762k);
            this.f5759h.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* renamed from: a */
    void mo6901a(Canvas canvas) {
        if (this.f5763l != null) {
            int max = getMax();
            if (max > 1) {
                int intrinsicWidth = this.f5763l.getIntrinsicWidth();
                int intrinsicHeight = this.f5763l.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f5763l.setBounds(-i, -i2, i, i2);
                float height = ((getHeight() - getPaddingTop()) - getPaddingBottom()) / max;
                int save = canvas.save();
                canvas.translate(getWidth() / 2, getPaddingTop());
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f5763l.draw(canvas);
                    canvas.translate(0.0f, height);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public Drawable getProgressDrawable() {
        return this.f5761j;
    }

    public void setProgressDrawable(Drawable drawable) {
        Drawable drawable2 = this.f5760i;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f5760i);
            }
            this.f5760i = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                if (Build.VERSION.SDK_INT >= 23) {
                    drawable.setLayoutDirection(getLayoutDirection());
                }
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (this.f5754b < minimumWidth) {
                    this.f5754b = minimumWidth;
                    requestLayout();
                }
            }
            m6900a(drawable);
            postInvalidate();
            m6889b(getWidth(), getHeight());
            m6881f();
            m6905a(m6892a(NotificationCompat.CATEGORY_PROGRESS), this.f5768q, false, false, false);
        }
    }

    /* renamed from: a */
    private void m6900a(Drawable drawable) {
        Drawable drawable2 = this.f5761j;
        this.f5761j = drawable;
        if (drawable2 != this.f5761j) {
            if (drawable2 != null) {
                drawable2.setVisible(false, false);
            }
            Drawable drawable3 = this.f5761j;
            if (drawable3 != null) {
                drawable3.setVisible(getWindowVisibility() == 0 && isShown(), false);
            }
        }
    }

    /* renamed from: b */
    private void m6889b(int i, int i2) {
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        Drawable drawable = this.f5760i;
        if (drawable != null) {
            drawable.setBounds(0, 0, paddingRight, paddingTop);
        }
    }

    /* renamed from: f */
    private void m6881f() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f5760i;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* renamed from: a */
    private synchronized void m6906a(int i, int i2, boolean z, boolean z2) {
        if (this.f5771t == Thread.currentThread().getId()) {
            m6905a(i, i2, z, true, z2);
        } else {
            if (this.f5770s == null) {
                this.f5770s = new RunnableC1982c();
            }
            this.f5774w.add(C1981b.m6874a(i, i2, z, z2));
            if (this.f5772u && !this.f5773v) {
                post(this.f5770s);
                this.f5773v = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m6905a(int i, int i2, boolean z, boolean z2, boolean z3) {
        float f = this.f5769r > 0 ? i2 / this.f5769r : 0.0f;
        boolean z4 = i == m6892a(NotificationCompat.CATEGORY_PROGRESS);
        if (z4 && z3) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.f5776z, f);
            ofFloat.setAutoCancel(true);
            ofFloat.setDuration(80L);
            ofFloat.setInterpolator(f5751y);
            ofFloat.start();
        } else {
            m6890b(i, f);
        }
        if (z4 && z2) {
            m6910a(f, z, i2);
        }
    }

    /* renamed from: a */
    void m6910a(float f, boolean z, int i) {
        InterfaceC1980a interfaceC1980a = this.f5752A;
        if (interfaceC1980a != null) {
            interfaceC1980a.mo6877a(this, i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6890b(int i, float f) {
        this.f5775x = f;
        Drawable drawable = this.f5761j;
        if ((drawable instanceof LayerDrawable) && (drawable = ((LayerDrawable) drawable).findDrawableByLayerId(i)) == null) {
            drawable = this.f5761j;
        }
        if (drawable != null) {
            drawable.setLevel((int) (10000.0f * f));
        } else {
            invalidate();
        }
        m6909a(i, f);
    }

    /* renamed from: a */
    void m6909a(int i, float f) {
        Drawable drawable;
        if (i != m6892a(NotificationCompat.CATEGORY_PROGRESS) || (drawable = this.f5759h) == null) {
            return;
        }
        m6904a(getHeight(), drawable, f, Integer.MIN_VALUE);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.xbar.XBar$b */
    /* loaded from: classes.dex */
    public static class C1981b {

        /* renamed from: e */
        private static final Pools.SynchronizedPool<C1981b> f5778e = new Pools.SynchronizedPool<>(24);

        /* renamed from: a */
        public int f5779a;

        /* renamed from: b */
        public int f5780b;

        /* renamed from: c */
        public boolean f5781c;

        /* renamed from: d */
        public boolean f5782d;

        private C1981b() {
        }

        /* renamed from: a */
        public static C1981b m6874a(int i, int i2, boolean z, boolean z2) {
            C1981b acquire = f5778e.acquire();
            if (acquire == null) {
                acquire = new C1981b();
            }
            acquire.f5779a = i;
            acquire.f5780b = i2;
            acquire.f5781c = z;
            acquire.f5782d = z2;
            return acquire;
        }

        /* renamed from: a */
        public void m6875a() {
            f5778e.release(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.xbar.XBar$c */
    /* loaded from: classes.dex */
    public class RunnableC1982c implements Runnable {
        private RunnableC1982c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (XBar.this) {
                int size = XBar.this.f5774w.size();
                for (int i = 0; i < size; i++) {
                    C1981b c1981b = (C1981b) XBar.this.f5774w.get(i);
                    XBar.this.m6905a(c1981b.f5779a, c1981b.f5780b, c1981b.f5781c, true, c1981b.f5782d);
                    c1981b.m6875a();
                }
                XBar.this.f5774w.clear();
                XBar.this.f5773v = false;
            }
        }
    }

    public void setOnSeekBarChangeListener(InterfaceC1980a interfaceC1980a) {
        this.f5752A = interfaceC1980a;
    }
}
