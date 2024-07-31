package com.theartofdev.edmodo.cropper;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class CropOverlayView extends View {

    /* renamed from: A */
    private final Rect f8295A;

    /* renamed from: B */
    private boolean f8296B;

    /* renamed from: C */
    private Integer f8297C;

    /* renamed from: a */
    private ScaleGestureDetector f8298a;

    /* renamed from: b */
    private boolean f8299b;

    /* renamed from: c */
    private final CropWindowHandler f8300c;

    /* renamed from: d */
    private InterfaceC2622a f8301d;

    /* renamed from: e */
    private final RectF f8302e;

    /* renamed from: f */
    private Paint f8303f;

    /* renamed from: g */
    private Paint f8304g;

    /* renamed from: h */
    private Paint f8305h;

    /* renamed from: i */
    private Paint f8306i;

    /* renamed from: j */
    private Path f8307j;

    /* renamed from: k */
    private final float[] f8308k;

    /* renamed from: l */
    private final RectF f8309l;

    /* renamed from: m */
    private int f8310m;

    /* renamed from: n */
    private int f8311n;

    /* renamed from: o */
    private float f8312o;

    /* renamed from: p */
    private float f8313p;

    /* renamed from: q */
    private float f8314q;

    /* renamed from: r */
    private float f8315r;

    /* renamed from: s */
    private float f8316s;

    /* renamed from: t */
    private CropWindowMoveHandler f8317t;

    /* renamed from: u */
    private boolean f8318u;

    /* renamed from: v */
    private int f8319v;

    /* renamed from: w */
    private int f8320w;

    /* renamed from: x */
    private float f8321x;

    /* renamed from: y */
    private CropImageView.Guidelines f8322y;

    /* renamed from: z */
    private CropImageView.CropShape f8323z;

    /* renamed from: com.theartofdev.edmodo.cropper.CropOverlayView$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2622a {
        /* renamed from: a */
        void mo4661a(boolean z);
    }

    public CropOverlayView(Context context) {
        this(context, null);
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8300c = new CropWindowHandler();
        this.f8302e = new RectF();
        this.f8307j = new Path();
        this.f8308k = new float[8];
        this.f8309l = new RectF();
        this.f8321x = this.f8319v / this.f8320w;
        this.f8295A = new Rect();
    }

    public void setCropWindowChangeListener(InterfaceC2622a interfaceC2622a) {
        this.f8301d = interfaceC2622a;
    }

    public RectF getCropWindowRect() {
        return this.f8300c.m4606a();
    }

    public void setCropWindowRect(RectF rectF) {
        this.f8300c.m4599a(rectF);
    }

    /* renamed from: a */
    public void m4682a() {
        RectF cropWindowRect = getCropWindowRect();
        m4676a(cropWindowRect);
        this.f8300c.m4599a(cropWindowRect);
    }

    /* renamed from: a */
    public void m4673a(float[] fArr, int i, int i2) {
        if (fArr == null || !Arrays.equals(this.f8308k, fArr)) {
            if (fArr == null) {
                Arrays.fill(this.f8308k, 0.0f);
            } else {
                System.arraycopy(fArr, 0, this.f8308k, 0, fArr.length);
            }
            this.f8310m = i;
            this.f8311n = i2;
            RectF m4606a = this.f8300c.m4606a();
            if (m4606a.width() == 0.0f || m4606a.height() == 0.0f) {
                m4665d();
            }
        }
    }

    /* renamed from: b */
    public void m4672b() {
        if (this.f8296B) {
            setCropWindowRect(BitmapUtils.f8369b);
            m4665d();
            invalidate();
        }
    }

    public CropImageView.CropShape getCropShape() {
        return this.f8323z;
    }

    public void setCropShape(CropImageView.CropShape cropShape) {
        if (this.f8323z != cropShape) {
            this.f8323z = cropShape;
            if (Build.VERSION.SDK_INT <= 17) {
                if (this.f8323z == CropImageView.CropShape.OVAL) {
                    this.f8297C = Integer.valueOf(getLayerType());
                    if (this.f8297C.intValue() != 1) {
                        setLayerType(1, null);
                    } else {
                        this.f8297C = null;
                    }
                } else {
                    Integer num = this.f8297C;
                    if (num != null) {
                        setLayerType(num.intValue(), null);
                        this.f8297C = null;
                    }
                }
            }
            invalidate();
        }
    }

    public CropImageView.Guidelines getGuidelines() {
        return this.f8322y;
    }

    public void setGuidelines(CropImageView.Guidelines guidelines) {
        if (this.f8322y != guidelines) {
            this.f8322y = guidelines;
            if (this.f8296B) {
                invalidate();
            }
        }
    }

    /* renamed from: c */
    public boolean m4667c() {
        return this.f8318u;
    }

    public void setFixedAspectRatio(boolean z) {
        if (this.f8318u != z) {
            this.f8318u = z;
            if (this.f8296B) {
                m4665d();
                invalidate();
            }
        }
    }

    public int getAspectRatioX() {
        return this.f8319v;
    }

    public void setAspectRatioX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.f8319v != i) {
            this.f8319v = i;
            this.f8321x = this.f8319v / this.f8320w;
            if (this.f8296B) {
                m4665d();
                invalidate();
            }
        }
    }

    public int getAspectRatioY() {
        return this.f8320w;
    }

    public void setAspectRatioY(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.f8320w != i) {
            this.f8320w = i;
            this.f8321x = this.f8319v / this.f8320w;
            if (this.f8296B) {
                m4665d();
                invalidate();
            }
        }
    }

    public void setSnapRadius(float f) {
        this.f8316s = f;
    }

    /* renamed from: a */
    public boolean m4674a(boolean z) {
        if (this.f8299b != z) {
            this.f8299b = z;
            if (this.f8299b && this.f8298a == null) {
                this.f8298a = new ScaleGestureDetector(getContext(), new C2623b());
                return true;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m4680a(float f, float f2, float f3, float f4) {
        this.f8300c.m4603a(f, f2, f3, f4);
    }

    public Rect getInitialCropWindowRect() {
        return this.f8295A;
    }

    public void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.f8295A;
        if (rect == null) {
            rect = BitmapUtils.f8368a;
        }
        rect2.set(rect);
        if (this.f8296B) {
            m4665d();
            invalidate();
            m4668b(false);
        }
    }

    public void setInitialAttributeValues(CropImageOptions cropImageOptions) {
        this.f8300c.m4598a(cropImageOptions);
        setCropShape(cropImageOptions.f8215a);
        setSnapRadius(cropImageOptions.f8216b);
        setGuidelines(cropImageOptions.f8218d);
        setFixedAspectRatio(cropImageOptions.f8226l);
        setAspectRatioX(cropImageOptions.f8227m);
        setAspectRatioY(cropImageOptions.f8228n);
        m4674a(cropImageOptions.f8223i);
        this.f8315r = cropImageOptions.f8217c;
        this.f8314q = cropImageOptions.f8225k;
        this.f8303f = m4679a(cropImageOptions.f8229o, cropImageOptions.f8230p);
        this.f8312o = cropImageOptions.f8232r;
        this.f8313p = cropImageOptions.f8233s;
        this.f8304g = m4679a(cropImageOptions.f8231q, cropImageOptions.f8234t);
        this.f8305h = m4679a(cropImageOptions.f8235u, cropImageOptions.f8236v);
        this.f8306i = m4678a(cropImageOptions.f8237w);
    }

    /* renamed from: d */
    private void m4665d() {
        float max = Math.max(BitmapUtils.m4617a(this.f8308k), 0.0f);
        float max2 = Math.max(BitmapUtils.m4615b(this.f8308k), 0.0f);
        float min = Math.min(BitmapUtils.m4614c(this.f8308k), getWidth());
        float min2 = Math.min(BitmapUtils.m4613d(this.f8308k), getHeight());
        if (min <= max || min2 <= max2) {
            return;
        }
        RectF rectF = new RectF();
        this.f8296B = true;
        float f = this.f8314q;
        float f2 = min - max;
        float f3 = f * f2;
        float f4 = min2 - max2;
        float f5 = f * f4;
        if (this.f8295A.width() > 0 && this.f8295A.height() > 0) {
            rectF.left = (this.f8295A.left / this.f8300c.m4591f()) + max;
            rectF.top = (this.f8295A.top / this.f8300c.m4590g()) + max2;
            rectF.right = rectF.left + (this.f8295A.width() / this.f8300c.m4591f());
            rectF.bottom = rectF.top + (this.f8295A.height() / this.f8300c.m4590g());
            rectF.left = Math.max(max, rectF.left);
            rectF.top = Math.max(max2, rectF.top);
            rectF.right = Math.min(min, rectF.right);
            rectF.bottom = Math.min(min2, rectF.bottom);
        } else if (this.f8318u && min > max && min2 > max2) {
            if (f2 / f4 > this.f8321x) {
                rectF.top = max2 + f5;
                rectF.bottom = min2 - f5;
                float width = getWidth() / 2.0f;
                this.f8321x = this.f8319v / this.f8320w;
                float max3 = Math.max(this.f8300c.m4597b(), rectF.height() * this.f8321x) / 2.0f;
                rectF.left = width - max3;
                rectF.right = width + max3;
            } else {
                rectF.left = max + f3;
                rectF.right = min - f3;
                float height = getHeight() / 2.0f;
                float max4 = Math.max(this.f8300c.m4595c(), rectF.width() / this.f8321x) / 2.0f;
                rectF.top = height - max4;
                rectF.bottom = height + max4;
            }
        } else {
            rectF.left = max + f3;
            rectF.top = max2 + f5;
            rectF.right = min - f3;
            rectF.bottom = min2 - f5;
        }
        m4676a(rectF);
        this.f8300c.m4599a(rectF);
    }

    /* renamed from: a */
    private void m4676a(RectF rectF) {
        if (rectF.width() < this.f8300c.m4597b()) {
            float m4597b = (this.f8300c.m4597b() - rectF.width()) / 2.0f;
            rectF.left -= m4597b;
            rectF.right += m4597b;
        }
        if (rectF.height() < this.f8300c.m4595c()) {
            float m4595c = (this.f8300c.m4595c() - rectF.height()) / 2.0f;
            rectF.top -= m4595c;
            rectF.bottom += m4595c;
        }
        if (rectF.width() > this.f8300c.m4593d()) {
            float width = (rectF.width() - this.f8300c.m4593d()) / 2.0f;
            rectF.left += width;
            rectF.right -= width;
        }
        if (rectF.height() > this.f8300c.m4592e()) {
            float height = (rectF.height() - this.f8300c.m4592e()) / 2.0f;
            rectF.top += height;
            rectF.bottom -= height;
        }
        m4669b(rectF);
        if (this.f8309l.width() > 0.0f && this.f8309l.height() > 0.0f) {
            float max = Math.max(this.f8309l.left, 0.0f);
            float max2 = Math.max(this.f8309l.top, 0.0f);
            float min = Math.min(this.f8309l.right, getWidth());
            float min2 = Math.min(this.f8309l.bottom, getHeight());
            if (rectF.left < max) {
                rectF.left = max;
            }
            if (rectF.top < max2) {
                rectF.top = max2;
            }
            if (rectF.right > min) {
                rectF.right = min;
            }
            if (rectF.bottom > min2) {
                rectF.bottom = min2;
            }
        }
        if (!this.f8318u || Math.abs(rectF.width() - (rectF.height() * this.f8321x)) <= 0.1d) {
            return;
        }
        if (rectF.width() > rectF.height() * this.f8321x) {
            float abs = Math.abs((rectF.height() * this.f8321x) - rectF.width()) / 2.0f;
            rectF.left += abs;
            rectF.right -= abs;
            return;
        }
        float abs2 = Math.abs((rectF.width() / this.f8321x) - rectF.height()) / 2.0f;
        rectF.top += abs2;
        rectF.bottom -= abs2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m4677a(canvas);
        if (this.f8300c.m4589h()) {
            if (this.f8322y == CropImageView.Guidelines.ON) {
                m4670b(canvas);
            } else if (this.f8322y == CropImageView.Guidelines.ON_TOUCH && this.f8317t != null) {
                m4670b(canvas);
            }
        }
        m4666c(canvas);
        m4664d(canvas);
    }

    /* renamed from: a */
    private void m4677a(Canvas canvas) {
        RectF m4606a = this.f8300c.m4606a();
        float max = Math.max(BitmapUtils.m4617a(this.f8308k), 0.0f);
        float max2 = Math.max(BitmapUtils.m4615b(this.f8308k), 0.0f);
        float min = Math.min(BitmapUtils.m4614c(this.f8308k), getWidth());
        float min2 = Math.min(BitmapUtils.m4613d(this.f8308k), getHeight());
        if (this.f8323z == CropImageView.CropShape.RECTANGLE) {
            if (!m4662f() || Build.VERSION.SDK_INT <= 17) {
                canvas.drawRect(max, max2, min, m4606a.top, this.f8306i);
                canvas.drawRect(max, m4606a.bottom, min, min2, this.f8306i);
                canvas.drawRect(max, m4606a.top, m4606a.left, m4606a.bottom, this.f8306i);
                canvas.drawRect(m4606a.right, m4606a.top, min, m4606a.bottom, this.f8306i);
                return;
            }
            this.f8307j.reset();
            Path path = this.f8307j;
            float[] fArr = this.f8308k;
            path.moveTo(fArr[0], fArr[1]);
            Path path2 = this.f8307j;
            float[] fArr2 = this.f8308k;
            path2.lineTo(fArr2[2], fArr2[3]);
            Path path3 = this.f8307j;
            float[] fArr3 = this.f8308k;
            path3.lineTo(fArr3[4], fArr3[5]);
            Path path4 = this.f8307j;
            float[] fArr4 = this.f8308k;
            path4.lineTo(fArr4[6], fArr4[7]);
            this.f8307j.close();
            canvas.save();
            canvas.clipPath(this.f8307j, Region.Op.INTERSECT);
            canvas.clipRect(m4606a, Region.Op.XOR);
            canvas.drawRect(max, max2, min, min2, this.f8306i);
            canvas.restore();
            return;
        }
        this.f8307j.reset();
        if (Build.VERSION.SDK_INT <= 17 && this.f8323z == CropImageView.CropShape.OVAL) {
            this.f8302e.set(m4606a.left + 2.0f, m4606a.top + 2.0f, m4606a.right - 2.0f, m4606a.bottom - 2.0f);
        } else {
            this.f8302e.set(m4606a.left, m4606a.top, m4606a.right, m4606a.bottom);
        }
        this.f8307j.addOval(this.f8302e, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(this.f8307j, Region.Op.XOR);
        canvas.drawRect(max, max2, min, min2, this.f8306i);
        canvas.restore();
    }

    /* renamed from: b */
    private void m4670b(Canvas canvas) {
        if (this.f8305h != null) {
            Paint paint = this.f8303f;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF m4606a = this.f8300c.m4606a();
            m4606a.inset(strokeWidth, strokeWidth);
            float width = m4606a.width() / 3.0f;
            float height = m4606a.height() / 3.0f;
            if (this.f8323z == CropImageView.CropShape.OVAL) {
                float width2 = (m4606a.width() / 2.0f) - strokeWidth;
                float height2 = (m4606a.height() / 2.0f) - strokeWidth;
                float f = m4606a.left + width;
                float f2 = m4606a.right - width;
                float sin = (float) (height2 * Math.sin(Math.acos((width2 - width) / width2)));
                canvas.drawLine(f, (m4606a.top + height2) - sin, f, (m4606a.bottom - height2) + sin, this.f8305h);
                canvas.drawLine(f2, (m4606a.top + height2) - sin, f2, (m4606a.bottom - height2) + sin, this.f8305h);
                float f3 = m4606a.top + height;
                float f4 = m4606a.bottom - height;
                float cos = (float) (width2 * Math.cos(Math.asin((height2 - height) / height2)));
                canvas.drawLine((m4606a.left + width2) - cos, f3, (m4606a.right - width2) + cos, f3, this.f8305h);
                canvas.drawLine((m4606a.left + width2) - cos, f4, (m4606a.right - width2) + cos, f4, this.f8305h);
                return;
            }
            float f5 = m4606a.left + width;
            float f6 = m4606a.right - width;
            canvas.drawLine(f5, m4606a.top, f5, m4606a.bottom, this.f8305h);
            canvas.drawLine(f6, m4606a.top, f6, m4606a.bottom, this.f8305h);
            float f7 = m4606a.top + height;
            float f8 = m4606a.bottom - height;
            canvas.drawLine(m4606a.left, f7, m4606a.right, f7, this.f8305h);
            canvas.drawLine(m4606a.left, f8, m4606a.right, f8, this.f8305h);
        }
    }

    /* renamed from: c */
    private void m4666c(Canvas canvas) {
        Paint paint = this.f8303f;
        if (paint != null) {
            float strokeWidth = paint.getStrokeWidth();
            RectF m4606a = this.f8300c.m4606a();
            float f = strokeWidth / 2.0f;
            m4606a.inset(f, f);
            if (this.f8323z == CropImageView.CropShape.RECTANGLE) {
                canvas.drawRect(m4606a, this.f8303f);
            } else {
                canvas.drawOval(m4606a, this.f8303f);
            }
        }
    }

    /* renamed from: d */
    private void m4664d(Canvas canvas) {
        if (this.f8304g != null) {
            Paint paint = this.f8303f;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            float strokeWidth2 = this.f8304g.getStrokeWidth();
            float f = strokeWidth2 / 2.0f;
            float f2 = (this.f8323z == CropImageView.CropShape.RECTANGLE ? this.f8312o : 0.0f) + f;
            RectF m4606a = this.f8300c.m4606a();
            m4606a.inset(f2, f2);
            float f3 = (strokeWidth2 - strokeWidth) / 2.0f;
            float f4 = f + f3;
            canvas.drawLine(m4606a.left - f3, m4606a.top - f4, m4606a.left - f3, m4606a.top + this.f8313p, this.f8304g);
            canvas.drawLine(m4606a.left - f4, m4606a.top - f3, m4606a.left + this.f8313p, m4606a.top - f3, this.f8304g);
            canvas.drawLine(m4606a.right + f3, m4606a.top - f4, m4606a.right + f3, m4606a.top + this.f8313p, this.f8304g);
            canvas.drawLine(m4606a.right + f4, m4606a.top - f3, m4606a.right - this.f8313p, m4606a.top - f3, this.f8304g);
            canvas.drawLine(m4606a.left - f3, m4606a.bottom + f4, m4606a.left - f3, m4606a.bottom - this.f8313p, this.f8304g);
            canvas.drawLine(m4606a.left - f4, m4606a.bottom + f3, m4606a.left + this.f8313p, m4606a.bottom + f3, this.f8304g);
            canvas.drawLine(m4606a.right + f3, m4606a.bottom + f4, m4606a.right + f3, m4606a.bottom - this.f8313p, this.f8304g);
            canvas.drawLine(m4606a.right + f4, m4606a.bottom + f3, m4606a.right - this.f8313p, m4606a.bottom + f3, this.f8304g);
        }
    }

    /* renamed from: a */
    private static Paint m4678a(int i) {
        Paint paint = new Paint();
        paint.setColor(i);
        return paint;
    }

    /* renamed from: a */
    private static Paint m4679a(float f, int i) {
        if (f > 0.0f) {
            Paint paint = new Paint();
            paint.setColor(i);
            paint.setStrokeWidth(f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            return paint;
        }
        return null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (this.f8299b) {
                this.f8298a.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction()) {
                case 0:
                    m4681a(motionEvent.getX(), motionEvent.getY());
                    return true;
                case 1:
                case 3:
                    getParent().requestDisallowInterceptTouchEvent(false);
                    m4663e();
                    return true;
                case 2:
                    m4671b(motionEvent.getX(), motionEvent.getY());
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m4681a(float f, float f2) {
        this.f8317t = this.f8300c.m4600a(f, f2, this.f8315r, this.f8323z);
        if (this.f8317t != null) {
            invalidate();
        }
    }

    /* renamed from: e */
    private void m4663e() {
        if (this.f8317t != null) {
            this.f8317t = null;
            m4668b(false);
            invalidate();
        }
    }

    /* renamed from: b */
    private void m4671b(float f, float f2) {
        if (this.f8317t != null) {
            float f3 = this.f8316s;
            RectF m4606a = this.f8300c.m4606a();
            this.f8317t.m4655a(m4606a, f, f2, this.f8309l, this.f8310m, this.f8311n, m4669b(m4606a) ? 0.0f : f3, this.f8318u, this.f8321x);
            this.f8300c.m4599a(m4606a);
            m4668b(true);
            invalidate();
        }
    }

    /* renamed from: b */
    private boolean m4669b(RectF rectF) {
        float m4617a = BitmapUtils.m4617a(this.f8308k);
        float m4615b = BitmapUtils.m4615b(this.f8308k);
        float m4614c = BitmapUtils.m4614c(this.f8308k);
        float m4613d = BitmapUtils.m4613d(this.f8308k);
        if (!m4662f()) {
            this.f8309l.set(m4617a, m4615b, m4614c, m4613d);
            return false;
        }
        float[] fArr = this.f8308k;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[4];
        float f4 = fArr[5];
        float f5 = fArr[6];
        float f6 = fArr[7];
        if (fArr[7] < fArr[1]) {
            if (fArr[1] < fArr[3]) {
                f = fArr[6];
                f2 = fArr[7];
                f3 = fArr[2];
                f4 = fArr[3];
                f5 = fArr[4];
                f6 = fArr[5];
            } else {
                f = fArr[4];
                f2 = fArr[5];
                f3 = fArr[0];
                f4 = fArr[1];
                f5 = fArr[2];
                f6 = fArr[3];
            }
        } else if (fArr[1] > fArr[3]) {
            f = fArr[2];
            f2 = fArr[3];
            f3 = fArr[6];
            f4 = fArr[7];
            f5 = fArr[0];
            f6 = fArr[1];
        }
        float f7 = (f6 - f2) / (f5 - f);
        float f8 = (-1.0f) / f7;
        float f9 = f2 - (f7 * f);
        float f10 = f2 - (f * f8);
        float f11 = f4 - (f7 * f3);
        float f12 = f4 - (f3 * f8);
        float centerY = (rectF.centerY() - rectF.top) / (rectF.centerX() - rectF.left);
        float f13 = -centerY;
        float f14 = rectF.top - (rectF.left * centerY);
        float f15 = rectF.top - (rectF.right * f13);
        float f16 = f7 - centerY;
        float f17 = (f14 - f9) / f16;
        if (f17 >= rectF.right) {
            f17 = m4617a;
        }
        float max = Math.max(m4617a, f17);
        float f18 = (f14 - f10) / (f8 - centerY);
        if (f18 >= rectF.right) {
            f18 = max;
        }
        float max2 = Math.max(max, f18);
        float f19 = f8 - f13;
        float f20 = (f15 - f12) / f19;
        if (f20 >= rectF.right) {
            f20 = max2;
        }
        float max3 = Math.max(max2, f20);
        float f21 = (f15 - f10) / f19;
        if (f21 <= rectF.left) {
            f21 = m4614c;
        }
        float min = Math.min(m4614c, f21);
        float f22 = (f15 - f11) / (f7 - f13);
        if (f22 <= rectF.left) {
            f22 = min;
        }
        float min2 = Math.min(min, f22);
        float f23 = (f14 - f11) / f16;
        if (f23 <= rectF.left) {
            f23 = min2;
        }
        float min3 = Math.min(min2, f23);
        float max4 = Math.max(m4615b, Math.max((f7 * max3) + f9, (f8 * min3) + f10));
        float min4 = Math.min(m4613d, Math.min((f8 * max3) + f12, (f7 * min3) + f11));
        RectF rectF2 = this.f8309l;
        rectF2.left = max3;
        rectF2.top = max4;
        rectF2.right = min3;
        rectF2.bottom = min4;
        return true;
    }

    /* renamed from: f */
    private boolean m4662f() {
        float[] fArr = this.f8308k;
        return (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
    }

    /* renamed from: b */
    private void m4668b(boolean z) {
        try {
            if (this.f8301d != null) {
                this.f8301d.mo4661a(z);
            }
        } catch (Exception e) {
            Log.e("AIC", "Exception in crop window changed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.theartofdev.edmodo.cropper.CropOverlayView$b */
    /* loaded from: classes2.dex */
    public class C2623b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private C2623b() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        @TargetApi(11)
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RectF m4606a = CropOverlayView.this.f8300c.m4606a();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
            float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
            float f = focusY - currentSpanY;
            float f2 = focusX - currentSpanX;
            float f3 = focusX + currentSpanX;
            float f4 = focusY + currentSpanY;
            if (f2 >= f3 || f > f4 || f2 < 0.0f || f3 > CropOverlayView.this.f8300c.m4593d() || f < 0.0f || f4 > CropOverlayView.this.f8300c.m4592e()) {
                return true;
            }
            m4606a.set(f2, f, f3, f4);
            CropOverlayView.this.f8300c.m4599a(m4606a);
            CropOverlayView.this.invalidate();
            return true;
        }
    }
}
