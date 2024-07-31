package com.navatics.app.widget.avloading;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;

/* renamed from: com.navatics.app.widget.avloading.a */
/* loaded from: classes.dex */
public class BallPulseIndicator extends Indicator {

    /* renamed from: b */
    private float[] f5568b = {1.0f, 1.0f, 1.0f};

    @Override // com.navatics.app.widget.avloading.Indicator
    /* renamed from: a */
    public void mo7039a(Canvas canvas, Paint paint) {
        float min = (Math.min(m7036c(), m7035d()) - 8.0f) / 6.0f;
        float f = 2.0f * min;
        float c = (m7036c() / 2) - (f + 4.0f);
        float d = m7035d() / 2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f2 = i;
            canvas.translate((f * f2) + c + (f2 * 4.0f), d);
            float[] fArr = this.f5568b;
            canvas.scale(fArr[i], fArr[i]);
            canvas.drawCircle(0.0f, 0.0f, min, paint);
            canvas.restore();
        }
    }

    @Override // com.navatics.app.widget.avloading.Indicator
    /* renamed from: a */
    public ArrayList<ValueAnimator> mo7043a() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (final int i = 0; i < 3; i++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i]);
            m7040a(ofFloat, new ValueAnimator.AnimatorUpdateListener() { // from class: com.navatics.app.widget.avloading.a.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallPulseIndicator.this.f5568b[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallPulseIndicator.this.m7037b();
                }
            });
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}
