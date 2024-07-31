package com.bumptech.glide.load.engine;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.p008v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.p023b.DiskCache;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p018a.DataRewinder;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.p033a.FactoryPools;
import com.bumptech.glide.util.p033a.GlideTrace;
import com.bumptech.glide.util.p033a.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class DecodeJob<R> implements DataFetcherGenerator.InterfaceC0719a, FactoryPools.InterfaceC0787c, Comparable<DecodeJob<?>>, Runnable {

    /* renamed from: A */
    private DataSource f702A;

    /* renamed from: B */
    private DataFetcher<?> f703B;

    /* renamed from: C */
    private volatile DataFetcherGenerator f704C;

    /* renamed from: D */
    private volatile boolean f705D;

    /* renamed from: E */
    private volatile boolean f706E;

    /* renamed from: d */
    private final InterfaceC0683d f710d;

    /* renamed from: e */
    private final Pools.Pool<DecodeJob<?>> f711e;

    /* renamed from: h */
    private GlideContext f714h;

    /* renamed from: i */
    private Key f715i;

    /* renamed from: j */
    private Priority f716j;

    /* renamed from: k */
    private EngineKey f717k;

    /* renamed from: l */
    private int f718l;

    /* renamed from: m */
    private int f719m;

    /* renamed from: n */
    private DiskCacheStrategy f720n;

    /* renamed from: o */
    private Options f721o;

    /* renamed from: p */
    private InterfaceC0680a<R> f722p;

    /* renamed from: q */
    private int f723q;

    /* renamed from: r */
    private Stage f724r;

    /* renamed from: s */
    private RunReason f725s;

    /* renamed from: t */
    private long f726t;

    /* renamed from: u */
    private boolean f727u;

    /* renamed from: v */
    private Object f728v;

    /* renamed from: w */
    private Thread f729w;

    /* renamed from: x */
    private Key f730x;

    /* renamed from: y */
    private Key f731y;

    /* renamed from: z */
    private Object f732z;

    /* renamed from: a */
    private final DecodeHelper<R> f707a = new DecodeHelper<>();

    /* renamed from: b */
    private final List<Throwable> f708b = new ArrayList();

    /* renamed from: c */
    private final StateVerifier f709c = StateVerifier.m11604a();

    /* renamed from: f */
    private final C0682c<?> f712f = new C0682c<>();

    /* renamed from: g */
    private final C0684e f713g = new C0684e();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0680a<R> {
        /* renamed from: a */
        void mo12061a(DecodeJob<?> decodeJob);

        /* renamed from: a */
        void mo12060a(GlideException glideException);

        /* renamed from: a */
        void mo12059a(Resource<R> resource, DataSource dataSource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0683d {
        /* renamed from: a */
        DiskCache mo12065a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob(InterfaceC0683d interfaceC0683d, Pools.Pool<DecodeJob<?>> pool) {
        this.f710d = interfaceC0683d;
        this.f711e = pool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public DecodeJob<R> m12274a(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, InterfaceC0680a<R> interfaceC0680a, int i3) {
        this.f707a.m12106a(glideContext, obj, key, i, i2, diskCacheStrategy, cls, cls2, priority, options, map, z, z2, this.f710d);
        this.f714h = glideContext;
        this.f715i = key;
        this.f716j = priority;
        this.f717k = engineKey;
        this.f718l = i;
        this.f719m = i2;
        this.f720n = diskCacheStrategy;
        this.f727u = z3;
        this.f721o = options;
        this.f722p = interfaceC0680a;
        this.f723q = i3;
        this.f725s = RunReason.INITIALIZE;
        this.f728v = obj;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m12275a() {
        Stage m12270a = m12270a(Stage.INITIALIZE);
        return m12270a == Stage.RESOURCE_CACHE || m12270a == Stage.DATA_CACHE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12263a(boolean z) {
        if (this.f713g.m12245a(z)) {
            m12258g();
        }
    }

    /* renamed from: e */
    private void m12260e() {
        if (this.f713g.m12246a()) {
            m12258g();
        }
    }

    /* renamed from: f */
    private void m12259f() {
        if (this.f713g.m12244b()) {
            m12258g();
        }
    }

    /* renamed from: g */
    private void m12258g() {
        this.f713g.m12242c();
        this.f712f.m12247b();
        this.f707a.m12107a();
        this.f705D = false;
        this.f714h = null;
        this.f715i = null;
        this.f721o = null;
        this.f716j = null;
        this.f717k = null;
        this.f722p = null;
        this.f724r = null;
        this.f704C = null;
        this.f729w = null;
        this.f730x = null;
        this.f732z = null;
        this.f702A = null;
        this.f703B = null;
        this.f726t = 0L;
        this.f706E = false;
        this.f728v = null;
        this.f708b.clear();
        this.f711e.release(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int m12257h = m12257h() - decodeJob.m12257h();
        return m12257h == 0 ? this.f723q - decodeJob.f723q : m12257h;
    }

    /* renamed from: h */
    private int m12257h() {
        return this.f716j.ordinal();
    }

    /* renamed from: b */
    public void m12262b() {
        this.f706E = true;
        DataFetcherGenerator dataFetcherGenerator = this.f704C;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.mo12018b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r0 != null) goto L13;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r5 = this;
            java.lang.String r0 = "DecodeJob#run(model=%s)"
            java.lang.Object r1 = r5.f728v
            com.bumptech.glide.util.p033a.GlideTrace.m11606a(r0, r1)
            com.bumptech.glide.load.a.d<?> r0 = r5.f703B
            boolean r1 = r5.f706E     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L19
            r5.m12253l()     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L15
            r0.mo7364b()
        L15:
            com.bumptech.glide.util.p033a.GlideTrace.m11608a()
            return
        L19:
            r5.m12256i()     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L21
        L1e:
            r0.mo7364b()
        L21:
            com.bumptech.glide.util.p033a.GlideTrace.m11608a()
            goto L68
        L25:
            r1 = move-exception
            goto L6a
        L27:
            r1 = move-exception
            java.lang.String r2 = "DecodeJob"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L53
            java.lang.String r2 = "DecodeJob"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L25
            r3.<init>()     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = "DecodeJob threw unexpectedly, isCancelled: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L25
            boolean r4 = r5.f706E     // Catch: java.lang.Throwable -> L25
            r3.append(r4)     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = ", stage: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L25
            com.bumptech.glide.load.engine.DecodeJob$Stage r4 = r5.f724r     // Catch: java.lang.Throwable -> L25
            r3.append(r4)     // Catch: java.lang.Throwable -> L25
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L25
            android.util.Log.d(r2, r3, r1)     // Catch: java.lang.Throwable -> L25
        L53:
            com.bumptech.glide.load.engine.DecodeJob$Stage r2 = r5.f724r     // Catch: java.lang.Throwable -> L25
            com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.ENCODE     // Catch: java.lang.Throwable -> L25
            if (r2 == r3) goto L61
            java.util.List<java.lang.Throwable> r2 = r5.f708b     // Catch: java.lang.Throwable -> L25
            r2.add(r1)     // Catch: java.lang.Throwable -> L25
            r5.m12253l()     // Catch: java.lang.Throwable -> L25
        L61:
            boolean r2 = r5.f706E     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L69
            if (r0 == 0) goto L21
            goto L1e
        L68:
            return
        L69:
            throw r1     // Catch: java.lang.Throwable -> L25
        L6a:
            if (r0 == 0) goto L6f
            r0.mo7364b()
        L6f:
            com.bumptech.glide.util.p033a.GlideTrace.m11608a()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.run():void");
    }

    /* renamed from: i */
    private void m12256i() {
        switch (this.f725s) {
            case INITIALIZE:
                this.f724r = m12270a(Stage.INITIALIZE);
                this.f704C = m12255j();
                m12254k();
                return;
            case SWITCH_TO_SOURCE_SERVICE:
                m12254k();
                return;
            case DECODE_DATA:
                m12251n();
                return;
            default:
                throw new IllegalStateException("Unrecognized run reason: " + this.f725s);
        }
    }

    /* renamed from: j */
    private DataFetcherGenerator m12255j() {
        switch (this.f724r) {
            case RESOURCE_CACHE:
                return new ResourceCacheGenerator(this.f707a, this);
            case DATA_CACHE:
                return new DataCacheGenerator(this.f707a, this);
            case SOURCE:
                return new SourceGenerator(this.f707a, this);
            case FINISHED:
                return null;
            default:
                throw new IllegalStateException("Unrecognized stage: " + this.f724r);
        }
    }

    /* renamed from: k */
    private void m12254k() {
        this.f729w = Thread.currentThread();
        this.f726t = LogTime.m11595a();
        boolean z = false;
        while (!this.f706E && this.f704C != null && !(z = this.f704C.mo12023a())) {
            this.f724r = m12270a(this.f724r);
            this.f704C = m12255j();
            if (this.f724r == Stage.SOURCE) {
                mo12016c();
                return;
            }
        }
        if ((this.f724r == Stage.FINISHED || this.f706E) && !z) {
            m12253l();
        }
    }

    /* renamed from: l */
    private void m12253l() {
        m12252m();
        this.f722p.mo12060a(new GlideException("Failed to load resource", new ArrayList(this.f708b)));
        m12259f();
    }

    /* renamed from: a */
    private void m12268a(Resource<R> resource, DataSource dataSource) {
        m12252m();
        this.f722p.mo12059a(resource, dataSource);
    }

    /* renamed from: m */
    private void m12252m() {
        this.f709c.mo11602b();
        if (this.f705D) {
            throw new IllegalStateException("Already notified");
        }
        this.f705D = true;
    }

    /* renamed from: a */
    private Stage m12270a(Stage stage) {
        switch (stage) {
            case RESOURCE_CACHE:
                return this.f720n.mo12077b() ? Stage.DATA_CACHE : m12270a(Stage.DATA_CACHE);
            case DATA_CACHE:
                return this.f727u ? Stage.FINISHED : Stage.SOURCE;
            case SOURCE:
            case FINISHED:
                return Stage.FINISHED;
            case INITIALIZE:
                return this.f720n.mo12080a() ? Stage.RESOURCE_CACHE : m12270a(Stage.RESOURCE_CACHE);
            default:
                throw new IllegalArgumentException("Unrecognized stage: " + stage);
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC0719a
    /* renamed from: c */
    public void mo12016c() {
        this.f725s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.f722p.mo12061a((DecodeJob<?>) this);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC0719a
    /* renamed from: a */
    public void mo12021a(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f730x = key;
        this.f732z = obj;
        this.f703B = dataFetcher;
        this.f702A = dataSource;
        this.f731y = key2;
        if (Thread.currentThread() != this.f729w) {
            this.f725s = RunReason.DECODE_DATA;
            this.f722p.mo12061a((DecodeJob<?>) this);
            return;
        }
        GlideTrace.m11607a("DecodeJob.decodeFromRetrievedData");
        try {
            m12251n();
        } finally {
            GlideTrace.m11608a();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC0719a
    /* renamed from: a */
    public void mo12022a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.mo7364b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(key, dataSource, dataFetcher.mo7366a());
        this.f708b.add(glideException);
        if (Thread.currentThread() != this.f729w) {
            this.f725s = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.f722p.mo12061a((DecodeJob<?>) this);
            return;
        }
        m12254k();
    }

    /* renamed from: n */
    private void m12251n() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.f726t;
            m12264a("Retrieved data", j, "data: " + this.f732z + ", cache key: " + this.f730x + ", fetcher: " + this.f703B);
        }
        Resource<R> resource = null;
        try {
            resource = m12271a(this.f703B, (DataFetcher<?>) this.f732z, this.f702A);
        } catch (GlideException e) {
            e.setLoggingDetails(this.f731y, this.f702A);
            this.f708b.add(e);
        }
        if (resource != null) {
            m12261b(resource, this.f702A);
        } else {
            m12254k();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private void m12261b(Resource<R> resource, DataSource dataSource) {
        if (resource instanceof Initializable) {
            ((Initializable) resource).mo11854a();
        }
        LockedResource lockedResource = 0;
        if (this.f712f.m12250a()) {
            resource = LockedResource.m12030a(resource);
            lockedResource = resource;
        }
        m12268a((Resource) resource, dataSource);
        this.f724r = Stage.ENCODE;
        try {
            if (this.f712f.m12250a()) {
                this.f712f.m12248a(this.f710d, this.f721o);
            }
            m12260e();
        } finally {
            if (lockedResource != 0) {
                lockedResource.m12031a();
            }
        }
    }

    /* renamed from: a */
    private <Data> Resource<R> m12271a(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data != null) {
            try {
                long m11595a = LogTime.m11595a();
                Resource<R> m12267a = m12267a((DecodeJob<R>) data, dataSource);
                if (Log.isLoggable("DecodeJob", 2)) {
                    m12265a("Decoded result " + m12267a, m11595a);
                }
                return m12267a;
            } finally {
                dataFetcher.mo7364b();
            }
        }
        return null;
    }

    /* renamed from: a */
    private <Data> Resource<R> m12267a(Data data, DataSource dataSource) throws GlideException {
        return m12266a((DecodeJob<R>) data, dataSource, (LoadPath<DecodeJob<R>, ResourceType, R>) ((LoadPath<Data, ?, R>) this.f707a.m12098b(data.getClass())));
    }

    @NonNull
    /* renamed from: a */
    private Options m12273a(DataSource dataSource) {
        Options options = this.f721o;
        if (Build.VERSION.SDK_INT >= 26 && options.m12014a(Downsampler.f1048d) == null) {
            if (dataSource == DataSource.RESOURCE_DISK_CACHE || this.f707a.m12087l()) {
                Options options2 = new Options();
                options2.m12011a(this.f721o);
                options2.m12013a(Downsampler.f1048d, true);
                return options2;
            }
            return options;
        }
        return options;
    }

    /* renamed from: a */
    private <Data, ResourceType> Resource<R> m12266a(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options m12273a = m12273a(dataSource);
        DataRewinder<Data> m12612b = this.f714h.m12496d().m12612b((Registry) data);
        try {
            return loadPath.m12033a(m12612b, m12273a, this.f718l, this.f719m, new C0681b(dataSource));
        } finally {
            m12612b.mo12009b();
        }
    }

    /* renamed from: a */
    private void m12265a(String str, long j) {
        m12264a(str, j, (String) null);
    }

    /* renamed from: a */
    private void m12264a(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.m11594a(j));
        sb.append(", load key: ");
        sb.append(this.f717k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0787c
    @NonNull
    /* renamed from: a_ */
    public StateVerifier mo11610a_() {
        return this.f709c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    /* renamed from: a */
    <Z> Resource<Z> m12272a(DataSource dataSource, @NonNull Resource<Z> resource) {
        Resource<Z> resource2;
        Transformation<Z> transformation;
        EncodeStrategy encodeStrategy;
        ResourceEncoder resourceEncoder;
        Key dataCacheKey;
        Class<?> cls = resource.mo11898d().getClass();
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            Transformation<Z> m12096c = this.f707a.m12096c(cls);
            transformation = m12096c;
            resource2 = m12096c.mo11850a(this.f714h, resource, this.f718l, this.f719m);
        } else {
            resource2 = resource;
            transformation = null;
        }
        if (!resource.equals(resource2)) {
            resource.mo11851f();
        }
        if (this.f707a.m12104a((Resource<?>) resource2)) {
            ResourceEncoder m12099b = this.f707a.m12099b(resource2);
            encodeStrategy = m12099b.mo11856a(this.f721o);
            resourceEncoder = m12099b;
        } else {
            encodeStrategy = EncodeStrategy.NONE;
            resourceEncoder = null;
        }
        if (this.f720n.mo12078a(!this.f707a.m12105a(this.f730x), dataSource, encodeStrategy)) {
            if (resourceEncoder == null) {
                throw new Registry.NoResultEncoderAvailableException(resource2.mo11898d().getClass());
            }
            switch (encodeStrategy) {
                case SOURCE:
                    dataCacheKey = new DataCacheKey(this.f730x, this.f715i);
                    break;
                case TRANSFORMED:
                    dataCacheKey = new ResourceCacheKey(this.f707a.m12090i(), this.f730x, this.f715i, this.f718l, this.f719m, transformation, cls, this.f721o);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
            }
            LockedResource m12030a = LockedResource.m12030a(resource2);
            this.f712f.m12249a(dataCacheKey, resourceEncoder, m12030a);
            return m12030a;
        }
        return resource2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$b */
    /* loaded from: classes.dex */
    public final class C0681b<Z> implements DecodePath.InterfaceC0720a<Z> {

        /* renamed from: b */
        private final DataSource f739b;

        C0681b(DataSource dataSource) {
            this.f739b = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.InterfaceC0720a
        @NonNull
        /* renamed from: a */
        public Resource<Z> mo12081a(@NonNull Resource<Z> resource) {
            return DecodeJob.this.m12272a(this.f739b, resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$e */
    /* loaded from: classes.dex */
    public static class C0684e {

        /* renamed from: a */
        private boolean f743a;

        /* renamed from: b */
        private boolean f744b;

        /* renamed from: c */
        private boolean f745c;

        C0684e() {
        }

        /* renamed from: a */
        synchronized boolean m12245a(boolean z) {
            this.f743a = true;
            return m12243b(z);
        }

        /* renamed from: a */
        synchronized boolean m12246a() {
            this.f744b = true;
            return m12243b(false);
        }

        /* renamed from: b */
        synchronized boolean m12244b() {
            this.f745c = true;
            return m12243b(false);
        }

        /* renamed from: c */
        synchronized void m12242c() {
            this.f744b = false;
            this.f743a = false;
            this.f745c = false;
        }

        /* renamed from: b */
        private boolean m12243b(boolean z) {
            return (this.f745c || z || this.f744b) && this.f743a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$c */
    /* loaded from: classes.dex */
    public static class C0682c<Z> {

        /* renamed from: a */
        private Key f740a;

        /* renamed from: b */
        private ResourceEncoder<Z> f741b;

        /* renamed from: c */
        private LockedResource<Z> f742c;

        C0682c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        <X> void m12249a(Key key, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            this.f740a = key;
            this.f741b = resourceEncoder;
            this.f742c = lockedResource;
        }

        /* renamed from: a */
        void m12248a(InterfaceC0683d interfaceC0683d, Options options) {
            GlideTrace.m11607a("DecodeJob.encode");
            try {
                interfaceC0683d.mo12065a().mo12141a(this.f740a, new DataCacheWriter(this.f741b, this.f742c, options));
            } finally {
                this.f742c.m12031a();
                GlideTrace.m11608a();
            }
        }

        /* renamed from: a */
        boolean m12250a() {
            return this.f742c != null;
        }

        /* renamed from: b */
        void m12247b() {
            this.f740a = null;
            this.f741b = null;
            this.f742c = null;
        }
    }
}
