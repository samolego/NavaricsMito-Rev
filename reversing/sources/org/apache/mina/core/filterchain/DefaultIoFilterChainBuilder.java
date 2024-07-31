package org.apache.mina.core.filterchain;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.core.filterchain.b */
/* loaded from: classes2.dex */
public class DefaultIoFilterChainBuilder implements IoFilterChainBuilder {

    /* renamed from: b */
    private static final InterfaceC3153b f11458b = C3154c.m262a(DefaultIoFilterChainBuilder.class);

    /* renamed from: c */
    private final List<IoFilterChain.InterfaceC3074a> f11459c = new CopyOnWriteArrayList();

    /* renamed from: a */
    public IoFilterChain.InterfaceC3074a m1119a(String str) {
        for (IoFilterChain.InterfaceC3074a interfaceC3074a : this.f11459c) {
            if (interfaceC3074a.mo1087a().equals(str)) {
                return interfaceC3074a;
            }
        }
        return null;
    }

    /* renamed from: b */
    public boolean m1117b(String str) {
        return m1119a(str) != null;
    }

    /* renamed from: a */
    public synchronized void m1118a(String str, IoFilter ioFilter) {
        m1120a(0, new C3072a(str, ioFilter));
    }

    /* renamed from: b */
    public synchronized void m1116b(String str, IoFilter ioFilter) {
        m1120a(this.f11459c.size(), new C3072a(str, ioFilter));
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChainBuilder
    /* renamed from: a */
    public void mo1084a(IoFilterChain ioFilterChain) throws Exception {
        for (IoFilterChain.InterfaceC3074a interfaceC3074a : this.f11459c) {
            ioFilterChain.mo1096b(interfaceC3074a.mo1087a(), interfaceC3074a.mo1086b());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        boolean z = true;
        for (IoFilterChain.InterfaceC3074a interfaceC3074a : this.f11459c) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append('(');
            sb.append(interfaceC3074a.mo1087a());
            sb.append(':');
            sb.append(interfaceC3074a.mo1086b());
            sb.append(')');
        }
        if (z) {
            sb.append("empty");
        }
        sb.append(" }");
        return sb.toString();
    }

    /* renamed from: a */
    private void m1120a(int i, IoFilterChain.InterfaceC3074a interfaceC3074a) {
        if (m1117b(interfaceC3074a.mo1087a())) {
            throw new IllegalArgumentException("Other filter is using the same name: " + interfaceC3074a.mo1087a());
        }
        this.f11459c.add(i, interfaceC3074a);
    }

    /* compiled from: DefaultIoFilterChainBuilder.java */
    /* renamed from: org.apache.mina.core.filterchain.b$a */
    /* loaded from: classes2.dex */
    private final class C3072a implements IoFilterChain.InterfaceC3074a {

        /* renamed from: b */
        private final String f11461b;

        /* renamed from: c */
        private volatile IoFilter f11462c;

        private C3072a(String str, IoFilter ioFilter) {
            if (str == null) {
                throw new IllegalArgumentException("name");
            }
            if (ioFilter == null) {
                throw new IllegalArgumentException("filter");
            }
            this.f11461b = str;
            this.f11462c = ioFilter;
        }

        @Override // org.apache.mina.core.filterchain.IoFilterChain.InterfaceC3074a
        /* renamed from: a */
        public String mo1087a() {
            return this.f11461b;
        }

        @Override // org.apache.mina.core.filterchain.IoFilterChain.InterfaceC3074a
        /* renamed from: b */
        public IoFilter mo1086b() {
            return this.f11462c;
        }

        @Override // org.apache.mina.core.filterchain.IoFilterChain.InterfaceC3074a
        /* renamed from: c */
        public IoFilter.InterfaceC3073a mo1085c() {
            throw new IllegalStateException();
        }

        public String toString() {
            return "(" + mo1087a() + ':' + this.f11462c + ')';
        }
    }
}
