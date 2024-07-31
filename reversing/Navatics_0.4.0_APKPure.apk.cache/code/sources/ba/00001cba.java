package com.pnikosis.materialishprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes2.dex */
public class ProgressWheel extends View {

    /* renamed from: a */
    private static final String f6821a = "ProgressWheel";

    /* renamed from: b */
    private int f6822b;

    /* renamed from: c */
    private boolean f6823c;

    /* renamed from: d */
    private final int f6824d;

    /* renamed from: e */
    private final int f6825e;

    /* renamed from: f */
    private double f6826f;

    /* renamed from: g */
    private double f6827g;

    /* renamed from: h */
    private float f6828h;

    /* renamed from: i */
    private boolean f6829i;

    /* renamed from: j */
    private long f6830j;

    /* renamed from: k */
    private final long f6831k;

    /* renamed from: l */
    private int f6832l;

    /* renamed from: m */
    private int f6833m;

    /* renamed from: n */
    private int f6834n;

    /* renamed from: o */
    private int f6835o;

    /* renamed from: p */
    private Paint f6836p;

    /* renamed from: q */
    private Paint f6837q;

    /* renamed from: r */
    private RectF f6838r;

    /* renamed from: s */
    private float f6839s;

    /* renamed from: t */
    private long f6840t;

    /* renamed from: u */
    private float f6841u;

    /* renamed from: v */
    private float f6842v;

    /* renamed from: w */
    private boolean f6843w;

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6822b = 80;
        this.f6823c = false;
        this.f6824d = 40;
        this.f6825e = 270;
        this.f6826f = Utils.DOUBLE_EPSILON;
        this.f6827g = 1000.0d;
        this.f6828h = 0.0f;
        this.f6829i = true;
        this.f6830j = 0L;
        this.f6831k = 300L;
        this.f6832l = 5;
        this.f6833m = 5;
        this.f6834n = -1442840576;
        this.f6835o = ViewCompat.MEASURED_SIZE_MASK;
        this.f6836p = new Paint();
        this.f6837q = new Paint();
        this.f6838r = new RectF();
        this.f6839s = 270.0f;
        this.f6840t = 0L;
        this.f6841u = 0.0f;
        this.f6842v = 0.0f;
        this.f6843w = false;
        m7012a(context.obtainStyledAttributes(attributeSet, R.styleable.ProgressWheel));
    }

    public ProgressWheel(Context context) {
        super(context);
        this.f6822b = 80;
        this.f6823c = false;
        this.f6824d = 40;
        this.f6825e = 270;
        this.f6826f = Utils.DOUBLE_EPSILON;
        this.f6827g = 1000.0d;
        this.f6828h = 0.0f;
        this.f6829i = true;
        this.f6830j = 0L;
        this.f6831k = 300L;
        this.f6832l = 5;
        this.f6833m = 5;
        this.f6834n = -1442840576;
        this.f6835o = ViewCompat.MEASURED_SIZE_MASK;
        this.f6836p = new Paint();
        this.f6837q = new Paint();
        this.f6838r = new RectF();
        this.f6839s = 270.0f;
        this.f6840t = 0L;
        this.f6841u = 0.0f;
        this.f6842v = 0.0f;
        this.f6843w = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = this.f6822b + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.f6822b + getPaddingTop() + getPaddingBottom();
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
        m7010a(i, i2);
        m7013d();
        invalidate();
    }

    /* renamed from: d */
    private void m7013d() {
        this.f6836p.setColor(this.f6834n);
        this.f6836p.setAntiAlias(true);
        this.f6836p.setStyle(Paint.Style.STROKE);
        this.f6836p.setStrokeWidth(this.f6832l);
        this.f6837q.setColor(this.f6835o);
        this.f6837q.setAntiAlias(true);
        this.f6837q.setStyle(Paint.Style.STROKE);
        this.f6837q.setStrokeWidth(this.f6833m);
    }

    /* renamed from: a */
    private void m7010a(int i, int i2) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.f6823c) {
            int i3 = (i - paddingLeft) - paddingRight;
            int min = Math.min(Math.min(i3, (i2 - paddingBottom) - paddingTop), (this.f6822b * 2) - (this.f6832l * 2));
            int i4 = ((i3 - min) / 2) + paddingLeft;
            int i5 = ((((i2 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
            int i6 = this.f6832l;
            this.f6838r = new RectF(i4 + i6, i5 + i6, (i4 + min) - i6, (i5 + min) - i6);
            return;
        }
        int i7 = this.f6832l;
        this.f6838r = new RectF(paddingLeft + i7, paddingTop + i7, (i - paddingRight) - i7, (i2 - paddingBottom) - i7);
    }

    /* renamed from: a */
    private void m7012a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f6832l = (int) TypedValue.applyDimension(1, this.f6832l, displayMetrics);
        this.f6833m = (int) TypedValue.applyDimension(1, this.f6833m, displayMetrics);
        this.f6822b = (int) typedArray.getDimension(R.styleable.ProgressWheel_circleRadius, this.f6822b);
        this.f6823c = typedArray.getBoolean(R.styleable.ProgressWheel_fillRadius, false);
        this.f6832l = (int) typedArray.getDimension(R.styleable.ProgressWheel_barWidth, this.f6832l);
        this.f6833m = (int) typedArray.getDimension(R.styleable.ProgressWheel_rimWidth, this.f6833m);
        this.f6839s = typedArray.getFloat(R.styleable.ProgressWheel_spinSpeed, this.f6839s / 360.0f) * 360.0f;
        this.f6827g = typedArray.getInt(R.styleable.ProgressWheel_barSpinCycleTime, (int) this.f6827g);
        this.f6834n = typedArray.getColor(R.styleable.ProgressWheel_barColor, this.f6834n);
        this.f6835o = typedArray.getColor(R.styleable.ProgressWheel_rimColor, this.f6835o);
        if (typedArray.getBoolean(R.styleable.ProgressWheel_progressIndeterminate, false)) {
            m7016c();
        }
        typedArray.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f6838r, 360.0f, 360.0f, false, this.f6837q);
        boolean z = true;
        if (this.f6843w) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f6840t;
            float f = (((float) uptimeMillis) * this.f6839s) / 1000.0f;
            m7011a(uptimeMillis);
            this.f6841u += f;
            float f2 = this.f6841u;
            if (f2 > 360.0f) {
                this.f6841u = f2 - 360.0f;
            }
            this.f6840t = SystemClock.uptimeMillis();
            canvas.drawArc(this.f6838r, this.f6841u - 90.0f, this.f6828h + 40.0f, false, this.f6836p);
        } else {
            if (this.f6841u != this.f6842v) {
                this.f6841u = Math.min(this.f6841u + ((((float) (SystemClock.uptimeMillis() - this.f6840t)) / 1000.0f) * this.f6839s), this.f6842v);
                this.f6840t = SystemClock.uptimeMillis();
            } else {
                z = false;
            }
            canvas.drawArc(this.f6838r, -90.0f, this.f6841u, false, this.f6836p);
        }
        if (z) {
            invalidate();
        }
    }

    /* renamed from: a */
    private void m7011a(long j) {
        long j2 = this.f6830j;
        if (j2 >= 300) {
            this.f6826f += j;
            double d = this.f6826f;
            double d2 = this.f6827g;
            if (d > d2) {
                this.f6826f = d - d2;
                this.f6826f = Utils.DOUBLE_EPSILON;
                if (!this.f6829i) {
                    this.f6830j = 0L;
                }
                this.f6829i = !this.f6829i;
            }
            float cos = (((float) Math.cos(((this.f6826f / this.f6827g) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (this.f6829i) {
                this.f6828h = cos * 230.0f;
                return;
            }
            float f = (1.0f - cos) * 230.0f;
            this.f6841u += this.f6828h - f;
            this.f6828h = f;
            return;
        }
        this.f6830j = j2 + j;
    }

    /* renamed from: a */
    public boolean m7014a() {
        return this.f6843w;
    }

    /* renamed from: b */
    public void m7015b() {
        this.f6843w = false;
        this.f6841u = 0.0f;
        this.f6842v = 0.0f;
        invalidate();
    }

    /* renamed from: c */
    public void m7016c() {
        this.f6840t = SystemClock.uptimeMillis();
        this.f6843w = true;
        invalidate();
    }

    public void setProgress(float f) {
        if (this.f6843w) {
            this.f6841u = 0.0f;
            this.f6843w = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        float f2 = this.f6842v;
        if (f == f2) {
            return;
        }
        if (this.f6841u == f2) {
            this.f6840t = SystemClock.uptimeMillis();
        }
        this.f6842v = Math.min(f * 360.0f, 360.0f);
        invalidate();
    }

    public void setInstantProgress(float f) {
        if (this.f6843w) {
            this.f6841u = 0.0f;
            this.f6843w = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f == this.f6842v) {
            return;
        }
        this.f6842v = Math.min(f * 360.0f, 360.0f);
        this.f6841u = this.f6842v;
        this.f6840t = SystemClock.uptimeMillis();
        invalidate();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f6844a = this.f6841u;
        wheelSavedState.f6845b = this.f6842v;
        wheelSavedState.f6846c = this.f6843w;
        wheelSavedState.f6847d = this.f6839s;
        wheelSavedState.f6848e = this.f6832l;
        wheelSavedState.f6849f = this.f6834n;
        wheelSavedState.f6850g = this.f6833m;
        wheelSavedState.f6851h = this.f6835o;
        wheelSavedState.f6852i = this.f6822b;
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
        this.f6841u = wheelSavedState.f6844a;
        this.f6842v = wheelSavedState.f6845b;
        this.f6843w = wheelSavedState.f6846c;
        this.f6839s = wheelSavedState.f6847d;
        this.f6832l = wheelSavedState.f6848e;
        this.f6834n = wheelSavedState.f6849f;
        this.f6833m = wheelSavedState.f6850g;
        this.f6835o = wheelSavedState.f6851h;
        this.f6822b = wheelSavedState.f6852i;
    }

    public float getProgress() {
        if (this.f6843w) {
            return -1.0f;
        }
        return this.f6841u / 360.0f;
    }

    public int getCircleRadius() {
        return this.f6822b;
    }

    public void setCircleRadius(int i) {
        this.f6822b = i;
        if (this.f6843w) {
            return;
        }
        invalidate();
    }

    public int getBarWidth() {
        return this.f6832l;
    }

    public void setBarWidth(int i) {
        this.f6832l = i;
        if (this.f6843w) {
            return;
        }
        invalidate();
    }

    public int getBarColor() {
        return this.f6834n;
    }

    public void setBarColor(int i) {
        this.f6834n = i;
        m7013d();
        if (this.f6843w) {
            return;
        }
        invalidate();
    }

    public int getRimColor() {
        return this.f6835o;
    }

    public void setRimColor(int i) {
        this.f6835o = i;
        m7013d();
        if (this.f6843w) {
            return;
        }
        invalidate();
    }

    public float getSpinSpeed() {
        return this.f6839s / 360.0f;
    }

    public void setSpinSpeed(float f) {
        this.f6839s = f * 360.0f;
    }

    public int getRimWidth() {
        return this.f6833m;
    }

    public void setRimWidth(int i) {
        this.f6833m = i;
        if (this.f6843w) {
            return;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() { // from class: com.pnikosis.materialishprogress.ProgressWheel.WheelSavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public WheelSavedState[] newArray(int i) {
                return new WheelSavedState[i];
            }
        };

        /* renamed from: a */
        float f6844a;

        /* renamed from: b */
        float f6845b;

        /* renamed from: c */
        boolean f6846c;

        /* renamed from: d */
        float f6847d;

        /* renamed from: e */
        int f6848e;

        /* renamed from: f */
        int f6849f;

        /* renamed from: g */
        int f6850g;

        /* renamed from: h */
        int f6851h;

        /* renamed from: i */
        int f6852i;

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            super(parcel);
            this.f6844a = parcel.readFloat();
            this.f6845b = parcel.readFloat();
            this.f6846c = parcel.readByte() != 0;
            this.f6847d = parcel.readFloat();
            this.f6848e = parcel.readInt();
            this.f6849f = parcel.readInt();
            this.f6850g = parcel.readInt();
            this.f6851h = parcel.readInt();
            this.f6852i = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f6844a);
            parcel.writeFloat(this.f6845b);
            parcel.writeByte(this.f6846c ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.f6847d);
            parcel.writeInt(this.f6848e);
            parcel.writeInt(this.f6849f);
            parcel.writeInt(this.f6850g);
            parcel.writeInt(this.f6851h);
            parcel.writeInt(this.f6852i);
        }
    }
}