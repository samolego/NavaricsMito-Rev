package io.objectbox.relation;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.exception.DbDetachedException;
import io.objectbox.internal.ReflectionCache;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class ToOne<TARGET> implements Serializable {
    private static final long serialVersionUID = 5092547044335989281L;

    /* renamed from: a */
    private transient BoxStore f9595a;

    /* renamed from: b */
    private transient Box f9596b;

    /* renamed from: c */
    private volatile transient Box<TARGET> f9597c;
    private boolean checkIdOfTargetForPut;

    /* renamed from: d */
    private transient Field f9598d;
    private boolean debugRelations;
    private final Object entity;
    private final RelationInfo relationInfo;
    private volatile long resolvedTargetId;
    private TARGET target;
    private long targetId;
    private final boolean virtualProperty;

    public ToOne(Object obj, RelationInfo relationInfo) {
        if (obj == null) {
            throw new IllegalArgumentException("No source entity given (null)");
        }
        if (relationInfo == null) {
            throw new IllegalArgumentException("No relation info given (null)");
        }
        this.entity = obj;
        this.relationInfo = relationInfo;
        this.virtualProperty = relationInfo.targetIdProperty.isVirtual;
    }

    public TARGET getTarget() {
        return getTarget(getTargetId());
    }

    @Internal
    public TARGET getTarget(long j) {
        synchronized (this) {
            if (this.resolvedTargetId == j) {
                return this.target;
            }
            m3264a(null);
            TARGET m3429a = this.f9597c.m3429a(j);
            m3263a(m3429a, j);
            return m3429a;
        }
    }

    /* renamed from: a */
    private void m3264a(TARGET target) {
        if (this.f9597c == null) {
            try {
                this.f9595a = (BoxStore) ReflectionCache.m3313a().m3312a(this.entity.getClass(), "__boxStore").get(this.entity);
                if (this.f9595a == null) {
                    if (target != null) {
                        this.f9595a = (BoxStore) ReflectionCache.m3313a().m3312a(target.getClass(), "__boxStore").get(target);
                    }
                    if (this.f9595a == null) {
                        throw new DbDetachedException("Cannot resolve relation for detached entities, call box.attach(entity) beforehand.");
                    }
                }
                this.debugRelations = this.f9595a.m3466k();
                this.f9596b = this.f9595a.m3474d(this.relationInfo.sourceInfo.getEntityClass());
                this.f9597c = this.f9595a.m3474d(this.relationInfo.targetInfo.getEntityClass());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public TARGET getCachedTarget() {
        return this.target;
    }

    public boolean isResolved() {
        return this.resolvedTargetId == getTargetId();
    }

    public boolean isResolvedAndNotNull() {
        return this.resolvedTargetId != 0 && this.resolvedTargetId == getTargetId();
    }

    public boolean isNull() {
        return getTargetId() == 0 && this.target == null;
    }

    public void setTargetId(long j) {
        if (this.virtualProperty) {
            this.targetId = j;
        } else {
            try {
                m3262b().set(this.entity, Long.valueOf(j));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Could not update to-one ID in entity", e);
            }
        }
        if (j != 0) {
            this.checkIdOfTargetForPut = false;
        }
    }

    void setAndUpdateTargetId(long j) {
        setTargetId(j);
        m3264a(null);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setTarget(@Nullable TARGET target) {
        if (target != null) {
            long mo3317a = this.relationInfo.targetInfo.getIdGetter().mo3317a(target);
            this.checkIdOfTargetForPut = mo3317a == 0;
            setTargetId(mo3317a);
            m3263a(target, mo3317a);
            return;
        }
        setTargetId(0L);
        m3265a();
    }

    public void setAndPutTarget(@Nullable TARGET target) {
        m3264a(target);
        if (target != null) {
            long m3426a = this.f9597c.m3426a((Box<TARGET>) target);
            if (m3426a == 0) {
                setAndPutTargetAlways(target);
                return;
            }
            setTargetId(m3426a);
            m3263a(target, m3426a);
            this.f9596b.m3421b((Box) this.entity);
            return;
        }
        setTargetId(0L);
        m3265a();
        this.f9596b.m3421b((Box) this.entity);
    }

    public void setAndPutTargetAlways(@Nullable final TARGET target) {
        m3264a(target);
        if (target != null) {
            this.f9595a.m3485a(new Runnable() { // from class: io.objectbox.relation.ToOne.1
                @Override // java.lang.Runnable
                public void run() {
                    ToOne.this.m3263a(target, ToOne.this.f9597c.m3421b((Box) target));
                    ToOne.this.f9596b.m3421b((Box) ToOne.this.entity);
                }
            });
            return;
        }
        setTargetId(0L);
        m3265a();
        this.f9596b.m3421b((Box) this.entity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m3263a(@Nullable TARGET target, long j) {
        if (this.debugRelations) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("Setting resolved ToOne target to ");
            sb.append(target == null ? "null" : "non-null");
            sb.append(" for ID ");
            sb.append(j);
            printStream.println(sb.toString());
        }
        this.resolvedTargetId = j;
        this.target = target;
    }

    /* renamed from: a */
    private synchronized void m3265a() {
        this.resolvedTargetId = 0L;
        this.target = null;
    }

    public long getTargetId() {
        if (this.virtualProperty) {
            return this.targetId;
        }
        Field m3262b = m3262b();
        try {
            Long l = (Long) m3262b.get(this.entity);
            if (l != null) {
                return l.longValue();
            }
            return 0L;
        } catch (IllegalAccessException unused) {
            throw new RuntimeException("Could not access field " + m3262b);
        }
    }

    /* renamed from: b */
    private Field m3262b() {
        if (this.f9598d == null) {
            this.f9598d = ReflectionCache.m3313a().m3312a(this.entity.getClass(), this.relationInfo.targetIdProperty.name);
        }
        return this.f9598d;
    }

    @Internal
    public boolean internalRequiresPutTarget() {
        return this.checkIdOfTargetForPut && this.target != null && getTargetId() == 0;
    }

    @Internal
    public void internalPutTarget(Cursor<TARGET> cursor) {
        this.checkIdOfTargetForPut = false;
        long mo3456a = cursor.mo3456a((Cursor<TARGET>) this.target);
        setTargetId(mo3456a);
        m3263a(this.target, mo3456a);
    }

    Object getEntity() {
        return this.entity;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ToOne) {
            ToOne toOne = (ToOne) obj;
            return this.relationInfo == toOne.relationInfo && getTargetId() == toOne.getTargetId();
        }
        return false;
    }

    public int hashCode() {
        long targetId = getTargetId();
        return (int) (targetId ^ (targetId >>> 32));
    }
}
