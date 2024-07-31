package com.yanzhenjie.sofia;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* renamed from: com.yanzhenjie.sofia.b */
/* loaded from: classes2.dex */
class HostLayout extends RelativeLayout implements Bar {

    /* renamed from: a */
    private Activity f9295a;

    /* renamed from: b */
    private int f9296b;

    /* renamed from: c */
    private StatusView f9297c;

    /* renamed from: d */
    private NavigationView f9298d;

    /* renamed from: e */
    private FrameLayout f9299e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HostLayout(Activity activity) {
        super(activity);
        this.f9296b = 0;
        this.f9295a = activity;
        m3728c();
        m3727d();
        C2803d.m3724a(this.f9295a);
        C2803d.m3721b(this.f9295a);
        C2803d.m3723a(this.f9295a, 0);
        C2803d.m3720b(this.f9295a, 0);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 21) {
            int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
            int defaultBarSize = this.f9298d.getDefaultBarSize();
            if (systemWindowInsetBottom == defaultBarSize) {
                systemWindowInsetBottom = 0;
            }
            this.f9299e.setPaddingRelative(0, 0, 0, systemWindowInsetBottom);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9299e.getLayoutParams();
            if (systemWindowInsetBottom > 0 && !this.f9298d.m3734a()) {
                layoutParams.bottomMargin = -defaultBarSize;
            } else {
                layoutParams.bottomMargin = 0;
            }
            return super.onApplyWindowInsets(windowInsets.replaceSystemWindowInsets(0, 0, 0, 0));
        }
        return windowInsets;
    }

    /* renamed from: c */
    private void m3728c() {
        inflate(this.f9295a, R.layout.sofia_host_layout, this);
        this.f9297c = (StatusView) findViewById(R.id.status_view);
        this.f9298d = (NavigationView) findViewById(R.id.navigation_view);
        this.f9299e = (FrameLayout) findViewById(R.id.content);
    }

    /* renamed from: d */
    private void m3727d() {
        ViewGroup viewGroup = (ViewGroup) this.f9295a.getWindow().getDecorView().findViewById(16908290);
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            viewGroup.removeView(childAt);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            this.f9299e.addView(childAt, layoutParams.width, layoutParams.height);
        }
        viewGroup.addView(this, -1, -1);
    }

    @Override // com.yanzhenjie.sofia.Bar
    /* renamed from: a */
    public Bar mo3731a() {
        C2803d.m3722a(this.f9295a, false);
        return this;
    }

    @Override // com.yanzhenjie.sofia.Bar
    /* renamed from: a */
    public Bar mo3730a(int i) {
        this.f9297c.setBackgroundColor(i);
        return this;
    }

    @Override // com.yanzhenjie.sofia.Bar
    /* renamed from: b */
    public Bar mo3729b() {
        this.f9296b |= 1;
        m3726e();
        return this;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (this.f9298d.m3734a()) {
            ((RelativeLayout.LayoutParams) this.f9298d.getLayoutParams()).addRule(11);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9297c.getLayoutParams();
            layoutParams.addRule(10);
            layoutParams.addRule(0, R.id.navigation_view);
        } else {
            ((RelativeLayout.LayoutParams) this.f9297c.getLayoutParams()).addRule(10);
            ((RelativeLayout.LayoutParams) this.f9298d.getLayoutParams()).addRule(12);
        }
        m3726e();
    }

    /* renamed from: e */
    private void m3726e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (this.f9298d.m3734a()) {
            switch (this.f9296b) {
                case 0:
                    layoutParams.addRule(3, R.id.status_view);
                    layoutParams.addRule(0, R.id.navigation_view);
                    break;
                case 1:
                    layoutParams.addRule(0, R.id.navigation_view);
                    bringChildToFront(this.f9297c);
                    break;
                case 2:
                    layoutParams.addRule(3, R.id.status_view);
                    layoutParams.addRule(0, R.id.navigation_view);
                    bringChildToFront(this.f9298d);
                    break;
                case 3:
                    layoutParams.addRule(0, R.id.navigation_view);
                    bringChildToFront(this.f9297c);
                    bringChildToFront(this.f9298d);
                    break;
            }
        } else {
            switch (this.f9296b) {
                case 0:
                    layoutParams.addRule(3, R.id.status_view);
                    layoutParams.addRule(2, R.id.navigation_view);
                    break;
                case 1:
                    layoutParams.addRule(2, R.id.navigation_view);
                    bringChildToFront(this.f9297c);
                    break;
                case 2:
                    layoutParams.addRule(3, R.id.status_view);
                    bringChildToFront(this.f9298d);
                    break;
                case 3:
                    bringChildToFront(this.f9297c);
                    bringChildToFront(this.f9298d);
                    break;
            }
        }
        this.f9299e.setLayoutParams(layoutParams);
    }
}
