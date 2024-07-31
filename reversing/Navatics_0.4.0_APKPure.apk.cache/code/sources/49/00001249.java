package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class zzru extends ImageView {

    /* renamed from: AT */
    private Uri f3354AT;

    /* renamed from: AU */
    private int f3355AU;

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public int zzatp() {
        return this.f3355AU;
    }

    public void zzgj(int i) {
        this.f3355AU = i;
    }

    public void zzq(Uri uri) {
        this.f3354AT = uri;
    }
}