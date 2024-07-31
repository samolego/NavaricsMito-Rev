package com.yanzhenjie.recyclerview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.p008v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class StickyNestedScrollView extends NestedScrollView {

    /* renamed from: a */
    private ArrayList<View> f9273a;

    /* renamed from: b */
    private View f9274b;

    /* renamed from: c */
    private float f9275c;

    /* renamed from: d */
    private final Runnable f9276d;

    /* renamed from: e */
    private int f9277e;

    /* renamed from: f */
    private boolean f9278f;

    /* renamed from: g */
    private boolean f9279g;

    /* renamed from: h */
    private boolean f9280h;

    /* renamed from: i */
    private int f9281i;

    /* renamed from: j */
    private Drawable f9282j;

    /* renamed from: k */
    private boolean f9283k;

    /* renamed from: l */
    private List<InterfaceC2800a> f9284l;

    /* renamed from: com.yanzhenjie.recyclerview.widget.StickyNestedScrollView$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2800a {
        /* renamed from: a */
        void m3741a(View view);

        /* renamed from: b */
        void m3740b(View view);
    }

    public StickyNestedScrollView(Context context) {
        this(context, null);
    }

    public StickyNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842880);
    }

    public StickyNestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9276d = new Runnable() { // from class: com.yanzhenjie.recyclerview.widget.StickyNestedScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                if (StickyNestedScrollView.this.f9274b != null) {
                    StickyNestedScrollView stickyNestedScrollView = StickyNestedScrollView.this;
                    int m3759a = stickyNestedScrollView.m3759a(stickyNestedScrollView.f9274b);
                    StickyNestedScrollView stickyNestedScrollView2 = StickyNestedScrollView.this;
                    int m3748d = stickyNestedScrollView2.m3748d(stickyNestedScrollView2.f9274b);
                    StickyNestedScrollView stickyNestedScrollView3 = StickyNestedScrollView.this;
                    StickyNestedScrollView.this.invalidate(m3759a, m3748d, stickyNestedScrollView3.m3751c(stickyNestedScrollView3.f9274b), (int) (StickyNestedScrollView.this.getScrollY() + StickyNestedScrollView.this.f9274b.getHeight() + StickyNestedScrollView.this.f9275c));
                }
                StickyNestedScrollView.this.postDelayed(this, 16L);
            }
        };
        this.f9281i = 10;
        this.f9283k = true;
        m3760a();
    }

    public void addOnViewStickyListener(InterfaceC2800a interfaceC2800a) {
        if (this.f9284l == null) {
            this.f9284l = new ArrayList();
        }
        this.f9284l.add(interfaceC2800a);
    }

    public void removeOnViewStickyListener(InterfaceC2800a interfaceC2800a) {
        List<InterfaceC2800a> list = this.f9284l;
        if (list != null) {
            list.remove(interfaceC2800a);
        }
    }

    public void setShadowHeight(int i) {
        this.f9281i = i;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f9282j = drawable;
    }

    /* renamed from: a */
    public void m3760a() {
        this.f9273a = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m3759a(View view) {
        int left = view.getLeft();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            left += view.getLeft();
        }
        return left;
    }

    /* renamed from: b */
    private int m3755b(View view) {
        int top = view.getTop();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            top += view.getTop();
        }
        return top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m3751c(View view) {
        int right = view.getRight();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            right += view.getRight();
        }
        return right;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m3748d(View view) {
        int bottom = view.getBottom();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            bottom += view.getBottom();
        }
        return bottom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.f9280h) {
            this.f9279g = true;
        }
        m3749d();
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.f9279g = z;
        this.f9280h = true;
    }

    @Override // android.support.p008v4.widget.NestedScrollView, android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        m3746f(view);
    }

    @Override // android.support.p008v4.widget.NestedScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        m3746f(view);
    }

    @Override // android.support.p008v4.widget.NestedScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        m3746f(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        super.addView(view, i, i2);
        m3746f(view);
    }

    @Override // android.support.p008v4.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        m3746f(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f9274b != null) {
            canvas.save();
            canvas.translate(getPaddingLeft() + this.f9277e, getScrollY() + this.f9275c + (this.f9279g ? getPaddingTop() : 0));
            canvas.clipRect(0.0f, this.f9279g ? -this.f9275c : 0.0f, getWidth() - this.f9277e, this.f9274b.getHeight() + this.f9281i + 1);
            if (this.f9282j != null) {
                this.f9282j.setBounds(0, this.f9274b.getHeight(), this.f9274b.getWidth(), this.f9274b.getHeight() + this.f9281i);
                this.f9282j.draw(canvas);
            }
            canvas.clipRect(0.0f, this.f9279g ? -this.f9275c : 0.0f, getWidth(), this.f9274b.getHeight());
            if (m3744h(this.f9274b).contains("-hastransparency")) {
                m3742j(this.f9274b);
                this.f9274b.draw(canvas);
                m3743i(this.f9274b);
            } else {
                this.f9274b.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getAction() == 0) {
            this.f9278f = true;
        }
        if (this.f9278f) {
            this.f9278f = this.f9274b != null;
            if (this.f9278f) {
                this.f9278f = (motionEvent.getY() > ((float) this.f9274b.getHeight()) + this.f9275c || motionEvent.getX() < ((float) m3759a(this.f9274b)) || motionEvent.getX() > ((float) m3751c(this.f9274b))) ? false : false;
            }
        } else if (this.f9274b == null) {
            this.f9278f = false;
        }
        if (this.f9278f) {
            motionEvent.offsetLocation(0.0f, ((getScrollY() + this.f9275c) - m3755b(this.f9274b)) * (-1.0f));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.support.p008v4.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f9278f) {
            motionEvent.offsetLocation(0.0f, (getScrollY() + this.f9275c) - m3755b(this.f9274b));
        }
        if (motionEvent.getAction() == 0) {
            this.f9283k = false;
        }
        if (this.f9283k) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(0);
            super.onTouchEvent(obtain);
            this.f9283k = false;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.f9283k = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m3756b();
    }

    /* renamed from: b */
    private void m3756b() {
        float min;
        Iterator<View> it = this.f9273a.iterator();
        View view = null;
        View view2 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            View next = it.next();
            int m3755b = (m3755b(next) - getScrollY()) + (this.f9279g ? 0 : getPaddingTop());
            if (m3755b <= 0) {
                if (view != null) {
                    if (m3755b > (m3755b(view) - getScrollY()) + (this.f9279g ? 0 : getPaddingTop())) {
                    }
                }
                view = next;
            } else {
                if (view2 != null) {
                    if (m3755b < (m3755b(view2) - getScrollY()) + (this.f9279g ? 0 : getPaddingTop())) {
                    }
                }
                view2 = next;
            }
        }
        if (view != null) {
            if (view2 == null) {
                min = 0.0f;
            } else {
                min = Math.min(0, ((m3755b(view2) - getScrollY()) + (this.f9279g ? 0 : getPaddingTop())) - view.getHeight());
            }
            this.f9275c = min;
            View view3 = this.f9274b;
            if (view != view3) {
                if (view3 != null) {
                    List<InterfaceC2800a> list = this.f9284l;
                    if (list != null) {
                        for (InterfaceC2800a interfaceC2800a : list) {
                            interfaceC2800a.m3740b(this.f9274b);
                        }
                    }
                    m3752c();
                }
                this.f9277e = m3759a(view);
                m3747e(view);
                List<InterfaceC2800a> list2 = this.f9284l;
                if (list2 != null) {
                    for (InterfaceC2800a interfaceC2800a2 : list2) {
                        interfaceC2800a2.m3741a(this.f9274b);
                    }
                }
            }
        } else if (this.f9274b != null) {
            List<InterfaceC2800a> list3 = this.f9284l;
            if (list3 != null) {
                for (InterfaceC2800a interfaceC2800a3 : list3) {
                    interfaceC2800a3.m3740b(this.f9274b);
                }
            }
            m3752c();
        }
    }

    /* renamed from: e */
    private void m3747e(View view) {
        this.f9274b = view;
        View view2 = this.f9274b;
        if (view2 != null) {
            if (m3744h(view2).contains("-hastransparency")) {
                m3743i(this.f9274b);
            }
            if (m3744h(this.f9274b).contains("-nonconstant")) {
                post(this.f9276d);
            }
        }
    }

    /* renamed from: c */
    private void m3752c() {
        if (m3744h(this.f9274b).contains("-hastransparency")) {
            m3742j(this.f9274b);
        }
        this.f9274b = null;
        removeCallbacks(this.f9276d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f9276d);
        super.onDetachedFromWindow();
    }

    /* renamed from: d */
    private void m3749d() {
        if (this.f9274b != null) {
            m3752c();
        }
        this.f9273a.clear();
        m3746f(getChildAt(0));
        m3756b();
        invalidate();
    }

    /* renamed from: f */
    private void m3746f(View view) {
        if (m3745g(view) || !(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            m3746f(viewGroup.getChildAt(i));
        }
    }

    /* renamed from: g */
    private boolean m3745g(View view) {
        if (m3744h(view).contains("sticky")) {
            this.f9273a.add(view);
            return true;
        }
        return false;
    }

    /* renamed from: h */
    private String m3744h(View view) {
        return String.valueOf(view.getTag());
    }

    /* renamed from: i */
    private void m3743i(View view) {
        view.setAlpha(0.0f);
    }

    /* renamed from: j */
    private void m3742j(View view) {
        view.setAlpha(1.0f);
    }
}
