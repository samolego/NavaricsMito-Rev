package com.yanzhenjie.sofia;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/* loaded from: classes2.dex */
public class NavigationView extends View {

    /* renamed from: a */
    private Display f9329a;

    /* renamed from: b */
    private DisplayMetrics f9330b;

    /* renamed from: c */
    private Configuration f9331c;

    /* renamed from: d */
    private int f9332d;

    /* renamed from: e */
    private int f9333e;

    public NavigationView(Context context) {
        this(context, null, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9329a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.f9330b = new DisplayMetrics();
        Resources resources = getResources();
        this.f9331c = resources.getConfiguration();
        this.f9332d = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (m9110a()) {
                this.f9329a.getRealMetrics(this.f9330b);
                this.f9333e = this.f9330b.widthPixels - m9108a(this.f9329a);
                setMeasuredDimension(this.f9333e, View.MeasureSpec.getSize(i2));
                return;
            } else {
                this.f9329a.getRealMetrics(this.f9330b);
                this.f9333e = this.f9330b.heightPixels - m9109b(this.f9329a);
                setMeasuredDimension(View.MeasureSpec.getSize(i), this.f9333e);
                return;
            }
        }
        setMeasuredDimension(0, 0);
    }

    /* renamed from: a */
    private static int m9108a(Display display) {
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    /* renamed from: b */
    private static int m9109b(Display display) {
        Point point = new Point();
        display.getSize(point);
        return point.y;
    }

    public int getDefaultBarSize() {
        return this.f9332d;
    }

    public int getBarSize() {
        return this.f9333e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m9110a() {
        return this.f9331c.orientation == 2;
    }
}