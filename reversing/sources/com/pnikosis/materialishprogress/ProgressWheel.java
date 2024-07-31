package com.pnikosis.materialishprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p008v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes2.dex */
public class ProgressWheel extends View {

    /* renamed from: a */
    private static final String f6790a = "ProgressWheel";

    /* renamed from: b */
    private int f6791b;

    /* renamed from: c */
    private boolean f6792c;

    /* renamed from: d */
    private final int f6793d;

    /* renamed from: e */
    private final int f6794e;

    /* renamed from: f */
    private double f6795f;

    /* renamed from: g */
    private double f6796g;

    /* renamed from: h */
    private float f6797h;

    /* renamed from: i */
    private boolean f6798i;

    /* renamed from: j */
    private long f6799j;

    /* renamed from: k */
    private final long f6800k;

    /* renamed from: l */
    private int f6801l;

    /* renamed from: m */
    private int f6802m;

    /* renamed from: n */
    private int f6803n;

    /* renamed from: o */
    private int f6804o;

    /* renamed from: p */
    private Paint f6805p;

    /* renamed from: q */
    private Paint f6806q;

    /* renamed from: r */
    private RectF f6807r;

    /* renamed from: s */
    private float f6808s;

    /* renamed from: t */
    private long f6809t;

    /* renamed from: u */
    private float f6810u;

    /* renamed from: v */
    private float f6811v;

    /* renamed from: w */
    private boolean f6812w;

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6791b = 80;
        this.f6792c = false;
        this.f6793d = 40;
        this.f6794e = 270;
        this.f6795f = Utils.DOUBLE_EPSILON;
        this.f6796g = 1000.0d;
        this.f6797h = 0.0f;
        this.f6798i = true;
        this.f6799j = 0L;
        this.f6800k = 300L;
        this.f6801l = 5;
        this.f6802m = 5;
        this.f6803n = -1442840576;
        this.f6804o = ViewCompat.MEASURED_SIZE_MASK;
        this.f6805p = new Paint();
        this.f6806q = new Paint();
        this.f6807r = new RectF();
        this.f6808s = 270.0f;
        this.f6809t = 0L;
        this.f6810u = 0.0f;
        this.f6811v = 0.0f;
        this.f6812w = false;
        m5835a(context.obtainStyledAttributes(attributeSet, R.styleable.ProgressWheel));
    }

    public ProgressWheel(Context context) {
        super(context);
        this.f6791b = 80;
        this.f6792c = false;
        this.f6793d = 40;
        this.f6794e = 270;
        this.f6795f = Utils.DOUBLE_EPSILON;
        this.f6796g = 1000.0d;
        this.f6797h = 0.0f;
        this.f6798i = true;
        this.f6799j = 0L;
        this.f6800k = 300L;
        this.f6801l = 5;
        this.f6802m = 5;
        this.f6803n = -1442840576;
        this.f6804o = ViewCompat.MEASURED_SIZE_MASK;
        this.f6805p = new Paint();
        this.f6806q = new Paint();
        this.f6807r = new RectF();
        this.f6808s = 270.0f;
        this.f6809t = 0L;
        this.f6810u = 0.0f;
        this.f6811v = 0.0f;
        this.f6812w = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = this.f6791b + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.f6791b + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m5837a(i, i2);
        m5832d();
        invalidate();
    }

    /* renamed from: d */
    private void m5832d() {
        this.f6805p.setColor(this.f6803n);
        this.f6805p.setAntiAlias(true);
        this.f6805p.setStyle(Paint.Style.STROKE);
        this.f6805p.setStrokeWidth(this.f6801l);
        this.f6806q.setColor(this.f6804o);
        this.f6806q.setAntiAlias(true);
        this.f6806q.setStyle(Paint.Style.STROKE);
        this.f6806q.setStrokeWidth(this.f6802m);
    }

    /* renamed from: a */
    private void m5837a(int i, int i2) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.f6792c) {
            int i3 = (i - paddingLeft) - paddingRight;
            int min = Math.min(Math.min(i3, (i2 - paddingBottom) - paddingTop), (this.f6791b * 2) - (this.f6801l * 2));
            int i4 = ((i3 - min) / 2) + paddingLeft;
            int i5 = ((((i2 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
            int i6 = this.f6801l;
            this.f6807r = new RectF(i4 + i6, i5 + i6, (i4 + min) - i6, (i5 + min) - i6);
            return;
        }
        int i7 = this.f6801l;
        this.f6807r = new RectF(paddingLeft + i7, paddingTop + i7, (i - paddingRight) - i7, (i2 - paddingBottom) - i7);
    }

    /* renamed from: a */
    private void m5835a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f6801l = (int) TypedValue.applyDimension(1, this.f6801l, displayMetrics);
        this.f6802m = (int) TypedValue.applyDimension(1, this.f6802m, displayMetrics);
        this.f6791b = (int) typedArray.getDimension(R.styleable.ProgressWheel_circleRadius, this.f6791b);
        this.f6792c = typedArray.getBoolean(R.styleable.ProgressWheel_fillRadius, false);
        this.f6801l = (int) typedArray.getDimension(R.styleable.ProgressWheel_barWidth, this.f6801l);
        this.f6802m = (int) typedArray.getDimension(R.styleable.ProgressWheel_rimWidth, this.f6802m);
        this.f6808s = typedArray.getFloat(R.styleable.ProgressWheel_spinSpeed, this.f6808s / 360.0f) * 360.0f;
        this.f6796g = typedArray.getInt(R.styleable.ProgressWheel_barSpinCycleTime, (int) this.f6796g);
        this.f6803n = typedArray.getColor(R.styleable.ProgressWheel_barColor, this.f6803n);
        this.f6804o = typedArray.getColor(R.styleable.ProgressWheel_rimColor, this.f6804o);
        if (typedArray.getBoolean(R.styleable.ProgressWheel_progressIndeterminate, false)) {
            m5833c();
        }
        typedArray.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f6807r, 360.0f, 360.0f, false, this.f6806q);
        boolean z = true;
        if (this.f6812w) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f6809t;
            m5836a(uptimeMillis);
            this.f6810u += (((float) uptimeMillis) * this.f6808s) / 1000.0f;
            float f = this.f6810u;
            if (f > 360.0f) {
                this.f6810u = f - 360.0f;
            }
            this.f6809t = SystemClock.uptimeMillis();
            canvas.drawArc(this.f6807r, this.f6810u - 90.0f, this.f6797h + 40.0f, false, this.f6805p);
        } else {
            if (this.f6810u != this.f6811v) {
                this.f6810u = Math.min(this.f6810u + ((((float) (SystemClock.uptimeMillis() - this.f6809t)) / 1000.0f) * this.f6808s), this.f6811v);
                this.f6809t = SystemClock.uptimeMillis();
            } else {
                z = false;
            }
            canvas.drawArc(this.f6807r, -90.0f, this.f6810u, false, this.f6805p);
        }
        if (z) {
            invalidate();
        }
    }

    /* renamed from: a */
    private void m5836a(long j) {
        long j2 = this.f6799j;
        if (j2 >= 300) {
            this.f6795f += j;
            double d = this.f6795f;
            double d2 = this.f6796g;
            if (d > d2) {
                this.f6795f = d - d2;
                this.f6795f = Utils.DOUBLE_EPSILON;
                if (!this.f6798i) {
                    this.f6799j = 0L;
                }
                this.f6798i = !this.f6798i;
            }
            float cos = (((float) Math.cos(((this.f6795f / this.f6796g) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (this.f6798i) {
                this.f6797h = cos * 230.0f;
                return;
            }
            float f = (1.0f - cos) * 230.0f;
            this.f6810u += this.f6797h - f;
            this.f6797h = f;
            return;
        }
        this.f6799j = j2 + j;
    }

    /* renamed from: a */
    public boolean m5838a() {
        return this.f6812w;
    }

    /* renamed from: b */
    public void m5834b() {
        this.f6812w = false;
        this.f6810u = 0.0f;
        this.f6811v = 0.0f;
        invalidate();
    }

    /* renamed from: c */
    public void m5833c() {
        this.f6809t = SystemClock.uptimeMillis();
        this.f6812w = true;
        invalidate();
    }

    public void setProgress(float f) {
        if (this.f6812w) {
            this.f6810u = 0.0f;
            this.f6812w = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        float f2 = this.f6811v;
        if (f == f2) {
            return;
        }
        if (this.f6810u == f2) {
            this.f6809t = SystemClock.uptimeMillis();
        }
        this.f6811v = Math.min(f * 360.0f, 360.0f);
        invalidate();
    }

    public void setInstantProgress(float f) {
        if (this.f6812w) {
            this.f6810u = 0.0f;
            this.f6812w = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f == this.f6811v) {
            return;
        }
        this.f6811v = Math.min(f * 360.0f, 360.0f);
        this.f6810u = this.f6811v;
        this.f6809t = SystemClock.uptimeMillis();
        invalidate();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f6813a = this.f6810u;
        wheelSavedState.f6814b = this.f6811v;
        wheelSavedState.f6815c = this.f6812w;
        wheelSavedState.f6816d = this.f6808s;
        wheelSavedState.f6817e = this.f6801l;
        wheelSavedState.f6818f = this.f6803n;
        wheelSavedState.f6819g = this.f6802m;
        wheelSavedState.f6820h = this.f6804o;
        wheelSavedState.f6821i = this.f6791b;
        return wheelSavedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.f6810u = wheelSavedState.f6813a;
        this.f6811v = wheelSavedState.f6814b;
        this.f6812w = wheelSavedState.f6815c;
        this.f6808s = wheelSavedState.f6816d;
        this.f6801l = wheelSavedState.f6817e;
        this.f6803n = wheelSavedState.f6818f;
        this.f6802m = wheelSavedState.f6819g;
        this.f6804o = wheelSavedState.f6820h;
        this.f6791b = wheelSavedState.f6821i;
    }

    public float getProgress() {
        if (this.f6812w) {
            return -1.0f;
        }
        return this.f6810u / 360.0f;
    }

    public int getCircleRadius() {
        return this.f6791b;
    }

    public void setCircleRadius(int i) {
        this.f6791b = i;
        if (this.f6812w) {
            return;
        }
        invalidate();
    }

    public int getBarWidth() {
        return this.f6801l;
    }

    public void setBarWidth(int i) {
        this.f6801l = i;
        if (this.f6812w) {
            return;
        }
        invalidate();
    }

    public int getBarColor() {
        return this.f6803n;
    }

    public void setBarColor(int i) {
        this.f6803n = i;
        m5832d();
        if (this.f6812w) {
            return;
        }
        invalidate();
    }

    public int getRimColor() {
        return this.f6804o;
    }

    public void setRimColor(int i) {
        this.f6804o = i;
        m5832d();
        if (this.f6812w) {
            return;
        }
        invalidate();
    }

    public float getSpinSpeed() {
        return this.f6808s / 360.0f;
    }

    public void setSpinSpeed(float f) {
        this.f6808s = f * 360.0f;
    }

    public int getRimWidth() {
        return this.f6802m;
    }

    public void setRimWidth(int i) {
        this.f6802m = i;
        if (this.f6812w) {
            return;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() { // from class: com.pnikosis.materialishprogress.ProgressWheel.WheelSavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public WheelSavedState[] newArray(int i) {
                return new WheelSavedState[i];
            }
        };

        /* renamed from: a */
        float f6813a;

        /* renamed from: b */
        float f6814b;

        /* renamed from: c */
        boolean f6815c;

        /* renamed from: d */
        float f6816d;

        /* renamed from: e */
        int f6817e;

        /* renamed from: f */
        int f6818f;

        /* renamed from: g */
        int f6819g;

        /* renamed from: h */
        int f6820h;

        /* renamed from: i */
        int f6821i;

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            super(parcel);
            this.f6813a = parcel.readFloat();
            this.f6814b = parcel.readFloat();
            this.f6815c = parcel.readByte() != 0;
            this.f6816d = parcel.readFloat();
            this.f6817e = parcel.readInt();
            this.f6818f = parcel.readInt();
            this.f6819g = parcel.readInt();
            this.f6820h = parcel.readInt();
            this.f6821i = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f6813a);
            parcel.writeFloat(this.f6814b);
            parcel.writeByte(this.f6815c ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.f6816d);
            parcel.writeInt(this.f6817e);
            parcel.writeInt(this.f6818f);
            parcel.writeInt(this.f6819g);
            parcel.writeInt(this.f6820h);
            parcel.writeInt(this.f6821i);
        }
    }
}
