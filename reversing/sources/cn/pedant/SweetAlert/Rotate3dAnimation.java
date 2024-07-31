package cn.pedant.SweetAlert;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: cn.pedant.SweetAlert.c */
/* loaded from: classes.dex */
public class Rotate3dAnimation extends Animation {

    /* renamed from: a */
    private int f289a;

    /* renamed from: b */
    private int f290b;

    /* renamed from: c */
    private float f291c;

    /* renamed from: d */
    private float f292d;

    /* renamed from: e */
    private float f293e;

    /* renamed from: f */
    private float f294f;

    /* renamed from: g */
    private float f295g;

    /* renamed from: h */
    private float f296h;

    /* renamed from: i */
    private Camera f297i;

    /* renamed from: j */
    private int f298j;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Rotate3dAnimation.java */
    /* renamed from: cn.pedant.SweetAlert.c$a */
    /* loaded from: classes.dex */
    public static class C0586a {

        /* renamed from: a */
        public int f299a;

        /* renamed from: b */
        public float f300b;

        protected C0586a() {
        }
    }

    /* renamed from: a */
    C0586a m12671a(TypedValue typedValue) {
        C0586a c0586a = new C0586a();
        if (typedValue == null) {
            c0586a.f299a = 0;
            c0586a.f300b = 0.0f;
        } else if (typedValue.type == 6) {
            c0586a.f299a = (typedValue.data & 15) == 1 ? 2 : 1;
            c0586a.f300b = TypedValue.complexToFloat(typedValue.data);
            return c0586a;
        } else if (typedValue.type == 4) {
            c0586a.f299a = 0;
            c0586a.f300b = typedValue.getFloat();
            return c0586a;
        } else if (typedValue.type >= 16 && typedValue.type <= 31) {
            c0586a.f299a = 0;
            c0586a.f300b = typedValue.data;
            return c0586a;
        }
        c0586a.f299a = 0;
        c0586a.f300b = 0.0f;
        return c0586a;
    }

    public Rotate3dAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f289a = 0;
        this.f290b = 0;
        this.f291c = 0.0f;
        this.f292d = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Rotate3dAnimation);
        this.f293e = obtainStyledAttributes.getFloat(R.styleable.Rotate3dAnimation_fromDeg, 0.0f);
        this.f294f = obtainStyledAttributes.getFloat(R.styleable.Rotate3dAnimation_toDeg, 0.0f);
        this.f298j = obtainStyledAttributes.getInt(R.styleable.Rotate3dAnimation_rollType, 0);
        C0586a m12671a = m12671a(obtainStyledAttributes.peekValue(R.styleable.Rotate3dAnimation_pivotX));
        this.f289a = m12671a.f299a;
        this.f291c = m12671a.f300b;
        C0586a m12671a2 = m12671a(obtainStyledAttributes.peekValue(R.styleable.Rotate3dAnimation_pivotY));
        this.f290b = m12671a2.f299a;
        this.f292d = m12671a2.f300b;
        obtainStyledAttributes.recycle();
        m12672a();
    }

    /* renamed from: a */
    private void m12672a() {
        if (this.f289a == 0) {
            this.f295g = this.f291c;
        }
        if (this.f290b == 0) {
            this.f296h = this.f292d;
        }
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f297i = new Camera();
        this.f295g = resolveSize(this.f289a, this.f291c, i, i3);
        this.f296h = resolveSize(this.f290b, this.f292d, i2, i4);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f293e;
        float f3 = f2 + ((this.f294f - f2) * f);
        Matrix matrix = transformation.getMatrix();
        this.f297i.save();
        switch (this.f298j) {
            case 0:
                this.f297i.rotateX(f3);
                break;
            case 1:
                this.f297i.rotateY(f3);
                break;
            case 2:
                this.f297i.rotateZ(f3);
                break;
        }
        this.f297i.getMatrix(matrix);
        this.f297i.restore();
        matrix.preTranslate(-this.f295g, -this.f296h);
        matrix.postTranslate(this.f295g, this.f296h);
    }
}
