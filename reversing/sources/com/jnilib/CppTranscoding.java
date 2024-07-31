package com.jnilib;

/* loaded from: classes.dex */
public class CppTranscoding {
    public static native int CreatH264File(String str, int i, int i2, byte[] bArr, byte[] bArr2);

    public static native int H264FileTst(String str, String str2);

    static {
        System.loadLibrary("transcoding");
    }
}
