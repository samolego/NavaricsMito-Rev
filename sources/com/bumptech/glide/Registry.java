package com.bumptech.glide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.p018a.DataRewinder;
import com.bumptech.glide.load.p018a.DataRewinderRegistry;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.load.p020b.ModelLoaderFactory;
import com.bumptech.glide.load.p020b.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.p030e.ResourceTranscoder;
import com.bumptech.glide.load.resource.p030e.TranscoderRegistry;
import com.bumptech.glide.p016c.EncoderRegistry;
import com.bumptech.glide.p016c.ImageHeaderParserRegistry;
import com.bumptech.glide.p016c.LoadPathCache;
import com.bumptech.glide.p016c.ModelToResourceClassCache;
import com.bumptech.glide.p016c.ResourceDecoderRegistry;
import com.bumptech.glide.p016c.ResourceEncoderRegistry;
import com.bumptech.glide.util.p033a.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class Registry {

    /* renamed from: h */
    private final ModelToResourceClassCache f358h = new ModelToResourceClassCache();

    /* renamed from: i */
    private final LoadPathCache f359i = new LoadPathCache();

    /* renamed from: j */
    private final Pools.Pool<List<Throwable>> f360j = FactoryPools.m11620a();

    /* renamed from: a */
    private final ModelLoaderRegistry f351a = new ModelLoaderRegistry(this.f360j);

    /* renamed from: b */
    private final EncoderRegistry f352b = new EncoderRegistry();

    /* renamed from: c */
    private final ResourceDecoderRegistry f353c = new ResourceDecoderRegistry();

    /* renamed from: d */
    private final ResourceEncoderRegistry f354d = new ResourceEncoderRegistry();

    /* renamed from: e */
    private final DataRewinderRegistry f355e = new DataRewinderRegistry();

    /* renamed from: f */
    private final TranscoderRegistry f356f = new TranscoderRegistry();

    /* renamed from: g */
    private final ImageHeaderParserRegistry f357g = new ImageHeaderParserRegistry();

    public Registry() {
        m12616a(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    /* renamed from: a */
    public <Data> Registry m12624a(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        this.f352b.m12549a(cls, encoder);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public <Data, TResource> Registry m12621a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        m12617a("legacy_append", cls, cls2, resourceDecoder);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public <Data, TResource> Registry m12617a(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f353c.m12537a(str, resourceDecoder, cls, cls2);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public final Registry m12616a(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f353c.m12536a(arrayList);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public <TResource> Registry m12623a(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        this.f354d.m12532a(cls, resourceEncoder);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public Registry m12626a(@NonNull DataRewinder.InterfaceC0616a<?> interfaceC0616a) {
        this.f355e.m12406a(interfaceC0616a);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public <TResource, Transcode> Registry m12620a(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f356f.m11816a(cls, cls2, resourceTranscoder);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public Registry m12627a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f357g.m12546a(imageHeaderParser);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public <Model, Data> Registry m12622a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f351a.m12320a(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    /* renamed from: b */
    public <Model, Data> Registry m12614b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f351a.m12316b(cls, cls2, modelLoaderFactory);
        return this;
    }

    @Nullable
    /* renamed from: a */
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> m12619a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> m12544a = this.f359i.m12544a(cls, cls2, cls3);
        if (this.f359i.m12545a(m12544a)) {
            return null;
        }
        if (m12544a == null) {
            List<DecodePath<Data, TResource, Transcode>> m12611c = m12611c(cls, cls2, cls3);
            m12544a = m12611c.isEmpty() ? null : new LoadPath<>(cls, cls2, cls3, m12611c, this.f360j);
            this.f359i.m12543a(cls, cls2, cls3, m12544a);
        }
        return m12544a;
    }

    @NonNull
    /* renamed from: c */
    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> m12611c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f353c.m12535b(cls, cls2)) {
            for (Class cls5 : this.f356f.m11815b(cls4, cls3)) {
                arrayList.add(new DecodePath(cls, cls4, cls5, this.f353c.m12539a(cls, cls4), this.f356f.m11817a(cls4, cls5), this.f360j));
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: b */
    public <Model, TResource, Transcode> List<Class<?>> m12613b(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> m12541a = this.f358h.m12541a(cls, cls2);
        if (m12541a == null) {
            m12541a = new ArrayList<>();
            for (Class<?> cls4 : this.f351a.m12321a((Class<?>) cls)) {
                for (Class<?> cls5 : this.f353c.m12535b(cls4, cls2)) {
                    if (!this.f356f.m11815b(cls5, cls3).isEmpty() && !m12541a.contains(cls5)) {
                        m12541a.add(cls5);
                    }
                }
            }
            this.f358h.m12540a(cls, cls2, Collections.unmodifiableList(m12541a));
        }
        return m12541a;
    }

    /* renamed from: a */
    public boolean m12625a(@NonNull Resource<?> resource) {
        return this.f354d.m12533a(resource.mo11853c()) != null;
    }

    @NonNull
    /* renamed from: b */
    public <X> ResourceEncoder<X> m12615b(@NonNull Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> m12533a = this.f354d.m12533a(resource.mo11853c());
        if (m12533a != null) {
            return m12533a;
        }
        throw new NoResultEncoderAvailableException(resource.mo11853c());
    }

    @NonNull
    /* renamed from: a */
    public <X> Encoder<X> m12618a(@NonNull X x) throws NoSourceEncoderAvailableException {
        Encoder<X> m12550a = this.f352b.m12550a(x.getClass());
        if (m12550a != null) {
            return m12550a;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    @NonNull
    /* renamed from: b */
    public <X> DataRewinder<X> m12612b(@NonNull X x) {
        return this.f355e.m12405a((DataRewinderRegistry) x);
    }

    @NonNull
    /* renamed from: c */
    public <Model> List<ModelLoader<Model, ?>> m12610c(@NonNull Model model) {
        List<ModelLoader<Model, ?>> m12319a = this.f351a.m12319a((ModelLoaderRegistry) model);
        if (m12319a.isEmpty()) {
            throw new NoModelLoaderAvailableException(model);
        }
        return m12319a;
    }

    @NonNull
    /* renamed from: a */
    public List<ImageHeaderParser> m12628a() {
        List<ImageHeaderParser> m12547a = this.f357g.m12547a();
        if (m12547a.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return m12547a;
    }

    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }
}
