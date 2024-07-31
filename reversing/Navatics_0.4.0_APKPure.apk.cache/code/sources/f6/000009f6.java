package cn.pedant.SweetAlert;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: Rotate3dAnimation.java */
/* renamed from: cn.pedant.SweetAlert.c, reason: use source file name */
/* loaded from: classes.dex */
public class Rotate3dAnimation extends Animation {

    /* renamed from: a */
    private int f293a;

    /* renamed from: b */
    private int f294b;

    /* renamed from: c */
    private float f295c;

    /* renamed from: d */
    private float f296d;

    /* renamed from: e */
    private float f297e;

    /* renamed from: f */
    private float f298f;

    /* renamed from: g */
    private float f299g;

    /* renamed from: h */
    private float f300h;

    /* renamed from: i */
    private Camera f301i;

    /* renamed from: j */
    private int f302j;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Rotate3dAnimation.java */
    /* renamed from: cn.pedant.SweetAlert.c$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public int f303a;

        /* renamed from: b */
        public float f304b;

        protected a() {
        }
    }

    /* renamed from: a */
    a m290a(TypedValue typedValue) {
        a aVar = new a();
        if (typedValue == null) {
            aVar.f303a = 0;
            aVar.f304b = 0.0f;
        } else {
            if (typedValue.type == 6) {
                aVar.f303a = (typedValue.data & 15) == 1 ? 2 : 1;
                aVar.f304b = TypedValue.complexToFloat(typedValue.data);
                return aVar;
            }
            if (typedValue.type == 4) {
                aVar.f303a = 0;
                aVar.f304b = typedValue.getFloat();
                return aVar;
            }
            if (typedValue.type >= 16 && typedValue.type <= 31) {
                aVar.f303a = 0;
                aVar.f304b = typedValue.data;
                return aVar;
            }
        }
        aVar.f303a = 0;
        aVar.f304b = 0.0f;
        return aVar;
    }

    public Rotate3dAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f293a = 0;
        this.f294b = 0;
        this.f295c = 0.0f;
        this.f296d = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Rotate3dAnimation);
        this.f297e = obtainStyledAttributes.getFloat(R.styleable.Rotate3dAnimation_fromDeg, 0.0f);
        this.f298f = obtainStyledAttributes.getFloat(R.styleable.Rotate3dAnimation_toDeg, 0.0f);
        this.f302j = obtainStyledAttributes.getInt(R.styleable.Rotate3dAnimation_rollType, 0);
        a m290a = m290a(obtainStyledAttributes.peekValue(R.styleable.Rotate3dAnimation_pivotX));
        this.f293a = m290a.f303a;
        this.f295c = m290a.f304b;
        a m290a2 = m290a(obtainStyledAttributes.peekValue(R.styleable.Rotate3dAnimation_pivotY));
        this.f294b = m290a2.f303a;
        this.f296d = m290a2.f304b;
        obtainStyledAttributes.recycle();
        m289a();
    }

    /* renamed from: a */
    private void m289a() {
        if (this.f293a == 0) {
            this.f299g = this.f295c;
        }
        if (this.f294b == 0) {
            this.f300h = this.f296d;
        }
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f301i = new Camera();
        this.f299g = resolveSize(this.f293a, this.f295c, i, i3);
        this.f300h = resolveSize(this.f294b, this.f296d, i2, i4);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f297e;
        float f3 = f2 + ((this.f298f - f2) * f);
        Matrix matrix = transformation.getMatrix();
        this.f301i.save();
        switch (this.f302j) {
            case 0:
                this.f301i.rotateX(f3);
                break;
            case 1:
                this.f301i.rotateY(f3);
                break;
            case 2:
                this.f301i.rotateZ(f3);
                break;
        }
        this.f301i.getMatrix(matrix);
        this.f301i.restore();
        matrix.preTranslate(-this.f299g, -this.f300h);
        matrix.postTranslate(this.f299g, this.f300h);
    }
}