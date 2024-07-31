package com.navatics.p057cv;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;

/* renamed from: com.navatics.cv.NavaticsCV */
/* loaded from: classes.dex */
public class NavaticsCV {

    /* renamed from: a */
    private static boolean f5790a;

    /* renamed from: b */
    private static Map<String, NavaticsFilter> f5791b = new HashMap();

    /* renamed from: c */
    private static List<NavaticsFilter> f5792c = new ArrayList();

    private static native void _create_filters_from_native(List<NavaticsFilter> list);

    private static native void _native_init(String str);

    private static native long _native_try_retrieve_mat_from_opengl();

    /* renamed from: a */
    public static synchronized void m6861a(Context context) {
        synchronized (NavaticsCV.class) {
            if (!f5790a) {
                System.loadLibrary("nvtsfilter");
                System.loadLibrary("nvts_cv_jni");
                System.loadLibrary("fftw3");
                if (OpenCVLoader.m303a()) {
                    Log.i("NavaticsCV", "OpenCV library found inside package.");
                } else {
                    Log.i("NavaticsCV", "OpenCV library not found inside package.");
                    Process.killProcess(Process.myPid());
                }
                String path = context.getDir("libs", 0).getPath();
                String[] strArr = Build.SUPPORTED_ABIS;
                StringBuilder sb = new StringBuilder("Supported ABIs : \n");
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = strArr[i];
                    sb.append("    ");
                    sb.append(str);
                    sb.append("\n");
                    if (str.equals("arm64-v8a")) {
                        path = context.getDir("libs-arm64", 0).getPath();
                        break;
                    }
                    i++;
                }
                Log.i("NavaticsCV", sb.toString());
                _native_init(path);
                Log.i("NavaticsCV", "java load filter start");
                _create_filters_from_native(f5792c);
                for (NavaticsFilter navaticsFilter : f5792c) {
                    Log.i("NavaticsCV", "java find filter " + navaticsFilter.getName());
                    f5791b.put(navaticsFilter.getName(), navaticsFilter);
                }
                Log.i("NavaticsCV", "java load filter end, size " + f5792c.size());
                f5790a = true;
            }
        }
    }

    /* renamed from: a */
    public static Mat m6862a() {
        long _native_try_retrieve_mat_from_opengl = _native_try_retrieve_mat_from_opengl();
        if (_native_try_retrieve_mat_from_opengl == -1) {
            return null;
        }
        return new Mat(_native_try_retrieve_mat_from_opengl);
    }

    /* renamed from: b */
    public static List<NavaticsFilter> m6860b() {
        return f5792c;
    }
}
