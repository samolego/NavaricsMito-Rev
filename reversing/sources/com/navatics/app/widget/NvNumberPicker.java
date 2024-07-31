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
    private int f5365A;

    /* renamed from: B */
    private int f5366B;

    /* renamed from: C */
    private int f5367C;

    /* renamed from: D */
    private int f5368D;

    /* renamed from: E */
    private InterfaceC1938b f5369E;

    /* renamed from: F */
    private OnScrollListener f5370F;

    /* renamed from: G */
    private float f5371G;

    /* renamed from: H */
    private long f5372H;

    /* renamed from: I */
    private float f5373I;

    /* renamed from: J */
    private VelocityTracker f5374J;

    /* renamed from: K */
    private int f5375K;

    /* renamed from: L */
    private int f5376L;

    /* renamed from: M */
    private int f5377M;

    /* renamed from: N */
    private boolean f5378N;

    /* renamed from: a */
    private int f5379a;

    /* renamed from: b */
    private final SparseArray<String> f5380b;

    /* renamed from: c */
    private InterfaceC1937a f5381c;

    /* renamed from: d */
    private int f5382d;

    /* renamed from: e */
    private int f5383e;

    /* renamed from: f */
    private int f5384f;

    /* renamed from: g */
    private int f5385g;

    /* renamed from: h */
    private int f5386h;

    /* renamed from: i */
    private boolean f5387i;

    /* renamed from: j */
    private boolean f5388j;

    /* renamed from: k */
    private Paint f5389k;

    /* renamed from: l */
    private Paint f5390l;

    /* renamed from: m */
    private final int[] f5391m;

    /* renamed from: n */
    private String[] f5392n;

    /* renamed from: o */
    private Drawable f5393o;

    /* renamed from: p */
    private int f5394p;

    /* renamed from: q */
    private int f5395q;

    /* renamed from: r */
    private int f5396r;

    /* renamed from: s */
    private int f5397s;

    /* renamed from: t */
    private int f5398t;

    /* renamed from: u */
    private int f5399u;

    /* renamed from: v */
    private int f5400v;

    /* renamed from: w */
    private Scroller f5401w;

    /* renamed from: x */
    private Scroller f5402x;

    /* renamed from: y */
    private int f5403y;

    /* renamed from: z */
    private int f5404z;

    /* loaded from: classes.dex */
    public interface OnScrollListener {

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface ScrollState {
        }

        /* renamed from: a */
        void m7174a(NvNumberPicker nvNumberPicker, int i);
    }

    /* renamed from: com.navatics.app.widget.NvNumberPicker$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1937a {
        /* renamed from: a */
        String m7173a(int i);
    }

    /* renamed from: com.navatics.app.widget.NvNumberPicker$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1938b {
        /* renamed from: a */
        void mo7172a(NvNumberPicker nvNumberPicker, int i, int i2);
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
        this.f5379a = 18;
        this.f5380b = new SparseArray<>();
        this.f5385g = -1;
        this.f5388j = false;
        this.f5391m = new int[5];
        this.f5366B = Integer.MIN_VALUE;
        this.f5368D = 0;
        m7193a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m7193a(Context context, AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NvNumberPicker, i, 0);
        this.f5384f = obtainStyledAttributes.getDimensionPixelSize(1, (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.f5386h = obtainStyledAttributes.getDimensionPixelSize(0, (int) TypedValue.applyDimension(1, 38.0f, getResources().getDisplayMetrics()));
        this.f5399u = obtainStyledAttributes.getDimensionPixelSize(6, -1);
        this.f5400v = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        int i4 = this.f5399u;
        if (i4 != -1 && (i3 = this.f5400v) != -1 && i4 > i3) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        this.f5398t = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        this.f5397s = obtainStyledAttributes.getDimensionPixelSize(4, -1);
        int i5 = this.f5398t;
        if (i5 != -1 && (i2 = this.f5397s) != -1 && i5 > i2) {
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        this.f5394p = obtainStyledAttributes.getInt(8, this.f5394p);
        this.f5396r = obtainStyledAttributes.getInt(2, this.f5396r);
        this.f5395q = obtainStyledAttributes.getInt(5, this.f5395q);
        setDividerColor(this.f5385g);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5375K = viewConfiguration.getScaledTouchSlop();
        this.f5376L = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5377M = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(m7198a(this.f5379a));
        paint.setTypeface(Typeface.DEFAULT);
        paint.setColor(-1);
        this.f5389k = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(m7198a(14.0f));
        paint2.setTypeface(Typeface.DEFAULT);
        paint2.setColor(-1);
        this.f5390l = paint2;
        this.f5401w = new Scroller(getContext(), null, true);
        this.f5402x = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
    }

    /* renamed from: c */
    private void m7184c() {
        this.f5380b.clear();
        int[] iArr = this.f5391m;
        int value = getValue();
        for (int i = 0; i < this.f5391m.length; i++) {
            int i2 = (i - 2) + value;
            if (this.f5387i) {
                i2 = m7183c(i2);
            }
            iArr[i] = i2;
            m7181d(iArr[i]);
        }
    }

    /* renamed from: d */
    private void m7182d() {
        m7184c();
        int[] iArr = this.f5391m;
        this.f5404z = (int) ((((getBottom() - getTop()) - (iArr.length * this.f5379a)) / iArr.length) + 0.5f);
        this.f5365A = this.f5379a + this.f5404z;
        Paint.FontMetricsInt fontMetricsInt = this.f5389k.getFontMetricsInt();
        this.f5366B = ((((getBottom() - getTop()) / 2) - ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.top) - (this.f5365A * 2);
        this.f5367C = this.f5366B;
    }

    /* renamed from: e */
    private void m7180e() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.f5379a) / 2);
    }

    /* renamed from: a */
    private void m7191a(boolean z) {
        if (!m7192a(this.f5401w)) {
            m7192a(this.f5402x);
        }
        this.f5403y = 0;
        if (z) {
            this.f5401w.m6968a(0, 0, 0, -this.f5365A, IjkMediaCodecInfo.RANK_SECURE);
        } else {
            this.f5401w.m6968a(0, 0, 0, this.f5365A, IjkMediaCodecInfo.RANK_SECURE);
        }
        invalidate();
    }

    /* renamed from: a */
    private boolean m7192a(Scroller scroller) {
        scroller.m6966a(true);
        int m6958h = scroller.m6958h() - scroller.m6963c();
        int i = this.f5366B - ((this.f5367C + m6958h) % this.f5365A);
        if (i != 0) {
            int abs = Math.abs(i);
            int i2 = this.f5365A;
            if (abs > i2 / 2) {
                i = i > 0 ? i - i2 : i + i2;
            }
            scrollBy(0, m6958h + i);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int height = getHeight();
            int i5 = this.f5386h;
            int i6 = this.f5384f;
            this.f5382d = ((height - i5) / 2) - i6;
            this.f5383e = this.f5382d + (i6 * 2) + i5;
            m7182d();
            m7180e();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(m7187b(i, this.f5397s), m7187b(i2, this.f5400v));
        setMeasuredDimension(m7195a(this.f5398t, getMeasuredWidth(), i), m7195a(this.f5399u, getMeasuredHeight(), i2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float right = (getRight() - getLeft()) / 2;
        int[] iArr = this.f5391m;
        int length = iArr.length / 2;
        float f = this.f5367C;
        for (int i : iArr) {
            String str = this.f5380b.get(i);
            canvas.drawText(str, right, f, this.f5389k);
            canvas.drawText(str, right, f, this.f5389k);
            f += this.f5365A;
        }
        Drawable drawable = this.f5393o;
        if (drawable != null) {
            int i2 = this.f5382d;
            drawable.setBounds(0, i2, getWidth(), this.f5384f + i2);
            this.f5393o.draw(canvas);
            int i3 = this.f5383e;
            this.f5393o.setBounds(0, i3 - this.f5384f, getWidth(), i3);
            this.f5393o.draw(canvas);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.f5401w;
        if (scroller.m6970a()) {
            scroller = this.f5402x;
            if (scroller.m6970a()) {
                return;
            }
        }
        scroller.m6957i();
        int m6963c = scroller.m6963c();
        if (this.f5403y == 0) {
            this.f5403y = scroller.m6960f();
        }
        scrollBy(0, m6963c - this.f5403y);
        this.f5403y = m6963c;
        if (scroller.m6970a()) {
            m7186b(scroller);
        } else {
            invalidate();
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        int[] iArr = this.f5391m;
        if (!this.f5387i && i2 > 0 && iArr[2] <= this.f5395q) {
            this.f5367C = this.f5366B;
        } else if (!this.f5387i && i2 < 0 && iArr[2] >= this.f5396r) {
            this.f5367C = this.f5366B;
        } else {
            this.f5367C += i2;
            while (true) {
                int i3 = this.f5367C;
                if (i3 - this.f5366B <= this.f5404z) {
                    break;
                }
                this.f5367C = i3 - this.f5365A;
                m7185b(iArr);
                m7194a(iArr[2], true);
                if (!this.f5387i && iArr[2] <= this.f5395q) {
                    this.f5367C = this.f5366B;
                }
            }
            while (true) {
                int i4 = this.f5367C;
                if (i4 - this.f5366B >= (-this.f5404z)) {
                    return;
                }
                this.f5367C = i4 + this.f5365A;
                m7190a(iArr);
                m7194a(iArr[2], true);
                if (!this.f5387i && iArr[2] >= this.f5396r) {
                    this.f5367C = this.f5366B;
                }
            }
        }
    }

    /* renamed from: a */
    private void m7190a(int[] iArr) {
        int i = 0;
        while (i < iArr.length - 1) {
            int i2 = i + 1;
            iArr[i] = iArr[i2];
            i = i2;
        }
        int i3 = iArr[iArr.length - 2] + 1;
        if (this.f5387i && i3 > this.f5396r) {
            i3 = this.f5395q;
        }
        iArr[iArr.length - 1] = i3;
        m7181d(i3);
    }

    /* renamed from: b */
    private void m7185b(int[] iArr) {
        for (int length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        int i = iArr[1] - 1;
        if (this.f5387i && i < this.f5395q) {
            i = this.f5396r;
        }
        iArr[0] = i;
        m7181d(i);
    }

    public void setValue(int i) {
        m7194a(i, false);
    }

    /* renamed from: a */
    public void m7199a() {
        m7191a(true);
    }

    /* renamed from: b */
    public void m7189b() {
        m7191a(false);
    }

    /* renamed from: a */
    private void m7194a(int i, boolean z) {
        int min;
        if (this.f5394p == i) {
            return;
        }
        if (this.f5387i) {
            min = m7183c(i);
        } else {
            min = Math.min(Math.max(i, this.f5395q), this.f5396r);
        }
        int i2 = this.f5394p;
        this.f5394p = min;
        if (z) {
            m7196a(i2, min);
        }
        m7184c();
        invalidate();
    }

    /* renamed from: a */
    private void m7196a(int i, int i2) {
        InterfaceC1938b interfaceC1938b = this.f5369E;
        if (interfaceC1938b != null) {
            interfaceC1938b.mo7172a(this, i, this.f5394p);
        }
    }

    public void setOnValueChangedListener(InterfaceC1938b interfaceC1938b) {
        this.f5369E = interfaceC1938b;
    }

    /* renamed from: f */
    private boolean m7178f() {
        int i;
        int i2 = this.f5366B - this.f5367C;
        if (i2 != 0) {
            this.f5403y = 0;
            int abs = Math.abs(i2);
            int i3 = this.f5365A;
            if (abs > i3 / 2) {
                if (i2 > 0) {
                    i3 = -i3;
                }
                i = i2 + i3;
            } else {
                i = i2;
            }
            this.f5402x.m6968a(0, 0, 0, i, 800);
            invalidate();
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private void m7186b(Scroller scroller) {
        if (scroller == this.f5401w) {
            m7178f();
            m7197a(0);
            return;
        }
        int i = this.f5368D;
    }

    /* renamed from: a */
    private void m7197a(int i) {
        if (this.f5368D == i) {
            return;
        }
        this.f5368D = i;
        OnScrollListener onScrollListener = this.f5370F;
        if (onScrollListener != null) {
            onScrollListener.m7174a(this, i);
        }
    }

    /* renamed from: b */
    private void m7188b(int i) {
        this.f5403y = 0;
        if (i > 0) {
            this.f5401w.m6967a(0, 0, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.f5401w.m6967a(0, Integer.MAX_VALUE, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (this.f5374J == null) {
                this.f5374J = VelocityTracker.obtain();
            }
            this.f5374J.addMovement(motionEvent);
            switch (motionEvent.getActionMasked()) {
                case 0:
                    float y = motionEvent.getY();
                    this.f5371G = y;
                    this.f5373I = y;
                    this.f5372H = motionEvent.getEventTime();
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!this.f5401w.m6970a()) {
                        this.f5401w.m6966a(true);
                        this.f5402x.m6966a(true);
                        m7197a(0);
                    } else if (!this.f5402x.m6970a()) {
                        this.f5401w.m6966a(true);
                        this.f5402x.m6966a(true);
                    }
                    return true;
                case 1:
                    VelocityTracker velocityTracker = this.f5374J;
                    velocityTracker.computeCurrentVelocity(1000, this.f5377M);
                    int yVelocity = (int) velocityTracker.getYVelocity();
                    if (Math.abs(yVelocity) > this.f5376L) {
                        m7188b(yVelocity);
                        m7197a(2);
                    } else {
                        int y2 = (int) motionEvent.getY();
                        int abs = (int) Math.abs(y2 - this.f5371G);
                        long eventTime = motionEvent.getEventTime() - this.f5372H;
                        if (abs <= this.f5375K && eventTime < ViewConfiguration.getTapTimeout()) {
                            if (this.f5378N) {
                                this.f5378N = false;
                                performClick();
                            } else {
                                int i = (y2 / this.f5365A) - 2;
                                if (i > 0) {
                                    m7191a(true);
                                } else if (i < 0) {
                                    m7191a(false);
                                }
                            }
                        } else {
                            m7178f();
                        }
                        m7197a(0);
                    }
                    this.f5374J.recycle();
                    this.f5374J = null;
                    break;
                case 2:
                    float y3 = motionEvent.getY();
                    if (this.f5368D != 1) {
                        if (((int) Math.abs(y3 - this.f5371G)) > this.f5375K) {
                            m7197a(1);
                        }
                    } else {
                        scrollBy(0, (int) (y3 - this.f5373I));
                        invalidate();
                    }
                    this.f5373I = y3;
                    break;
            }
            return true;
        }
        return false;
    }

    public void setDividerColor(@ColorInt int i) {
        this.f5385g = i;
        this.f5393o = new ColorDrawable(i);
    }

    /* renamed from: a */
    private int m7195a(int i, int i2, int i3) {
        return i != -1 ? resolveSizeAndState(Math.max(i, i2), i3, 0) : i2;
    }

    /* renamed from: b */
    private int m7187b(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return i;
                }
                throw new IllegalArgumentException("Unknown measure mode: " + mode);
            }
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
    }

    public void setFormatter(InterfaceC1937a interfaceC1937a) {
        if (interfaceC1937a == this.f5381c) {
            return;
        }
        this.f5381c = interfaceC1937a;
        m7184c();
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.f5392n == strArr) {
            return;
        }
        this.f5392n = strArr;
        m7184c();
        m7176g();
    }

    public int getValue() {
        return this.f5394p;
    }

    public int getMinValue() {
        return this.f5395q;
    }

    public void setMinValue(int i) {
        if (this.f5395q == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.f5395q = i;
        int i2 = this.f5395q;
        if (i2 > this.f5394p) {
            this.f5394p = i2;
        }
        m7175h();
        m7184c();
        m7176g();
        invalidate();
    }

    /* renamed from: g */
    private void m7176g() {
        int i;
        String[] strArr = this.f5392n;
        int i2 = 0;
        if (strArr == null) {
            float f = 0.0f;
            for (int i3 = 0; i3 <= 9; i3++) {
                float measureText = this.f5389k.measureText(m7177f(i3));
                if (measureText > f) {
                    f = measureText;
                }
            }
            for (int i4 = this.f5396r; i4 > 0; i4 /= 10) {
                i2++;
            }
            i = (int) (i2 * f);
        } else {
            int length = strArr.length;
            int i5 = 0;
            while (i2 < length) {
                float measureText2 = this.f5389k.measureText(this.f5392n[i2]);
                if (measureText2 > i5) {
                    i5 = (int) measureText2;
                }
                i2++;
            }
            i = i5;
        }
        if (this.f5397s != i) {
            int i6 = this.f5398t;
            if (i > i6) {
                this.f5397s = i;
            } else {
                this.f5397s = i6;
            }
            invalidate();
        }
    }

    public int getMaxValue() {
        return this.f5396r;
    }

    public void setMaxValue(int i) {
        if (this.f5396r == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.f5396r = i;
        int i2 = this.f5396r;
        if (i2 < this.f5394p) {
            this.f5394p = i2;
        }
        m7175h();
        m7184c();
        m7176g();
        invalidate();
    }

    public boolean getWrapSelectorWheel() {
        return this.f5387i;
    }

    public void setWrapSelectorWheel(boolean z) {
        this.f5388j = z;
        m7175h();
    }

    /* renamed from: h */
    private void m7175h() {
        boolean z = true;
        this.f5387i = ((this.f5396r - this.f5395q >= this.f5391m.length) && this.f5388j) ? false : false;
    }

    /* renamed from: c */
    private int m7183c(int i) {
        int i2 = this.f5396r;
        if (i > i2) {
            int i3 = this.f5395q;
            return (i3 + ((i - i2) % (i2 - i3))) - 1;
        }
        int i4 = this.f5395q;
        return i < i4 ? (i2 - ((i4 - i) % (i2 - i4))) + 1 : i;
    }

    /* renamed from: d */
    private void m7181d(int i) {
        String str;
        SparseArray<String> sparseArray = this.f5380b;
        if (sparseArray.get(i) != null) {
            return;
        }
        int i2 = this.f5395q;
        if (i < i2 || i > this.f5396r) {
            str = "";
        } else {
            String[] strArr = this.f5392n;
            if (strArr != null) {
                str = strArr[i - i2];
            } else {
                str = m7179e(i);
            }
        }
        sparseArray.put(i, str);
    }

    /* renamed from: e */
    private String m7179e(int i) {
        InterfaceC1937a interfaceC1937a = this.f5381c;
        return interfaceC1937a != null ? interfaceC1937a.m7173a(i) : m7177f(i);
    }

    /* renamed from: f */
    private static String m7177f(int i) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(i));
    }

    /* renamed from: a */
    private float m7198a(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }
}
