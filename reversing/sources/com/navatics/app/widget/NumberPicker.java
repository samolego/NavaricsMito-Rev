package com.navatics.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.StringRes;
import android.support.p008v4.content.ContextCompat;
import android.support.p008v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.navatics.app.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.DecimalFormatSymbols;
import java.util.Formatter;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes.dex */
public class NumberPicker extends LinearLayout {

    /* renamed from: a */
    private static final C1936f f5287a = new C1936f();

    /* renamed from: ar */
    private static final char[] f5288ar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785, '-'};

    /* renamed from: A */
    private int f5289A;

    /* renamed from: B */
    private int f5290B;

    /* renamed from: C */
    private int f5291C;

    /* renamed from: D */
    private int[] f5292D;

    /* renamed from: E */
    private final Paint f5293E;

    /* renamed from: F */
    private int f5294F;

    /* renamed from: G */
    private int f5295G;

    /* renamed from: H */
    private int f5296H;

    /* renamed from: I */
    private final Scroller f5297I;

    /* renamed from: J */
    private final Scroller f5298J;

    /* renamed from: K */
    private int f5299K;

    /* renamed from: L */
    private int f5300L;

    /* renamed from: M */
    private RunnableC1935e f5301M;

    /* renamed from: N */
    private RunnableC1931a f5302N;

    /* renamed from: O */
    private float f5303O;

    /* renamed from: P */
    private float f5304P;

    /* renamed from: Q */
    private float f5305Q;

    /* renamed from: R */
    private float f5306R;

    /* renamed from: S */
    private VelocityTracker f5307S;

    /* renamed from: T */
    private int f5308T;

    /* renamed from: U */
    private int f5309U;

    /* renamed from: V */
    private int f5310V;

    /* renamed from: W */
    private boolean f5311W;

    /* renamed from: aa */
    private Drawable f5312aa;

    /* renamed from: ab */
    private int f5313ab;

    /* renamed from: ac */
    private int f5314ac;

    /* renamed from: ad */
    private int f5315ad;

    /* renamed from: ae */
    private int f5316ae;

    /* renamed from: af */
    private int f5317af;

    /* renamed from: ag */
    private int f5318ag;

    /* renamed from: ah */
    private int f5319ah;

    /* renamed from: ai */
    private int f5320ai;

    /* renamed from: aj */
    private int f5321aj;

    /* renamed from: ak */
    private float f5322ak;

    /* renamed from: al */
    private float f5323al;

    /* renamed from: am */
    private int f5324am;

    /* renamed from: an */
    private int f5325an;

    /* renamed from: ao */
    private boolean f5326ao;

    /* renamed from: ap */
    private boolean f5327ap;

    /* renamed from: aq */
    private Context f5328aq;

    /* renamed from: b */
    private final EditText f5329b;

    /* renamed from: c */
    private float f5330c;

    /* renamed from: d */
    private float f5331d;

    /* renamed from: e */
    private int f5332e;

    /* renamed from: f */
    private int f5333f;

    /* renamed from: g */
    private int f5334g;

    /* renamed from: h */
    private int f5335h;

    /* renamed from: i */
    private final boolean f5336i;

    /* renamed from: j */
    private int f5337j;

    /* renamed from: k */
    private int f5338k;

    /* renamed from: l */
    private float f5339l;

    /* renamed from: m */
    private float f5340m;

    /* renamed from: n */
    private Typeface f5341n;

    /* renamed from: o */
    private int f5342o;

    /* renamed from: p */
    private int f5343p;

    /* renamed from: q */
    private String[] f5344q;

    /* renamed from: r */
    private int f5345r;

    /* renamed from: s */
    private int f5346s;

    /* renamed from: t */
    private int f5347t;

    /* renamed from: u */
    private View.OnClickListener f5348u;

    /* renamed from: v */
    private InterfaceC1934d f5349v;

    /* renamed from: w */
    private InterfaceC1933c f5350w;

    /* renamed from: x */
    private InterfaceC1932b f5351x;

    /* renamed from: y */
    private long f5352y;

    /* renamed from: z */
    private final SparseArray<String> f5353z;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Order {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* renamed from: com.navatics.app.widget.NumberPicker$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1932b {
        /* renamed from: a */
        String mo7203a(int i);
    }

    /* renamed from: com.navatics.app.widget.NumberPicker$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1933c {
        /* renamed from: a */
        void m7205a(NumberPicker numberPicker, int i);
    }

    /* renamed from: com.navatics.app.widget.NumberPicker$d */
    /* loaded from: classes.dex */
    public interface InterfaceC1934d {
        /* renamed from: a */
        void m7204a(NumberPicker numberPicker, int i, int i2);
    }

    /* renamed from: com.navatics.app.widget.NumberPicker$f */
    /* loaded from: classes.dex */
    private static class C1936f implements InterfaceC1932b {

        /* renamed from: b */
        char f5362b;

        /* renamed from: c */
        Formatter f5363c;

        /* renamed from: a */
        final StringBuilder f5361a = new StringBuilder();

        /* renamed from: d */
        final Object[] f5364d = new Object[1];

        C1936f() {
            m7202a(Locale.getDefault());
        }

        /* renamed from: a */
        private void m7202a(Locale locale) {
            this.f5363c = m7200c(locale);
            this.f5362b = m7201b(locale);
        }

        @Override // com.navatics.app.widget.NumberPicker.InterfaceC1932b
        /* renamed from: a */
        public String mo7203a(int i) {
            Locale locale = Locale.getDefault();
            if (this.f5362b != m7201b(locale)) {
                m7202a(locale);
            }
            this.f5364d[0] = Integer.valueOf(i);
            StringBuilder sb = this.f5361a;
            sb.delete(0, sb.length());
            this.f5363c.format("%02d", this.f5364d);
            return this.f5363c.toString();
        }

        /* renamed from: b */
        private static char m7201b(Locale locale) {
            return new DecimalFormatSymbols(locale).getZeroDigit();
        }

        /* renamed from: c */
        private Formatter m7200c(Locale locale) {
            return new Formatter(this.f5361a, locale);
        }
    }

    public static final InterfaceC1932b getTwoDigitFormatter() {
        return f5287a;
    }

    public NumberPicker(Context context) {
        this(context, null);
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f5337j = ViewCompat.MEASURED_STATE_MASK;
        this.f5338k = ViewCompat.MEASURED_STATE_MASK;
        this.f5339l = 25.0f;
        this.f5340m = 25.0f;
        this.f5345r = 1;
        this.f5346s = 100;
        this.f5352y = 300L;
        this.f5353z = new SparseArray<>();
        this.f5289A = 3;
        this.f5290B = 3;
        int i2 = this.f5289A;
        this.f5291C = i2 / 2;
        this.f5292D = new int[i2];
        this.f5295G = Integer.MIN_VALUE;
        this.f5313ab = ViewCompat.MEASURED_STATE_MASK;
        this.f5316ae = 0;
        this.f5321aj = -1;
        this.f5326ao = true;
        this.f5327ap = true;
        this.f5328aq = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NumberPicker, i, 0);
        this.f5312aa = ContextCompat.getDrawable(context, R.drawable.np_numberpicker_selection_divider);
        this.f5313ab = obtainStyledAttributes.getColor(0, this.f5313ab);
        this.f5314ac = obtainStyledAttributes.getDimensionPixelSize(1, (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics()));
        this.f5315ad = obtainStyledAttributes.getDimensionPixelSize(2, (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.f5325an = obtainStyledAttributes.getInt(8, 0);
        this.f5324am = obtainStyledAttributes.getInt(9, 1);
        this.f5322ak = obtainStyledAttributes.getDimensionPixelSize(18, -1);
        this.f5323al = obtainStyledAttributes.getDimensionPixelSize(5, -1);
        m7208l();
        this.f5336i = true;
        this.f5347t = obtainStyledAttributes.getInt(16, this.f5347t);
        this.f5346s = obtainStyledAttributes.getInt(6, this.f5346s);
        this.f5345r = obtainStyledAttributes.getInt(7, this.f5345r);
        this.f5337j = obtainStyledAttributes.getColor(11, this.f5337j);
        this.f5340m = obtainStyledAttributes.getDimension(12, m7223c(this.f5340m));
        this.f5338k = obtainStyledAttributes.getColor(13, this.f5338k);
        this.f5339l = obtainStyledAttributes.getDimension(14, m7223c(this.f5339l));
        this.f5341n = Typeface.create(obtainStyledAttributes.getString(15), 0);
        this.f5351x = m7237a(obtainStyledAttributes.getString(4));
        this.f5326ao = obtainStyledAttributes.getBoolean(3, this.f5326ao);
        this.f5327ap = obtainStyledAttributes.getBoolean(10, this.f5327ap);
        this.f5289A = obtainStyledAttributes.getInt(17, this.f5289A);
        setWillNotDraw(false);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.number_picker_with_selector_wheel, (ViewGroup) this, true);
        this.f5329b = (EditText) findViewById(R.id.np__numberpicker_input);
        this.f5329b.setEnabled(false);
        this.f5329b.setFocusable(false);
        this.f5329b.setImeOptions(1);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        this.f5293E = paint;
        setSelectedTextColor(this.f5337j);
        setTextColor(this.f5338k);
        setTextSize(this.f5339l);
        setSelectedTextSize(this.f5340m);
        setTypeface(this.f5341n);
        setFormatter(this.f5351x);
        m7212h();
        setValue(this.f5347t);
        setMaxValue(this.f5346s);
        setMinValue(this.f5345r);
        setDividerColor(this.f5313ab);
        setWheelItemCount(this.f5289A);
        this.f5311W = obtainStyledAttributes.getBoolean(19, this.f5311W);
        setWrapSelectorWheel(this.f5311W);
        float f = this.f5322ak;
        if (f != -1.0f && this.f5323al != -1.0f) {
            setScaleX(f / this.f5334g);
            setScaleY(this.f5323al / this.f5333f);
        } else {
            float f2 = this.f5322ak;
            if (f2 != -1.0f) {
                setScaleX(f2 / this.f5334g);
                setScaleY(this.f5322ak / this.f5334g);
            } else {
                float f3 = this.f5323al;
                if (f3 != -1.0f) {
                    setScaleX(f3 / this.f5333f);
                    setScaleY(this.f5323al / this.f5333f);
                }
            }
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5308T = viewConfiguration.getScaledTouchSlop();
        this.f5309U = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5310V = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        this.f5297I = new Scroller(context, null, true);
        this.f5298J = new Scroller(context, new DecelerateInterpolator(2.5f));
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.f5329b.getMeasuredWidth();
        int measuredHeight2 = this.f5329b.getMeasuredHeight();
        int i5 = (measuredWidth - measuredWidth2) / 2;
        int i6 = (measuredHeight - measuredHeight2) / 2;
        this.f5329b.layout(i5, i6, measuredWidth2 + i5, measuredHeight2 + i6);
        this.f5330c = this.f5329b.getX() + (this.f5329b.getMeasuredWidth() / 2);
        this.f5331d = this.f5329b.getY() + (this.f5329b.getMeasuredHeight() / 2);
        if (z) {
            m7215f();
            m7213g();
            if (m7247a()) {
                int width = getWidth();
                int i7 = this.f5314ac;
                int i8 = this.f5315ad;
                this.f5319ah = ((width - i7) / 2) - i8;
                this.f5320ai = this.f5319ah + (i8 * 2) + i7;
                return;
            }
            int height = getHeight();
            int i9 = this.f5314ac;
            int i10 = this.f5315ad;
            this.f5317af = ((height - i9) / 2) - i10;
            this.f5318ag = this.f5317af + (i10 * 2) + i9;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(m7229b(i, this.f5335h), m7229b(i2, this.f5333f));
        setMeasuredDimension(m7228b(this.f5334g, getMeasuredWidth(), i), m7228b(this.f5332e, getMeasuredHeight(), i2));
    }

    /* renamed from: a */
    private boolean m7238a(Scroller scroller) {
        scroller.m6966a(true);
        if (m7247a()) {
            int m6959g = scroller.m6959g() - scroller.m6965b();
            int i = this.f5295G - ((this.f5296H + m6959g) % this.f5294F);
            if (i != 0) {
                int abs = Math.abs(i);
                int i2 = this.f5294F;
                if (abs > i2 / 2) {
                    i = i > 0 ? i - i2 : i + i2;
                }
                scrollBy(m6959g + i, 0);
                return true;
            }
        } else {
            int m6958h = scroller.m6958h() - scroller.m6963c();
            int i3 = this.f5295G - ((this.f5296H + m6958h) % this.f5294F);
            if (i3 != 0) {
                int abs2 = Math.abs(i3);
                int i4 = this.f5294F;
                if (abs2 > i4 / 2) {
                    i3 = i3 > 0 ? i3 - i4 : i3 + i4;
                }
                scrollBy(0, m6958h + i3);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && (motionEvent.getAction() & 255) == 0) {
            m7210j();
            this.f5329b.setVisibility(4);
            if (m7247a()) {
                float x = motionEvent.getX();
                this.f5303O = x;
                this.f5305Q = x;
                getParent().requestDisallowInterceptTouchEvent(true);
                if (!this.f5297I.m6970a()) {
                    this.f5297I.m6966a(true);
                    this.f5298J.m6966a(true);
                    m7245a(0);
                } else if (!this.f5298J.m6970a()) {
                    this.f5297I.m6966a(true);
                    this.f5298J.m6966a(true);
                } else {
                    float f = this.f5303O;
                    if (f >= this.f5319ah && f <= this.f5320ai) {
                        View.OnClickListener onClickListener = this.f5348u;
                        if (onClickListener != null) {
                            onClickListener.onClick(this);
                        }
                    } else {
                        float f2 = this.f5303O;
                        if (f2 < this.f5319ah) {
                            m7234a(false, ViewConfiguration.getLongPressTimeout());
                        } else if (f2 > this.f5320ai) {
                            m7234a(true, ViewConfiguration.getLongPressTimeout());
                        }
                    }
                }
                return true;
            }
            float y = motionEvent.getY();
            this.f5304P = y;
            this.f5306R = y;
            getParent().requestDisallowInterceptTouchEvent(true);
            if (!this.f5297I.m6970a()) {
                this.f5297I.m6966a(true);
                this.f5298J.m6966a(true);
                m7245a(0);
            } else if (!this.f5298J.m6970a()) {
                this.f5297I.m6966a(true);
                this.f5298J.m6966a(true);
            } else {
                float f3 = this.f5304P;
                if (f3 >= this.f5317af && f3 <= this.f5318ag) {
                    View.OnClickListener onClickListener2 = this.f5348u;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(this);
                    }
                } else {
                    float f4 = this.f5304P;
                    if (f4 < this.f5317af) {
                        m7234a(false, ViewConfiguration.getLongPressTimeout());
                    } else if (f4 > this.f5318ag) {
                        m7234a(true, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && m7224c()) {
            if (this.f5307S == null) {
                this.f5307S = VelocityTracker.obtain();
            }
            this.f5307S.addMovement(motionEvent);
            switch (motionEvent.getAction() & 255) {
                case 1:
                    m7211i();
                    VelocityTracker velocityTracker = this.f5307S;
                    velocityTracker.computeCurrentVelocity(1000, this.f5310V);
                    if (m7247a()) {
                        int xVelocity = (int) velocityTracker.getXVelocity();
                        if (Math.abs(xVelocity) > this.f5309U) {
                            m7230b(xVelocity);
                            m7245a(2);
                        } else {
                            int x = (int) motionEvent.getX();
                            if (((int) Math.abs(x - this.f5303O)) <= this.f5308T) {
                                int i = (x / this.f5294F) - this.f5291C;
                                if (i > 0) {
                                    m7235a(true);
                                } else if (i < 0) {
                                    m7235a(false);
                                } else {
                                    m7209k();
                                }
                            } else {
                                m7209k();
                            }
                            m7245a(0);
                        }
                    } else {
                        int yVelocity = (int) velocityTracker.getYVelocity();
                        if (Math.abs(yVelocity) > this.f5309U) {
                            m7230b(yVelocity);
                            m7245a(2);
                        } else {
                            int y = (int) motionEvent.getY();
                            if (((int) Math.abs(y - this.f5304P)) <= this.f5308T) {
                                int i2 = (y / this.f5294F) - this.f5291C;
                                if (i2 > 0) {
                                    m7235a(true);
                                } else if (i2 < 0) {
                                    m7235a(false);
                                } else {
                                    m7209k();
                                }
                            } else {
                                m7209k();
                            }
                            m7245a(0);
                        }
                    }
                    this.f5307S.recycle();
                    this.f5307S = null;
                    break;
                case 2:
                    if (m7247a()) {
                        float x2 = motionEvent.getX();
                        if (this.f5316ae != 1) {
                            if (((int) Math.abs(x2 - this.f5303O)) > this.f5308T) {
                                m7210j();
                                m7245a(1);
                            }
                        } else {
                            scrollBy((int) (x2 - this.f5305Q), 0);
                            invalidate();
                        }
                        this.f5305Q = x2;
                        break;
                    } else {
                        float y2 = motionEvent.getY();
                        if (this.f5316ae != 1) {
                            if (((int) Math.abs(y2 - this.f5304P)) > this.f5308T) {
                                m7210j();
                                m7245a(1);
                            }
                        } else {
                            scrollBy(0, (int) (y2 - this.f5306R));
                            invalidate();
                        }
                        this.f5306R = y2;
                        break;
                    }
            }
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            m7210j();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 23 || keyCode == 66) {
            m7210j();
        } else {
            switch (keyCode) {
                case 19:
                case 20:
                    switch (keyEvent.getAction()) {
                        case 0:
                            if (this.f5311W || keyCode == 20 ? getValue() < getMaxValue() : getValue() > getMinValue()) {
                                requestFocus();
                                this.f5321aj = keyCode;
                                m7210j();
                                if (this.f5297I.m6970a()) {
                                    m7235a(keyCode == 20);
                                }
                                return true;
                            }
                            break;
                        case 1:
                            if (this.f5321aj == keyCode) {
                                this.f5321aj = -1;
                                return true;
                            }
                            break;
                    }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            m7210j();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (m7224c()) {
            Scroller scroller = this.f5297I;
            if (scroller.m6970a()) {
                scroller = this.f5298J;
                if (scroller.m6970a()) {
                    return;
                }
            }
            scroller.m6957i();
            if (m7247a()) {
                int m6965b = scroller.m6965b();
                if (this.f5299K == 0) {
                    this.f5299K = scroller.m6961e();
                }
                scrollBy(m6965b - this.f5299K, 0);
                this.f5299K = m6965b;
            } else {
                int m6963c = scroller.m6963c();
                if (this.f5300L == 0) {
                    this.f5300L = scroller.m6960f();
                }
                scrollBy(0, m6963c - this.f5300L);
                this.f5300L = m6963c;
            }
            if (scroller.m6970a()) {
                m7226b(scroller);
            } else {
                postInvalidate();
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f5329b.setEnabled(z);
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        int i3;
        if (!m7224c()) {
            return;
        }
        int[] selectorIndices = getSelectorIndices();
        if (m7247a()) {
            if (m7232b()) {
                if (!this.f5311W && i > 0 && selectorIndices[this.f5291C] <= this.f5345r) {
                    this.f5296H = this.f5295G;
                    return;
                } else if (!this.f5311W && i < 0 && selectorIndices[this.f5291C] >= this.f5346s) {
                    this.f5296H = this.f5295G;
                    return;
                }
            } else if (!this.f5311W && i > 0 && selectorIndices[this.f5291C] >= this.f5346s) {
                this.f5296H = this.f5295G;
                return;
            } else if (!this.f5311W && i < 0 && selectorIndices[this.f5291C] <= this.f5345r) {
                this.f5296H = this.f5295G;
                return;
            }
            this.f5296H += i;
            i3 = this.f5342o;
        } else {
            if (m7232b()) {
                if (!this.f5311W && i2 > 0 && selectorIndices[this.f5291C] <= this.f5345r) {
                    this.f5296H = this.f5295G;
                    return;
                } else if (!this.f5311W && i2 < 0 && selectorIndices[this.f5291C] >= this.f5346s) {
                    this.f5296H = this.f5295G;
                    return;
                }
            } else if (!this.f5311W && i2 > 0 && selectorIndices[this.f5291C] >= this.f5346s) {
                this.f5296H = this.f5295G;
                return;
            } else if (!this.f5311W && i2 < 0 && selectorIndices[this.f5291C] <= this.f5345r) {
                this.f5296H = this.f5295G;
                return;
            }
            this.f5296H += i2;
            i3 = this.f5343p;
        }
        while (true) {
            int i4 = this.f5296H;
            if (i4 - this.f5295G <= i3) {
                break;
            }
            this.f5296H = i4 - this.f5294F;
            if (m7232b()) {
                m7225b(selectorIndices);
            } else {
                m7233a(selectorIndices);
            }
            m7242a(selectorIndices[this.f5291C], true);
            if (!this.f5311W && selectorIndices[this.f5291C] < this.f5345r) {
                this.f5296H = this.f5295G;
            }
        }
        while (true) {
            int i5 = this.f5296H;
            if (i5 - this.f5295G >= (-i3)) {
                return;
            }
            this.f5296H = i5 + this.f5294F;
            if (m7232b()) {
                m7233a(selectorIndices);
            } else {
                m7225b(selectorIndices);
            }
            m7242a(selectorIndices[this.f5291C], true);
            if (!this.f5311W && selectorIndices[this.f5291C] > this.f5346s) {
                this.f5296H = this.f5295G;
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f5348u = onClickListener;
    }

    public void setOnValueChangedListener(InterfaceC1934d interfaceC1934d) {
        this.f5349v = interfaceC1934d;
    }

    public void setOnScrollListener(InterfaceC1933c interfaceC1933c) {
        this.f5350w = interfaceC1933c;
    }

    public void setFormatter(InterfaceC1932b interfaceC1932b) {
        if (interfaceC1932b == this.f5351x) {
            return;
        }
        this.f5351x = interfaceC1932b;
        m7217e();
        m7212h();
    }

    public void setValue(int i) {
        m7242a(i, false);
    }

    private float getMaxTextSize() {
        return Math.max(this.f5339l, this.f5340m);
    }

    /* renamed from: a */
    private float m7241a(Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    /* renamed from: d */
    private void m7220d() {
        int i;
        if (this.f5336i) {
            this.f5293E.setTextSize(getMaxTextSize());
            String[] strArr = this.f5344q;
            int i2 = 0;
            if (strArr == null) {
                float f = 0.0f;
                for (int i3 = 0; i3 <= 9; i3++) {
                    float measureText = this.f5293E.measureText(m7214f(i3));
                    if (measureText > f) {
                        f = measureText;
                    }
                }
                for (int i4 = this.f5346s; i4 > 0; i4 /= 10) {
                    i2++;
                }
                i = (int) (i2 * f);
            } else {
                int length = strArr.length;
                int i5 = 0;
                while (i2 < length) {
                    float measureText2 = this.f5293E.measureText(this.f5344q[i2]);
                    if (measureText2 > i5) {
                        i5 = (int) measureText2;
                    }
                    i2++;
                }
                i = i5;
            }
            int paddingLeft = i + this.f5329b.getPaddingLeft() + this.f5329b.getPaddingRight();
            if (this.f5335h != paddingLeft) {
                int i6 = this.f5334g;
                if (paddingLeft > i6) {
                    this.f5335h = paddingLeft;
                } else {
                    this.f5335h = i6;
                }
                invalidate();
            }
        }
    }

    public boolean getWrapSelectorWheel() {
        return this.f5311W;
    }

    public void setWrapSelectorWheel(boolean z) {
        boolean z2 = this.f5346s - this.f5345r >= this.f5292D.length;
        if ((!z || z2) && z != this.f5311W) {
            this.f5311W = z;
        }
    }

    public void setOnLongPressUpdateInterval(long j) {
        this.f5352y = j;
    }

    public int getValue() {
        return this.f5347t;
    }

    public int getMinValue() {
        return this.f5345r;
    }

    public void setMinValue(int i) {
        this.f5345r = i;
        int i2 = this.f5345r;
        if (i2 > this.f5347t) {
            this.f5347t = i2;
        }
        setWrapSelectorWheel(this.f5346s - this.f5345r > this.f5292D.length);
        m7217e();
        m7212h();
        m7220d();
        invalidate();
    }

    public int getMaxValue() {
        return this.f5346s;
    }

    public void setMaxValue(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.f5346s = i;
        int i2 = this.f5346s;
        if (i2 < this.f5347t) {
            this.f5347t = i2;
        }
        setWrapSelectorWheel(this.f5346s - this.f5345r > this.f5292D.length);
        m7217e();
        m7212h();
        m7220d();
        invalidate();
    }

    public String[] getDisplayedValues() {
        return this.f5344q;
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.f5344q == strArr) {
            return;
        }
        this.f5344q = strArr;
        if (this.f5344q != null) {
            this.f5329b.setRawInputType(524289);
        } else {
            this.f5329b.setRawInputType(2);
        }
        m7212h();
        m7217e();
        m7220d();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return (m7247a() || !this.f5326ao) ? 0.0f : 0.9f;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return (m7247a() || !this.f5326ao) ? 0.0f : 0.9f;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        return (m7247a() && this.f5326ao) ? 0.9f : 0.0f;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        return (m7247a() && this.f5326ao) ? 0.9f : 0.0f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m7210j();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        int[] selectorIndices = getSelectorIndices();
        float f = this.f5296H;
        float right = (getRight() - getLeft()) / 2;
        for (int i = 0; i < selectorIndices.length; i++) {
            if (i == this.f5291C) {
                this.f5293E.setTextSize(this.f5340m);
                this.f5293E.setColor(this.f5337j);
            } else {
                this.f5293E.setTextSize(this.f5339l);
                this.f5293E.setColor(this.f5338k);
            }
            String str = this.f5353z.get(selectorIndices[m7232b() ? i : (selectorIndices.length - i) - 1]);
            if (i != this.f5291C || this.f5329b.getVisibility() != 0) {
                if (m7247a()) {
                    canvas.drawText(str, right, f, this.f5293E);
                } else {
                    canvas.drawText(str, right, m7241a(this.f5293E.getFontMetrics()) + f, this.f5293E);
                }
            }
            if (m7247a()) {
                right += this.f5294F;
            } else {
                f += this.f5294F;
            }
        }
        canvas.restore();
        if (this.f5312aa != null) {
            if (m7247a()) {
                int i2 = this.f5319ah;
                this.f5312aa.setBounds(i2, 0, this.f5315ad + i2, getBottom());
                this.f5312aa.draw(canvas);
                int i3 = this.f5320ai;
                this.f5312aa.setBounds(i3 - this.f5315ad, 0, i3, getBottom());
                this.f5312aa.draw(canvas);
                return;
            }
            int i4 = this.f5317af;
            int i5 = this.f5315ad + i4;
            Log.d("NumberPicker", "top divider : x=" + i4 + ", bottom=" + i5);
            this.f5312aa.setBounds(0, i4, getRight(), i5);
            this.f5312aa.draw(canvas);
            int i6 = this.f5318ag;
            this.f5312aa.setBounds(0, i6 - this.f5315ad, getRight(), i6);
            this.f5312aa.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NumberPicker.class.getName());
        accessibilityEvent.setScrollable(m7224c());
        int i = this.f5345r;
        int i2 = this.f5294F;
        int i3 = (this.f5347t + i) * i2;
        int i4 = (this.f5346s - i) * i2;
        if (m7247a()) {
            accessibilityEvent.setScrollX(i3);
            accessibilityEvent.setMaxScrollX(i4);
            return;
        }
        accessibilityEvent.setScrollY(i3);
        accessibilityEvent.setMaxScrollY(i4);
    }

    /* renamed from: b */
    private int m7229b(int i, int i2) {
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

    /* renamed from: b */
    private int m7228b(int i, int i2, int i3) {
        return i != -1 ? m7243a(Math.max(i, i2), i3, 0) : i2;
    }

    /* renamed from: a */
    public static int m7243a(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0 && mode == 1073741824) {
                i = size;
            }
        } else if (size < i) {
            i = 16777216 | size;
        }
        return i | ((-16777216) & i3);
    }

    /* renamed from: e */
    private void m7217e() {
        this.f5353z.clear();
        int[] selectorIndices = getSelectorIndices();
        int value = getValue();
        for (int i = 0; i < this.f5292D.length; i++) {
            int i2 = (i - this.f5291C) + value;
            if (this.f5311W) {
                i2 = m7222c(i2);
            }
            selectorIndices[i] = i2;
            m7218d(selectorIndices[i]);
        }
    }

    /* renamed from: a */
    private void m7242a(int i, boolean z) {
        int min;
        if (this.f5347t == i) {
            return;
        }
        if (this.f5311W) {
            min = m7222c(i);
        } else {
            min = Math.min(Math.max(i, this.f5345r), this.f5346s);
        }
        int i2 = this.f5347t;
        this.f5347t = min;
        m7212h();
        if (z) {
            m7221c(i2, min);
        }
        m7217e();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7235a(boolean z) {
        this.f5329b.setVisibility(4);
        if (!m7238a(this.f5297I)) {
            m7238a(this.f5298J);
        }
        if (m7247a()) {
            this.f5299K = 0;
            if (z) {
                this.f5297I.m6968a(0, 0, -this.f5294F, 0, IjkMediaCodecInfo.RANK_SECURE);
            } else {
                this.f5297I.m6968a(0, 0, this.f5294F, 0, IjkMediaCodecInfo.RANK_SECURE);
            }
        } else {
            this.f5300L = 0;
            if (z) {
                this.f5297I.m6968a(0, 0, 0, -this.f5294F, IjkMediaCodecInfo.RANK_SECURE);
            } else {
                this.f5297I.m6968a(0, 0, 0, this.f5294F, IjkMediaCodecInfo.RANK_SECURE);
            }
        }
        invalidate();
    }

    /* renamed from: f */
    private void m7215f() {
        m7217e();
        int[] selectorIndices = getSelectorIndices();
        int length = ((selectorIndices.length - 1) * ((int) this.f5339l)) + ((int) this.f5340m);
        float length2 = selectorIndices.length;
        if (m7247a()) {
            this.f5342o = (int) (((getRight() - getLeft()) - length) / length2);
            this.f5294F = ((int) getMaxTextSize()) + this.f5342o;
            this.f5295G = ((int) this.f5330c) - (this.f5294F * this.f5291C);
        } else {
            this.f5343p = (int) (((getBottom() - getTop()) - length) / length2);
            this.f5294F = ((int) getMaxTextSize()) + this.f5343p;
            this.f5295G = ((int) this.f5331d) - (this.f5294F * this.f5291C);
        }
        this.f5296H = this.f5295G;
        m7212h();
    }

    /* renamed from: g */
    private void m7213g() {
        if (m7247a()) {
            setHorizontalFadingEdgeEnabled(true);
            setFadingEdgeLength(((getRight() - getLeft()) - ((int) this.f5339l)) / 2);
            return;
        }
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - ((int) this.f5339l)) / 2);
    }

    /* renamed from: b */
    private void m7226b(Scroller scroller) {
        if (scroller == this.f5297I) {
            if (!m7209k()) {
                m7212h();
            }
            m7245a(0);
        } else if (this.f5316ae != 1) {
            m7212h();
        }
    }

    /* renamed from: a */
    private void m7245a(int i) {
        if (this.f5316ae == i) {
            return;
        }
        this.f5316ae = i;
        InterfaceC1933c interfaceC1933c = this.f5350w;
        if (interfaceC1933c != null) {
            interfaceC1933c.m7205a(this, i);
        }
    }

    /* renamed from: b */
    private void m7230b(int i) {
        if (m7247a()) {
            this.f5299K = 0;
            if (i > 0) {
                this.f5297I.m6967a(0, 0, i, 0, 0, Integer.MAX_VALUE, 0, 0);
            } else {
                this.f5297I.m6967a(Integer.MAX_VALUE, 0, i, 0, 0, Integer.MAX_VALUE, 0, 0);
            }
        } else {
            this.f5300L = 0;
            if (i > 0) {
                this.f5297I.m6967a(0, 0, 0, i, 0, 0, 0, Integer.MAX_VALUE);
            } else {
                this.f5297I.m6967a(0, Integer.MAX_VALUE, 0, i, 0, 0, 0, Integer.MAX_VALUE);
            }
        }
        invalidate();
    }

    /* renamed from: c */
    private int m7222c(int i) {
        int i2 = this.f5346s;
        if (i > i2) {
            int i3 = this.f5345r;
            return (i3 + ((i - i2) % (i2 - i3))) - 1;
        }
        int i4 = this.f5345r;
        return i < i4 ? (i2 - ((i4 - i) % (i2 - i4))) + 1 : i;
    }

    private int[] getSelectorIndices() {
        return this.f5292D;
    }

    /* renamed from: a */
    private void m7233a(int[] iArr) {
        int i = 0;
        while (i < iArr.length - 1) {
            int i2 = i + 1;
            iArr[i] = iArr[i2];
            i = i2;
        }
        int i3 = iArr[iArr.length - 2] + 1;
        if (this.f5311W && i3 > this.f5346s) {
            i3 = this.f5345r;
        }
        iArr[iArr.length - 1] = i3;
        m7218d(i3);
    }

    /* renamed from: b */
    private void m7225b(int[] iArr) {
        for (int length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        int i = iArr[1] - 1;
        if (this.f5311W && i < this.f5345r) {
            i = this.f5346s;
        }
        iArr[0] = i;
        m7218d(i);
    }

    /* renamed from: d */
    private void m7218d(int i) {
        String str;
        SparseArray<String> sparseArray = this.f5353z;
        if (sparseArray.get(i) != null) {
            return;
        }
        int i2 = this.f5345r;
        if (i < i2 || i > this.f5346s) {
            str = "";
        } else {
            String[] strArr = this.f5344q;
            if (strArr != null) {
                str = strArr[i - i2];
            } else {
                str = m7216e(i);
            }
        }
        sparseArray.put(i, str);
    }

    /* renamed from: e */
    private String m7216e(int i) {
        InterfaceC1932b interfaceC1932b = this.f5351x;
        return interfaceC1932b != null ? interfaceC1932b.mo7203a(i) : m7214f(i);
    }

    /* renamed from: h */
    private boolean m7212h() {
        String[] strArr = this.f5344q;
        String m7216e = strArr == null ? m7216e(this.f5347t) : strArr[this.f5347t - this.f5345r];
        if (TextUtils.isEmpty(m7216e) || m7216e.equals(this.f5329b.getText().toString())) {
            return false;
        }
        this.f5329b.setText(m7216e);
        return true;
    }

    /* renamed from: c */
    private void m7221c(int i, int i2) {
        InterfaceC1934d interfaceC1934d = this.f5349v;
        if (interfaceC1934d != null) {
            interfaceC1934d.m7204a(this, i, this.f5347t);
        }
    }

    /* renamed from: a */
    private void m7234a(boolean z, long j) {
        RunnableC1931a runnableC1931a = this.f5302N;
        if (runnableC1931a == null) {
            this.f5302N = new RunnableC1931a();
        } else {
            removeCallbacks(runnableC1931a);
        }
        this.f5302N.m7206a(z);
        postDelayed(this.f5302N, j);
    }

    /* renamed from: i */
    private void m7211i() {
        RunnableC1931a runnableC1931a = this.f5302N;
        if (runnableC1931a != null) {
            removeCallbacks(runnableC1931a);
        }
    }

    /* renamed from: j */
    private void m7210j() {
        RunnableC1931a runnableC1931a = this.f5302N;
        if (runnableC1931a != null) {
            removeCallbacks(runnableC1931a);
        }
        RunnableC1935e runnableC1935e = this.f5301M;
        if (runnableC1935e != null) {
            removeCallbacks(runnableC1935e);
        }
    }

    /* renamed from: k */
    private boolean m7209k() {
        int i;
        int i2 = this.f5295G - this.f5296H;
        if (i2 != 0) {
            int abs = Math.abs(i2);
            int i3 = this.f5294F;
            if (abs > i3 / 2) {
                if (i2 > 0) {
                    i3 = -i3;
                }
                i = i2 + i3;
            } else {
                i = i2;
            }
            if (m7247a()) {
                this.f5299K = 0;
                this.f5298J.m6968a(0, 0, i, 0, 800);
            } else {
                this.f5300L = 0;
                this.f5298J.m6968a(0, 0, 0, i, 800);
            }
            invalidate();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.widget.NumberPicker$e */
    /* loaded from: classes.dex */
    public class RunnableC1935e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ NumberPicker f5358a;

        /* renamed from: b */
        private int f5359b;

        /* renamed from: c */
        private int f5360c;

        @Override // java.lang.Runnable
        public void run() {
            this.f5358a.f5329b.setSelection(this.f5359b, this.f5360c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.widget.NumberPicker$a */
    /* loaded from: classes.dex */
    public class RunnableC1931a implements Runnable {

        /* renamed from: b */
        private boolean f5357b;

        RunnableC1931a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m7206a(boolean z) {
            this.f5357b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberPicker.this.m7235a(this.f5357b);
            NumberPicker numberPicker = NumberPicker.this;
            numberPicker.postDelayed(this, numberPicker.f5352y);
        }
    }

    /* renamed from: f */
    private String m7214f(int i) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(i));
    }

    /* renamed from: l */
    private void m7208l() {
        if (m7247a()) {
            this.f5332e = -1;
            this.f5333f = (int) m7246a(64.0f);
            this.f5334g = (int) m7246a(180.0f);
            this.f5335h = -1;
            return;
        }
        this.f5332e = -1;
        this.f5333f = (int) m7246a(180.0f);
        this.f5334g = (int) m7246a(64.0f);
        this.f5335h = -1;
    }

    public void setDividerColor(@ColorInt int i) {
        this.f5313ab = i;
        this.f5312aa = new ColorDrawable(i);
    }

    public void setDividerColorResource(@ColorRes int i) {
        setDividerColor(ContextCompat.getColor(this.f5328aq, i));
    }

    public void setDividerDistance(int i) {
        this.f5314ac = (int) m7246a(i);
    }

    public void setDividerThickness(int i) {
        this.f5315ad = (int) m7246a(i);
    }

    public void setOrder(int i) {
        this.f5325an = i;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        this.f5324am = i;
        m7208l();
    }

    public void setWheelItemCount(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Wheel item count must be >= 1");
        }
        this.f5290B = i;
        if (i < 3) {
            i = 3;
        }
        this.f5289A = i;
        int i2 = this.f5289A;
        this.f5291C = i2 / 2;
        this.f5292D = new int[i2];
    }

    public void setFormatter(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setFormatter(m7237a(str));
    }

    public void setFormatter(@StringRes int i) {
        setFormatter(getResources().getString(i));
    }

    public void setFadingEdgeEnabled(boolean z) {
        this.f5326ao = z;
    }

    public void setScrollerEnabled(boolean z) {
        this.f5327ap = z;
    }

    public void setSelectedTextColor(@ColorInt int i) {
        this.f5337j = i;
        this.f5329b.setTextColor(this.f5337j);
    }

    public void setSelectedTextColorResource(@ColorRes int i) {
        setSelectedTextColor(ContextCompat.getColor(this.f5328aq, i));
    }

    public void setSelectedTextSize(float f) {
        this.f5340m = f;
        this.f5329b.setTextSize(m7219d(this.f5340m));
    }

    public void setSelectedTextSize(@DimenRes int i) {
        setSelectedTextSize(getResources().getDimension(i));
    }

    public void setTextColor(@ColorInt int i) {
        this.f5338k = i;
        this.f5293E.setColor(this.f5338k);
    }

    public void setTextColorResource(@ColorRes int i) {
        setTextColor(ContextCompat.getColor(this.f5328aq, i));
    }

    public void setTextSize(float f) {
        this.f5339l = f;
        this.f5293E.setTextSize(this.f5339l);
    }

    public void setTextSize(@DimenRes int i) {
        setTextSize(getResources().getDimension(i));
    }

    public void setTypeface(Typeface typeface) {
        this.f5341n = typeface;
        Typeface typeface2 = this.f5341n;
        if (typeface2 != null) {
            this.f5329b.setTypeface(typeface2);
            this.f5293E.setTypeface(this.f5341n);
            return;
        }
        this.f5329b.setTypeface(Typeface.MONOSPACE);
        this.f5293E.setTypeface(Typeface.MONOSPACE);
    }

    /* renamed from: a */
    public void m7236a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setTypeface(Typeface.create(str, i));
    }

    public void setTypeface(String str) {
        m7236a(str, 0);
    }

    /* renamed from: a */
    public void m7244a(@StringRes int i, int i2) {
        m7236a(getResources().getString(i), i2);
    }

    public void setTypeface(@StringRes int i) {
        m7244a(i, 0);
    }

    /* renamed from: a */
    private InterfaceC1932b m7237a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new InterfaceC1932b() { // from class: com.navatics.app.widget.NumberPicker.1
            @Override // com.navatics.app.widget.NumberPicker.InterfaceC1932b
            /* renamed from: a */
            public String mo7203a(int i) {
                return String.format(Locale.getDefault(), str, Integer.valueOf(i));
            }
        };
    }

    /* renamed from: a */
    private float m7246a(float f) {
        return f * getResources().getDisplayMetrics().density;
    }

    /* renamed from: b */
    private float m7231b(float f) {
        return f / getResources().getDisplayMetrics().density;
    }

    /* renamed from: c */
    private float m7223c(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    /* renamed from: d */
    private float m7219d(float f) {
        return f / getResources().getDisplayMetrics().scaledDensity;
    }

    /* renamed from: a */
    public boolean m7247a() {
        return getOrientation() == 0;
    }

    /* renamed from: b */
    public boolean m7232b() {
        return getOrder() == 0;
    }

    public int getDividerColor() {
        return this.f5313ab;
    }

    public float getDividerDistance() {
        return m7231b(this.f5314ac);
    }

    public float getDividerThickness() {
        return m7231b(this.f5315ad);
    }

    public int getOrder() {
        return this.f5325an;
    }

    @Override // android.widget.LinearLayout
    public int getOrientation() {
        return this.f5324am;
    }

    public int getWheelItemCount() {
        return this.f5289A;
    }

    public InterfaceC1932b getFormatter() {
        return this.f5351x;
    }

    /* renamed from: c */
    public boolean m7224c() {
        return this.f5327ap;
    }

    public int getSelectedTextColor() {
        return this.f5337j;
    }

    public float getSelectedTextSize() {
        return this.f5340m;
    }

    public int getTextColor() {
        return this.f5338k;
    }

    public float getTextSize() {
        return m7223c(this.f5339l);
    }

    public Typeface getTypeface() {
        return this.f5341n;
    }
}
