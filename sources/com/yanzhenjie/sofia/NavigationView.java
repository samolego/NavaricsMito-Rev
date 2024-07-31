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
    private Display f9289a;

    /* renamed from: b */
    private DisplayMetrics f9290b;

    /* renamed from: c */
    private Configuration f9291c;

    /* renamed from: d */
    private int f9292d;

    /* renamed from: e */
    private int f9293e;

    public NavigationView(Context context) {
        this(context, null, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9289a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.f9290b = new DisplayMetrics();
        Resources resources = getResources();
        this.f9291c = resources.getConfiguration();
        this.f9292d = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (m3734a()) {
                this.f9289a.getRealMetrics(this.f9290b);
                this.f9293e = this.f9290b.widthPixels - m3733a(this.f9289a);
                setMeasuredDimension(this.f9293e, View.MeasureSpec.getSize(i2));
                return;
            }
            this.f9289a.getRealMetrics(this.f9290b);
            this.f9293e = this.f9290b.heightPixels - m3732b(this.f9289a);
            setMeasuredDimension(View.MeasureSpec.getSize(i), this.f9293e);
            return;
        }
        setMeasuredDimension(0, 0);
    }

    /* renamed from: a */
    private static int m3733a(Display display) {
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    /* renamed from: b */
    private static int m3732b(Display display) {
        Point point = new Point();
        display.getSize(point);
        return point.y;
    }

    public int getDefaultBarSize() {
        return this.f9292d;
    }

    public int getBarSize() {
        return this.f9293e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m3734a() {
        return this.f9291c.orientation == 2;
    }
}
