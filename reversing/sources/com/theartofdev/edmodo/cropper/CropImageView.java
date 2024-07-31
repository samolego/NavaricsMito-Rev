package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.theartofdev.edmodo.cropper.BitmapCroppingWorkerTask;
import com.theartofdev.edmodo.cropper.BitmapLoadingWorkerTask;
import com.theartofdev.edmodo.cropper.CropOverlayView;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes2.dex */
public class CropImageView extends FrameLayout {

    /* renamed from: A */
    private InterfaceC2616b f8241A;

    /* renamed from: B */
    private Uri f8242B;

    /* renamed from: C */
    private int f8243C;

    /* renamed from: D */
    private float f8244D;

    /* renamed from: E */
    private float f8245E;

    /* renamed from: F */
    private float f8246F;

    /* renamed from: G */
    private RectF f8247G;

    /* renamed from: H */
    private int f8248H;

    /* renamed from: I */
    private boolean f8249I;

    /* renamed from: J */
    private Uri f8250J;

    /* renamed from: K */
    private WeakReference<BitmapLoadingWorkerTask> f8251K;

    /* renamed from: L */
    private WeakReference<BitmapCroppingWorkerTask> f8252L;

    /* renamed from: a */
    private final ImageView f8253a;

    /* renamed from: b */
    private final CropOverlayView f8254b;

    /* renamed from: c */
    private final Matrix f8255c;

    /* renamed from: d */
    private final Matrix f8256d;

    /* renamed from: e */
    private final ProgressBar f8257e;

    /* renamed from: f */
    private final float[] f8258f;

    /* renamed from: g */
    private final float[] f8259g;

    /* renamed from: h */
    private CropImageAnimation f8260h;

    /* renamed from: i */
    private Bitmap f8261i;

    /* renamed from: j */
    private int f8262j;

    /* renamed from: k */
    private int f8263k;

    /* renamed from: l */
    private boolean f8264l;

    /* renamed from: m */
    private boolean f8265m;

    /* renamed from: n */
    private int f8266n;

    /* renamed from: o */
    private int f8267o;

    /* renamed from: p */
    private int f8268p;

    /* renamed from: q */
    private ScaleType f8269q;

    /* renamed from: r */
    private boolean f8270r;

    /* renamed from: s */
    private boolean f8271s;

    /* renamed from: t */
    private boolean f8272t;

    /* renamed from: u */
    private boolean f8273u;

    /* renamed from: v */
    private int f8274v;

    /* renamed from: w */
    private InterfaceC2618d f8275w;

    /* renamed from: x */
    private InterfaceC2617c f8276x;

    /* renamed from: y */
    private InterfaceC2619e f8277y;

    /* renamed from: z */
    private InterfaceC2620f f8278z;

    /* loaded from: classes2.dex */
    public enum CropShape {
        RECTANGLE,
        OVAL
    }

    /* loaded from: classes2.dex */
    public enum Guidelines {
        OFF,
        ON_TOUCH,
        ON
    }

    /* loaded from: classes2.dex */
    public enum RequestSizeOptions {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    /* loaded from: classes2.dex */
    public enum ScaleType {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$b */
    /* loaded from: classes2.dex */
    public interface InterfaceC2616b {
        /* renamed from: a */
        void mo4687a(CropImageView cropImageView, C2615a c2615a);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$c */
    /* loaded from: classes2.dex */
    public interface InterfaceC2617c {
        /* renamed from: a */
        void m4686a(Rect rect);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$d */
    /* loaded from: classes2.dex */
    public interface InterfaceC2618d {
        /* renamed from: a */
        void m4685a(Rect rect);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$e */
    /* loaded from: classes2.dex */
    public interface InterfaceC2619e {
        /* renamed from: a */
        void m4684a();
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$f */
    /* loaded from: classes2.dex */
    public interface InterfaceC2620f {
        /* renamed from: a */
        void mo4683a(CropImageView cropImageView, Uri uri, Exception exc);
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bundle bundleExtra;
        this.f8255c = new Matrix();
        this.f8256d = new Matrix();
        this.f8258f = new float[8];
        this.f8259g = new float[8];
        this.f8270r = false;
        this.f8271s = true;
        this.f8272t = true;
        this.f8273u = true;
        this.f8243C = 1;
        this.f8244D = 1.0f;
        CropImageOptions cropImageOptions = null;
        Intent intent = context instanceof Activity ? ((Activity) context).getIntent() : null;
        if (intent != null && (bundleExtra = intent.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE")) != null) {
            cropImageOptions = (CropImageOptions) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        }
        if (cropImageOptions == null) {
            cropImageOptions = new CropImageOptions();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CropImageView, 0, 0);
                try {
                    cropImageOptions.f8226l = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropFixAspectRatio, cropImageOptions.f8226l);
                    cropImageOptions.f8227m = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropAspectRatioX, cropImageOptions.f8227m);
                    cropImageOptions.f8228n = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropAspectRatioY, cropImageOptions.f8228n);
                    cropImageOptions.f8219e = ScaleType.values()[obtainStyledAttributes.getInt(R.styleable.CropImageView_cropScaleType, cropImageOptions.f8219e.ordinal())];
                    cropImageOptions.f8222h = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropAutoZoomEnabled, cropImageOptions.f8222h);
                    cropImageOptions.f8223i = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropMultiTouchEnabled, cropImageOptions.f8223i);
                    cropImageOptions.f8224j = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropMaxZoom, cropImageOptions.f8224j);
                    cropImageOptions.f8215a = CropShape.values()[obtainStyledAttributes.getInt(R.styleable.CropImageView_cropShape, cropImageOptions.f8215a.ordinal())];
                    cropImageOptions.f8218d = Guidelines.values()[obtainStyledAttributes.getInt(R.styleable.CropImageView_cropGuidelines, cropImageOptions.f8218d.ordinal())];
                    cropImageOptions.f8216b = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropSnapRadius, cropImageOptions.f8216b);
                    cropImageOptions.f8217c = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropTouchRadius, cropImageOptions.f8217c);
                    cropImageOptions.f8225k = obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropInitialCropWindowPaddingRatio, cropImageOptions.f8225k);
                    cropImageOptions.f8229o = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderLineThickness, cropImageOptions.f8229o);
                    cropImageOptions.f8230p = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropBorderLineColor, cropImageOptions.f8230p);
                    cropImageOptions.f8231q = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderCornerThickness, cropImageOptions.f8231q);
                    cropImageOptions.f8232r = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderCornerOffset, cropImageOptions.f8232r);
                    cropImageOptions.f8233s = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderCornerLength, cropImageOptions.f8233s);
                    cropImageOptions.f8234t = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropBorderCornerColor, cropImageOptions.f8234t);
                    cropImageOptions.f8235u = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropGuidelinesThickness, cropImageOptions.f8235u);
                    cropImageOptions.f8236v = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropGuidelinesColor, cropImageOptions.f8236v);
                    cropImageOptions.f8237w = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropBackgroundColor, cropImageOptions.f8237w);
                    cropImageOptions.f8220f = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropShowCropOverlay, this.f8271s);
                    cropImageOptions.f8221g = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropShowProgressBar, this.f8272t);
                    cropImageOptions.f8231q = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderCornerThickness, cropImageOptions.f8231q);
                    cropImageOptions.f8238x = (int) obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropMinCropWindowWidth, cropImageOptions.f8238x);
                    cropImageOptions.f8239y = (int) obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropMinCropWindowHeight, cropImageOptions.f8239y);
                    cropImageOptions.f8240z = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMinCropResultWidthPX, cropImageOptions.f8240z);
                    cropImageOptions.f8193A = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMinCropResultHeightPX, cropImageOptions.f8193A);
                    cropImageOptions.f8194B = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMaxCropResultWidthPX, cropImageOptions.f8194B);
                    cropImageOptions.f8195C = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMaxCropResultHeightPX, cropImageOptions.f8195C);
                    cropImageOptions.f8211S = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropFlipHorizontally, cropImageOptions.f8211S);
                    cropImageOptions.f8212T = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropFlipHorizontally, cropImageOptions.f8212T);
                    this.f8270r = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropSaveBitmapToInstanceState, this.f8270r);
                    if (obtainStyledAttributes.hasValue(R.styleable.CropImageView_cropAspectRatioX) && obtainStyledAttributes.hasValue(R.styleable.CropImageView_cropAspectRatioX) && !obtainStyledAttributes.hasValue(R.styleable.CropImageView_cropFixAspectRatio)) {
                        cropImageOptions.f8226l = true;
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
        cropImageOptions.m4719a();
        this.f8269q = cropImageOptions.f8219e;
        this.f8273u = cropImageOptions.f8222h;
        this.f8274v = cropImageOptions.f8224j;
        this.f8271s = cropImageOptions.f8220f;
        this.f8272t = cropImageOptions.f8221g;
        this.f8264l = cropImageOptions.f8211S;
        this.f8265m = cropImageOptions.f8212T;
        View inflate = LayoutInflater.from(context).inflate(R.layout.crop_image_view, (ViewGroup) this, true);
        this.f8253a = (ImageView) inflate.findViewById(R.id.ImageView_image);
        this.f8253a.setScaleType(ImageView.ScaleType.MATRIX);
        this.f8254b = (CropOverlayView) inflate.findViewById(R.id.CropOverlayView);
        this.f8254b.setCropWindowChangeListener(new CropOverlayView.InterfaceC2622a() { // from class: com.theartofdev.edmodo.cropper.CropImageView.1
            @Override // com.theartofdev.edmodo.cropper.CropOverlayView.InterfaceC2622a
            /* renamed from: a */
            public void mo4661a(boolean z) {
                CropImageView.this.m4703a(z, true);
                InterfaceC2618d interfaceC2618d = CropImageView.this.f8275w;
                if (interfaceC2618d != null && !z) {
                    interfaceC2618d.m4685a(CropImageView.this.getCropRect());
                }
                InterfaceC2617c interfaceC2617c = CropImageView.this.f8276x;
                if (interfaceC2617c == null || !z) {
                    return;
                }
                interfaceC2617c.m4686a(CropImageView.this.getCropRect());
            }
        });
        this.f8254b.setInitialAttributeValues(cropImageOptions);
        this.f8257e = (ProgressBar) inflate.findViewById(R.id.CropProgressBar);
        m4696f();
    }

    public ScaleType getScaleType() {
        return this.f8269q;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != this.f8269q) {
            this.f8269q = scaleType;
            this.f8244D = 1.0f;
            this.f8246F = 0.0f;
            this.f8245E = 0.0f;
            this.f8254b.m4672b();
            requestLayout();
        }
    }

    public CropShape getCropShape() {
        return this.f8254b.getCropShape();
    }

    public void setCropShape(CropShape cropShape) {
        this.f8254b.setCropShape(cropShape);
    }

    public void setAutoZoomEnabled(boolean z) {
        if (this.f8273u != z) {
            this.f8273u = z;
            m4703a(false, false);
            this.f8254b.invalidate();
        }
    }

    public void setMultiTouchEnabled(boolean z) {
        if (this.f8254b.m4674a(z)) {
            m4703a(false, false);
            this.f8254b.invalidate();
        }
    }

    public int getMaxZoom() {
        return this.f8274v;
    }

    public void setMaxZoom(int i) {
        if (this.f8274v == i || i <= 0) {
            return;
        }
        this.f8274v = i;
        m4703a(false, false);
        this.f8254b.invalidate();
    }

    public int getRotatedDegrees() {
        return this.f8263k;
    }

    public void setRotatedDegrees(int i) {
        int i2 = this.f8263k;
        if (i2 != i) {
            m4714a(i - i2);
        }
    }

    public void setFixedAspectRatio(boolean z) {
        this.f8254b.setFixedAspectRatio(z);
    }

    public void setFlippedHorizontally(boolean z) {
        if (this.f8264l != z) {
            this.f8264l = z;
            m4715a(getWidth(), getHeight(), true, false);
        }
    }

    public void setFlippedVertically(boolean z) {
        if (this.f8265m != z) {
            this.f8265m = z;
            m4715a(getWidth(), getHeight(), true, false);
        }
    }

    public Guidelines getGuidelines() {
        return this.f8254b.getGuidelines();
    }

    public void setGuidelines(Guidelines guidelines) {
        this.f8254b.setGuidelines(guidelines);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair<>(Integer.valueOf(this.f8254b.getAspectRatioX()), Integer.valueOf(this.f8254b.getAspectRatioY()));
    }

    public void setSnapRadius(float f) {
        if (f >= 0.0f) {
            this.f8254b.setSnapRadius(f);
        }
    }

    public void setShowProgressBar(boolean z) {
        if (this.f8272t != z) {
            this.f8272t = z;
            m4696f();
        }
    }

    public void setShowCropOverlay(boolean z) {
        if (this.f8271s != z) {
            this.f8271s = z;
            m4697e();
        }
    }

    public void setSaveBitmapToInstanceState(boolean z) {
        this.f8270r = z;
    }

    public int getImageResource() {
        return this.f8268p;
    }

    public Uri getImageUri() {
        return this.f8242B;
    }

    public Rect getWholeImageRect() {
        int i = this.f8243C;
        Bitmap bitmap = this.f8261i;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i, bitmap.getHeight() * i);
    }

    public Rect getCropRect() {
        int i = this.f8243C;
        Bitmap bitmap = this.f8261i;
        if (bitmap == null) {
            return null;
        }
        return BitmapUtils.m4616a(getCropPoints(), bitmap.getWidth() * i, i * bitmap.getHeight(), this.f8254b.m4667c(), this.f8254b.getAspectRatioX(), this.f8254b.getAspectRatioY());
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.f8254b;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.f8254b.getCropWindowRect();
        float[] fArr = new float[8];
        fArr[0] = cropWindowRect.left;
        fArr[1] = cropWindowRect.top;
        fArr[2] = cropWindowRect.right;
        fArr[3] = cropWindowRect.top;
        fArr[4] = cropWindowRect.right;
        fArr[5] = cropWindowRect.bottom;
        fArr[6] = cropWindowRect.left;
        fArr[7] = cropWindowRect.bottom;
        this.f8255c.invert(this.f8256d);
        this.f8256d.mapPoints(fArr);
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] * this.f8243C;
        }
        return fArr;
    }

    public void setCropRect(Rect rect) {
        this.f8254b.setInitialCropWindowRect(rect);
    }

    public Bitmap getCroppedImage() {
        return m4712a(0, 0, RequestSizeOptions.NONE);
    }

    /* renamed from: a */
    public Bitmap m4712a(int i, int i2, RequestSizeOptions requestSizeOptions) {
        Bitmap bitmap;
        if (this.f8261i != null) {
            this.f8253a.clearAnimation();
            int i3 = requestSizeOptions != RequestSizeOptions.NONE ? i : 0;
            int i4 = requestSizeOptions != RequestSizeOptions.NONE ? i2 : 0;
            if (this.f8242B != null && (this.f8243C > 1 || requestSizeOptions == RequestSizeOptions.SAMPLING)) {
                bitmap = BitmapUtils.m4629a(getContext(), this.f8242B, getCropPoints(), this.f8263k, this.f8261i.getWidth() * this.f8243C, this.f8261i.getHeight() * this.f8243C, this.f8254b.m4667c(), this.f8254b.getAspectRatioX(), this.f8254b.getAspectRatioY(), i3, i4, this.f8264l, this.f8265m).f8375a;
            } else {
                bitmap = BitmapUtils.m4621a(this.f8261i, getCropPoints(), this.f8263k, this.f8254b.m4667c(), this.f8254b.getAspectRatioX(), this.f8254b.getAspectRatioY(), this.f8264l, this.f8265m).f8375a;
            }
            return BitmapUtils.m4626a(bitmap, i3, i4, requestSizeOptions);
        }
        return null;
    }

    public void getCroppedImageAsync() {
        m4701b(0, 0, RequestSizeOptions.NONE);
    }

    /* renamed from: b */
    public void m4701b(int i, int i2, RequestSizeOptions requestSizeOptions) {
        if (this.f8241A == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        }
        m4711a(i, i2, requestSizeOptions, (Uri) null, (Bitmap.CompressFormat) null, 0);
    }

    /* renamed from: a */
    public void m4709a(Uri uri, Bitmap.CompressFormat compressFormat, int i, int i2, int i3, RequestSizeOptions requestSizeOptions) {
        if (this.f8241A == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        }
        m4711a(i2, i3, requestSizeOptions, uri, compressFormat, i);
    }

    public void setOnSetCropOverlayReleasedListener(InterfaceC2618d interfaceC2618d) {
        this.f8275w = interfaceC2618d;
    }

    public void setOnSetCropOverlayMovedListener(InterfaceC2617c interfaceC2617c) {
        this.f8276x = interfaceC2617c;
    }

    public void setOnCropWindowChangedListener(InterfaceC2619e interfaceC2619e) {
        this.f8277y = interfaceC2619e;
    }

    public void setOnSetImageUriCompleteListener(InterfaceC2620f interfaceC2620f) {
        this.f8278z = interfaceC2620f;
    }

    public void setOnCropImageCompleteListener(InterfaceC2616b interfaceC2616b) {
        this.f8241A = interfaceC2616b;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f8254b.setInitialCropWindowRect(null);
        m4710a(bitmap, 0, null, 1, 0);
    }

    public void setImageResource(int i) {
        if (i != 0) {
            this.f8254b.setInitialCropWindowRect(null);
            m4710a(BitmapFactory.decodeResource(getResources(), i), i, null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference<BitmapLoadingWorkerTask> weakReference = this.f8251K;
            BitmapLoadingWorkerTask bitmapLoadingWorkerTask = weakReference != null ? weakReference.get() : null;
            if (bitmapLoadingWorkerTask != null) {
                bitmapLoadingWorkerTask.cancel(true);
            }
            m4699c();
            this.f8247G = null;
            this.f8248H = 0;
            this.f8254b.setInitialCropWindowRect(null);
            this.f8251K = new WeakReference<>(new BitmapLoadingWorkerTask(this, uri));
            this.f8251K.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            m4696f();
        }
    }

    /* renamed from: a */
    public void m4714a(int i) {
        int i2;
        if (this.f8261i != null) {
            if (i < 0) {
                i2 = (i % 360) + 360;
            } else {
                i2 = i % 360;
            }
            boolean z = !this.f8254b.m4667c() && ((i2 > 45 && i2 < 135) || (i2 > 215 && i2 < 305));
            BitmapUtils.f8370c.set(this.f8254b.getCropWindowRect());
            float height = (z ? BitmapUtils.f8370c.height() : BitmapUtils.f8370c.width()) / 2.0f;
            float width = (z ? BitmapUtils.f8370c.width() : BitmapUtils.f8370c.height()) / 2.0f;
            if (z) {
                boolean z2 = this.f8264l;
                this.f8264l = this.f8265m;
                this.f8265m = z2;
            }
            this.f8255c.invert(this.f8256d);
            BitmapUtils.f8371d[0] = BitmapUtils.f8370c.centerX();
            BitmapUtils.f8371d[1] = BitmapUtils.f8370c.centerY();
            BitmapUtils.f8371d[2] = 0.0f;
            BitmapUtils.f8371d[3] = 0.0f;
            BitmapUtils.f8371d[4] = 1.0f;
            BitmapUtils.f8371d[5] = 0.0f;
            this.f8256d.mapPoints(BitmapUtils.f8371d);
            this.f8263k = (this.f8263k + i2) % 360;
            m4715a(getWidth(), getHeight(), true, false);
            this.f8255c.mapPoints(BitmapUtils.f8372e, BitmapUtils.f8371d);
            this.f8244D = (float) (this.f8244D / Math.sqrt(Math.pow(BitmapUtils.f8372e[4] - BitmapUtils.f8372e[2], 2.0d) + Math.pow(BitmapUtils.f8372e[5] - BitmapUtils.f8372e[3], 2.0d)));
            this.f8244D = Math.max(this.f8244D, 1.0f);
            m4715a(getWidth(), getHeight(), true, false);
            this.f8255c.mapPoints(BitmapUtils.f8372e, BitmapUtils.f8371d);
            double sqrt = Math.sqrt(Math.pow(BitmapUtils.f8372e[4] - BitmapUtils.f8372e[2], 2.0d) + Math.pow(BitmapUtils.f8372e[5] - BitmapUtils.f8372e[3], 2.0d));
            float f = (float) (height * sqrt);
            float f2 = (float) (width * sqrt);
            BitmapUtils.f8370c.set(BitmapUtils.f8372e[0] - f, BitmapUtils.f8372e[1] - f2, BitmapUtils.f8372e[0] + f, BitmapUtils.f8372e[1] + f2);
            this.f8254b.m4672b();
            this.f8254b.setCropWindowRect(BitmapUtils.f8370c);
            m4715a(getWidth(), getHeight(), true, false);
            m4703a(false, false);
            this.f8254b.m4682a();
        }
    }

    /* renamed from: a */
    public void m4716a() {
        this.f8264l = !this.f8264l;
        m4715a(getWidth(), getHeight(), true, false);
    }

    /* renamed from: b */
    public void m4702b() {
        this.f8265m = !this.f8265m;
        m4715a(getWidth(), getHeight(), true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4705a(BitmapLoadingWorkerTask.C2630a c2630a) {
        this.f8251K = null;
        m4696f();
        if (c2630a.f8367e == null) {
            this.f8262j = c2630a.f8366d;
            m4710a(c2630a.f8364b, 0, c2630a.f8363a, c2630a.f8365c, c2630a.f8366d);
        }
        InterfaceC2620f interfaceC2620f = this.f8278z;
        if (interfaceC2620f != null) {
            interfaceC2620f.mo4683a(this, c2630a.f8363a, c2630a.f8367e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4706a(BitmapCroppingWorkerTask.C2629a c2629a) {
        this.f8252L = null;
        m4696f();
        InterfaceC2616b interfaceC2616b = this.f8241A;
        if (interfaceC2616b != null) {
            interfaceC2616b.mo4687a(this, new C2615a(this.f8261i, this.f8242B, c2629a.f8353a, c2629a.f8354b, c2629a.f8355c, getCropPoints(), getCropRect(), getWholeImageRect(), getRotatedDegrees(), c2629a.f8357e));
        }
    }

    /* renamed from: a */
    private void m4710a(Bitmap bitmap, int i, Uri uri, int i2, int i3) {
        Bitmap bitmap2 = this.f8261i;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            this.f8253a.clearAnimation();
            m4699c();
            this.f8261i = bitmap;
            this.f8253a.setImageBitmap(this.f8261i);
            this.f8242B = uri;
            this.f8268p = i;
            this.f8243C = i2;
            this.f8263k = i3;
            m4715a(getWidth(), getHeight(), true, false);
            CropOverlayView cropOverlayView = this.f8254b;
            if (cropOverlayView != null) {
                cropOverlayView.m4672b();
                m4697e();
            }
        }
    }

    /* renamed from: c */
    private void m4699c() {
        if (this.f8261i != null && (this.f8268p > 0 || this.f8242B != null)) {
            this.f8261i.recycle();
        }
        this.f8261i = null;
        this.f8268p = 0;
        this.f8242B = null;
        this.f8243C = 1;
        this.f8263k = 0;
        this.f8244D = 1.0f;
        this.f8245E = 0.0f;
        this.f8246F = 0.0f;
        this.f8255c.reset();
        this.f8250J = null;
        this.f8253a.setImageBitmap(null);
        m4697e();
    }

    /* renamed from: a */
    public void m4711a(int i, int i2, RequestSizeOptions requestSizeOptions, Uri uri, Bitmap.CompressFormat compressFormat, int i3) {
        CropImageView cropImageView;
        Bitmap bitmap = this.f8261i;
        if (bitmap != null) {
            this.f8253a.clearAnimation();
            WeakReference<BitmapCroppingWorkerTask> weakReference = this.f8252L;
            BitmapCroppingWorkerTask bitmapCroppingWorkerTask = weakReference != null ? weakReference.get() : null;
            if (bitmapCroppingWorkerTask != null) {
                bitmapCroppingWorkerTask.cancel(true);
            }
            int i4 = requestSizeOptions != RequestSizeOptions.NONE ? i : 0;
            int i5 = requestSizeOptions != RequestSizeOptions.NONE ? i2 : 0;
            int width = bitmap.getWidth() * this.f8243C;
            int height = bitmap.getHeight();
            int i6 = this.f8243C;
            int i7 = height * i6;
            if (this.f8242B != null && (i6 > 1 || requestSizeOptions == RequestSizeOptions.SAMPLING)) {
                this.f8252L = new WeakReference<>(new BitmapCroppingWorkerTask(this, this.f8242B, getCropPoints(), this.f8263k, width, i7, this.f8254b.m4667c(), this.f8254b.getAspectRatioX(), this.f8254b.getAspectRatioY(), i4, i5, this.f8264l, this.f8265m, requestSizeOptions, uri, compressFormat, i3));
                cropImageView = this;
            } else {
                cropImageView = this;
                cropImageView.f8252L = new WeakReference<>(new BitmapCroppingWorkerTask(this, bitmap, getCropPoints(), this.f8263k, this.f8254b.m4667c(), this.f8254b.getAspectRatioX(), this.f8254b.getAspectRatioY(), i4, i5, this.f8264l, this.f8265m, requestSizeOptions, uri, compressFormat, i3));
            }
            cropImageView.f8252L.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            m4696f();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        BitmapLoadingWorkerTask bitmapLoadingWorkerTask;
        if (this.f8242B == null && this.f8261i == null && this.f8268p < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uri = this.f8242B;
        if (this.f8270r && uri == null && this.f8268p < 1) {
            uri = BitmapUtils.m4633a(getContext(), this.f8261i, this.f8250J);
            this.f8250J = uri;
        }
        if (uri != null && this.f8261i != null) {
            String uuid = UUID.randomUUID().toString();
            BitmapUtils.f8373f = new Pair<>(uuid, new WeakReference(this.f8261i));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid);
        }
        WeakReference<BitmapLoadingWorkerTask> weakReference = this.f8251K;
        if (weakReference != null && (bitmapLoadingWorkerTask = weakReference.get()) != null) {
            bundle.putParcelable("LOADING_IMAGE_URI", bitmapLoadingWorkerTask.m4641a());
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.f8268p);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.f8243C);
        bundle.putInt("DEGREES_ROTATED", this.f8263k);
        bundle.putParcelable("INITIAL_CROP_RECT", this.f8254b.getInitialCropWindowRect());
        BitmapUtils.f8370c.set(this.f8254b.getCropWindowRect());
        this.f8255c.invert(this.f8256d);
        this.f8256d.mapRect(BitmapUtils.f8370c);
        bundle.putParcelable("CROP_WINDOW_RECT", BitmapUtils.f8370c);
        bundle.putString("CROP_SHAPE", this.f8254b.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.f8273u);
        bundle.putInt("CROP_MAX_ZOOM", this.f8274v);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.f8264l);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.f8265m);
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.f8251K == null && this.f8242B == null && this.f8261i == null && this.f8268p == 0) {
                Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
                if (uri != null) {
                    String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        Bitmap bitmap = (BitmapUtils.f8373f == null || !((String) BitmapUtils.f8373f.first).equals(string)) ? null : (Bitmap) ((WeakReference) BitmapUtils.f8373f.second).get();
                        BitmapUtils.f8373f = null;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            m4710a(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                        }
                    }
                    if (this.f8242B == null) {
                        setImageUriAsync(uri);
                    }
                } else {
                    int i = bundle.getInt("LOADED_IMAGE_RESOURCE");
                    if (i > 0) {
                        setImageResource(i);
                    } else {
                        Uri uri2 = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                        if (uri2 != null) {
                            setImageUriAsync(uri2);
                        }
                    }
                }
                int i2 = bundle.getInt("DEGREES_ROTATED");
                this.f8248H = i2;
                this.f8263k = i2;
                Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
                if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                    this.f8254b.setInitialCropWindowRect(rect);
                }
                RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
                if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                    this.f8247G = rectF;
                }
                this.f8254b.setCropShape(CropShape.valueOf(bundle.getString("CROP_SHAPE")));
                this.f8273u = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.f8274v = bundle.getInt("CROP_MAX_ZOOM");
                this.f8264l = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
                this.f8265m = bundle.getBoolean("CROP_FLIP_VERTICALLY");
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int width;
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        Bitmap bitmap = this.f8261i;
        if (bitmap != null) {
            if (size2 == 0) {
                size2 = bitmap.getHeight();
            }
            double width2 = size < this.f8261i.getWidth() ? size / this.f8261i.getWidth() : Double.POSITIVE_INFINITY;
            double height = size2 < this.f8261i.getHeight() ? size2 / this.f8261i.getHeight() : Double.POSITIVE_INFINITY;
            if (width2 == Double.POSITIVE_INFINITY && height == Double.POSITIVE_INFINITY) {
                width = this.f8261i.getWidth();
                i3 = this.f8261i.getHeight();
            } else if (width2 <= height) {
                i3 = (int) (this.f8261i.getHeight() * width2);
                width = size;
            } else {
                width = (int) (this.f8261i.getWidth() * height);
                i3 = size2;
            }
            int m4713a = m4713a(mode, size, width);
            int m4713a2 = m4713a(mode2, size2, i3);
            this.f8266n = m4713a;
            this.f8267o = m4713a2;
            setMeasuredDimension(this.f8266n, this.f8267o);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f8266n > 0 && this.f8267o > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = this.f8266n;
            layoutParams.height = this.f8267o;
            setLayoutParams(layoutParams);
            if (this.f8261i != null) {
                float f = i3 - i;
                float f2 = i4 - i2;
                m4715a(f, f2, true, false);
                if (this.f8247G != null) {
                    int i5 = this.f8248H;
                    if (i5 != this.f8262j) {
                        this.f8263k = i5;
                        m4715a(f, f2, true, false);
                    }
                    this.f8255c.mapRect(this.f8247G);
                    this.f8254b.setCropWindowRect(this.f8247G);
                    m4703a(false, false);
                    this.f8254b.m4682a();
                    this.f8247G = null;
                    return;
                } else if (this.f8249I) {
                    this.f8249I = false;
                    m4703a(false, false);
                    return;
                } else {
                    return;
                }
            }
            m4704a(true);
            return;
        }
        m4704a(true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8249I = i3 > 0 && i4 > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4703a(boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.CropImageView.m4703a(boolean, boolean):void");
    }

    /* renamed from: a */
    private void m4715a(float f, float f2, boolean z, boolean z2) {
        if (this.f8261i != null) {
            if (f <= 0.0f || f2 <= 0.0f) {
                return;
            }
            this.f8255c.invert(this.f8256d);
            RectF cropWindowRect = this.f8254b.getCropWindowRect();
            this.f8256d.mapRect(cropWindowRect);
            this.f8255c.reset();
            this.f8255c.postTranslate((f - this.f8261i.getWidth()) / 2.0f, (f2 - this.f8261i.getHeight()) / 2.0f);
            m4698d();
            int i = this.f8263k;
            if (i > 0) {
                this.f8255c.postRotate(i, BitmapUtils.m4610g(this.f8258f), BitmapUtils.m4609h(this.f8258f));
                m4698d();
            }
            float min = Math.min(f / BitmapUtils.m4612e(this.f8258f), f2 / BitmapUtils.m4611f(this.f8258f));
            if (this.f8269q == ScaleType.FIT_CENTER || ((this.f8269q == ScaleType.CENTER_INSIDE && min < 1.0f) || (min > 1.0f && this.f8273u))) {
                this.f8255c.postScale(min, min, BitmapUtils.m4610g(this.f8258f), BitmapUtils.m4609h(this.f8258f));
                m4698d();
            }
            float f3 = this.f8264l ? -this.f8244D : this.f8244D;
            float f4 = this.f8265m ? -this.f8244D : this.f8244D;
            this.f8255c.postScale(f3, f4, BitmapUtils.m4610g(this.f8258f), BitmapUtils.m4609h(this.f8258f));
            m4698d();
            this.f8255c.mapRect(cropWindowRect);
            if (z) {
                this.f8245E = f > BitmapUtils.m4612e(this.f8258f) ? 0.0f : Math.max(Math.min((f / 2.0f) - cropWindowRect.centerX(), -BitmapUtils.m4617a(this.f8258f)), getWidth() - BitmapUtils.m4614c(this.f8258f)) / f3;
                this.f8246F = f2 <= BitmapUtils.m4611f(this.f8258f) ? Math.max(Math.min((f2 / 2.0f) - cropWindowRect.centerY(), -BitmapUtils.m4615b(this.f8258f)), getHeight() - BitmapUtils.m4613d(this.f8258f)) / f4 : 0.0f;
            } else {
                this.f8245E = Math.min(Math.max(this.f8245E * f3, -cropWindowRect.left), (-cropWindowRect.right) + f) / f3;
                this.f8246F = Math.min(Math.max(this.f8246F * f4, -cropWindowRect.top), (-cropWindowRect.bottom) + f2) / f4;
            }
            this.f8255c.postTranslate(this.f8245E * f3, this.f8246F * f4);
            cropWindowRect.offset(this.f8245E * f3, this.f8246F * f4);
            this.f8254b.setCropWindowRect(cropWindowRect);
            m4698d();
            this.f8254b.invalidate();
            if (z2) {
                this.f8260h.m4607b(this.f8258f, this.f8255c);
                this.f8253a.startAnimation(this.f8260h);
            } else {
                this.f8253a.setImageMatrix(this.f8255c);
            }
            m4704a(false);
        }
    }

    /* renamed from: d */
    private void m4698d() {
        float[] fArr = this.f8258f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = this.f8261i.getWidth();
        float[] fArr2 = this.f8258f;
        fArr2[3] = 0.0f;
        fArr2[4] = this.f8261i.getWidth();
        this.f8258f[5] = this.f8261i.getHeight();
        float[] fArr3 = this.f8258f;
        fArr3[6] = 0.0f;
        fArr3[7] = this.f8261i.getHeight();
        this.f8255c.mapPoints(this.f8258f);
        float[] fArr4 = this.f8259g;
        fArr4[0] = 0.0f;
        fArr4[1] = 0.0f;
        fArr4[2] = 100.0f;
        fArr4[3] = 0.0f;
        fArr4[4] = 100.0f;
        fArr4[5] = 100.0f;
        fArr4[6] = 0.0f;
        fArr4[7] = 100.0f;
        this.f8255c.mapPoints(fArr4);
    }

    /* renamed from: a */
    private static int m4713a(int i, int i2, int i3) {
        return i == 1073741824 ? i2 : i == Integer.MIN_VALUE ? Math.min(i3, i2) : i3;
    }

    /* renamed from: e */
    private void m4697e() {
        CropOverlayView cropOverlayView = this.f8254b;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.f8271s || this.f8261i == null) ? 4 : 0);
        }
    }

    /* renamed from: f */
    private void m4696f() {
        this.f8257e.setVisibility(this.f8272t && ((this.f8261i == null && this.f8251K != null) || this.f8252L != null) ? 0 : 4);
    }

    /* renamed from: a */
    private void m4704a(boolean z) {
        if (this.f8261i != null && !z) {
            this.f8254b.m4680a(getWidth(), getHeight(), (this.f8243C * 100.0f) / BitmapUtils.m4612e(this.f8259g), (this.f8243C * 100.0f) / BitmapUtils.m4611f(this.f8259g));
        }
        this.f8254b.m4673a(z ? null : this.f8258f, getWidth(), getHeight());
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$a */
    /* loaded from: classes2.dex */
    public static class C2615a {

        /* renamed from: a */
        private final Bitmap f8285a;

        /* renamed from: b */
        private final Uri f8286b;

        /* renamed from: c */
        private final Bitmap f8287c;

        /* renamed from: d */
        private final Uri f8288d;

        /* renamed from: e */
        private final Exception f8289e;

        /* renamed from: f */
        private final float[] f8290f;

        /* renamed from: g */
        private final Rect f8291g;

        /* renamed from: h */
        private final Rect f8292h;

        /* renamed from: i */
        private final int f8293i;

        /* renamed from: j */
        private final int f8294j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C2615a(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i, int i2) {
            this.f8285a = bitmap;
            this.f8286b = uri;
            this.f8287c = bitmap2;
            this.f8288d = uri2;
            this.f8289e = exc;
            this.f8290f = fArr;
            this.f8291g = rect;
            this.f8292h = rect2;
            this.f8293i = i;
            this.f8294j = i2;
        }

        /* renamed from: a */
        public Uri m4695a() {
            return this.f8286b;
        }

        /* renamed from: b */
        public Uri m4694b() {
            return this.f8288d;
        }

        /* renamed from: c */
        public Exception m4693c() {
            return this.f8289e;
        }

        /* renamed from: d */
        public float[] m4692d() {
            return this.f8290f;
        }

        /* renamed from: e */
        public Rect m4691e() {
            return this.f8291g;
        }

        /* renamed from: f */
        public Rect m4690f() {
            return this.f8292h;
        }

        /* renamed from: g */
        public int m4689g() {
            return this.f8293i;
        }

        /* renamed from: h */
        public int m4688h() {
            return this.f8294j;
        }
    }
}
