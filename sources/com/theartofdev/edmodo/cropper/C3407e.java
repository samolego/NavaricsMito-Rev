package com.theartofdev.edmodo.cropper;

import android.graphics.RectF;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.theartofdev.edmodo.cropper.CropWindowMoveHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.theartofdev.edmodo.cropper.e */
/* loaded from: classes2.dex */
public final class CropWindowHandler {

    /* renamed from: c */
    private float f8392c;

    /* renamed from: d */
    private float f8393d;

    /* renamed from: e */
    private float f8394e;

    /* renamed from: f */
    private float f8395f;

    /* renamed from: g */
    private float f8396g;

    /* renamed from: h */
    private float f8397h;

    /* renamed from: i */
    private float f8398i;

    /* renamed from: j */
    private float f8399j;

    /* renamed from: a */
    private final RectF f8390a = new RectF();

    /* renamed from: b */
    private final RectF f8391b = new RectF();

    /* renamed from: k */
    private float f8400k = 1.0f;

    /* renamed from: l */
    private float f8401l = 1.0f;

    /* renamed from: c */
    private static boolean m4594c(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f5 && f2 > f4 && f2 < f6;
    }

    /* renamed from: a */
    public RectF m4606a() {
        this.f8391b.set(this.f8390a);
        return this.f8391b;
    }

    /* renamed from: b */
    public float m4597b() {
        return Math.max(this.f8392c, this.f8396g / this.f8400k);
    }

    /* renamed from: c */
    public float m4595c() {
        return Math.max(this.f8393d, this.f8397h / this.f8401l);
    }

    /* renamed from: d */
    public float m4593d() {
        return Math.min(this.f8394e, this.f8398i / this.f8400k);
    }

    /* renamed from: e */
    public float m4592e() {
        return Math.min(this.f8395f, this.f8399j / this.f8401l);
    }

    /* renamed from: f */
    public float m4591f() {
        return this.f8400k;
    }

    /* renamed from: g */
    public float m4590g() {
        return this.f8401l;
    }

    /* renamed from: a */
    public void m4603a(float f, float f2, float f3, float f4) {
        this.f8394e = f;
        this.f8395f = f2;
        this.f8400k = f3;
        this.f8401l = f4;
    }

    /* renamed from: a */
    public void m4598a(CropImageOptions cropImageOptions) {
        this.f8392c = cropImageOptions.f8238x;
        this.f8393d = cropImageOptions.f8239y;
        this.f8396g = cropImageOptions.f8240z;
        this.f8397h = cropImageOptions.f8193A;
        this.f8398i = cropImageOptions.f8194B;
        this.f8399j = cropImageOptions.f8195C;
    }

    /* renamed from: a */
    public void m4599a(RectF rectF) {
        this.f8390a.set(rectF);
    }

    /* renamed from: h */
    public boolean m4589h() {
        return this.f8390a.width() >= 100.0f && this.f8390a.height() >= 100.0f;
    }

    /* renamed from: a */
    public CropWindowMoveHandler m4600a(float f, float f2, float f3, CropImageView.CropShape cropShape) {
        CropWindowMoveHandler.Type m4604a;
        if (cropShape == CropImageView.CropShape.OVAL) {
            m4604a = m4605a(f, f2);
        } else {
            m4604a = m4604a(f, f2, f3);
        }
        if (m4604a != null) {
            return new CropWindowMoveHandler(m4604a, this, f, f2);
        }
        return null;
    }

    /* renamed from: a */
    private CropWindowMoveHandler.Type m4604a(float f, float f2, float f3) {
        if (m4602a(f, f2, this.f8390a.left, this.f8390a.top, f3)) {
            return CropWindowMoveHandler.Type.TOP_LEFT;
        }
        if (m4602a(f, f2, this.f8390a.right, this.f8390a.top, f3)) {
            return CropWindowMoveHandler.Type.TOP_RIGHT;
        }
        if (m4602a(f, f2, this.f8390a.left, this.f8390a.bottom, f3)) {
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        }
        if (m4602a(f, f2, this.f8390a.right, this.f8390a.bottom, f3)) {
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
        if (m4594c(f, f2, this.f8390a.left, this.f8390a.top, this.f8390a.right, this.f8390a.bottom) && m4588i()) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        if (m4601a(f, f2, this.f8390a.left, this.f8390a.right, this.f8390a.top, f3)) {
            return CropWindowMoveHandler.Type.TOP;
        }
        if (m4601a(f, f2, this.f8390a.left, this.f8390a.right, this.f8390a.bottom, f3)) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        if (m4596b(f, f2, this.f8390a.left, this.f8390a.top, this.f8390a.bottom, f3)) {
            return CropWindowMoveHandler.Type.LEFT;
        }
        if (m4596b(f, f2, this.f8390a.right, this.f8390a.top, this.f8390a.bottom, f3)) {
            return CropWindowMoveHandler.Type.RIGHT;
        }
        if (!m4594c(f, f2, this.f8390a.left, this.f8390a.top, this.f8390a.right, this.f8390a.bottom) || m4588i()) {
            return null;
        }
        return CropWindowMoveHandler.Type.CENTER;
    }

    /* renamed from: a */
    private CropWindowMoveHandler.Type m4605a(float f, float f2) {
        float width = this.f8390a.width() / 6.0f;
        float f3 = this.f8390a.left + width;
        float f4 = this.f8390a.left + (width * 5.0f);
        float height = this.f8390a.height() / 6.0f;
        float f5 = this.f8390a.top + height;
        float f6 = this.f8390a.top + (height * 5.0f);
        if (f < f3) {
            if (f2 < f5) {
                return CropWindowMoveHandler.Type.TOP_LEFT;
            }
            if (f2 < f6) {
                return CropWindowMoveHandler.Type.LEFT;
            }
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        } else if (f < f4) {
            if (f2 < f5) {
                return CropWindowMoveHandler.Type.TOP;
            }
            if (f2 < f6) {
                return CropWindowMoveHandler.Type.CENTER;
            }
            return CropWindowMoveHandler.Type.BOTTOM;
        } else if (f2 < f5) {
            return CropWindowMoveHandler.Type.TOP_RIGHT;
        } else {
            if (f2 < f6) {
                return CropWindowMoveHandler.Type.RIGHT;
            }
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
    }

    /* renamed from: a */
    private static boolean m4602a(float f, float f2, float f3, float f4, float f5) {
        return Math.abs(f - f3) <= f5 && Math.abs(f2 - f4) <= f5;
    }

    /* renamed from: a */
    private static boolean m4601a(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f4 && Math.abs(f2 - f5) <= f6;
    }

    /* renamed from: b */
    private static boolean m4596b(float f, float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f - f3) <= f6 && f2 > f4 && f2 < f5;
    }

    /* renamed from: i */
    private boolean m4588i() {
        return !m4589h();
    }
}
