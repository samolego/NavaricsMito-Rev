package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p008v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import com.yanzhenjie.recyclerview.Horizontal;

/* loaded from: classes2.dex */
public class SwipeMenuLayout extends FrameLayout implements Controller {

    /* renamed from: a */
    private int f9163a;

    /* renamed from: b */
    private int f9164b;

    /* renamed from: c */
    private int f9165c;

    /* renamed from: d */
    private float f9166d;

    /* renamed from: e */
    private int f9167e;

    /* renamed from: f */
    private int f9168f;

    /* renamed from: g */
    private int f9169g;

    /* renamed from: h */
    private int f9170h;

    /* renamed from: i */
    private int f9171i;

    /* renamed from: j */
    private int f9172j;

    /* renamed from: k */
    private View f9173k;

    /* renamed from: l */
    private LeftHorizontal f9174l;

    /* renamed from: m */
    private RightHorizontal f9175m;

    /* renamed from: n */
    private Horizontal f9176n;

    /* renamed from: o */
    private boolean f9177o;

    /* renamed from: p */
    private boolean f9178p;

    /* renamed from: q */
    private boolean f9179q;

    /* renamed from: r */
    private OverScroller f9180r;

    /* renamed from: s */
    private VelocityTracker f9181s;

    /* renamed from: t */
    private int f9182t;

    /* renamed from: u */
    private int f9183u;

    public SwipeMenuLayout(Context context) {
        this(context, null);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9163a = 0;
        this.f9164b = 0;
        this.f9165c = 0;
        this.f9166d = 0.5f;
        this.f9167e = 200;
        this.f9179q = true;
        setClickable(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeMenuLayout);
        this.f9163a = obtainStyledAttributes.getResourceId(R.styleable.SwipeMenuLayout_leftViewId, this.f9163a);
        this.f9164b = obtainStyledAttributes.getResourceId(R.styleable.SwipeMenuLayout_contentViewId, this.f9164b);
        this.f9165c = obtainStyledAttributes.getResourceId(R.styleable.SwipeMenuLayout_rightViewId, this.f9165c);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f9168f = viewConfiguration.getScaledTouchSlop();
        this.f9182t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f9183u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f9180r = new OverScroller(getContext());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f9163a;
        if (i != 0 && this.f9174l == null) {
            this.f9174l = new LeftHorizontal(findViewById(i));
        }
        int i2 = this.f9165c;
        if (i2 != 0 && this.f9175m == null) {
            this.f9175m = new RightHorizontal(findViewById(i2));
        }
        int i3 = this.f9164b;
        if (i3 != 0 && this.f9173k == null) {
            this.f9173k = findViewById(i3);
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setClickable(true);
        textView.setGravity(17);
        textView.setTextSize(16.0f);
        textView.setText("You may not have set the ContentView.");
        this.f9173k = textView;
        addView(this.f9173k);
    }

    public void setSwipeEnable(boolean z) {
        this.f9179q = z;
    }

    /* renamed from: a */
    public boolean m3857a() {
        return this.f9179q;
    }

    public void setOpenPercent(float f) {
        this.f9166d = f;
    }

    public float getOpenPercent() {
        return this.f9166d;
    }

    public void setScrollerDuration(int i) {
        this.f9167e = i;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (m3857a()) {
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    this.f9169g = x;
                    this.f9171i = x;
                    this.f9172j = (int) motionEvent.getY();
                    return false;
                case 1:
                    Horizontal horizontal = this.f9176n;
                    boolean z = horizontal != null && horizontal.mo3805a(getWidth(), motionEvent.getX());
                    if (m3849d() && z) {
                        m3840m();
                        return true;
                    }
                    return false;
                case 2:
                    int x2 = (int) (motionEvent.getX() - this.f9171i);
                    return Math.abs(x2) > this.f9168f && Math.abs(x2) > Math.abs((int) (motionEvent.getY() - ((float) this.f9172j)));
                case 3:
                    if (!this.f9180r.isFinished()) {
                        this.f9180r.abortAnimation();
                    }
                    return false;
                default:
                    return onInterceptTouchEvent;
            }
        }
        return onInterceptTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m3857a()) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.f9181s == null) {
            this.f9181s = VelocityTracker.obtain();
        }
        this.f9181s.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.f9169g = (int) motionEvent.getX();
                this.f9170h = (int) motionEvent.getY();
                break;
            case 1:
                int x = (int) (this.f9171i - motionEvent.getX());
                int y = (int) (this.f9172j - motionEvent.getY());
                this.f9178p = false;
                this.f9181s.computeCurrentVelocity(1000, this.f9183u);
                int xVelocity = (int) this.f9181s.getXVelocity();
                int abs = Math.abs(xVelocity);
                if (abs > this.f9182t) {
                    if (this.f9176n != null) {
                        int m3853a = m3853a(motionEvent, abs);
                        if (this.f9176n instanceof RightHorizontal) {
                            if (xVelocity < 0) {
                                m3851b(m3853a);
                            } else {
                                m3855a(m3853a);
                            }
                        } else if (xVelocity > 0) {
                            m3851b(m3853a);
                        } else {
                            m3855a(m3853a);
                        }
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                } else {
                    m3854a(x, y);
                }
                this.f9181s.clear();
                this.f9181s.recycle();
                this.f9181s = null;
                if (Math.abs(this.f9171i - motionEvent.getX()) > this.f9168f || Math.abs(this.f9172j - motionEvent.getY()) > this.f9168f || m3848e() || m3847f()) {
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                break;
            case 2:
                int x2 = (int) (this.f9169g - motionEvent.getX());
                int y2 = (int) (this.f9170h - motionEvent.getY());
                if (!this.f9178p && Math.abs(x2) > this.f9168f && Math.abs(x2) > Math.abs(y2)) {
                    this.f9178p = true;
                }
                if (this.f9178p) {
                    if (this.f9176n == null || this.f9177o) {
                        if (x2 < 0) {
                            LeftHorizontal leftHorizontal = this.f9174l;
                            if (leftHorizontal != null) {
                                this.f9176n = leftHorizontal;
                            } else {
                                this.f9176n = this.f9175m;
                            }
                        } else {
                            RightHorizontal rightHorizontal = this.f9175m;
                            if (rightHorizontal != null) {
                                this.f9176n = rightHorizontal;
                            } else {
                                this.f9176n = this.f9174l;
                            }
                        }
                    }
                    scrollBy(x2, 0);
                    this.f9169g = (int) motionEvent.getX();
                    this.f9170h = (int) motionEvent.getY();
                    this.f9177o = false;
                    break;
                }
                break;
            case 3:
                this.f9178p = false;
                if (!this.f9180r.isFinished()) {
                    this.f9180r.abortAnimation();
                    break;
                } else {
                    m3854a((int) (this.f9171i - motionEvent.getX()), (int) (this.f9172j - motionEvent.getY()));
                    break;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private int m3853a(MotionEvent motionEvent, int i) {
        int abs;
        int x = (int) (motionEvent.getX() - getScrollX());
        int m3811d = this.f9176n.m3811d();
        int i2 = m3811d / 2;
        float f = m3811d;
        float f2 = i2;
        float m3856a = f2 + (m3856a(Math.min(1.0f, (Math.abs(x) * 1.0f) / f)) * f2);
        if (i > 0) {
            abs = Math.round(Math.abs(m3856a / i) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(x) / f) + 1.0f) * 100.0f);
        }
        return Math.min(abs, this.f9167e);
    }

    /* renamed from: a */
    float m3856a(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    /* renamed from: a */
    private void m3854a(int i, int i2) {
        if (this.f9176n != null) {
            if (Math.abs(getScrollX()) >= this.f9176n.m3812c().getWidth() * this.f9166d) {
                if (Math.abs(i) > this.f9168f || Math.abs(i2) > this.f9168f) {
                    if (m3844i()) {
                        m3840m();
                        return;
                    } else {
                        m3841l();
                        return;
                    }
                } else if (m3849d()) {
                    m3840m();
                    return;
                } else {
                    m3841l();
                    return;
                }
            }
            m3840m();
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Horizontal horizontal = this.f9176n;
        if (horizontal == null) {
            super.scrollTo(i, i2);
            return;
        }
        Horizontal.C2798a mo3804a = horizontal.mo3804a(i, i2);
        this.f9177o = mo3804a.f9241c;
        if (mo3804a.f9239a != getScrollX()) {
            super.scrollTo(mo3804a.f9239a, mo3804a.f9240b);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Horizontal horizontal;
        if (!this.f9180r.computeScrollOffset() || (horizontal = this.f9176n) == null) {
            return;
        }
        if (horizontal instanceof RightHorizontal) {
            scrollTo(Math.abs(this.f9180r.getCurrX()), 0);
            invalidate();
            return;
        }
        scrollTo(-Math.abs(this.f9180r.getCurrX()), 0);
        invalidate();
    }

    /* renamed from: b */
    public boolean m3852b() {
        LeftHorizontal leftHorizontal = this.f9174l;
        return leftHorizontal != null && leftHorizontal.m3815a();
    }

    /* renamed from: c */
    public boolean m3850c() {
        RightHorizontal rightHorizontal = this.f9175m;
        return rightHorizontal != null && rightHorizontal.m3815a();
    }

    /* renamed from: d */
    public boolean m3849d() {
        return m3848e() || m3847f();
    }

    /* renamed from: e */
    public boolean m3848e() {
        LeftHorizontal leftHorizontal = this.f9174l;
        return leftHorizontal != null && leftHorizontal.m3810b(getScrollX());
    }

    /* renamed from: f */
    public boolean m3847f() {
        RightHorizontal rightHorizontal = this.f9175m;
        return rightHorizontal != null && rightHorizontal.m3802b(getScrollX());
    }

    /* renamed from: g */
    public boolean m3846g() {
        LeftHorizontal leftHorizontal = this.f9174l;
        return (leftHorizontal == null || leftHorizontal.m3814a(getScrollX())) ? false : true;
    }

    /* renamed from: h */
    public boolean m3845h() {
        RightHorizontal rightHorizontal = this.f9175m;
        return (rightHorizontal == null || rightHorizontal.m3814a(getScrollX())) ? false : true;
    }

    /* renamed from: i */
    public boolean m3844i() {
        return m3843j() || m3842k();
    }

    /* renamed from: j */
    public boolean m3843j() {
        LeftHorizontal leftHorizontal = this.f9174l;
        return leftHorizontal != null && leftHorizontal.m3809c(getScrollX());
    }

    /* renamed from: k */
    public boolean m3842k() {
        RightHorizontal rightHorizontal = this.f9175m;
        return rightHorizontal != null && rightHorizontal.m3800c(getScrollX());
    }

    /* renamed from: l */
    public void m3841l() {
        m3851b(this.f9167e);
    }

    /* renamed from: b */
    private void m3851b(int i) {
        Horizontal horizontal = this.f9176n;
        if (horizontal != null) {
            horizontal.mo3803a(this.f9180r, getScrollX(), i);
            invalidate();
        }
    }

    /* renamed from: m */
    public void m3840m() {
        m3855a(this.f9167e);
    }

    /* renamed from: a */
    public void m3855a(int i) {
        Horizontal horizontal = this.f9176n;
        if (horizontal != null) {
            horizontal.mo3801b(this.f9180r, getScrollX(), i);
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.f9173k;
        if (view != null) {
            int measuredWidthAndState = view.getMeasuredWidthAndState();
            int measuredHeightAndState = this.f9173k.getMeasuredHeightAndState();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop() + ((FrameLayout.LayoutParams) this.f9173k.getLayoutParams()).topMargin;
            this.f9173k.layout(paddingLeft, paddingTop, measuredWidthAndState + paddingLeft, measuredHeightAndState + paddingTop);
        }
        LeftHorizontal leftHorizontal = this.f9174l;
        if (leftHorizontal != null) {
            View c = leftHorizontal.m3812c();
            int measuredWidthAndState2 = c.getMeasuredWidthAndState();
            int measuredHeightAndState2 = c.getMeasuredHeightAndState();
            int paddingTop2 = getPaddingTop() + ((FrameLayout.LayoutParams) c.getLayoutParams()).topMargin;
            c.layout(-measuredWidthAndState2, paddingTop2, 0, measuredHeightAndState2 + paddingTop2);
        }
        RightHorizontal rightHorizontal = this.f9175m;
        if (rightHorizontal != null) {
            View c2 = rightHorizontal.m3812c();
            int measuredWidthAndState3 = c2.getMeasuredWidthAndState();
            int measuredHeightAndState3 = c2.getMeasuredHeightAndState();
            int paddingTop3 = getPaddingTop() + ((FrameLayout.LayoutParams) c2.getLayoutParams()).topMargin;
            int measuredWidthAndState4 = getMeasuredWidthAndState();
            c2.layout(measuredWidthAndState4, paddingTop3, measuredWidthAndState3 + measuredWidthAndState4, measuredHeightAndState3 + paddingTop3);
        }
    }
}
