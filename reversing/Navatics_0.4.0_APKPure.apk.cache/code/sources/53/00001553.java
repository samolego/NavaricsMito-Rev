package com.navatics.app;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class MyViewPager extends ViewPager {

    /* renamed from: a */
    private boolean f3466a;

    public MyViewPager(Context context) {
        super(context);
        this.f3466a = true;
    }

    public MyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3466a = true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f3466a && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f3466a && super.onTouchEvent(motionEvent);
    }

    public void setEnableSwipe(boolean z) {
        this.f3466a = z;
    }
}