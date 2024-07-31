package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.h */
/* loaded from: classes.dex */
public class GraphRequestBatch extends AbstractList<GraphRequest> {

    /* renamed from: a */
    private static AtomicInteger f1866a = new AtomicInteger();

    /* renamed from: b */
    private Handler f1867b;

    /* renamed from: c */
    private List<GraphRequest> f1868c;

    /* renamed from: d */
    private int f1869d = 0;

    /* renamed from: e */
    private final String f1870e = Integer.valueOf(f1866a.incrementAndGet()).toString();

    /* renamed from: f */
    private List<InterfaceC0919a> f1871f = new ArrayList();

    /* renamed from: g */
    private String f1872g;

    /* compiled from: GraphRequestBatch.java */
    /* renamed from: com.facebook.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0919a {
        /* renamed from: a */
        void mo10082a(GraphRequestBatch graphRequestBatch);
    }

    /* compiled from: GraphRequestBatch.java */
    /* renamed from: com.facebook.h$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0920b extends InterfaceC0919a {
        /* renamed from: a */
        void m10832a(GraphRequestBatch graphRequestBatch, long j, long j2);
    }

    public GraphRequestBatch() {
        this.f1868c = new ArrayList();
        this.f1868c = new ArrayList();
    }

    public GraphRequestBatch(Collection<GraphRequest> collection) {
        this.f1868c = new ArrayList();
        this.f1868c = new ArrayList(collection);
    }

    public GraphRequestBatch(GraphRequest... graphRequestArr) {
        this.f1868c = new ArrayList();
        this.f1868c = Arrays.asList(graphRequestArr);
    }

    /* renamed from: a */
    public int m10849a() {
        return this.f1869d;
    }

    /* renamed from: a */
    public void m10844a(InterfaceC0919a interfaceC0919a) {
        if (this.f1871f.contains(interfaceC0919a)) {
            return;
        }
        this.f1871f.add(interfaceC0919a);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: a */
    public final boolean add(GraphRequest graphRequest) {
        return this.f1868c.add(graphRequest);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public final void add(int i, GraphRequest graphRequest) {
        this.f1868c.add(i, graphRequest);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f1868c.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public final GraphRequest get(int i) {
        return this.f1868c.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b */
    public final GraphRequest remove(int i) {
        return this.f1868c.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b */
    public final GraphRequest set(int i, GraphRequest graphRequest) {
        return this.f1868c.set(i, graphRequest);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1868c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final String m10843b() {
        return this.f1870e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final Handler m10840c() {
        return this.f1867b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m10846a(Handler handler) {
        this.f1867b = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final List<GraphRequest> m10839d() {
        return this.f1868c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final List<InterfaceC0919a> m10838e() {
        return this.f1871f;
    }

    /* renamed from: f */
    public final String m10837f() {
        return this.f1872g;
    }

    /* renamed from: g */
    public final List<GraphResponse> m10836g() {
        return m10834i();
    }

    /* renamed from: h */
    public final GraphRequestAsyncTask m10835h() {
        return m10833j();
    }

    /* renamed from: i */
    List<GraphResponse> m10834i() {
        return GraphRequest.m11369b(this);
    }

    /* renamed from: j */
    GraphRequestAsyncTask m10833j() {
        return GraphRequest.m11363c(this);
    }
}
