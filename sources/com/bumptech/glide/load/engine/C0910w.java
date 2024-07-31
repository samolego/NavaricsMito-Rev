package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.engine.w */
/* loaded from: classes.dex */
public class SourceGenerator implements DataFetcher.InterfaceC0615a<Object>, DataFetcherGenerator, DataFetcherGenerator.InterfaceC0719a {

    /* renamed from: a */
    private final DecodeHelper<?> f997a;

    /* renamed from: b */
    private final DataFetcherGenerator.InterfaceC0719a f998b;

    /* renamed from: c */
    private int f999c;

    /* renamed from: d */
    private DataCacheGenerator f1000d;

    /* renamed from: e */
    private Object f1001e;

    /* renamed from: f */
    private volatile ModelLoader.C0656a<?> f1002f;

    /* renamed from: g */
    private DataCacheKey f1003g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.InterfaceC0719a interfaceC0719a) {
        this.f997a = decodeHelper;
        this.f998b = interfaceC0719a;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /* renamed from: a */
    public boolean mo12023a() {
        Object obj = this.f1001e;
        if (obj != null) {
            this.f1001e = null;
            m12017b(obj);
        }
        DataCacheGenerator dataCacheGenerator = this.f1000d;
        if (dataCacheGenerator == null || !dataCacheGenerator.mo12023a()) {
            this.f1000d = null;
            this.f1002f = null;
            boolean z = false;
            while (!z && m12015d()) {
                List<ModelLoader.C0656a<?>> m12086m = this.f997a.m12086m();
                int i = this.f999c;
                this.f999c = i + 1;
                this.f1002f = m12086m.get(i);
                if (this.f1002f != null && (this.f997a.m12097c().mo12079a(this.f1002f.f655c.mo7362d()) || this.f997a.m12102a(this.f1002f.f655c.mo7366a()))) {
                    this.f1002f.f655c.mo7365a(this.f997a.m12095d(), this);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    /* renamed from: d */
    private boolean m12015d() {
        return this.f999c < this.f997a.m12086m().size();
    }

    /* renamed from: b */
    private void m12017b(Object obj) {
        long m11595a = LogTime.m11595a();
        try {
            Encoder<X> m12101a = this.f997a.m12101a((DecodeHelper<?>) obj);
            DataCacheWriter dataCacheWriter = new DataCacheWriter(m12101a, obj, this.f997a.m12094e());
            this.f1003g = new DataCacheKey(this.f1002f.f653a, this.f997a.m12093f());
            this.f997a.m12100b().mo12141a(this.f1003g, dataCacheWriter);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f1003g + ", data: " + obj + ", encoder: " + m12101a + ", duration: " + LogTime.m11594a(m11595a));
            }
            this.f1002f.f655c.mo7364b();
            this.f1000d = new DataCacheGenerator(Collections.singletonList(this.f1002f.f653a), this.f997a, this);
        } catch (Throwable th) {
            this.f1002f.f655c.mo7364b();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /* renamed from: b */
    public void mo12018b() {
        ModelLoader.C0656a<?> c0656a = this.f1002f;
        if (c0656a != null) {
            c0656a.f655c.mo7363c();
        }
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher.InterfaceC0615a
    /* renamed from: a */
    public void mo12019a(Object obj) {
        DiskCacheStrategy m12097c = this.f997a.m12097c();
        if (obj != null && m12097c.mo12079a(this.f1002f.f655c.mo7362d())) {
            this.f1001e = obj;
            this.f998b.mo12016c();
            return;
        }
        this.f998b.mo12021a(this.f1002f.f653a, obj, this.f1002f.f655c, this.f1002f.f655c.mo7362d(), this.f1003g);
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher.InterfaceC0615a
    /* renamed from: a */
    public void mo12020a(@NonNull Exception exc) {
        this.f998b.mo12022a(this.f1003g, exc, this.f1002f.f655c, this.f1002f.f655c.mo7362d());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC0719a
    /* renamed from: c */
    public void mo12016c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC0719a
    /* renamed from: a */
    public void mo12021a(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f998b.mo12021a(key, obj, dataFetcher, this.f1002f.f655c.mo7362d(), key);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC0719a
    /* renamed from: a */
    public void mo12022a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f998b.mo12022a(key, exc, dataFetcher, this.f1002f.f655c.mo7362d());
    }
}
