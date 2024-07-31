package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.p008v4.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.p018a.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.q */
/* loaded from: classes.dex */
public class LoadPath<Data, ResourceType, Transcode> {

    /* renamed from: a */
    private final Class<Data> f967a;

    /* renamed from: b */
    private final Pools.Pool<List<Throwable>> f968b;

    /* renamed from: c */
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> f969c;

    /* renamed from: d */
    private final String f970d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f967a = cls;
        this.f968b = pool;
        this.f969c = (List) Preconditions.m11577a(list);
        this.f970d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* renamed from: a */
    public Resource<Transcode> m12033a(DataRewinder<Data> dataRewinder, @NonNull Options options, int i, int i2, DecodePath.InterfaceC0720a<ResourceType> interfaceC0720a) throws GlideException {
        List<Throwable> list = (List) Preconditions.m11580a(this.f968b.acquire());
        try {
            return m12032a(dataRewinder, options, i, i2, interfaceC0720a, list);
        } finally {
            this.f968b.release(list);
        }
    }

    /* renamed from: a */
    private Resource<Transcode> m12032a(DataRewinder<Data> dataRewinder, @NonNull Options options, int i, int i2, DecodePath.InterfaceC0720a<ResourceType> interfaceC0720a, List<Throwable> list) throws GlideException {
        int size = this.f969c.size();
        Resource<Transcode> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                resource = this.f969c.get(i3).m12083a(dataRewinder, i, i2, options, interfaceC0720a);
            } catch (GlideException e) {
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f970d, new ArrayList(list));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f969c.toArray()) + '}';
    }
}
