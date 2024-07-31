package io.objectbox;

import io.objectbox.annotation.apihint.Beta;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.relation.ToMany;
import java.io.Closeable;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@Beta
@Internal
@NotThreadSafe
/* loaded from: classes2.dex */
public abstract class Cursor<T> implements Closeable {
    @Internal

    /* renamed from: a */
    static boolean f9428a;
    @Internal

    /* renamed from: b */
    static boolean f9429b;

    /* renamed from: c */
    protected final Transaction f9430c;

    /* renamed from: d */
    protected final long f9431d;

    /* renamed from: e */
    protected final EntityInfo f9432e;

    /* renamed from: f */
    protected final BoxStore f9433f;

    /* renamed from: g */
    protected final boolean f9434g;

    /* renamed from: h */
    protected boolean f9435h;

    /* renamed from: i */
    private final Throwable f9436i;

    /* JADX INFO: Access modifiers changed from: protected */
    public static native long collect002033(long j, long j2, int i, int i2, long j3, int i3, long j4, int i4, float f, int i5, float f2, int i6, float f3, int i7, double d, int i8, double d2, int i9, double d3);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native long collect313311(long j, long j2, int i, int i2, @Nullable String str, int i3, @Nullable String str2, int i4, @Nullable String str3, int i5, @Nullable byte[] bArr, int i6, long j3, int i7, long j4, int i8, long j5, int i9, int i10, int i11, int i12, int i13, int i14, int i15, float f, int i16, double d);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native long collect400000(long j, long j2, int i, int i2, @Nullable String str, int i3, @Nullable String str2, int i4, @Nullable String str3, int i5, @Nullable String str4);

    static native void nativeDeleteEntity(long j, long j2);

    static native void nativeDestroy(long j);

    static native List nativeGetBacklinkEntities(long j, int i, int i2, long j2);

    static native Object nativeGetEntity(long j, long j2);

    static native List nativeGetRelationEntities(long j, int i, int i2, long j2, boolean z);

    static native void nativeModifyRelations(long j, int i, long j2, long[] jArr, boolean z);

    static native int nativePropertyId(long j, String str);

    static native long nativeRenew(long j);

    static native void nativeSetBoxStoreForEntities(long j, Object obj);

    /* renamed from: a */
    public abstract long mo3456a(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public abstract long mo3451b(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public Cursor(Transaction transaction, long j, EntityInfo entityInfo, BoxStore boxStore) {
        Property<T>[] allProperties;
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction is null");
        }
        this.f9430c = transaction;
        this.f9434g = transaction.m3434i();
        this.f9431d = j;
        this.f9432e = entityInfo;
        this.f9433f = boxStore;
        for (Property<T> property : entityInfo.getAllProperties()) {
            if (!property.isIdVerified()) {
                property.verifyId(m3455a(property.dbName));
            }
        }
        this.f9436i = f9428a ? new Throwable() : null;
        nativeSetBoxStoreForEntities(j, boxStore);
    }

    protected void finalize() throws Throwable {
        if (this.f9435h) {
            return;
        }
        if (!this.f9434g || f9429b) {
            System.err.println("Cursor was not closed.");
            if (this.f9436i != null) {
                System.err.println("Cursor was initially created here:");
                this.f9436i.printStackTrace();
            }
            System.err.flush();
        }
        close();
        super.finalize();
    }

    /* renamed from: a */
    public T m3458a(long j) {
        return (T) nativeGetEntity(this.f9431d, j);
    }

    /* renamed from: b */
    public void m3452b(long j) {
        nativeDeleteEntity(this.f9431d, j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.f9435h) {
            this.f9435h = true;
            if (this.f9430c != null && !this.f9430c.m3437f().m3473e()) {
                nativeDestroy(this.f9431d);
            }
        }
    }

    /* renamed from: a */
    public int m3455a(String str) {
        return nativePropertyId(this.f9431d, str);
    }

    /* renamed from: a */
    public Transaction m3462a() {
        return this.f9430c;
    }

    /* renamed from: b */
    public boolean m3453b() {
        return this.f9435h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public <TARGET> Cursor<TARGET> m3457a(Class<TARGET> cls) {
        return this.f9430c.m3442a(cls);
    }

    /* renamed from: c */
    public void m3450c() {
        nativeRenew(this.f9431d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Internal
    /* renamed from: d */
    public long m3449d() {
        return this.f9431d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Internal
    /* renamed from: a */
    public List<T> m3459a(int i, Property property, long j) {
        try {
            return nativeGetBacklinkEntities(this.f9431d, i, property.getId(), j);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Please check if the given property belongs to a valid @Relation: " + property, e);
        }
    }

    @Internal
    /* renamed from: a */
    public List<T> m3461a(int i, int i2, long j, boolean z) {
        return nativeGetRelationEntities(this.f9431d, i, i2, j, z);
    }

    @Internal
    /* renamed from: a */
    public void m3460a(int i, long j, long[] jArr, boolean z) {
        nativeModifyRelations(this.f9431d, i, j, jArr, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public <TARGET> void m3454a(List<TARGET> list, Class<TARGET> cls) {
        if (list instanceof ToMany) {
            ToMany toMany = (ToMany) list;
            if (toMany.internalCheckApplyToDbRequired()) {
                Cursor<TARGET> m3457a = m3457a((Class) cls);
                try {
                    toMany.internalApplyToDb(this, m3457a);
                } finally {
                    m3457a.close();
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cursor ");
        sb.append(Long.toString(this.f9431d, 16));
        sb.append(m3453b() ? "(closed)" : "");
        return sb.toString();
    }
}
