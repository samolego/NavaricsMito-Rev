package io.objectbox.internal;

import io.objectbox.BoxStore;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLConnection;
import org.greenrobot.essentials.p143a.C3113a;

/* renamed from: io.objectbox.internal.c */
/* loaded from: classes2.dex */
public class NativeLibraryLoader {
    /* renamed from: a */
    public static void m3316a() {
    }

    static {
        String str = "objectbox-jni";
        String str2 = "objectbox-jni.so";
        boolean contains = System.getProperty("java.vendor").contains("Android");
        boolean z = false;
        if (!contains) {
            String lowerCase = System.getProperty("os.name").toLowerCase();
            String str3 = "32".equals(System.getProperty("sun.arch.data.model")) ? "-x86" : "-x64";
            if (lowerCase.contains("windows")) {
                str = "objectbox-jni-windows" + str3;
                str2 = str + ".dll";
                m3315a(str2);
            } else if (lowerCase.contains("linux")) {
                z = true;
                str = "objectbox-jni-linux" + str3;
                str2 = "lib" + str + ".so";
                m3315a(str2);
            } else if (lowerCase.contains("mac")) {
                str = "objectbox-jni-macos" + str3;
                str2 = "lib" + str + ".dylib";
                m3315a(str2);
            }
        }
        File file = new File(str2);
        if (file.exists()) {
            System.load(file.getAbsolutePath());
            return;
        }
        if (!contains) {
            System.err.println("File not available: " + file.getAbsolutePath());
        }
        if (contains) {
            try {
                if (m3314b(str)) {
                    return;
                }
            } catch (UnsatisfiedLinkError e) {
                if (!contains && z) {
                    if (m3314b("objectbox-jni")) {
                        return;
                    }
                    System.loadLibrary("objectbox-jni");
                    return;
                }
                throw e;
            }
        }
        System.loadLibrary(str);
    }

    /* renamed from: a */
    private static void m3315a(String str) {
        String str2 = "/native/" + str;
        URL resource = NativeLibraryLoader.class.getResource(str2);
        if (resource == null) {
            System.err.println("Not available in classpath: " + str2);
            return;
        }
        File file = new File(str);
        try {
            URLConnection openConnection = resource.openConnection();
            int contentLength = openConnection.getContentLength();
            long lastModified = openConnection.getLastModified();
            if (file.exists() && file.length() == contentLength && file.lastModified() == lastModified) {
                return;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            C3113a.m759a(bufferedInputStream, bufferedOutputStream);
            C3113a.m760a(bufferedOutputStream);
            C3113a.m760a(bufferedInputStream);
            if (lastModified > 0) {
                file.setLastModified(lastModified);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private static boolean m3314b(String str) {
        if (BoxStore.f9404a == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.content.Context");
            if (BoxStore.f9405b == null) {
                Class.forName("com.getkeepsafe.relinker.ReLinker").getMethod("loadLibrary", cls, String.class, String.class).invoke(null, BoxStore.f9404a, str, "2.3.3");
            } else {
                BoxStore.f9405b.getClass().getMethod("loadLibrary", cls, String.class, String.class).invoke(BoxStore.f9405b, BoxStore.f9404a, str, "2.3.3");
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (IllegalAccessException unused2) {
            return false;
        } catch (NoSuchMethodException unused3) {
            return false;
        } catch (InvocationTargetException unused4) {
            return false;
        }
    }
}
