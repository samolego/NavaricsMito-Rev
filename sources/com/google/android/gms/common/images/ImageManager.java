package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.p008v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzrv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class ImageManager {

    /* renamed from: Ae */
    private static final Object f2738Ae = new Object();

    /* renamed from: Af */
    private static HashSet<Uri> f2739Af = new HashSet<>();

    /* renamed from: Ag */
    private static ImageManager f2740Ag;

    /* renamed from: Ah */
    private static ImageManager f2741Ah;

    /* renamed from: Aj */
    private final zzb f2743Aj;

    /* renamed from: Ak */
    private final zzrv f2744Ak;

    /* renamed from: Al */
    private final Map<com.google.android.gms.common.images.zza, ImageReceiver> f2745Al;

    /* renamed from: Am */
    private final Map<Uri, ImageReceiver> f2746Am;

    /* renamed from: An */
    private final Map<Uri, Long> f2747An;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: Ai */
    private final ExecutorService f2742Ai = Executors.newFixedThreadPool(4);

    /* JADX INFO: Access modifiers changed from: private */
    @KeepName
    /* loaded from: classes.dex */
    public final class ImageReceiver extends ResultReceiver {

        /* renamed from: Ao */
        private final ArrayList<com.google.android.gms.common.images.zza> f2748Ao;
        private final Uri mUri;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.f2748Ao = new ArrayList<>();
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.f2742Ai.execute(new zzc(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzatm() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        public void zzb(com.google.android.gms.common.images.zza zzaVar) {
            com.google.android.gms.common.internal.zzc.zzhq("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f2748Ao.add(zzaVar);
        }

        public void zzc(com.google.android.gms.common.images.zza zzaVar) {
            com.google.android.gms.common.internal.zzc.zzhq("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f2748Ao.remove(zzaVar);
        }
    }

    /* loaded from: classes.dex */
    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    /* loaded from: classes.dex */
    public static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class zzb extends LruCache<zza.C3233zza, Bitmap> {
        public zzb(Context context) {
            super(zzcc(context));
        }

        @TargetApi(11)
        private static int zzcc(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((((context.getApplicationInfo().flags & 1048576) != 0) && zzs.zzaxk()) ? zza.zza(activityManager) : activityManager.getMemoryClass()) * 1048576 * 0.33f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.p008v4.util.LruCache
        /* renamed from: zza */
        public int sizeOf(zza.C3233zza c3233zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.p008v4.util.LruCache
        /* renamed from: zza */
        public void entryRemoved(boolean z, zza.C3233zza c3233zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c3233zza, bitmap, bitmap2);
        }
    }

    /* loaded from: classes.dex */
    private final class zzc implements Runnable {

        /* renamed from: Aq */
        private final ParcelFileDescriptor f2751Aq;
        private final Uri mUri;

        public zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.f2751Aq = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Bitmap bitmap;
            com.google.android.gms.common.internal.zzc.zzhr("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.f2751Aq;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.mUri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e);
                    z2 = true;
                }
                try {
                    this.f2751Aq.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zzf(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.mUri);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class zzd implements Runnable {

        /* renamed from: Ar */
        private final com.google.android.gms.common.images.zza f2753Ar;

        public zzd(com.google.android.gms.common.images.zza zzaVar) {
            this.f2753Ar = zzaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzc.zzhq("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f2745Al.get(this.f2753Ar);
            if (imageReceiver != null) {
                ImageManager.this.f2745Al.remove(this.f2753Ar);
                imageReceiver.zzc(this.f2753Ar);
            }
            zza.C3233zza c3233zza = this.f2753Ar.f2758At;
            if (c3233zza.uri == null) {
                this.f2753Ar.zza(ImageManager.this.mContext, ImageManager.this.f2744Ak, true);
                return;
            }
            Bitmap zza = ImageManager.this.zza(c3233zza);
            if (zza != null) {
                this.f2753Ar.zza(ImageManager.this.mContext, zza, true);
                return;
            }
            Long l = (Long) ImageManager.this.f2747An.get(c3233zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.f2753Ar.zza(ImageManager.this.mContext, ImageManager.this.f2744Ak, true);
                    return;
                }
                ImageManager.this.f2747An.remove(c3233zza.uri);
            }
            this.f2753Ar.zza(ImageManager.this.mContext, ImageManager.this.f2744Ak);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.f2746Am.get(c3233zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(c3233zza.uri);
                ImageManager.this.f2746Am.put(c3233zza.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.f2753Ar);
            if (!(this.f2753Ar instanceof zza.zzc)) {
                ImageManager.this.f2745Al.put(this.f2753Ar, imageReceiver2);
            }
            synchronized (ImageManager.f2738Ae) {
                if (!ImageManager.f2739Af.contains(c3233zza.uri)) {
                    ImageManager.f2739Af.add(c3233zza.uri);
                    imageReceiver2.zzatm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    /* loaded from: classes.dex */
    public static final class zze implements ComponentCallbacks2 {

        /* renamed from: Aj */
        private final zzb f2754Aj;

        public zze(zzb zzbVar) {
            this.f2754Aj = zzbVar;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            this.f2754Aj.evictAll();
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.f2754Aj.evictAll();
            } else if (i >= 20) {
                zzb zzbVar = this.f2754Aj;
                zzbVar.trimToSize(zzbVar.size() / 2);
            }
        }
    }

    /* loaded from: classes.dex */
    private final class zzf implements Runnable {

        /* renamed from: As */
        private boolean f2756As;
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zzamx;

        public zzf(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.f2756As = z;
            this.zzamx = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList arrayList = imageReceiver.f2748Ao;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.google.android.gms.common.images.zza zzaVar = (com.google.android.gms.common.images.zza) arrayList.get(i);
                if (z) {
                    zzaVar.zza(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.f2747An.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zzaVar.zza(ImageManager.this.mContext, ImageManager.this.f2744Ak, false);
                }
                if (!(zzaVar instanceof zza.zzc)) {
                    ImageManager.this.f2745Al.remove(zzaVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzc.zzhq("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.f2743Aj != null) {
                if (this.f2756As) {
                    ImageManager.this.f2743Aj.evictAll();
                    System.gc();
                    this.f2756As = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.f2743Aj.put(new zza.C3233zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f2746Am.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzamx.countDown();
            synchronized (ImageManager.f2738Ae) {
                ImageManager.f2739Af.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        if (z) {
            this.f2743Aj = new zzb(this.mContext);
            if (zzs.zzaxn()) {
                zzatk();
            }
        } else {
            this.f2743Aj = null;
        }
        this.f2744Ak = new zzrv();
        this.f2745Al = new HashMap();
        this.f2746Am = new HashMap();
        this.f2747An = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzg(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap zza(zza.C3233zza c3233zza) {
        zzb zzbVar = this.f2743Aj;
        if (zzbVar == null) {
            return null;
        }
        return zzbVar.get(c3233zza);
    }

    @TargetApi(14)
    private void zzatk() {
        this.mContext.registerComponentCallbacks(new zze(this.f2743Aj));
    }

    public static ImageManager zzg(Context context, boolean z) {
        if (z) {
            if (f2741Ah == null) {
                f2741Ah = new ImageManager(context, true);
            }
            return f2741Ah;
        }
        if (f2740Ag == null) {
            f2740Ag = new ImageManager(context, false);
        }
        return f2740Ag;
    }

    public void loadImage(ImageView imageView, int i) {
        zza(new zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zza.zzb zzbVar = new zza.zzb(imageView, uri);
        zzbVar.zzgh(i);
        zza(zzbVar);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza.zzc zzcVar = new zza.zzc(onImageLoadedListener, uri);
        zzcVar.zzgh(i);
        zza(zzcVar);
    }

    public void zza(com.google.android.gms.common.images.zza zzaVar) {
        com.google.android.gms.common.internal.zzc.zzhq("ImageManager.loadImage() must be called in the main thread");
        new zzd(zzaVar).run();
    }
}
