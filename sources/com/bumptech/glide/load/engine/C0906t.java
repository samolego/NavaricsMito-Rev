package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.engine.t */
/* loaded from: classes.dex */
public class ResourceCacheGenerator implements DataFetcher.InterfaceC0615a<Object>, DataFetcherGenerator {

    /* renamed from: a */
    private final DataFetcherGenerator.InterfaceC0719a f976a;

    /* renamed from: b */
    private final DecodeHelper<?> f977b;

    /* renamed from: c */
    private int f978c;

    /* renamed from: d */
    private int f979d = -1;

    /* renamed from: e */
    private Key f980e;

    /* renamed from: f */
    private List<ModelLoader<File, ?>> f981f;

    /* renamed from: g */
    private int f982g;

    /* renamed from: h */
    private volatile ModelLoader.C0656a<?> f983h;

    /* renamed from: i */
    private File f984i;

    /* renamed from: j */
    private ResourceCacheKey f985j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.InterfaceC0719a interfaceC0719a) {
        this.f977b = decodeHelper;
        this.f976a = interfaceC0719a;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /* renamed from: a */
    public boolean mo12023a() {
        List<Key> m12085n = this.f977b.m12085n();
        boolean z = false;
        if (m12085n.isEmpty()) {
            return false;
        }
        List<Class<?>> m12088k = this.f977b.m12088k();
        if (m12088k.isEmpty() && File.class.equals(this.f977b.m12089j())) {
            return false;
        }
        while (true) {
            if (this.f981f == null || !m12026c()) {
                this.f979d++;
                if (this.f979d >= m12088k.size()) {
                    this.f978c++;
                    if (this.f978c >= m12085n.size()) {
                        return false;
                    }
                    this.f979d = 0;
                }
                Key key = m12085n.get(this.f978c);
                Class<?> cls = m12088k.get(this.f979d);
                this.f985j = new ResourceCacheKey(this.f977b.m12090i(), key, this.f977b.m12093f(), this.f977b.m12092g(), this.f977b.m12091h(), this.f977b.m12096c(cls), cls, this.f977b.m12094e());
                this.f984i = this.f977b.m12100b().mo12142a(this.f985j);
                File file = this.f984i;
                if (file != null) {
                    this.f980e = key;
                    this.f981f = this.f977b.m12103a(file);
                    this.f982g = 0;
                }
            } else {
                this.f983h = null;
                while (!z && m12026c()) {
                    List<ModelLoader<File, ?>> list = this.f981f;
                    int i = this.f982g;
                    this.f982g = i + 1;
                    this.f983h = list.get(i).mo7358a(this.f984i, this.f977b.m12092g(), this.f977b.m12091h(), this.f977b.m12094e());
                    if (this.f983h != null && this.f977b.m12102a(this.f983h.f655c.mo7366a())) {
                        this.f983h.f655c.mo7365a(this.f977b.m12095d(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    /* renamed from: c */
    private boolean m12026c() {
        return this.f982g < this.f981f.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /* renamed from: b */
    public void mo12018b() {
        ModelLoader.C0656a<?> c0656a = this.f983h;
        if (c0656a != null) {
            c0656a.f655c.mo7363c();
        }
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher.InterfaceC0615a
    /* renamed from: a */
    public void mo12019a(Object obj) {
        this.f976a.mo12021a(this.f980e, obj, this.f983h.f655c, DataSource.RESOURCE_DISK_CACHE, this.f985j);
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher.InterfaceC0615a
    /* renamed from: a */
    public void mo12020a(@NonNull Exception exc) {
        this.f976a.mo12022a(this.f985j, exc, this.f983h.f655c, DataSource.RESOURCE_DISK_CACHE);
    }
}
