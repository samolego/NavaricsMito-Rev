package com.navatics.app.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.widget.g */
/* loaded from: classes.dex */
public class TextDrawable extends ShapeDrawable {

    /* renamed from: a */
    private static final C3044k f5709a = C3044k.m1564a(TextDrawable.class);

    /* renamed from: b */
    private final Paint f5710b;

    /* renamed from: c */
    private final Paint f5711c;

    /* renamed from: d */
    private final String f5712d;

    /* renamed from: e */
    private final int f5713e;

    /* renamed from: f */
    private final RectShape f5714f;

    /* renamed from: g */
    private final int f5715g;

    /* renamed from: h */
    private final int f5716h;

    /* renamed from: i */
    private final int f5717i;

    /* renamed from: j */
    private final float f5718j;

    /* renamed from: k */
    private final int f5719k;

    /* compiled from: TextDrawable.java */
    /* renamed from: com.navatics.app.widget.g$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1976b {
    }

    /* compiled from: TextDrawable.java */
    /* renamed from: com.navatics.app.widget.g$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1977c {
        /* renamed from: a */
        InterfaceC1977c mo6931a(int i);

        /* renamed from: b */
        InterfaceC1977c mo6929b(int i);

        /* renamed from: b */
        InterfaceC1978d mo6930b();

        /* renamed from: c */
        InterfaceC1977c mo6928c(int i);
    }

    /* compiled from: TextDrawable.java */
    /* renamed from: com.navatics.app.widget.g$d */
    /* loaded from: classes.dex */
    public interface InterfaceC1978d {
        /* renamed from: a */
        InterfaceC1977c mo6927a();

        /* renamed from: a */
        TextDrawable mo6926a(String str, int i, int i2);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private TextDrawable(C1975a c1975a) {
        super(c1975a.f5728i);
        this.f5714f = c1975a.f5728i;
        this.f5715g = c1975a.f5726g;
        this.f5716h = c1975a.f5725f;
        this.f5718j = c1975a.f5721b;
        this.f5712d = c1975a.f5731l ? c1975a.f5722c.toUpperCase() : c1975a.f5722c;
        this.f5713e = c1975a.f5723d;
        this.f5717i = c1975a.f5729j;
        this.f5710b = new Paint();
        this.f5710b.setColor(c1975a.f5720a);
        this.f5710b.setAntiAlias(true);
        this.f5710b.setFakeBoldText(c1975a.f5730k);
        this.f5710b.setStyle(Paint.Style.FILL);
        this.f5710b.setTypeface(c1975a.f5727h);
        this.f5710b.setTextAlign(Paint.Align.CENTER);
        this.f5710b.setStrokeWidth(c1975a.f5724e);
        this.f5719k = c1975a.f5724e;
        this.f5711c = new Paint();
        this.f5711c.setColor(-1);
        this.f5711c.setStyle(Paint.Style.STROKE);
        this.f5711c.setStrokeWidth(this.f5719k);
        this.f5711c.setAntiAlias(true);
        getPaint().setColor(this.f5713e);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Rect bounds = getBounds();
        if (this.f5719k > 0) {
            m6944a(canvas);
        }
        int save = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        int i = this.f5716h;
        if (i < 0) {
            i = bounds.width();
        }
        int i2 = this.f5715g;
        if (i2 < 0) {
            i2 = bounds.height();
        }
        int i3 = this.f5717i;
        if (i3 < 0) {
            i3 = Math.min(i, i2) / 2;
        }
        this.f5710b.setTextSize(i3);
        canvas.drawText(this.f5712d, i / 2, (i2 / 2) - ((this.f5710b.descent() + this.f5710b.ascent()) / 2.0f), this.f5710b);
        canvas.restoreToCount(save);
    }

    /* renamed from: a */
    private void m6944a(Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        int i = this.f5719k;
        rectF.inset(i / 2, i / 2);
        RectShape rectShape = this.f5714f;
        if (rectShape instanceof OvalShape) {
            canvas.drawOval(rectF, this.f5711c);
        } else if (rectShape instanceof RoundRectShape) {
            float f = this.f5718j;
            canvas.drawRoundRect(rectF, f, f, this.f5711c);
        } else {
            canvas.drawRect(rectF, this.f5711c);
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5710b.setAlpha(i);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5710b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5716h;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f5715g;
    }

    /* renamed from: a */
    public static InterfaceC1978d m6945a() {
        return new C1975a();
    }

    /* compiled from: TextDrawable.java */
    /* renamed from: com.navatics.app.widget.g$a */
    /* loaded from: classes.dex */
    public static class C1975a implements InterfaceC1976b, InterfaceC1977c, InterfaceC1978d {

        /* renamed from: a */
        public int f5720a;

        /* renamed from: b */
        public float f5721b;

        /* renamed from: c */
        private String f5722c;

        /* renamed from: d */
        private int f5723d;

        /* renamed from: e */
        private int f5724e;

        /* renamed from: f */
        private int f5725f;

        /* renamed from: g */
        private int f5726g;

        /* renamed from: h */
        private Typeface f5727h;

        /* renamed from: i */
        private RectShape f5728i;

        /* renamed from: j */
        private int f5729j;

        /* renamed from: k */
        private boolean f5730k;

        /* renamed from: l */
        private boolean f5731l;

        @Override // com.navatics.app.widget.TextDrawable.InterfaceC1978d
        /* renamed from: a */
        public InterfaceC1977c mo6927a() {
            return this;
        }

        @Override // com.navatics.app.widget.TextDrawable.InterfaceC1977c
        /* renamed from: b */
        public InterfaceC1978d mo6930b() {
            return this;
        }

        private C1975a() {
            this.f5722c = "";
            this.f5723d = -7829368;
            this.f5720a = -1;
            this.f5724e = 0;
            this.f5725f = -1;
            this.f5726g = -1;
            this.f5728i = new RectShape();
            this.f5727h = Typeface.create("sans-serif-light", 0);
            this.f5729j = -1;
            this.f5730k = false;
            this.f5731l = false;
        }

        @Override // com.navatics.app.widget.TextDrawable.InterfaceC1977c
        /* renamed from: a */
        public InterfaceC1977c mo6931a(int i) {
            this.f5725f = i;
            return this;
        }

        @Override // com.navatics.app.widget.TextDrawable.InterfaceC1977c
        /* renamed from: b */
        public InterfaceC1977c mo6929b(int i) {
            this.f5726g = i;
            return this;
        }

        @Override // com.navatics.app.widget.TextDrawable.InterfaceC1977c
        /* renamed from: c */
        public InterfaceC1977c mo6928c(int i) {
            this.f5724e = i;
            return this;
        }

        /* renamed from: d */
        public InterfaceC1976b m6939d(int i) {
            float f = i;
            this.f5721b = f;
            this.f5728i = new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null);
            return this;
        }

        @Override // com.navatics.app.widget.TextDrawable.InterfaceC1978d
        /* renamed from: a */
        public TextDrawable mo6926a(String str, int i, int i2) {
            m6939d(i2);
            return m6942a(str, i);
        }

        /* renamed from: a */
        public TextDrawable m6942a(String str, int i) {
            this.f5723d = i;
            this.f5722c = str;
            return new TextDrawable(this);
        }
    }
}
