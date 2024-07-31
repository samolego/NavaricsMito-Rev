package com.mframe.app;

import android.support.p008v4.view.ViewPager;
import android.view.View;
import com.mframe.p047a.PageChangeListener;

/* loaded from: classes.dex */
public abstract class PageFragmentActivity extends MFragmentActivity {

    /* renamed from: b */
    private int f3454b;

    /* loaded from: classes.dex */
    protected class PageChange implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        final /* synthetic */ PageFragmentActivity f3455a;

        /* renamed from: b */
        private PageChangeListener f3456b;

        @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            this.f3455a.f3454b = i;
            PageChangeListener pageChangeListener = this.f3456b;
            if (pageChangeListener != null) {
                pageChangeListener.m9581a(i);
            }
        }
    }

    public void toBack(View view) {
        finish();
    }
}
