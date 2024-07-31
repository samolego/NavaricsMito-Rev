package com.navatics.app.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p008v4.app.NotificationCompat;
import android.support.p008v4.graphics.drawable.DrawableCompat;
import android.support.p008v4.util.Pools;
import android.support.p008v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.navatics.app.R;
import java.util.ArrayList;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class DivelogSeekbar extends View {

    /* renamed from: f */
    private static final C3044k f5217f = C3044k.m1564a(DivelogSeekbar.class);

    /* renamed from: A */
    private InterfaceC1923a f5218A;

    /* renamed from: a */
    int f5219a;

    /* renamed from: b */
    int f5220b;

    /* renamed from: c */
    int f5221c;

    /* renamed from: d */
    int f5222d;

    /* renamed from: e */
    float f5223e;

    /* renamed from: g */
    private Drawable f5224g;

    /* renamed from: h */
    private Drawable f5225h;

    /* renamed from: i */
    private Drawable f5226i;

    /* renamed from: j */
    private int f5227j;

    /* renamed from: k */
    private int f5228k;

    /* renamed from: l */
    private long f5229l;

    /* renamed from: m */
    private RunnableC1925c f5230m;

    /* renamed from: n */
    private final ArrayList<C1924b> f5231n;

    /* renamed from: o */
    private boolean f5232o;

    /* renamed from: p */
    private boolean f5233p;

    /* renamed from: q */
    private boolean f5234q;

    /* renamed from: r */
    private boolean f5235r;

    /* renamed from: s */
    private float f5236s;

    /* renamed from: t */
    private int f5237t;

    /* renamed from: u */
    private float f5238u;

    /* renamed from: v */
    private boolean f5239v;

    /* renamed from: w */
    private int f5240w;

    /* renamed from: x */
    private Paint f5241x;

    /* renamed from: y */
    private Rect f5242y;

    /* renamed from: z */
    private int f5243z;

    /* renamed from: com.navatics.app.widget.DivelogSeekbar$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1923a {
        /* renamed from: a */
        void mo7274a(DivelogSeekbar divelogSeekbar);

        /* renamed from: a */
        void mo7273a(DivelogSeekbar divelogSeekbar, int i, boolean z);

        /* renamed from: b */
        void mo7272b(DivelogSeekbar divelogSeekbar);
    }

    /* renamed from: a */
    boolean m7301a() {
        return false;
    }

    public DivelogSeekbar(Context context) {
        this(context, null);
    }

    public DivelogSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DivelogSeekbar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DivelogSeekbar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f5231n = new ArrayList<>();
        this.f5242y = new Rect();
        m7279e();
        this.f5229l = Thread.currentThread().getId();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DivelogSeekbar, i, i2);
        this.f5234q = true;
        Drawable drawable = obtainStyledAttributes.getDrawable(6);
        if (drawable != null) {
            setProgressDrawable(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(7);
        if (drawable2 != null) {
            setThumb(drawable2);
        }
        setThumbOffset(obtainStyledAttributes.getDimensionPixelOffset(8, getThumbOffset()));
        this.f5236s = 1.0f;
        this.f5219a = obtainStyledAttributes.getDimensionPixelSize(4, this.f5219a);
        this.f5220b = obtainStyledAttributes.getDimensionPixelSize(2, this.f5220b);
        this.f5221c = obtainStyledAttributes.getDimensionPixelSize(3, this.f5221c);
        this.f5222d = obtainStyledAttributes.getDimensionPixelSize(1, this.f5222d);
        setMax(obtainStyledAttributes.getInt(0, this.f5228k));
        setProgress(obtainStyledAttributes.getInt(5, this.f5227j));
        this.f5234q = false;
        obtainStyledAttributes.recycle();
        this.f5241x = new Paint();
        this.f5241x.setColor(Color.parseColor("#1A7DA2"));
        this.f5241x.setAntiAlias(true);
        this.f5241x.setStyle(Paint.Style.FILL);
    }

    public int getThumbOffset() {
        return this.f5237t;
    }

    public void setThumbOffset(int i) {
        this.f5237t = i;
        invalidate();
    }

    @Override // android.view.View
    public void postInvalidate() {
        if (this.f5234q) {
            return;
        }
        super.postInvalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5231n != null) {
            synchronized (this) {
                int size = this.f5231n.size();
                for (int i = 0; i < size; i++) {
                    C1924b c1924b = this.f5231n.get(i);
                    m7297a(c1924b.f5246a, c1924b.f5247b, c1924b.f5248c, c1924b.f5249d);
                    c1924b.m7271a();
                }
                this.f5231n.clear();
            }
        }
        this.f5233p = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        RunnableC1925c runnableC1925c = this.f5230m;
        if (runnableC1925c != null) {
            removeCallbacks(runnableC1925c);
        }
        RunnableC1925c runnableC1925c2 = this.f5230m;
        if (runnableC1925c2 != null && this.f5232o) {
            removeCallbacks(runnableC1925c2);
        }
        super.onDetachedFromWindow();
        this.f5233p = false;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5244a = this.f5227j;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.f5244a);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m7295a(i, i2);
        m7284b(i, i2);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (this.f5235r) {
            return;
        }
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m7278f();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null && this.f5236s < 1.0f) {
            progressDrawable.setAlpha(isEnabled() ? 255 : (int) (this.f5236s * 255.0f));
        }
        Drawable drawable = this.f5224g;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.f5225h;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
        Drawable drawable2 = this.f5224g;
        if (drawable2 != null) {
            drawable2.setHotspot(f, f2);
        }
    }

    /* renamed from: a */
    void m7292a(Canvas canvas) {
        Drawable drawable = this.f5226i;
        if (drawable != null) {
            int save = canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f5225h || drawable == this.f5224g || super.verifyDrawable(drawable);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f5225h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f5224g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    /* renamed from: e */
    private void m7279e() {
        this.f5228k = 100;
        this.f5227j = 10;
        this.f5219a = 24;
        this.f5220b = 48;
        this.f5221c = 24;
        this.f5222d = 48;
    }

    /* renamed from: a */
    private int m7287a(String str) {
        return Resources.getSystem().getIdentifier(str, "id", "android");
    }

    public Drawable getProgressDrawable() {
        return this.f5225h;
    }

    Drawable getCurrentDrawable() {
        return this.f5226i;
    }

    public void setProgressDrawable(Drawable drawable) {
        Drawable drawable2 = this.f5225h;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f5225h);
            }
            this.f5225h = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this));
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (this.f5222d < minimumHeight) {
                    this.f5222d = minimumHeight;
                    requestLayout();
                }
            }
            this.f5226i = drawable;
            postInvalidate();
            m7295a(getWidth(), getHeight());
            m7278f();
            m7297a(m7287a(NotificationCompat.CATEGORY_PROGRESS), this.f5227j, false, false);
        }
    }

    /* renamed from: a */
    private void m7295a(int i, int i2) {
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        Drawable drawable = this.f5225h;
        if (drawable != null) {
            drawable.setBounds(0, 0, paddingRight, paddingTop);
        }
    }

    /* renamed from: f */
    private void m7278f() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f5225h;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f5225h.setState(drawableState);
    }

    /* renamed from: a */
    private float m7300a(float f) {
        int i = this.f5228k;
        if (i > 0) {
            return f / i;
        }
        return 0.0f;
    }

    /* renamed from: a */
    private synchronized void m7297a(int i, float f, boolean z, boolean z2) {
        m7296a(i, f, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m7296a(int i, float f, boolean z, boolean z2, boolean z3) {
        float m7300a = m7300a(f);
        Drawable drawable = this.f5226i;
        if (drawable != null) {
            Drawable drawable2 = null;
            if ((drawable instanceof LayerDrawable) && (drawable2 = ((LayerDrawable) drawable).findDrawableByLayerId(i)) != null && canResolveLayoutDirection()) {
                DrawableCompat.setLayoutDirection(drawable2, ViewCompat.getLayoutDirection(this));
            }
            int i2 = (int) (10000.0f * m7300a);
            if (drawable2 != null) {
                drawable = drawable2;
            }
            drawable.setLevel(i2);
        } else {
            invalidate();
        }
        if (i == m7287a(NotificationCompat.CATEGORY_PROGRESS)) {
            m7299a(m7300a, z);
        }
    }

    /* renamed from: a */
    void m7299a(float f, boolean z) {
        if (!m7301a()) {
            setThumbPos(f);
        }
        InterfaceC1923a interfaceC1923a = this.f5218A;
        if (interfaceC1923a != null) {
            interfaceC1923a.mo7273a(this, getProgress(), z);
        }
    }

    /* renamed from: a */
    private synchronized void m7298a(int i, float f, boolean z) {
        m7285b(i, f, z, false);
    }

    /* renamed from: b */
    private synchronized void m7285b(int i, float f, boolean z, boolean z2) {
        if (this.f5229l == Thread.currentThread().getId()) {
            m7296a(i, f, z, true, z2);
        } else {
            if (this.f5230m == null) {
                this.f5230m = new RunnableC1925c();
            }
            this.f5231n.add(C1924b.m7270a(i, f, z, z2));
            if (this.f5233p && !this.f5232o) {
                post(this.f5230m);
                this.f5232o = true;
            }
        }
    }

    public synchronized void setProgress(int i) {
        m7293a(i, false);
    }

    /* renamed from: a */
    synchronized void m7293a(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.f5228k) {
            i = this.f5228k;
        }
        if (i != this.f5227j) {
            this.f5227j = i;
            m7298a(m7287a(NotificationCompat.CATEGORY_PROGRESS), this.f5227j, z);
        }
    }

    public synchronized int getProgress() {
        return this.f5227j;
    }

    public synchronized int getMax() {
        return this.f5228k;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.f5228k) {
            this.f5228k = i;
            postInvalidate();
            if (this.f5227j > i) {
                this.f5227j = i;
            }
            m7298a(m7287a(NotificationCompat.CATEGORY_PROGRESS), this.f5227j, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.DivelogSeekbar$c */
    /* loaded from: classes.dex */
    public class RunnableC1925c implements Runnable {
        private RunnableC1925c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (DivelogSeekbar.this) {
                int size = DivelogSeekbar.this.f5231n.size();
                for (int i = 0; i < size; i++) {
                    C1924b c1924b = (C1924b) DivelogSeekbar.this.f5231n.get(i);
                    DivelogSeekbar.this.m7296a(c1924b.f5246a, c1924b.f5247b, c1924b.f5248c, true, c1924b.f5249d);
                    c1924b.m7271a();
                }
                DivelogSeekbar.this.f5231n.clear();
                DivelogSeekbar.this.f5232o = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.DivelogSeekbar$b */
    /* loaded from: classes.dex */
    public static class C1924b {

        /* renamed from: e */
        private static final Pools.SynchronizedPool<C1924b> f5245e = new Pools.SynchronizedPool<>(24);

        /* renamed from: a */
        public int f5246a;

        /* renamed from: b */
        public float f5247b;

        /* renamed from: c */
        public boolean f5248c;

        /* renamed from: d */
        public boolean f5249d;

        private C1924b() {
        }

        /* renamed from: a */
        public static C1924b m7270a(int i, float f, boolean z, boolean z2) {
            C1924b acquire = f5245e.acquire();
            if (acquire == null) {
                acquire = new C1924b();
            }
            acquire.f5246a = i;
            acquire.f5247b = f;
            acquire.f5248c = z;
            acquire.f5249d = z2;
            return acquire;
        }

        /* renamed from: a */
        public void m7271a() {
            f5245e.release(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.navatics.app.widget.DivelogSeekbar.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f5244a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5244a = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5244a);
        }
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Drawable drawable = this.f5226i;
        int intrinsicHeight = this.f5224g == null ? 0 : this.f5224g.getIntrinsicHeight();
        if (drawable != null) {
            i4 = Math.max(this.f5219a, Math.min(this.f5220b, drawable.getIntrinsicWidth()));
            i3 = Math.max(intrinsicHeight, Math.max(this.f5221c, Math.min(this.f5222d, drawable.getIntrinsicHeight())));
        } else {
            i3 = 0;
            i4 = 0;
        }
        setMeasuredDimension(resolveSizeAndState(i4 + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(i3 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    public void setIndicatorProgress(int i) {
        this.f5243z = i;
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m7292a(canvas);
        m7281c(canvas);
        m7283b(canvas);
    }

    /* renamed from: c */
    private void m7281c(Canvas canvas) {
        if (this.f5243z <= 0) {
            return;
        }
        int i = this.f5226i.getBounds().bottom - this.f5226i.getBounds().top;
        Rect bounds = this.f5225h.getBounds();
        int width = (getWidth() * this.f5243z) / getMax();
        int i2 = bounds.top;
        this.f5242y.set(width, i2, ((int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics())) + width, i + i2);
        canvas.drawRect(this.f5242y, this.f5241x);
    }

    /* renamed from: b */
    void m7283b(Canvas canvas) {
        if (this.f5224g != null) {
            canvas.save();
            canvas.translate(getPaddingLeft() - this.f5237t, getPaddingTop());
            this.f5224g.draw(canvas);
            canvas.restore();
        }
    }

    private float getScale() {
        int max = getMax();
        if (max > 0) {
            return getProgress() / max;
        }
        return 0.0f;
    }

    public void setThumb(Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.f5224g;
        if (drawable2 == null || drawable == drawable2) {
            z = false;
        } else {
            drawable2.setCallback(null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            if (canResolveLayoutDirection()) {
                DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this));
            }
            this.f5237t = drawable.getIntrinsicWidth() / 2;
            if (z && (drawable.getIntrinsicWidth() != this.f5224g.getIntrinsicWidth() || drawable.getIntrinsicHeight() != this.f5224g.getIntrinsicHeight())) {
                requestLayout();
            }
        }
        this.f5224g = drawable;
        invalidate();
        if (z) {
            m7284b(getWidth(), getHeight());
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    /* renamed from: b */
    private void m7284b(int i, int i2) {
        int i3;
        int i4;
        Drawable currentDrawable = getCurrentDrawable();
        Drawable drawable = this.f5224g;
        int min = Math.min(this.f5222d, (i2 - getPaddingTop()) - getPaddingBottom());
        int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
        if (intrinsicHeight > min) {
            i4 = (intrinsicHeight - min) / 2;
            i3 = 0;
        } else {
            i3 = (min - intrinsicHeight) / 2;
            i4 = 0;
        }
        if (currentDrawable != null) {
            currentDrawable.setBounds(0, i4, (i - getPaddingRight()) - getPaddingLeft(), ((i2 - getPaddingBottom()) - i4) - getPaddingTop());
        }
        if (drawable != null) {
            m7294a(i, drawable, getScale(), i3);
        }
    }

    private void setThumbPos(float f) {
        Drawable drawable = this.f5224g;
        if (drawable != null) {
            m7294a(getWidth(), drawable, f, Integer.MIN_VALUE);
            invalidate();
        }
    }

    /* renamed from: a */
    private void m7294a(int i, Drawable drawable, float f, int i2) {
        int i3;
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i4 = (int) ((f * ((paddingLeft - intrinsicWidth) + (this.f5237t * 2))) + 0.5f);
        if (i2 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i2 = bounds.top;
            i3 = bounds.bottom;
        } else {
            i3 = i2 + intrinsicHeight;
        }
        int i5 = intrinsicWidth + i4;
        Drawable background = getBackground();
        if (background != null) {
            drawable.getBounds();
            int paddingLeft2 = getPaddingLeft() - this.f5237t;
            int paddingTop = getPaddingTop();
            background.setHotspotBounds(i4 + paddingLeft2, i2 + paddingTop, paddingLeft2 + i5, paddingTop + i3);
        }
        drawable.setBounds(i4, i2, i5, i3);
    }

    /* renamed from: b */
    public boolean m7286b() {
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
                    if (m7286b()) {
                        this.f5238u = motionEvent.getX();
                        break;
                    } else {
                        setPressed(true);
                        if (this.f5224g != null) {
                            invalidate();
                        }
                        m7282c();
                        m7291a(motionEvent);
                        m7277g();
                        break;
                    }
                case 1:
                    if (this.f5239v) {
                        m7291a(motionEvent);
                        m7280d();
                        setPressed(false);
                    } else {
                        m7282c();
                        m7291a(motionEvent);
                        m7280d();
                    }
                    invalidate();
                    break;
                case 2:
                    if (this.f5239v) {
                        m7291a(motionEvent);
                        break;
                    } else if (Math.abs(motionEvent.getX() - this.f5238u) > this.f5240w) {
                        setPressed(true);
                        Drawable drawable = this.f5224g;
                        if (drawable != null) {
                            invalidate(drawable.getBounds());
                        }
                        m7282c();
                        m7291a(motionEvent);
                        m7277g();
                        break;
                    }
                    break;
                case 3:
                    if (this.f5239v) {
                        m7280d();
                        setPressed(false);
                    }
                    invalidate();
                    break;
            }
            return true;
        }
        return false;
    }

    /* renamed from: g */
    private void m7277g() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* renamed from: c */
    void m7282c() {
        this.f5239v = true;
        InterfaceC1923a interfaceC1923a = this.f5218A;
        if (interfaceC1923a != null) {
            interfaceC1923a.mo7274a(this);
        }
    }

    /* renamed from: d */
    void m7280d() {
        this.f5239v = false;
        InterfaceC1923a interfaceC1923a = this.f5218A;
        if (interfaceC1923a != null) {
            interfaceC1923a.mo7272b(this);
        }
    }

    /* renamed from: a */
    private void m7291a(MotionEvent motionEvent) {
        float f;
        int width = getWidth();
        int paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
        int x = (int) motionEvent.getX();
        float f2 = 0.0f;
        if (x < getPaddingLeft()) {
            f = 0.0f;
        } else if (x > width - getPaddingRight()) {
            f = 1.0f;
        } else {
            float paddingLeft2 = (x - getPaddingLeft()) / paddingLeft;
            f2 = this.f5223e;
            f = paddingLeft2;
        }
        m7293a((int) (f2 + (f * getMax())), true);
    }

    public void setOnSeekBarChangeListener(InterfaceC1923a interfaceC1923a) {
        this.f5218A = interfaceC1923a;
    }
}
