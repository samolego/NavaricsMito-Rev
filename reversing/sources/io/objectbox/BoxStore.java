package io.objectbox;

import io.objectbox.annotation.apihint.Experimental;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.converter.PropertyConverter;
import io.objectbox.exception.DbException;
import io.objectbox.exception.DbSchemaException;
import io.objectbox.internal.NativeLibraryLoader;
import io.objectbox.internal.ObjectBoxThreadPool;
import io.objectbox.p092b.SubscriptionBuilder;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import org.greenrobot.essentials.collections.LongHashMap;

@ThreadSafe
/* loaded from: classes2.dex */
public class BoxStore implements Closeable {
    @Nullable

    /* renamed from: a */
    public static Object f9404a;
    @Nullable

    /* renamed from: b */
    public static Object f9405b;

    /* renamed from: i */
    private static final Set<String> f9406i = new HashSet();

    /* renamed from: c */
    final boolean f9407c;

    /* renamed from: d */
    final boolean f9408d;

    /* renamed from: e */
    final boolean f9409e;

    /* renamed from: h */
    volatile int f9412h;

    /* renamed from: j */
    private final File f9413j;

    /* renamed from: k */
    private final String f9414k;

    /* renamed from: l */
    private final long f9415l;

    /* renamed from: q */
    private final int[] f9420q;

    /* renamed from: u */
    private final ObjectClassPublisher f9424u;

    /* renamed from: v */
    private boolean f9425v;

    /* renamed from: w */
    private final int f9426w;

    /* renamed from: x */
    private final TxCallback f9427x;

    /* renamed from: m */
    private final Map<Class, String> f9416m = new HashMap();

    /* renamed from: n */
    private final Map<Class, Integer> f9417n = new HashMap();

    /* renamed from: o */
    private final Map<Class, EntityInfo> f9418o = new HashMap();

    /* renamed from: p */
    private final LongHashMap<Class> f9419p = new LongHashMap<>();

    /* renamed from: r */
    private final Map<Class, Box> f9421r = new ConcurrentHashMap();

    /* renamed from: s */
    private final Set<Transaction> f9422s = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: t */
    private final ExecutorService f9423t = new ObjectBoxThreadPool(this);

    /* renamed from: f */
    final ThreadLocal<Transaction> f9410f = new ThreadLocal<>();

    /* renamed from: g */
    final Object f9411g = new Object();

    static native long nativeBeginReadTx(long j);

    static native long nativeBeginTx(long j);

    static native int nativeCleanStaleReadTransactions(long j);

    static native long nativeCreate(String str, long j, int i, byte[] bArr);

    static native void nativeDelete(long j);

    static native String nativeDiagnose(long j);

    static native void nativeRegisterCustomType(long j, int i, int i2, String str, Class<? extends PropertyConverter> cls, Class cls2);

    static native int nativeRegisterEntityClass(long j, String str, Class cls);

    static native void nativeSetDebugFlags(long j, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoxStore(BoxStoreBuilder boxStoreBuilder) {
        Property[] allProperties;
        f9404a = boxStoreBuilder.f9457c;
        f9405b = boxStoreBuilder.f9458d;
        NativeLibraryLoader.m3316a();
        this.f9413j = boxStoreBuilder.f9456b;
        this.f9414k = m3487a(this.f9413j);
        m3484a(this.f9414k);
        this.f9415l = nativeCreate(this.f9414k, boxStoreBuilder.f9459e, boxStoreBuilder.f9462h, boxStoreBuilder.f9455a);
        int i = boxStoreBuilder.f9460f;
        if (i != 0) {
            nativeSetDebugFlags(this.f9415l, i);
            this.f9407c = (i & 1) != 0;
            this.f9408d = (i & 2) != 0;
        } else {
            this.f9408d = false;
            this.f9407c = false;
        }
        this.f9409e = boxStoreBuilder.f9461g;
        for (EntityInfo entityInfo : boxStoreBuilder.f9465k) {
            try {
                this.f9416m.put(entityInfo.getEntityClass(), entityInfo.getDbName());
                int nativeRegisterEntityClass = nativeRegisterEntityClass(this.f9415l, entityInfo.getDbName(), entityInfo.getEntityClass());
                this.f9417n.put(entityInfo.getEntityClass(), Integer.valueOf(nativeRegisterEntityClass));
                this.f9419p.m748a(nativeRegisterEntityClass, entityInfo.getEntityClass());
                this.f9418o.put(entityInfo.getEntityClass(), entityInfo);
                for (Property property : entityInfo.getAllProperties()) {
                    if (property.customType != null) {
                        if (property.converterClass == null) {
                            throw new RuntimeException("No converter class for custom type of " + property);
                        }
                        nativeRegisterCustomType(this.f9415l, nativeRegisterEntityClass, 0, property.dbName, property.converterClass, property.customType);
                    }
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("Could not setup up entity " + entityInfo.getEntityClass(), e);
            }
        }
        int m747b = this.f9419p.m747b();
        this.f9420q = new int[m747b];
        long[] m751a = this.f9419p.m751a();
        for (int i2 = 0; i2 < m747b; i2++) {
            this.f9420q[i2] = (int) m751a[i2];
        }
        this.f9424u = new ObjectClassPublisher(this);
        this.f9427x = boxStoreBuilder.f9464j;
        this.f9426w = boxStoreBuilder.f9463i >= 1 ? boxStoreBuilder.f9463i : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m3487a(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new DbException("Is not a directory: " + file.getAbsolutePath());
            }
        } else if (!file.mkdirs()) {
            throw new DbException("Could not create directory: " + file.getAbsolutePath());
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            throw new DbException("Could not verify dir", e);
        }
    }

    /* renamed from: a */
    private static void m3484a(String str) {
        synchronized (f9406i) {
            m3478b(str);
            if (!f9406i.add(str)) {
                throw new DbException("Another BoxStore is still open for this directory: " + str + ". Hint: for most apps it's recommended to keep a BoxStore for the app's life time.");
            }
        }
    }

    /* renamed from: b */
    private static boolean m3478b(String str) {
        boolean contains;
        synchronized (f9406i) {
            int i = 0;
            while (i < 5) {
                if (!f9406i.contains(str)) {
                    break;
                }
                i++;
                System.gc();
                System.runFinalization();
                System.gc();
                System.runFinalization();
                try {
                    f9406i.wait(100L);
                } catch (InterruptedException unused) {
                }
            }
            contains = f9406i.contains(str);
        }
        return contains;
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    /* renamed from: m */
    private void m3464m() {
        if (this.f9425v) {
            throw new IllegalStateException("Store is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m3486a(Class cls) {
        return this.f9416m.get(cls);
    }

    @Internal
    /* renamed from: b */
    public int m3480b(Class cls) {
        Integer num = this.f9417n.get(cls);
        if (num == null) {
            throw new DbSchemaException("No entity registered for " + cls);
        }
        return num.intValue();
    }

    /* renamed from: a */
    public Collection<Class> m3491a() {
        return this.f9416m.keySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Internal
    /* renamed from: b */
    public int[] m3481b() {
        return this.f9420q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Internal
    /* renamed from: a */
    public Class m3490a(int i) {
        Class m749a = this.f9419p.m749a(i);
        if (m749a != null) {
            return m749a;
        }
        throw new DbSchemaException("No entity registered for type ID " + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Internal
    /* renamed from: c */
    public EntityInfo m3476c(Class cls) {
        return this.f9418o.get(cls);
    }

    @Internal
    /* renamed from: c */
    public Transaction m3477c() {
        m3464m();
        int i = this.f9412h;
        if (this.f9408d) {
            PrintStream printStream = System.out;
            printStream.println("Begin TX with commit count " + i);
        }
        Transaction transaction = new Transaction(this, nativeBeginTx(this.f9415l), i);
        synchronized (this.f9422s) {
            this.f9422s.add(transaction);
        }
        return transaction;
    }

    @Internal
    /* renamed from: d */
    public Transaction m3475d() {
        m3464m();
        int i = this.f9412h;
        if (this.f9407c) {
            PrintStream printStream = System.out;
            printStream.println("Begin read TX with commit count " + i);
        }
        Transaction transaction = new Transaction(this, nativeBeginReadTx(this.f9415l), i);
        synchronized (this.f9422s) {
            this.f9422s.add(transaction);
        }
        return transaction;
    }

    /* renamed from: e */
    public boolean m3473e() {
        return this.f9425v;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        boolean z;
        ArrayList<Transaction> arrayList;
        synchronized (this) {
            z = this.f9425v;
            if (!this.f9425v) {
                this.f9425v = true;
                synchronized (this.f9422s) {
                    arrayList = new ArrayList(this.f9422s);
                }
                for (Transaction transaction : arrayList) {
                    transaction.close();
                }
                if (this.f9415l != 0) {
                    nativeDelete(this.f9415l);
                }
                this.f9423t.shutdown();
                m3463n();
            }
        }
        if (z) {
            return;
        }
        synchronized (f9406i) {
            f9406i.remove(this.f9414k);
            f9406i.notifyAll();
        }
    }

    /* renamed from: n */
    private void m3463n() {
        try {
            if (this.f9423t.awaitTermination(1L, TimeUnit.SECONDS)) {
                return;
            }
            int activeCount = Thread.activeCount();
            System.err.println("Thread pool not terminated in time; printing stack traces...");
            Thread[] threadArr = new Thread[activeCount + 2];
            int enumerate = Thread.enumerate(threadArr);
            for (int i = 0; i < enumerate; i++) {
                PrintStream printStream = System.err;
                printStream.println("Thread: " + threadArr[i].getName());
                Thread.dumpStack();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Internal
    /* renamed from: a */
    public void m3489a(Transaction transaction) {
        synchronized (this.f9422s) {
            this.f9422s.remove(transaction);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3488a(Transaction transaction, @Nullable int[] iArr) {
        synchronized (this.f9411g) {
            this.f9412h++;
            if (this.f9408d) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("TX committed. New commit count: ");
                sb.append(this.f9412h);
                sb.append(", entity types affected: ");
                sb.append(iArr != null ? iArr.length : 0);
                printStream.println(sb.toString());
            }
        }
        for (Box box : this.f9421r.values()) {
            box.m3427a(transaction);
        }
        if (iArr != null) {
            this.f9424u.m3320a(iArr);
        }
    }

    /* renamed from: d */
    public <T> Box<T> m3474d(Class<T> cls) {
        Box<T> box;
        Box<T> box2 = this.f9421r.get(cls);
        if (box2 == null) {
            if (!this.f9416m.containsKey(cls)) {
                throw new IllegalArgumentException(cls + " is not a known entity. Please add it and trigger generation again.");
            }
            synchronized (this.f9421r) {
                box = this.f9421r.get(cls);
                if (box == null) {
                    box = new Box<>(this, cls);
                    this.f9421r.put(cls, box);
                }
            }
            return box;
        }
        return box2;
    }

    /* renamed from: a */
    public void m3485a(Runnable runnable) {
        Transaction transaction = this.f9410f.get();
        if (transaction == null) {
            Transaction m3477c = m3477c();
            this.f9410f.set(m3477c);
            try {
                runnable.run();
                m3477c.m3443a();
            } finally {
                this.f9410f.remove();
                m3477c.close();
            }
        } else if (transaction.m3434i()) {
            throw new IllegalStateException("Cannot start a transaction while a read only transaction is active");
        } else {
            runnable.run();
        }
    }

    @Experimental
    /* renamed from: a */
    public <T> T m3482a(Callable<T> callable, int i, int i2, boolean z) {
        if (i == 1) {
            return (T) m3483a(callable);
        }
        if (i < 1) {
            throw new IllegalArgumentException("Illegal value of attempts: " + i);
        }
        long j = i2;
        DbException e = null;
        for (int i3 = 1; i3 <= i; i3++) {
            try {
                return (T) m3483a(callable);
            } catch (DbException e2) {
                e = e2;
                String m3471f = m3471f();
                String str = i3 + " of " + i + " attempts of calling a read TX failed:";
                if (z) {
                    System.err.println(str);
                    e.printStackTrace();
                    System.err.println(m3471f);
                    System.err.flush();
                    System.gc();
                    System.runFinalization();
                    m3470g();
                }
                TxCallback txCallback = this.f9427x;
                if (txCallback != null) {
                    txCallback.m3319a(null, new DbException(str + " \n" + m3471f, e));
                }
                try {
                    Thread.sleep(j);
                    j *= 2;
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                    throw e;
                }
            }
        }
        throw e;
    }

    /* renamed from: a */
    public <T> T m3483a(Callable<T> callable) {
        if (this.f9410f.get() == null) {
            Transaction m3475d = m3475d();
            this.f9410f.set(m3475d);
            try {
                try {
                    return callable.call();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException("Callable threw exception", e2);
                }
            } finally {
                this.f9410f.remove();
                for (Box next : this.f9421r.values()) {
                    next.m3422b(m3475d);
                }
                m3475d.close();
            }
        }
        try {
            return callable.call();
        } catch (Exception e3) {
            throw new RuntimeException("Callable threw exception", e3);
        }
    }

    /* renamed from: f */
    public String m3471f() {
        return nativeDiagnose(this.f9415l);
    }

    /* renamed from: g */
    public int m3470g() {
        return nativeCleanStaleReadTransactions(this.f9415l);
    }

    /* renamed from: h */
    public void m3469h() {
        for (Box box : this.f9421r.values()) {
            box.m3417d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Internal
    /* renamed from: i */
    public long m3468i() {
        return this.f9415l;
    }

    /* renamed from: e */
    public <T> SubscriptionBuilder<Class<T>> m3472e(Class<T> cls) {
        return new SubscriptionBuilder<>(this.f9424u, cls, this.f9423t);
    }

    @Internal
    /* renamed from: b */
    public Future m3479b(Runnable runnable) {
        return this.f9423t.submit(runnable);
    }

    @Internal
    /* renamed from: j */
    public ExecutorService m3467j() {
        return this.f9423t;
    }

    @Internal
    /* renamed from: k */
    public boolean m3466k() {
        return this.f9409e;
    }

    @Internal
    /* renamed from: l */
    public int m3465l() {
        return this.f9426w;
    }
}
