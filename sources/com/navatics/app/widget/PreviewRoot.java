package com.navatics.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.utils.Utils;
import com.navatics.app.R;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class PreviewRoot extends FrameLayout {

    /* renamed from: a */
    private static final C3044k f5469a = C3044k.m1564a(PreviewRoot.class);

    /* renamed from: b */
    private int f5470b;

    /* renamed from: c */
    private InterfaceC1953a f5471c;

    /* renamed from: d */
    private View f5472d;

    /* renamed from: e */
    private View f5473e;

    /* renamed from: f */
    private View f5474f;

    /* renamed from: g */
    private double f5475g;

    /* renamed from: com.navatics.app.widget.PreviewRoot$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1953a {
        /* renamed from: a */
        void mo7109a();

        /* renamed from: b */
        void mo7108b();
    }

    public PreviewRoot(@NonNull Context context) {
        super(context);
        this.f5470b = 0;
        this.f5475g = Utils.DOUBLE_EPSILON;
    }

    public PreviewRoot(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5470b = 0;
        this.f5475g = Utils.DOUBLE_EPSILON;
    }

    public PreviewRoot(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5470b = 0;
        this.f5475g = Utils.DOUBLE_EPSILON;
    }

    public void setMode(int i) {
        this.f5470b = i;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m7114a(i, i2, i3, i4, false);
        m7110d(i, i2, i3, i4);
        m7112b(i, i2, i3, i4);
        m7111c(i, i2, i3, i4);
        m7115a(i, i2, i3, i4);
    }

    /* renamed from: a */
    void m7114a(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                C1954b c1954b = (C1954b) childAt.getLayoutParams();
                if (childAt != getContentLayout() && childAt != getLayoutHelper() && childAt != getVideoView() && c1954b.f5476a != 2 && c1954b.f5476a != 1) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    C3044k c3044k = f5469a;
                    c3044k.mo1511a((Object) ("layout child : width=" + measuredWidth + ", "));
                    int i8 = c1954b.gravity;
                    if (i8 == -1) {
                        i8 = 8388659;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i8, getLayoutDirection());
                    int i9 = i8 & 112;
                    int i10 = absoluteGravity & 7;
                    if (i10 == 1) {
                        i5 = (((((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft) + c1954b.leftMargin) - c1954b.rightMargin;
                    } else if (i10 == 5 && !z) {
                        i5 = (paddingRight - measuredWidth) - c1954b.rightMargin;
                    } else {
                        i5 = c1954b.leftMargin + paddingLeft;
                    }
                    if (i9 == 16) {
                        i6 = (((((paddingBottom - paddingTop) - measuredHeight) / 2) + paddingTop) + c1954b.topMargin) - c1954b.bottomMargin;
                    } else if (i9 == 48) {
                        i6 = c1954b.topMargin + paddingTop;
                    } else if (i9 == 80) {
                        i6 = (paddingBottom - measuredHeight) - c1954b.bottomMargin;
                    } else {
                        i6 = c1954b.topMargin + paddingTop;
                    }
                    childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
                }
            }
        }
    }

    /* renamed from: a */
    private void m7115a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        RelativeLayout userGuideView = getUserGuideView();
        int measuredWidth = userGuideView.getMeasuredWidth();
        int measuredHeight = userGuideView.getMeasuredHeight();
        C1954b c1954b = (C1954b) userGuideView.getLayoutParams();
        int i5 = paddingLeft + c1954b.leftMargin;
        int i6 = paddingTop + c1954b.topMargin;
        userGuideView.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    /* renamed from: b */
    private void m7112b(int i, int i2, int i3, int i4) {
        if (this.f5470b == 0) {
            LayoutHelper layoutHelper = getLayoutHelper();
            ContentLayout contentLayout = getContentLayout();
            int measuredWidth = layoutHelper.getMeasuredWidth();
            int measuredHeight = layoutHelper.getMeasuredHeight();
            int left = contentLayout.getLeft();
            int top = contentLayout.getTop();
            int i5 = measuredWidth + left;
            int i6 = measuredHeight + top;
            getVideoView().layout(left, top, i5, i6);
            layoutHelper.layout(left, top, i5, i6);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        LayoutHelper layoutHelper2 = getLayoutHelper();
        int measuredWidth2 = layoutHelper2.getMeasuredWidth();
        int measuredHeight2 = layoutHelper2.getMeasuredHeight();
        C1954b c1954b = (C1954b) layoutHelper2.getLayoutParams();
        int i7 = ((paddingLeft + (((paddingRight - paddingLeft) - measuredWidth2) / 2)) + c1954b.leftMargin) - c1954b.rightMargin;
        int i8 = paddingTop + c1954b.topMargin;
        int i9 = measuredWidth2 + i7;
        int i10 = measuredHeight2 + i8;
        getVideoView().layout(i7, i8, i9, i10);
        layoutHelper2.layout(i7, i8, i9, i10);
    }

    /* renamed from: c */
    private void m7111c(int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            C1954b c1954b = (C1954b) childAt.getLayoutParams();
            if (c1954b.f5476a == 1) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LayoutHelper layoutHelper = getLayoutHelper();
                int left = layoutHelper.getLeft();
                int top = layoutHelper.getTop();
                childAt.layout(left, top, measuredWidth + left, measuredHeight + top);
            } else if (c1954b.f5476a == 2) {
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LayoutHelper layoutHelper2 = getLayoutHelper();
                int left2 = layoutHelper2.getLeft();
                int top2 = (layoutHelper2.getTop() + layoutHelper2.getMeasuredHeight()) - measuredHeight2;
                childAt.layout(left2, top2, measuredWidth2 + left2, measuredHeight2 + top2);
            }
        }
    }

    /* renamed from: d */
    private void m7110d(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        ContentLayout contentLayout = getContentLayout();
        int measuredWidth = contentLayout.getMeasuredWidth();
        int measuredHeight = contentLayout.getMeasuredHeight();
        C1954b c1954b = (C1954b) contentLayout.getLayoutParams();
        int i5 = ((paddingLeft + (((paddingRight - paddingLeft) - measuredWidth) / 2)) + c1954b.leftMargin) - c1954b.rightMargin;
        int i6 = paddingTop + c1954b.topMargin;
        contentLayout.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    private LayoutHelper getLayoutHelper() {
        if (this.f5473e == null) {
            this.f5473e = findViewById(R.id.layoutHelper);
        }
        return (LayoutHelper) this.f5473e;
    }

    private ContentLayout getContentLayout() {
        if (this.f5472d == null) {
            this.f5472d = findViewById(R.id.contentLayout);
        }
        return (ContentLayout) this.f5472d;
    }

    private View getVideoView() {
        if (this.f5474f == null) {
            View findViewById = findViewById(R.id.streamingView);
            if (findViewById.getVisibility() == 0) {
                this.f5474f = findViewById;
            } else {
                this.f5474f = findViewById(R.id.surfaceStreamingView);
            }
        }
        return this.f5474f;
    }

    private RelativeLayout getUserGuideView() {
        return (RelativeLayout) findViewById(R.id.rl_userGuide);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: a */
    public C1954b generateLayoutParams(AttributeSet attributeSet) {
        return new C1954b(getContext(), attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1954b;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C1954b) {
            return new C1954b((C1954b) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C1954b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C1954b(layoutParams);
    }

    /* renamed from: com.navatics.app.widget.PreviewRoot$b */
    /* loaded from: classes.dex */
    public static class C1954b extends FrameLayout.LayoutParams {

        /* renamed from: a */
        int f5476a;

        public C1954b(@Nullable Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5476a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ContentContainer_Layout);
            this.f5476a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public C1954b(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5476a = 0;
        }

        public C1954b(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f5476a = 0;
        }

        public C1954b(@NonNull C1954b c1954b) {
            super((FrameLayout.LayoutParams) c1954b);
            this.f5476a = 0;
            this.f5476a = c1954b.f5476a;
        }
    }

    public void setGestureListener(InterfaceC1953a interfaceC1953a) {
        this.f5471c = interfaceC1953a;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterfaceC1953a interfaceC1953a;
        int pointerCount = motionEvent.getPointerCount();
        switch (motionEvent.getAction() & 255) {
            case 5:
                if (2 == pointerCount) {
                    for (int i = 0; i < pointerCount; i++) {
                        new Point((int) motionEvent.getX(i), (int) motionEvent.getY(i));
                    }
                    double abs = Math.abs(((int) motionEvent.getX(0)) - ((int) motionEvent.getX(1)));
                    double abs2 = Math.abs(((int) motionEvent.getY(0)) - ((int) motionEvent.getY(1)));
                    this.f5475g = Math.sqrt((abs * abs) + (abs2 * abs2));
                    break;
                }
                break;
            case 6:
                if (2 == pointerCount) {
                    for (int i2 = 0; i2 < pointerCount; i2++) {
                        new Point((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                    }
                    double abs3 = Math.abs(((int) motionEvent.getX(0)) - ((int) motionEvent.getX(1)));
                    double abs4 = Math.abs(((int) motionEvent.getY(0)) - ((int) motionEvent.getY(1)));
                    double sqrt = Math.sqrt((abs3 * abs3) + (abs4 * abs4));
                    double d = this.f5475g;
                    if (sqrt - d > 150.0d) {
                        InterfaceC1953a interfaceC1953a2 = this.f5471c;
                        if (interfaceC1953a2 != null) {
                            interfaceC1953a2.mo7109a();
                            break;
                        }
                    } else if (d - sqrt > 150.0d && (interfaceC1953a = this.f5471c) != null) {
                        interfaceC1953a.mo7108b();
                        break;
                    }
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
