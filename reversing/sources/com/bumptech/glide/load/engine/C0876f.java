package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.load.engine.p023b.DiskCache;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.engine.f */
/* loaded from: classes.dex */
public final class DecodeHelper<Transcode> {

    /* renamed from: a */
    private final List<ModelLoader.C0656a<?>> f872a = new ArrayList();

    /* renamed from: b */
    private final List<Key> f873b = new ArrayList();

    /* renamed from: c */
    private GlideContext f874c;

    /* renamed from: d */
    private Object f875d;

    /* renamed from: e */
    private int f876e;

    /* renamed from: f */
    private int f877f;

    /* renamed from: g */
    private Class<?> f878g;

    /* renamed from: h */
    private DecodeJob.InterfaceC0683d f879h;

    /* renamed from: i */
    private Options f880i;

    /* renamed from: j */
    private Map<Class<?>, Transformation<?>> f881j;

    /* renamed from: k */
    private Class<Transcode> f882k;

    /* renamed from: l */
    private boolean f883l;

    /* renamed from: m */
    private boolean f884m;

    /* renamed from: n */
    private Key f885n;

    /* renamed from: o */
    private Priority f886o;

    /* renamed from: p */
    private DiskCacheStrategy f887p;

    /* renamed from: q */
    private boolean f888q;

    /* renamed from: r */
    private boolean f889r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <R> void m12106a(GlideContext glideContext, Object obj, Key key, int i, int i2, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, DecodeJob.InterfaceC0683d interfaceC0683d) {
        this.f874c = glideContext;
        this.f875d = obj;
        this.f885n = key;
        this.f876e = i;
        this.f877f = i2;
        this.f887p = diskCacheStrategy;
        this.f878g = cls;
        this.f879h = interfaceC0683d;
        this.f882k = cls2;
        this.f886o = priority;
        this.f880i = options;
        this.f881j = map;
        this.f888q = z;
        this.f889r = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12107a() {
        this.f874c = null;
        this.f875d = null;
        this.f885n = null;
        this.f878g = null;
        this.f882k = null;
        this.f880i = null;
        this.f886o = null;
        this.f881j = null;
        this.f887p = null;
        this.f872a.clear();
        this.f883l = false;
        this.f873b.clear();
        this.f884m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public DiskCache m12100b() {
        return this.f879h.mo12065a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public DiskCacheStrategy m12097c() {
        return this.f887p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public Priority m12095d() {
        return this.f886o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public Options m12094e() {
        return this.f880i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public Key m12093f() {
        return this.f885n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public int m12092g() {
        return this.f876e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public int m12091h() {
        return this.f877f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public ArrayPool m12090i() {
        return this.f874c.m12494f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public Class<?> m12089j() {
        return (Class<Transcode>) this.f882k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public List<Class<?>> m12088k() {
        return this.f874c.m12496d().m12613b(this.f875d.getClass(), this.f878g, this.f882k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public boolean m12102a(Class<?> cls) {
        return m12098b(cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public <Data> LoadPath<Data, ?, Transcode> m12098b(Class<Data> cls) {
        return this.f874c.m12496d().m12619a(cls, this.f878g, this.f882k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean m12087l() {
        return this.f889r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public <Z> Transformation<Z> m12096c(Class<Z> cls) {
        Transformation<Z> transformation = (Transformation<Z>) this.f881j.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.f881j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, Transformation<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    transformation = (Transformation<Z>) next.getValue();
                    break;
                }
            }
        }
        if (transformation == null) {
            if (this.f881j.isEmpty() && this.f888q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return UnitTransformation.m12003a();
        }
        return transformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m12104a(Resource<?> resource) {
        return this.f874c.m12496d().m12625a(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public <Z> ResourceEncoder<Z> m12099b(Resource<Z> resource) {
        return this.f874c.m12496d().m12615b((Resource) resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public List<ModelLoader<File, ?>> m12103a(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f874c.m12496d().m12610c(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m12105a(Key key) {
        List<ModelLoader.C0656a<?>> m12086m = m12086m();
        int size = m12086m.size();
        for (int i = 0; i < size; i++) {
            if (m12086m.get(i).f653a.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public List<ModelLoader.C0656a<?>> m12086m() {
        if (!this.f883l) {
            this.f883l = true;
            this.f872a.clear();
            List m12610c = this.f874c.m12496d().m12610c(this.f875d);
            int size = m12610c.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.C0656a<?> mo7358a = ((ModelLoader) m12610c.get(i)).mo7358a(this.f875d, this.f876e, this.f877f, this.f880i);
                if (mo7358a != null) {
                    this.f872a.add(mo7358a);
                }
            }
        }
        return this.f872a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public List<Key> m12085n() {
        if (!this.f884m) {
            this.f884m = true;
            this.f873b.clear();
            List<ModelLoader.C0656a<?>> m12086m = m12086m();
            int size = m12086m.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.C0656a<?> c0656a = m12086m.get(i);
                if (!this.f873b.contains(c0656a.f653a)) {
                    this.f873b.add(c0656a.f653a);
                }
                for (int i2 = 0; i2 < c0656a.f654b.size(); i2++) {
                    if (!this.f873b.contains(c0656a.f654b.get(i2))) {
                        this.f873b.add(c0656a.f654b.get(i2));
                    }
                }
            }
        }
        return this.f873b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public <X> Encoder<X> m12101a(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f874c.m12496d().m12618a((Registry) x);
    }
}
