package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class ScanBoxView extends View {

    /* renamed from: A */
    private int f189A;

    /* renamed from: B */
    private boolean f190B;

    /* renamed from: C */
    private String f191C;

    /* renamed from: D */
    private String f192D;

    /* renamed from: E */
    private String f193E;

    /* renamed from: F */
    private int f194F;

    /* renamed from: G */
    private int f195G;

    /* renamed from: H */
    private boolean f196H;

    /* renamed from: I */
    private int f197I;

    /* renamed from: J */
    private boolean f198J;

    /* renamed from: K */
    private int f199K;

    /* renamed from: L */
    private boolean f200L;

    /* renamed from: M */
    private boolean f201M;

    /* renamed from: N */
    private boolean f202N;

    /* renamed from: O */
    private Drawable f203O;

    /* renamed from: P */
    private Bitmap f204P;

    /* renamed from: Q */
    private float f205Q;

    /* renamed from: R */
    private float f206R;

    /* renamed from: S */
    private Bitmap f207S;

    /* renamed from: T */
    private Bitmap f208T;

    /* renamed from: U */
    private Bitmap f209U;

    /* renamed from: V */
    private Bitmap f210V;

    /* renamed from: W */
    private float f211W;

    /* renamed from: a */
    private int f212a;

    /* renamed from: aa */
    private StaticLayout f213aa;

    /* renamed from: ab */
    private int f214ab;

    /* renamed from: ac */
    private boolean f215ac;

    /* renamed from: ad */
    private boolean f216ad;

    /* renamed from: ae */
    private boolean f217ae;

    /* renamed from: af */
    private QRCodeView f218af;

    /* renamed from: b */
    private int f219b;

    /* renamed from: c */
    private Rect f220c;

    /* renamed from: d */
    private float f221d;

    /* renamed from: e */
    private float f222e;

    /* renamed from: f */
    private Paint f223f;

    /* renamed from: g */
    private TextPaint f224g;

    /* renamed from: h */
    private int f225h;

    /* renamed from: i */
    private int f226i;

    /* renamed from: j */
    private int f227j;

    /* renamed from: k */
    private int f228k;

    /* renamed from: l */
    private int f229l;

    /* renamed from: m */
    private int f230m;

    /* renamed from: n */
    private int f231n;

    /* renamed from: o */
    private int f232o;

    /* renamed from: p */
    private int f233p;

    /* renamed from: q */
    private int f234q;

    /* renamed from: r */
    private int f235r;

    /* renamed from: s */
    private boolean f236s;

    /* renamed from: t */
    private Drawable f237t;

    /* renamed from: u */
    private Bitmap f238u;

    /* renamed from: v */
    private int f239v;

    /* renamed from: w */
    private int f240w;

    /* renamed from: x */
    private int f241x;

    /* renamed from: y */
    private float f242y;

    /* renamed from: z */
    private int f243z;

    public ScanBoxView(Context context) {
        super(context);
        this.f223f = new Paint();
        this.f223f.setAntiAlias(true);
        this.f225h = Color.parseColor("#33FFFFFF");
        this.f226i = -1;
        this.f227j = BGAQRCodeUtil.m12726a(context, 20.0f);
        this.f228k = BGAQRCodeUtil.m12726a(context, 3.0f);
        this.f233p = BGAQRCodeUtil.m12726a(context, 1.0f);
        this.f234q = -1;
        this.f232o = BGAQRCodeUtil.m12726a(context, 90.0f);
        this.f229l = BGAQRCodeUtil.m12726a(context, 200.0f);
        this.f231n = BGAQRCodeUtil.m12726a(context, 140.0f);
        this.f235r = 0;
        this.f236s = false;
        this.f237t = null;
        this.f238u = null;
        this.f239v = BGAQRCodeUtil.m12726a(context, 1.0f);
        this.f240w = -1;
        this.f241x = 1000;
        this.f242y = -1.0f;
        this.f243z = 1;
        this.f189A = 0;
        this.f190B = false;
        this.f212a = BGAQRCodeUtil.m12726a(context, 2.0f);
        this.f193E = null;
        this.f194F = BGAQRCodeUtil.m12719b(context, 14.0f);
        this.f195G = -1;
        this.f196H = false;
        this.f197I = BGAQRCodeUtil.m12726a(context, 20.0f);
        this.f198J = false;
        this.f199K = Color.parseColor("#22000000");
        this.f200L = false;
        this.f201M = false;
        this.f202N = false;
        this.f224g = new TextPaint();
        this.f224g.setAntiAlias(true);
        this.f214ab = BGAQRCodeUtil.m12726a(context, 4.0f);
        this.f215ac = false;
        this.f216ad = false;
        this.f217ae = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12741a(QRCodeView qRCodeView, AttributeSet attributeSet) {
        this.f218af = qRCodeView;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            m12743a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        m12736d();
    }

    /* renamed from: a */
    private void m12743a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.f232o = typedArray.getDimensionPixelSize(i, this.f232o);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.f228k = typedArray.getDimensionPixelSize(i, this.f228k);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.f227j = typedArray.getDimensionPixelSize(i, this.f227j);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.f233p = typedArray.getDimensionPixelSize(i, this.f233p);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.f229l = typedArray.getDimensionPixelSize(i, this.f229l);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.f225h = typedArray.getColor(i, this.f225h);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerColor) {
            this.f226i = typedArray.getColor(i, this.f226i);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.f234q = typedArray.getColor(i, this.f234q);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.f235r = typedArray.getDimensionPixelSize(i, this.f235r);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.f236s = typedArray.getBoolean(i, this.f236s);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.f237t = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.f239v = typedArray.getDimensionPixelSize(i, this.f239v);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.f240w = typedArray.getColor(i, this.f240w);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.f241x = typedArray.getInteger(i, this.f241x);
        } else if (i == R.styleable.QRCodeView_qrcv_verticalBias) {
            this.f242y = typedArray.getFloat(i, this.f242y);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerDisplayType) {
            this.f243z = typedArray.getInteger(i, this.f243z);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.f189A = typedArray.getDimensionPixelSize(i, this.f189A);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.f231n = typedArray.getDimensionPixelSize(i, this.f231n);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.f190B = typedArray.getBoolean(i, this.f190B);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.f192D = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.f191C = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.f194F = typedArray.getDimensionPixelSize(i, this.f194F);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.f195G = typedArray.getColor(i, this.f195G);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.f196H = typedArray.getBoolean(i, this.f196H);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.f197I = typedArray.getDimensionPixelSize(i, this.f197I);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.f198J = typedArray.getBoolean(i, this.f198J);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.f200L = typedArray.getBoolean(i, this.f200L);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.f199K = typedArray.getColor(i, this.f199K);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.f201M = typedArray.getBoolean(i, this.f201M);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.f202N = typedArray.getBoolean(i, this.f202N);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.f203O = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.f215ac = typedArray.getBoolean(i, this.f215ac);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowLocationPoint) {
            this.f216ad = typedArray.getBoolean(i, this.f216ad);
        } else if (i == R.styleable.QRCodeView_qrcv_isAutoZoom) {
            this.f217ae = typedArray.getBoolean(i, this.f217ae);
        }
    }

    /* renamed from: d */
    private void m12736d() {
        Drawable drawable = this.f203O;
        if (drawable != null) {
            this.f209U = ((BitmapDrawable) drawable).getBitmap();
        }
        if (this.f209U == null) {
            this.f209U = BitmapFactory.decodeResource(getResources(), R.mipmap.qrcode_default_grid_scan_line);
            this.f209U = BGAQRCodeUtil.m12718b(this.f209U, this.f234q);
        }
        this.f210V = BGAQRCodeUtil.m12725a(this.f209U, 90);
        this.f210V = BGAQRCodeUtil.m12725a(this.f210V, 90);
        this.f210V = BGAQRCodeUtil.m12725a(this.f210V, 90);
        Drawable drawable2 = this.f237t;
        if (drawable2 != null) {
            this.f207S = ((BitmapDrawable) drawable2).getBitmap();
        }
        if (this.f207S == null) {
            this.f207S = BitmapFactory.decodeResource(getResources(), R.mipmap.qrcode_default_scan_line);
            this.f207S = BGAQRCodeUtil.m12718b(this.f207S, this.f234q);
        }
        this.f208T = BGAQRCodeUtil.m12725a(this.f207S, 90);
        this.f232o += this.f189A;
        this.f211W = (this.f228k * 1.0f) / 2.0f;
        this.f224g.setTextSize(this.f194F);
        this.f224g.setColor(this.f195G);
        setIsBarcode(this.f190B);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f220c == null) {
            return;
        }
        m12742a(canvas);
        m12739b(canvas);
        m12737c(canvas);
        m12735d(canvas);
        m12733e(canvas);
        m12734e();
    }

    /* renamed from: a */
    private void m12742a(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.f225h != 0) {
            this.f223f.setStyle(Paint.Style.FILL);
            this.f223f.setColor(this.f225h);
            float f = width;
            canvas.drawRect(0.0f, 0.0f, f, this.f220c.top, this.f223f);
            canvas.drawRect(0.0f, this.f220c.top, this.f220c.left, this.f220c.bottom + 1, this.f223f);
            canvas.drawRect(this.f220c.right + 1, this.f220c.top, f, this.f220c.bottom + 1, this.f223f);
            canvas.drawRect(0.0f, this.f220c.bottom + 1, f, height, this.f223f);
        }
    }

    /* renamed from: b */
    private void m12739b(Canvas canvas) {
        if (this.f239v > 0) {
            this.f223f.setStyle(Paint.Style.STROKE);
            this.f223f.setColor(this.f240w);
            this.f223f.setStrokeWidth(this.f239v);
            canvas.drawRect(this.f220c, this.f223f);
        }
    }

    /* renamed from: c */
    private void m12737c(Canvas canvas) {
        if (this.f211W > 0.0f) {
            this.f223f.setStyle(Paint.Style.STROKE);
            this.f223f.setColor(this.f226i);
            this.f223f.setStrokeWidth(this.f228k);
            int i = this.f243z;
            if (i == 1) {
                canvas.drawLine(this.f220c.left - this.f211W, this.f220c.top, (this.f220c.left - this.f211W) + this.f227j, this.f220c.top, this.f223f);
                canvas.drawLine(this.f220c.left, this.f220c.top - this.f211W, this.f220c.left, (this.f220c.top - this.f211W) + this.f227j, this.f223f);
                canvas.drawLine(this.f220c.right + this.f211W, this.f220c.top, (this.f220c.right + this.f211W) - this.f227j, this.f220c.top, this.f223f);
                canvas.drawLine(this.f220c.right, this.f220c.top - this.f211W, this.f220c.right, (this.f220c.top - this.f211W) + this.f227j, this.f223f);
                canvas.drawLine(this.f220c.left - this.f211W, this.f220c.bottom, (this.f220c.left - this.f211W) + this.f227j, this.f220c.bottom, this.f223f);
                canvas.drawLine(this.f220c.left, this.f220c.bottom + this.f211W, this.f220c.left, (this.f220c.bottom + this.f211W) - this.f227j, this.f223f);
                canvas.drawLine(this.f220c.right + this.f211W, this.f220c.bottom, (this.f220c.right + this.f211W) - this.f227j, this.f220c.bottom, this.f223f);
                canvas.drawLine(this.f220c.right, this.f220c.bottom + this.f211W, this.f220c.right, (this.f220c.bottom + this.f211W) - this.f227j, this.f223f);
            } else if (i == 2) {
                canvas.drawLine(this.f220c.left, this.f220c.top + this.f211W, this.f220c.left + this.f227j, this.f220c.top + this.f211W, this.f223f);
                canvas.drawLine(this.f220c.left + this.f211W, this.f220c.top, this.f220c.left + this.f211W, this.f220c.top + this.f227j, this.f223f);
                canvas.drawLine(this.f220c.right, this.f220c.top + this.f211W, this.f220c.right - this.f227j, this.f220c.top + this.f211W, this.f223f);
                canvas.drawLine(this.f220c.right - this.f211W, this.f220c.top, this.f220c.right - this.f211W, this.f220c.top + this.f227j, this.f223f);
                canvas.drawLine(this.f220c.left, this.f220c.bottom - this.f211W, this.f220c.left + this.f227j, this.f220c.bottom - this.f211W, this.f223f);
                canvas.drawLine(this.f220c.left + this.f211W, this.f220c.bottom, this.f220c.left + this.f211W, this.f220c.bottom - this.f227j, this.f223f);
                canvas.drawLine(this.f220c.right, this.f220c.bottom - this.f211W, this.f220c.right - this.f227j, this.f220c.bottom - this.f211W, this.f223f);
                canvas.drawLine(this.f220c.right - this.f211W, this.f220c.bottom, this.f220c.right - this.f211W, this.f220c.bottom - this.f227j, this.f223f);
            }
        }
    }

    /* renamed from: d */
    private void m12735d(Canvas canvas) {
        if (this.f190B) {
            if (this.f204P != null) {
                RectF rectF = new RectF(this.f220c.left + this.f211W + 0.5f, this.f220c.top + this.f211W + this.f235r, this.f206R, (this.f220c.bottom - this.f211W) - this.f235r);
                Rect rect = new Rect((int) (this.f204P.getWidth() - rectF.width()), 0, this.f204P.getWidth(), this.f204P.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.f204P, rect, rectF, this.f223f);
            } else if (this.f238u != null) {
                canvas.drawBitmap(this.f238u, (Rect) null, new RectF(this.f222e, this.f220c.top + this.f211W + this.f235r, this.f222e + this.f238u.getWidth(), (this.f220c.bottom - this.f211W) - this.f235r), this.f223f);
            } else {
                this.f223f.setStyle(Paint.Style.FILL);
                this.f223f.setColor(this.f234q);
                canvas.drawRect(this.f222e, this.f220c.top + this.f211W + this.f235r, this.f222e + this.f233p, (this.f220c.bottom - this.f211W) - this.f235r, this.f223f);
            }
        } else if (this.f204P != null) {
            RectF rectF2 = new RectF(this.f220c.left + this.f211W + this.f235r, this.f220c.top + this.f211W + 0.5f, (this.f220c.right - this.f211W) - this.f235r, this.f205Q);
            Rect rect2 = new Rect(0, (int) (this.f204P.getHeight() - rectF2.height()), this.f204P.getWidth(), this.f204P.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            canvas.drawBitmap(this.f204P, rect2, rectF2, this.f223f);
        } else if (this.f238u != null) {
            canvas.drawBitmap(this.f238u, (Rect) null, new RectF(this.f220c.left + this.f211W + this.f235r, this.f221d, (this.f220c.right - this.f211W) - this.f235r, this.f221d + this.f238u.getHeight()), this.f223f);
        } else {
            this.f223f.setStyle(Paint.Style.FILL);
            this.f223f.setColor(this.f234q);
            canvas.drawRect(this.f220c.left + this.f211W + this.f235r, this.f221d, (this.f220c.right - this.f211W) - this.f235r, this.f221d + this.f233p, this.f223f);
        }
    }

    /* renamed from: e */
    private void m12733e(Canvas canvas) {
        if (TextUtils.isEmpty(this.f193E) || this.f213aa == null) {
            return;
        }
        if (this.f196H) {
            if (this.f200L) {
                this.f223f.setColor(this.f199K);
                this.f223f.setStyle(Paint.Style.FILL);
                if (this.f198J) {
                    Rect rect = new Rect();
                    TextPaint textPaint = this.f224g;
                    String str = this.f193E;
                    textPaint.getTextBounds(str, 0, str.length(), rect);
                    float width = ((canvas.getWidth() - rect.width()) / 2) - this.f214ab;
                    RectF rectF = new RectF(width, (this.f220c.bottom + this.f197I) - this.f214ab, rect.width() + width + (this.f214ab * 2), this.f220c.bottom + this.f197I + this.f213aa.getHeight() + this.f214ab);
                    int i = this.f214ab;
                    canvas.drawRoundRect(rectF, i, i, this.f223f);
                } else {
                    RectF rectF2 = new RectF(this.f220c.left, (this.f220c.bottom + this.f197I) - this.f214ab, this.f220c.right, this.f220c.bottom + this.f197I + this.f213aa.getHeight() + this.f214ab);
                    int i2 = this.f214ab;
                    canvas.drawRoundRect(rectF2, i2, i2, this.f223f);
                }
            }
            canvas.save();
            if (this.f198J) {
                canvas.translate(0.0f, this.f220c.bottom + this.f197I);
            } else {
                canvas.translate(this.f220c.left + this.f214ab, this.f220c.bottom + this.f197I);
            }
            this.f213aa.draw(canvas);
            canvas.restore();
            return;
        }
        if (this.f200L) {
            this.f223f.setColor(this.f199K);
            this.f223f.setStyle(Paint.Style.FILL);
            if (this.f198J) {
                Rect rect2 = new Rect();
                TextPaint textPaint2 = this.f224g;
                String str2 = this.f193E;
                textPaint2.getTextBounds(str2, 0, str2.length(), rect2);
                float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.f214ab;
                RectF rectF3 = new RectF(width2, ((this.f220c.top - this.f197I) - this.f213aa.getHeight()) - this.f214ab, rect2.width() + width2 + (this.f214ab * 2), (this.f220c.top - this.f197I) + this.f214ab);
                int i3 = this.f214ab;
                canvas.drawRoundRect(rectF3, i3, i3, this.f223f);
            } else {
                RectF rectF4 = new RectF(this.f220c.left, ((this.f220c.top - this.f197I) - this.f213aa.getHeight()) - this.f214ab, this.f220c.right, (this.f220c.top - this.f197I) + this.f214ab);
                int i4 = this.f214ab;
                canvas.drawRoundRect(rectF4, i4, i4, this.f223f);
            }
        }
        canvas.save();
        if (this.f198J) {
            canvas.translate(0.0f, (this.f220c.top - this.f197I) - this.f213aa.getHeight());
        } else {
            canvas.translate(this.f220c.left + this.f214ab, (this.f220c.top - this.f197I) - this.f213aa.getHeight());
        }
        this.f213aa.draw(canvas);
        canvas.restore();
    }

    /* renamed from: e */
    private void m12734e() {
        if (this.f190B) {
            if (this.f204P == null) {
                this.f222e += this.f212a;
                int i = this.f233p;
                Bitmap bitmap = this.f238u;
                if (bitmap != null) {
                    i = bitmap.getWidth();
                }
                if (this.f201M) {
                    if (this.f222e + i > this.f220c.right - this.f211W || this.f222e < this.f220c.left + this.f211W) {
                        this.f212a = -this.f212a;
                    }
                } else if (this.f222e + i > this.f220c.right - this.f211W) {
                    this.f222e = this.f220c.left + this.f211W + 0.5f;
                }
            } else {
                this.f206R += this.f212a;
                if (this.f206R > this.f220c.right - this.f211W) {
                    this.f206R = this.f220c.left + this.f211W + 0.5f;
                }
            }
        } else if (this.f204P == null) {
            this.f221d += this.f212a;
            int i2 = this.f233p;
            Bitmap bitmap2 = this.f238u;
            if (bitmap2 != null) {
                i2 = bitmap2.getHeight();
            }
            if (this.f201M) {
                if (this.f221d + i2 > this.f220c.bottom - this.f211W || this.f221d < this.f220c.top + this.f211W) {
                    this.f212a = -this.f212a;
                }
            } else if (this.f221d + i2 > this.f220c.bottom - this.f211W) {
                this.f221d = this.f220c.top + this.f211W + 0.5f;
            }
        } else {
            this.f205Q += this.f212a;
            if (this.f205Q > this.f220c.bottom - this.f211W) {
                this.f205Q = this.f220c.top + this.f211W + 0.5f;
            }
        }
        postInvalidateDelayed(this.f219b, this.f220c.left, this.f220c.top, this.f220c.right, this.f220c.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m12732f();
    }

    /* renamed from: f */
    private void m12732f() {
        int width = getWidth();
        int i = this.f229l;
        int i2 = (width - i) / 2;
        int i3 = this.f232o;
        this.f220c = new Rect(i2, i3, i + i2, this.f230m + i3);
        if (this.f190B) {
            float f = this.f220c.left + this.f211W + 0.5f;
            this.f222e = f;
            this.f206R = f;
        } else {
            float f2 = this.f220c.top + this.f211W + 0.5f;
            this.f221d = f2;
            this.f205Q = f2;
        }
        if (this.f218af == null || !m12745a()) {
            return;
        }
        this.f218af.m12770a(new Rect(this.f220c));
    }

    /* renamed from: a */
    public Rect m12744a(int i) {
        if (this.f215ac && getVisibility() == 0) {
            Rect rect = new Rect(this.f220c);
            float measuredHeight = (i * 1.0f) / getMeasuredHeight();
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            float width = (rect.width() / 2.0f) * measuredHeight;
            float height = (rect.height() / 2.0f) * measuredHeight;
            rect.left = (int) (exactCenterX - width);
            rect.right = (int) (exactCenterX + width);
            rect.top = (int) (exactCenterY - height);
            rect.bottom = (int) (exactCenterY + height);
            return rect;
        }
        return null;
    }

    public void setIsBarcode(boolean z) {
        this.f190B = z;
        m12731g();
    }

    /* renamed from: g */
    private void m12731g() {
        if (this.f203O != null || this.f202N) {
            if (this.f190B) {
                this.f204P = this.f210V;
            } else {
                this.f204P = this.f209U;
            }
        } else if (this.f237t != null || this.f236s) {
            if (this.f190B) {
                this.f238u = this.f208T;
            } else {
                this.f238u = this.f207S;
            }
        }
        if (this.f190B) {
            this.f193E = this.f192D;
            this.f230m = this.f231n;
            this.f219b = (int) (((this.f241x * 1.0f) * this.f212a) / this.f229l);
        } else {
            this.f193E = this.f191C;
            this.f230m = this.f229l;
            this.f219b = (int) (((this.f241x * 1.0f) * this.f212a) / this.f230m);
        }
        if (!TextUtils.isEmpty(this.f193E)) {
            if (this.f198J) {
                this.f213aa = new StaticLayout(this.f193E, this.f224g, BGAQRCodeUtil.m12720b(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.f213aa = new StaticLayout(this.f193E, this.f224g, this.f229l - (this.f214ab * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.f242y != -1.0f) {
            int m12716c = BGAQRCodeUtil.m12720b(getContext()).y - BGAQRCodeUtil.m12716c(getContext());
            int i = this.f189A;
            if (i == 0) {
                this.f232o = (int) ((m12716c * this.f242y) - (this.f230m / 2));
            } else {
                this.f232o = i + ((int) (((m12716c - i) * this.f242y) - (this.f230m / 2)));
            }
        }
        m12732f();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.f190B;
    }

    public int getMaskColor() {
        return this.f225h;
    }

    public void setMaskColor(int i) {
        this.f225h = i;
        m12731g();
    }

    public int getCornerColor() {
        return this.f226i;
    }

    public void setCornerColor(int i) {
        this.f226i = i;
        m12731g();
    }

    public int getCornerLength() {
        return this.f227j;
    }

    public void setCornerLength(int i) {
        this.f227j = i;
        m12731g();
    }

    public int getCornerSize() {
        return this.f228k;
    }

    public void setCornerSize(int i) {
        this.f228k = i;
        m12731g();
    }

    public int getRectWidth() {
        return this.f229l;
    }

    public void setRectWidth(int i) {
        this.f229l = i;
        m12731g();
    }

    public int getRectHeight() {
        return this.f230m;
    }

    public void setRectHeight(int i) {
        this.f230m = i;
        m12731g();
    }

    public int getBarcodeRectHeight() {
        return this.f231n;
    }

    public void setBarcodeRectHeight(int i) {
        this.f231n = i;
        m12731g();
    }

    public int getTopOffset() {
        return this.f232o;
    }

    public void setTopOffset(int i) {
        this.f232o = i;
        m12731g();
    }

    public int getScanLineSize() {
        return this.f233p;
    }

    public void setScanLineSize(int i) {
        this.f233p = i;
        m12731g();
    }

    public int getScanLineColor() {
        return this.f234q;
    }

    public void setScanLineColor(int i) {
        this.f234q = i;
        m12731g();
    }

    public int getScanLineMargin() {
        return this.f235r;
    }

    public void setScanLineMargin(int i) {
        this.f235r = i;
        m12731g();
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.f236s = z;
        m12731g();
    }

    public Drawable getCustomScanLineDrawable() {
        return this.f237t;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.f237t = drawable;
        m12731g();
    }

    public Bitmap getScanLineBitmap() {
        return this.f238u;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.f238u = bitmap;
        m12731g();
    }

    public int getBorderSize() {
        return this.f239v;
    }

    public void setBorderSize(int i) {
        this.f239v = i;
        m12731g();
    }

    public int getBorderColor() {
        return this.f240w;
    }

    public void setBorderColor(int i) {
        this.f240w = i;
        m12731g();
    }

    public int getAnimTime() {
        return this.f241x;
    }

    public void setAnimTime(int i) {
        this.f241x = i;
        m12731g();
    }

    public float getVerticalBias() {
        return this.f242y;
    }

    public void setVerticalBias(float f) {
        this.f242y = f;
        m12731g();
    }

    public int getToolbarHeight() {
        return this.f189A;
    }

    public void setToolbarHeight(int i) {
        this.f189A = i;
        m12731g();
    }

    public String getQRCodeTipText() {
        return this.f191C;
    }

    public void setQRCodeTipText(String str) {
        this.f191C = str;
        m12731g();
    }

    public String getBarCodeTipText() {
        return this.f192D;
    }

    public void setBarCodeTipText(String str) {
        this.f192D = str;
        m12731g();
    }

    public String getTipText() {
        return this.f193E;
    }

    public void setTipText(String str) {
        if (this.f190B) {
            this.f192D = str;
        } else {
            this.f191C = str;
        }
        m12731g();
    }

    public int getTipTextColor() {
        return this.f195G;
    }

    public void setTipTextColor(int i) {
        this.f195G = i;
        this.f224g.setColor(this.f195G);
        m12731g();
    }

    public int getTipTextSize() {
        return this.f194F;
    }

    public void setTipTextSize(int i) {
        this.f194F = i;
        this.f224g.setTextSize(this.f194F);
        m12731g();
    }

    public void setTipTextBelowRect(boolean z) {
        this.f196H = z;
        m12731g();
    }

    public int getTipTextMargin() {
        return this.f197I;
    }

    public void setTipTextMargin(int i) {
        this.f197I = i;
        m12731g();
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.f198J = z;
        m12731g();
    }

    public void setShowTipBackground(boolean z) {
        this.f200L = z;
        m12731g();
    }

    public int getTipBackgroundColor() {
        return this.f199K;
    }

    public void setTipBackgroundColor(int i) {
        this.f199K = i;
        m12731g();
    }

    public void setScanLineReverse(boolean z) {
        this.f201M = z;
        m12731g();
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.f202N = z;
        m12731g();
    }

    public float getHalfCornerSize() {
        return this.f211W;
    }

    public void setHalfCornerSize(float f) {
        this.f211W = f;
        m12731g();
    }

    public StaticLayout getTipTextSl() {
        return this.f213aa;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.f213aa = staticLayout;
        m12731g();
    }

    public int getTipBackgroundRadius() {
        return this.f214ab;
    }

    public void setTipBackgroundRadius(int i) {
        this.f214ab = i;
        m12731g();
    }

    /* renamed from: a */
    public boolean m12745a() {
        return this.f215ac;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.f215ac = z;
        m12732f();
    }

    /* renamed from: b */
    public boolean m12740b() {
        return this.f216ad;
    }

    public void setShowLocationPoint(boolean z) {
        this.f216ad = z;
    }

    /* renamed from: c */
    public boolean m12738c() {
        return this.f217ae;
    }

    public void setAutoZoom(boolean z) {
        this.f217ae = z;
    }
}
