package com.navatics.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import com.navatics.app.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes.dex */
public class NvNumberPicker extends View {

    /* renamed from: A */
    private int f5387A;

    /* renamed from: B */
    private int f5388B;

    /* renamed from: C */
    private int f5389C;

    /* renamed from: D */
    private int f5390D;

    /* renamed from: E */
    private InterfaceC1859b f5391E;

    /* renamed from: F */
    private OnScrollListener f5392F;

    /* renamed from: G */
    private float f5393G;

    /* renamed from: H */
    private long f5394H;

    /* renamed from: I */
    private float f5395I;

    /* renamed from: J */
    private VelocityTracker f5396J;

    /* renamed from: K */
    private int f5397K;

    /* renamed from: L */
    private int f5398L;

    /* renamed from: M */
    private int f5399M;

    /* renamed from: N */
    private boolean f5400N;

    /* renamed from: a */
    private int f5401a;

    /* renamed from: b */
    private final SparseArray<String> f5402b;

    /* renamed from: c */
    private InterfaceC1858a f5403c;

    /* renamed from: d */
    private int f5404d;

    /* renamed from: e */
    private int f5405e;

    /* renamed from: f */
    private int f5406f;

    /* renamed from: g */
    private int f5407g;

    /* renamed from: h */
    private int f5408h;

    /* renamed from: i */
    private boolean f5409i;

    /* renamed from: j */
    private boolean f5410j;

    /* renamed from: k */
    private Paint f5411k;

    /* renamed from: l */
    private Paint f5412l;

    /* renamed from: m */
    private final int[] f5413m;

    /* renamed from: n */
    private String[] f5414n;

    /* renamed from: o */
    private Drawable f5415o;

    /* renamed from: p */
    private int f5416p;

    /* renamed from: q */
    private int f5417q;

    /* renamed from: r */
    private int f5418r;

    /* renamed from: s */
    private int f5419s;

    /* renamed from: t */
    private int f5420t;

    /* renamed from: u */
    private int f5421u;

    /* renamed from: v */
    private int f5422v;

    /* renamed from: w */
    private Scroller f5423w;

    /* renamed from: x */
    private Scroller f5424x;

    /* renamed from: y */
    private int f5425y;

    /* renamed from: z */
    private int f5426z;

    /* loaded from: classes.dex */
    public interface OnScrollListener {

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface ScrollState {
        }

        /* renamed from: a */
        void m5699a(NvNumberPicker nvNumberPicker, int i);
    }

    /* renamed from: com.navatics.app.widget.NvNumberPicker$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1858a {
        /* renamed from: a */
        String m5700a(int i);
    }

    /* renamed from: com.navatics.app.widget.NvNumberPicker$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1859b {
        /* renamed from: a */
        void mo3848a(NvNumberPicker nvNumberPicker, int i, int i2);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public NvNumberPicker(Context context) {
        this(context, null);
    }

    public NvNumberPicker(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NvNumberPicker(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5401a = 18;
        this.f5402b = new SparseArray<>();
        this.f5407g = -1;
        this.f5410j = false;
        this.f5413m = new int[5];
        this.f5388B = Integer.MIN_VALUE;
        this.f5390D = 0;
        m5679a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m5679a(Context context, AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NvNumberPicker, i, 0);
        this.f5406f = obtainStyledAttributes.getDimensionPixelSize(1, (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.f5408h = obtainStyledAttributes.getDimensionPixelSize(0, (int) TypedValue.applyDimension(1, 38.0f, getResources().getDisplayMetrics()));
        this.f5421u = obtainStyledAttributes.getDimensionPixelSize(6, -1);
        this.f5422v = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        int i4 = this.f5421u;
        if (i4 != -1 && (i3 = this.f5422v) != -1 && i4 > i3) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        this.f5420t = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        this.f5419s = obtainStyledAttributes.getDimensionPixelSize(4, -1);
        int i5 = this.f5420t;
        if (i5 != -1 && (i2 = this.f5419s) != -1 && i5 > i2) {
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        this.f5416p = obtainStyledAttributes.getInt(8, this.f5416p);
        this.f5418r = obtainStyledAttributes.getInt(2, this.f5418r);
        this.f5417q = obtainStyledAttributes.getInt(5, this.f5417q);
        setDividerColor(this.f5407g);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5397K = viewConfiguration.getScaledTouchSlop();
        this.f5398L = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5399M = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(m5674a(this.f5401a));
        paint.setTypeface(Typeface.DEFAULT);
        paint.setColor(-1);
        this.f5411k = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(m5674a(14.0f));
        paint2.setTypeface(Typeface.DEFAULT);
        paint2.setColor(-1);
        this.f5412l = paint2;
        this.f5423w = new Scroller(getContext(), null, true);
        this.f5424x = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
    }

    /* renamed from: c */
    private void m5688c() {
        this.f5402b.clear();
        int[] iArr = this.f5413m;
        int value = getValue();
        for (int i = 0; i < this.f5413m.length; i++) {
            int i2 = (i - 2) + value;
            if (this.f5409i) {
                i2 = m5687c(i2);
            }
            iArr[i] = i2;
            m5690d(iArr[i]);
        }
    }

    /* renamed from: d */
    private void m5689d() {
        m5688c();
        int[] iArr = this.f5413m;
        this.f5426z = (int) ((((getBottom() - getTop()) - (iArr.length * this.f5401a)) / iArr.length) + 0.5f);
        this.f5387A = this.f5401a + this.f5426z;
        Paint.FontMetricsInt fontMetricsInt = this.f5411k.getFontMetricsInt();
        this.f5388B = ((((getBottom() - getTop()) / 2) - ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.top) - (this.f5387A * 2);
        this.f5389C = this.f5388B;
    }

    /* renamed from: e */
    private void m5692e() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.f5401a) / 2);
    }

    /* renamed from: a */
    private void m5680a(boolean z) {
        if (!m5682a(this.f5423w)) {
            m5682a(this.f5424x);
        }
        this.f5425y = 0;
        if (z) {
            this.f5423w.m5897a(0, 0, 0, -this.f5387A, IjkMediaCodecInfo.RANK_SECURE);
        } else {
            this.f5423w.m5897a(0, 0, 0, this.f5387A, IjkMediaCodecInfo.RANK_SECURE);
        }
        invalidate();
    }

    /* renamed from: a */
    private boolean m5682a(Scroller scroller) {
        scroller.m5899a(true);
        int m5907h = scroller.m5907h() - scroller.m5902c();
        int i = this.f5388B - ((this.f5389C + m5907h) % this.f5387A);
        if (i == 0) {
            return false;
        }
        int abs = Math.abs(i);
        int i2 = this.f5387A;
        if (abs > i2 / 2) {
            i = i > 0 ? i - i2 : i + i2;
        }
        scrollBy(0, m5907h + i);
        return true;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int height = getHeight();
            int i5 = this.f5408h;
            int i6 = this.f5406f;
            this.f5404d = ((height - i5) / 2) - i6;
            this.f5405e = this.f5404d + (i6 * 2) + i5;
            m5689d();
            m5692e();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(m5683b(i, this.f5419s), m5683b(i2, this.f5422v));
        setMeasuredDimension(m5675a(this.f5420t, getMeasuredWidth(), i), m5675a(this.f5421u, getMeasuredHeight(), i2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float right = (getRight() - getLeft()) / 2;
        float f = this.f5389C;
        int[] iArr = this.f5413m;
        int length = iArr.length / 2;
        float f2 = f;
        for (int i : iArr) {
            String str = this.f5402b.get(i);
            canvas.drawText(str, right, f2, this.f5411k);
            canvas.drawText(str, right, f2, this.f5411k);
            f2 += this.f5387A;
        }
        Drawable drawable = this.f5415o;
        if (drawable != null) {
            int i2 = this.f5404d;
            drawable.setBounds(0, i2, getWidth(), this.f5406f + i2);
            this.f5415o.draw(canvas);
            int i3 = this.f5405e;
            this.f5415o.setBounds(0, i3 - this.f5406f, getWidth(), i3);
            this.f5415o.draw(canvas);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.f5423w;
        if (scroller.m5900a()) {
            scroller = this.f5424x;
            if (scroller.m5900a()) {
                return;
            }
        }
        scroller.m5908i();
        int m5902c = scroller.m5902c();
        if (this.f5425y == 0) {
            this.f5425y = scroller.m5905f();
        }
        scrollBy(0, m5902c - this.f5425y);
        this.f5425y = m5902c;
        if (scroller.m5900a()) {
            m5685b(scroller);
        } else {
            invalidate();
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        int[] iArr = this.f5413m;
        if (!this.f5409i && i2 > 0 && iArr[2] <= this.f5417q) {
            this.f5389C = this.f5388B;
            return;
        }
        if (!this.f5409i && i2 < 0 && iArr[2] >= this.f5418r) {
            this.f5389C = this.f5388B;
            return;
        }
        this.f5389C += i2;
        while (true) {
            int i3 = this.f5389C;
            if (i3 - this.f5388B <= this.f5426z) {
                break;
            }
            this.f5389C = i3 - this.f5387A;
            m5686b(iArr);
            m5678a(iArr[2], true);
            if (!this.f5409i && iArr[2] <= this.f5417q) {
                this.f5389C = this.f5388B;
            }
        }
        while (true) {
            int i4 = this.f5389C;
            if (i4 - this.f5388B >= (-this.f5426z)) {
                return;
            }
            this.f5389C = i4 + this.f5387A;
            m5681a(iArr);
            m5678a(iArr[2], true);
            if (!this.f5409i && iArr[2] >= this.f5418r) {
                this.f5389C = this.f5388B;
            }
        }
    }

    /* renamed from: a */
    private void m5681a(int[] iArr) {
        int i = 0;
        while (i < iArr.length - 1) {
            int i2 = i + 1;
            iArr[i] = iArr[i2];
            i = i2;
        }
        int i3 = iArr[iArr.length - 2] + 1;
        if (this.f5409i && i3 > this.f5418r) {
            i3 = this.f5417q;
        }
        iArr[iArr.length - 1] = i3;
        m5690d(i3);
    }

    /* renamed from: b */
    private void m5686b(int[] iArr) {
        for (int length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        int i = iArr[1] - 1;
        if (this.f5409i && i < this.f5417q) {
            i = this.f5418r;
        }
        iArr[0] = i;
        m5690d(i);
    }

    public void setValue(int i) {
        m5678a(i, false);
    }

    /* renamed from: a */
    public void m5697a() {
        m5680a(true);
    }

    /* renamed from: b */
    public void m5698b() {
        m5680a(false);
    }

    /* renamed from: a */
    private void m5678a(int i, boolean z) {
        int min;
        if (this.f5416p == i) {
            return;
        }
        if (this.f5409i) {
            min = m5687c(i);
        } else {
            min = Math.min(Math.max(i, this.f5417q), this.f5418r);
        }
        int i2 = this.f5416p;
        this.f5416p = min;
        if (z) {
            m5677a(i2, min);
        }
        m5688c();
        invalidate();
    }

    /* renamed from: a */
    private void m5677a(int i, int i2) {
        InterfaceC1859b interfaceC1859b = this.f5391E;
        if (interfaceC1859b != null) {
            interfaceC1859b.mo3848a(this, i, this.f5416p);
        }
    }

    public void setOnValueChangedListener(InterfaceC1859b interfaceC1859b) {
        this.f5391E = interfaceC1859b;
    }

    /* renamed from: f */
    private boolean m5694f() {
        int i;
        int i2 = this.f5388B - this.f5389C;
        if (i2 == 0) {
            return false;
        }
        this.f5425y = 0;
        int abs = Math.abs(i2);
        int i3 = this.f5387A;
        if (abs > i3 / 2) {
            if (i2 > 0) {
                i3 = -i3;
            }
            i = i2 + i3;
        } else {
            i = i2;
        }
        this.f5424x.m5897a(0, 0, 0, i, 800);
        invalidate();
        return true;
    }

    /* renamed from: b */
    private void m5685b(Scroller scroller) {
        if (scroller == this.f5423w) {
            m5694f();
            m5676a(0);
        } else {
            int i = this.f5390D;
        }
    }

    /* renamed from: a */
    private void m5676a(int i) {
        if (this.f5390D == i) {
            return;
        }
        this.f5390D = i;
        OnScrollListener onScrollListener = this.f5392F;
        if (onScrollListener != null) {
            onScrollListener.m5699a(this, i);
        }
    }

    /* renamed from: b */
    private void m5684b(int i) {
        this.f5425y = 0;
        if (i > 0) {
            this.f5423w.m5898a(0, 0, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.f5423w.m5898a(0, Integer.MAX_VALUE, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        }
        invalidate();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.f5396J == null) {
            this.f5396J = VelocityTracker.obtain();
        }
        this.f5396J.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float y = motionEvent.getY();
                this.f5393G = y;
                this.f5395I = y;
                this.f5394H = motionEvent.getEventTime();
                getParent().requestDisallowInterceptTouchEvent(true);
                if (!this.f5423w.m5900a()) {
                    this.f5423w.m5899a(true);
                    this.f5424x.m5899a(true);
                    m5676a(0);
                } else if (!this.f5424x.m5900a()) {
                    this.f5423w.m5899a(true);
                    this.f5424x.m5899a(true);
                }
                return true;
            case 1:
                VelocityTracker velocityTracker = this.f5396J;
                velocityTracker.computeCurrentVelocity(1000, this.f5399M);
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (Math.abs(yVelocity) > this.f5398L) {
                    m5684b(yVelocity);
                    m5676a(2);
                } else {
                    int y2 = (int) motionEvent.getY();
                    int abs = (int) Math.abs(y2 - this.f5393G);
                    long eventTime = motionEvent.getEventTime() - this.f5394H;
                    if (abs <= this.f5397K && eventTime < ViewConfiguration.getTapTimeout()) {
                        if (this.f5400N) {
                            this.f5400N = false;
                            performClick();
                        } else {
                            int i = (y2 / this.f5387A) - 2;
                            if (i > 0) {
                                m5680a(true);
                            } else if (i < 0) {
                                m5680a(false);
                            }
                        }
                    } else {
                        m5694f();
                    }
                    m5676a(0);
                }
                this.f5396J.recycle();
                this.f5396J = null;
                return true;
            case 2:
                float y3 = motionEvent.getY();
                if (this.f5390D != 1) {
                    if (((int) Math.abs(y3 - this.f5393G)) > this.f5397K) {
                        m5676a(1);
                    }
                } else {
                    scrollBy(0, (int) (y3 - this.f5395I));
                    invalidate();
                }
                this.f5395I = y3;
                return true;
            default:
                return true;
        }
    }

    public void setDividerColor(@ColorInt int i) {
        this.f5407g = i;
        this.f5415o = new ColorDrawable(i);
    }

    /* renamed from: a */
    private int m5675a(int i, int i2, int i3) {
        return i != -1 ? resolveSizeAndState(Math.max(i, i2), i3, 0) : i2;
    }

    /* renamed from: b */
    private int m5683b(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        if (mode == 1073741824) {
            return i;
        }
        throw new IllegalArgumentException("Unknown measure mode: " + mode);
    }

    public void setFormatter(InterfaceC1858a interfaceC1858a) {
        if (interfaceC1858a == this.f5403c) {
            return;
        }
        this.f5403c = interfaceC1858a;
        m5688c();
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.f5414n == strArr) {
            return;
        }
        this.f5414n = strArr;
        m5688c();
        m5695g();
    }

    public int getValue() {
        return this.f5416p;
    }

    public int getMinValue() {
        return this.f5417q;
    }

    public void setMinValue(int i) {
        if (this.f5417q == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.f5417q = i;
        int i2 = this.f5417q;
        if (i2 > this.f5416p) {
            this.f5416p = i2;
        }
        m5696h();
        m5688c();
        m5695g();
        invalidate();
    }

    /* renamed from: g */
    private void m5695g() {
        int i;
        String[] strArr = this.f5414n;
        int i2 = 0;
        if (strArr == null) {
            float f = 0.0f;
            for (int i3 = 0; i3 <= 9; i3++) {
                float measureText = this.f5411k.measureText(m5693f(i3));
                if (measureText > f) {
                    f = measureText;
                }
            }
            for (int i4 = this.f5418r; i4 > 0; i4 /= 10) {
                i2++;
            }
            i = (int) (i2 * f);
        } else {
            int length = strArr.length;
            int i5 = 0;
            while (i2 < length) {
                float measureText2 = this.f5411k.measureText(this.f5414n[i2]);
                if (measureText2 > i5) {
                    i5 = (int) measureText2;
                }
                i2++;
            }
            i = i5;
        }
        if (this.f5419s != i) {
            int i6 = this.f5420t;
            if (i > i6) {
                this.f5419s = i;
            } else {
                this.f5419s = i6;
            }
            invalidate();
        }
    }

    public int getMaxValue() {
        return this.f5418r;
    }

    public void setMaxValue(int i) {
        if (this.f5418r == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.f5418r = i;
        int i2 = this.f5418r;
        if (i2 < this.f5416p) {
            this.f5416p = i2;
        }
        m5696h();
        m5688c();
        m5695g();
        invalidate();
    }

    public boolean getWrapSelectorWheel() {
        return this.f5409i;
    }

    public void setWrapSelectorWheel(boolean z) {
        this.f5410j = z;
        m5696h();
    }

    /* renamed from: h */
    private void m5696h() {
        this.f5409i = (this.f5418r - this.f5417q >= this.f5413m.length) && this.f5410j;
    }

    /* renamed from: c */
    private int m5687c(int i) {
        int i2 = this.f5418r;
        if (i > i2) {
            int i3 = this.f5417q;
            return (i3 + ((i - i2) % (i2 - i3))) - 1;
        }
        int i4 = this.f5417q;
        return i < i4 ? (i2 - ((i4 - i) % (i2 - i4))) + 1 : i;
    }

    /* renamed from: d */
    private void m5690d(int i) {
        String str;
        SparseArray<String> sparseArray = this.f5402b;
        if (sparseArray.get(i) != null) {
            return;
        }
        int i2 = this.f5417q;
        if (i < i2 || i > this.f5418r) {
            str = "";
        } else {
            String[] strArr = this.f5414n;
            if (strArr != null) {
                str = strArr[i - i2];
            } else {
                str = m5691e(i);
            }
        }
        sparseArray.put(i, str);
    }

    /* renamed from: e */
    private String m5691e(int i) {
        InterfaceC1858a interfaceC1858a = this.f5403c;
        return interfaceC1858a != null ? interfaceC1858a.m5700a(i) : m5693f(i);
    }

    /* renamed from: f */
    private static String m5693f(int i) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(i));
    }

    /* renamed from: a */
    private float m5674a(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }
}