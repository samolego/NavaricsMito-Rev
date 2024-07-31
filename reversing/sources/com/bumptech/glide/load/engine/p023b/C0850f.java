package com.bumptech.glide.load.engine.p023b;

import android.content.Context;
import com.bumptech.glide.load.engine.p023b.DiskLruCacheFactory;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.b.f */
/* loaded from: classes.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public InternalCacheDiskCacheFactory(final Context context, final String str, long j) {
        super(new DiskLruCacheFactory.InterfaceC0704a() { // from class: com.bumptech.glide.load.engine.b.f.1
            @Override // com.bumptech.glide.load.engine.p023b.DiskLruCacheFactory.InterfaceC0704a
            /* renamed from: a */
            public File mo12139a() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                String str2 = str;
                return str2 != null ? new File(cacheDir, str2) : cacheDir;
            }
        }, j);
    }
}
