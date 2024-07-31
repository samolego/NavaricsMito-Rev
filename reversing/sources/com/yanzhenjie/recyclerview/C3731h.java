package com.yanzhenjie.recyclerview;

import android.view.View;
import android.widget.OverScroller;
import com.yanzhenjie.recyclerview.Horizontal;

/* renamed from: com.yanzhenjie.recyclerview.h */
/* loaded from: classes2.dex */
class RightHorizontal extends Horizontal {
    public RightHorizontal(View view) {
        super(-1, view);
    }

    /* renamed from: b */
    public boolean m3802b(int i) {
        int b = (-m3812c().getWidth()) * m3813b();
        return i >= b && b != 0;
    }

    /* renamed from: c */
    public boolean m3800c(int i) {
        return i > (-m3812c().getWidth()) * m3813b();
    }

    @Override // com.yanzhenjie.recyclerview.Horizontal
    /* renamed from: a */
    public void mo3803a(OverScroller overScroller, int i, int i2) {
        overScroller.startScroll(Math.abs(i), 0, m3812c().getWidth() - Math.abs(i), 0, i2);
    }

    @Override // com.yanzhenjie.recyclerview.Horizontal
    /* renamed from: b */
    public void mo3801b(OverScroller overScroller, int i, int i2) {
        overScroller.startScroll(-Math.abs(i), 0, Math.abs(i), 0, i2);
    }

    @Override // com.yanzhenjie.recyclerview.Horizontal
    /* renamed from: a */
    public Horizontal.C2798a mo3804a(int i, int i2) {
        this.f9236a.f9239a = i;
        this.f9236a.f9240b = i2;
        this.f9236a.f9241c = false;
        if (this.f9236a.f9239a == 0) {
            this.f9236a.f9241c = true;
        }
        if (this.f9236a.f9239a < 0) {
            this.f9236a.f9239a = 0;
        }
        if (this.f9236a.f9239a > m3812c().getWidth()) {
            this.f9236a.f9239a = m3812c().getWidth();
        }
        return this.f9236a;
    }

    @Override // com.yanzhenjie.recyclerview.Horizontal
    /* renamed from: a */
    public boolean mo3805a(int i, float f) {
        return f < ((float) (i - m3812c().getWidth()));
    }
}
