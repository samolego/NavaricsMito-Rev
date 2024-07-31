package cn.pedant.SweetAlert;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public class SuccessTickView extends View {

    /* renamed from: a */
    private float f266a;

    /* renamed from: b */
    private Paint f267b;

    /* renamed from: c */
    private final float f268c;

    /* renamed from: d */
    private final float f269d;

    /* renamed from: e */
    private final float f270e;

    /* renamed from: f */
    private final float f271f;

    /* renamed from: g */
    private final float f272g;

    /* renamed from: h */
    private final float f273h;

    /* renamed from: i */
    private float f274i;

    /* renamed from: j */
    private float f275j;

    /* renamed from: k */
    private float f276k;

    /* renamed from: l */
    private boolean f277l;

    public SuccessTickView(Context context) {
        super(context);
        this.f266a = -1.0f;
        this.f268c = m12689a(1.2f);
        this.f269d = m12689a(3.0f);
        this.f270e = m12689a(15.0f);
        this.f271f = m12689a(25.0f);
        this.f272g = m12689a(3.3f);
        this.f273h = this.f271f + m12689a(6.7f);
        m12685b();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f266a = -1.0f;
        this.f268c = m12689a(1.2f);
        this.f269d = m12689a(3.0f);
        this.f270e = m12689a(15.0f);
        this.f271f = m12689a(25.0f);
        this.f272g = m12689a(3.3f);
        this.f273h = this.f271f + m12689a(6.7f);
        m12685b();
    }

    /* renamed from: b */
    private void m12685b() {
        this.f267b = new Paint();
        this.f267b.setColor(getResources().getColor(R.color.success_stroke_color));
        this.f275j = this.f270e;
        this.f276k = this.f271f;
        this.f277l = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (height / 1.4d);
        float f = (int) (width / 1.2d);
        this.f274i = (((this.f270e + f) / 2.0f) + this.f269d) - 1.0f;
        RectF rectF = new RectF();
        if (this.f277l) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.f275j;
            rectF.top = (i + this.f271f) / 2.0f;
            rectF.bottom = rectF.top + this.f269d;
        } else {
            rectF.right = (((this.f270e + f) / 2.0f) + this.f269d) - 1.0f;
            rectF.left = rectF.right - this.f275j;
            rectF.top = (i + this.f271f) / 2.0f;
            rectF.bottom = rectF.top + this.f269d;
        }
        float f2 = this.f268c;
        canvas.drawRoundRect(rectF, f2, f2, this.f267b);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i + this.f271f) / 2.0f) + this.f269d) - 1.0f;
        rectF2.left = (f + this.f270e) / 2.0f;
        rectF2.right = rectF2.left + this.f269d;
        rectF2.top = rectF2.bottom - this.f276k;
        float f3 = this.f268c;
        canvas.drawRoundRect(rectF2, f3, f3, this.f267b);
    }

    /* renamed from: a */
    public float m12689a(float f) {
        if (this.f266a == -1.0f) {
            this.f266a = getResources().getDisplayMetrics().density;
        }
        return (f * this.f266a) + 0.5f;
    }

    /* renamed from: a */
    public void m12690a() {
        this.f275j = 0.0f;
        this.f276k = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: cn.pedant.SweetAlert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                double d = f;
                if (0.54d < d && 0.7d >= d) {
                    SuccessTickView.this.f277l = true;
                    SuccessTickView successTickView = SuccessTickView.this;
                    successTickView.f275j = successTickView.f274i * ((f - 0.54f) / 0.16f);
                    if (0.65d < d) {
                        SuccessTickView successTickView2 = SuccessTickView.this;
                        successTickView2.f276k = successTickView2.f273h * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < d && 0.84d >= d) {
                    SuccessTickView.this.f277l = false;
                    SuccessTickView successTickView3 = SuccessTickView.this;
                    successTickView3.f275j = successTickView3.f274i * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView successTickView4 = SuccessTickView.this;
                    successTickView4.f275j = successTickView4.f275j < SuccessTickView.this.f272g ? SuccessTickView.this.f272g : SuccessTickView.this.f275j;
                    SuccessTickView successTickView5 = SuccessTickView.this;
                    successTickView5.f276k = successTickView5.f273h * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d >= d || 1.0f < f) {
                } else {
                    SuccessTickView.this.f277l = false;
                    SuccessTickView successTickView6 = SuccessTickView.this;
                    float f2 = (f - 0.84f) / 0.16f;
                    successTickView6.f275j = successTickView6.f272g + ((SuccessTickView.this.f270e - SuccessTickView.this.f272g) * f2);
                    SuccessTickView successTickView7 = SuccessTickView.this;
                    successTickView7.f276k = successTickView7.f271f + ((SuccessTickView.this.f273h - SuccessTickView.this.f271f) * (1.0f - f2));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
