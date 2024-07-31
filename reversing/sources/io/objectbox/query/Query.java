package io.objectbox.query;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.InternalAccess;
import io.objectbox.p092b.SubscriptionBuilder;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class Query<T> {

    /* renamed from: a */
    final Box<T> f9544a;

    /* renamed from: b */
    long f9545b;

    /* renamed from: c */
    private final BoxStore f9546c;

    /* renamed from: d */
    private final boolean f9547d;

    /* renamed from: e */
    private final QueryPublisher<T> f9548e;

    /* renamed from: f */
    private final List<EagerRelation> f9549f;

    /* renamed from: g */
    private final QueryFilter<T> f9550g;

    /* renamed from: h */
    private final Comparator<T> f9551h;

    /* renamed from: i */
    private final int f9552i;

    /* renamed from: j */
    private final int f9553j = 10;

    native void nativeDestroy(long j);

    native List nativeFind(long j, long j2, long j3, long j4);

    native Object nativeFindFirst(long j, long j2);

    native Object nativeFindUnique(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Query(Box<T> box, long j, boolean z, List<EagerRelation> list, QueryFilter<T> queryFilter, Comparator<T> comparator) {
        this.f9544a = box;
        this.f9546c = box.m3415f();
        this.f9552i = this.f9546c.m3465l();
        this.f9545b = j;
        this.f9547d = z;
        this.f9548e = new QueryPublisher<>(this, box);
        this.f9549f = list;
        this.f9550g = queryFilter;
        this.f9551h = comparator;
    }

    protected void finalize() throws Throwable {
        m3311a();
        super.finalize();
    }

    /* renamed from: a */
    public synchronized void m3311a() {
        if (this.f9545b != 0) {
            nativeDestroy(this.f9545b);
            this.f9545b = 0L;
        }
    }

    /* renamed from: b */
    long m3304b() {
        return InternalAccess.m3344b(this.f9544a);
    }

    @Nullable
    /* renamed from: c */
    public T m3302c() {
        m3298g();
        return (T) m3305a((Callable<Object>) ((Callable<T>) new Callable<T>() { // from class: io.objectbox.query.Query.1
            @Override // java.util.concurrent.Callable
            public T call() {
                Query query = Query.this;
                T t = (T) query.nativeFindFirst(query.f9545b, Query.this.m3304b());
                Query.this.m3309a(t);
                return t;
            }
        }));
    }

    /* renamed from: g */
    private void m3298g() {
        if (this.f9550g != null) {
            throw new UnsupportedOperationException("Does not yet work with a filter yet. At this point, only find() and forEach() are supported with filters.");
        }
        m3297h();
    }

    /* renamed from: h */
    private void m3297h() {
        if (this.f9551h != null) {
            throw new UnsupportedOperationException("Does not yet work with a sorting comparator yet. At this point, only find() is supported with sorting comparators.");
        }
    }

    @Nullable
    /* renamed from: d */
    public T m3301d() {
        m3298g();
        return (T) m3305a((Callable<Object>) ((Callable<T>) new Callable<T>() { // from class: io.objectbox.query.Query.2
            @Override // java.util.concurrent.Callable
            public T call() {
                Query query = Query.this;
                T t = (T) query.nativeFindUnique(query.f9545b, Query.this.m3304b());
                Query.this.m3309a(t);
                return t;
            }
        }));
    }

    @Nonnull
    /* renamed from: e */
    public List<T> m3300e() {
        return (List) m3305a((Callable<Object>) ((Callable<List<T>>) new Callable<List<T>>() { // from class: io.objectbox.query.Query.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public List<T> call() throws Exception {
                Query query = Query.this;
                List<T> nativeFind = query.nativeFind(query.f9545b, Query.this.m3304b(), 0L, 0L);
                if (Query.this.f9550g != null) {
                    Iterator<T> it = nativeFind.iterator();
                    while (it.hasNext()) {
                        if (!Query.this.f9550g.m3283a(it.next())) {
                            it.remove();
                        }
                    }
                }
                Query.this.m3306a((List) nativeFind);
                if (Query.this.f9551h != null) {
                    Collections.sort(nativeFind, Query.this.f9551h);
                }
                return nativeFind;
            }
        }));
    }

    /* renamed from: a */
    <R> R m3305a(Callable<R> callable) {
        return (R) this.f9546c.m3482a(callable, this.f9552i, 10, true);
    }

    /* renamed from: a */
    void m3306a(List list) {
        if (this.f9549f != null) {
            int i = 0;
            for (Object obj : list) {
                m3308a(obj, i);
                i++;
            }
        }
    }

    /* renamed from: a */
    void m3308a(@Nonnull Object obj, int i) {
        for (EagerRelation eagerRelation : this.f9549f) {
            if (eagerRelation.f9575a == 0 || i < eagerRelation.f9575a) {
                m3307a(obj, eagerRelation);
            }
        }
    }

    /* renamed from: a */
    void m3309a(@Nullable Object obj) {
        List<EagerRelation> list = this.f9549f;
        if (list == null || obj == null) {
            return;
        }
        for (EagerRelation eagerRelation : list) {
            m3307a(obj, eagerRelation);
        }
    }

    /* renamed from: a */
    void m3307a(@Nonnull Object obj, EagerRelation eagerRelation) {
        if (this.f9549f != null) {
            RelationInfo relationInfo = eagerRelation.f9576b;
            if (relationInfo.toOneGetter != null) {
                ToOne toOne = relationInfo.toOneGetter.getToOne(obj);
                if (toOne != null) {
                    toOne.getTarget();
                }
            } else if (relationInfo.toManyGetter == null) {
                throw new IllegalStateException("Relation info without relation getter: " + relationInfo);
            } else {
                List toMany = relationInfo.toManyGetter.getToMany(obj);
                if (toMany != null) {
                    toMany.size();
                }
            }
        }
    }

    /* renamed from: f */
    public SubscriptionBuilder<List<T>> m3299f() {
        return new SubscriptionBuilder<>(this.f9548e, null, this.f9544a.m3415f().m3467j());
    }
}
