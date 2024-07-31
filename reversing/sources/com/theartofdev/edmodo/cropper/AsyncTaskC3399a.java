package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.theartofdev.edmodo.cropper.BitmapUtils;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.theartofdev.edmodo.cropper.a */
/* loaded from: classes2.dex */
public final class BitmapCroppingWorkerTask extends AsyncTask<Void, Void, C2629a> {

    /* renamed from: a */
    private final WeakReference<CropImageView> f8334a;

    /* renamed from: b */
    private final Bitmap f8335b;

    /* renamed from: c */
    private final Uri f8336c;

    /* renamed from: d */
    private final Context f8337d;

    /* renamed from: e */
    private final float[] f8338e;

    /* renamed from: f */
    private final int f8339f;

    /* renamed from: g */
    private final int f8340g;

    /* renamed from: h */
    private final int f8341h;

    /* renamed from: i */
    private final boolean f8342i;

    /* renamed from: j */
    private final int f8343j;

    /* renamed from: k */
    private final int f8344k;

    /* renamed from: l */
    private final int f8345l;

    /* renamed from: m */
    private final int f8346m;

    /* renamed from: n */
    private final boolean f8347n;

    /* renamed from: o */
    private final boolean f8348o;

    /* renamed from: p */
    private final CropImageView.RequestSizeOptions f8349p;

    /* renamed from: q */
    private final Uri f8350q;

    /* renamed from: r */
    private final Bitmap.CompressFormat f8351r;

    /* renamed from: s */
    private final int f8352s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapCroppingWorkerTask(CropImageView cropImageView, Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, int i4, int i5, boolean z2, boolean z3, CropImageView.RequestSizeOptions requestSizeOptions, Uri uri, Bitmap.CompressFormat compressFormat, int i6) {
        this.f8334a = new WeakReference<>(cropImageView);
        this.f8337d = cropImageView.getContext();
        this.f8335b = bitmap;
        this.f8338e = fArr;
        this.f8336c = null;
        this.f8339f = i;
        this.f8342i = z;
        this.f8343j = i2;
        this.f8344k = i3;
        this.f8345l = i4;
        this.f8346m = i5;
        this.f8347n = z2;
        this.f8348o = z3;
        this.f8349p = requestSizeOptions;
        this.f8350q = uri;
        this.f8351r = compressFormat;
        this.f8352s = i6;
        this.f8340g = 0;
        this.f8341h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapCroppingWorkerTask(CropImageView cropImageView, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3, CropImageView.RequestSizeOptions requestSizeOptions, Uri uri2, Bitmap.CompressFormat compressFormat, int i8) {
        this.f8334a = new WeakReference<>(cropImageView);
        this.f8337d = cropImageView.getContext();
        this.f8336c = uri;
        this.f8338e = fArr;
        this.f8339f = i;
        this.f8342i = z;
        this.f8343j = i4;
        this.f8344k = i5;
        this.f8340g = i2;
        this.f8341h = i3;
        this.f8345l = i6;
        this.f8346m = i7;
        this.f8347n = z2;
        this.f8348o = z3;
        this.f8349p = requestSizeOptions;
        this.f8350q = uri2;
        this.f8351r = compressFormat;
        this.f8352s = i8;
        this.f8335b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public C2629a doInBackground(Void... voidArr) {
        BitmapUtils.C2631a m4621a;
        try {
            if (isCancelled()) {
                return null;
            }
            if (this.f8336c != null) {
                m4621a = BitmapUtils.m4629a(this.f8337d, this.f8336c, this.f8338e, this.f8339f, this.f8340g, this.f8341h, this.f8342i, this.f8343j, this.f8344k, this.f8345l, this.f8346m, this.f8347n, this.f8348o);
            } else if (this.f8335b != null) {
                m4621a = BitmapUtils.m4621a(this.f8335b, this.f8338e, this.f8339f, this.f8342i, this.f8343j, this.f8344k, this.f8347n, this.f8348o);
            } else {
                return new C2629a((Bitmap) null, 1);
            }
            Bitmap m4626a = BitmapUtils.m4626a(m4621a.f8375a, this.f8345l, this.f8346m, this.f8349p);
            if (this.f8350q == null) {
                return new C2629a(m4626a, m4621a.f8376b);
            }
            BitmapUtils.m4632a(this.f8337d, m4626a, this.f8350q, this.f8351r, this.f8352s);
            if (m4626a != null) {
                m4626a.recycle();
            }
            return new C2629a(this.f8350q, m4621a.f8376b);
        } catch (Exception e) {
            return new C2629a(e, this.f8350q != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(C2629a c2629a) {
        CropImageView cropImageView;
        if (c2629a != null) {
            boolean z = false;
            if (!isCancelled() && (cropImageView = this.f8334a.get()) != null) {
                z = true;
                cropImageView.m4706a(c2629a);
            }
            if (z || c2629a.f8353a == null) {
                return;
            }
            c2629a.f8353a.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapCroppingWorkerTask.java */
    /* renamed from: com.theartofdev.edmodo.cropper.a$a */
    /* loaded from: classes2.dex */
    public static final class C2629a {

        /* renamed from: a */
        public final Bitmap f8353a;

        /* renamed from: b */
        public final Uri f8354b;

        /* renamed from: c */
        final Exception f8355c;

        /* renamed from: d */
        final boolean f8356d;

        /* renamed from: e */
        final int f8357e;

        C2629a(Bitmap bitmap, int i) {
            this.f8353a = bitmap;
            this.f8354b = null;
            this.f8355c = null;
            this.f8356d = false;
            this.f8357e = i;
        }

        C2629a(Uri uri, int i) {
            this.f8353a = null;
            this.f8354b = uri;
            this.f8355c = null;
            this.f8356d = true;
            this.f8357e = i;
        }

        C2629a(Exception exc, boolean z) {
            this.f8353a = null;
            this.f8354b = null;
            this.f8355c = exc;
            this.f8356d = z;
            this.f8357e = 1;
        }
    }
}
