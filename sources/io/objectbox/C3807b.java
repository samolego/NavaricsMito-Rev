package io.objectbox;

import android.support.p008v4.media.session.PlaybackStateCompat;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.exception.DbException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.greenrobot.essentials.p143a.C3113a;

/* renamed from: io.objectbox.b */
/* loaded from: classes2.dex */
public class BoxStoreBuilder {

    /* renamed from: a */
    final byte[] f9455a;

    /* renamed from: b */
    File f9456b;
    @Nullable

    /* renamed from: c */
    Object f9457c;
    @Nullable

    /* renamed from: d */
    Object f9458d;

    /* renamed from: e */
    long f9459e;

    /* renamed from: f */
    int f9460f;

    /* renamed from: g */
    boolean f9461g;

    /* renamed from: h */
    int f9462h;

    /* renamed from: i */
    int f9463i;

    /* renamed from: j */
    TxCallback f9464j;

    /* renamed from: k */
    final List<EntityInfo> f9465k;

    /* renamed from: l */
    private File f9466l;

    /* renamed from: m */
    private String f9467m;

    /* renamed from: n */
    private boolean f9468n;

    /* renamed from: o */
    private Factory<InputStream> f9469o;

    /* renamed from: a */
    private static String m3376a(@Nullable String str) {
        return str != null ? str : "objectbox";
    }

    private BoxStoreBuilder() {
        this.f9459e = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        this.f9465k = new ArrayList();
        this.f9455a = null;
    }

    @Internal
    public BoxStoreBuilder(byte[] bArr) {
        this.f9459e = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        this.f9465k = new ArrayList();
        this.f9455a = bArr;
        if (bArr == null) {
            throw new IllegalArgumentException("Model may not be null");
        }
    }

    /* renamed from: a */
    public BoxStoreBuilder m3377a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Context may not be null");
        }
        this.f9457c = m3373c(obj);
        File m3374b = m3374b(obj);
        if (!m3374b.exists()) {
            m3374b.mkdir();
            if (!m3374b.exists()) {
                throw new RuntimeException("Could not init Android base dir at " + m3374b.getAbsolutePath());
            }
        }
        if (!m3374b.isDirectory()) {
            throw new RuntimeException("Android base dir is not a dir: " + m3374b.getAbsolutePath());
        }
        this.f9466l = m3374b;
        this.f9468n = true;
        return this;
    }

    /* renamed from: c */
    private Object m3373c(Object obj) {
        try {
            return obj.getClass().getMethod("getApplicationContext", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException("context must be a valid Android Context", e);
        }
    }

    /* renamed from: b */
    static File m3374b(Object obj) {
        return new File(m3372d(obj), "objectbox");
    }

    @Nonnull
    /* renamed from: d */
    private static File m3372d(Object obj) {
        try {
            Method method = obj.getClass().getMethod("getFilesDir", new Class[0]);
            File file = (File) method.invoke(obj, new Object[0]);
            if (file == null) {
                System.err.println("getFilesDir() returned null - retrying once...");
                file = (File) method.invoke(obj, new Object[0]);
            }
            if (file == null) {
                throw new IllegalStateException("Android files dir is null");
            }
            if (file.exists()) {
                return file;
            }
            throw new IllegalStateException("Android files dir does not exist");
        } catch (Exception e) {
            throw new RuntimeException("Could not init with given Android context (must be sub class of android.content.Context)", e);
        }
    }

    @Internal
    /* renamed from: a */
    public void m3379a(EntityInfo entityInfo) {
        this.f9465k.add(entityInfo);
    }

    /* renamed from: a */
    public BoxStore m3380a() {
        if (this.f9456b == null) {
            this.f9467m = m3376a(this.f9467m);
            this.f9456b = m3378a(this.f9466l, this.f9467m);
        }
        m3375b();
        return new BoxStore(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.InputStream] */
    /* renamed from: b */
    private void m3375b() {
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedOutputStream bufferedOutputStream3;
        if (this.f9469o == null) {
            return;
        }
        File file = new File(BoxStore.m3487a(this.f9456b), "data.mdb");
        if (file.exists()) {
            return;
        }
        Closeable closeable = null;
        try {
            inputStream = this.f9469o.m3346a();
            try {
                if (inputStream == null) {
                    throw new DbException("Factory did not provide a resource");
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Exception e) {
                    e = e;
                    bufferedOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    C3113a.m759a(bufferedInputStream, bufferedOutputStream3);
                    C3113a.m760a(bufferedOutputStream3);
                    C3113a.m760a(bufferedInputStream);
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream2 = bufferedOutputStream3;
                    closeable = bufferedInputStream;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        throw new DbException("Could not provision initial data file", e);
                    } catch (Throwable th2) {
                        th = th2;
                        BufferedOutputStream bufferedOutputStream4 = bufferedOutputStream;
                        inputStream = closeable;
                        closeable = bufferedOutputStream4;
                        C3113a.m760a(closeable);
                        C3113a.m760a(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = bufferedOutputStream3;
                    inputStream = bufferedInputStream;
                    C3113a.m760a(closeable);
                    C3113a.m760a(inputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedOutputStream = null;
                closeable = inputStream;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    /* renamed from: a */
    static File m3378a(@Nullable File file, @Nullable String str) {
        String m3376a = m3376a(str);
        if (file != null) {
            return new File(file, m3376a);
        }
        return new File(m3376a);
    }
}
