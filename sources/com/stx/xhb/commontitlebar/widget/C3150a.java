package com.stx.xhb.commontitlebar.widget;

import android.support.annotation.NonNull;
import android.view.View;
import com.stx.xhb.commontitlebar.R;
import com.stx.xhb.commontitlebar.p068a.UIResHelper;

/* renamed from: com.stx.xhb.commontitlebar.widget.a */
/* loaded from: classes2.dex */
public class UIAlphaViewHelper {

    /* renamed from: a */
    private View f7101a;

    /* renamed from: b */
    private boolean f7102b = true;

    /* renamed from: c */
    private boolean f7103c = true;

    /* renamed from: d */
    private float f7104d = 1.0f;

    /* renamed from: e */
    private float f7105e;

    /* renamed from: f */
    private float f7106f;

    public UIAlphaViewHelper(@NonNull View view) {
        this.f7105e = 0.5f;
        this.f7106f = 0.5f;
        this.f7101a = view;
        this.f7105e = UIResHelper.m5588a(view.getContext(), R.attr.alpha_pressed);
        this.f7106f = UIResHelper.m5588a(view.getContext(), R.attr.alpha_disabled);
    }

    /* renamed from: a */
    public void m5580a(View view, boolean z) {
        if (this.f7101a.isEnabled()) {
            this.f7101a.setAlpha((this.f7102b && z && view.isClickable()) ? this.f7105e : this.f7104d);
        } else if (this.f7103c) {
            view.setAlpha(this.f7106f);
        }
    }

    /* renamed from: b */
    public void m5578b(View view, boolean z) {
        float f;
        if (this.f7103c) {
            f = z ? this.f7104d : this.f7106f;
        } else {
            f = this.f7104d;
        }
        view.setAlpha(f);
    }

    /* renamed from: a */
    public void m5579a(boolean z) {
        this.f7102b = z;
    }

    /* renamed from: b */
    public void m5577b(boolean z) {
        this.f7103c = z;
        View view = this.f7101a;
        m5578b(view, view.isEnabled());
    }
}
