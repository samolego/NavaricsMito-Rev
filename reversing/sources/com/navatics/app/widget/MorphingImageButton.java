package com.navatics.app.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.p034dd.morphingbutton.MorphingButton;

/* loaded from: classes.dex */
public class MorphingImageButton extends MorphingButton {

    /* renamed from: b */
    private Bitmap f5286b;

    public MorphingImageButton(Context context) {
        super(context);
    }

    public MorphingImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBitmapResource(int i) {
        this.f5286b = BitmapFactory.decodeResource(getResources(), i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.f5286b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f5286b, (getWidth() / 2) - (this.f5286b.getWidth() / 2), (getHeight() / 2) - (this.f5286b.getHeight() / 2), (Paint) null);
    }
}
