package com.navatics.miya;

import com.navatics.miya.Serializer;
import com.navatics.miya.p060b.C2012j;
import com.navatics.miya.serializers.FieldSerializer;

/* renamed from: com.navatics.miya.g */
/* loaded from: classes.dex */
public interface SerializerFactory<T extends Serializer> {

    /* compiled from: SerializerFactory.java */
    /* renamed from: com.navatics.miya.g$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2013a<T extends Serializer> implements SerializerFactory<T> {
        @Override // com.navatics.miya.SerializerFactory
        /* renamed from: a */
        public boolean mo6646a(Class cls) {
            return true;
        }
    }

    /* renamed from: a */
    T mo6643a(Miya miya, Class cls);

    /* renamed from: a */
    boolean mo6646a(Class cls);

    /* compiled from: SerializerFactory.java */
    /* renamed from: com.navatics.miya.g$c */
    /* loaded from: classes.dex */
    public static class C2015c<T extends Serializer> extends AbstractC2013a<T> {

        /* renamed from: a */
        private final Class<T> f6053a;

        public C2015c(Class<T> cls) {
            this.f6053a = cls;
        }

        @Override // com.navatics.miya.SerializerFactory
        /* renamed from: a */
        public T mo6643a(Miya miya, Class cls) {
            return (T) m6644a(miya, this.f6053a, cls);
        }

        /* renamed from: a */
        public static <T extends Serializer> T m6644a(Miya miya, Class<T> cls, Class cls2) {
            try {
                try {
                    try {
                        try {
                            return cls.getConstructor(Miya.class, Class.class).newInstance(miya, cls2);
                        } catch (NoSuchMethodException unused) {
                            return cls.getConstructor(Class.class).newInstance(cls2);
                        }
                    } catch (NoSuchMethodException unused2) {
                        return cls.getConstructor(Miya.class).newInstance(miya);
                    }
                } catch (NoSuchMethodException unused3) {
                    return cls.newInstance();
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Unable to create serializer \"" + cls.getName() + "\" for class: " + C2012j.m6659b(cls2), e);
            }
        }
    }

    /* compiled from: SerializerFactory.java */
    /* renamed from: com.navatics.miya.g$d */
    /* loaded from: classes.dex */
    public static class C2016d<T extends Serializer> extends AbstractC2013a<T> {

        /* renamed from: a */
        private final T f6054a;

        public C2016d(T t) {
            this.f6054a = t;
        }

        @Override // com.navatics.miya.SerializerFactory
        /* renamed from: a */
        public T mo6643a(Miya miya, Class cls) {
            return this.f6054a;
        }
    }

    /* compiled from: SerializerFactory.java */
    /* renamed from: com.navatics.miya.g$b */
    /* loaded from: classes.dex */
    public static class C2014b extends AbstractC2013a<FieldSerializer> {

        /* renamed from: a */
        private final FieldSerializer.C2018b f6052a = new FieldSerializer.C2018b();

        @Override // com.navatics.miya.SerializerFactory
        /* renamed from: b */
        public FieldSerializer mo6643a(Miya miya, Class cls) {
            return new FieldSerializer(miya, cls, this.f6052a.clone());
        }
    }
}
