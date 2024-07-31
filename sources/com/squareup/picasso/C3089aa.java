package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.java */
/* renamed from: com.squareup.picasso.aa */
/* loaded from: classes2.dex */
public final class C2344aa {

    /* renamed from: a */
    static final StringBuilder f6895a = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m5765a(Bitmap bitmap) {
        int rowBytes;
        if (Build.VERSION.SDK_INT >= 12) {
            rowBytes = C2347b.m5745a(bitmap);
        } else {
            rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (rowBytes >= 0) {
            return rowBytes;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static <T> T m5757a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5770a() {
        if (!m5753b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    /* renamed from: b */
    static boolean m5753b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m5763a(BitmapHunter bitmapHunter) {
        return m5762a(bitmapHunter, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m5762a(BitmapHunter bitmapHunter, String str) {
        StringBuilder sb = new StringBuilder(str);
        Action m5725i = bitmapHunter.m5725i();
        if (m5725i != null) {
            sb.append(m5725i.f6883b.m5670a());
        }
        List<Action> m5723k = bitmapHunter.m5723k();
        if (m5723k != null) {
            int size = m5723k.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || m5725i != null) {
                    sb.append(", ");
                }
                sb.append(m5723k.get(i).f6883b.m5670a());
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5755a(String str, String str2, String str3) {
        m5754a(str, str2, str3, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5754a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m5761a(C2365q c2365q) {
        String m5760a = m5760a(c2365q, f6895a);
        f6895a.setLength(0);
        return m5760a;
    }

    /* renamed from: a */
    static String m5760a(C2365q c2365q, StringBuilder sb) {
        if (c2365q.f6982f != null) {
            sb.ensureCapacity(c2365q.f6982f.length() + 50);
            sb.append(c2365q.f6982f);
        } else if (c2365q.f6980d != null) {
            String uri = c2365q.f6980d.toString();
            sb.ensureCapacity(uri.length() + 50);
            sb.append(uri);
        } else {
            sb.ensureCapacity(50);
            sb.append(c2365q.f6981e);
        }
        sb.append('\n');
        if (c2365q.f6989m != 0.0f) {
            sb.append("rotation:");
            sb.append(c2365q.f6989m);
            if (c2365q.f6992p) {
                sb.append('@');
                sb.append(c2365q.f6990n);
                sb.append('x');
                sb.append(c2365q.f6991o);
            }
            sb.append('\n');
        }
        if (c2365q.m5667d()) {
            sb.append("resize:");
            sb.append(c2365q.f6984h);
            sb.append('x');
            sb.append(c2365q.f6985i);
            sb.append('\n');
        }
        if (c2365q.f6986j) {
            sb.append("centerCrop");
            sb.append('\n');
        } else if (c2365q.f6987k) {
            sb.append("centerInside");
            sb.append('\n');
        }
        if (c2365q.f6983g != null) {
            int size = c2365q.f6983g.size();
            for (int i = 0; i < size; i++) {
                sb.append(c2365q.f6983g.get(i).m5617a());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5758a(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m5756a(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(" ", 2);
        if ("CACHE".equals(split[0])) {
            return true;
        }
        if (split.length == 1) {
            return false;
        }
        try {
            if ("CONDITIONAL_CACHE".equals(split[0])) {
                return Integer.parseInt(split[1]) == 304;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Downloader m5769a(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return C2348c.m5744a(context);
        } catch (ClassNotFoundException unused) {
            return new UrlConnectionDownloader(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static File m5752b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static long m5759a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (statFs.getBlockCount() * statFs.getBlockSize()) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800L), 5242880L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static int m5749c(Context context) {
        ActivityManager activityManager = (ActivityManager) m5767a(context, "activity");
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z && Build.VERSION.SDK_INT >= 11) {
            memoryClass = C2346a.m5746a(activityManager);
        }
        return (memoryClass * 1048576) / 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static boolean m5747d(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static <T> T m5767a(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m5751b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static byte[] m5750b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static boolean m5748c(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m5766a(Resources resources, C2365q c2365q) throws FileNotFoundException {
        if (c2365q.f6981e != 0 || c2365q.f6980d == null) {
            return c2365q.f6981e;
        }
        String authority = c2365q.f6980d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c2365q.f6980d);
        }
        List<String> pathSegments = c2365q.f6980d.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + c2365q.f6980d);
        } else if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + c2365q.f6980d);
            }
        } else if (pathSegments.size() == 2) {
            return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        } else {
            throw new FileNotFoundException("More than two path segments: " + c2365q.f6980d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Resources m5768a(Context context, C2365q c2365q) throws FileNotFoundException {
        if (c2365q.f6981e != 0 || c2365q.f6980d == null) {
            return context.getResources();
        }
        String authority = c2365q.f6980d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c2365q.f6980d);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + c2365q.f6980d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5764a(Looper looper) {
        Handler handler = new Handler(looper) { // from class: com.squareup.picasso.aa.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000L);
            }
        };
        handler.sendMessageDelayed(handler.obtainMessage(), 1000L);
    }

    /* compiled from: Utils.java */
    @TargetApi(11)
    /* renamed from: com.squareup.picasso.aa$a */
    /* loaded from: classes2.dex */
    private static class C2346a {
        /* renamed from: a */
        static int m5746a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: com.squareup.picasso.aa$e */
    /* loaded from: classes2.dex */
    static class ThreadFactoryC2350e implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C2349d(runnable);
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: com.squareup.picasso.aa$d */
    /* loaded from: classes2.dex */
    private static class C2349d extends Thread {
        public C2349d(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* compiled from: Utils.java */
    @TargetApi(12)
    /* renamed from: com.squareup.picasso.aa$b */
    /* loaded from: classes2.dex */
    private static class C2347b {
        /* renamed from: a */
        static int m5745a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: com.squareup.picasso.aa$c */
    /* loaded from: classes2.dex */
    private static class C2348c {
        /* renamed from: a */
        static Downloader m5744a(Context context) {
            return new OkHttpDownloader(context);
        }
    }
}
