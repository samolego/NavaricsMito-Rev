package com.bumptech.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.util.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.engine.p022a.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.p022a.LruArrayPool;
import com.bumptech.glide.load.engine.p022a.LruBitmapPool;
import com.bumptech.glide.load.engine.p023b.DiskCache;
import com.bumptech.glide.load.engine.p023b.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.p023b.LruResourceCache;
import com.bumptech.glide.load.engine.p023b.MemoryCache;
import com.bumptech.glide.load.engine.p023b.MemorySizeCalculator;
import com.bumptech.glide.load.engine.p024c.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestOptions;
import java.util.Map;

/* renamed from: com.bumptech.glide.f */
/* loaded from: classes.dex */
public final class GlideBuilder {

    /* renamed from: b */
    private Engine f437b;

    /* renamed from: c */
    private BitmapPool f438c;

    /* renamed from: d */
    private ArrayPool f439d;

    /* renamed from: e */
    private MemoryCache f440e;

    /* renamed from: f */
    private GlideExecutor f441f;

    /* renamed from: g */
    private GlideExecutor f442g;

    /* renamed from: h */
    private DiskCache.InterfaceC0700a f443h;

    /* renamed from: i */
    private MemorySizeCalculator f444i;

    /* renamed from: j */
    private ConnectivityMonitorFactory f445j;
    @Nullable

    /* renamed from: m */
    private RequestManagerRetriever.InterfaceC0773a f448m;

    /* renamed from: n */
    private GlideExecutor f449n;

    /* renamed from: o */
    private boolean f450o;

    /* renamed from: a */
    private final Map<Class<?>, TransitionOptions<?, ?>> f436a = new ArrayMap();

    /* renamed from: k */
    private int f446k = 4;

    /* renamed from: l */
    private RequestOptions f447l = new RequestOptions();

    @NonNull
    /* renamed from: a */
    public GlideBuilder m12504a(int i) {
        if (i < 2 || i > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.f446k = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12502a(@Nullable RequestManagerRetriever.InterfaceC0773a interfaceC0773a) {
        this.f448m = interfaceC0773a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public Glide m12503a(@NonNull Context context) {
        if (this.f441f == null) {
            this.f441f = GlideExecutor.m12116b();
        }
        if (this.f442g == null) {
            this.f442g = GlideExecutor.m12119a();
        }
        if (this.f449n == null) {
            this.f449n = GlideExecutor.m12113d();
        }
        if (this.f444i == null) {
            this.f444i = new MemorySizeCalculator.C0707a(context).m12125a();
        }
        if (this.f445j == null) {
            this.f445j = new DefaultConnectivityMonitorFactory();
        }
        if (this.f438c == null) {
            int m12127b = this.f444i.m12127b();
            if (m12127b > 0) {
                this.f438c = new LruBitmapPool(m12127b);
            } else {
                this.f438c = new BitmapPoolAdapter();
            }
        }
        if (this.f439d == null) {
            this.f439d = new LruArrayPool(this.f444i.m12126c());
        }
        if (this.f440e == null) {
            this.f440e = new LruResourceCache(this.f444i.m12131a());
        }
        if (this.f443h == null) {
            this.f443h = new InternalCacheDiskCacheFactory(context);
        }
        if (this.f437b == null) {
            this.f437b = new Engine(this.f440e, this.f443h, this.f442g, this.f441f, GlideExecutor.m12114c(), GlideExecutor.m12113d(), this.f450o);
        }
        return new Glide(context, this.f437b, this.f440e, this.f438c, this.f439d, new RequestManagerRetriever(this.f448m), this.f445j, this.f446k, this.f447l.mo9518j(), this.f436a);
    }
}
