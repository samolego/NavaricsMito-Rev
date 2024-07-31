package com.navatics.app.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class LayoutHelper extends View {

    /* renamed from: a */
    private static final C3044k f5279a = C3044k.m1564a(LayoutHelper.class);

    /* renamed from: b */
    private int f5280b;

    /* renamed from: c */
    private int f5281c;

    /* renamed from: d */
    private int f5282d;

    /* renamed from: e */
    private int f5283e;

    /* renamed from: f */
    private int f5284f;

    /* renamed from: a */
    private void m7251a() {
    }

    public LayoutHelper(@NonNull Context context) {
        super(context);
        this.f5284f = 0;
    }

    public LayoutHelper(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5284f = 0;
        m7251a();
    }

    public LayoutHelper(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5284f = 0;
        m7251a();
    }

    /* renamed from: a */
    public void m7250a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f5280b = i;
        this.f5281c = i2;
    }

    /* renamed from: b */
    public void m7249b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f5282d = i;
        this.f5283e = i2;
    }

    public void setAspectRatio(int i) {
        this.f5284f = i;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        float f;
        int i3;
        int defaultSize = View.getDefaultSize(this.f5280b, i);
        int defaultSize2 = View.getDefaultSize(this.f5281c, i2);
        if (defaultSize < defaultSize2) {
            f5279a.mo1504b((Object) "wtf ??? width < height detected.");
        }
        if (this.f5284f != 3) {
            if (this.f5280b > 0 && this.f5281c > 0) {
                i = View.MeasureSpec.getSize(i);
                i2 = View.MeasureSpec.getSize(i2);
                float f2 = i;
                float f3 = i2;
                float f4 = f2 / f3;
                switch (this.f5284f) {
                    case 4:
                        f = 1.7777778f;
                        break;
                    case 5:
                        f = 1.3333334f;
                        break;
                    default:
                        f = this.f5280b / this.f5281c;
                        int i4 = this.f5282d;
                        if (i4 > 0 && (i3 = this.f5283e) > 0) {
                            f = (f * i4) / i3;
                            break;
                        }
                        break;
                }
                boolean z = f > f4;
                switch (this.f5284f) {
                    case 0:
                    case 4:
                    case 5:
                        if (!z) {
                            i = (int) (f3 * f);
                            break;
                        } else {
                            i2 = (int) (f2 / f);
                            break;
                        }
                    case 1:
                        if (!z) {
                            i2 = (int) (f2 / f);
                            break;
                        } else {
                            i = (int) (f3 * f);
                            break;
                        }
                    case 2:
                    case 3:
                    default:
                        if (z) {
                            i = Math.min(this.f5280b, i);
                            i2 = (int) (i / f);
                            break;
                        } else {
                            i2 = Math.min(this.f5281c, i2);
                            i = (int) (i2 * f);
                            break;
                        }
                }
            } else {
                i = defaultSize;
                i2 = defaultSize2;
            }
        }
        Log.v("layout_debug", "LayoutHelper ： width=" + i + ", height=" + i2);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
    }
}
