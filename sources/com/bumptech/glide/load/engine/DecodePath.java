package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.p008v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.p018a.DataRewinder;
import com.bumptech.glide.load.resource.p030e.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.g */
/* loaded from: classes.dex */
public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: a */
    private final Class<DataType> f890a;

    /* renamed from: b */
    private final List<? extends ResourceDecoder<DataType, ResourceType>> f891b;

    /* renamed from: c */
    private final ResourceTranscoder<ResourceType, Transcode> f892c;

    /* renamed from: d */
    private final Pools.Pool<List<Throwable>> f893d;

    /* renamed from: e */
    private final String f894e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodePath.java */
    /* renamed from: com.bumptech.glide.load.engine.g$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0720a<ResourceType> {
        @NonNull
        /* renamed from: a */
        Resource<ResourceType> mo12081a(@NonNull Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.f890a = cls;
        this.f891b = list;
        this.f892c = resourceTranscoder;
        this.f893d = pool;
        this.f894e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* renamed from: a */
    public Resource<Transcode> m12083a(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options, InterfaceC0720a<ResourceType> interfaceC0720a) throws GlideException {
        return this.f892c.mo11812a(interfaceC0720a.mo12081a(m12084a(dataRewinder, i, i2, options)), options);
    }

    @NonNull
    /* renamed from: a */
    private Resource<ResourceType> m12084a(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options) throws GlideException {
        List<Throwable> list = (List) Preconditions.m11580a(this.f893d.acquire());
        try {
            return m12082a(dataRewinder, i, i2, options, list);
        } finally {
            this.f893d.release(list);
        }
    }

    @NonNull
    /* renamed from: a */
    private Resource<ResourceType> m12082a(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options, List<Throwable> list) throws GlideException {
        int size = this.f891b.size();
        Resource<ResourceType> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder<DataType, ResourceType> resourceDecoder = this.f891b.get(i3);
            try {
                if (resourceDecoder.mo11819a(dataRewinder.mo12010a(), options)) {
                    resource = resourceDecoder.mo11820a(dataRewinder.mo12010a(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + resourceDecoder, e);
                }
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f894e, new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f890a + ", decoders=" + this.f891b + ", transcoder=" + this.f892c + '}';
    }
}
