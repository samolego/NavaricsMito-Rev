package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.p011v7.widget.helper.ItemTouchHelper;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzrt;
import com.google.android.gms.internal.zzru;
import com.google.android.gms.internal.zzrv;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class zza {

    /* renamed from: At */
    final C3233zza f2758At;

    /* renamed from: Av */
    protected int f2760Av;

    /* renamed from: Au */
    protected int f2759Au = 0;

    /* renamed from: Aw */
    protected boolean f2761Aw = false;

    /* renamed from: Ax */
    private boolean f2762Ax = true;

    /* renamed from: Ay */
    private boolean f2763Ay = false;

    /* renamed from: Az */
    private boolean f2764Az = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.gms.common.images.zza$zza  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C3233zza {
        public final Uri uri;

        public C3233zza(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C3233zza) {
                if (this == obj) {
                    return true;
                }
                return zzab.equal(((C3233zza) obj).uri, this.uri);
            }
            return false;
        }

        public int hashCode() {
            return zzab.hashCode(this.uri);
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zza {

        /* renamed from: AA */
        private WeakReference<ImageView> f2765AA;

        public zzb(ImageView imageView, int i) {
            super(null, i);
            com.google.android.gms.common.internal.zzc.zzu(imageView);
            this.f2765AA = new WeakReference<>(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzc.zzu(imageView);
            this.f2765AA = new WeakReference<>(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            boolean z4 = (z2 || z3) ? false : true;
            if (z4 && (imageView instanceof zzru)) {
                int zzatp = ((zzru) imageView).zzatp();
                if (this.f2760Av != 0 && zzatp == this.f2760Av) {
                    return;
                }
            }
            boolean zzc = zzc(z, z2);
            if (zzc) {
                drawable = zza(imageView.getDrawable(), drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zzru) {
                zzru zzruVar = (zzru) imageView;
                zzruVar.zzq(z3 ? this.f2758At.uri : null);
                zzruVar.zzgj(z4 ? this.f2760Av : 0);
            }
            if (zzc) {
                ((zzrt) drawable).startTransition(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof zzb) {
                if (this == obj) {
                    return true;
                }
                ImageView imageView = this.f2765AA.get();
                ImageView imageView2 = ((zzb) obj).f2765AA.get();
                return (imageView2 == null || imageView == null || !zzab.equal(imageView2, imageView)) ? false : true;
            }
            return false;
        }

        public int hashCode() {
            return 0;
        }

        @Override // com.google.android.gms.common.images.zza
        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = this.f2765AA.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zzc extends zza {

        /* renamed from: AB */
        private WeakReference<ImageManager.OnImageLoadedListener> f2766AB;

        public zzc(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzc.zzu(onImageLoadedListener);
            this.f2766AB = new WeakReference<>(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (obj instanceof zzc) {
                if (this == obj) {
                    return true;
                }
                zzc zzcVar = (zzc) obj;
                ImageManager.OnImageLoadedListener onImageLoadedListener = this.f2766AB.get();
                ImageManager.OnImageLoadedListener onImageLoadedListener2 = zzcVar.f2766AB.get();
                return onImageLoadedListener2 != null && onImageLoadedListener != null && zzab.equal(onImageLoadedListener2, onImageLoadedListener) && zzab.equal(zzcVar.f2758At, this.f2758At);
            }
            return false;
        }

        public int hashCode() {
            return zzab.hashCode(this.f2758At);
        }

        @Override // com.google.android.gms.common.images.zza
        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageManager.OnImageLoadedListener onImageLoadedListener;
            if (z2 || (onImageLoadedListener = this.f2766AB.get()) == null) {
                return;
            }
            onImageLoadedListener.onImageLoaded(this.f2758At.uri, drawable, z3);
        }
    }

    public zza(Uri uri, int i) {
        this.f2760Av = 0;
        this.f2758At = new C3233zza(uri);
        this.f2760Av = i;
    }

    private Drawable zza(Context context, zzrv zzrvVar, int i) {
        return context.getResources().getDrawable(i);
    }

    protected zzrt zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzrt) {
            drawable = ((zzrt) drawable).zzatn();
        }
        return new zzrt(drawable, drawable2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzc.zzu(bitmap);
        zza(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(Context context, zzrv zzrvVar) {
        if (this.f2764Az) {
            zza(null, false, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(Context context, zzrv zzrvVar, boolean z) {
        int i = this.f2760Av;
        zza(i != 0 ? zza(context, zzrvVar, i) : null, z, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    protected boolean zzc(boolean z, boolean z2) {
        return (!this.f2762Ax || z2 || z) ? false : true;
    }

    public void zzgh(int i) {
        this.f2760Av = i;
    }
}
