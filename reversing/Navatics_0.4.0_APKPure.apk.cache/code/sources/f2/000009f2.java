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
    private float f270a;

    /* renamed from: b */
    private Paint f271b;

    /* renamed from: c */
    private final float f272c;

    /* renamed from: d */
    private final float f273d;

    /* renamed from: e */
    private final float f274e;

    /* renamed from: f */
    private final float f275f;

    /* renamed from: g */
    private final float f276g;

    /* renamed from: h */
    private final float f277h;

    /* renamed from: i */
    private float f278i;

    /* renamed from: j */
    private float f279j;

    /* renamed from: k */
    private float f280k;

    /* renamed from: l */
    private boolean f281l;

    public SuccessTickView(Context context) {
        super(context);
        this.f270a = -1.0f;
        this.f272c = m281a(1.2f);
        this.f273d = m281a(3.0f);
        this.f274e = m281a(15.0f);
        this.f275f = m281a(25.0f);
        this.f276g = m281a(3.3f);
        this.f277h = this.f275f + m281a(6.7f);
        m276b();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f270a = -1.0f;
        this.f272c = m281a(1.2f);
        this.f273d = m281a(3.0f);
        this.f274e = m281a(15.0f);
        this.f275f = m281a(25.0f);
        this.f276g = m281a(3.3f);
        this.f277h = this.f275f + m281a(6.7f);
        m276b();
    }

    /* renamed from: b */
    private void m276b() {
        this.f271b = new Paint();
        this.f271b.setColor(getResources().getColor(R.color.success_stroke_color));
        this.f279j = this.f274e;
        this.f280k = this.f275f;
        this.f281l = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (height / 1.4d);
        float f = (int) (width / 1.2d);
        this.f278i = (((this.f274e + f) / 2.0f) + this.f273d) - 1.0f;
        RectF rectF = new RectF();
        if (this.f281l) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.f279j;
            rectF.top = (i + this.f275f) / 2.0f;
            rectF.bottom = rectF.top + this.f273d;
        } else {
            rectF.right = (((this.f274e + f) / 2.0f) + this.f273d) - 1.0f;
            rectF.left = rectF.right - this.f279j;
            rectF.top = (i + this.f275f) / 2.0f;
            rectF.bottom = rectF.top + this.f273d;
        }
        float f2 = this.f272c;
        canvas.drawRoundRect(rectF, f2, f2, this.f271b);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i + this.f275f) / 2.0f) + this.f273d) - 1.0f;
        rectF2.left = (f + this.f274e) / 2.0f;
        rectF2.right = rectF2.left + this.f273d;
        rectF2.top = rectF2.bottom - this.f280k;
        float f3 = this.f272c;
        canvas.drawRoundRect(rectF2, f3, f3, this.f271b);
    }

    /* renamed from: a */
    public float m281a(float f) {
        if (this.f270a == -1.0f) {
            this.f270a = getResources().getDisplayMetrics().density;
        }
        return (f * this.f270a) + 0.5f;
    }

    /* renamed from: a */
    public void m282a() {
        this.f279j = 0.0f;
        this.f280k = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: cn.pedant.SweetAlert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                double d = f;
                if (0.54d < d && 0.7d >= d) {
                    SuccessTickView.this.f281l = true;
                    SuccessTickView successTickView = SuccessTickView.this;
                    successTickView.f279j = successTickView.f278i * ((f - 0.54f) / 0.16f);
                    if (0.65d < d) {
                        SuccessTickView successTickView2 = SuccessTickView.this;
                        successTickView2.f280k = successTickView2.f277h * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                    return;
                }
                if (0.7d < d && 0.84d >= d) {
                    SuccessTickView.this.f281l = false;
                    SuccessTickView successTickView3 = SuccessTickView.this;
                    successTickView3.f279j = successTickView3.f278i * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView successTickView4 = SuccessTickView.this;
                    successTickView4.f279j = successTickView4.f279j < SuccessTickView.this.f276g ? SuccessTickView.this.f276g : SuccessTickView.this.f279j;
                    SuccessTickView successTickView5 = SuccessTickView.this;
                    successTickView5.f280k = successTickView5.f277h * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                    return;
                }
                if (0.84d >= d || 1.0f < f) {
                    return;
                }
                SuccessTickView.this.f281l = false;
                SuccessTickView successTickView6 = SuccessTickView.this;
                float f2 = (f - 0.84f) / 0.16f;
                successTickView6.f279j = successTickView6.f276g + ((SuccessTickView.this.f274e - SuccessTickView.this.f276g) * f2);
                SuccessTickView successTickView7 = SuccessTickView.this;
                successTickView7.f280k = successTickView7.f275f + ((SuccessTickView.this.f277h - SuccessTickView.this.f275f) * (1.0f - f2));
                SuccessTickView.this.invalidate();
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}