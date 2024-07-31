package org.opencv.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import java.text.DecimalFormat;
import org.opencv.core.Core;

/* compiled from: FpsMeter.java */
/* renamed from: org.opencv.android.d, reason: use source file name */
/* loaded from: classes2.dex */
public class FpsMeter {

    /* renamed from: e */
    private static final DecimalFormat f12525e = new DecimalFormat("0.00");

    /* renamed from: a */
    Paint f12526a;

    /* renamed from: b */
    boolean f12527b = false;

    /* renamed from: c */
    int f12528c = 0;

    /* renamed from: d */
    int f12529d = 0;

    /* renamed from: f */
    private int f12530f;

    /* renamed from: g */
    private double f12531g;

    /* renamed from: h */
    private long f12532h;

    /* renamed from: i */
    private String f12533i;

    /* renamed from: a */
    public void m12504a() {
        this.f12530f = 0;
        this.f12531g = Core.m12511b();
        this.f12532h = Core.m12513c();
        this.f12533i = "";
        this.f12526a = new Paint();
        this.f12526a.setColor(-16776961);
        this.f12526a.setTextSize(20.0f);
    }

    /* renamed from: b */
    public void m12507b() {
        if (!this.f12527b) {
            m12504a();
            this.f12527b = true;
            return;
        }
        this.f12530f++;
        if (this.f12530f % 20 == 0) {
            long m12513c = Core.m12513c();
            double d = (this.f12531g * 20.0d) / (m12513c - this.f12532h);
            this.f12532h = m12513c;
            if (this.f12528c != 0 && this.f12529d != 0) {
                this.f12533i = f12525e.format(d) + " FPS@" + Integer.valueOf(this.f12528c) + "x" + Integer.valueOf(this.f12529d);
            } else {
                this.f12533i = f12525e.format(d) + " FPS";
            }
            Log.i("FpsMeter", this.f12533i);
        }
    }

    /* renamed from: a */
    public void m12505a(int i, int i2) {
        this.f12528c = i;
        this.f12529d = i2;
    }

    /* renamed from: a */
    public void m12506a(Canvas canvas, float f, float f2) {
        Log.d("FpsMeter", this.f12533i);
        canvas.drawText(this.f12533i, f, f2, this.f12526a);
    }
}