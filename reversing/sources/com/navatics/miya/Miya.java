package com.navatics.miya;

import com.navatics.miya.SerializerFactory;
import com.navatics.miya.p059a.Output;
import com.navatics.miya.p060b.C2012j;
import com.navatics.miya.p060b.DefaultClassResolver;
import com.navatics.miya.p060b.DefaultInstantiatorStrategy;
import com.navatics.miya.p060b.Generics;
import com.navatics.miya.p060b.IntArray;
import com.navatics.miya.p060b.Log;
import com.navatics.miya.p060b.ObjectMap;
import com.navatics.miya.serializers.CollectionSerializer;
import com.navatics.miya.serializers.DefaultSerializers;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.objenesis.p151a.InstantiatorStrategy;

/* renamed from: com.navatics.miya.b */
/* loaded from: classes.dex */
public class Miya {

    /* renamed from: c */
    private final int f5963c;

    /* renamed from: d */
    private final ClassResolver f5964d;

    /* renamed from: e */
    private int f5965e;

    /* renamed from: h */
    private boolean f5968h;

    /* renamed from: i */
    private boolean f5969i;

    /* renamed from: j */
    private int f5970j;

    /* renamed from: m */
    private ObjectMap f5973m;

    /* renamed from: n */
    private ObjectMap f5974n;

    /* renamed from: o */
    private ReferenceResolver f5975o;

    /* renamed from: q */
    private boolean f5977q;

    /* renamed from: s */
    private Object f5979s;

    /* renamed from: a */
    private SerializerFactory f5961a = new SerializerFactory.C2014b();

    /* renamed from: b */
    private final ArrayList<C2009a> f5962b = new ArrayList<>(53);

    /* renamed from: f */
    private ClassLoader f5966f = getClass().getClassLoader();

    /* renamed from: g */
    private InstantiatorStrategy f5967g = new DefaultInstantiatorStrategy();

    /* renamed from: k */
    private int f5971k = Integer.MAX_VALUE;

    /* renamed from: l */
    private boolean f5972l = true;

    /* renamed from: p */
    private final IntArray f5976p = new IntArray(0);

    /* renamed from: r */
    private boolean f5978r = true;

    /* renamed from: t */
    private final Generics f5980t = new Generics(this);

    private Miya(ClassResolver classResolver, ReferenceResolver referenceResolver) {
        if (classResolver == null) {
            throw new IllegalArgumentException("classResolver cannot be null.");
        }
        this.f5964d = classResolver;
        if (referenceResolver != null) {
            this.f5975o = referenceResolver;
            this.f5977q = true;
        }
        classResolver.mo6717a(this);
        m6737a(MiyaSerializable.class, DefaultSerializers.C2028j.class);
        m6737a(Class.class, DefaultSerializers.C2022d.class);
        m6737a(Date.class, DefaultSerializers.C2023e.class);
        m6737a(Collection.class, CollectionSerializer.class);
        m6739a(Void.TYPE, new DefaultSerializers.C2031m());
        this.f5963c = this.f5962b.size();
        m6732b(Integer.TYPE, new DefaultSerializers.C2026h());
        m6732b(String.class, new DefaultSerializers.C2030l());
        m6732b(Float.TYPE, new DefaultSerializers.C2025g());
        m6732b(Boolean.TYPE, new DefaultSerializers.C2019a());
        m6732b(Byte.TYPE, new DefaultSerializers.C2020b());
        m6732b(Character.TYPE, new DefaultSerializers.C2021c());
        m6732b(Short.TYPE, new DefaultSerializers.C2029k());
        m6732b(Long.TYPE, new DefaultSerializers.C2027i());
        m6732b(Double.TYPE, new DefaultSerializers.C2024f());
    }

    /* renamed from: a */
    public static Miya m6744a() {
        return new Miya(new DefaultClassResolver(), null);
    }

    /* renamed from: a */
    public void m6739a(Class cls, Serializer serializer) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        m6738a(cls, new SerializerFactory.C2016d(serializer));
    }

    /* renamed from: a */
    public void m6737a(Class cls, Class<? extends Serializer> cls2) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (cls2 == null) {
            throw new IllegalArgumentException("serializerClass cannot be null.");
        }
        m6738a(cls, new SerializerFactory.C2015c(cls2));
    }

    /* renamed from: a */
    private int m6738a(Class cls, SerializerFactory serializerFactory) {
        int size = this.f5962b.size() - this.f5963c;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (cls.isAssignableFrom(this.f5962b.get(i2).f5981a)) {
                i = i2 + 1;
            }
        }
        this.f5962b.add(i, new C2009a(cls, serializerFactory));
        return i;
    }

    /* renamed from: a */
    public Serializer m6740a(Class cls) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        int size = this.f5962b.size();
        for (int i = 0; i < size; i++) {
            C2009a c2009a = this.f5962b.get(i);
            if (c2009a.f5981a.isAssignableFrom(cls) && c2009a.f5982b.mo6646a(cls)) {
                return c2009a.f5982b.mo6643a(this, cls);
            }
        }
        return m6733b(cls);
    }

    /* renamed from: b */
    protected Serializer m6733b(Class cls) {
        return this.f5961a.mo6643a(this, cls);
    }

    /* renamed from: b */
    public boolean m6736b() {
        return this.f5968h;
    }

    /* renamed from: b */
    public Registration m6732b(Class cls, Serializer serializer) {
        Registration mo6714b = this.f5964d.mo6714b(cls);
        if (mo6714b != null) {
            mo6714b.m6653a(serializer);
            return mo6714b;
        }
        return this.f5964d.mo6716a(new Registration(cls, serializer, m6723g()));
    }

    /* renamed from: g */
    private int m6723g() {
        while (true) {
            int i = this.f5965e;
            if (i != -2) {
                if (this.f5964d.mo6720a(i) == null) {
                    return this.f5965e;
                }
                this.f5965e++;
            } else {
                throw new MiyaException("No registration IDs are available.");
            }
        }
    }

    /* renamed from: c */
    public Registration m6730c(Class cls) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        Registration mo6714b = this.f5964d.mo6714b(cls);
        if (mo6714b == null) {
            if (this.f5968h) {
                throw new IllegalArgumentException(m6728d(cls));
            }
            if (this.f5969i) {
                Log.m6678a("miya", m6728d(cls));
            }
            return this.f5964d.mo6715a(cls);
        }
        return mo6714b;
    }

    /* renamed from: d */
    protected String m6728d(Class cls) {
        return "Class is not registered: " + C2012j.m6659b(cls) + "\nNote: To register this class use: miya.register(" + C2012j.m6659b(cls) + ".class);";
    }

    /* renamed from: e */
    public Serializer m6726e(Class cls) {
        return m6730c(cls).m6650d();
    }

    /* renamed from: a */
    public Registration m6743a(Output output, Class cls) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        try {
            return this.f5964d.mo6719a(output, cls);
        } finally {
            if (this.f5970j == 0 && this.f5972l) {
                m6731c();
            }
        }
    }

    /* renamed from: a */
    public void m6742a(Output output, Object obj) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (obj == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        m6722h();
        try {
            m6730c(obj.getClass()).m6650d().mo6619a(this, output, obj);
        } finally {
            int i = this.f5970j - 1;
            this.f5970j = i;
            if (i == 0 && this.f5972l) {
                m6731c();
            }
        }
    }

    /* renamed from: a */
    public void m6741a(Output output, Object obj, Serializer serializer) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (obj == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        m6722h();
        try {
            serializer.mo6619a(this, output, obj);
        } finally {
            int i = this.f5970j - 1;
            this.f5970j = i;
            if (i == 0 && this.f5972l) {
                m6731c();
            }
        }
    }

    /* renamed from: b */
    public void m6734b(Output output, Object obj, Serializer serializer) {
        int i;
        boolean z;
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        m6722h();
        try {
            if (!serializer.m6649a()) {
                if (obj == null) {
                    output.m6763a((byte) 0);
                    if (i == 0) {
                        if (z) {
                            return;
                        }
                        return;
                    }
                    return;
                }
                output.m6763a((byte) 1);
            }
            serializer.mo6619a(this, output, obj);
            int i2 = this.f5970j - 1;
            this.f5970j = i2;
            if (i2 == 0 && this.f5972l) {
                m6731c();
            }
        } finally {
            i = this.f5970j - 1;
            this.f5970j = i;
            if (i == 0 && this.f5972l) {
                m6731c();
            }
        }
    }

    /* renamed from: b */
    public void m6735b(Output output, Object obj) {
        int i;
        boolean z;
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        m6722h();
        try {
            if (obj == null) {
                m6743a(output, (Class) null);
                if (i == 0) {
                    if (z) {
                        return;
                    }
                    return;
                }
                return;
            }
            m6743a(output, (Class) obj.getClass()).m6650d().mo6619a(this, output, obj);
            int i2 = this.f5970j - 1;
            this.f5970j = i2;
            if (i2 == 0 && this.f5972l) {
                m6731c();
            }
        } finally {
            i = this.f5970j - 1;
            this.f5970j = i;
            if (i == 0 && this.f5972l) {
                m6731c();
            }
        }
    }

    /* renamed from: c */
    public void m6731c() {
        this.f5970j = 0;
        ObjectMap objectMap = this.f5974n;
        if (objectMap != null) {
            objectMap.m6676a(2048);
        }
        this.f5964d.mo6721a();
        if (this.f5977q) {
            this.f5975o.m6655a();
            this.f5979s = null;
        }
    }

    /* renamed from: f */
    public boolean m6724f(Class cls) {
        if (cls != null) {
            return cls.isArray() ? Modifier.isFinal(C2012j.m6657d(cls).getModifiers()) : Modifier.isFinal(cls.getModifiers());
        }
        throw new IllegalArgumentException("type cannot be null.");
    }

    /* renamed from: d */
    public ObjectMap m6729d() {
        if (this.f5973m == null) {
            this.f5973m = new ObjectMap();
        }
        return this.f5973m;
    }

    /* renamed from: e */
    public int m6727e() {
        return this.f5970j;
    }

    /* renamed from: h */
    private void m6722h() {
        int i = this.f5970j;
        if (i == this.f5971k) {
            throw new MiyaException("Max depth exceeded: " + this.f5970j);
        }
        this.f5970j = i + 1;
    }

    /* renamed from: f */
    public Generics m6725f() {
        return this.f5980t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Miya.java */
    /* renamed from: com.navatics.miya.b$a */
    /* loaded from: classes.dex */
    public static final class C2009a {

        /* renamed from: a */
        final Class f5981a;

        /* renamed from: b */
        final SerializerFactory f5982b;

        C2009a(Class cls, SerializerFactory serializerFactory) {
            this.f5981a = cls;
            this.f5982b = serializerFactory;
        }
    }
}
