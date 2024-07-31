package com.senseplay.mframe.app;

import android.support.p008v4.view.ViewPager;
import android.view.View;
import com.senseplay.mframe.listener.PageChangeListener;

/* loaded from: classes2.dex */
public abstract class PageFragmentActivity extends MFragmentActivity {
    private int[] bgIds;
    private int curIndex;
    protected ViewPager viewPager;
    private View[] views;

    protected void initTab(int[] iArr) {
        initRes(iArr);
    }

    private void initRes(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        this.views = new View[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.views[i] = findViewById(iArr[i]);
            this.views[i].setOnClickListener(new ClickListener(i));
        }
    }

    /* loaded from: classes2.dex */
    protected class PageChange implements ViewPager.OnPageChangeListener {
        private PageChangeListener listener;

        @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        public PageChange(PageChangeListener pageChangeListener) {
            this.listener = pageChangeListener;
        }

        @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PageFragmentActivity.this.curIndex = i;
            PageChangeListener pageChangeListener = this.listener;
            if (pageChangeListener != null) {
                pageChangeListener.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ClickListener implements View.OnClickListener {
        private int index;

        public ClickListener(int i) {
            this.index = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PageFragmentActivity.this.viewPager != null) {
                PageFragmentActivity.this.viewPager.setCurrentItem(this.index);
            }
        }
    }

    public void toBack(View view) {
        finish();
    }
}
