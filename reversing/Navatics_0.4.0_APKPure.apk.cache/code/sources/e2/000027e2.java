package org.opencv.android;

import android.util.Log;
import java.util.StringTokenizer;
import org.opencv.core.Core;

/* loaded from: classes2.dex */
class StaticHelper {
    private static native String getLibraryList();

    /* renamed from: a */
    public static boolean m12464a(boolean z) {
        String str = "";
        if (z) {
            m12463a("cudart");
            m12463a("nppc");
            m12463a("nppi");
            m12463a("npps");
            m12463a("cufft");
            m12463a("cublas");
        }
        Log.d("OpenCV/StaticHelper", "Trying to get library list");
        try {
            System.loadLibrary("opencv_info");
            str = getLibraryList();
        } catch (UnsatisfiedLinkError unused) {
            Log.e("OpenCV/StaticHelper", "OpenCV error: Cannot load info library for OpenCV");
        }
        Log.d("OpenCV/StaticHelper", "Library list: \"" + str + "\"");
        Log.d("OpenCV/StaticHelper", "First attempt to load libs");
        boolean m12465b = m12465b(str);
        if (m12465b) {
            Log.d("OpenCV/StaticHelper", "First attempt to load libs is OK");
            for (String str2 : Core.m12509a().split(System.getProperty("line.separator"))) {
                Log.i("OpenCV/StaticHelper", str2);
            }
            return true;
        }
        Log.d("OpenCV/StaticHelper", "First attempt to load libs fails");
        return false;
    }

    /* renamed from: a */
    private static boolean m12463a(String str) {
        Log.d("OpenCV/StaticHelper", "Trying to load library " + str);
        try {
            System.loadLibrary(str);
            Log.d("OpenCV/StaticHelper", "Library " + str + " loaded");
            return true;
        } catch (UnsatisfiedLinkError e) {
            Log.d("OpenCV/StaticHelper", "Cannot load library \"" + str + "\"");
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m12465b(String str) {
        Log.d("OpenCV/StaticHelper", "Trying to init OpenCV libs");
        boolean z = true;
        if (str != null && str.length() != 0) {
            Log.d("OpenCV/StaticHelper", "Trying to load libs by dependency list");
            StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
            while (stringTokenizer.hasMoreTokens()) {
                z &= m12463a(stringTokenizer.nextToken());
            }
            return z;
        }
        return true & m12463a("opencv_java3");
    }
}