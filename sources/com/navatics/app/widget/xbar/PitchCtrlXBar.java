package com.navatics.app.widget.xbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.navatics.robot.utils.DpiUtils;

/* loaded from: classes.dex */
public class PitchCtrlXBar extends XBar {

    /* renamed from: f */
    private Paint f5749f;

    public PitchCtrlXBar(Context context) {
        super(context);
        this.f5749f = new Paint();
        m6912c();
    }

    public PitchCtrlXBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5749f = new Paint();
        m6912c();
    }

    public PitchCtrlXBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5749f = new Paint();
        m6912c();
    }

    /* renamed from: c */
    private void m6912c() {
        this.f5749f.setColor(-1);
    }

    @Override // com.navatics.app.widget.xbar.XBar
    /* renamed from: a */
    void mo6901a(Canvas canvas) {
        int m5887a = DpiUtils.m5887a(getContext(), 1.5f);
        int m5887a2 = DpiUtils.m5887a(getContext(), 15.0f);
        int measuredWidth = (getMeasuredWidth() / 2) - (m5887a2 / 2);
        int measuredHeight = (getMeasuredHeight() / 2) - (m5887a / 2);
        canvas.drawRect(measuredWidth, measuredHeight, m5887a2 + measuredWidth, measuredHeight + m5887a, this.f5749f);
        int m5887a3 = DpiUtils.m5887a(getContext(), 7.0f);
        int measuredHeight2 = (getMeasuredHeight() / 2) / 5;
        int measuredWidth2 = (getMeasuredWidth() / 2) - (m5887a3 / 2);
        int i = measuredHeight;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i - measuredHeight2) - m5887a;
            canvas.drawRect(measuredWidth2, i, measuredWidth2 + m5887a3, i + m5887a, this.f5749f);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            measuredHeight = measuredHeight + measuredHeight2 + m5887a;
            canvas.drawRect(measuredWidth2, measuredHeight, measuredWidth2 + m5887a3, measuredHeight + m5887a, this.f5749f);
        }
    }
}
