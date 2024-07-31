package com.navatics.app.widget;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.navatics.app.ICameraSettingManager;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class ContentLayout extends RelativeLayout {

    /* renamed from: a */
    private static final C3044k f5184a = C3044k.m1564a(ContentLayout.class);

    /* renamed from: b */
    private int f5185b;

    /* renamed from: c */
    private int f5186c;

    /* renamed from: d */
    private int f5187d;

    /* renamed from: e */
    private int f5188e;

    /* renamed from: f */
    private Point f5189f;

    /* renamed from: g */
    private View f5190g;

    /* renamed from: h */
    private ICameraSettingManager f5191h;

    public ContentLayout(Context context) {
        super(context);
        this.f5189f = new Point();
    }

    public ContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5189f = new Point();
    }

    public ContentLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5189f = new Point();
    }

    public void setRenderView(View view) {
        this.f5190g = view;
    }

    public void setCameraSettingManager(ICameraSettingManager iCameraSettingManager) {
        this.f5191h = iCameraSettingManager;
    }

    public int getMeasuredCtrlWidth() {
        return this.f5185b;
    }

    public int getMeasuredCtrlHeight() {
        return this.f5186c;
    }

    public int getMeasuredInfoWidth() {
        return this.f5187d;
    }

    public int getMeasuredInfoHeight() {
        return this.f5188e;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        m7334a(i, i2);
        m7333b(i, i2);
        Log.v("layout_debug", "ContentLayout : ctrlViewWidth " + this.f5185b + ", ctrlViewHeight " + this.f5186c);
        Log.v("layout_debug", "ContentLayout : infoViewWidth " + this.f5187d + ", infoViewHeight " + this.f5188e);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f5185b + this.f5187d, Integer.MIN_VALUE), i2);
    }

    /* renamed from: a */
    private void m7334a(int i, int i2) {
        int measuredHeight = this.f5190g.getMeasuredHeight();
        Log.d("layout_debug", "renderViewHeight = " + this.f5190g.getMeasuredHeight());
        float f = (float) measuredHeight;
        int i3 = (int) (((16.0f * f) / 9.0f) + 0.5f);
        int measuredWidth = this.f5191h.mo8806a() == 1 ? (int) (((f * 4.0f) / 3.0f) + 0.5f) : this.f5190g.getMeasuredWidth();
        int i4 = getResources().getDisplayMetrics().heightPixels;
        this.f5185b = i3 - measuredWidth;
        this.f5186c = View.getDefaultSize(i4, i2);
        Log.d("layout_debug", "ContentLayout : width16by9 = " + i3 + ", renderViewWidthIn4by3=" + measuredWidth);
    }

    /* renamed from: b */
    private void m7333b(int i, int i2) {
        int measuredWidth = this.f5190g.getMeasuredWidth();
        int i3 = this.f5185b;
        if (this.f5191h.mo8806a() == 1) {
            int i4 = measuredWidth - i3;
            int defaultSize = View.getDefaultSize(i4, i);
            if (defaultSize < i4) {
                C3044k c3044k = f5184a;
                c3044k.mo1499d("shouldBe " + i4 + ", but defaultSize " + defaultSize);
            } else if (defaultSize > i4) {
                defaultSize = i4;
            }
            this.f5187d = defaultSize;
        } else {
            ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRealSize(this.f5189f);
            int i5 = this.f5189f.x;
            int i6 = measuredWidth + i3;
            if (i6 > i5) {
                measuredWidth = i5 - i3;
                C3044k c3044k2 = f5184a;
                c3044k2.mo1499d("shouldBe " + measuredWidth + ", we need " + i6 + ", but we only have " + i5 + ", modify to " + measuredWidth);
            }
            this.f5187d = measuredWidth;
        }
        this.f5188e = View.getDefaultSize(getResources().getDisplayMetrics().heightPixels, i2);
    }
}
