package com.stx.xhb.commontitlebar.widget;

import android.content.Context;
import android.support.p011v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

/* loaded from: classes2.dex */
public class UIAlphaImageButton extends AppCompatImageButton {

    /* renamed from: a */
    private UIAlphaViewHelper f7100a;

    public UIAlphaImageButton(Context context) {
        super(context);
    }

    public UIAlphaImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UIAlphaImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private UIAlphaViewHelper getAlphaViewHelper() {
        if (this.f7100a == null) {
            this.f7100a = new UIAlphaViewHelper(this);
        }
        return this.f7100a;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        getAlphaViewHelper().m5580a(this, z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        getAlphaViewHelper().m5578b(this, z);
    }

    public void setChangeAlphaWhenPress(boolean z) {
        getAlphaViewHelper().m5579a(z);
    }

    public void setChangeAlphaWhenDisable(boolean z) {
        getAlphaViewHelper().m5577b(z);
    }
}
