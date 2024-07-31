package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.theartofdev.edmodo.cropper.d */
/* loaded from: classes2.dex */
public final class CropImageAnimation extends Animation implements Animation.AnimationListener {

    /* renamed from: a */
    private final ImageView f8379a;

    /* renamed from: b */
    private final CropOverlayView f8380b;

    /* renamed from: c */
    private final float[] f8381c = new float[8];

    /* renamed from: d */
    private final float[] f8382d = new float[8];

    /* renamed from: e */
    private final RectF f8383e = new RectF();

    /* renamed from: f */
    private final RectF f8384f = new RectF();

    /* renamed from: g */
    private final float[] f8385g = new float[9];

    /* renamed from: h */
    private final float[] f8386h = new float[9];

    /* renamed from: i */
    private final RectF f8387i = new RectF();

    /* renamed from: j */
    private final float[] f8388j = new float[8];

    /* renamed from: k */
    private final float[] f8389k = new float[9];

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    public CropImageAnimation(ImageView imageView, CropOverlayView cropOverlayView) {
        this.f8379a = imageView;
        this.f8380b = cropOverlayView;
        setDuration(300L);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    /* renamed from: a */
    public void m4608a(float[] fArr, Matrix matrix) {
        reset();
        System.arraycopy(fArr, 0, this.f8381c, 0, 8);
        this.f8383e.set(this.f8380b.getCropWindowRect());
        matrix.getValues(this.f8385g);
    }

    /* renamed from: b */
    public void m4607b(float[] fArr, Matrix matrix) {
        System.arraycopy(fArr, 0, this.f8382d, 0, 8);
        this.f8384f.set(this.f8380b.getCropWindowRect());
        matrix.getValues(this.f8386h);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float[] fArr;
        this.f8387i.left = this.f8383e.left + ((this.f8384f.left - this.f8383e.left) * f);
        this.f8387i.top = this.f8383e.top + ((this.f8384f.top - this.f8383e.top) * f);
        this.f8387i.right = this.f8383e.right + ((this.f8384f.right - this.f8383e.right) * f);
        this.f8387i.bottom = this.f8383e.bottom + ((this.f8384f.bottom - this.f8383e.bottom) * f);
        this.f8380b.setCropWindowRect(this.f8387i);
        int i = 0;
        int i2 = 0;
        while (true) {
            fArr = this.f8388j;
            if (i2 >= fArr.length) {
                break;
            }
            float[] fArr2 = this.f8381c;
            fArr[i2] = fArr2[i2] + ((this.f8382d[i2] - fArr2[i2]) * f);
            i2++;
        }
        this.f8380b.m4673a(fArr, this.f8379a.getWidth(), this.f8379a.getHeight());
        while (true) {
            float[] fArr3 = this.f8389k;
            if (i < fArr3.length) {
                float[] fArr4 = this.f8385g;
                fArr3[i] = fArr4[i] + ((this.f8386h[i] - fArr4[i]) * f);
                i++;
            } else {
                Matrix imageMatrix = this.f8379a.getImageMatrix();
                imageMatrix.setValues(this.f8389k);
                this.f8379a.setImageMatrix(imageMatrix);
                this.f8379a.invalidate();
                this.f8380b.invalidate();
                return;
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f8379a.clearAnimation();
    }
}
