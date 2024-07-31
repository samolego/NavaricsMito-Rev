package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.facebook.internal.m */
/* loaded from: classes.dex */
public final class FileLruCache {

    /* renamed from: a */
    static final String f1989a = "m";

    /* renamed from: b */
    private static final AtomicLong f1990b = new AtomicLong();

    /* renamed from: c */
    private final String f1991c;

    /* renamed from: d */
    private final C0965c f1992d;

    /* renamed from: e */
    private final File f1993e;

    /* renamed from: f */
    private boolean f1994f;

    /* renamed from: g */
    private boolean f1995g;

    /* renamed from: i */
    private AtomicLong f1997i = new AtomicLong(0);

    /* renamed from: h */
    private final Object f1996h = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.java */
    /* renamed from: com.facebook.internal.m$e */
    /* loaded from: classes.dex */
    public interface InterfaceC0967e {
        /* renamed from: a */
        void mo10651a();
    }

    public FileLruCache(String str, C0965c c0965c) {
        this.f1991c = str;
        this.f1992d = c0965c;
        this.f1993e = new File(FacebookSdk.m10858s(), str);
        if (this.f1993e.mkdirs() || this.f1993e.isDirectory()) {
            C0961a.m10659a(this.f1993e);
        }
    }

    /* renamed from: a */
    public InputStream m10669a(String str) throws IOException {
        return m10667a(str, (String) null);
    }

    /* renamed from: a */
    public InputStream m10667a(String str, String str2) throws IOException {
        File file = new File(this.f1993e, Utility.m10506b(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject m10650a = C0968f.m10650a(bufferedInputStream);
                if (m10650a == null) {
                    return null;
                }
                String optString = m10650a.optString("key");
                if (optString != null && optString.equals(str)) {
                    String optString2 = m10650a.optString("tag", null);
                    if ((str2 != null || optString2 == null) && (str2 == null || str2.equals(optString2))) {
                        long time = new Date().getTime();
                        LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                        String str3 = f1989a;
                        Logger.m10634a(loggingBehavior, str3, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                        file.setLastModified(time);
                        return bufferedInputStream;
                    }
                    return null;
                }
                return null;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public OutputStream m10664b(String str) throws IOException {
        return m10663b(str, null);
    }

    /* renamed from: b */
    public OutputStream m10663b(final String str, String str2) throws IOException {
        final File m10657b = C0961a.m10657b(this.f1993e);
        m10657b.delete();
        if (!m10657b.createNewFile()) {
            throw new IOException("Could not create file at " + m10657b.getAbsolutePath());
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(m10657b);
            final long currentTimeMillis = System.currentTimeMillis();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new C0964b(fileOutputStream, new InterfaceC0967e() { // from class: com.facebook.internal.m.1
                @Override // com.facebook.internal.FileLruCache.InterfaceC0967e
                /* renamed from: a */
                public void mo10651a() {
                    if (currentTimeMillis >= FileLruCache.this.f1997i.get()) {
                        FileLruCache.this.m10668a(str, m10657b);
                    } else {
                        m10657b.delete();
                    }
                }
            }), 8192);
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!Utility.m10530a(str2)) {
                        jSONObject.put("tag", str2);
                    }
                    C0968f.m10649a(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String str3 = f1989a;
                    Logger.m10636a(loggingBehavior, 5, str3, "Error creating JSON header for cache file: " + e);
                    throw new IOException(e.getMessage());
                }
            } catch (Throwable th) {
                bufferedOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e2) {
            LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
            String str4 = f1989a;
            Logger.m10636a(loggingBehavior2, 5, str4, "Error creating buffer output stream: " + e2);
            throw new IOException(e2.getMessage());
        }
    }

    /* renamed from: a */
    public void m10672a() {
        final File[] listFiles = this.f1993e.listFiles(C0961a.m10660a());
        this.f1997i.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.internal.m.2
                @Override // java.lang.Runnable
                public void run() {
                    for (File file : listFiles) {
                        file.delete();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10668a(String str, File file) {
        if (!file.renameTo(new File(this.f1993e, Utility.m10506b(str)))) {
            file.delete();
        }
        m10662c();
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.f1991c + " file:" + this.f1993e.getName() + "}";
    }

    /* renamed from: c */
    private void m10662c() {
        synchronized (this.f1996h) {
            if (!this.f1994f) {
                this.f1994f = true;
                FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.internal.m.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FileLruCache.this.m10661d();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10661d() {
        long j;
        C0966d c0966d;
        synchronized (this.f1996h) {
            this.f1994f = false;
            this.f1995g = true;
        }
        try {
            Logger.m10634a(LoggingBehavior.CACHE, f1989a, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            File[] listFiles = this.f1993e.listFiles(C0961a.m10660a());
            long j2 = 0;
            if (listFiles != null) {
                long j3 = 0;
                j = 0;
                for (File file : listFiles) {
                    priorityQueue.add(new C0966d(file));
                    Logger.m10634a(LoggingBehavior.CACHE, f1989a, "  trim considering time=" + Long.valueOf(c0966d.m10652b()) + " name=" + c0966d.m10654a().getName());
                    j3 += file.length();
                    j++;
                }
                j2 = j3;
            } else {
                j = 0;
            }
            while (true) {
                if (j2 > this.f1992d.m10656a() || j > this.f1992d.m10655b()) {
                    File m10654a = ((C0966d) priorityQueue.remove()).m10654a();
                    Logger.m10634a(LoggingBehavior.CACHE, f1989a, "  trim removing " + m10654a.getName());
                    j2 -= m10654a.length();
                    j--;
                    m10654a.delete();
                } else {
                    synchronized (this.f1996h) {
                        this.f1995g = false;
                        this.f1996h.notifyAll();
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            synchronized (this.f1996h) {
                this.f1995g = false;
                this.f1996h.notifyAll();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.java */
    /* renamed from: com.facebook.internal.m$a */
    /* loaded from: classes.dex */
    public static class C0961a {

        /* renamed from: a */
        private static final FilenameFilter f2005a = new FilenameFilter() { // from class: com.facebook.internal.m.a.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return !str.startsWith("buffer");
            }
        };

        /* renamed from: b */
        private static final FilenameFilter f2006b = new FilenameFilter() { // from class: com.facebook.internal.m.a.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("buffer");
            }
        };

        /* renamed from: a */
        static void m10659a(File file) {
            File[] listFiles = file.listFiles(m10658b());
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }

        /* renamed from: a */
        static FilenameFilter m10660a() {
            return f2005a;
        }

        /* renamed from: b */
        static FilenameFilter m10658b() {
            return f2006b;
        }

        /* renamed from: b */
        static File m10657b(File file) {
            return new File(file, "buffer" + Long.valueOf(FileLruCache.f1990b.incrementAndGet()).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.java */
    /* renamed from: com.facebook.internal.m$f */
    /* loaded from: classes.dex */
    public static final class C0968f {
        /* renamed from: a */
        static void m10649a(OutputStream outputStream, JSONObject jSONObject) throws IOException {
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }

        /* renamed from: a */
        static JSONObject m10650a(InputStream inputStream) throws IOException {
            if (inputStream.read() != 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int read = inputStream.read();
                if (read == -1) {
                    Logger.m10634a(LoggingBehavior.CACHE, FileLruCache.f1989a, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < bArr.length) {
                int read2 = inputStream.read(bArr, i, bArr.length - i);
                if (read2 < 1) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String str = FileLruCache.f1989a;
                    Logger.m10634a(loggingBehavior, str, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + bArr.length);
                    return null;
                }
                i += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr)).nextValue();
                if (!(nextValue instanceof JSONObject)) {
                    LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                    String str2 = FileLruCache.f1989a;
                    Logger.m10634a(loggingBehavior2, str2, "readHeader: expected JSONObject, got " + nextValue.getClass().getCanonicalName());
                    return null;
                }
                return (JSONObject) nextValue;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.java */
    /* renamed from: com.facebook.internal.m$b */
    /* loaded from: classes.dex */
    public static class C0964b extends OutputStream {

        /* renamed from: a */
        final OutputStream f2007a;

        /* renamed from: b */
        final InterfaceC0967e f2008b;

        C0964b(OutputStream outputStream, InterfaceC0967e interfaceC0967e) {
            this.f2007a = outputStream;
            this.f2008b = interfaceC0967e;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.f2007a.close();
            } finally {
                this.f2008b.mo10651a();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f2007a.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f2007a.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f2007a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f2007a.write(i);
        }
    }

    /* compiled from: FileLruCache.java */
    /* renamed from: com.facebook.internal.m$c */
    /* loaded from: classes.dex */
    public static final class C0965c {

        /* renamed from: b */
        private int f2010b = 1024;

        /* renamed from: a */
        private int f2009a = 1048576;

        /* renamed from: a */
        int m10656a() {
            return this.f2009a;
        }

        /* renamed from: b */
        int m10655b() {
            return this.f2010b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.java */
    /* renamed from: com.facebook.internal.m$d */
    /* loaded from: classes.dex */
    public static final class C0966d implements Comparable<C0966d> {

        /* renamed from: a */
        private final File f2011a;

        /* renamed from: b */
        private final long f2012b;

        C0966d(File file) {
            this.f2011a = file;
            this.f2012b = file.lastModified();
        }

        /* renamed from: a */
        File m10654a() {
            return this.f2011a;
        }

        /* renamed from: b */
        long m10652b() {
            return this.f2012b;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0966d c0966d) {
            if (m10652b() < c0966d.m10652b()) {
                return -1;
            }
            if (m10652b() > c0966d.m10652b()) {
                return 1;
            }
            return m10654a().compareTo(c0966d.m10654a());
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0966d) && compareTo((C0966d) obj) == 0;
        }

        public int hashCode() {
            return ((1073 + this.f2011a.hashCode()) * 37) + ((int) (this.f2012b % 2147483647L));
        }
    }
}
