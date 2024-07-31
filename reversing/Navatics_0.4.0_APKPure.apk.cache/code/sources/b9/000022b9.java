package com.yanzhenjie.recyclerview;

import android.view.View;
import android.widget.OverScroller;
import com.yanzhenjie.recyclerview.AbstractC2725c;

/* compiled from: LeftHorizontal.java */
/* renamed from: com.yanzhenjie.recyclerview.d, reason: use source file name */
/* loaded from: classes2.dex */
class LeftHorizontal extends AbstractC2725c {
    public LeftHorizontal(View view) {
        super(1, view);
    }

    /* renamed from: b */
    public boolean m9042b(int i) {
        int b = (-m9040c().getWidth()) * m9038b();
        return i <= b && b != 0;
    }

    /* renamed from: c */
    public boolean m9043c(int i) {
        return i < (-m9040c().getWidth()) * m9038b();
    }

    @Override // com.yanzhenjie.recyclerview.AbstractC2725c
    /* renamed from: a */
    public void mo9034a(OverScroller overScroller, int i, int i2) {
        overScroller.startScroll(Math.abs(i), 0, m9040c().getWidth() - Math.abs(i), 0, i2);
    }

    @Override // com.yanzhenjie.recyclerview.AbstractC2725c
    /* renamed from: b */
    public void mo9039b(OverScroller overScroller, int i, int i2) {
        overScroller.startScroll(-Math.abs(i), 0, Math.abs(i), 0, i2);
    }

    @Override // com.yanzhenjie.recyclerview.AbstractC2725c
    /* renamed from: a */
    public AbstractC2725c.a mo9033a(int i, int i2) {
        this.f9276a.f9279a = i;
        this.f9276a.f9280b = i2;
        this.f9276a.f9281c = false;
        if (this.f9276a.f9279a == 0) {
            this.f9276a.f9281c = true;
        }
        if (this.f9276a.f9279a >= 0) {
            this.f9276a.f9279a = 0;
        }
        if (this.f9276a.f9279a <= (-m9040c().getWidth())) {
            this.f9276a.f9279a = -m9040c().getWidth();
        }
        return this.f9276a;
    }

    @Override // com.yanzhenjie.recyclerview.AbstractC2725c
    /* renamed from: a */
    public boolean mo9037a(int i, float f) {
        return f > ((float) m9040c().getWidth());
    }
}