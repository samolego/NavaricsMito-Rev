package com.navatics.miya.serializers;

import com.navatics.miya.Miya;
import com.navatics.miya.MiyaException;
import com.navatics.miya.Serializer;
import com.navatics.miya.p059a.Output;
import com.navatics.miya.p060b.Generics;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class FieldSerializer<T> extends Serializer<T> {

    /* renamed from: a */
    final Miya f6057a;

    /* renamed from: b */
    final Class f6058b;

    /* renamed from: c */
    final C2018b f6059c;

    /* renamed from: d */
    final CachedFields f6060d;

    /* renamed from: e */
    private final Generics.C2011b f6061e;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface Ignore {
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface NotNull {
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface Optional {
        /* renamed from: a */
        String m6637a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m6639b() {
    }

    public FieldSerializer(Miya miya, Class cls, C2018b c2018b) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("type cannot be a primitive class: " + cls);
        } else if (c2018b == null) {
            throw new IllegalArgumentException("config cannot be null.");
        } else {
            this.f6057a = miya;
            this.f6058b = cls;
            this.f6059c = c2018b;
            this.f6061e = new Generics.C2011b(cls);
            this.f6060d = new CachedFields(this);
            this.f6060d.m6635a();
        }
    }

    @Override // com.navatics.miya.Serializer
    /* renamed from: a */
    public void mo6619a(Miya miya, Output output, T t) {
        int m6638c = m6638c();
        for (AbstractC2017a abstractC2017a : this.f6060d.f6077b) {
            abstractC2017a.mo6616a(output, t);
        }
        if (m6638c > 0) {
            m6640a(m6638c);
        }
    }

    /* renamed from: c */
    protected int m6638c() {
        Generics.C2010a[] m6708b = this.f6057a.m6725f().m6708b();
        if (m6708b == null) {
            return 0;
        }
        return this.f6057a.m6725f().m6710a(this.f6061e, m6708b);
    }

    /* renamed from: a */
    protected void m6640a(int i) {
        Generics m6725f = this.f6057a.m6725f();
        m6725f.m6712a(i);
        m6725f.m6713a();
    }

    /* renamed from: com.navatics.miya.serializers.FieldSerializer$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2017a {

        /* renamed from: a */
        final Field f6062a;

        /* renamed from: b */
        String f6063b;

        /* renamed from: c */
        Class f6064c;

        /* renamed from: d */
        Serializer f6065d;

        /* renamed from: e */
        boolean f6066e;

        /* renamed from: f */
        boolean f6067f = true;

        /* renamed from: a */
        public abstract void mo6616a(Output output, Object obj);

        public AbstractC2017a(Field field) {
            this.f6062a = field;
        }

        public String toString() {
            return this.f6063b;
        }
    }

    /* renamed from: com.navatics.miya.serializers.FieldSerializer$b */
    /* loaded from: classes.dex */
    public static class C2018b implements Cloneable {

        /* renamed from: d */
        boolean f6071d;

        /* renamed from: f */
        boolean f6073f;

        /* renamed from: h */
        boolean f6075h;

        /* renamed from: a */
        boolean f6068a = true;

        /* renamed from: b */
        boolean f6069b = true;

        /* renamed from: c */
        boolean f6070c = true;

        /* renamed from: e */
        boolean f6072e = true;

        /* renamed from: g */
        boolean f6074g = true;

        /* renamed from: a */
        public C2018b clone() {
            try {
                return (C2018b) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new MiyaException(e);
            }
        }
    }
}
