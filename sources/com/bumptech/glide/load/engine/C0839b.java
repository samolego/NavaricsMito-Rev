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
/* renamed from: com.bumptech.glide.load.engine.b */
/* loaded from: classes.dex */
public class DataCacheGenerator implements DataFetcher.InterfaceC0615a<Object>, DataFetcherGenerator {

    /* renamed from: a */
    private final List<Key> f807a;

    /* renamed from: b */
    private final DecodeHelper<?> f808b;

    /* renamed from: c */
    private final DataFetcherGenerator.InterfaceC0719a f809c;

    /* renamed from: d */
    private int f810d;

    /* renamed from: e */
    private Key f811e;

    /* renamed from: f */
    private List<ModelLoader<File, ?>> f812f;

    /* renamed from: g */
    private int f813g;

    /* renamed from: h */
    private volatile ModelLoader.C0656a<?> f814h;

    /* renamed from: i */
    private File f815i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.InterfaceC0719a interfaceC0719a) {
        this(decodeHelper.m12085n(), decodeHelper, interfaceC0719a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.InterfaceC0719a interfaceC0719a) {
        this.f810d = -1;
        this.f807a = list;
        this.f808b = decodeHelper;
        this.f809c = interfaceC0719a;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /* renamed from: a */
    public boolean mo12023a() {
        while (true) {
            boolean z = false;
            if (this.f812f == null || !m12149c()) {
                this.f810d++;
                if (this.f810d >= this.f807a.size()) {
                    return false;
                }
                Key key = this.f807a.get(this.f810d);
                this.f815i = this.f808b.m12100b().mo12142a(new DataCacheKey(key, this.f808b.m12093f()));
                File file = this.f815i;
                if (file != null) {
                    this.f811e = key;
                    this.f812f = this.f808b.m12103a(file);
                    this.f813g = 0;
                }
            } else {
                this.f814h = null;
                while (!z && m12149c()) {
                    List<ModelLoader<File, ?>> list = this.f812f;
                    int i = this.f813g;
                    this.f813g = i + 1;
                    this.f814h = list.get(i).mo7358a(this.f815i, this.f808b.m12092g(), this.f808b.m12091h(), this.f808b.m12094e());
                    if (this.f814h != null && this.f808b.m12102a(this.f814h.f655c.mo7366a())) {
                        this.f814h.f655c.mo7365a(this.f808b.m12095d(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    /* renamed from: c */
    private boolean m12149c() {
        return this.f813g < this.f812f.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /* renamed from: b */
    public void mo12018b() {
        ModelLoader.C0656a<?> c0656a = this.f814h;
        if (c0656a != null) {
            c0656a.f655c.mo7363c();
        }
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher.InterfaceC0615a
    /* renamed from: a */
    public void mo12019a(Object obj) {
        this.f809c.mo12021a(this.f811e, obj, this.f814h.f655c, DataSource.DATA_DISK_CACHE, this.f811e);
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher.InterfaceC0615a
    /* renamed from: a */
    public void mo12020a(@NonNull Exception exc) {
        this.f809c.mo12022a(this.f811e, exc, this.f814h.f655c, DataSource.DATA_DISK_CACHE);
    }
}
