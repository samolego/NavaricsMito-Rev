package io.objectbox.query;

import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.annotation.apihint.Experimental;
import io.objectbox.annotation.apihint.Internal;
import java.util.Comparator;
import java.util.List;

@Experimental
/* loaded from: classes2.dex */
public class QueryBuilder<T> {

    /* renamed from: a */
    private final Box<T> f9557a;

    /* renamed from: b */
    private final long f9558b;

    /* renamed from: c */
    private long f9559c;

    /* renamed from: d */
    private boolean f9560d;

    /* renamed from: e */
    private long f9561e;

    /* renamed from: g */
    private List<EagerRelation> f9563g;

    /* renamed from: h */
    private QueryFilter<T> f9564h;

    /* renamed from: i */
    private Comparator<T> f9565i;

    /* renamed from: f */
    private Operator f9562f = Operator.NONE;

    /* renamed from: j */
    private final boolean f9566j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum Operator {
        NONE,
        AND,
        OR
    }

    private native long nativeBuild(long j);

    private native long nativeCombine(long j, long j2, long j3, boolean z);

    private native long nativeCreate(long j, String str);

    private native void nativeDestroy(long j);

    private native long nativeEqual(long j, int i, long j2);

    private native long nativeEqual(long j, int i, String str, boolean z);

    private native void nativeOrder(long j, int i, int i2);

    @Internal
    public QueryBuilder(Box<T> box, long j, String str) {
        this.f9557a = box;
        this.f9558b = j;
        this.f9559c = nativeCreate(j, str);
    }

    protected void finalize() throws Throwable {
        m3295a();
        super.finalize();
    }

    /* renamed from: a */
    public synchronized void m3295a() {
        if (this.f9559c != 0) {
            if (!this.f9566j) {
                nativeDestroy(this.f9559c);
            }
            this.f9559c = 0L;
        }
    }

    /* renamed from: b */
    public Query<T> m3288b() {
        m3287c();
        m3286d();
        if (this.f9562f != Operator.NONE) {
            throw new IllegalStateException("Incomplete logic condition. Use or()/and() between two conditions only.");
        }
        Query<T> query = new Query<>(this.f9557a, nativeBuild(this.f9559c), this.f9560d, this.f9563g, this.f9564h, this.f9565i);
        m3295a();
        return query;
    }

    /* renamed from: c */
    private void m3287c() {
        if (this.f9566j) {
            throw new IllegalStateException("This call is not supported on sub query builders (links)");
        }
    }

    /* renamed from: d */
    private void m3286d() {
        if (this.f9559c == 0) {
            throw new IllegalStateException("This QueryBuilder has already been closed. Please use a new instance.");
        }
    }

    /* renamed from: a */
    public QueryBuilder<T> m3293a(Property<T> property) {
        return m3292a((Property) property, 0);
    }

    /* renamed from: a */
    public QueryBuilder<T> m3292a(Property<T> property, int i) {
        m3287c();
        m3286d();
        if (this.f9562f != Operator.NONE) {
            throw new IllegalStateException("An operator is pending. Use operators like and() and or() only between two conditions.");
        }
        nativeOrder(this.f9559c, property.getId(), i);
        this.f9560d = true;
        return this;
    }

    /* renamed from: a */
    private void m3294a(long j) {
        if (this.f9562f != Operator.NONE) {
            this.f9561e = nativeCombine(this.f9559c, this.f9561e, j, this.f9562f == Operator.OR);
            this.f9562f = Operator.NONE;
            return;
        }
        this.f9561e = j;
    }

    /* renamed from: a */
    public QueryBuilder<T> m3291a(Property<T> property, long j) {
        m3286d();
        m3294a(nativeEqual(this.f9559c, property.getId(), j));
        return this;
    }

    /* renamed from: a */
    public QueryBuilder<T> m3289a(Property<T> property, boolean z) {
        m3286d();
        m3294a(nativeEqual(this.f9559c, property.getId(), z ? 1L : 0L));
        return this;
    }

    /* renamed from: a */
    public QueryBuilder<T> m3290a(Property<T> property, String str) {
        m3286d();
        m3294a(nativeEqual(this.f9559c, property.getId(), str, false));
        return this;
    }
}
