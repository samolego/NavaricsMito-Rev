package com.navatics.app;

import android.content.Context;
import android.support.p008v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class MyViewPager extends ViewPager {

    /* renamed from: a */
    private boolean f3457a;

    public MyViewPager(Context context) {
        super(context);
        this.f3457a = true;
    }

    public MyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3457a = true;
    }

    @Override // android.support.p008v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f3457a && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.p008v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f3457a && super.onTouchEvent(motionEvent);
    }

    public void setEnableSwipe(boolean z) {
        this.f3457a = z;
    }
}
