package cn.bingoogolapple.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BGAFlowLayout extends ViewGroup {

    /* renamed from: a */
    private List<C0568a> f142a;

    /* renamed from: b */
    private int f143b;

    /* renamed from: c */
    private int f144c;

    /* renamed from: d */
    private boolean f145d;

    public BGAFlowLayout(Context context) {
        this(context, null);
    }

    public BGAFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BGAFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f142a = new ArrayList();
        this.f145d = true;
        m12796a(context);
        m12794a(context, attributeSet);
    }

    /* renamed from: a */
    private void m12796a(Context context) {
        this.f143b = m12795a(context, 10.0f);
        this.f144c = m12795a(context, 10.0f);
    }

    /* renamed from: a */
    private void m12794a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BGAFlowLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            m12797a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m12797a(int i, TypedArray typedArray) {
        if (i == R.styleable.BGAFlowLayout_fl_horizontalChildGap) {
            this.f143b = typedArray.getDimensionPixelOffset(i, this.f143b);
        } else if (i == R.styleable.BGAFlowLayout_fl_verticalChildGap) {
            this.f144c = typedArray.getDimensionPixelOffset(i, this.f144c);
        } else if (i == R.styleable.BGAFlowLayout_fl_isDistributionWhiteSpacing) {
            this.f145d = typedArray.getBoolean(i, this.f145d);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        this.f142a.clear();
        C0568a c0568a = new C0568a(size);
        int childCount = getChildCount();
        C0568a c0568a2 = c0568a;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            measureChild(childAt, i, i2);
            if (!c0568a2.m12791a(childAt)) {
                this.f142a.add(c0568a2);
                c0568a2 = new C0568a(size);
                c0568a2.m12791a(childAt);
            }
        }
        if (!this.f142a.contains(c0568a2)) {
            this.f142a.add(c0568a2);
        }
        int size3 = this.f142a.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size3; i5++) {
            i4 += this.f142a.get(i5).f150e;
            if (i5 != size3 - 1) {
                i4 += this.f144c;
            }
        }
        if (mode != 1073741824) {
            size2 = i4 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int size = this.f142a.size();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < size; i5++) {
            C0568a c0568a = this.f142a.get(i5);
            if (this.f145d && i5 != size - 1) {
                c0568a.m12789a(true, paddingTop);
            } else {
                c0568a.m12789a(false, paddingTop);
            }
            paddingTop += c0568a.f150e + this.f144c;
        }
    }

    /* renamed from: cn.bingoogolapple.flowlayout.BGAFlowLayout$a */
    /* loaded from: classes.dex */
    private class C0568a {

        /* renamed from: b */
        private List<View> f147b = new ArrayList();

        /* renamed from: c */
        private int f148c;

        /* renamed from: d */
        private int f149d;

        /* renamed from: e */
        private int f150e;

        /* renamed from: f */
        private int f151f;

        public C0568a(int i) {
            this.f151f = (i - BGAFlowLayout.this.getPaddingLeft()) - BGAFlowLayout.this.getPaddingRight();
        }

        /* renamed from: a */
        public boolean m12791a(View view) {
            if (m12792a(view.getMeasuredWidth())) {
                return false;
            }
            this.f147b.add(view);
            this.f148c = this.f149d;
            int measuredHeight = view.getMeasuredHeight();
            int i = this.f150e;
            if (i >= measuredHeight) {
                measuredHeight = i;
            }
            this.f150e = measuredHeight;
            return true;
        }

        /* renamed from: a */
        private boolean m12792a(int i) {
            if (this.f147b.size() != 0) {
                this.f149d = this.f148c + BGAFlowLayout.this.f143b + i;
            } else {
                this.f149d = this.f148c + i;
            }
            return this.f149d > this.f151f;
        }

        /* renamed from: a */
        public void m12789a(boolean z, int i) {
            if (this.f147b.size() == 0) {
                return;
            }
            int paddingLeft = BGAFlowLayout.this.getPaddingLeft();
            int size = this.f147b.size();
            int i2 = (this.f151f - this.f148c) / size;
            for (int i3 = 0; i3 < size; i3++) {
                View view = this.f147b.get(i3);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                if (z) {
                    measuredWidth += i2;
                    view.getLayoutParams().width = measuredWidth;
                    if (i2 > 0) {
                        view.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                    }
                }
                int i4 = ((int) (((this.f150e - measuredHeight) / 2.0d) + 0.5d)) + i;
                view.layout(paddingLeft, i4, paddingLeft + measuredWidth, measuredHeight + i4);
                paddingLeft += measuredWidth + BGAFlowLayout.this.f143b;
            }
        }
    }

    /* renamed from: a */
    public static int m12795a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
