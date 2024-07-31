package com.bumptech.glide.p014a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bumptech.glide.a.a */
/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable {

    /* renamed from: b */
    private final File f362b;

    /* renamed from: c */
    private final File f363c;

    /* renamed from: d */
    private final File f364d;

    /* renamed from: e */
    private final File f365e;

    /* renamed from: f */
    private final int f366f;

    /* renamed from: g */
    private long f367g;

    /* renamed from: h */
    private final int f368h;

    /* renamed from: j */
    private Writer f370j;

    /* renamed from: l */
    private int f372l;

    /* renamed from: i */
    private long f369i = 0;

    /* renamed from: k */
    private final LinkedHashMap<String, C0601c> f371k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m */
    private long f373m = 0;

    /* renamed from: a */
    final ThreadPoolExecutor f361a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0599a());

    /* renamed from: n */
    private final Callable<Void> f374n = new Callable<Void>() { // from class: com.bumptech.glide.a.a.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.f370j == null) {
                    return null;
                }
                DiskLruCache.this.m12586g();
                if (DiskLruCache.this.m12590e()) {
                    DiskLruCache.this.m12593d();
                    DiskLruCache.this.f372l = 0;
                }
                return null;
            }
        }
    };

    private DiskLruCache(File file, int i, int i2, long j) {
        this.f362b = file;
        this.f366f = i;
        this.f363c = new File(file, "journal");
        this.f364d = new File(file, "journal.tmp");
        this.f365e = new File(file, "journal.bkp");
        this.f368h = i2;
        this.f367g = j;
    }

    /* renamed from: a */
    public static DiskLruCache m12603a(File file, int i, int i2, long j) throws IOException {
        if (j > 0) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("valueCount <= 0");
            }
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m12602a(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
            if (diskLruCache.f363c.exists()) {
                try {
                    diskLruCache.m12599b();
                    diskLruCache.m12596c();
                    return diskLruCache;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    diskLruCache.m12609a();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
            diskLruCache2.m12593d();
            return diskLruCache2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* renamed from: b */
    private void m12599b() throws IOException {
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.f363c), Util.f399a);
        try {
            String m12563a = strictLineReader.m12563a();
            String m12563a2 = strictLineReader.m12563a();
            String m12563a3 = strictLineReader.m12563a();
            String m12563a4 = strictLineReader.m12563a();
            String m12563a5 = strictLineReader.m12563a();
            if (!"libcore.io.DiskLruCache".equals(m12563a) || !"1".equals(m12563a2) || !Integer.toString(this.f366f).equals(m12563a3) || !Integer.toString(this.f368h).equals(m12563a4) || !"".equals(m12563a5)) {
                throw new IOException("unexpected journal header: [" + m12563a + ", " + m12563a2 + ", " + m12563a4 + ", " + m12563a5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m12591d(strictLineReader.m12563a());
                    i++;
                } catch (EOFException unused) {
                    this.f372l = i - this.f371k.size();
                    if (strictLineReader.m12561b()) {
                        m12593d();
                    } else {
                        this.f370j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f363c, true), Util.f399a));
                    }
                    Util.m12559a(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.m12559a(strictLineReader);
            throw th;
        }
    }

    /* renamed from: d */
    private void m12591d(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.f371k.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        C0601c c0601c = this.f371k.get(substring);
        if (c0601c == null) {
            c0601c = new C0601c(substring);
            this.f371k.put(substring, c0601c);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c0601c.f385f = true;
            c0601c.f386g = null;
            c0601c.m12571a(split);
        } else if (indexOf2 != -1 || indexOf != 5 || !str.startsWith("DIRTY")) {
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        } else {
            c0601c.f386g = new C0600b(c0601c);
        }
    }

    /* renamed from: c */
    private void m12596c() throws IOException {
        m12604a(this.f364d);
        Iterator<C0601c> it = this.f371k.values().iterator();
        while (it.hasNext()) {
            C0601c next = it.next();
            int i = 0;
            if (next.f386g == null) {
                while (i < this.f368h) {
                    this.f369i += next.f384e[i];
                    i++;
                }
            } else {
                next.f386g = null;
                while (i < this.f368h) {
                    m12604a(next.m12577a(i));
                    m12604a(next.m12570b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m12593d() throws IOException {
        if (this.f370j != null) {
            this.f370j.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f364d), Util.f399a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f366f));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f368h));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C0601c c0601c : this.f371k.values()) {
            if (c0601c.f386g != null) {
                bufferedWriter.write("DIRTY " + c0601c.f383d + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c0601c.f383d + c0601c.m12578a() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f363c.exists()) {
            m12602a(this.f363c, this.f365e, true);
        }
        m12602a(this.f364d, this.f363c, false);
        this.f365e.delete();
        this.f370j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f363c, true), Util.f399a));
    }

    /* renamed from: a */
    private static void m12604a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m12602a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m12604a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    public synchronized C0602d m12601a(String str) throws IOException {
        m12588f();
        C0601c c0601c = this.f371k.get(str);
        if (c0601c == null) {
            return null;
        }
        if (c0601c.f385f) {
            for (File file : c0601c.f380a) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.f372l++;
            this.f370j.append((CharSequence) "READ");
            this.f370j.append(' ');
            this.f370j.append((CharSequence) str);
            this.f370j.append('\n');
            if (m12590e()) {
                this.f361a.submit(this.f374n);
            }
            return new C0602d(str, c0601c.f387h, c0601c.f380a, c0601c.f384e);
        }
        return null;
    }

    /* renamed from: b */
    public C0600b m12597b(String str) throws IOException {
        return m12600a(str, -1L);
    }

    /* renamed from: a */
    private synchronized C0600b m12600a(String str, long j) throws IOException {
        m12588f();
        C0601c c0601c = this.f371k.get(str);
        if (j == -1 || (c0601c != null && c0601c.f387h == j)) {
            if (c0601c == null) {
                c0601c = new C0601c(str);
                this.f371k.put(str, c0601c);
            } else if (c0601c.f386g != null) {
                return null;
            }
            C0600b c0600b = new C0600b(c0601c);
            c0601c.f386g = c0600b;
            this.f370j.append((CharSequence) "DIRTY");
            this.f370j.append(' ');
            this.f370j.append((CharSequence) str);
            this.f370j.append('\n');
            this.f370j.flush();
            return c0600b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m12608a(C0600b c0600b, boolean z) throws IOException {
        C0601c c0601c = c0600b.f377b;
        if (c0601c.f386g != c0600b) {
            throw new IllegalStateException();
        }
        if (z && !c0601c.f385f) {
            for (int i = 0; i < this.f368h; i++) {
                if (!c0600b.f378c[i]) {
                    c0600b.m12581b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!c0601c.m12570b(i).exists()) {
                    c0600b.m12581b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f368h; i2++) {
            File m12570b = c0601c.m12570b(i2);
            if (z) {
                if (m12570b.exists()) {
                    File m12577a = c0601c.m12577a(i2);
                    m12570b.renameTo(m12577a);
                    long j = c0601c.f384e[i2];
                    long length = m12577a.length();
                    c0601c.f384e[i2] = length;
                    this.f369i = (this.f369i - j) + length;
                }
            } else {
                m12604a(m12570b);
            }
        }
        this.f372l++;
        c0601c.f386g = null;
        if (c0601c.f385f | z) {
            c0601c.f385f = true;
            this.f370j.append((CharSequence) "CLEAN");
            this.f370j.append(' ');
            this.f370j.append((CharSequence) c0601c.f383d);
            this.f370j.append((CharSequence) c0601c.m12578a());
            this.f370j.append('\n');
            if (z) {
                long j2 = this.f373m;
                this.f373m = 1 + j2;
                c0601c.f387h = j2;
            }
        } else {
            this.f371k.remove(c0601c.f383d);
            this.f370j.append((CharSequence) "REMOVE");
            this.f370j.append(' ');
            this.f370j.append((CharSequence) c0601c.f383d);
            this.f370j.append('\n');
        }
        this.f370j.flush();
        if (this.f369i > this.f367g || m12590e()) {
            this.f361a.submit(this.f374n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m12590e() {
        int i = this.f372l;
        return i >= 2000 && i >= this.f371k.size();
    }

    /* renamed from: c */
    public synchronized boolean m12594c(String str) throws IOException {
        m12588f();
        C0601c c0601c = this.f371k.get(str);
        if (c0601c != null && c0601c.f386g == null) {
            for (int i = 0; i < this.f368h; i++) {
                File m12577a = c0601c.m12577a(i);
                if (m12577a.exists() && !m12577a.delete()) {
                    throw new IOException("failed to delete " + m12577a);
                }
                this.f369i -= c0601c.f384e[i];
                c0601c.f384e[i] = 0;
            }
            this.f372l++;
            this.f370j.append((CharSequence) "REMOVE");
            this.f370j.append(' ');
            this.f370j.append((CharSequence) str);
            this.f370j.append('\n');
            this.f371k.remove(str);
            if (m12590e()) {
                this.f361a.submit(this.f374n);
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private void m12588f() {
        if (this.f370j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f370j == null) {
            return;
        }
        Iterator it = new ArrayList(this.f371k.values()).iterator();
        while (it.hasNext()) {
            C0601c c0601c = (C0601c) it.next();
            if (c0601c.f386g != null) {
                c0601c.f386g.m12581b();
            }
        }
        m12586g();
        this.f370j.close();
        this.f370j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12586g() throws IOException {
        while (this.f369i > this.f367g) {
            m12594c(this.f371k.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: a */
    public void m12609a() throws IOException {
        close();
        Util.m12558a(this.f362b);
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.a.a$d */
    /* loaded from: classes.dex */
    public final class C0602d {

        /* renamed from: b */
        private final String f389b;

        /* renamed from: c */
        private final long f390c;

        /* renamed from: d */
        private final long[] f391d;

        /* renamed from: e */
        private final File[] f392e;

        private C0602d(String str, long j, File[] fileArr, long[] jArr) {
            this.f389b = str;
            this.f390c = j;
            this.f392e = fileArr;
            this.f391d = jArr;
        }

        /* renamed from: a */
        public File m12564a(int i) {
            return this.f392e[i];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.a.a$b */
    /* loaded from: classes.dex */
    public final class C0600b {

        /* renamed from: b */
        private final C0601c f377b;

        /* renamed from: c */
        private final boolean[] f378c;

        /* renamed from: d */
        private boolean f379d;

        private C0600b(C0601c c0601c) {
            this.f377b = c0601c;
            this.f378c = c0601c.f385f ? null : new boolean[DiskLruCache.this.f368h];
        }

        /* renamed from: a */
        public File m12583a(int i) throws IOException {
            File m12570b;
            synchronized (DiskLruCache.this) {
                if (this.f377b.f386g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f377b.f385f) {
                    this.f378c[i] = true;
                }
                m12570b = this.f377b.m12570b(i);
                if (!DiskLruCache.this.f362b.exists()) {
                    DiskLruCache.this.f362b.mkdirs();
                }
            }
            return m12570b;
        }

        /* renamed from: a */
        public void m12584a() throws IOException {
            DiskLruCache.this.m12608a(this, true);
            this.f379d = true;
        }

        /* renamed from: b */
        public void m12581b() throws IOException {
            DiskLruCache.this.m12608a(this, false);
        }

        /* renamed from: c */
        public void m12579c() {
            if (this.f379d) {
                return;
            }
            try {
                m12581b();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.a.a$c */
    /* loaded from: classes.dex */
    public final class C0601c {

        /* renamed from: a */
        File[] f380a;

        /* renamed from: b */
        File[] f381b;

        /* renamed from: d */
        private final String f383d;

        /* renamed from: e */
        private final long[] f384e;

        /* renamed from: f */
        private boolean f385f;

        /* renamed from: g */
        private C0600b f386g;

        /* renamed from: h */
        private long f387h;

        private C0601c(String str) {
            this.f383d = str;
            this.f384e = new long[DiskLruCache.this.f368h];
            this.f380a = new File[DiskLruCache.this.f368h];
            this.f381b = new File[DiskLruCache.this.f368h];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.this.f368h; i++) {
                sb.append(i);
                this.f380a[i] = new File(DiskLruCache.this.f362b, sb.toString());
                sb.append(".tmp");
                this.f381b[i] = new File(DiskLruCache.this.f362b, sb.toString());
                sb.setLength(length);
            }
        }

        /* renamed from: a */
        public String m12578a() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f384e) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m12571a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f368h) {
                throw m12568b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f384e[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw m12568b(strArr);
                }
            }
        }

        /* renamed from: b */
        private IOException m12568b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File m12577a(int i) {
            return this.f380a[i];
        }

        /* renamed from: b */
        public File m12570b(int i) {
            return this.f381b[i];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.a.a$a */
    /* loaded from: classes.dex */
    private static final class ThreadFactoryC0599a implements ThreadFactory {
        private ThreadFactoryC0599a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }
}
