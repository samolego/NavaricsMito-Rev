package org.opencv.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import java.text.DecimalFormat;
import org.opencv.core.Core;

/* renamed from: org.opencv.android.d */
/* loaded from: classes2.dex */
public class FpsMeter {

    /* renamed from: e */
    private static final DecimalFormat f12484e = new DecimalFormat("0.00");

    /* renamed from: a */
    Paint f12485a;

    /* renamed from: b */
    boolean f12486b = false;

    /* renamed from: c */
    int f12487c = 0;

    /* renamed from: d */
    int f12488d = 0;

    /* renamed from: f */
    private int f12489f;

    /* renamed from: g */
    private double f12490g;

    /* renamed from: h */
    private long f12491h;

    /* renamed from: i */
    private String f12492i;

    /* renamed from: a */
    public void m307a() {
        this.f12489f = 0;
        this.f12490g = Core.m300b();
        this.f12491h = Core.m298c();
        this.f12492i = "";
        this.f12485a = new Paint();
        this.f12485a.setColor(-16776961);
        this.f12485a.setTextSize(20.0f);
    }

    /* renamed from: b */
    public void m304b() {
        if (!this.f12486b) {
            m307a();
            this.f12486b = true;
            return;
        }
        this.f12489f++;
        if (this.f12489f % 20 == 0) {
            long m298c = Core.m298c();
            double d = (this.f12490g * 20.0d) / (m298c - this.f12491h);
            this.f12491h = m298c;
            if (this.f12487c != 0 && this.f12488d != 0) {
                this.f12492i = f12484e.format(d) + " FPS@" + Integer.valueOf(this.f12487c) + "x" + Integer.valueOf(this.f12488d);
            } else {
                this.f12492i = f12484e.format(d) + " FPS";
            }
            Log.i("FpsMeter", this.f12492i);
        }
    }

    /* renamed from: a */
    public void m306a(int i, int i2) {
        this.f12487c = i;
        this.f12488d = i2;
    }

    /* renamed from: a */
    public void m305a(Canvas canvas, float f, float f2) {
        Log.d("FpsMeter", this.f12492i);
        canvas.drawText(this.f12492i, f, f2, this.f12485a);
    }
}
