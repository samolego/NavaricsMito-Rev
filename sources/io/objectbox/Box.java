package io.objectbox;

import io.objectbox.annotation.apihint.Beta;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.IdGetter;
import io.objectbox.query.QueryBuilder;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@ThreadSafe
/* renamed from: io.objectbox.a */
/* loaded from: classes2.dex */
public class Box<T> {

    /* renamed from: b */
    private final BoxStore f9446b;

    /* renamed from: c */
    private final Class<T> f9447c;

    /* renamed from: e */
    private final IdGetter<T> f9449e;

    /* renamed from: a */
    final ThreadLocal<Cursor<T>> f9445a = new ThreadLocal<>();

    /* renamed from: d */
    private final ThreadLocal<Cursor<T>> f9448d = new ThreadLocal<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Box(BoxStore boxStore, Class<T> cls) {
        this.f9446b = boxStore;
        this.f9447c = cls;
        this.f9449e = boxStore.m3476c(cls).getIdGetter();
    }

    /* renamed from: a */
    Cursor<T> m3432a() {
        Cursor<T> m3425b = m3425b();
        if (m3425b != null) {
            return m3425b;
        }
        Cursor<T> cursor = this.f9448d.get();
        if (cursor != null) {
            Transaction transaction = cursor.f9430c;
            if (transaction.m3435h() || !transaction.m3436g()) {
                throw new IllegalStateException("Illegal reader TX state");
            }
            transaction.m3438e();
            cursor.m3450c();
            return cursor;
        }
        Cursor<T> m3442a = this.f9446b.m3475d().m3442a(this.f9447c);
        this.f9448d.set(m3442a);
        return m3442a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Cursor<T> m3425b() {
        Transaction transaction = this.f9446b.f9410f.get();
        if (transaction != null) {
            if (transaction.m3435h()) {
                throw new IllegalStateException("Active TX is closed");
            }
            Cursor<T> cursor = this.f9445a.get();
            if (cursor == null || cursor.m3462a().m3435h()) {
                Cursor<T> m3442a = transaction.m3442a(this.f9447c);
                this.f9445a.set(m3442a);
                return m3442a;
            }
            return cursor;
        }
        return null;
    }

    /* renamed from: c */
    Cursor<T> m3420c() {
        Cursor<T> m3425b = m3425b();
        if (m3425b != null) {
            return m3425b;
        }
        Transaction m3477c = this.f9446b.m3477c();
        try {
            return m3477c.m3442a(this.f9447c);
        } catch (RuntimeException e) {
            m3477c.close();
            throw e;
        }
    }

    /* renamed from: a */
    void m3428a(Cursor<T> cursor) {
        if (this.f9445a.get() == null) {
            cursor.close();
            cursor.m3462a().m3441b();
        }
    }

    /* renamed from: b */
    void m3423b(Cursor<T> cursor) {
        if (this.f9445a.get() == null) {
            Transaction m3462a = cursor.m3462a();
            if (m3462a.m3435h()) {
                return;
            }
            cursor.close();
            m3462a.m3440c();
            m3462a.close();
        }
    }

    /* renamed from: c */
    void m3419c(Cursor<T> cursor) {
        if (this.f9445a.get() == null) {
            Transaction m3462a = cursor.m3462a();
            if (m3462a.m3435h() || m3462a.m3436g() || !m3462a.m3434i()) {
                throw new IllegalStateException("Illegal reader TX state");
            }
            m3462a.m3439d();
        }
    }

    /* renamed from: d */
    public void m3417d() {
        Cursor<T> cursor = this.f9448d.get();
        if (cursor != null) {
            cursor.close();
            this.f9448d.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3427a(Transaction transaction) {
        Cursor<T> cursor = this.f9445a.get();
        if (cursor != null) {
            this.f9445a.remove();
            cursor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3422b(Transaction transaction) {
        Cursor<T> cursor = this.f9445a.get();
        if (cursor == null || cursor.m3462a() != transaction) {
            return;
        }
        this.f9445a.remove();
        cursor.close();
    }

    @Internal
    /* renamed from: a */
    public long m3426a(T t) {
        return this.f9449e.mo3317a(t);
    }

    /* renamed from: a */
    public T m3429a(long j) {
        Cursor<T> m3432a = m3432a();
        try {
            return m3432a.m3458a(j);
        } finally {
            m3419c((Cursor) m3432a);
        }
    }

    /* renamed from: b */
    public long m3421b(T t) {
        Cursor<T> m3420c = m3420c();
        try {
            long mo3456a = m3420c.mo3456a((Cursor<T>) t);
            m3428a((Cursor) m3420c);
            return mo3456a;
        } finally {
            m3423b((Cursor) m3420c);
        }
    }

    /* renamed from: b */
    public void m3424b(long j) {
        Cursor<T> m3420c = m3420c();
        try {
            m3420c.m3452b(j);
            m3428a((Cursor) m3420c);
        } finally {
            m3423b((Cursor) m3420c);
        }
    }

    /* renamed from: c */
    public void m3418c(T t) {
        Cursor<T> m3420c = m3420c();
        try {
            m3420c.m3452b(m3420c.mo3451b((Cursor<T>) t));
            m3428a((Cursor) m3420c);
        } finally {
            m3423b((Cursor) m3420c);
        }
    }

    /* renamed from: e */
    public QueryBuilder<T> m3416e() {
        return new QueryBuilder<>(this, this.f9446b.m3468i(), this.f9446b.m3486a(this.f9447c));
    }

    /* renamed from: f */
    public BoxStore m3415f() {
        return this.f9446b;
    }

    /* renamed from: g */
    public Class<T> m3414g() {
        return this.f9447c;
    }

    @Internal
    /* renamed from: a */
    public List<T> m3430a(int i, Property property, long j) {
        Cursor<T> m3432a = m3432a();
        try {
            return m3432a.m3459a(i, property, j);
        } finally {
            m3419c((Cursor) m3432a);
        }
    }

    @Internal
    /* renamed from: a */
    public List<T> m3431a(int i, int i2, long j, boolean z) {
        Cursor<T> m3432a = m3432a();
        try {
            return m3432a.m3461a(i, i2, j, z);
        } finally {
            m3419c((Cursor) m3432a);
        }
    }
}
