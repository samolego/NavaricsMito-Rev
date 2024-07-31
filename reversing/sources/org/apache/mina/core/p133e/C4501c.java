package org.apache.mina.core.p133e;

import java.net.SocketAddress;
import java.util.Collections;
import java.util.Set;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.util.IdentityHashSet;

/* renamed from: org.apache.mina.core.e.c */
/* loaded from: classes2.dex */
public class DefaultTransportMetadata implements TransportMetadata {

    /* renamed from: a */
    private final String f11393a;

    /* renamed from: b */
    private final String f11394b;

    /* renamed from: c */
    private final boolean f11395c;

    /* renamed from: d */
    private final boolean f11396d;

    /* renamed from: e */
    private final Class<? extends SocketAddress> f11397e;

    /* renamed from: f */
    private final Class<? extends IoSessionConfig> f11398f;

    /* renamed from: g */
    private final Set<Class<? extends Object>> f11399g;

    public DefaultTransportMetadata(String str, String str2, boolean z, boolean z2, Class<? extends SocketAddress> cls, Class<? extends IoSessionConfig> cls2, Class<?>... clsArr) {
        if (str == null) {
            throw new IllegalArgumentException("providerName");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("name");
        }
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.length() == 0) {
            throw new IllegalArgumentException("providerName is empty.");
        }
        String lowerCase2 = str2.trim().toLowerCase();
        if (lowerCase2.length() == 0) {
            throw new IllegalArgumentException("name is empty.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("addressType");
        }
        if (clsArr == null) {
            throw new IllegalArgumentException("envelopeTypes");
        }
        if (clsArr.length == 0) {
            throw new IllegalArgumentException("envelopeTypes is empty.");
        }
        if (cls2 == null) {
            throw new IllegalArgumentException("sessionConfigType");
        }
        this.f11393a = lowerCase;
        this.f11394b = lowerCase2;
        this.f11395c = z;
        this.f11396d = z2;
        this.f11397e = cls;
        this.f11398f = cls2;
        IdentityHashSet identityHashSet = new IdentityHashSet();
        for (Class<?> cls3 : clsArr) {
            identityHashSet.add(cls3);
        }
        this.f11399g = Collections.unmodifiableSet(identityHashSet);
    }

    @Override // org.apache.mina.core.p133e.TransportMetadata
    /* renamed from: a */
    public Class<? extends SocketAddress> mo1157a() {
        return this.f11397e;
    }

    @Override // org.apache.mina.core.p133e.TransportMetadata
    /* renamed from: b */
    public Class<? extends IoSessionConfig> mo1156b() {
        return this.f11398f;
    }

    @Override // org.apache.mina.core.p133e.TransportMetadata
    /* renamed from: c */
    public String mo1155c() {
        return this.f11393a;
    }

    @Override // org.apache.mina.core.p133e.TransportMetadata
    /* renamed from: d */
    public String mo1154d() {
        return this.f11394b;
    }

    @Override // org.apache.mina.core.p133e.TransportMetadata
    /* renamed from: e */
    public boolean mo1153e() {
        return this.f11395c;
    }

    @Override // org.apache.mina.core.p133e.TransportMetadata
    /* renamed from: f */
    public boolean mo1152f() {
        return this.f11396d;
    }

    public String toString() {
        return this.f11394b;
    }
}
