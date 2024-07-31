package com.navatics.miya.p060b;

import com.navatics.miya.ClassResolver;
import com.navatics.miya.Miya;
import com.navatics.miya.Registration;
import com.navatics.miya.p059a.Output;

/* renamed from: com.navatics.miya.b.a */
/* loaded from: classes.dex */
public class DefaultClassResolver implements ClassResolver {

    /* renamed from: a */
    protected Miya f5983a;

    /* renamed from: d */
    protected IdentityObjectIntMap<Class> f5986d;

    /* renamed from: e */
    protected IntMap<Class> f5987e;

    /* renamed from: f */
    protected int f5988f;

    /* renamed from: h */
    private Class f5990h;

    /* renamed from: i */
    private Registration f5991i;

    /* renamed from: b */
    protected final IntMap<Registration> f5984b = new IntMap<>();

    /* renamed from: c */
    protected final ObjectMap<Class, Registration> f5985c = new ObjectMap<>();

    /* renamed from: g */
    private int f5989g = -1;

    @Override // com.navatics.miya.ClassResolver
    /* renamed from: a */
    public void mo6717a(Miya miya) {
        this.f5983a = miya;
    }

    @Override // com.navatics.miya.ClassResolver
    /* renamed from: a */
    public Registration mo6716a(Registration registration) {
        if (registration == null) {
            throw new IllegalArgumentException("registration cannot be null.");
        }
        if (registration.m6651c() != -1) {
            this.f5984b.m6687a(registration.m6651c(), registration);
        }
        this.f5985c.m6674a(registration.m6654a(), registration);
        if (registration.m6654a().isPrimitive()) {
            this.f5985c.m6674a(C2012j.m6661a(registration.m6654a()), registration);
        }
        return registration;
    }

    @Override // com.navatics.miya.ClassResolver
    /* renamed from: a */
    public Registration mo6715a(Class cls) {
        return mo6716a(new Registration(cls, this.f5983a.m6740a(cls), -1));
    }

    @Override // com.navatics.miya.ClassResolver
    /* renamed from: b */
    public Registration mo6714b(Class cls) {
        if (cls == this.f5990h) {
            return this.f5991i;
        }
        Registration m6675a = this.f5985c.m6675a((ObjectMap<Class, Registration>) cls);
        if (m6675a != null) {
            this.f5990h = cls;
            this.f5991i = m6675a;
        }
        return m6675a;
    }

    @Override // com.navatics.miya.ClassResolver
    /* renamed from: a */
    public Registration mo6720a(int i) {
        return this.f5984b.m6688a(i);
    }

    @Override // com.navatics.miya.ClassResolver
    /* renamed from: a */
    public Registration mo6719a(Output output, Class cls) {
        if (cls == null) {
            output.m6763a((byte) 0);
            return null;
        }
        Registration m6730c = this.f5983a.m6730c(cls);
        if (m6730c.m6651c() == -1) {
            m6718a(output, cls, m6730c);
        } else {
            output.m6758a(m6730c.m6651c() + 2, true);
        }
        return m6730c;
    }

    /* renamed from: a */
    protected void m6718a(Output output, Class cls, Registration registration) {
        int m6696b;
        output.m6748b(1);
        IdentityObjectIntMap<Class> identityObjectIntMap = this.f5986d;
        if (identityObjectIntMap != null && (m6696b = identityObjectIntMap.m6696b(cls, -1)) != -1) {
            output.m6758a(m6696b, true);
            return;
        }
        int i = this.f5988f;
        this.f5988f = i + 1;
        if (this.f5986d == null) {
            this.f5986d = new IdentityObjectIntMap<>();
        }
        this.f5986d.m6699a(cls, i);
        output.m6758a(i, true);
        if (registration.m6652b()) {
            output.m6747b(cls.getName());
        } else {
            output.m6755a(cls.getName());
        }
    }

    @Override // com.navatics.miya.ClassResolver
    /* renamed from: a */
    public void mo6721a() {
        if (this.f5983a.m6736b()) {
            return;
        }
        IdentityObjectIntMap<Class> identityObjectIntMap = this.f5986d;
        if (identityObjectIntMap != null) {
            identityObjectIntMap.m6700a(2048);
        }
        IntMap<Class> intMap = this.f5987e;
        if (intMap != null) {
            intMap.m6689a();
        }
        this.f5988f = 0;
    }
}
