package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import com.theartofdev.edmodo.cropper.BitmapUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.theartofdev.edmodo.cropper.b */
/* loaded from: classes2.dex */
public final class BitmapLoadingWorkerTask extends AsyncTask<Void, Void, C2630a> {

    /* renamed from: a */
    private final WeakReference<CropImageView> f8358a;

    /* renamed from: b */
    private final Uri f8359b;

    /* renamed from: c */
    private final Context f8360c;

    /* renamed from: d */
    private final int f8361d;

    /* renamed from: e */
    private final int f8362e;

    public BitmapLoadingWorkerTask(CropImageView cropImageView, Uri uri) {
        this.f8359b = uri;
        this.f8358a = new WeakReference<>(cropImageView);
        this.f8360c = cropImageView.getContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        double d = displayMetrics.density > 1.0f ? 1.0f / displayMetrics.density : 1.0d;
        this.f8361d = (int) (displayMetrics.widthPixels * d);
        this.f8362e = (int) (displayMetrics.heightPixels * d);
    }

    /* renamed from: a */
    public Uri m4641a() {
        return this.f8359b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public C2630a doInBackground(Void... voidArr) {
        try {
            if (isCancelled()) {
                return null;
            }
            BitmapUtils.C2631a m4631a = BitmapUtils.m4631a(this.f8360c, this.f8359b, this.f8361d, this.f8362e);
            if (isCancelled()) {
                return null;
            }
            BitmapUtils.C2632b m4624a = BitmapUtils.m4624a(m4631a.f8375a, this.f8360c, this.f8359b);
            return new C2630a(this.f8359b, m4624a.f8377a, m4631a.f8376b, m4624a.f8378b);
        } catch (Exception e) {
            return new C2630a(this.f8359b, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(C2630a c2630a) {
        CropImageView cropImageView;
        if (c2630a != null) {
            boolean z = false;
            if (!isCancelled() && (cropImageView = this.f8358a.get()) != null) {
                z = true;
                cropImageView.m4705a(c2630a);
            }
            if (z || c2630a.f8364b == null) {
                return;
            }
            c2630a.f8364b.recycle();
        }
    }

    /* compiled from: BitmapLoadingWorkerTask.java */
    /* renamed from: com.theartofdev.edmodo.cropper.b$a */
    /* loaded from: classes2.dex */
    public static final class C2630a {

        /* renamed from: a */
        public final Uri f8363a;

        /* renamed from: b */
        public final Bitmap f8364b;

        /* renamed from: c */
        public final int f8365c;

        /* renamed from: d */
        public final int f8366d;

        /* renamed from: e */
        public final Exception f8367e;

        C2630a(Uri uri, Bitmap bitmap, int i, int i2) {
            this.f8363a = uri;
            this.f8364b = bitmap;
            this.f8365c = i;
            this.f8366d = i2;
            this.f8367e = null;
        }

        C2630a(Uri uri, Exception exc) {
            this.f8363a = uri;
            this.f8364b = null;
            this.f8365c = 0;
            this.f8366d = 0;
            this.f8367e = exc;
        }
    }
}
